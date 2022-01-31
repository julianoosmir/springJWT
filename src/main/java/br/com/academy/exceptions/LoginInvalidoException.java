package br.com.academy.exceptions;

public class LoginInvalidoException extends RuntimeException {
    public LoginInvalidoException(String mensagem) {
        super(mensagem);
    }
}
