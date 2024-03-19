package com.gabriel.teste.entity;

import com.gabriel.teste.dto.AtualizarDados;
import com.gabriel.teste.dto.DadosUsuarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Usuarios")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;


    public Usuarios(DadosUsuarios dados) {
        this.nome = dados.nome();
        this.senha = dados.senha();
    }

    public void AtualizarInformacao(AtualizarDados atualizarDados) {
        if (atualizarDados.nome()!=null){
            this.nome = atualizarDados.nome();

        }
        if (atualizarDados.id()!=null){
            this.id = atualizarDados.id();
        }
        if (atualizarDados.senha()!=null){
            this.senha =atualizarDados.senha();
        }
    }
}
