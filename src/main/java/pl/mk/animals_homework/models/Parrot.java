package pl.mk.animals_homework.models;

import pl.mk.animals_homework.Intefaces.PlantEater;

public class Parrot extends Bird implements PlantEater {

    @Override
    public void eatPlant() {
        System.out.println(getName() + " is eating plants.");
    }
    //parrot can tweet
    public void tweet() {
        System.out.println(getName() + " is tweeting.");
    }

    @Override
    public void eat() {
        eatPlant();
    }
}
