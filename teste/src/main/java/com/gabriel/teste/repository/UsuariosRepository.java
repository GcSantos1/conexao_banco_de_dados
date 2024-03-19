package com.gabriel.teste.repository;

import com.gabriel.teste.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    boolean existsByNome(String nome);
}
