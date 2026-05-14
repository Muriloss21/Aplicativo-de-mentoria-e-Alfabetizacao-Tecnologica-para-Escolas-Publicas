package model;

public class Certificado {

    private Aluno aluno;

    private Curso curso;

    private String dataConclusao;

    // CONSTRUTOR
    public Certificado(Aluno aluno,
            Curso curso,
            String dataConclusao) {

        this.aluno = aluno;

        this.curso = curso;

        this.dataConclusao = dataConclusao;
    }

    // GET ALUNO
    public Aluno getAluno() {

        return aluno;
    }

    // GET CURSO
    public Curso getCurso() {

        return curso;
    }

    // GET DATA
    public String getDataConclusao() {

        return dataConclusao;
    }

    // GET NOME ALUNO
    public String getNomeAluno() {

        return aluno.getNome();
    }

    // GET NOME CURSO
    public String getNomeCurso() {

        return curso.getTitulo();
    }
}