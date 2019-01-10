package pl.mk.animals_homework.models;

import pl.mk.animals_homework.Animal;

public abstract class Bird extends Animal {

    private String featherColor;

    public String getScaleColor() {
        return featherColor;
    }

    public void setScaleColor(String scaleColor) {
        this.featherColor = scaleColor;
    }

    @Override
    public void eat() {

    }
}
