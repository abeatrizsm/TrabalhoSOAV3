# Simulador de Sistema de Arquivos com Journaling

## Resumo

Este trabalho propõe o desenvolvimento de um simulador de sistema de arquivos em Java com suporte a journaling representando, de forma simplificada, algumas operações comuns realizadas por sistemas operacionais, como criação, cópia, renomeação e exclusão de arquivos e diretórios.

---

# Introdução

O gerenciamento de arquivos é uma das funções fundamentais de um sistema operacional. É por meio dele que os dados são organizados, armazenados e recuperados quando necessário.

O sistema de arquivos é o componente responsável por estruturar e organizar essas informações, permitindo que sejam armazenadas em dispositivos de armazenamento e recuperadas posteriormente. Além disso, ele oferece uma forma de abstrair os detalhes físicos do armazenamento, permitindo que o usuário utilize arquivos e diretórios sem precisar conhecer como os dados estão organizados internamente.

Por ser uma das partes mais utilizadas pelos usuários, o sistema de arquivos é considerado uma das áreas mais visíveis de um sistema operacional. Ações como criar, copiar, renomear, listar e excluir arquivos fazem parte da utilização diária de qualquer computador.

Neste projeto foi desenvolvido um simulador em Java para reproduzir algumas dessas funcionalidades de forma simplificada, permitindo visualizar como as operações são realizadas e registradas.

---

# Objetivo

Desenvolver um simulador de sistema de arquivos que implemente funcionalidades básicas de manipulação de arquivos e diretórios, com suporte a journaling para garantir maior integridade dos dados.

O simulador deve permitir:

* Copiar arquivos
* Apagar arquivos
* Renomear arquivos
* Criar diretórios
* Apagar diretórios
* Renomear diretórios
* Listar arquivos de um diretório

Além disso, cada operação executada deve ser registrada em um arquivo de journal para possibilitar o acompanhamento das alterações realizadas durante a execução do sistema.

---

# Metodologia

O simulador foi desenvolvido utilizando a linguagem Java.

As operações do sistema são executadas por meio de chamadas de métodos. Cada método representa uma ação normalmente encontrada em sistemas operacionais, como criar arquivos, apagar diretórios ou listar conteúdos.

A estrutura foi organizada em classes específicas para representar os elementos do sistema de arquivos e para registrar as operações realizadas. Ao executar uma ação, o sistema atualiza suas estruturas internas e registra a operação no arquivo de journal.

---

# Parte 1: Introdução ao Sistema de Arquivos com Journaling

## Descrição do sistema de arquivos

Um sistema de arquivos é a parte do sistema operacional responsável pelo gerenciamento dos arquivos e diretórios armazenados em um dispositivo. Seu objetivo é organizar as informações de forma que possam ser localizadas e acessadas quando necessário.

Do ponto de vista dos sistemas operacionais, um arquivo pode ser entendido como uma unidade básica de armazenamento que contém informações. Essas informações podem representar programas, documentos, imagens, músicas ou qualquer outro tipo de dado.

Os arquivos normalmente são identificados por um nome e, em muitos sistemas operacionais, também por uma extensão, que auxilia na identificação do conteúdo armazenado. Além disso, o sistema de arquivos mantém informações importantes como localização, tamanho, permissões de acesso e datas de criação ou modificação.

## Journaling

O journaling é uma técnica utilizada para aumentar a confiabilidade de um sistema de arquivos. Seu funcionamento baseia-se no registro das operações em um log antes ou durante sua execução.

Dessa forma, caso ocorra uma falha inesperada, como desligamento do computador ou interrupção de energia, o sistema possui informações suficientes para identificar quais operações estavam em andamento.

Os principais modelos de journaling são:

### Write-Ahead Logging (WAL)

Nesse modelo, a operação é registrada primeiro no log e somente depois é aplicada aos dados. Essa abordagem permite que o sistema recupere operações pendentes após uma falha. É uma das técnicas mais utilizadas por sistemas de arquivos e bancos de dados.

### Log-Structured File System

Nesse tipo de implementação, as alterações são gravadas de forma sequencial em estruturas baseadas em logs. Isso facilita o rastreamento das modificações realizadas ao longo do tempo.

No simulador desenvolvido, foi implementada uma versão simplificada desse conceito. Cada operação realizada pelo usuário é registrada no arquivo `journal.txt`, criando um histórico das alterações executadas durante a utilização do sistema.

