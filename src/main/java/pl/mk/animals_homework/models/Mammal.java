package pl.mk.animals_homework.models;

import java.io.Serializable;

public abstract class Mammal extends Animal {

    private String furColor;
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }



}
