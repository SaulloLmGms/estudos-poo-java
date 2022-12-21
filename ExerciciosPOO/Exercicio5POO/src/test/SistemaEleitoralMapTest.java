package test;

import main.java.com.sistemaeleitoral.Partido;
import main.java.com.sistemaeleitoral.SistemaEleitoralMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaEleitoralMapTest {
    SistemaEleitoralMap sistema;


    @Before
    public void setUp(){
        this.sistema = new SistemaEleitoralMap();
    }


    @Test
    public void testeParaCadastrarEleitor(){

        Boolean resultado = this.sistema.cadastraEleitor("Juvenal", "147147147");
        Boolean resultadoFalso = this.sistema.cadastraEleitor("Juvenal", "147147147");

        assertTrue(resultado);
        assertFalse(resultadoFalso);

    }
}