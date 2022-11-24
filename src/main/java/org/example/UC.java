package org.example;

import java.util.ArrayList;

public class UC {

        private String nomeUC;
        private ArrayList<Nota>notas;
        private int totalAlunos;

    public UC(String nomeUC, ArrayList<Nota> notas, int totalAlunos) {
        this.nomeUC = nomeUC;
        notas = new ArrayList<Nota>();
        this.totalAlunos = totalAlunos;
    }

    public String getNomeUC() {
        return nomeUC;
    }

    public void setNomeUC(String nomeUC) {
        this.nomeUC = nomeUC;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public int getTotalNotas(){
        return notas.size();
    }

    /**
     * metodo para inserir nota
     * @param numAluno
     * @param nota
     */
    public boolean insereNotaUC(int numAluno, double nota){
        if(nota>=0 && nota<=20){
            Nota novaNota = new Nota(numAluno, nota);
            notas.add(novaNota);
            return true;
        }
        return false;
    }

    /**
     * metodo pesquisa aluno
     * @param numAluno
     */
    public boolean pesquisaAluno(int numAluno){
        for(int i = 0; i<notas.size();i++){
            if(numAluno == notas.get(i).getNumAluno()){
                return true;
            }
        }
        return false;
    }

    /**
     * metodo media
     */
    public double media(){
        double soma = 0;
        for (int i = 0; i<notas.size();i++){
            soma+=notas.get(i).getNota();
        }
        double media=soma/notas.size();
        return media;
    }

    /**
     * metodo aprovado
     * @param numAluno
     */
    public boolean aprovado(int numAluno){
        for (int i = 0; i<notas.size();i++){
            if(numAluno == notas.get(i).getNota()){
                if (notas.get(i).getNota()>=9.5){
                    return true;
                }
            }
        }
        return false;
    }
}
