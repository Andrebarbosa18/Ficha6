package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Ex3Test {

    static UC uc;

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Imprimir tudo antes:");
        ArrayList<Nota>notas = new ArrayList<>();
        uc = new UC("qs",notas,notas.size());
    }

    @ParameterizedTest
    @DisplayName("Inserir nota da uc:")
    @CsvSource (value = {"1234,15","5678,14","9874,19"})
    public void testeRegistarNota(int numAluno, double nota){
        assertTrue(uc.insereNotaUC(numAluno,nota),"nota valida");
    }

    @ParameterizedTest
    @DisplayName("Pesquisar Aluno")
    @ValueSource(ints = {42869,42856,42705,1234})
    public void testePesquisarAlunos(int numAluno){
        assertFalse(uc.pesquisaAluno(numAluno),"aluno encontrado");
    }

    @Test
    @DisplayName("Media da UC")
    public void testeMedia(){
        assertEquals(16,uc.media(),"media errada");
    }

    @ParameterizedTest
    @DisplayName("Verificar aprovação do aluno")
    public void testeAprovado(int numAluno){
        assertTrue(uc.aprovado(numAluno),"Aluno aprovado");
    }
}
