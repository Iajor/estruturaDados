# Na linguagem C++ ou nas linguagens estudadas fazer os seguintes PROGRAMAS:

# Gerar N listas de tamanho M com números aleatórios.
# Mostrar seus conteúdos.
# Mostrar os números que aparecem nas N listas.
# Mostrar os números que aparecem somente em uma das listas.
import random

def populateList(mainList, sizeOfInnerLists):
    for sublist in mainList:
        while len(sublist) != sizeOfInnerLists:
            number = random.randint(0, sizeOfInnerLists)
            if number not in sublist:
                sublist.append(number)    
        sublist.sort()

def showContent(mainList):
    for i, sublist in enumerate(mainList, start=1):
        print(f'Exibindo lista {i}')
        for element in sublist:
            print(element)

def showUnionList(mainList):
    unionSet = set()
    for sublist in mainList:
        unionSet.update(sublist)
    unionList = sorted(unionSet)
    print('Exibindo a lista de união')
    for element in unionList:
        print(element)

def showUniqueList(mainList):
    allNumbers = set()
    repeatedNumbers = set()
    for sublist in mainList:
        for number in sublist:
            if number in allNumbers:
                repeatedNumbers.add(number)
            else:
                allNumbers.add(number)
    uniqueNumbers = sorted(allNumbers - repeatedNumbers)
    print('Exibindo a lista de únicos')
    for element in uniqueNumbers:
        print(element)


sizeOfMainList = int(input("Informe a quantidade de listas: "))  
sizeOfInnerLists = int(input("Informe a quantidade de elementos em cada lista: "))

mainList = [[] for _ in range(sizeOfMainList)]
populateList(mainList, sizeOfInnerLists)
showContent(mainList)
showUnionList(mainList)
showUniqueList(mainList)
