package controller;

import java.util.ArrayList;

import model.Mentor;
import model.Mentoria;

public class MentoriaController {

    private ArrayList<Mentoria> mentorias;

    public MentoriaController() {

        mentorias = new ArrayList<>();
    }

    // AGENDAR
    public void agendarMentoria(String tema,
            Mentor mentor,
            String horario) {

        Mentoria mentoria = new Mentoria(
                tema,
                mentor,
                horario);

        mentorias.add(mentoria);
    }

    // LISTAR
    public ArrayList<Mentoria> listarMentorias() {

        return mentorias;
    }
}