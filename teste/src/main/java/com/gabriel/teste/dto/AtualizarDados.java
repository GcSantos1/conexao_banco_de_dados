package com.gabriel.teste.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarDados(Long id, String nome, String senha) {


}
