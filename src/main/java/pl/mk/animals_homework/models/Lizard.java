package pl.mk.animals_homework.models;

public abstract class Lizard extends Animal {

    private String scaleColor;

    public String getscaleColor() {
        return scaleColor;
    }

    public void setscaleColor(String featherColor) {
        this.scaleColor = featherColor;
    }

    @Override
    public void eat() {

    }
}
