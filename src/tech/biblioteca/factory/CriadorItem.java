package tech.biblioteca.factory;

import tech.biblioteca.model.ItemBiblioteca;

public abstract class CriadorItem {
    // Esse é o método fábrica abstrato
    public abstract ItemBiblioteca criarItem(String atributo);
}