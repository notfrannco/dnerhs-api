package py.gov.mspbs.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import py.gov.mspbs.entity.Archivo;
import py.gov.mspbs.exception.ControllerException;
import py.gov.mspbs.service.ArchivoService;
import py.gov.mspbs.storage.StorageService;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;


@Controller
public class FileController {

    @Autowired
    ArchivoService archivoService;

    private StorageService storageService;

    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @ApiOperation(value = "Descargar un archivo dado su id", notes = "Descarga el archivo correspondiente al id dado")
    @GetMapping("/file/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws IOException {

        Resource resource = storageService.loadAsResource(filename);

        Optional<Archivo> archivo = archivoService.findById(filename);
        String originalFilename = archivo.get().getNombreOriginal();

        File file = resource.getFile();
        Tika tika = new Tika();
        String mimeType = tika.detect(file);

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + originalFilename + "\"")
                .body(resource);
    }

    @ApiOperation(value = "Subir un archivo y obtener id", notes = "Sube un archivo y devuelve el id asignado")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Archivo subido") })
    @PostMapping("/file")
    @ResponseBody
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException, NoSuchAlgorithmException {

		if (!MediaType.valueOf(file.getContentType()).equals(MediaType.APPLICATION_PDF)
				&& !MediaType.valueOf(file.getContentType()).equals(MediaType.IMAGE_JPEG)
				&& !MediaType.valueOf(file.getContentType()).equals(MediaType.IMAGE_PNG)) {
			throw new ControllerException("EL formato de archivo no es válido");
		}
    	
        //Use MD5 algorithm
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        String checksum = getFileChecksum(md5Digest, file);
        
        String id = storageService.store(file, checksum);

        Archivo archivo = new Archivo();
        archivo.setId(id);
        archivo.setNombreOriginal(file.getOriginalFilename());
        archivoService.save(archivo);

        return new FileResponse(id, file.getContentType(), file.getSize());
    }


    private static String getFileChecksum(MessageDigest digest, MultipartFile file) throws IOException
    {
        InputStream inputStream =  new BufferedInputStream(file.getInputStream());

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = inputStream.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        //close the stream; We don't need it now.
        inputStream.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }
}
