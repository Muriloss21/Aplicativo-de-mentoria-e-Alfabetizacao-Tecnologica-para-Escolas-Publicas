package view;

import controller.AppController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.stage.Stage;

public class LayoutBase {

    protected AppController app;

    protected BorderPane root;

    protected VBox conteudo;

    protected Stage stage;

    // CONSTRUTOR
    public LayoutBase(AppController app,
            Stage stage) {

        this.app = app;

        this.stage = stage;

        criarLayout();
    }

    // LAYOUT PRINCIPAL
    private void criarLayout() {

        root = new BorderPane();

        root.setStyle(
                "-fx-background-color: #f8fafc;");

        // =========================
        // SIDEBAR
        // =========================

        VBox sidebar = new VBox(18);

        sidebar.setPadding(
                new Insets(30));

        sidebar.setPrefWidth(260);

        sidebar.setStyle(
                "-fx-background-color: #0f172a;");

        // LOGO
        Label logo = new Label("TechEdu");

        logo.setFont(
                Font.font("Arial", 34));

        logo.setTextFill(Color.WHITE);

        // SUBTEXTO
        Label subtitulo = new Label(
                "Painel Educacional");

        subtitulo.setTextFill(
                Color.web("#94a3b8"));

        subtitulo.setFont(
                Font.font(14));

        // BOTÕES MENU

        Button dashboardBtn = criarBotao("🏠 Dashboard");

        Button cursosBtn = criarBotao("📚 Cursos");

        Button mentoriasBtn = criarBotao("🎓 Mentorias");

        Button atividadesBtn = criarBotao("📝 Atividades");

        Button rankingBtn = criarBotao("🏆 Ranking");

        Button perfilBtn = criarBotao("👤 Perfil");

        Button certificadosBtn = criarBotao("📜 Certificados");

        // AÇÕES

        dashboardBtn.setOnAction(e -> {

            new TelaDashboard(app)
                    .mostrar(stage);
        });

        cursosBtn.setOnAction(e -> {

            new TelaCursos(app)
                    .mostrar(stage);
        });

        mentoriasBtn.setOnAction(e -> {

            new TelaMentorias(app)
                    .mostrar(stage);
        });

        atividadesBtn.setOnAction(e -> {

            new TelaAtividades(app)
                    .mostrar(stage);
        });

        rankingBtn.setOnAction(e -> {

            new TelaRanking(app)
                    .mostrar(stage);
        });

        perfilBtn.setOnAction(e -> {

            new TelaPerfil(app)
                    .mostrar(stage);
        });

        certificadosBtn.setOnAction(e -> {

            new TelaCertificados(app)
                    .mostrar(stage);
        });

        // ESPAÇADOR
        Region espacador = new Region();

        VBox.setVgrow(
                espacador,
                Priority.ALWAYS);

        // LOGOUT
        Button logoutBtn = criarBotao("🚪 Logout");

        logoutBtn.setStyle(
                "-fx-background-color: #dc2626;" +
                        "-fx-background-radius: 18;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;");

        logoutBtn.setOnAction(e -> {

            app.getLoginController()
                    .logout();

            new TelaLogin(app)
                    .mostrar(stage);
        });

        // SIDEBAR COMPONENTES
        sidebar.getChildren().addAll(
                logo,
                subtitulo,

                dashboardBtn,
                cursosBtn,
                mentoriasBtn,
                atividadesBtn,
                rankingBtn,
                perfilBtn,
                certificadosBtn,

                espacador,

                logoutBtn);

        // =========================
        // CONTEÚDO
        // =========================

        conteudo = new VBox(25);

        conteudo.setPadding(
                new Insets(40));

        root.setLeft(sidebar);

        root.setCenter(conteudo);
    }

    // BOTÃO PADRÃO
    protected Button criarBotao(String texto) {

        Button btn = new Button(texto);

        btn.setPrefWidth(210);

        btn.setPrefHeight(52);

        btn.setAlignment(Pos.CENTER_LEFT);

        btn.setStyle(
                "-fx-background-color: #1e293b;" +
                        "-fx-background-radius: 18;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;");

        // HOVER
        btn.setOnMouseEntered(e -> {

            btn.setStyle(
                    "-fx-background-color: #2563eb;" +
                            "-fx-background-radius: 18;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 16px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-cursor: hand;");
        });

        btn.setOnMouseExited(e -> {

            btn.setStyle(
                    "-fx-background-color: #1e293b;" +
                            "-fx-background-radius: 18;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 16px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-cursor: hand;");
        });

        return btn;
    }

    // GET ROOT
    public BorderPane getRoot() {

        return root;
    }

    // GET CONTEÚDO
    public VBox getConteudo() {

        return conteudo;
    }
}