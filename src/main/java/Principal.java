import anabeatrix.LeituraRetornoBradesco;
import anabeatrix.ProcessadorBoletos;

/**
 * @author anabeatriz
 * Baseado no vídeo disponível em:
 * https://www.youtube.com/watch?v=rg8_0f6bWWo
 */
public class Principal {
    public static void main(String[] args) {
        ProcessadorBoletos processador = new ProcessadorBoletos(new LeituraRetornoBradesco());
        String nomeArquivo = "bradesco-1.csv";
        processador.processar(nomeArquivo);
    }
}
