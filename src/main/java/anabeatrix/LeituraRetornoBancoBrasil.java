package anabeatrix;

import anabeatrix.Boleto;
import anabeatrix.LeituraRetorno;

import java.time.LocalDate;

/**
 * @author anabeatriz
 * Baseado no vídeo disponível em:
 * https://www.youtube.com/watch?v=rg8_0f6bWWo
 */
public class LeituraRetornoBancoBrasil implements LeituraRetorno {

    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArquivo) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArquivo[0]));
        boleto.setCodBanco(vetorLinhaArquivo[1]);
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArquivo[2], LeituraRetorno.FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArquivo[3], LeituraRetorno.FORMATO_DATA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetorLinhaArquivo[4]);
        boleto.setValor(Double.parseDouble(vetorLinhaArquivo[5]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArquivo[6]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArquivo[7]));
        return boleto;
    }
}
