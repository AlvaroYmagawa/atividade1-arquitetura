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

    public static void main(final String[] args) {
        // Constantes intuitivas
        int SAIR = 1;
        int opcao = 0;   

        // Inicializando Scanner

        final Scanner read = new Scanner(System.in);
       


        //Menu
        do{
            System.out.println("Bem vindo ao sistema de ...");
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Listar alunos cadastrados");
            System.out.println("[3] Sair");

         //Verifica tipo de entrada
            while((opcao != 1)&&(opcao !=2)&&(opcao !=3)){
            try{
                opcao = Integer.parseInt(read.nextLine());
                
            }catch(Exception e){
                
                System.out.println("Entrada inválida, insira novamente");
                
            }
            }

            switch(opcao) {
                case 1:
                    System.out.println("Digite o nome do aluno: ");
                    nomeAluno = read.nextLine().toString();
                    cadastrarAluno(nomeAluno);
                    break;
                case 2:
                    imprimeLista();
                    break;
                case 3:
                    //Unico caso em que o SAIR muda o valor
                    SAIR = 0;
                    break;

                default:
                    System.out.println("Por favor, insira somente uma das opções do menu");
                }
            
            //opcao reseta para o zero para que se posso resgatar um novo valor
            opcao = 0;
                //Se o SAIR mudou o valor, o usuário quer sair do programa
            }while(SAIR == 1);





        }

    // Modularizando função de cadastro de aluno
    private static void cadastrarAluno(final String nomeAluno){
        if(alunoCadastrado(nomeAluno)){
            System.out.println("Aluno já cadastrado");
        }else{
            listaAlunos.add(new Aluno(nomeAluno));
            System.out.println("Cadastro de "+nomeAluno+" realizado com sucesso!");
        }
    }

    // Modularizando função verificação de cadastro
    private static Boolean alunoCadastrado(final String nomeAluno){
        for(final Aluno aluno : listaAlunos){
            if(aluno.getName().equals(nomeAluno)){
                return true;
            }
        }
        return false;
    }

    // Modularizando função listagem de alunos
    private static void imprimeLista(){
        System.out.println("---LISTA DE ALUNOS---");
        for(final Aluno aluno : listaAlunos){
            System.out.println(aluno.getName());
        }
        System.out.println("---------------------");
    }

   

    
}