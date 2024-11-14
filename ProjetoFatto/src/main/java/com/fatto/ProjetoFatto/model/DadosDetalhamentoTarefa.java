package com.fatto.ProjetoFatto.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhamentoTarefa( Long id,String nome,BigDecimal custo, LocalDate dataLimite,Integer ordemApresentacao) {

    public DadosDetalhamentoTarefa(Tarefas tarefas){
        this(tarefas.getId(),tarefas.getNome(), tarefas.getCusto(),tarefas.getDataLimite(),tarefas.getOrdemApresentacao());
    }
}
