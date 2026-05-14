import controller.AppController;

import javafx.application.Application;
import javafx.stage.Stage;

import model.Mentor;

import view.TelaLogin;

public class Main extends Application {

        @Override
        public void start(Stage stage) {

                // APP CONTROLLER
                AppController app = new AppController();

                // DADOS TESTE

                // ALUNOS
                app.getAlunoController().cadastrarAluno(
                                "Murilo",
                                "murilo@gmail.com",
                                "123456");

                app.getAlunoController().cadastrarAluno(
                                "João",
                                "joao@gmail.com",
                                "123456");

                // CURSOS
                app.getCursoController().cadastrarCurso(
                                "Informática Básica",
                                "Aprenda fundamentos da informática.");

                app.getCursoController().cadastrarCurso(
                                "Segurança Digital",
                                "Aprenda proteção online.");

                app.getCursoController().cadastrarCurso(
                                "Pacote Office",
                                "Aprenda Word, Excel e PowerPoint.");

                // MENTOR
                Mentor mentor = new Mentor(
                                "Carlos Silva",
                                "carlos@gmail.com",
                                "123456",
                                "Tecnologia");

                // MENTORIAS
                app.getMentoriaController().agendarMentoria(
                                "Introdução à Tecnologia",
                                mentor,
                                "20/05/2026 - 14:00");

                app.getMentoriaController().agendarMentoria(
                                "Segurança Digital",
                                mentor,
                                "22/05/2026 - 16:00");

                // ABRIR LOGIN
                TelaLogin telaLogin = new TelaLogin(app);
                // ATIVIDADES
                app.getAtividadeController()
                                .cadastrarAtividade(
                                                "Quiz Java",
                                                "Responda perguntas sobre Java.",
                                                50);

                app.getAtividadeController()
                                .cadastrarAtividade(
                                                "Desafio POO",
                                                "Resolva exercícios de orientação a objetos.",
                                                100);

                app.getAtividadeController()
                                .cadastrarAtividade(
                                                "Projeto Final",
                                                "Crie um mini sistema em Java.",
                                                200);
                telaLogin.mostrar(stage);
        }

        public static void main(String[] args) {

                launch(args);
        }
}