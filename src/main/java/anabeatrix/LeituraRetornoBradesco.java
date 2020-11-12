package anabeatrix;

import anabeatrix.Boleto;
import anabeatrix.LeituraRetorno;

import java.time.LocalDate;

/**
 * @author anabeatriz
 * Baseado no vídeo disponível em:
 * https://www.youtube.com/watch?v=rg8_0f6bWWo
 */
public class LeituraRetornoBradesco implements LeituraRetorno {

    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArquivo) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArquivo[0]));
        boleto.setCodBanco(vetorLinhaArquivo[1]);
        boleto.setAgencia(vetorLinhaArquivo[2]);
        boleto.setContaBancaria(vetorLinhaArquivo[3]);
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArquivo[4], LeituraRetorno.FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArquivo[5], LeituraRetorno.FORMATO_DATA_HORA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetorLinhaArquivo[6]);
        boleto.setValor(Double.parseDouble(vetorLinhaArquivo[7]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArquivo[8]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArquivo[9]));
        return boleto;
    }
}
