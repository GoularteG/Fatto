package com.fatto.ProjetoFatto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity (name = "Tarefas")
@Table(name = "tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal custo;

    private LocalDate dataLimite;

    private Integer ordemApresentacao;


    public Tarefas(DadosCadastroTarefa dadosCadastroTarefa){
        this.nome=dadosCadastroTarefa.nome();
        this.custo=dadosCadastroTarefa.custo();
        this.dataLimite=dadosCadastroTarefa.dataLimite();
    }


    public void atualizarTarefa(DadosAtualizacaoTarefas dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.custo() != null) {
            this.custo = dados.custo();
        }
        if (dados.dataLimite() != null) {
            this.dataLimite = dados.dataLimite();
        }
    }
}

