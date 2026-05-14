package controller;

import java.util.ArrayList;

import model.Atividade;

public class AtividadeController {

    private ArrayList<Atividade> atividades;

    // CONSTRUTOR
    public AtividadeController() {

        atividades = new ArrayList<>();
    }

    // CADASTRAR
    public void cadastrarAtividade(
            String titulo,
            String descricao,
            int pontos) {

        Atividade atividade = new Atividade(
                titulo,
                descricao,
                pontos);

        atividades.add(atividade);
    }

    // LISTAR
    public ArrayList<Atividade> listarAtividades() {

        return atividades;
    }
}