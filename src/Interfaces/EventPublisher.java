package Interfaces;

public interface EventPublisher {
    void addListener(EventListener listener);
    void notifyListeners();
}