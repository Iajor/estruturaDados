package atividades01042024;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Menu {
    public static void clearScreen(){     

        System.out.print("\033[H\033[2J");  

        System.out.flush();  

    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int opcao;
        
        do {
            clearScreen();
            System.out.println("----------Menu----------");
            System.out.println("1. Cadastrar personagem");
            System.out.println("2. Listar personagens");
            System.out.println("3. Remover personagem");
            System.out.println("4. Sair");
            System.out.println("----------Menu----------");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    ArrayList<Personagem> personagens = new ArrayList<>();
                    System.out.println("Informe o nome do personagem:");
                    String nome = input.nextLine();
                    System.out.println("Informe a categoria do personagem:");
                    String categoria = input.nextLine();
                    Personagem personagem = new Personagem(nome, categoria);

                    if (!personagens.contains(personagem)){
                        personagens.add(personagem);
                        System.out.println("Personagem "+personagem.getNome()+" adicionado");
                    }
                    else System.out.println("Personagem já registrado");
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            
        } while (opcao!=4);
        
        
        input.close();
    }    
}
