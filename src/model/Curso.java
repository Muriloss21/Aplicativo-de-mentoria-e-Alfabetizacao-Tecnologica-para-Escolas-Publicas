package model;

public class Curso {

    private String titulo;

    private String descricao;

    public Curso(String titulo,
            String descricao) {

        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {

        return titulo;
    }

    public String getDescricao() {

        return descricao;
    }
}