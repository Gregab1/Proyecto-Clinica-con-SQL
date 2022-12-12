import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
  @Test
          void  testear(){
      //verificasion de validasion de pacientes si no existe lo agreaga a la base de datos
      Paciente p=new Paciente("Andres","avalos",23,34986234,"osep");

      assertEquals(p.validacion(),false);
  }




}
