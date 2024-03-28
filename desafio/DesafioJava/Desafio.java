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
    static void populate(List<List<Integer>> mainList, int sizeOfMainList, int sizeOfInnerList){
        for (int i = 0; i < sizeOfMainList; i++) {
            List<Integer> subList = new ArrayList<Integer>();
            while (subList.size() != sizeOfInnerList) {
                Random random = new Random();
                int element = random.nextInt(sizeOfInnerList*10);
                if (!subList.contains(element)){
                    subList.add(element);
                }   
            }
            subList.sort(null);
            mainList.add(subList);
        }
    }
    static void printMainList(List<List<Integer>> mainList){
        
        int index = 1;
        for (List<Integer> subList : mainList) {
            System.out.println("Exibindo lista " + index);
            for (int element : subList) {
                System.out.println(element);
            }
            index++;
        }

    }
    static void printUnionList(List<List<Integer>> mainList, List<Integer> unionList) {
        for (List<Integer> subList : mainList) {
            for (int element : subList) {
                if (!unionList.contains(element)){
                    unionList.add(element);
                }
            }
        }
        unionList.sort(null);;
        System.out.println("Exbibindo lista união: ");
        for (int element : unionList) {
            System.out.println(element);
        }
    }
    static void printUniqueList(List<List<Integer>> mainList, List<Integer> uniqueList){
        for (List<Integer> subList : mainList) {
            for (int element : subList) {
                boolean isUnique = true;
                for (List<Integer> otherSubList : mainList) {
                    if (subList != otherSubList && otherSubList.contains(element)){
                        isUnique = false;
                        break;
                    }            
                }
                if (isUnique){
                uniqueList.add(element);
                }
            }
        }
        uniqueList.sort(null);
        System.out.println("Exbibindo lista unicos: ");
        for (int element : uniqueList) {
            System.out.println(element);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe a quantidade de listas: ");
        int sizeOfMainList = input.nextInt();
        System.out.println("Informe a quantidade de elementos em cada lista: ");
        int sizeOfInnerList = input.nextInt();

        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        populate(mainList, sizeOfMainList, sizeOfInnerList);
        printMainList(mainList);

        List<Integer> unionList = new ArrayList<Integer>();
        printUnionList(mainList, unionList);

        List<Integer> uniqueList = new ArrayList<Integer>();
        printUniqueList(mainList, uniqueList);


        input.close();
    }
}
    
