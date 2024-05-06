import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        HashSet<Atomo> tabelaHash = new HashSet<>();
        String nomeArquivo = "Atomo\\src\\atomos.csv";
        
        Util.popularArquivoNoHash(tabelaHash, nomeArquivo);
        Util.mostrarHash(tabelaHash);
    }
}

