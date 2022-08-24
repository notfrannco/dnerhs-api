package py.gov.mspbs.controller;

import io.swagger.annotations.ApiParam;
import javassist.NotFoundException;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import py.gov.mspbs.model.DatosPersonales;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import py.gov.mspbs.service.GeneroService;


@RestController
@RequestMapping(value="/datos-personales", produces = MediaType.APPLICATION_JSON_VALUE)
public class ObtencionDatosPersonalesController {

    @Autowired
    GeneroService generoService;

    @Value("${spring.obtencion.url}")
    private String urlObtencion;

    @Value("${spring.obtencion.credenciales}")
    private String credenciales;



    @GetMapping("/{numeroCedula}")
    public ResponseEntity<DatosPersonales> getDatosPersonales(
            @ApiParam("Número de Cédula") @PathVariable("numeroCedula") Integer numeroCedula) {

        DatosPersonales datosPersonales = new DatosPersonales();



        try {
            String url = urlObtencion + numeroCedula;
            String authStr = credenciales;
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            HttpEntity request = new HttpEntity(headers);

            ResponseEntity<Map> response = getRestTemplate().exchange(url, HttpMethod.GET, request, Map.class);

            if (response.getBody() == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            datosPersonales.setNumeroCedula(numeroCedula);
            datosPersonales.setApellidos(response.getBody().get("apellidos").toString());
            datosPersonales.setNombres(response.getBody().get("nombres").toString());
            datosPersonales.setFechaNacimiento( new SimpleDateFormat("yyyy-MM-dd").parse(response.getBody().get("fecha_nacimiento").toString()));
            datosPersonales.setGenero(generoService.findById(Long.valueOf(response.getBody().get("codigo_genero").toString())).get());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<DatosPersonales>(datosPersonales, HttpStatus.OK);
    }


    public RestTemplate getRestTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (x509Certificates, s) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }


}
