package pl.mk.animals_homework.models;

public abstract class Mammal extends Animal {

    private String furColor;
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }


    @Override
    public void eat() {

    }
}
