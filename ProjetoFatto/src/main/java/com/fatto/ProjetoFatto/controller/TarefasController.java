package com.fatto.ProjetoFatto.controller;

import com.fatto.ProjetoFatto.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    @Autowired
    private TarefaRepository repository;


    @GetMapping
    public ResponseEntity<Page<DadosListagemTarefas>> listar(@PageableDefault(size = 10,sort = {"ordemApresentacao"}) Pageable paginacao){
        var p= repository.findAll(paginacao).map(DadosListagemTarefas::new);
        return ResponseEntity.ok(p);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity excluirTarefa(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity atualizarTarefa( @RequestBody DadosAtualizacaoTarefas dadosAtualizacaoTarefas) {
        var tarefa = repository.findById(dadosAtualizacaoTarefas.id()).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));;
        tarefa.atualizarTarefa(dadosAtualizacaoTarefas);
        repository.save(tarefa);
        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }


    @PostMapping
    public ResponseEntity<DadosDetalhamentoTarefa> criarTarefa(@RequestBody DadosCadastroTarefa dados) {
        int maiorOrdem = repository.findTopByOrderByOrdemApresentacaoDesc()
                .map(Tarefas::getOrdemApresentacao)
                .orElse(0);
        var tarefaCriada = new Tarefas(dados);
        tarefaCriada.setOrdemApresentacao(maiorOrdem + 1);
        repository.save(tarefaCriada);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefaCriada));
    }



}

