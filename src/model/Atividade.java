package model;

public class Atividade {

    private String titulo;

    private String descricao;

    private int pontos;

    private boolean concluida;

    // CONSTRUTOR
    public Atividade(String titulo,
            String descricao,
            int pontos) {

        this.titulo = titulo;

        this.descricao = descricao;

        this.pontos = pontos;

        this.concluida = false;
    }

    // GET TÍTULO
    public String getTitulo() {

        return titulo;
    }

    // GET DESCRIÇÃO
    public String getDescricao() {

        return descricao;
    }

    // GET PONTOS
    public int getPontos() {

        return pontos;
    }

    // CONCLUÍDA
    public boolean isConcluida() {

        return concluida;
    }

    // CONCLUIR
    public void concluir() {

        concluida = true;
    }
}