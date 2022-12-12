import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Doctor implements Serializable {
    private String nombre;
    private String apellido;
    private  int matricula;
    private String profesion;
    public Doctor(){
    }

    public Doctor(String nombre, String apellido, int matricula, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    public  void   agregarDoctor(){


        try {
            Connection non=Conexion.getConnection();
            PreparedStatement agregar=non.prepareStatement("INSERT INTO doctores VALUE (?,?,?,?,?)");


            agregar.setString(1,null);
            agregar.setString(2,nombre);
            agregar.setString(3,apellido);
            agregar.setInt(4, matricula);
            agregar.setString(5,profesion);

            agregar.executeUpdate();


        } catch (SQLException e) {
            System.out.println("herror al guardar en BDA  ");
            Modelo.GuardarDoctor(this);


        }
    }
   public boolean validacionDocotor(){
        ArrayList<Doctor>verD=Modelo.recuperaDoctores();
        boolean retornar=false;
        for (int i=0;i<verD.size();i++){
            if (equals(verD)){
                return true;
            }
        }
        return retornar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return matricula == doctor.matricula && Objects.equals(nombre, doctor.nombre) && Objects.equals(apellido, doctor.apellido) && Objects.equals(profesion, doctor.profesion);
    }


    @Override
    public String toString() {
        return "Doctor-->" +
                "nombre; " + nombre  +
                " apellido; " + apellido +
                " matricula; " + matricula +
                " profesion; " + profesion ;
    }
}
