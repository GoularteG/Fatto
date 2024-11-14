package com.fatto.ProjetoFatto.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemTarefas(Long id, String nome, BigDecimal custo, LocalDate dataLimite,Integer ordemApresentacao,boolean destacar) {

    public DadosListagemTarefas(Tarefas tarefas){
        this(tarefas.getId(),tarefas.getNome(), tarefas.getCusto(),tarefas.getDataLimite(), tarefas.getOrdemApresentacao(),tarefas.getCusto().compareTo(BigDecimal.valueOf(1000)) >= 0);
    }

}
