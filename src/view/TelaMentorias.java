package view;

import controller.AppController;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;

import javafx.stage.Stage;

import model.Aluno;
import model.Mentoria;

public class TelaMentorias
                extends LayoutBase {

        public TelaMentorias(AppController app) {

                super(app, null);
        }

        public void mostrar(Stage stage) {

                this.stage = stage;

                // LIMPA CONTEÚDO
                conteudo.getChildren().clear();

                // TÍTULO
                Label titulo = new Label("Mentorias");

                titulo.setFont(
                                Font.font("Arial", 34));

                conteudo.getChildren().add(titulo);

                // ALUNO LOGADO
                Aluno aluno = app.getLoginController()
                                .getAlunoLogado();

                // LISTAR MENTORIAS
                for (Mentoria mentoria : app.getMentoriaController()
                                .listarMentorias()) {

                        VBox card = criarCardMentoria(
                                        aluno,
                                        mentoria);

                        conteudo.getChildren().add(card);
                }

                // SCENE
                Scene scene = new Scene(root, 1500, 900);

                stage.setTitle("Mentorias");

                stage.setScene(scene);

                stage.show();
        }

        // CARD MENTORIA
        private VBox criarCardMentoria(Aluno aluno,
                        Mentoria mentoria) {

                VBox card = new VBox(15);

                card.setPadding(
                                new Insets(25));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 25;");

                // TEMA
                Label tema = new Label(
                                mentoria.getTema());

                tema.setFont(
                                Font.font("Arial", 28));

                // MENTOR
                Label mentor = new Label(
                                "👨‍🏫 Mentor: "
                                                + mentoria.getMentor()
                                                                .getNome());

                mentor.setStyle(
                                "-fx-font-size: 16px;");

                // HORÁRIO
                Label horario = new Label(
                                "🕒 "
                                                + mentoria.getHorario());

                horario.setStyle(
                                "-fx-font-size: 16px;");

                // VAGAS
                Label vagas = new Label(
                                "👥 Vagas restantes: "
                                                + mentoria.getVagas());

                vagas.setStyle(
                                "-fx-font-size: 16px;");

                // BOTOES
                HBox botoes = new HBox(10);

                // VERIFICA PARTICIPAÇÃO
                boolean participando = aluno.getMentoriasParticipando()
                                .contains(mentoria);

                // BOTÃO
                Button participarBtn = new Button();

                participarBtn.setPrefWidth(220);

                participarBtn.setPrefHeight(42);

                // PARTICIPANDO
                if (participando) {

                        participarBtn.setText(
                                        "❌ Cancelar Participação");

                        participarBtn.setStyle(
                                        "-fx-background-color: #dc2626;" +
                                                        "-fx-text-fill: white;" +
                                                        "-fx-font-size: 15px;" +
                                                        "-fx-font-weight: bold;" +
                                                        "-fx-background-radius: 12;");

                        // CANCELAR
                        participarBtn.setOnAction(e -> {

                                aluno.cancelarMentoria(
                                                mentoria);

                                mentoria.removerParticipante(
                                                aluno);

                                Alert alert = new Alert(
                                                Alert.AlertType.INFORMATION);

                                alert.setHeaderText(null);

                                alert.setContentText(
                                                "Participação cancelada!");

                                alert.showAndWait();

                                mostrar(stage);
                        });

                } else {

                        // SEM VAGAS
                        if (mentoria.getVagas() <= 0) {

                                participarBtn.setText(
                                                "🚫 Sem vagas");

                                participarBtn.setDisable(true);

                                participarBtn.setStyle(
                                                "-fx-background-color: #94a3b8;" +
                                                                "-fx-text-fill: white;" +
                                                                "-fx-background-radius: 12;");

                        } else {

                                participarBtn.setText(
                                                "🎓 Participar");

                                participarBtn.setStyle(
                                                "-fx-background-color: #2563eb;" +
                                                                "-fx-text-fill: white;" +
                                                                "-fx-font-size: 15px;" +
                                                                "-fx-font-weight: bold;" +
                                                                "-fx-background-radius: 12;");

                                // PARTICIPAR
                                participarBtn.setOnAction(e -> {

                                        boolean sucesso = mentoria.adicionarParticipante(
                                                        aluno);

                                        if (sucesso) {

                                                aluno.participarMentoria(
                                                                mentoria);

                                                Alert alert = new Alert(
                                                                Alert.AlertType.INFORMATION);

                                                alert.setHeaderText(null);

                                                alert.setContentText(
                                                                "Participação confirmada!");

                                                alert.showAndWait();

                                                mostrar(stage);
                                        }
                                });
                        }
                }

                botoes.getChildren().add(
                                participarBtn);

                // COMPONENTES
                card.getChildren().addAll(
                                tema,
                                mentor,
                                horario,
                                vagas,
                                botoes);

                return card;
        }
}