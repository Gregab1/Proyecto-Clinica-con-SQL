import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Turno implements Serializable {
    private  String fecha;
    private String hora;
    private int paciente;
    private int doctor;
    public Turno(){
    }

    public Turno(String fecha, String hora, int paciente, int doctor) {

        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente( int paciente) {
        this.paciente = paciente;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }
    public  void   asignarTurno(){


        try {
            Connection non=Conexion.getConnection();
            PreparedStatement agregar=non.prepareStatement("INSERT INTO turnos VALUE (?,?,?,?,?)");


            agregar.setString(1,null);
            agregar.setString(2,fecha);
            agregar.setString(3,hora);
            agregar.setInt(4,paciente);
            agregar.setInt(5, doctor);


            agregar.executeUpdate();


        } catch (SQLException e) {
            System.out.println("herror al guardar en BDA  ");
            Modelo.GuardarTurno(this);


        }
    }
   public boolean validacionTurno(){
       ArrayList<Turno>verT=Modelo.recuperaTurnos();
       boolean retornar=false;
       for (int i=0;i<verT.size();i++){
           if (equals(verT)){
               return true;
           }
       }
       return retornar;
   }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turno)) return false;
        Turno turno = (Turno) o;
        return Objects.equals(hora, turno.hora) && Objects.equals(fecha, turno.fecha) && Objects.equals(paciente, turno.paciente) && Objects.equals(doctor, turno.doctor);
    }



    @Override
    public String toString() {
        return "Turno-->" +
                "fecha; " +  fecha +
                " hora; " + hora+
                " paciente=" + paciente +
                " doctor=" + doctor ;
    }
}
