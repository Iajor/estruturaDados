
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int opcaoMenu;
        HashSet<Atleta> atletas = new HashSet<Atleta>();
        
        do {
            
            System.out.println("-------------------------Menu-------------------------");
            System.out.println("1. Listar atletas (nome ou por pontuação decrescente)");
            System.out.println("2. Cadastrar atleta");
            System.out.println("3. Procurar por atleta (nome ou apelido)");
            System.out.println("4. Remover atleta (nome ou apelido)");
            System.out.println("-------------------------Menu-------------------------");
            opcaoMenu = input.nextInt();
            input.nextLine();

            switch (opcaoMenu) {
                case 1:
                    if (atletas.isEmpty()){
                        System.out.println("Lista vazia!");
                    }else{
                        System.out.println("Deseja listar os atletas por 1 - nome ou 2 - pontuação decrescente?");
                        int opcaoListagem = input.nextInt();
                        input.nextLine();
                        switch (opcaoListagem) {
                            case 1:
                                ArrayList<Atleta> listaAtletasNome = new ArrayList<Atleta>();
                                listaAtletasNome.addAll(atletas);
                                listaAtletasNome.sort((a1,a2) -> (a1.getNome()).compareTo(a2.getNome()));
                                for(Atleta atleta : listaAtletasNome){
                                    System.out.println(atleta);
                                }
                                break;
                            case 2:
                                ArrayList<Atleta> listaAtletasPontuacao = new ArrayList<Atleta>();
                                listaAtletasPontuacao.addAll(atletas);
                                listaAtletasPontuacao.sort((a1,a2) -> ((Integer)a2.getPontuacaoAcumulada()).compareTo(a1.getPontuacaoAcumulada()));
                                for(Atleta atleta : listaAtletasPontuacao){
                                    System.out.println(atleta);
                                }
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Cadastrando atleta");
                    System.out.println("Informe o fone");
                    String fone = input.nextLine();
                    System.out.println("Informe o nome");
                    String nome = input.nextLine();
                    System.out.println("Informe o apelido");
                    String apelido = input.nextLine();
                    System.out.println("Informe a data de nascimento");
                    String dataNascimento = input.nextLine();
                    System.out.println("Informe a pontuação acumulada");
                    int pontuacaoAcumulada = input.nextInt();
                    
                    if (!atletas.add(new Atleta(fone, nome, apelido, dataNascimento, pontuacaoAcumulada))){
                        System.out.println("Atleta já cadastrado!");
                    }
                    break;
                case 3:
                    if (atletas.isEmpty()){
                        System.out.println("Lista vazia!");
                    }else{
                        System.out.println("Deseja procurar entre os atletas por 1 - nome ou 2 - apelido?");
                        int opcaoListagem = input.nextInt();
                        input.nextLine();
                        switch (opcaoListagem) {
                            case 1: 
                                System.out.println("Informe o nome do atleta");
                                String nomeProcurado = input.nextLine();
                                for (Atleta atletaProcurado : atletas){
                                    if (atletaProcurado.getNome().equals(nomeProcurado)){
                                        System.out.println(atletaProcurado);
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Informe o apelido do atleta");
                                String apelidoProcurado = input.nextLine();
                                for (Atleta atletaProcurado : atletas){
                                    if (atletaProcurado.getApelido().equals(apelidoProcurado)){
                                        System.out.println(atletaProcurado);
                                    }
                                }
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;
                case 4:
                    if (atletas.isEmpty()){
                        System.out.println("Lista vazia!");
                    }else{
                        System.out.println("Deseja remover o atleta por 1 - nome ou 2 - apelido?");
                        int opcaoListagem = input.nextInt();
                        input.nextLine();
                        switch (opcaoListagem) {
                            case 1: 
                                System.out.println("Informe o nome do atleta");
                                String nomeProcurado = input.nextLine();
                                for (Atleta atletaProcurado : atletas){
                                    if (atletaProcurado.getNome().equals(nomeProcurado)){
                                        atletas.remove(atletaProcurado);
                                        System.out.println("Atleta removido!");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Informe o apelido do atleta");
                                String apelidoProcurado = input.nextLine();
                                for (Atleta atletaProcurado : atletas){
                                    if (atletaProcurado.getApelido().equals(apelidoProcurado)){
                                        atletas.remove(atletaProcurado);
                                        System.out.println("Atleta removido!");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            
        } while (true);
    
    }
}