---

# Parte 2: Arquitetura do Simulador

## Estrutura de Dados

O simulador foi construído utilizando quatro classes principais.

### Classe Arquivo

Representa um arquivo armazenado no sistema.

Cada objeto mantém o nome do arquivo e permite sua alteração quando necessário.

### Classe Directory

Representa um diretório.

Cada diretório possui:

* Nome;
* Lista de arquivos armazenados.

Os arquivos são mantidos em uma coleção do tipo ArrayList.

### Classe FileSystemSimulator

É a classe principal do sistema.

Ela mantém uma lista de diretórios e implementa todas as operações disponíveis no simulador:

* Criar diretório;
* Criar arquivo;
* Copiar arquivo;
* Renomear arquivo;
* Renomear diretório;
* Apagar arquivo;
* Apagar diretório;
* Listar arquivos;
* Listar diretórios.

Também é responsável por salvar o estado do sistema em um arquivo chamado `sistema.dat`.

### Classe Journal

Responsável pelo gerenciamento do journal.

Cada operação realizada é registrada em um arquivo chamado `journal.txt`, permitindo acompanhar o histórico das modificações.

## Journaling

O journal foi implementado através de gravações em arquivo texto.

Sempre que uma operação é executada, uma mensagem é adicionada ao arquivo de log.

Exemplos de registros:

```text
criarDiretorio Documentos
criarArquivo trabalhoAV3_SistOperacional.docx
renomearArquivo rock.mp3 -> rock_legiãoUrbana.mp3
apagarDiretorio Audio
```

Dessa forma é possível visualizar toda a sequência de operações realizadas durante a execução do simulador.

---

# Parte 3: Implementação em Java

## Classe FileSystemSimulator

Essa classe concentra toda a lógica do simulador.

Ela gerencia os diretórios existentes e executa as operações de manipulação de arquivos e diretórios.

Também realiza a serialização do sistema em um arquivo chamado `sistema.dat`, permitindo armazenar o estado atual da estrutura criada.

## Classes Arquivo e Directory

A classe `Arquivo` representa os arquivos do sistema.

A classe `Directory` representa os diretórios e mantém uma lista contendo seus respectivos arquivos.

Juntas, essas duas classes formam a estrutura básica utilizada para organizar os dados dentro do simulador.

## Classe Journal

A classe `Journal` é responsável pelo registro das operações.

Sempre que uma ação é executada, uma entrada é adicionada ao arquivo `journal.txt`.

Esse mecanismo permite acompanhar todas as modificações realizadas durante a execução do programa.

---

# Parte 4: Instalação e Funcionamento

## Recursos utilizados

* Java JDK 17 (ou versão compatível);
* IDE de desenvolvimento (IntelliJ IDEA, Eclipse ou NetBeans);
* Terminal para execução do programa.

## Passo a passo para execução

1. Baixar ou clonar o projeto do GitHub.

2. Abrir o projeto em uma IDE Java.

3. Compilar os arquivos do projeto.

4. Executar a classe `Main`.

5. O programa realizará automaticamente as operações definidas no método `main()`.

6. Os resultados serão exibidos no terminal.

7. Ao final da execução serão gerados os arquivos:

* `journal.txt` (registro das operações);
* `sistema.dat` (estado serializado do sistema).

## Exemplo de execução

Inicialmente são criados os diretórios:

```text
Documentos
Fotos
Videos
Musicas
```

Em seguida são criados arquivos dentro de cada diretório.

Depois são executadas operações de cópia, renomeação e exclusão.

Ao final da execução o sistema permanece com os seguintes diretórios:

```text
Documentos
Fotos
Filmes
```

E os arquivos refletem todas as alterações realizadas durante o processamento.

---

# Resultados

O simulador permite compreender melhor como um sistema de arquivos organiza informações e executa operações básicas de gerenciamento de dados.

O uso do journaling também possibilita visualizar como sistemas reais registram alterações para auxiliar na integridade e no acompanhamento das operações realizadas.

Com os testes executados foi possível observar a criação, modificação, cópia, renomeação e exclusão de arquivos e diretórios, além do registro dessas ações no arquivo de journal.

---

# Link do GitHub

**Repositório do projeto:**
https://github.com/abeatrizsm/TrabalhoSOAV3
