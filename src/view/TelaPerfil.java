package view;

import controller.AppController;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.stage.Stage;

import model.Aluno;

public class TelaPerfil
        extends LayoutBase {

    public TelaPerfil(AppController app) {

        super(app, null);
    }

    public void mostrar(Stage stage) {

        this.stage = stage;

        conteudo.getChildren().clear();

        // ALUNO
        Aluno aluno = app.getLoginController()
                .getAlunoLogado();

        // TÍTULO
        Label titulo = new Label("Meu Perfil");

        titulo.setFont(
                Font.font("Arial", 36));

        // CARD PERFIL
        VBox perfilCard = criarCardPerfil(aluno);

        // ESTATÍSTICAS
        HBox estatisticas = new HBox(20);

        estatisticas.getChildren().addAll(

                criarCardInfo(
                        "📚 Cursos",
                        String.valueOf(
                                aluno.getCursosMatriculados()
                                        .size()),
                        "#2563eb"),

                criarCardInfo(
                        "🏆 Concluídos",
                        String.valueOf(
                                aluno.getCursosConcluidos()
                                        .size()),
                        "#059669"),

                criarCardInfo(
                        "🎓 Mentorias",
                        String.valueOf(
                                aluno.getMentoriasParticipando()
                                        .size()),
                        "#7c3aed"),

                criarCardInfo(
                        "📜 Certificados",
                        String.valueOf(
                                app.getCertificadoController()
                                        .contarCertificadosDoAluno(
                                                aluno)),
                        "#ea580c"));

        // COMPONENTES
        conteudo.getChildren().addAll(
                titulo,
                perfilCard,
                estatisticas);

        // SCENE
        Scene scene = new Scene(root, 1500, 900);

        stage.setScene(scene);

        stage.show();
    }

    // CARD PERFIL
    private VBox criarCardPerfil(
            Aluno aluno) {

        VBox card = new VBox(18);

        card.setPadding(
                new Insets(30));

        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 25;");

        // AVATAR
        Label avatar = new Label(
                aluno.getAvatar());

        avatar.setFont(
                Font.font(70));

        // BOTÃO ALTERAR AVATAR
        Button avatarBtn = new Button(
                "Alterar Avatar");

        avatarBtn.setStyle(
                "-fx-background-color: #2563eb;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 12;");

        avatarBtn.setOnAction(e -> {

            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle(
                    "Avatar");

            dialog.setHeaderText(
                    "Digite um emoji");

            dialog.setContentText(
                    "Exemplo: 😎 👨‍💻 🚀");

            dialog.showAndWait()
                    .ifPresent(novoAvatar -> {

                        aluno.setAvatar(
                                novoAvatar);

                        mostrar(stage);
                    });
        });

        // NOME
        Label nome = new Label(
                aluno.getNome());

        nome.setFont(
                Font.font("Arial", 32));

        // EMAIL
        Label email = new Label(
                "📧 "
                        + aluno.getEmail());

        email.setStyle(
                "-fx-font-size: 18px;");

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

        // BIO
        Label bioLabel = new Label(
                "📝 Biografia");

        bioLabel.setFont(
                Font.font(22));

        TextArea bioArea = new TextArea(
                aluno.getBio());

        bioArea.setWrapText(true);

        bioArea.setPrefHeight(120);

        bioArea.setStyle(
                "-fx-background-radius: 15;");

        // SALVAR BIO
        Button salvarBio = new Button(
                "Salvar Biografia");

        salvarBio.setStyle(
                "-fx-background-color: #059669;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 12;");

        salvarBio.setOnAction(e -> {

            aluno.setBio(
                    bioArea.getText());

            Alert alert = new Alert(
                    Alert.AlertType.INFORMATION);

            alert.setHeaderText(null);

            alert.setContentText(
                    "Biografia atualizada!");

            alert.showAndWait();
        });

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
                Font.font(24));

        // COMPONENTES
        card.getChildren().addAll(
                avatar,
                avatarBtn,
                nome,
                email,
                pontos,
                nivel,
                status,
                bioLabel,
                bioArea,
                salvarBio);

        return card;
    }

    // CARD INFO
    private VBox criarCardInfo(String titulo,
            String valor,
            String cor) {

        VBox card = new VBox(10);

        card.setPadding(
                new Insets(25));

        card.setPrefWidth(220);

        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 25;");

        Label tituloLabel = new Label(titulo);

        tituloLabel.setStyle(
                "-fx-font-size: 17px;");

        Label valorLabel = new Label(valor);

        valorLabel.setFont(
                Font.font("Arial", 36));

        valorLabel.setTextFill(
                Color.web(cor));

        card.getChildren().addAll(
                tituloLabel,
                valorLabel);

        return card;
    }
}