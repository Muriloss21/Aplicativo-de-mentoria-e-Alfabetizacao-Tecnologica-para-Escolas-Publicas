package view;

import controller.AppController;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.stage.Stage;

import model.Aluno;

public class TelaRanking
                extends LayoutBase {

        public TelaRanking(AppController app) {

                super(app, null);
        }

        public void mostrar(Stage stage) {

                this.stage = stage;

                // LIMPA
                conteudo.getChildren().clear();

                // TÍTULO
                Label titulo = new Label("🏆 Ranking Global");

                titulo.setFont(
                                Font.font("Arial", 36));

                conteudo.getChildren().add(titulo);

                // POSIÇÃO
                int posicao = 1;

                // LISTA
                for (Aluno aluno : app.getAlunoController()
                                .gerarRanking()) {

                        VBox card = criarCardRanking(
                                        aluno,
                                        posicao);

                        conteudo.getChildren().add(card);

                        posicao++;
                }

                // SCENE
                Scene scene = new Scene(root, 1500, 900);

                stage.setScene(scene);

                stage.show();
        }

        // CARD
        private VBox criarCardRanking(
                        Aluno aluno,
                        int posicao) {

                VBox card = new VBox(15);

                card.setPadding(
                                new Insets(25));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 25;");

                // LINHA TOP
                HBox linhaTop = new HBox(20);

                // POSIÇÃO
                Label ranking = new Label();

                ranking.setFont(
                                Font.font("Arial", 26));

                // CORES TOP 3
                if (posicao == 1) {

                        ranking.setText("🥇");

                } else if (posicao == 2) {

                        ranking.setText("🥈");

                } else if (posicao == 3) {

                        ranking.setText("🥉");

                } else {

                        ranking.setText(
                                        "#" + posicao);
                }

                // NOME
                Label nome = new Label(
                                aluno.getNome());

                nome.setFont(
                                Font.font("Arial", 28));

                linhaTop.getChildren().addAll(
                                ranking,
                                nome);

                // PONTOS
                Label pontos = new Label(
                                "🏆 "
                                                + aluno.getPontos()
                                                + " pontos");

                pontos.setStyle(
                                "-fx-font-size: 18px;");

                // NÍVEL
                Label nivel = new Label(
                                "⭐ Nível "
                                                + aluno.getNivel());

                nivel.setStyle(
                                "-fx-font-size: 18px;");

                // STATUS
                Label status = new Label();

                if (aluno.getPontos() >= 500) {

                        status.setText(
                                        "👑 Mestre Tech");

                        status.setTextFill(
                                        Color.GOLD);

                } else if (aluno.getPontos() >= 300) {

                        status.setText(
                                        "🔥 Avançado");

                        status.setTextFill(
                                        Color.ORANGE);

                } else {

                        status.setText(
                                        "🚀 Iniciante");

                        status.setTextFill(
                                        Color.web("#2563eb"));
                }

                status.setFont(
                                Font.font("Arial", 18));

                // COMPONENTES
                card.getChildren().addAll(
                                linhaTop,
                                pontos,
                                nivel,
                                status);

                return card;
        }
}