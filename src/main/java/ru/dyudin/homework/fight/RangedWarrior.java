package ru.dyudin.homework.fight;

public class RangedWarrior extends Warrior implements WarriorRangedType {


    @Override
    void run() {
        System.out.println(getName() + " runs very fast");
    }

    @Override
    public void shootSomething() {
        System.out.println(getName() + " throws the brick");
    }

    @Override
    public void dodgeLeft() {
        System.out.println(getName() + " dodges an attack by jumping to the right");
    }
}
