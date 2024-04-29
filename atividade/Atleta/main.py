class Atleta:
    def __init__(self, fone="", nome="", apelido="", dataNascimento="", pontuacaoAcumulada=0):
        self.fone = fone
        self.nome = nome
        self.apelido = apelido
        self.dataNascimento = dataNascimento
        self.pontuacaoAcumulada = pontuacaoAcumulada

    def get_fone(self):
        return self.fone

    def set_fone(self, fone):
        self.fone = fone

    def get_nome(self):
        return self.nome

    def set_nome(self, nome):
        self.nome = nome

    def get_apelido(self):
        return self.apelido

    def set_apelido(self, apelido):
        self.apelido = apelido

    def get_dataNascimento(self):
        return self.dataNascimento

    def set_dataNascimento(self, dataNascimento):
        self.dataNascimento = dataNascimento

    def get_pontuacaoAcumulada(self):
        return self.pontuacaoAcumulada

    def set_pontuacaoAcumulada(self, pontuacaoAcumulada):
        self.pontuacaoAcumulada = pontuacaoAcumulada

    def __str__(self):
        return f"Atleta [fone={self.fone}, nome={self.nome}, apelido={self.apelido}, dataNascimento={self.dataNascimento}, pontuacaoAcumulada={self.pontuacaoAcumulada}]"

    def __eq__(self, other):
        if self is other:
            return True
        if not isinstance(other, Atleta):
            return False
        return self.fone == other.fone

    def __hash__(self):
        return hash(self.fone)


def exibirMenu():
    print("-------------------------Menu-------------------------")
    print("1. Listar atletas (nome ou por pontuação decrescente)")
    print("2. Cadastrar atleta")
    print("3. Procurar por atleta (nome ou apelido)")
    print("4. Remover atleta (nome ou apelido)")
    print("-------------------------Menu-------------------------")


def conexaoBase(lista):
    with open('atleta/atletas.csv', 'r') as leitor:
        for linha in leitor:
            listaSplit = linha.strip().split(';')
            lista.append(Atleta(listaSplit[0], listaSplit[1], listaSplit[2], listaSplit[3], int(listaSplit[4])))


def cadastrarAtleta(lista):
    print("Cadastrando atleta")
    fone = input("Informe o fone: ")
    nome = input("Informe o nome: ")
    apelido = input("Informe o apelido: ")
    data_nascimento = input("Informe a data de nascimento: ")
    pontuacao_acumulada = int(input("Informe a pontuação acumulada: "))

    novo_atleta = Atleta(fone, nome, apelido, data_nascimento, pontuacao_acumulada)
    if novo_atleta not in lista:
        lista.append(novo_atleta)
        atualizarLista(lista)
    else:
        print("Atleta já cadastrado!")


def atualizarLista(lista):
    with open('atleta/atletas.csv', 'w', encoding='utf8') as escritor:
        for atleta in lista:
            escritor.write(f"{atleta.fone};{atleta.nome};{atleta.apelido};{atleta.dataNascimento};{atleta.pontuacaoAcumulada}\n")


def removerAtleta(lista):
    if not lista:
        print("Lista vazia!")
    else:
        print("Deseja remover o atleta por 1 - nome ou 2 - apelido?")
        opcao_remocao = int(input())
        if opcao_remocao == 1:
            nome_procurado = input("Informe o nome do atleta: ")
            for atleta in lista:
                if atleta.get_nome() == nome_procurado:
                    lista.remove(atleta)
                    print("Atleta removido!")
                    atualizarLista(lista)
                    return
            print("Atleta não encontrado!")
        elif opcao_remocao == 2:
            apelido_procurado = input("Informe o apelido do atleta: ")
            for atleta in lista:
                if atleta.get_apelido() == apelido_procurado:
                    lista.remove(atleta)
                    print("Atleta removido!")
                    atualizarLista(lista)
                    return
            print("Atleta não encontrado!")
        else:
            print("Opção inválida!")


import os

atletas = []
conexaoBase(atletas)

while True:
    os.system('cls')
    exibirMenu()
    opcao_menu = int(input())
    
    if opcao_menu == 1:
        if not atletas:
            print("Lista vazia!")
        else:
            print("Deseja listar os atletas por 1 - nome ou 2 - pontuação decrescente?")
            opcao_listagem = int(input())
            if opcao_listagem == 1:
                lista_atletas_nome = sorted(atletas, key=lambda x: x.nome)
                for atleta in lista_atletas_nome:
                    print(atleta)
            elif opcao_listagem == 2:
                lista_atletas_pontuacao = sorted(atletas, key=lambda x: x.pontuacaoAcumulada, reverse=True)
                for atleta in lista_atletas_pontuacao:
                    print(atleta)
            else:
                print("Opção inválida!")
    elif opcao_menu == 2:
        cadastrarAtleta(atletas)
    elif opcao_menu == 3:
        if not atletas:
            print("Lista vazia!")
        else:
            print("Deseja procurar entre os atletas por 1 - nome ou 2 - apelido?")
            opcao_listagem = int(input())
            if opcao_listagem == 1:
                nome_procurado = input("Informe o nome do atleta: ")
                for atleta in atletas:
                    if atleta.nome == nome_procurado:
                        print(atleta)
            elif opcao_listagem == 2:
                apelido_procurado = input("Informe o apelido do atleta: ")
                for atleta in atletas:
                    if atleta.apelido == apelido_procurado:
                        print(atleta)
            else:
                print("Opção inválida!")
    elif opcao_menu == 4:
        removerAtleta(atletas)
    else:
        print("Opção inválida")

    os.system('pause')

