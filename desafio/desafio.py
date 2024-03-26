# Na linguagem C++ ou nas linguagens estudadas fazer os seguintes PROGRAMAS:

# Gerar N listas de tamanho M com números aleatórios.
# Mostrar seus conteúdos.
# Mostrar os números que aparecem nas N listas.
# Mostrar os números que aparecem somente em uma das listas.
import random

def populateList(mainList, sizeOfInnerLists):
    for list in mainList:
        while list.__len__() != sizeOfInnerLists:
            number=random.randint(0, sizeOfInnerLists*100)
            if number not in list:
                list.append(number)    
        list.sort()

def showContent(mainList):
    for i in range(mainList.__len__()):
        print(f'Exibindo lista {i+1}')
        for element in mainList[i]:
            print(element)
            
def showUnionList(mainList, unionList):
    for i in mainList:
        for j in i:
            if j not in unionList:
                unionList.append(j)

    unionList.sort()
    print(f'Exibindo a lista de união')
    for i in unionList:
        print(i)

def showUniqueList(mainList, uniqueList):
    for list in mainList:
        for element in list:
            isUnique = True
            for otherList in mainList:
                if list != otherList and element in otherList:
                    isUnique = False
                    break
            if isUnique:
                uniqueList.append(element)
    uniqueList.sort()
    print(f'Exibindo a lista de únicos')
    for i in uniqueList:
        print(i)

sizeOfMainList = int(input("Informe a quantidade de listas: "))  
sizeOfInnerLists = int(input("Informe a quantidade de elementos em cada lista: "))

mainList = [[] for _ in range(sizeOfMainList)]
populateList(mainList, sizeOfInnerLists)
showContent(mainList)

unionList = []
showUnionList(mainList, unionList)
uniqueList = []
showUniqueList(mainList, uniqueList)

