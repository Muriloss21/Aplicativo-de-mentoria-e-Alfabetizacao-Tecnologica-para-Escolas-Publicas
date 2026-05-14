package view;

import controller.AppController;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.stage.Stage;

import model.Aluno;
import model.Curso;

public class TelaCursos
                extends LayoutBase {

        public TelaCursos(AppController app) {

                super(app, null);
        }

        public void mostrar(Stage stage) {

                this.stage = stage;

                conteudo.getChildren().clear();

                Label titulo = new Label("Cursos Disponíveis");

                titulo.setFont(
                                Font.font("Arial", 34));

                conteudo.getChildren().add(titulo);

                Aluno aluno = app.getLoginController()
                                .getAlunoLogado();

                for (Curso curso : app.getCursoController()
                                .listarCursos()) {

                        VBox card = criarCardCurso(
                                        aluno,
                                        curso);

                        conteudo.getChildren().add(card);
                }

                Scene scene = new Scene(root, 1500, 900);

                stage.setScene(scene);

                stage.show();
        }

        // CARD CURSO
        private VBox criarCardCurso(Aluno aluno,
                        Curso curso) {

                VBox card = new VBox(15);

                card.setPadding(
                                new Insets(25));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 25;");

                // TÍTULO
                Label titulo = new Label(curso.getTitulo());

                titulo.setFont(
                                Font.font("Arial", 24));

                titulo.setTextFill(
                                Color.web("#2563eb"));

                // DESCRIÇÃO
                Label descricao = new Label(curso.getDescricao());

                descricao.setStyle(
                                "-fx-font-size: 16px;");

                // BOTÕES
                HBox botoes = new HBox(10);

                // BOTÃO MATRICULAR
                Button matriculaBtn = new Button();

                matriculaBtn.setPrefHeight(40);

                // BOTÃO CONCLUIR
                Button concluirBtn = new Button("✅ Concluir");

                concluirBtn.setPrefHeight(40);

                concluirBtn.setStyle(
                                "-fx-background-color: #059669;" +
                                                "-fx-text-fill: white;" +
                                                "-fx-background-radius: 12;");

                // VERIFICAÇÕES
                boolean matriculado = aluno.getCursosMatriculados()
                                .contains(curso);

                boolean concluido = aluno.getCursosConcluidos()
                                .contains(curso);

                // CURSO CONCLUÍDO
                if (concluido) {

                        matriculaBtn.setText(
                                        "🏆 Concluído");

                        matriculaBtn.setDisable(true);

                        concluirBtn.setDisable(true);

                } else {

                        // MATRICULADO
                        if (matriculado) {

                                matriculaBtn.setText(
                                                "❌ Desmatricular");

                                matriculaBtn.setStyle(
                                                "-fx-background-color: #dc2626;" +
                                                                "-fx-text-fill: white;" +
                                                                "-fx-background-radius: 12;");

                                // DESMATRICULAR
                                matriculaBtn.setOnAction(e -> {

                                        aluno.desmatricularCurso(curso);

                                        mostrar(stage);
                                });

                                // CONCLUIR
                                concluirBtn.setOnAction(e -> {

                                        aluno.concluirCurso(curso);

                                        // CERTIFICADO
                                        app.getCertificadoController()
                                                        .emitirCertificado(
                                                                        aluno,
                                                                        curso,
                                                                        "2026");

                                        Alert alert = new Alert(
                                                        Alert.AlertType.INFORMATION);

                                        alert.setHeaderText(null);

                                        alert.setContentText(
                                                        "Curso concluído!");

                                        alert.showAndWait();

                                        mostrar(stage);
                                });

                        } else {

                                matriculaBtn.setText(
                                                "📚 Matricular");

                                matriculaBtn.setStyle(
                                                "-fx-background-color: #2563eb;" +
                                                                "-fx-text-fill: white;" +
                                                                "-fx-background-radius: 12;");

                                concluirBtn.setDisable(true);

                                // MATRICULAR
                                matriculaBtn.setOnAction(e -> {

                                        aluno.matricularCurso(curso);

                                        aluno.ganharPontos(50);

                                        mostrar(stage);
                                });
                        }
                }

                botoes.getChildren().addAll(
                                matriculaBtn,
                                concluirBtn);

                card.getChildren().addAll(
                                titulo,
                                descricao,
                                botoes);

                return card;
        }
}