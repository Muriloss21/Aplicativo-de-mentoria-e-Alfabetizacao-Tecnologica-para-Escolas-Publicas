package controller;

import java.util.ArrayList;

import model.Aluno;
import model.Certificado;
import model.Curso;

public class CertificadoController {

    private ArrayList<Certificado> certificados;

    public CertificadoController() {
        certificados = new ArrayList<>();
    }

    // EMITIR CERTIFICADO
    public boolean emitirCertificado(Aluno aluno,
                                     Curso curso,
                                     String dataConclusao) {

        if(aluno == null ||
           curso == null ||
           dataConclusao.isEmpty()) {
            return false;
        }

        for(Certificado certificado : certificados) {

            if(certificado.getAluno().getEmail().equalsIgnoreCase(aluno.getEmail()) &&
               certificado.getCurso().getTitulo().equalsIgnoreCase(curso.getTitulo())) {
                return false;
            }
        }

        Certificado novoCertificado =
                new Certificado(aluno, curso, dataConclusao);

        certificados.add(novoCertificado);

        aluno.ganharPontos(100);

        return true;
    }

    // LISTAR TODOS OS CERTIFICADOS
    public ArrayList<Certificado> listarCertificados() {
        return certificados;
    }

    // LISTAR CERTIFICADOS DE UM ALUNO
    public ArrayList<Certificado> listarCertificadosDoAluno(Aluno aluno) {

        ArrayList<Certificado> resultado = new ArrayList<>();

        for(Certificado certificado : certificados) {

            if(certificado.getAluno().getEmail().equalsIgnoreCase(aluno.getEmail())) {
                resultado.add(certificado);
            }
        }

        return resultado;
    }
    
 // CONTAR CERTIFICADOS DE UM ALUNO
    public int contarCertificadosDoAluno(Aluno aluno) {

        if(aluno == null) {
            return 0;
        }

        int contador = 0;

        // PERCORRE TODOS OS CERTIFICADOS
        for(Certificado certificado : certificados) {

            // VERIFICA SE O CERTIFICADO PERTENCE AO ALUNO
            if(certificado.getAluno()
                    .getEmail()
                    .equalsIgnoreCase(aluno.getEmail())) {

                contador++;
            }
        }

        return contador;
    }
    
}
