package ui;

import java.util.Date;
import java.util.Scanner;
import static ui.UIMenu.*;
import model.Maestro;
import java.util.ArrayList;

public class UIMaestro {
    public static ArrayList<Maestro> maestrosConTutorias = new ArrayList<>();


    public static void maestroMenu(){
        int respuesta;
        Scanner sc = new Scanner(System.in);
        System.out.println("..:: Maestro ::..");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Agregar tutoría");
        System.out.println("2. Listar mis tutorías");
        System.out.println("0. Cancelar");
        respuesta = sc.nextInt();

        switch (respuesta) {
            case 1:
                agregararTutoria();
                break;
            case 2:
                listarTutorias();
                break;
            case 0:
                mostrarMenu();
                break;
            default:
                System.out.println("Por favor, seleccione una respuesta válida.");
                maestroMenu();
                break;
        }
    }

    public static void agregararTutoria(){
        System.out.println("Agregar tutoría: ");
        System.out.println("Ingresa la fecha del curso: [dd/mm/yyyy]");
        Scanner sc = new Scanner(System.in);
        String fecha = sc.nextLine();
        System.out.println("Ingresa la hora del curso: [hh:mm]");
        String hora = sc.nextLine();

        boolean bandera = true;
        do {
        System.out.println("La fecha de la tutorías es " + fecha + " " + hora + ". ¿Es correcto?");
        System.out.println("1. Agregar tutoría");
        System.out.println("2. Corregir fecha");
        int respuesta = sc.nextInt();
        switch (respuesta) {
            case 1:
                maestroLogeado.addTutoriaDisponible(fecha, hora);
                bandera = false;
                System.out.println("Tutoría agregada exitosamente.");
                maestroMenu();
                break;
            case 2:
                agregararTutoria();
                bandera = false;
                break;
            default:
                System.out.println("Por favor, ingrese una respuesta válida.");
            }
        } while (bandera);
    }

    public static void consultarMaestroConTutoria(Maestro maestro) {
        if(!maestrosConTutorias.contains(maestro)) {
            maestrosConTutorias.add(maestro);
        }
    }

    public static void listarTutorias(){
        System.out.println("Listado de tutorias: ");

        if(maestroLogeado.getTutoriaDisponibles().isEmpty()){
            System.out.println("No hay registros.");
            maestroMenu();
        } else {
            int j = 1;
            for(int i = 0; i < maestroLogeado.getTutoriaDisponibles().size(); i++){
                System.out.println(j + ". " + maestroLogeado.getTutoriaDisponibles().get(i).getFechaString() + " " + maestroLogeado.getTutoriaDisponibles().get(i).getHora());
                j++;
            }
            maestroMenu();
        }
    }
}