package pl.mk.animals_homework.models;

import pl.mk.animals_homework.Intefaces.PlantEater;

public class Iguana extends Lizard implements PlantEater {

    @Override
    public void eatPlant() {
        System.out.println(getName() + " is eating plants.");
    }
    //Iguana can hiss
    public void hiss() {
        System.out.println(getName() + " is hissing.");
    }

    @Override
    public void eat() {
        eatPlant();
    }
}
