package py.gov.mspbs.model;

import py.gov.mspbs.entity.Practica;
import py.gov.mspbs.entity.PracticaDetalle;

public class PracticaEstudianteDTO {
    private Practica practica;
    private PracticaDetalle practicaDetalle;

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }

    public PracticaDetalle getPracticaDetalle() {
        return practicaDetalle;
    }

    public void setPracticaDetalle(PracticaDetalle practicaDetalle) {
        this.practicaDetalle = practicaDetalle;
    }

}
