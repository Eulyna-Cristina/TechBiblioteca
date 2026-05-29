import tech.biblioteca.model.ItemBiblioteca;
import tech.biblioteca.factory.CriadorItem;
import tech.biblioteca.factory.CriadorLivro;
import tech.biblioteca.factory.CriadorNotebook;
import tech.biblioteca.observer.ItemDisponibilidade;
import tech.biblioteca.observer.Usuario;

public class Main {
    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" [PADRÃO FACTORY METHOD] - Registro de Acervo");
        System.out.println("==================================================");
        System.out.println("-> Solicitando a criação de itens para as fábricas...\n");

        // Instanciando as fábricas do pacote factory
        CriadorItem fabricaLivros = new CriadorLivro();
        CriadorItem fabricaNotebooks = new CriadorNotebook();

        // Criando os itens através do padrão Factory Method
        ItemBiblioteca livro1 = fabricaLivros.criarItem("Dom Casmurro");
        ItemBiblioteca livro2 = fabricaLivros.criarItem("Outlander");
        ItemBiblioteca note1 = fabricaNotebooks.criarItem("Dell Inspiron 15");
        ItemBiblioteca note2 = fabricaNotebooks.criarItem("Samsung Book 2");

        // Exibindo os detalhes específicos de cada classe filha
        System.out.print("   "); livro1.exibirDetalhes();
        System.out.print("   "); livro2.exibirDetalhes();
        System.out.print("   "); note1.exibirDetalhes();
        System.out.print("   "); note2.exibirDetalhes();

        System.out.println("\n--------------------------------------------------");
        System.out.println(" Itens gerados e validados com sucesso via Factory!");
        System.out.println("--------------------------------------------------\n\n");


        System.out.println("==================================================");
        System.out.println("[PADRÃO OBSERVER] - Central de Disponibilidade");
        System.out.println("==================================================");

        // Criando o sujeito (Subject) que controla a disponibilidade usando o note1
        ItemDisponibilidade controleNotebook = new ItemDisponibilidade(note1.getTitulo());
        System.out.println(" Item atualmente monitorado: " + note1.getTitulo());

        // Criando os observadores (Observers)
        Usuario aluno1 = new Usuario("Lenilson");
        Usuario aluno2 = new Usuario("Eulyna");

        // Registrando os alunos na lista de interesse
        System.out.println(" Registrando interessados na fila de espera...");
        controleNotebook.registrarObservador(aluno1);
        controleNotebook.registrarObservador(aluno2);
        System.out.println("   [✓] Lenilson adicionado.");
        System.out.println("   [✓] Eulyna adicionada.");

        System.out.println("\n--------------------------------------------------");
        System.out.println("⚡ SIMULAÇÃO DE EVENTOS NO SISTEMA");
        System.out.println("--------------------------------------------------");

        // Simulando a devolução do notebook (Dispara o gatilho do Observer)
        System.out.println(" [EVENTO]: O notebook foi devolvido para o balcão.");
        System.out.println(" Processando notificações de interesse...");
        System.out.println("--------------------------------------------------");
        controleNotebook.setDisponivel(true);
        System.out.println("--------------------------------------------------");

        // Simulando um novo empréstimo (Não deve enviar notificações)
        System.out.println("\n [EVENTO]: O notebook foi retirado por outro estudante.");
        System.out.println(" Atualizando banco de dados (Silencioso - Sem alertas)...");
        controleNotebook.setDisponivel(false);
        System.out.println("   [i] Sistema atualizado para 'Indisponível'.");

        System.out.println("\n==================================================");
        System.out.println(" Fim da execução do fluxo de testes da biblioteca.");
        System.out.println("==================================================");
    }
}