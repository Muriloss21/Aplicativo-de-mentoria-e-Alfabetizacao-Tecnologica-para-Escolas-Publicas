package controller;

import model.Aluno;

public class LoginController {

    private AlunoController alunoController;

    private Aluno alunoLogado;

    // CONSTRUTOR
    public LoginController(AlunoController alunoController) {

        this.alunoController = alunoController;
    }

    // LOGIN
    public String autenticar(String email,
            String senha) {

        if (email.isEmpty() ||
                senha.isEmpty()) {

            return "Preencha todos os campos.";
        }

        for (Aluno aluno : alunoController.listarAlunos()) {

            if (aluno.getEmail()
                    .equalsIgnoreCase(email) &&

                    aluno.getSenha()
                            .equals(senha)) {

                alunoLogado = aluno;

                return "Login realizado com sucesso.";
            }
        }

        return "Email ou senha incorretos.";
    }

    // LOGOUT
    public void logout() {

        alunoLogado = null;
    }

    // USUÁRIO LOGADO
    public boolean usuarioLogado() {

        return alunoLogado != null;
    }

    // GET ALUNO LOGADO
    public Aluno getAlunoLogado() {

        return alunoLogado;
    }

    // GET CONTROLLER
    public AlunoController getAlunoController() {

        return alunoController;
    }
}