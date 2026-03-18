import org.example.calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotasTest {

    @Test
    public void testCalcularNota(){
        assertEquals(calculadora.media(10, 2, 3), 5);
    }

    @Test
    public void testaAprovado(){
        assertTrue(calculadora.verificaAprovacao(7));
    }

    @Test
    public void testaReprovado(){
        assertFalse(calculadora.verificaAprovacao(5));
    }
}
