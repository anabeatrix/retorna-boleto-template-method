package anabeatrix;

import anabeatrix.Boleto;

import java.time.format.DateTimeFormatter;

/**
 * @author anabeatriz
 * Baseado no vídeo disponível em:
 * https://www.youtube.com/watch?v=rg8_0f6bWWo
 */
public interface LeituraRetorno {

    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    Boleto processarLinhaArquivo(String[] vetorLinhaArquivo);

}
