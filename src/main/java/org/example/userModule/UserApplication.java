package org.example.userModule;

import lombok.NonNull;
import org.example.vendasModule.Produto;

import java.util.regex.Pattern;

public class UserApplication {
    UserRepository repository;

    public UserApplication(UserRepository repository) {
        this.repository = repository;
    }

    public static boolean validarEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        if (email == null) return false;

        return Pattern.compile(regex)
                .matcher(email)
                .matches();
    }

    public boolean login(@NonNull String email, @NonNull String senha) { //Aplicar Throws
        if (!validarEmail(email)) return false;
        User user = repository.findUserByEmail(email);
        if (user == null) {
            return false;
        } else {
            if (user.getSenha().equals(senha)) {
                return true;
            }
            return false;
        }
    }

    public boolean findUserByEmail(String email) {
        if (!validarEmail(email)) return false;
        if (repository.findUserByEmail(email) != null) {
            return true;
        }
        return false;
    }

    public boolean cadastrar(String nome, String email, String senha) { //Aplicar Throws
        if (!validarEmail(email)) return false;
        repository.addUser(new User(nome, email, senha));
        return true;
    }

    public boolean verificarCarrinho(String email, String produto){
        return repository.verificarCarrinho(email, produto);
    }

    public void adicionaCarrinho(String nome, Produto produto) {
        repository.adicionarProduto(nome, produto);
    };

    public void removerItem(String nome, Produto produto) {repository.removerProduto(nome, produto);}

    public double verificarTotal(String email){
        User user;
        if (repository.findUserByEmail(email) != null) {
            user = repository.findUserByEmail(email);
            return repository.retornaValorTotal(user);
        }
        return -1;
    }
}
