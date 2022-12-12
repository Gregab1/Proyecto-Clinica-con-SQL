import java.util.ArrayList;

public class Controlador {
    public static void main(String[] args) {



        int opcion=0;
        do{
            ArrayList<Paciente> ListaPaciente = Modelo.recuperaPacientes();
            ArrayList<Doctor> ListaDoctores = Modelo.recuperaDoctores();
            ArrayList<Turno> listaTurno = Modelo.recuperaTurnos();
            opcion = Vista.menu();
            if (opcion == 1) {

                ArrayList<String> atributosPacientes = Vista.generarPaciente();

                String nombre = atributosPacientes.get(0);
                String apellido = atributosPacientes.get(1);
                int edad = Integer.parseInt(atributosPacientes.get(2));
                int DNI = Integer.parseInt(atributosPacientes.get(3));

                String obrasocial = atributosPacientes.get(4);
                Paciente P1 = new Paciente(nombre, apellido, edad, DNI, obrasocial);

                if (P1.validacion()) {
                    Vista.verValidacion("Este Paciente ya se ecuentraregistrado");
                } else {
                    Vista.verValidacion("El pasiente ha sido añadido con exito");
                    P1.agregarPaciente();
                }


            } else if (opcion == 2) {
                ArrayList<String> atributosDoctor = Vista.agregarDoctor();
                String nombre = atributosDoctor.get(0);
                String apellido = atributosDoctor.get(1);
                int matricula = Integer.parseInt(atributosDoctor.get(2));
                String profesion = atributosDoctor.get(3);


                Doctor D1 = new Doctor(nombre, apellido, matricula, profesion);

                if (D1.validacionDocotor()) {
                    Vista.verValidacion("Este doctor ya se encuentra registrado");
                } else {
                    Vista.verValidacion("EL doctor ha sido añadido con exito");
                     D1.agregarDoctor();
                }

            } else if (opcion == 3) {
                Vista.verPacientess(ListaPaciente);


            } else if (opcion == 4) {
                Vista.verDoctores(ListaDoctores);


            } else if (opcion == 5) {
                ArrayList<String> datosTurno = Vista.agregarTurno();
                String fecha = datosTurno.get(0);
                String hora = datosTurno.get(1);
                int p1 = Vista.asignarPaciente(ListaPaciente);
                int d1 = Vista.asignarDoctor(ListaDoctores);
                Turno turno1 = new Turno(fecha, hora, p1, d1);
                if (turno1.validacionTurno()) {
                    Vista.verValidacion("Este turno ya se encuentra registrado");
                } else {
                    Vista.verValidacion("EL turno ha sido añadido con exito");
                    turno1.asignarTurno();
                }

            } else if (opcion == 6) {
                Vista.verTurno(listaTurno);

            } else if (opcion == 7) {
                Turno t1 = Vista.eliminarTurno(listaTurno);
                Modelo.Eliminarturno(t1);
            }

        } while (opcion != 0);


    }




}
