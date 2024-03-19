package com.gabriel.teste.dto;

import com.gabriel.teste.entity.Usuarios;

public record ListagemUsuario(Long id, String nome){

    public ListagemUsuario(Usuarios usuarios){
        this(usuarios.getId(), usuarios.getNome());
    }
}
