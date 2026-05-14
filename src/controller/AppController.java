package controller;

public class AppController {

    private AlunoController alunoController;

    private CursoController cursoController;

    private MentoriaController mentoriaController;

    private AtividadeController atividadeController;

    private CertificadoController certificadoController;

    private LoginController loginController;

    // CONSTRUTOR
    public AppController() {

        alunoController = new AlunoController();

        cursoController = new CursoController();

        mentoriaController = new MentoriaController();

        atividadeController = new AtividadeController();

        certificadoController = new CertificadoController();

        loginController = new LoginController(
                alunoController);
    }

    // GET ALUNO
    public AlunoController getAlunoController() {

        return alunoController;
    }

    // GET CURSO
    public CursoController getCursoController() {

        return cursoController;
    }

    // GET MENTORIA
    public MentoriaController getMentoriaController() {

        return mentoriaController;
    }

    // GET ATIVIDADE
    public AtividadeController getAtividadeController() {

        return atividadeController;
    }

    // GET CERTIFICADO
    public CertificadoController getCertificadoController() {

        return certificadoController;
    }

    // GET LOGIN
    public LoginController getLoginController() {

        return loginController;
    }
}