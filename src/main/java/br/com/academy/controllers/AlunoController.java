package br.com.academy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.models.Aluno;
import br.com.academy.services.AlunoService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    private List<Aluno> buscarTodos() {
        return alunoService.buscarTodos();
    }

    @PostMapping
    private Aluno salvar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @PutMapping
    private Aluno atualizarAluno(@RequestBody Aluno aluno) {
        return alunoService.atualizar(aluno);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable(name = "id") Integer id){
        alunoService.deletar(id);
    }

}
