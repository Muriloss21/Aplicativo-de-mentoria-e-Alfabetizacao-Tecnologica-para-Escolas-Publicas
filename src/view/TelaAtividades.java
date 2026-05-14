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
import model.Atividade;

public class TelaAtividades
                extends LayoutBase {

        public TelaAtividades(AppController app) {

                super(app, null);
        }

        public void mostrar(Stage stage) {

                this.stage = stage;

                conteudo.getChildren().clear();

                // TÍTULO
                Label titulo = new Label("Atividades");

                titulo.setFont(
                                Font.font("Arial", 34));

                conteudo.getChildren().add(titulo);

                // ALUNO
                Aluno aluno = app.getLoginController()
                                .getAlunoLogado();

                // LISTA
                for (Atividade atividade : app.getAtividadeController()
                                .listarAtividades()) {

                        VBox card = criarCardAtividade(
                                        aluno,
                                        atividade);

                        conteudo.getChildren().add(card);
                }

                // SCENE
                Scene scene = new Scene(root, 1500, 900);

                stage.setScene(scene);

                stage.show();
        }

        // CARD
        private VBox criarCardAtividade(
                        Aluno aluno,
                        Atividade atividade) {

                VBox card = new VBox(15);

                card.setPadding(
                                new Insets(25));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 25;");

                // TITULO
                Label titulo = new Label(
                                atividade.getTitulo());

                titulo.setFont(
                                Font.font("Arial", 26));

                titulo.setTextFill(
                                Color.web("#2563eb"));

                // DESCRIÇÃO
                Label descricao = new Label(
                                atividade.getDescricao());

                descricao.setStyle(
                                "-fx-font-size: 16px;");

                // PONTOS
                Label pontos = new Label(
                                "🏆 "
                                                + atividade.getPontos()
                                                + " pontos");

                pontos.setStyle(
                                "-fx-font-size: 16px;");

                // BOTOES
                HBox botoes = new HBox(10);

                // BOTAO
                Button concluirBtn = new Button();

                concluirBtn.setPrefWidth(200);

                concluirBtn.setPrefHeight(42);

                // CONCLUÍDA
                if (atividade.isConcluida()) {

                        concluirBtn.setText(
                                        "✅ Concluída");

                        concluirBtn.setDisable(true);

                        concluirBtn.setStyle(
                                        "-fx-background-color: #059669;" +
                                                        "-fx-text-fill: white;" +
                                                        "-fx-background-radius: 12;");

                } else {

                        concluirBtn.setText(
                                        "📝 Concluir Atividade");

                        concluirBtn.setStyle(
                                        "-fx-background-color: #2563eb;" +
                                                        "-fx-text-fill: white;" +
                                                        "-fx-font-size: 15px;" +
                                                        "-fx-font-weight: bold;" +
                                                        "-fx-background-radius: 12;");

                        // CONCLUIR
                        concluirBtn.setOnAction(e -> {

                                atividade.concluir();

                                aluno.ganharPontos(
                                                atividade.getPontos());

                                Alert alert = new Alert(
                                                Alert.AlertType.INFORMATION);

                                alert.setHeaderText(null);

                                alert.setContentText(
                                                "Atividade concluída!");

                                alert.showAndWait();

                                mostrar(stage);
                        });
                }

                botoes.getChildren().add(
                                concluirBtn);

                // COMPONENTES
                card.getChildren().addAll(
                                titulo,
                                descricao,
                                pontos,
                                botoes);

                return card;
        }
}