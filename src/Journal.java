import java.io.FileWriter;
import java.io.IOException;

public class Journal {

    public void registrar(String mensagem) {

        try {
            FileWriter fw = new FileWriter("journal.txt", true);
            fw.write(mensagem + "\n");
            fw.close();

        } catch (IOException e) {
            System.out.println("Erro no journal");
        }
    }
}