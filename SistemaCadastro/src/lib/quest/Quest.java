
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class Quest {
    public static void Show() {
        Logger logger = Logger.getLogger("LeitorFormulario");
        
        try{
            List<String> perguntas = Files.readAllLines(Paths.get("src\\lib\\formulario.txt"));

            String newPerguntas = perguntas.toString().replaceAll("\\[", "").
                    replaceAll("\\]", "").
                    replaceAll(",", "\n");
            logger.info(newPerguntas);

        } catch (IOException e){
            logger.severe("Erro ao ler o arquivo: " + e.getMessage());
        }

    }
}
