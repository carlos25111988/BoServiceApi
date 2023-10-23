package br.com.boserviceapi.entities;

import lombok.Data;

@Data
public class Pessoa {

    Integer idade;
    String nome;

    public Pessoa(Integer idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }
}
