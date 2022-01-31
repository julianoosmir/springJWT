package br.com.academy.Enums;

public enum EnumCurso {
   
    ADMINISTRACAO("Administracao"),
    INFORMATICA("informatica"),
    CONTABIIDADE("Contabilidade"),
    PROGRAMACAO("Programacao"),
    ENFERMAGEM("Enfermagem");

    private String curso;

    private EnumCurso(String curso) {
        this.curso = curso;
    }
}
