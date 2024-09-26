package ui;

import model.Estudiante;
import model.Maestro;
import model.Secretaria;

import java.util.ArrayList;
import java.util.Scanner;
import static ui.UIEstudiante.*;
import static ui.UIMaestro.*;
import static ui.UISecretaria.*;


public class UIMenu {
    public static ArrayList<Maestro> maestros = new ArrayList<>();
    public static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    public static ArrayList<Secretaria> secretarias = new ArrayList<>();
    public static Maestro maestroLogeado;
    public static Estudiante estudianteLogeado;
    public static Secretaria secretariaLogeado;

    public static void mostrarMenu() {
        System.out.println("..:: Bienvenido ::..");
        System.out.println("Selecciona una opción:");

        System.out.println("1. Maestro");
        System.out.println("2. Estudiante");
        System.out.println("3. Secretaria");
        System.out.println("0. Salir");

        int respuesta;
        Scanner sc = new Scanner(System.in);
        respuesta = sc.nextInt();

        switch (respuesta) {
            case 1:
                loginUsuario(1);
                break;
            case 2:
                loginUsuario(2);
                break;
            case 3:
                loginUsuario(3);
                break;
            case 0:
                System.out.println("..:: Adiós ::..");
                System.exit(0);
                break;
            default:
                System.out.println("Por favor, seleccione una respuesta válida.");
                mostrarMenu();
                break;
        }
    }

    public static void loginUsuario(int tipo) {
        //Maestro -> 1
        //Estudiante -> 2
        //Secretaria -> 3

        boolean banderaCorreo = true;
        do{
        System.out.println("Ingresa tu correo: ");
        Scanner sc = new Scanner(System.in);
        String correoUsuario = sc.nextLine();

        if(tipo == 1) {
            for(Maestro maestro : maestros) {
                if(maestro.getCorreo().equals(correoUsuario)){
                    System.out.println("Hola " + maestro.getNombre());
                    banderaCorreo = false;
                    maestroLogeado = maestro;
                    maestroMenu();
                } else {
                    System.out.println("Correo no encontrado.");
                    mostrarMenu();
                }
            }
        }

        if(tipo == 2) {
            for(Estudiante estudiante : estudiantes) {
                if(estudiante.getCorreo().equals(correoUsuario)){
                    System.out.println("Hola " + estudiante.getNombre());
                    banderaCorreo = false;
                    estudianteLogeado = estudiante;
                    estudianteMenu();
                } else {
                    System.out.println("Correo no encontrado.");
                    mostrarMenu();
                }
            }
        }

        if(tipo == 3) {
            for(Secretaria secretaria : secretarias) {
                if(secretaria.getCorreo().equals(correoUsuario)) {
                    System.out.println("Hola " + secretaria.getNombre());
                    banderaCorreo = false;
                    secretariaLogeado = secretaria;
                    secretariaMenu();
                    } else {
                        System.out.println("Correo no encontrado.");
                        mostrarMenu();
                    }
                }
            }
        } while (banderaCorreo);
    }
}