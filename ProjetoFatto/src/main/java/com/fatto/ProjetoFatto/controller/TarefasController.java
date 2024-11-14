package com.fatto.ProjetoFatto.controller;

import com.fatto.ProjetoFatto.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    @Autowired
    private TarefaRepository repository;


    @GetMapping("/tarefas")
    public ResponseEntity<Page<DadosListagemTarefas>> listar(@PageableDefault(size = 10,sort = {"ordemApresentacao"}) Pageable paginacao){
        var p= repository.findAll(paginacao).map(DadosListagemTarefas::new);
        return ResponseEntity.ok(p);
    }

    @PutMapping("/{id}/subir")
    public ResponseEntity<DadosDetalhamentoTarefa> subirTarefa(@PathVariable Long id) {
        var tarefa = repository.getReferenceById(id);
        if (tarefa.getOrdemApresentacao() > 1) {
            int novaOrdem = tarefa.getOrdemApresentacao() - 1;

            repository.findByOrdemApresentacao(novaOrdem).ifPresent(t -> {
                t.setOrdemApresentacao(t.getOrdemApresentacao() + 1);
                repository.save(t);
            });

            tarefa.setOrdemApresentacao(novaOrdem);
            repository.save(tarefa);
        }
        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @PutMapping("/{id}/descer")
    public ResponseEntity<DadosDetalhamentoTarefa> descerTarefa(@PathVariable Long id) {
        var tarefa = repository.getReferenceById(id);
        int totalTarefas = (int) repository.count();
        if (tarefa.getOrdemApresentacao() < totalTarefas) {
            int novaOrdem = tarefa.getOrdemApresentacao() + 1;

            repository.findByOrdemApresentacao(novaOrdem).ifPresent(t -> {
                t.setOrdemApresentacao(t.getOrdemApresentacao() - 1);
                repository.save(t);
            });

            tarefa.setOrdemApresentacao(novaOrdem);
            repository.save(tarefa);
        }
        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirTarefa(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity atualizarTarefa( @RequestBody DadosAtualizacaoTarefas dadosAtualizacaoTarefas) {
        var tarefa = repository.getReferenceById(dadosAtualizacaoTarefas.id());
        tarefa.atualizarTarefa(dadosAtualizacaoTarefas);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }


    @PostMapping("/tarefas")
    public ResponseEntity<DadosDetalhamentoTarefa> criarTarefa(@RequestBody DadosCadastroTarefa dados) {
        var tarefaCriada= new Tarefas(dados);
        repository.save(tarefaCriada);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefaCriada));
    }


}

