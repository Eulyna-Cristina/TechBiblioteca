package tech.biblioteca.model;

public class Notebook implements ItemBiblioteca {
    private String marcaModelo;

    public Notebook(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[HARDWARE] Notebook: " + marcaModelo + " (Requer termo de responsabilidade de uso local)");
    }

    @Override
    public String getTitulo() {
        return marcaModelo;
    }
}
