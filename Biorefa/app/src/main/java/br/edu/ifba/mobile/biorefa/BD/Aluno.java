package br.edu.ifba.mobile.biorefa.BD;

/**
 * Created by Romen on 22/06/2016.
 */
public class Aluno {
    private long codigoAluno= -1;
    private String nomeAluno;
    private String professor;
    private String escola;
    private String materia;
    private String serieTurma;
    private String turno;


    public long getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(long codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSerieTurma() {
        return serieTurma;
    }

    public void setSerieTurma(String serieTurma) {
        this.serieTurma = serieTurma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }



}
