package com.jessicaoliveira.CentralDeServicos.domain;

public class Tecnico extends Pessoa{

    public Tecnico() {
    }

    public Tecnico(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }
}
