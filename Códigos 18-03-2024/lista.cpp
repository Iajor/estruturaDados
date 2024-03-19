/*Na linguagem C++ ou nas linguagens estudadas fazer os seguintes PROGRAMAS:

Gerar duas listas de tamanho N com números aleatórios.
Mostrar seus conteúdos.
Mostrar os números que aparecem nas duas listas.
Mostrar os números que aparecem somente em uma das listas.*/


#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

#include "lista.h"

int main() {
    Lista *lista1 = NULL;
    Lista *lista2 = NULL;
    

    int qtd = 100;
    srand(time(NULL));

    for (; qtd > 0; qtd--) {
        lista1 = inserir(rand() % 100, lista1);
        lista2 = inserir(rand() % 100, lista2);
    }
    cout << "Tamanho da lista1 " << contar(lista1) << " e Tamanho da lista2 " << contar(lista2) << endl;
    cout << "lista1 -> ";
    exibir(lista1);
    cout << endl;
    cout << "lista2 -> ";
    exibir(lista2);
    cout << endl;

    Lista *listaComum = NULL;
    listaComum = duplicada(lista1, lista2, listaComum);
    cout << "Tamanho da listaComum " << contar(listaComum);
    cout << endl;
    cout << "listaComum -> ";
    exibir(listaComum);
    cout << endl;

    Lista *listaUnico = NULL;
    listaUnico = unica(lista1, lista2, listaUnico);
    cout << "Tamanho da listaUnico " << contar(listaUnico);
    cout << endl;
    cout << "listaUnico -> ";
    exibir(listaUnico);
    cout << endl;


    return 1;
}