import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
static Connection connection;
public static Connection getConnection() throws SQLException {

    if(connection==null){
connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica_solution","root","1234");
    }
    return connection;
}

    }









