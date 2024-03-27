/*Na linguagem C++ ou nas linguagens estudadas fazer os seguintes PROGRAMAS:

 Gerar N listas de tamanho M com números aleatórios.
 Mostrar seus conteúdos.
 Mostrar os números que aparecem nas N listas.
 Mostrar os números que aparecem somente em uma das listas.*/


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe a quantidade de listas: ");
        int sizeOfMainList = input.nextInt();
        System.out.println("Informe a quantidade de elementos em cada lista: ");
        int sizeOfInnerList = input.nextInt();

        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        populate(mainList, sizeOfMainList, sizeOfInnerList):
        
        for (int i = 0; i < sizeOfMainList; i++) {
            List<Integer> subList = new ArrayList<Integer>();
            while (subList.size() != sizeOfInnerList) {
                Random random = new Random();
                int element = random.nextInt(sizeOfInnerList);
                if (!subList.contains(element)){
                    subList.add(element);
                }   
            }
            subList.sort(null);
            mainList.add(subList);
        }
        
        for (List<Integer> subList : mainList) {
            for (int i = 0; i < mainList.size(); i++) {
                System.out.println("Exibindo lista "+(i+1));
            }
            for (int element : subList) {
                System.out.println(element);
            }
        }
        input.close();
    }
} 
    
