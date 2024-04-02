package atividades01042024;

public class Personagem {
    private String nome;
    private String categoria;
    private int energia = 5;

    public Personagem(){}

    public Personagem(String nome){
        this.nome = nome;
    }

    public Personagem(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    

}
