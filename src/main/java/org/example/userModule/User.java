package org.example.userModule;

import org.example.vendasModule.Produto;

import java.util.ArrayList;
import java.util.List;

public class User {
    String nome;
    String email;
    String senha;
    List<Produto> produtos;

    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void addProduto(Produto produto) {this.produtos.add(produto);}

    public void removeProduto(Produto produto) {this.produtos.remove(produto);}

    public List<Produto> getProdutos() {return this.produtos;}

    public boolean verificaCarrinho(Produto produto) {
        for (Produto prod : this.produtos) {
            if (prod.getNome().equals(produto.getNome())) {
                return true;
            }
        }
        return false;
    }

}
