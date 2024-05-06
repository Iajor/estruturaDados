import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Util {

    public static void popularArquivoNoHash(HashSet<Atomo> tabelaHash, String nomeArquivo) {
        try {
            // Verifica se o arquivo existe
            FileReader arquivo = new FileReader(nomeArquivo);
            BufferedReader leitor = new BufferedReader(arquivo);

            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";");
                Atomo atomo = new Atomo(dados[0], dados[1], dados[2], dados[3]);
                tabelaHash.add(atomo);
            }

            leitor.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void mostrarHash(HashSet<Atomo> tabelaHash) {
        for (Atomo atomo : tabelaHash) {
            System.out.println(atomo);
        }
    }
}

