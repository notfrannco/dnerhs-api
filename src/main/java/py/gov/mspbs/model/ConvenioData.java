package py.gov.mspbs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import py.gov.mspbs.entity.InstitucionFormadora;

import java.util.Date;

public class ConvenioData {
    private String institucionFormadora;
    private String sede;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaInicioVigencia;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaFinVigencia;
    private String categoria;
    private String carreras;

    public String getInstitucionFormadora() {
        return institucionFormadora;
    }

    public void setInstitucionFormadora(String institucionFormadora) {
        this.institucionFormadora = institucionFormadora;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCarreras() {
        return carreras;
    }

    public void setCarreras(String carreras) {
        this.carreras = carreras;
    }
}
