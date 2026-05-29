package tech.biblioteca.observer;

import java.util.ArrayList;
import java.util.List;
import tech.biblioteca.observer.Observer;

public abstract class Subject {

    private final List<Observer> observadores = new ArrayList<>();

    public void registrarObservador(Observer o) {
        if (o != null && !observadores.contains(o)) {
            observadores.add(o);
        }
    }

    public void removerObservador(Observer o) {
        observadores.remove(o);
    }

    protected void notificarTodos(String mensagem) {
        for (Observer o : observadores) {
            // Chama o método que criamos na sua interface
            o.atualizar(mensagem);
        }
    }
}