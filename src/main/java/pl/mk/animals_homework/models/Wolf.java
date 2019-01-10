package pl.mk.animals_homework.models;

import pl.mk.animals_homework.Intefaces.MeatEater;

public class Wolf extends Mammal implements MeatEater {

    @Override
    public void eatMeat() {
        System.out.println(getName() + " is eating meat.");
    }
    // wolf can howl
    public void howling () {
        System.out.println(getName() + " is howling!");
    }


}
