package pl.mk.animals_homework.models;

import java.io.Serializable;

public abstract class Bird extends Animal {

    private String featherColor;

    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String scaleColor) {
        this.featherColor = scaleColor;
    }

}
