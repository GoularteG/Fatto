package com.fatto.ProjetoFatto.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefas, Long > {

    Optional<Tarefas> findByOrdemApresentacao(int ordemApresentacao);

    Optional<Tarefas> findTopByOrderByOrdemApresentacaoDesc();
}
