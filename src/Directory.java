import java.io.Serializable;
import java.util.ArrayList;

public class Directory implements Serializable {
    String nome;
    ArrayList<Arquivo> arquivos;

    public Directory(String nome) {
        this.nome = nome;
        arquivos = new ArrayList<>();
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Arquivo> getArquivos() {
        return arquivos;
    }
}