/*Na linguagem C++ ou nas linguagens estudadas fazer os seguintes PROGRAMAS:

Gerar N listas de tamanho M com números aleatórios.
Mostrar seus conteúdos.
Mostrar os números que aparecem nas N listas.
Mostrar os números que aparecem somente em uma das listas.*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

#include "desafio.h"

int main() {

    cout << "Informe a quantidade de listas: " << endl;
    int sizeMainList;
    cin >> sizeMainList;
    cout << "Informe a quantidade de elementos em cada lista: " << endl;
    int sizeInnerList;
    cin >> sizeInnerList;

    PilhaListas* pilhaListas = NULL;

    srand(time(NULL));
    while(contarPilha(pilhaListas)<sizeMainList){
        Lista* lista=NULL;
        while (contar(lista)<sizeInnerList){
            lista = NULL;
            for(int i = 0; i<sizeInnerList;i++){
                lista=inserir(rand()%5, lista);
            }
        }
        pilhaListas=inserirPilha(lista, pilhaListas);
    }

    exibirPilha(pilhaListas);
    Lista* listaUniao = gerarListaUniao(pilhaListas);
    cout<<"Exibindo lista uniao"<<endl;
    exibir(listaUniao);
    Lista* listaUnico = gerarListaUnico(pilhaListas, listaUniao);
    cout<<"Exibindo lista unicos"<<endl;
    exibir(listaUnico);

    return 1;
}