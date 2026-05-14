package controller;

import java.util.ArrayList;

import model.Curso;

public class CursoController {

    private ArrayList<Curso> cursos;

    public CursoController() {

        cursos = new ArrayList<>();
    }

    // CADASTRAR CURSO
    public void cadastrarCurso(String titulo,
            String descricao) {

        Curso curso = new Curso(
                titulo,
                descricao);

        cursos.add(curso);
    }

    // LISTAR CURSOS
    public ArrayList<Curso> listarCursos() {

        return cursos;
    }
}