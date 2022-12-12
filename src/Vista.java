import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {
    public static int menu() {
        int opcion = 0;
        Scanner Leer = new Scanner(System.in);
        System.out.println("Clinica SOLUTION S.A.");
        System.out.println("A continuacion selecione la opcion que desea; ");
        System.out.println("[1] Agregar Paciente");
        System.out.println("[2] Agregar Doctor");
        System.out.println("[3] Listar Pacientes");
        System.out.println("[4] Listar Doctores");
        System.out.println("[5] Asignar Turno");
        System.out.println("[6] Ver turnos");
        System.out.println("[7] Borar Turno");
        System.out.println("[0] salir ");
        try {

            opcion = Leer.nextInt();

        } catch (InputMismatchException e) {

            System.out.println("A ingresado un valor incorecto vuelva a intentarlo");
            opcion = menu();
        }

        return opcion;
    }

    public static ArrayList generarPaciente() {

        ArrayList<String>Datos=new ArrayList<>();
        Scanner Leer = new Scanner(System.in);

        System.out.println("Nombre del paciente");
        String nom = Leer.nextLine();
        Datos.add(nom);
        System.out.println("Apellido del paciente");
        String ape = Leer.nextLine();
        Datos.add(ape);
        System.out.println("Edad del paciente");
        String edad=Leer.nextLine();
        Datos.add(edad);
        System.out.println("DNI del paciente");
        String DNI=Leer.nextLine();
        Datos.add(DNI);
        System.out.println("Obra Social del Paciente");
        String obraSocial=Leer.nextLine();
        Datos.add(obraSocial);;

        return Datos;
    }
    public static ArrayList agregarDoctor() {
        ArrayList<String>Datos=new ArrayList<>();
        Scanner Leer = new Scanner(System.in);
        ;
        System.out.println("Nombre del Doctor");
        String nom = Leer.nextLine();
        Datos.add(nom);
        System.out.println("Apellido del Doctor");
        String ape = Leer.nextLine();
        Datos.add(ape);

        System.out.println("matricula");
        String matri = Leer.nextLine();
        Datos.add(matri);

        System.out.println("Profesion");
        String profesion = Leer.nextLine();
        Datos.add(profesion);

        return Datos;

    }
    public static void verPacientess(ArrayList<Paciente> pacientes) {

        for (int i = 0; i < pacientes.size(); i++) {

            System.out.println(i+"--"+pacientes.get(i));

        }

    }
    public static void verDoctores(ArrayList<Doctor> doctores) {

        for (int i = 0; i < doctores.size(); i++) {

            System.out.println(i+"-"+doctores.get(i));

        }

    }
    public static void verTurno(ArrayList<Turno> turno) {

        for (int i = 0; i < turno.size(); i++) {

            System.out.println(i+"-"+turno.get(i));

        }

    }
    public static ArrayList agregarTurno(){
        ArrayList<String>datos=new ArrayList<>();
        Scanner leer=new Scanner(System.in);
        System.out.println("insgrese fecha de turno");
        String fecha=leer.nextLine();
        System.out.println("ingrese hora de turno");
        String hora=leer.nextLine();
        datos.add(fecha);
        datos.add(hora);
        return datos;
    }
    public static Turno eliminarTurno(ArrayList<Turno> turnos) {
        System.out.println("selecione un Turno;");
        for (int i = 0; i < turnos.size(); i++) {
            System.out.println("[" + i + "]-" + turnos.get(i));
        }
        Scanner leer = new Scanner(System.in);
        int  n = leer.nextInt();

        return turnos.get(n);
    }
    public static int asignarPaciente(ArrayList<Paciente> ListaPacientes) {
        System.out.println("selecione un Paciente;");
        for (int i = 0; i < ListaPacientes.size(); i++) {
            System.out.println("[" + i + "]-" + ListaPacientes.get(i));
        }
        int n=0;
        Scanner leer = new Scanner(System.in);
      try {

           n = leer.nextInt();
      }catch (InputMismatchException e){
          System.out.println("petision ingresada es incorrecto");
      }


        return n+1;
    }
    public static int asignarDoctor(ArrayList<Doctor> ListaDoctores) {
        int n=0;
        System.out.println("selecione un Doctor;");
        for (int i = 0; i < ListaDoctores.size(); i++) {
            System.out.println("[" + i + "]-" + ListaDoctores.get(i));
        }
        Scanner leer = new Scanner(System.in);
        try{
             n = leer.nextInt();
        }catch (InputMismatchException e){
            System.out.println("petision ingresada es incorrecto");
        }


        return n+1;
    }
    public static void verValidacion (String verresulatado){
        System.out.println(verresulatado);

    }

}
