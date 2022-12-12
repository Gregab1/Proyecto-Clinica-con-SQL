import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Paciente implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private int DNI;
    private String obrasoical;
    public Paciente(){
    }

    public Paciente(String nombre, String apellido, int edad, int DNI, String obrasoical) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = DNI;
        this.obrasoical = obrasoical;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getObrasoical() {
        return obrasoical;
    }

    public void setObrasoical(String obrasoical) {
        this.obrasoical = obrasoical;
    }

    public  void   agregarPaciente(){


        try {
            Connection non=Conexion.getConnection();
            PreparedStatement agregar=non.prepareStatement("INSERT INTO pacientes VALUE (?,?,?,?,?,?)");


            agregar.setString(1,null);
            agregar.setString(2,nombre);
            agregar.setString(3,apellido);
            agregar.setInt(4, edad);
            agregar.setInt(5, DNI);
            agregar.setString(6,obrasoical);

            agregar.executeUpdate();


        } catch (SQLException e) {
            System.out.println("herror al guardar en BDA  ");
            Modelo.GuardarPaciente(this);


        }
    }
    public boolean validacion(){
        ArrayList<Paciente> verP=Modelo.recuperaPacientes();
        boolean  retornar=false;
        for(int i=0;i<verP.size();i++){
            if(equals(verP.get(i))){
                retornar= true;
            }
        }
        return retornar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return edad == paciente.edad && DNI == paciente.DNI && Objects.equals(nombre, paciente.nombre) && Objects.equals(apellido, paciente.apellido) && Objects.equals(obrasoical, paciente.obrasoical);
    }


    @Override
    public String toString() {
        return "Paciente-->" +
                "nombre; " + nombre +
                " apellido; " + apellido +
                " edad; " + edad +
                " DNI; " + DNI +
                " obrasoical; " + obrasoical ;
    }


}
