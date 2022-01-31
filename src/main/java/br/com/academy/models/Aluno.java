package br.com.academy.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.academy.Enums.EnumCurso;
import br.com.academy.Enums.EnumStatus;

@Entity
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private EnumCurso curso;
    private String matricula;
    private EnumStatus status;
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno id(Integer id) {
        setId(id);
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno nome(String nome) {
        setNome(nome);
        return this;
    }

    public EnumCurso getCurso() {
        return this.curso;
    }

    public void setCurso(EnumCurso curso) {
        this.curso = curso;
    }

    public Aluno curso(EnumCurso curso) {
        setCurso(curso);
        return this;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Aluno matricula(String matricula) {
        setMatricula(matricula);
        return this;
    }

    public EnumStatus getStatus() {
        return this.status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public Aluno status(EnumStatus status) {
        setStatus(status);
        return this;
    }

}
