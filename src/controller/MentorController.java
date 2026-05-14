package controller;

import utils.Validador;

import java.util.ArrayList;
import model.Mentor;

public class MentorController {

    private ArrayList<Mentor> mentores;

    public MentorController() {
        mentores = new ArrayList<>();
    }

    public String cadastrarMentor(String nome,
            String email,
            String senha,
            String especialidade) {

        if (!Validador.nomeValido(nome)) {
            return "Nome inválido. O nome deve ter pelo menos 3 caracteres.";
        }

        if (!Validador.emailValido(email)) {
            return "Email inválido.";
        }

        if (!Validador.senhaValida(senha)) {
            return "Senha inválida. A senha deve ter no mínimo 6 caracteres.";
        }

        if (especialidade == null || especialidade.isEmpty()) {
            return "Especialidade inválida.";
        }

        for (Mentor mentor : mentores) {

            if (mentor.getEmail().equalsIgnoreCase(email)) {
                return "Email já cadastrado.";
            }
        }

        Mentor novoMentor = new Mentor(nome, email, senha, especialidade);

        mentores.add(novoMentor);

        return "Mentor cadastrado com sucesso.";
    }

    public Mentor buscarMentorPorEmail(String email) {

        for (Mentor mentor : mentores) {
            if (mentor.getEmail().equalsIgnoreCase(email)) {
                return mentor;
            }
        }

        return null;
    }

    public ArrayList<Mentor> listarMentores() {
        return mentores;
    }
}
