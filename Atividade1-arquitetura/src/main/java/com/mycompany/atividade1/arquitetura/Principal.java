package com.mycompany.atividade1.arquitetura;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Principal {
    // Troca de lista de Strings por lista Alunos.
    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    // Nome intuitivo
    private static String nomeAluno;

    public static void main(String[] args) {
        // Constantes intuitivas
        int SAIR = 3;
        int opcao = 0;   

        // Inicializando Scanner
        Scanner read = new Scanner(System.in);

        while(opcao != SAIR) {
            System.out.println("Bem vindo ao sistema de ...");
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Listar alunos cadastrados");
            System.out.println("[3] Sair");

            opcao = Integer.parseInt(read.nextLine());

            switch(opcao) {
                case 1:
                    System.out.println("Digite o nome do aluno: ");
                    nomeAluno = read.nextLine().toString();
                    cadastrarAluno(nomeAluno);
                    break;
                case 2:
                    imprimeLista();
                    break;
                }
            }
        }

    // Modularizando função de cadastro de aluno
    private static void cadastrarAluno(String nomeAluno){
        if(alunoCadastrado(nomeAluno)){
            System.out.println("Aluno já cadastrado");
        }else{
            listaAlunos.add(new Aluno(nomeAluno));
            System.out.println("Cadastro de "+nomeAluno+" realizado com sucesso!");
        }
    }

    // Modularizando função verificação de cadastro
    private static Boolean alunoCadastrado(String nomeAluno){
        for(Aluno aluno : listaAlunos){
            if(aluno.getName().equals(nomeAluno)){
                return true;
            }
        }
        return false;
    }

    // Modularizando função listagem de alunos
    private static void imprimeLista(){
        System.out.println("---LISTA DE ALUNOS---");
        for(Aluno aluno : listaAlunos){
            System.out.println(aluno.getName());
        }
        System.out.println("---------------------");
    }
}
