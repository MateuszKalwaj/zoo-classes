package pl.mk.animals_homework;

import pl.mk.animals_homework.models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnimalsMain {
    /**
     * Main class
     * @param args supplies command-line arguments as an array of String object
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the ZOO");

        //new created animal array
        Animal[] zoo;

        //path for saving text files
        String filePath = "/zoo.txt";

        while (true) {
            zoo = load();
            save(filePath, zoo);
            break;
        }
    }

    //method which should load text file to program
    private static Animal[] load () {

        String file = "C:\\Users\\Mateusz\\IdeaProjects\\Animals_homework\\zoo.txt";

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            //variables define
            String animalsCount = br.readLine();
            int count = Integer.parseInt(animalsCount);

            //array create
            Animal[] zoo = new Animal[count];

            for (int i = 0; i<count; i++) {

                //Read animal species
                String animalSpecies = br.readLine();

                //Create new animal
                Animal animal = null;

                if ("Wolf".equals(animalSpecies)){
                    animal = new Wolf();
                } else if ("Parrot".equals(animalSpecies)){
                    animal = new Parrot();
                } else if ("Iguana".equals(animalSpecies)){
                    animal = new Iguana();
                } else {

                    System.out.println("Unknown species!");
                    break;

                }
                //Assign animal to an array
                zoo[i] = animal;

                //Read animal name
                String animalName = br.readLine();
                animal.setName(animalName);

                //Read animal age
                String animalAgeText = br.readLine();
                int animalAge = Integer.parseInt(animalAgeText);

                //Set animal age
                animal.setAge(animalAge);

                //Read animal color
                String animalColor = br.readLine();

                //Set animal color according to species
                if (animal instanceof Wolf){
                    ((Mammal) animal).setFurColor(animalColor);
                } else if (animal instanceof Parrot) {
                    ((Bird) animal).setFeatherColor(animalColor);
                } else {
                    ((Lizard) animal).setscaleColor(animalColor);
                }
                //prints lines from text file
                System.out.println(i + " " + animal.getName() + " " + animal.getAge());
            }

            return zoo;

        } catch (IOException ex) {

            System.err.println(ex);

            return new Animal[0]; //returns empty table in case of exception
        }
    }

    private static void save (String file, Animal[] animals) {
        System.out.println("Enter the path to save the file");

        try (FileWriter fw = new FileWriter(file)) {

            //save array into the file
            fw.write(animals.length + "\n");

            for (int i = 0; i < animals.length; i++) {

                //set how animals should be saved
                if (animals[i] instanceof Wolf) {
                    String species = "Wolf";
                    fw.write(species);
                    System.out.println(" ");
                } else if (animals[i] instanceof Parrot) {
                    String species = "Parrot";
                    fw.write(species);
                    System.out.println(" ");
                } else if (animals[i] instanceof Iguana) {
                    String species = "Iguana";
                    fw.write(species);
                    System.out.println(" ");
                }

                //write animals using their names
                fw.write(animals[i].getName());

                //write animals using their age
                fw.write(animals[i].getAge());

                //write animals using their color
                if (animals[i] instanceof Wolf){
                    fw.write(((Wolf) animals[i]).getFurColor());
                } else if (animals[i] instanceof Parrot) {
                    fw.write(((Parrot) animals[i]).getFeatherColor());
                } else if (animals[i] instanceof Iguana) {
                    fw.write(((Iguana) animals[i]).getscaleColor());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }
}
