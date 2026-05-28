package tech.biblioteca.model;

public class Livro implements ItemBiblioteca {
    private String titulo;

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