package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CitaMaestro implements IAgendable {
    private int id;
    private Maestro maestro;
    private Estudiante estudiante;
    private Date fecha;
    private String hora;
    SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

    public CitaMaestro(Maestro maestro, Estudiante estudiante, Date fecha, String hora) {
        this.maestro = maestro;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getFechaString(){
        return formato.format(fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public void agendar(Date fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return maestro.getNombre() + " " + getFechaString() + " " + hora;
    }
}