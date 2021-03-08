package ru.dyudin.homework.fight;

public class MeleeWarrior extends Warrior implements WarriorMeleeType {
    @Override
    void setSpecialty() {
        this.specialty = "Melee warrior";
    }

    @Override
    void run() {
        System.out.println(getName() + " runs slowly");
    }

    @Override
    public void hitWithSomething() {
        System.out.println(getName() + " hits with brick");
    }

    @Override
    public void blockWithSomething() {
        System.out.println(getName() + " blocks the attack with the oak stick");
    }
}
