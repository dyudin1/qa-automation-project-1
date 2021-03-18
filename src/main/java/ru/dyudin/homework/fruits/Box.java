package ru.dyudin.homework.fruits;

public class Box<T> {
    private T content;

    T get() {
        return content;
    }

    void put(T content) {
        this.content = content;
    }
}
