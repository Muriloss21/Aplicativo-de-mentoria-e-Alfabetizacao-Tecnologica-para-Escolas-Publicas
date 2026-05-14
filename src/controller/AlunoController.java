package controller;

import java.util.ArrayList;

import model.Aluno;

public class AlunoController {

    private ArrayList<Aluno> alunos;

    public AlunoController() {

        alunos = new ArrayList<>();
    }

    // CADASTRAR ALUNO
    public String cadastrarAluno(String nome,
            String email,
            String senha) {

        if (nome.isEmpty() ||
                email.isEmpty() ||
                senha.isEmpty()) {

            return "Preencha todos os campos.";
        }

        // VERIFICAR EMAIL DUPLICADO
        for (Aluno aluno : alunos) {

            if (aluno.getEmail()
                    .equalsIgnoreCase(email)) {

                return "Email já cadastrado.";
            }
        }

        // CRIAR ALUNO
        Aluno novoAluno = new Aluno(
                nome,
                email,
                senha);

        alunos.add(novoAluno);

        return "Aluno cadastrado com sucesso.";
    }

    // LISTAR ALUNOS
    public ArrayList<Aluno> listarAlunos() {

        return alunos;
    }

    // BUSCAR ALUNO
    public Aluno buscarAlunoPorEmail(String email) {

        for (Aluno aluno : alunos) {

            if (aluno.getEmail()
                    .equalsIgnoreCase(email)) {

                return aluno;
            }
        }

        return null;
    }

    // GERAR RANKING
    public ArrayList<Aluno> gerarRanking() {

        alunos.sort((a1, a2) -> Integer.compare(
                a2.getPontos(),
                a1.getPontos()));

        return alunos;
    }
}