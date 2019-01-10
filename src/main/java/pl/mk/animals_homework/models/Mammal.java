package pl.mk.animals_homework.models;

public abstract class Mammal extends Animal {

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    String furColor;


    @Override
    public void eat() {

    }
}
