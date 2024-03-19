package com.gabriel.teste.service;

import com.gabriel.teste.dto.DadosUsuarios;
import com.gabriel.teste.entity.Usuarios;
import com.gabriel.teste.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class UsuariosService {
    @Autowired
    private UsuariosRepository repository;
    public ResponseEntity<Object> createUsuario(DadosUsuarios dados){
        if(repository.existsByNome(dados.nome())){
            throw new IllegalArgumentException("Usuario já registrado.");
        }
        var usuario = new Usuarios(dados);
        repository.save(usuario);
        return  ResponseEntity.ok().build();
    }

        public void delete(Long id){
            repository.deleteById(id);
        }



}
