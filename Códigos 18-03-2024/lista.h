typedef struct no {
    int dado;
    struct no *prox;
} Lista;

void exibir(Lista *lista){
    Lista *p;
    for (p = lista; p; p = p->prox) {
        cout << p->dado <<" ";
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

bool localizar(int valor, Lista *lista) {
    Lista *p;
    
    for (p = lista; p; p = p->prox) {
        if (valor == p->dado)
            return true;
    }
    return false;
}

Lista *inserir(int valor, Lista *lista) {
    //alocar memoria
    Lista *novo;
    novo = (Lista*)malloc(sizeof(Lista));

    //depositar valores
    novo->dado = valor;
    novo->prox = NULL;

    //engatar novo na sua posicao
    Lista *p, *pR;
    for (pR = NULL, p = lista; p ; pR = p, p = p->prox) {
        if (valor == p->dado) {
            free(novo);
            return lista;
        }
        if (valor < p->dado) {
            //achei a posicao
            break;
        }
    }
    //inserir na primeira posicao
    if (p == lista) {
        novo->prox = p;
        return novo;
    }
    //inserir na ultima posicao
    if (!p) {
        pR->prox = novo;
        return lista;
    }
    //inserir em alguma posicao do meio
    pR->prox = novo;
    novo->prox = p;
    return lista;
}

Lista *duplicada(Lista *lista1, Lista *lista2, Lista *lista){
    Lista *p, *p2;
    
    for (p = lista1; p; p = p->prox) {
        for (p2 = lista2; p2; p2 = p2->prox){
            if (p2->dado == p->dado) {
                lista = inserir(p->dado, lista);     
            }
        }
      
    }
    return lista;
}

Lista *unica(Lista *lista1, Lista *lista2, Lista *lista){
    Lista *p, *p2;
    bool unico = true;
    for (p = lista1; p; p = p->prox) {
        for (p2 = lista2; p2; p2 = p2->prox){
            if (p2->dado == p->dado) {
                unico = false;
                break;
            }else unico = true;
        }
        if(unico) lista = inserir(p->dado, lista); 
        
    }
    return lista;
}
// for (p = lista; p; p = p->prox) {
//         if (valor == p->dado)
//             return true;
//     }
//     return false;