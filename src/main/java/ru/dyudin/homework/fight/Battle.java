package ru.dyudin.homework.fight;

public class Battle {
    void start(){
        MeleeWarrior knight = new MeleeWarrior();
        RangedWarrior archer = new RangedWarrior();
        knight.setName("Knight");
        archer.setName("Archer");
        knight.run();
        archer.shootSomething();
        knight.blockWithSomething();
        knight.hitWithSomething();
        archer.dodgeLeft();
        archer.run();
        knight.hitWithSomething();
        archer.die();

    }
}
