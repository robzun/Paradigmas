package model;

import ui.UIMaestro;

import java.util.ArrayList;
import java.util.Date;

import static ui.UIMenu.maestroLogeado;

public class Maestro extends Usuario{
    //Atributos
    private int numPersonal;
    private String especialidad;

    public Maestro(String nombre, String correo, int numPersonal){
        super(nombre, correo);
        this.numPersonal = numPersonal;
    }

    public int getNumPersonal() {
        return numPersonal;
    }
    public void setNumPersonal(int numPersonal) {
        this.numPersonal = numPersonal;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    ArrayList<TutoriasDisponibles> tutriasDisponibles = new ArrayList<>();
    public void addTutoriaDisponible(String fecha, String hora) {
        tutriasDisponibles.add(new TutoriasDisponibles(fecha, hora));
        UIMaestro.consultarMaestroConTutoria(this);
    }

    public ArrayList<TutoriasDisponibles> getTutoriaDisponibles(){
        return tutriasDisponibles;
    }

    public static class TutoriasDisponibles extends CitaTutoria{
        TutoriasDisponibles(String fecha, String hora) {
            super(fecha, hora);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de personal = " + numPersonal + "\n Cursos disponibles: " + tutriasDisponibles;
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy un maestro");
    }
}