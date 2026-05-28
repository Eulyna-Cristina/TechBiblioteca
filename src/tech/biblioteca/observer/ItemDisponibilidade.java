package tech.biblioteca.observer;

public class ItemDisponibilidade extends Subject {
    private final String nomeItem;
    private boolean disponivel = false;

    public ItemDisponibilidade(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public void setDisponivel(boolean disponivel) {
        if (disponivel && !this.disponivel) {
            this.disponivel = true;
            notificarTodos("O item '" + nomeItem + "' já está disponível para empréstimo!");
        } else {
            this.disponivel = disponivel;
        }
    }
}