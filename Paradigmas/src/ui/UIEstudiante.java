package ui;

import model.CitaMaestro;
import model.CitaTutoria;
import model.Maestro;
import java.util.ArrayList;

import java.util.Scanner;

public class UIEstudiante {
    public static void estudianteMenu() {
        int respuesta;
        Scanner sc = new Scanner(System.in);
        System.out.println("..:: Estudiantes ::..");
        System.out.println("1. Agendar tutoría");
        System.out.println("2. Mis tutorías");
        System.out.println("0. Cancelar");
        respuesta = sc.nextInt();

        switch (respuesta) {
            case 1:
                agendarTutoria();
                break;
            case 2:
                listarTutorias();
                break;
            case 0:
                UIMenu.mostrarMenu();
                break;
            default:
                System.out.println("Por favor, seleccione una respuesta válida.");
                estudianteMenu();
                break;
        }
    }
    public static void agendarTutoria() {
        System.out.println("..:: Agendar tutoría ::..");
        if (UIMaestro.maestrosConTutorias.isEmpty()){
            System.out.println("No hay tutorías disponibles.");
            estudianteMenu();
        } else {
            boolean banderaMaestro = true;
            int maestroRespuesta = 0;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Seleccione un maestro: ");

                int i = 1;
                for (Maestro maestro : UIMaestro.maestrosConTutorias) {
                    System.out.println(i + ". " + maestro.getNombre());
                    i++;
                }

                int respuesta = sc.nextInt();

                int cantidadMaestros = UIMaestro.maestrosConTutorias.size();
                if (respuesta < 1 || respuesta > cantidadMaestros) {
                    System.out.println("Por favor, seleccione una opción válida.");
                }else {
                    banderaMaestro = false;
                    maestroRespuesta = respuesta;
                }
            }while (banderaMaestro);

            Maestro maestroSeleccionado = UIMaestro.maestrosConTutorias.get(maestroRespuesta - 1);

            boolean banderaTutoria = true;
            int tutoriaSeleccionada = 0;
            do {
            System.out.println("Seleccione una tutoría: ");
            int i = 1;
            for (Maestro.TutoriasDisponibles td : UIMaestro.maestrosConTutorias.get(maestroRespuesta - 1).getTutoriaDisponibles()) {
                System.out.println(i + ". " + td.getFechaString() + " " + td.getHora());
                i++;
            }
            int respuesta = sc.nextInt();

            int cantidadTutorias = UIMaestro.maestrosConTutorias.get(maestroRespuesta - 1).getTutoriaDisponibles().size();
            if (respuesta < 1 || respuesta > cantidadTutorias) {
                System.out.println("Por favor, seleccione una opción válida.");
            }else {
                banderaTutoria = false;
                tutoriaSeleccionada = respuesta;
                }
            }while (banderaTutoria);

            boolean banderaConfirmacion = true;
            do {
                System.out.println("Maestro: " + maestroSeleccionado.getNombre() + "\n" + "Tutoría: " + maestroSeleccionado.getTutoriaDisponibles().get(tutoriaSeleccionada - 1).getFechaString() + " " + maestroSeleccionado.getTutoriaDisponibles().get(tutoriaSeleccionada - 1).getHora());
                System.out.println("1. Continuar\n2. Cambiar tutoría");
                int respuestaConfirmacion = sc.nextInt();
                switch (respuestaConfirmacion) {
                    case 1:
                        Maestro.TutoriasDisponibles ts = maestroSeleccionado.getTutoriaDisponibles().get(tutoriaSeleccionada - 1);
                        UIMenu.estudianteLogeado.addTutoriaMaestro(maestroSeleccionado, ts.getFecha(), ts.getHora());
                        System.out.println("Tutoría agendada exitosamente.");
                        estudianteMenu();
                        banderaConfirmacion = false;
                        break;
                    case 2:
                        agendarTutoria();
                        break;
                    default:
                        System.out.println("Por favor, seleccione una opción válida.");
                        break;
                }
            } while (banderaConfirmacion);
        }
    }
    private static void listarTutorias() {
        System.out.println("..:: Mis tutorías ::..");
        ArrayList<CitaMaestro> misTutorias = UIMenu.estudianteLogeado.getTutoriasAgendadas();
        if (misTutorias.isEmpty()) {
            System.out.println("No tienes tutorías agendadas.");
            estudianteMenu();
        } else {
            int i = 1;
            for (CitaMaestro cita : misTutorias) {
                System.out.println(i + ". " + cita);
                i++;
            }
            estudianteMenu();
        }
    }
}