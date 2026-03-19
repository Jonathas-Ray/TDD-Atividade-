package org.example.userModule;

import org.example.vendasModule.Produto;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }
    public User findUserByEmail(String email){
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void adicionarProduto(String nome, Produto produto){
        for(User user : users){
            if(user.getNome().equals(nome)){
                user.addProduto(produto);
            }
        }
    }
    public boolean verificarCarrinho(String email, String nomeProduto) {
        User user = findUserByEmail(email);
        if (user == null) return false;
        for (Produto p : user.getProdutos()) {
            if (p.getNome().equals(nomeProduto)) {
                return true;
            }
        }
        return false;
    }

    public void removerProduto(String nome, Produto produto){
        for(User user : users){
            if(user.getNome().equals(nome)){
                if(user.getProdutos().contains(produto)){
                    user.removeProduto(produto);
                }
            }
        }
    }

    public double retornaValorTotal(User user){
        return user.getProdutos().stream().mapToDouble(Produto::getValor).sum();
    }


}
