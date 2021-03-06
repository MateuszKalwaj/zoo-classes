package pl.mk.animals_homework.models;

import pl.mk.animals_homework.Intefaces.MeatEater;

public class Wolf extends Mammal implements MeatEater {

    @Override
    public void eatMeat() {
        System.out.println(getName() + " is eating meat.");
    }
    // wolf can howl
    public void howl() {
        System.out.println(getName() + " is howling!");
    }


    @Override
    public void eat() {
        eatMeat();
    }
}
