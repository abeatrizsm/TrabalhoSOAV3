public class Main {

    public static void main(String[] args) {

        FileSystemSimulator sisbia = new FileSystemSimulator();

        sisbia.criarDiretorio("Documentos");
        sisbia.criarDiretorio("Fotos");
        sisbia.criarDiretorio("Videos");
        sisbia.criarDiretorio("Musicas");
        System.out.println("Diretórios criados:");
        sisbia.listarDiretorios();

        sisbia.criarArquivo("Documentos", "trabalhoAV3_SistOperacional.docx");
        sisbia.criarArquivo("Documentos", "anotacoes_Aula14_SistemaDeArquivos.txt");

        sisbia.criarArquivo("Fotos", "praiaParacuru.jpg");
        sisbia.criarArquivo("Fotos", "familia.jpg");

        sisbia.criarArquivo("Videos", "aulaHuawei.mp4");
        sisbia.criarArquivo("Videos", "filme.mp4");

        sisbia.criarArquivo("Musicas", "rock.mp3");
        sisbia.criarArquivo("Musicas", "pop.mp3");

        System.out.println("Arquivos criados:");

        System.out.println("------ Documentos ------");
        sisbia.listarArquivos("Documentos");

        System.out.println("\n------ Fotos ------");
        sisbia.listarArquivos("Fotos");

        System.out.println("\n------ Videos ------");
        sisbia.listarArquivos("Videos");

        System.out.println("\n------ Musicas ------");
        sisbia.listarArquivos("Musicas");

        sisbia.copiarArquivo("trabalhoAV3_SistOperacional.docx", "trabalhoSOAV3_backup.docx");
        sisbia.copiarArquivo("praiaParacuru.jpg", "praia_backup.jpg");

        sisbia.renomearArquivo("anotacoes_Aula14_SistemaDeArquivos.txt", "resumoAula14.txt");
        sisbia.renomearArquivo("rock.mp3", "rock_legiãoUrbana.mp3");

        sisbia.renomearDiretorio("Videos", "Filmes");
        sisbia.renomearDiretorio("Musicas", "Audio");

        System.out.println("");
        System.out.println("Todos os diretórios após renomear.");
        sisbia.listarDiretorios();

        System.out.println("Arquivos após alteracoes");
        System.out.println("------ Documentos ------");
        sisbia.listarArquivos("Documentos");

        System.out.println("\n------ Fotos ------");
        sisbia.listarArquivos("Fotos");

        System.out.println("\n------ Filmes ------");
        sisbia.listarArquivos("Filmes");

        System.out.println("\n------ Audio ------");
        sisbia.listarArquivos("Audio");

        sisbia.apagarArquivo("filme.mp4");
        sisbia.apagarArquivo("praia_backup.jpg");

        System.out.println();
        System.out.println("Arquivos após exclusão");
        System.out.println("------ Filmes ------");
        sisbia.listarArquivos("Filmes");

        System.out.println("\n------ Fotos ------");
        sisbia.listarArquivos("Fotos");
        System.out.println();

        sisbia.apagarDiretorio("Audio");
        System.out.println("Todos os diretórios após deleçao.");
        sisbia.listarDiretorios();
    }
}