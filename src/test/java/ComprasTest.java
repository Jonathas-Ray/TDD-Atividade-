import org.example.userModule.User;
import org.example.userModule.UserApplication;
import org.example.userModule.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.vendasModule.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComprasTest {
    User user;
    List<Produto> produtos;
    UserRepository repository;
    UserApplication userface;

    @BeforeEach
    public void setUp() {
        //Iniciei as instâncias
        repository = new UserRepository();
        userface = new UserApplication(repository);
        userface.cadastrar("Seu Creysson", "Casseta@Planeta.com", "Agarantcho");
        produtos = new ArrayList<>();
        produtos.add(new Produto("Pera", 2.5));
        produtos.add(new Produto("Uva", 7.85));
        produtos.add(new Produto("Maçã", 5.20));
        produtos.add(new Produto("Salada Mista", 20.99));
    }
    @AfterEach
    public void tearDown() {
        user = null;
        repository = null;
        userface = null;
        produtos = null;
    }

    @Test
    public void verificaAdicionaNoCarrinho(){
        Produto prod = produtos.get(0);
        userface.adicionaCarrinho("Seu Creysson",prod);
        Assertions.assertTrue(userface.verificarCarrinho("Casseta@Planeta.com", "Pera"));
    }

    @Test
    public void verificaRemoverNoCarrinho(){
        Produto prod = produtos.get(0);
        userface.adicionaCarrinho("Seu Creysson",prod);
        Assertions.assertTrue(userface.verificarCarrinho("Casseta@Planeta.com", "Pera"));
        userface.removerItem("Seu Creysson", prod);
        Assertions.assertFalse(userface.verificarCarrinho("Casseta@Planeta.com", "Pera"));
    }

    @Test
    public void verificaTotalCarrinho(){
        Assertions.assertEquals(userface.verificarTotal("Casseta@Planeta.com"), 0);
        Produto prod = produtos.get(0);
        userface.adicionaCarrinho("Seu Creysson",prod);
        Assertions.assertEquals(userface.verificarTotal("Casseta@Planeta.com"), 2.5);
    }
}
