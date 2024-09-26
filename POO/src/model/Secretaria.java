package model;

import java.util.ArrayList;
import java.util.Date;

public class Secretaria extends Usuario {
    private String area;
    private String turno;

    public Secretaria(String nombre, String correo, String turno) {
        super(nombre, correo);
        this.turno = turno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString() + "model.Secretaria{" + "area: " + area + ", turno: " + turno + '}';
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy una secretaria");
    }

    ArrayList<Secretaria.TutoriasDisponibles> tutriasDisponibles = new ArrayList<>();

    public void addCursoDisponible(String fecha, String hora) {
        tutriasDisponibles.add(new Secretaria.TutoriasDisponibles(fecha, hora));
    }

    public ArrayList<Secretaria.TutoriasDisponibles> getTutoriaDisponibles() {
        return tutriasDisponibles;
    }

    public static class TutoriasDisponibles extends CitaTutoria {
        TutoriasDisponibles(String fecha, String hora) {
            super(fecha, hora);
        }
    }
}