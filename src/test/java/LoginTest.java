import org.example.userModule.*;
import org.junit.jupiter.api.BeforeEach; // Mudou aqui
import org.junit.jupiter.api.AfterEach;  // Mudou aqui
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    //Criei as instâncias
    User user;
    UserRepository repository;
    UserApplication userface;

    @BeforeEach
    public void setUp() {
        //Iniciei as instâncias
        user = new User("Jhon Bacon", "bacon@Yahoo.com", "bacon");
        repository = new UserRepository();
        repository.addUser(user);
        userface = new UserApplication(repository);
    }

    @AfterEach
    public void tearDown() {
        //Zerei as instâncias
        user = null;
        repository = null;
        userface = null;
    }

    @Test
    public void LoginTestCorreto(){
        assertTrue(userface.login(user.getEmail(), user.getSenha()), String.valueOf(true));
    }

    @Test
    public void LoginTestIncorreto(){
        assertFalse(userface.login(user.getEmail(), "Pamonha"));
    }

    @Test
    public void LoginTestNoUser(){
        assertThrows(NullPointerException.class, () -> {
            userface.login(null, user.getSenha());
        });
    }

    @Test
    public void LoginTestNoPassword(){
        assertThrows(NullPointerException.class, () -> {
            userface.login(user.getEmail(), null);
        });
    }

    @Test
    public void CadastroCorretoTest(){
        //Cadastrar e depois checar com Assert
        userface.cadastrar("Joilsu", "locusOfCorruption@gmail.com", "senhaValida");
        assertTrue(userface.findUserByEmail("locusOfCorruption@gmail.com"), String.valueOf(true));
    }

    @Test
    public void CadastroIncorretoTest(){
        assertFalse(userface.cadastrar("Wanderglaydson", "notAnEmail.locusOfCorruption.yes", "senhaValida"));
    }
}
