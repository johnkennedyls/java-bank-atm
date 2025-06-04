import contract.Observer;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Observer> observers = new ArrayList<>();
    private double balance;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deposit(double amount) {
        balance += amount;
        notifyObservers();
    }

    public void withdraw(double amount) {
        balance -= amount;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(balance);
        }
    }
}