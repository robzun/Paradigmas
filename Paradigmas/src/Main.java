import model.Estudiante;
import model.Maestro;
import model.Secretaria;
import ui.UIEstudiante;
import ui.UIMaestro;
import ui.UIMenu;

import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
        Maestro maestro1 = new Maestro("Luis Morales","luismorales04@uv.mx",1);
        maestro1.addTutoriaDisponible("12/10/2024","14:00");
        maestro1.addTutoriaDisponible("20/10/2024","16:00");

        Maestro maestro2 = new Maestro("Magdiel Mercado","mamercado@uv.mx",3);
        maestro2.addTutoriaDisponible("20/09/2024","15:00");
        maestro2.addTutoriaDisponible("26/09/2024","17:00");

        maestros.add(new Maestro("Javier Pino","jpino@uv.mx",2));
        maestros.add(new Maestro("José Vergara","jvergara@uv.mx",4));
        maestros.add(new Maestro("Patricia Martínez","pmartinez@uv.mx",5));

        Estudiante estudiante1 = new Estudiante("Roberto Zúñiga", "zuniga@uv.mx", "S22017031");
        estudianteLogeado = estudiante1;

        estudiantes.add(new Estudiante("Ricardo Landa", "landa@uv.mx", "S120"));
        estudiantes.add(new Estudiante("Alexis Nava", "nava@uv.mx", "S121"));
        estudiantes.add(new Estudiante("Emilio Jasso", "jasso@uv.mx", "S122"));

        secretarias.add(new Secretaria("Mechita","mechita@uv.mx","Matutino"));

        mostrarMenu();
    }
}