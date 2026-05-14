package model;

import java.util.ArrayList;

public class Aluno extends Usuario {

    private int nivel;

    private int pontos;

    // CURSOS
    private ArrayList<Curso> cursosMatriculados;

    private ArrayList<Curso> cursosConcluidos;

    // MENTORIAS
    private ArrayList<Mentoria> mentoriasParticipando;

    // PERFIL
    private String avatar;

    private String bio;

    // CONSTRUTOR
    public Aluno(String nome,
            String email,
            String senha) {

        super(nome, email, senha, "Aluno");

        this.nivel = 1;

        this.pontos = 0;

        cursosMatriculados = new ArrayList<>();

        cursosConcluidos = new ArrayList<>();

        mentoriasParticipando = new ArrayList<>();

        this.avatar = "👨‍💻";

        this.bio = "Aluno da plataforma TechEdu";
    }

    // GET NÍVEL
    public int getNivel() {

        return nivel;
    }

    // GET PONTOS
    public int getPontos() {

        return pontos;
    }

    // GET CURSOS MATRICULADOS
    public ArrayList<Curso> getCursosMatriculados() {

        return cursosMatriculados;
    }

    // GET CURSOS CONCLUÍDOS
    public ArrayList<Curso> getCursosConcluidos() {

        return cursosConcluidos;
    }

    // GET MENTORIAS
    public ArrayList<Mentoria> getMentoriasParticipando() {

        return mentoriasParticipando;
    }

    // GET AVATAR
    public String getAvatar() {

        return avatar;
    }

    // SET AVATAR
    public void setAvatar(String avatar) {

        this.avatar = avatar;
    }

    // GET BIO
    public String getBio() {

        return bio;
    }

    // SET BIO
    public void setBio(String bio) {

        this.bio = bio;
    }

    // MATRICULAR CURSO
    public void matricularCurso(Curso curso) {

        if (!cursosMatriculados.contains(curso)) {

            cursosMatriculados.add(curso);
        }
    }

    // DESMATRICULAR CURSO
    public void desmatricularCurso(Curso curso) {

        cursosMatriculados.remove(curso);
    }

    // CONCLUIR CURSO
    public void concluirCurso(Curso curso) {

        if (cursosMatriculados.contains(curso) &&
                !cursosConcluidos.contains(curso)) {

            cursosConcluidos.add(curso);

            ganharPontos(100);
        }
    }

    // PARTICIPAR MENTORIA
    public void participarMentoria(
            Mentoria mentoria) {

        if (!mentoriasParticipando
                .contains(mentoria)) {

            mentoriasParticipando
                    .add(mentoria);

            ganharPontos(30);
        }
    }

    // CANCELAR MENTORIA
    public void cancelarMentoria(
            Mentoria mentoria) {

        mentoriasParticipando
                .remove(mentoria);
    }

    // GANHAR PONTOS
    public void ganharPontos(int pontos) {

        if (pontos > 0) {

            this.pontos += pontos;

            atualizarNivel();
        }
    }

    // ATUALIZAR NÍVEL
    private void atualizarNivel() {

        if (pontos >= 500) {

            nivel = 5;

        } else if (pontos >= 400) {

            nivel = 4;

        } else if (pontos >= 300) {

            nivel = 3;

        } else if (pontos >= 200) {

            nivel = 2;

        } else {

            nivel = 1;
        }
    }
}