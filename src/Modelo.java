import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modelo {
    public static void GuardarPaciente(Paciente p) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.addAll(recuperaPacientes());
        pacientes.add(p);
        try {
            ObjectOutputStream copiarDatos = new ObjectOutputStream(new FileOutputStream("C:/datosClinica/Paciente.txt"));
            copiarDatos.writeObject(pacientes);
            copiarDatos.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList recuperaPacientes() {
        ArrayList<Paciente> recuperarP = new ArrayList<>();

        try {

            PreparedStatement prepatre=Conexion.getConnection().prepareStatement("Select *from pacientes;");
            ResultSet resul=prepatre.executeQuery();

            while (resul.next()){
                Paciente p=new Paciente();
                p.setNombre(resul.getString("nombre"));
                p.setApellido(resul.getString("apellido"));
                p.setEdad(resul.getInt("edad"));
                p.setDNI(resul.getInt("dni"));
                p.setObrasoical(resul.getString("obrasocial"));
                recuperarP.add(p);
            }
        } catch (SQLException e) {
          try {
            ObjectInputStream obtenerDatos = new ObjectInputStream(new FileInputStream("C:/datosClinica/Paciente.txt"));
            recuperarP = (ArrayList<Paciente>) obtenerDatos.readObject();
        } catch (Exception p) { //t

        }
        }
        return recuperarP;
    }

    public static void GuardarDoctor(Doctor d) {
        ArrayList<Doctor> doctores = new ArrayList<>();
        doctores.addAll(recuperaDoctores());
        doctores.add(d);

        try {
            ObjectOutputStream copiarDatos = new ObjectOutputStream(new FileOutputStream("C:/datosClinica/Doctor.txt"));
            copiarDatos.writeObject(doctores);
            copiarDatos.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList recuperaDoctores() {
        ArrayList<Doctor> recuperarD = new ArrayList<>();
        try {

            PreparedStatement prepa=Conexion.getConnection().prepareStatement("Select *from doctores;");
            ResultSet resul=prepa.executeQuery();

            while (resul.next()){

                Doctor d=new Doctor();
                d.setNombre(resul.getString("nombre"));
                d.setApellido(resul.getString("apellido"));
                d.setMatricula(resul.getInt("matricula"));
                d.setProfesion(resul.getString("profesion"));
                recuperarD.add(d);
            }
        }catch (SQLException e){
            try {
                ObjectInputStream obtenerDatos = new ObjectInputStream(new FileInputStream("C:/datosClinica/Doctor.txt"));
                recuperarD = (ArrayList<Doctor>) obtenerDatos.readObject();

            } catch (Exception d) {//t

            }
        }

        return recuperarD;
    }

    public static void GuardarTurno(Turno t) {
        ArrayList<Turno> turnos = new ArrayList<>();
        turnos.addAll(recuperaTurnos());
        turnos.add(t);
        try {
            ObjectOutputStream copiarDatos = new ObjectOutputStream(new FileOutputStream("C:/datosClinica/Turno.txt"));
            copiarDatos.writeObject(turnos);
            copiarDatos.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList recuperaTurnos() {
        ArrayList<Turno> recuperarT = new ArrayList<>();
        try {

            PreparedStatement prepatre=Conexion.getConnection().prepareStatement("Select *from turnos;");
            ResultSet resul=prepatre.executeQuery();

            while (resul.next()){
                Turno t=new Turno();

                t.setFecha(resul.getString("fecha"));
                t.setHora(resul.getString("hora"));
                t.setPaciente(resul.getInt("ID_paciente_Asig"));

                t.setDoctor(resul.getInt("ID_doctor_Asig"));
                recuperarT.add(t);
            }
        }catch (SQLException e){
            try {
                ObjectInputStream obtenerDatos = new ObjectInputStream(new FileInputStream("C:/datosClinica/Turno.txt"));
                recuperarT = (ArrayList<Turno>) obtenerDatos.readObject();
            } catch (Exception h) {

            }
        }

        return recuperarT;
    }

    public static void Eliminarturno(Turno t) {
        ArrayList<Turno> turnos = new ArrayList<>();
        turnos.addAll(recuperaTurnos());
        turnos.remove(t);
        try {
            ObjectOutputStream copiarDatos = new ObjectOutputStream(new FileOutputStream("C:/datosClinica/Turno.txt"));
            copiarDatos.writeObject(turnos);
            copiarDatos.close();
        } catch (Exception e) {

        }
    }
}