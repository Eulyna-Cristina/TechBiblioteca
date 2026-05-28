package tech.biblioteca.factory;

import tech.biblioteca.model.ItemBiblioteca;
import tech.biblioteca.model.Notebook;

public class CriadorNotebook extends CriadorItem {
    @Override
    public ItemBiblioteca criarItem(String marcaModelo) {
        return new Notebook(marcaModelo);
    }
}