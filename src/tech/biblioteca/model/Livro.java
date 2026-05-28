package tech.biblioteca.model;

public class Livro implements ItemBiblioteca {
    // Adicionado o 'final' aqui
    private final String titulo;

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[LIVRO IMPRESSO] Título: " + titulo);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}