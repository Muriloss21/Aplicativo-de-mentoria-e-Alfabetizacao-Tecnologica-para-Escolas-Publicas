package model;

import java.util.ArrayList;

public class Mentoria {

    private String tema;

    private Mentor mentor;

    private String horario;

    private int vagas;

    private ArrayList<Aluno> participantes;

    // CONSTRUTOR
    public Mentoria(String tema,
            Mentor mentor,
            String horario) {

        this.tema = tema;

        this.mentor = mentor;

        this.horario = horario;

        this.vagas = 10;

        participantes = new ArrayList<>();
    }

    // GET TEMA
    public String getTema() {

        return tema;
    }

    // GET MENTOR
    public Mentor getMentor() {

        return mentor;
    }

    // GET HORÁRIO
    public String getHorario() {

        return horario;
    }

    // GET VAGAS
    public int getVagas() {

        return vagas;
    }

    // GET PARTICIPANTES
    public ArrayList<Aluno> getParticipantes() {

        return participantes;
    }

    // PARTICIPAR
    public boolean adicionarParticipante(
            Aluno aluno) {

        if (vagas > 0 &&
                !participantes.contains(aluno)) {

            participantes.add(aluno);

            vagas--;

            return true;
        }

        return false;
    }

    // CANCELAR
    public void removerParticipante(
            Aluno aluno) {

        if (participantes.remove(aluno)) {

            vagas++;
        }
    }
}