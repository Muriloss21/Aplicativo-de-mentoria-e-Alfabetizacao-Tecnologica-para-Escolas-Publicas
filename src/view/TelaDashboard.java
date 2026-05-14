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

public class TelaDashboard
                extends LayoutBase {

        public TelaDashboard(AppController app) {

                super(app, null);
        }

        public void mostrar(Stage stage) {

                this.stage = stage;

                // LIMPA CONTEÚDO
                conteudo.getChildren().clear();

                // TÍTULO
                Label titulo = new Label("Dashboard");

                titulo.setFont(
                                Font.font("Arial", 34));

                Label subtitulo = new Label(
                                "Bem-vindo ao TechEdu 🚀");

                subtitulo.setStyle(
                                "-fx-font-size: 18px;" +
                                                "-fx-text-fill: #64748b;");

                // CARDS
                HBox linhaCards = new HBox(25);

                VBox cardCursos = criarCardInfo(
                                "📚 Cursos",
                                String.valueOf(
                                                app.getCursoController()
                                                                .listarCursos()
                                                                .size()),
                                "#2563eb");

                VBox cardMentorias = criarCardInfo(
                                "🎓 Mentorias",
                                String.valueOf(
                                                app.getMentoriaController()
                                                                .listarMentorias()
                                                                .size()),
                                "#7c3aed");

                VBox cardAlunos = criarCardInfo(
                                "👨‍🎓 Alunos",
                                String.valueOf(
                                                app.getAlunoController()
                                                                .listarAlunos()
                                                                .size()),
                                "#059669");

                linhaCards.getChildren().addAll(
                                cardCursos,
                                cardMentorias,
                                cardAlunos);

                // ÁREA DE ATIVIDADE
                VBox atividadesCard = new VBox(18);

                atividadesCard.setPadding(
                                new Insets(30));

                atividadesCard.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 25;");

                Label atividadesTitulo = new Label("Atividades Recentes");

                atividadesTitulo.setFont(
                                Font.font("Arial", 24));

                Label atividade1 = criarAtividade(
                                "✅ Novo curso adicionado.");

                Label atividade2 = criarAtividade(
                                "🎓 Mentoria agendada.");

                Label atividade3 = criarAtividade(
                                "🏆 Ranking atualizado.");

                atividadesCard.getChildren().addAll(
                                atividadesTitulo,
                                atividade1,
                                atividade2,
                                atividade3);

                // ÁREA PERFIL
                VBox perfilCard = new VBox(15);

                perfilCard.setPadding(
                                new Insets(30));

                perfilCard.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 25;");

                Label perfilTitulo = new Label("Seu Perfil");

                perfilTitulo.setFont(
                                Font.font("Arial", 24));

                String nomeUsuario = "Usuário";

                if (app.getLoginController()
                                .getAlunoLogado() != null) {

                        nomeUsuario = app.getLoginController()
                                        .getAlunoLogado()
                                        .getNome();
                }

                Label nome = new Label(
                                "👤 Nome: " + nomeUsuario);

                nome.setStyle(
                                "-fx-font-size: 18px;");

                Label sistema = new Label(
                                "💻 Plataforma de Mentoria");

                sistema.setStyle(
                                "-fx-font-size: 18px;");

                perfilCard.getChildren().addAll(
                                perfilTitulo,
                                nome,
                                sistema);

                // ADICIONA COMPONENTES
                conteudo.getChildren().addAll(
                                titulo,
                                subtitulo,
                                linhaCards,
                                atividadesCard,
                                perfilCard);

                // SCENE
                Scene scene = new Scene(root, 1500, 900);

                stage.setTitle("Dashboard");

                stage.setScene(scene);

                stage.show();
        }

        // CARD INFO
        private VBox criarCardInfo(String titulo,
                        String valor,
                        String cor) {

                VBox card = new VBox(12);

                card.setPadding(
                                new Insets(25));

                card.setPrefWidth(280);

                card.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 25;");

                Label tituloLabel = new Label(titulo);

                tituloLabel.setStyle(
                                "-fx-font-size: 18px;" +
                                                "-fx-text-fill: #64748b;");

                Label valorLabel = new Label(valor);

                valorLabel.setFont(
                                Font.font("Arial", 40));

                valorLabel.setTextFill(
                                Color.web(cor));

                card.getChildren().addAll(
                                tituloLabel,
                                valorLabel);

                return card;
        }

        // ATIVIDADE
        private Label criarAtividade(String texto) {

                Label atividade = new Label(texto);

                atividade.setStyle(
                                "-fx-font-size: 17px;" +
                                                "-fx-background-color: #f1f5f9;" +
                                                "-fx-padding: 15;" +
                                                "-fx-background-radius: 15;");

                return atividade;
        }
}