package com.fatto.ProjetoFatto.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoTarefas (
        Long id,
        String nome,
        BigDecimal custo,
        LocalDate dataLimite
){

}
