package br.com.academy.Enums;

public enum EnumStatus {

    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String status;

    private EnumStatus(String status) {
        this.status = status;
    }
}
