package model;

public class Mentor {

    private String nome;

    private String email;

    private String senha;

    private String especialidade;

    public Mentor(String nome,
            String email,
            String senha,
            String especialidade) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.especialidade = especialidade;
    }

    public String getNome() {

        return nome;
    }

    public String getEmail() {

        return email;
    }

    public String getSenha() {

        return senha;
    }

    public String getEspecialidade() {

        return especialidade;
    }
}