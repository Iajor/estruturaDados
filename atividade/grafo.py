import networkx as nx
import matplotlib.pyplot as plt

def main():
    cidades = set()
    conexoes = []

    with open('cidades.csv', 'r') as file:
        content = file.read()
        connections = content.split('\n')
        for connection in connections:
            if '@' in connection:
                origem, destino = connection.split('@')
                if origem and destino:
                    cidades.add(origem)
                    cidades.add(destino)
                    conexoes.append((origem, destino))

    print("Cidades:", cidades)
    print("Conexões:", conexoes)
    cidades = sorted(list(cidades))
    grafo_rs = nx.Graph()
    grafo_rs.add_nodes_from(cidades)
    grafo_rs.add_edges_from(conexoes)
    pos = nx.spring_layout(grafo_rs, k=0.5)  
    plt.figure(figsize=(12, 8)) 
    nx.draw(grafo_rs, pos, with_labels=True, node_size=3000, node_color="skyblue", font_size=10, font_color="black", font_weight="bold", edge_color="gray")
    plt.show()

    cidade = "Itaara"
    if cidade in grafo_rs:
        print(f"Grau da cidade de {cidade}: {grafo_rs.degree[cidade]}")
    else:
        print(f"Cidade {cidade} não encontrada no grafo.")

if __name__ == "__main__":
    main()
