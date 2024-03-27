/*# Na linguagem C++ ou nas linguagens estudadas fazer os seguintes PROGRAMAS:

# Gerar N listas de tamanho M com números aleatórios.
# Mostrar seus conteúdos.
# Mostrar os números que aparecem nas N listas.
# Mostrar os números que aparecem somente em uma das listas.*/

class Desafio
{
    static void Print(List<List<int>> mainList)
    {
        foreach (List<int> subList in mainList)
        {
            foreach (int element in subList)
            {
                Console.Write(element + " "); 
            }
            Console.WriteLine();
        }
    }

    static void Populate(int sizeOfInnerLists, int sizeOfMainList, List<List<int>> mainList)
    {
        Random random = new Random();
        for (int i = 0; i < sizeOfMainList; i++)
        {
            List<int> subList = new List<int>();
            for (int j = 0; j < sizeOfInnerLists; j++)
            {
                int element = random.Next(sizeOfInnerLists);
                if (!subList.Contains(element))
                {
                    subList.Add(element);
                }
            }
            subList.Sort();
            mainList.Add(subList);
        }
    }

    static void UnionList(List<List<int>> mainList, List<int> unionList) 
    {
        foreach (List<int> subList in mainList) 
        {
            foreach (int element in subList)
            {
                if (!unionList.Contains(element))
                {
                    unionList.Add(element); 
                }
            }
        }
        unionList.Sort();
        foreach (int element in unionList) 
        {
            Console.Write(element + " ");
        }
        Console.WriteLine();
    }

    static void UniqueList(List<List<int>> mainList, List<int> uniqueList)
    {
        foreach (List<int> subList in mainList)
        {
            foreach (int element in subList)
            {
                bool isUnique = true;        
                foreach (List<int> otherSubList in mainList)
                {
                    if (subList != otherSubList && otherSubList.Contains(element))
                    {
                        isUnique = false;
                        break;
                    }
                    
                }
                if (isUnique)
                {
                    uniqueList.Add(element);
                }
            }
        }
        uniqueList.Sort();
        foreach (int element in uniqueList) 
        {
            Console.Write(element + " ");
        }
        Console.WriteLine();
        
    }
    static void Main()
    {
        Console.WriteLine("Informe a quantidade de listas: "); 
        int sizeOfMainList = int.Parse(Console.ReadLine());
        Console.WriteLine("Informe a quantidade de elementos em cada lista: "); 
        int sizeOfInnerLists = int.Parse(Console.ReadLine());

        List<List<int>> mainList = new List<List<int>>();
        Populate(sizeOfInnerLists, sizeOfMainList, mainList);
        Print(mainList);

        List<int> unionList = new List<int>();
        UnionList(mainList, unionList);

        List<int> uniqueList = new List<int>();
        UniqueList(mainList, uniqueList);
    }
}
