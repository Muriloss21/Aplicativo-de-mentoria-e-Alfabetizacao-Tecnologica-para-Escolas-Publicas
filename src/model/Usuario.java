package model;

public class Usuario {

	private String nome;
    private String email;
    private String senha;
    private String tipoUsuario;

    public Usuario(String nome, String email, String senha, String tipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
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
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }
} 
