import org.example.calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    @Test
    public void testaSoma(){
        assertEquals(calculadora.soma(2, 3), 5);
    }

    @Test
    public void testaSomaNegativa(){
        assertEquals(calculadora.soma(5, -2), 3);
    }

    @Test
    public void testaSubtracao(){
        assertEquals(calculadora.sub(7, 3), 4);
    }

    @Test
    public void testaMultiplicacao(){
        assertEquals(calculadora.multi(4, 3), 12);
    }

    @Test
    public void testaDivisao(){
        assertEquals(calculadora.div(10, 2), 5);
    }

    @Test
    public void testaException(){
        assertThrows(ArithmeticException.class, () -> {
            calculadora.div(10, 0);
        });
    }
}
