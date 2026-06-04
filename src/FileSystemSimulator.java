import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileSystemSimulator implements Serializable {
    ArrayList<Directory> diretorios;
    private transient Journal journal;

    public FileSystemSimulator() {
        diretorios = new ArrayList<>();
        journal = new Journal();
    }

    public void criarDiretorio(String nome) {
        diretorios.add(new Directory(nome));
        salvarSistema();

        journal.registrar("criarDiretorio " + nome);
    }
    public void criarArquivo(String nomeDiretorio, String nomeArquivo) {
        for (Directory d : diretorios) {
            if (d.getNome().equals(nomeDiretorio)) {
                d.getArquivos().add(new Arquivo(nomeArquivo));
                salvarSistema();

                journal.registrar("criarArquivo " + nomeArquivo);
                return;
            }
        }
    }

    public void renomearArquivo(String antigo, String novo) {
        for (Directory d : diretorios) {
            for (Arquivo f : d.getArquivos()) {
                if (f.getNome().equals(antigo)) {
                    f.setNome(novo);

                    journal.registrar("renomearArquivo " + antigo + " -> " + novo);

                    return;
                }
            }
        }
    }
    public void renomearDiretorio(String antigo, String novo) {
        for (Directory d : diretorios) {
            if (d.getNome().equals(antigo)) {

                d.setNome(novo);

                journal.registrar("renomearDiretorio " + antigo + " -> " + novo);

                return;
            }
        }
    }
    public void apagarArquivo(String nomeArquivo) {
        for (Directory d : diretorios) {
            for (int i = 0; i < d.getArquivos().size(); i++) {
                if (d.getArquivos().get(i).getNome().equals(nomeArquivo)) {

                    d.getArquivos().remove(i);

                    journal.registrar("apagarArquivo " + nomeArquivo);

                    return;
                }
            }
        }
    }
    public void apagarDiretorio(String nome) {
        for (int i = 0; i < diretorios.size(); i++) {
            if (diretorios.get(i).getNome().equals(nome)) {

                diretorios.remove(i);

                journal.registrar("apagarDiretorio " + nome);

                return;
            }
        }
    }
    public void copiarArquivo(String origem,String copia) {
        for (Directory d : diretorios) {
            for (Arquivo f : d.getArquivos()) {
                if (f.getNome().equals(origem)) {
                    d.getArquivos().add(new Arquivo(copia));
                    journal.registrar("cpiarArquivo " + origem + " -> " + copia);

                    return;
                }
            }
        }
    }
    public void listarArquivos(String nomeDiretorio) {
        for (Directory d : diretorios) {
            if (d.getNome().equals(nomeDiretorio)) {

                System.out.println("└── " +nomeDiretorio);

                for (Arquivo f : d.getArquivos()) {
                    System.out.println("    ├── "+ f.getNome());
                }
                System.out.println("-----------------------");

                return;
            }
        }
    }
    public void listarDiretorios() {

        System.out.println("-----------------------");

        for (Directory d : diretorios) {
            System.out.println("└── "+d.getNome());
        }

        System.out.println("-----------------------\n");
    }

    private void salvarSistema() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sistema.dat"));
            out.writeObject(this);
            out.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar");
        }
    }

}