import org.example.calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DescountTest {

    @Test
    public void testaDesconto(){
        assertEquals(calculadora.desconto(900, 10), 810);
    }

    @Test
    public void testaDescontoVip(){
        assertEquals(calculadora.desconto(900, true), 765); //Estou presumindo 15% de desconto
    }
}
