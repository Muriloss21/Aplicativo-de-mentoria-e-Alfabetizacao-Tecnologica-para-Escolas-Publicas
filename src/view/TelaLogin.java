package view;

import controller.AppController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.stage.Stage;

public class TelaLogin {

        private AppController app;

        public TelaLogin(AppController app) {

                this.app = app;
        }

        public void mostrar(Stage stage) {

                // ROOT
                HBox root = new HBox();

                // LADO ESQUERDO
                VBox esquerda = new VBox(20);

                esquerda.setAlignment(Pos.CENTER_LEFT);

                esquerda.setPadding(
                                new Insets(80));

                esquerda.setPrefWidth(700);

                esquerda.setStyle(
                                "-fx-background-color: #0f172a;");

                Label logo = new Label("TechEdu");

                logo.setFont(
                                Font.font("Arial", 48));

                logo.setTextFill(Color.WHITE);

                Label frase = new Label(
                                "Plataforma de Mentoria e\nAlfabetização Tecnológica 🚀");

                frase.setTextFill(Color.web("#cbd5e1"));

                frase.setFont(
                                Font.font("Arial", 24));

                esquerda.getChildren().addAll(
                                logo,
                                frase);

                // LADO DIREITO
                StackPane direita = new StackPane();

                direita.setStyle(
                                "-fx-background-color: #f8fafc;");

                direita.setPrefWidth(800);

                // CARD LOGIN
                VBox card = new VBox(20);

                card.setAlignment(Pos.CENTER);

                card.setPadding(
                                new Insets(50));

                card.setMaxWidth(450);

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 30;");

                // TÍTULO
                Label titulo = new Label("Entrar");

                titulo.setFont(
                                Font.font("Arial", 36));

                // EMAIL
                TextField campoEmail = new TextField();

                campoEmail.setPromptText("Digite seu email");

                campoEmail.setPrefHeight(50);

                campoEmail.setStyle(
                                "-fx-background-radius: 15;" +
                                                "-fx-font-size: 15px;");

                // SENHA
                PasswordField campoSenha = new PasswordField();

                campoSenha.setPromptText("Digite sua senha");

                campoSenha.setPrefHeight(50);

                campoSenha.setStyle(
                                "-fx-background-radius: 15;" +
                                                "-fx-font-size: 15px;");

                // MENSAGEM
                Label mensagem = new Label();

                // BOTÃO LOGIN
                Button entrarBtn = new Button("Entrar");

                entrarBtn.setPrefWidth(320);

                entrarBtn.setPrefHeight(52);

                entrarBtn.setStyle(
                                "-fx-background-color: #2563eb;" +
                                                "-fx-text-fill: white;" +
                                                "-fx-font-size: 16px;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-background-radius: 16;");

                // LOGIN
                entrarBtn.setOnAction(e -> {

                        String resultado = app.getLoginController()
                                        .autenticar(
                                                        campoEmail.getText(),
                                                        campoSenha.getText());

                        mensagem.setText(resultado);

                        if (resultado.equals(
                                        "Login realizado com sucesso.")) {

                                TelaDashboard dashboard = new TelaDashboard(app);

                                dashboard.mostrar(stage);
                        }
                });

                // BOTÃO CADASTRO
                Button cadastroBtn = new Button("Criar Conta");

                cadastroBtn.setPrefWidth(320);

                cadastroBtn.setPrefHeight(50);

                cadastroBtn.setStyle(
                                "-fx-background-color: #e2e8f0;" +
                                                "-fx-text-fill: #1e293b;" +
                                                "-fx-font-size: 15px;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-background-radius: 16;");

                cadastroBtn.setOnAction(e -> {

                        TelaCadastro telaCadastro = new TelaCadastro(app);

                        telaCadastro.mostrar(stage);
                });

                // COMPONENTES
                card.getChildren().addAll(
                                titulo,
                                campoEmail,
                                campoSenha,
                                entrarBtn,
                                cadastroBtn,
                                mensagem);

                direita.getChildren().add(card);

                // ROOT
                root.getChildren().addAll(
                                esquerda,
                                direita);

                // SCENE
                Scene scene = new Scene(root, 1500, 900);

                stage.setTitle("Login");

                stage.setScene(scene);

                stage.show();
        }
}