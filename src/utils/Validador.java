package utils;

public class Validador {

    // VALIDAR EMAIL
    public static boolean emailValido(String email) {

        return email != null &&
               email.contains("@") &&
               email.contains(".") &&
               email.length() >= 5;
    }

    // VALIDAR SENHA
    public static boolean senhaValida(String senha) {

        return senha != null &&
        	   senha.length() >= 6;
    }

    // VALIDAR NOME
    public static boolean nomeValido(String nome) {

        return nome != null &&
        	   nome.length() >= 3;
    }
}