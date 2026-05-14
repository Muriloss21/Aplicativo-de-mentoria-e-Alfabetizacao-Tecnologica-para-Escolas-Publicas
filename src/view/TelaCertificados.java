package view;

import controller.AppController;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.stage.Stage;

import model.Aluno;
import model.Certificado;

public class TelaCertificados
                extends LayoutBase {

        public TelaCertificados(AppController app) {

                super(app, null);
        }

        public void mostrar(Stage stage) {

                this.stage = stage;

                // LIMPA
                conteudo.getChildren().clear();

                // TÍTULO
                Label titulo = new Label("Certificados");

                titulo.setFont(
                                Font.font("Arial", 36));

                conteudo.getChildren().add(titulo);

                // ALUNO
                Aluno aluno = app.getLoginController()
                                .getAlunoLogado();

                // CERTIFICADOS
                var certificados = app.getCertificadoController()
                                .listarCertificadosDoAluno(
                                                aluno);

                // SEM CERTIFICADOS
                if (certificados.isEmpty()) {

                        VBox vazio = new VBox(15);

                        vazio.setPadding(
                                        new Insets(40));

                        vazio.setStyle(
                                        "-fx-background-color: white;" +
                                                        "-fx-background-radius: 25;");

                        Label emoji = new Label("📜");

                        emoji.setFont(
                                        Font.font(60));

                        Label texto = new Label(
                                        "Você ainda não possui certificados.");

                        texto.setFont(
                                        Font.font("Arial", 24));

                        texto.setTextFill(
                                        Color.GRAY);

                        Label dica = new Label(
                                        "Conclua cursos para desbloquear certificados.");

                        dica.setStyle(
                                        "-fx-font-size: 18px;");

                        vazio.getChildren().addAll(
                                        emoji,
                                        texto,
                                        dica);

                        conteudo.getChildren().add(vazio);

                } else {

                        // LISTAR CERTIFICADOS
                        for (Certificado certificado : certificados) {

                                VBox card = criarCardCertificado(
                                                certificado);

                                conteudo.getChildren().add(card);
                        }
                }

                // SCENE
                Scene scene = new Scene(root, 1500, 900);

                stage.setScene(scene);

                stage.show();
        }

        // CARD CERTIFICADO
        private VBox criarCardCertificado(
                        Certificado certificado) {

                VBox card = new VBox(15);

                card.setPadding(
                                new Insets(30));

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 25;" +
                                                "-fx-border-color: #e2e8f0;" +
                                                "-fx-border-radius: 25;");

                // SELO
                Label selo = new Label("🏆");

                selo.setFont(
                                Font.font(60));

                // NOME CURSO
                Label curso = new Label(
                                certificado.getNomeCurso());

                curso.setFont(
                                Font.font("Arial", 30));

                curso.setTextFill(
                                Color.web("#2563eb"));

                // ALUNO
                Label aluno = new Label(
                                "👨‍🎓 "
                                                + certificado.getNomeAluno());

                aluno.setStyle(
                                "-fx-font-size: 18px;");

                // DATA
                Label data = new Label(
                                "📅 Conclusão: "
                                                + certificado.getDataConclusao());

                data.setStyle(
                                "-fx-font-size: 18px;");

                // STATUS
                Label status = new Label(
                                "✅ Certificado Emitido");

                status.setTextFill(
                                Color.web("#059669"));

                status.setFont(
                                Font.font("Arial", 18));

                // COMPONENTES
                card.getChildren().addAll(
                                selo,
                                curso,
                                aluno,
                                data,
                                status);

                return card;
        }
}