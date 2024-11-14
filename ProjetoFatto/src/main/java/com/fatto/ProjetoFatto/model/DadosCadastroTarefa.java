package com.fatto.ProjetoFatto.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroTarefa(
        String nome,

        BigDecimal custo,

        LocalDate dataLimite
) {
}
