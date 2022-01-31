package br.com.academy.services;

import br.com.academy.models.Aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.repository.AlunoRepositoy;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepositoy alunoRepositoy;
    
    public List<Aluno> buscarTodos(){
        return alunoRepositoy.findAll();
    }
    public Aluno salvar(Aluno aluno){
        return alunoRepositoy.save(aluno);
    }
    public void deletar(Integer id){
        alunoRepositoy.deleteById(id);
    }
    public Aluno atualizar(Aluno aluno){
        Optional<Aluno> alunoCadastrado = alunoRepositoy.findById(aluno.getId());
        alunoCadastrado.ifPresent(oneAluno -> aluno.setId(oneAluno.getId()));
        return alunoRepositoy.save(aluno);
    }
}
