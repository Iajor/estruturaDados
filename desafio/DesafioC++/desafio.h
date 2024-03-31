typedef struct no{
    int dado;
    struct no* prox;
}Lista;

typedef struct pilha{
    Lista* lista;
    struct pilha* prox;
}PilhaListas;

Lista* inserir(int valor, Lista* lista){
    Lista* novo;
    novo = (Lista*)malloc(sizeof(Lista));

    novo->dado = valor;
    novo->prox = NULL;

    Lista *p, *pR;
    for (pR = NULL, p = lista; p; pR=p, p=p->prox){
        if (valor == p->dado){
            free(novo);
            return lista;
        }
        if (valor < p->dado){
            break;
        }
    }

    if(p==lista){
        novo->prox=p;
        return novo;
    }
    if(!p){
        pR->prox=novo;
        return lista;
    }

    pR->prox=novo;
    novo->prox=p;
    return lista;
}

void exibir(Lista *lista){
    Lista *p;
    for (p = lista; p; p = p->prox) {
        cout << p->dado << endl;
    }
}

void exibirPilha(PilhaListas* pilhaListas){
    PilhaListas *p;
    int index=1;
    for (p = pilhaListas; p; p = p->prox) {
        cout << "Exibindo lista " << index << endl;
        exibir(p->lista);
        index++;
    }
}

int contar(Lista *lista){
    Lista *p;
    int qtd = 0;
    for (p = lista; p; p = p->prox) {
        qtd++;
    }
    return qtd;
}

int contarPilha(PilhaListas *pilhasListas){
    PilhaListas *p;
    int qtd = 0;
    for (p=pilhasListas; p; p=p->prox){
        qtd++;
    }
    return qtd;
    
}

PilhaListas* inserirPilha(Lista* lista, PilhaListas* pilhaListas){
    PilhaListas* novo = (PilhaListas *)malloc(sizeof(PilhaListas));

    novo->lista = lista;

    novo->prox = pilhaListas;
 
    return novo;
}

Lista* gerarListaUniao(PilhaListas* pilhaListas){
    Lista* novo = NULL;
    PilhaListas *p;
    for (p = pilhaListas; p; p = p->prox) {
        Lista *l;
        for (l = p->lista; l; l = l->prox) {
            novo = inserir(l->dado, novo);
        }
    }
    return novo;
}

Lista* gerarListaUnico(PilhaListas* pilhaListas, Lista* lista){
    Lista* novo=NULL;
    int count;

    Lista* l;
    PilhaListas* p;

    for (l=lista;l;l=l->prox){
        count=0;
        for (p=pilhaListas;p;p=p->prox){
            Lista* pl;
            for (pl=p->lista;pl;pl=pl->prox){
                if(l->dado==pl->dado){
                    count++;
                    
                }
            }
        }
        if (count==1){
            novo=inserir(l->dado,novo);
        }
    }
    return novo;
}


