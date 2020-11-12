package anabeatrix;

import anabeatrix.Boleto;
import anabeatrix.LeituraRetorno;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anabeatriz
 * Baseado no vídeo disponível em:
 * https://www.youtube.com/watch?v=rg8_0f6bWWo
 */
public class ProcessadorBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessadorBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public final List<Boleto> processar(String nomeArquivo) {
        List<Boleto> boletos = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] vetor = linha.split(";");
                Boleto boleto = leituraRetorno.processarLinhaArquivo(vetor);
                boletos.add(boleto);
                System.out.println("ID: " + boleto.getId() + " | Banco: "
                        + boleto.getCodBanco() + " | CPF Cliente: "
                        + boleto.getCpfCliente());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return boletos;
    }
}
