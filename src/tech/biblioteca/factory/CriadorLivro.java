package tech.biblioteca.factory;

import tech.biblioteca.model.ItemBiblioteca;
import tech.biblioteca.model.Livro;

public class CriadorLivro extends CriadorItem {
    @Override
    public ItemBiblioteca criarItem(String titulo) {
        return new Livro(titulo);
    }
}