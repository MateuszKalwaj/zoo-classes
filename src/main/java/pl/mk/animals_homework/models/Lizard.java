package pl.mk.animals_homework.models;

import pl.mk.animals_homework.Animal;

public abstract class Lizard extends Animal {

    private String scaleColor;

    public String getFeatherColor() {
        return scaleColor;
    }

    public void setFeatherColor(String featherColor) {
        this.scaleColor = featherColor;
    }

    @Override
    public void eat() {

    }
}
