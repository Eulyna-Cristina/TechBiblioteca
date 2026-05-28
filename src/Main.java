// SEM LINHA DE PACKAGE AQUI (Já que ela está direto no src)

// IMPORTS EXPLÍCITOS (Isso garante que o VS Code encontre cada arquivo
import tech.biblioteca.model.ItemBiblioteca;
import tech.biblioteca.factory.CriadorItem;
import tech.biblioteca.factory.CriadorLivro;
import tech.biblioteca.factory.CriadorNotebook;
import tech.biblioteca.observer.ItemDisponibilidade;
import tech.biblioteca.observer.Usuario;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. TESTANDO FACTORY METHOD ---");

        // Instanciando as fábricas do pacote factory
        CriadorItem fabricaLivros = new CriadorLivro();
        CriadorItem fabricaNotebooks = new CriadorNotebook();

        // Criando os itens através do padrão Factory Method
        ItemBiblioteca livro1 = fabricaLivros.criarItem("Dom Casmurro");
        ItemBiblioteca note1 = fabricaNotebooks.criarItem("Dell Inspiron 15");

        // Exibindo os detalhes específicos de cada classe filha
        livro1.exibirDetalhes();
        note1.exibirDetalhes();

        System.out.println("\n--- 2. TESTANDO OBSERVER ---");

        // Criando o sujeito (Subject) que controla a disponibilidade
        ItemDisponibilidade controleNotebook = new ItemDisponibilidade(note1.getTitulo());

        // Criando os observadores (Observers)
        Usuario aluno1 = new Usuario("Carlos");
        Usuario aluno2 = new Usuario("Mariana");

        // Registrando os alunos na lista de interesse
        controleNotebook.registrarObservador(aluno1);
        controleNotebook.registrarObservador(aluno2);

        // Simulando a devolução do notebook (Dispara o gatilho do Observer)
        System.out.println("\nStatus no Sistema: O notebook foi devolvido e está pronto para uso.");
        controleNotebook.setDisponivel(true);

        // Simulando um novo empréstimo (Não deve enviar notificações)
        System.out.println("\nStatus no Sistema: O notebook foi emprestado novamente.");
        controleNotebook.setDisponivel(false);
    }
}