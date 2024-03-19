package com.gabriel.teste.controler;

import com.gabriel.teste.dto.AtualizarDados;
import com.gabriel.teste.dto.DadosUsuarios;
import com.gabriel.teste.dto.ListagemUsuario;
import com.gabriel.teste.entity.Usuarios;
import com.gabriel.teste.repository.UsuariosRepository;
import com.gabriel.teste.service.UsuariosService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.Endpoint;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioControler {
    @Autowired
    private UsuariosService usuariosService;

    @Autowired

    private UsuariosRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity login(@RequestBody @Valid DadosUsuarios dados, UriComponentsBuilder uriComponentsBuilder){

        return usuariosService.createUsuario(dados);
    }
    @GetMapping
    public ResponseEntity<Page <ListagemUsuario>>lista(@PageableDefault(size = 10)Pageable pagina){
        var pag = repository.findAll(pagina).map(ListagemUsuario::new);
        return ResponseEntity.ok(pag);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        usuariosService.delete(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarDados atualizarDados){
        var usuario = repository.getReferenceById(atualizarDados.id());
        usuario.AtualizarInformacao(atualizarDados);
        return ResponseEntity.ok(new ListagemUsuario(usuario));

    }


}
