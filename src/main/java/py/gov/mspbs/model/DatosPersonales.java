package py.gov.mspbs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import py.gov.mspbs.entity.Genero;

import java.util.Date;

public class DatosPersonales {

    private Integer numeroCedula;
    private String nombres;
    private String apellidos;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaNacimiento;

    private Genero genero;

    public Integer getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(Integer numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
