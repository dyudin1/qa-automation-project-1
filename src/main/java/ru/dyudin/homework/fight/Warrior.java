package ru.dyudin.homework.fight;

public abstract class Warrior {
    private String name;
    protected String specialty = setSpecialty();

    abstract String setSpecialty();

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract void run();

    void die() {
        System.out.println(name + " died");
    }
}