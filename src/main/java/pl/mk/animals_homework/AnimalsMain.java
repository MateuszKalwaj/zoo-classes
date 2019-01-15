package pl.mk.animals_homework;

import pl.mk.animals_homework.Intefaces.MeatEater;
import pl.mk.animals_homework.Intefaces.PlantEater;
import pl.mk.animals_homework.models.*;

import java.io.*;

public class AnimalsMain {
    /**
     * Main class
     *
     * @param args supplies command-line arguments as an array of String object
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the ZOO!");

        //new created animal array
        Animal[] zoo;

        //path for saving text files
        String filePath = "zoo100.txt";

        //path for saving binary files
        String binaryPath = "zooBinary";

        while (true) {
            zoo = load();
            save(filePath, zoo);
            System.out.println();
            printZoo(zoo);
            feedAllAnimals(zoo);
            feedAllMeatEaters(zoo);
            feedAllPlantEaters(zoo);
            howlAll(zoo);
            hissAll(zoo);
            tweetAll(zoo);
            saveBinaryAnimals(binaryPath,zoo);
            zoo = loadBinaryAnimals(binaryPath);
            printZoo(zoo);
            break;
        }
    }

    /**
     * method to load the file
     * @return an empty array in case of exception
     */
    //method which should load text file to program
    private static Animal[] load() {

        String file = "zoo.txt";

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            //variables define
            String animalsCount = br.readLine();
            int count = Integer.parseInt(animalsCount);

            //array create
            Animal[] zoo = new Animal[count];

            for (int i = 0; i < count; i++) {

                //Read animal species
                String animalSpecies = br.readLine();

                //Create new animal
                Animal animal = null;

                if ("Wolf".equals(animalSpecies)) {
                    animal = new Wolf();
                } else if ("Parrot".equals(animalSpecies)) {
                    animal = new Parrot();
                } else if ("Iguana".equals(animalSpecies)) {
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
                if (animal instanceof Wolf) {
                    ((Mammal) animal).setFurColor(animalColor);
                } else if (animal instanceof Parrot) {
                    ((Bird) animal).setFeatherColor(animalColor);
                } else {
                    ((Lizard) animal).setscaleColor(animalColor);
                }
                //prints lines from text file
                //System.out.println(i + " " + animal.getName() + " " + animal.getAge());
            }

            return zoo;

        } catch (IOException ex) {

            System.err.println(ex);

            return new Animal[0]; //returns empty table in case of exception
        }
    }

    /**
     *
     * @param file is the path to save the file
     * @param animals is new animal array
     */
    private static void save(String file, Animal[] animals) {

        try (FileWriter fw = new FileWriter(file)) {

            //save array into the file
            fw.write(animals.length + "\n");

            for (int i = 0; i < animals.length; i++) {

                //set how animals should be saved
                if (animals[i] instanceof Wolf) {
                    String species = "Wolf";
                    fw.write(species + "\n");
                } else if (animals[i] instanceof Parrot) {
                    String species = "Parrot";
                    fw.write(species + "\n");
                } else if (animals[i] instanceof Iguana) {
                    String species = "Iguana";
                    fw.write(species + "\n");
                }

                //write animals using their names
                fw.write(animals[i].getName());

                //write animals using their age
                fw.write(animals[i].getAge());

                //write animals using their color
                if (animals[i] instanceof Wolf) {
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

    /**
     * Print all animals
     * @param animals is the animals array
     */
    private static void printZoo(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            System.out.println((i + 1) + " Animal in the zoo is: " +
                    animals[i].getName() + ", which is " +
                    animals[i].getAge() + " years old.");

            //prints what species is the animal
            if (animals[i] instanceof Wolf) {
                System.out.println("belongs to species of wolfs");
            } else if (animals[i] instanceof Parrot) {
                System.out.println("belongs to species of parrots");
            } else if (animals[i] instanceof Iguana) {
                System.out.println("belongs to species of iguana");
            }
            //prints what color is animal
            if (animals[i] instanceof Mammal) {
                System.out.println("color of fur: " + ((Mammal) animals[i]).getFurColor());
            }else if (animals[i] instanceof Bird) {
                System.out.println("color of feathers: " + ((Bird) animals[i]).getFeatherColor());
            }else if (animals[i] instanceof Lizard) {
                System.out.println("color of scale: " + ((Lizard) animals[i]).getscaleColor());
            }
        }
    }

    /**
     * *Feed* methods are for feeding the animals
     * @param animals is the animal array
     */
    private static void feedAllAnimals (Animal [] animals) {
        System.out.println("\n I am now feeding all animals in the zoo: \n");
        for( Animal animal : animals) {
            animal.eat();
        }
    }

    private static void feedAllMeatEaters (Animal[] animals) {
        System.out.println("\n I am now feeding all meat eaters: \n");
        for (Animal animal : animals) {
            if (animal instanceof MeatEater) {
                ((MeatEater)animal).eatMeat();
            }
        }
    }

    private static void feedAllPlantEaters (Animal[] animals) {
        System.out.println("\n I am now feeding all plant eaters: \n");
        for (Animal animal : animals) {
            if (animal instanceof PlantEater) {
                ((PlantEater)animal).eatPlant();
            }
        }
    }

    /**
     * methods for howling, hissing and tweeting
     * @param animals is the animal array
     */
    private static void howlAll (Animal[] animals) {
        System.out.println("\n Animals that howls: \n");
        for (Animal animal : animals) {
            if (animal instanceof Wolf) {
                ((Wolf) animal).howl();
            }
        }
    }

    private static void hissAll (Animal[] animals) {
        System.out.println("\n Animals that hisses: \n");
        for (Animal animal : animals) {
            if (animal instanceof Iguana) {
                ((Iguana) animal).hiss();
            }
        }
    }

    private static void tweetAll (Animal[] animals) {
        System.out.println("\n Animals that tweets: \n");
        for (Animal animal : animals) {
            if (animal instanceof Parrot) {
                ((Parrot) animal).tweet();
            }
        }
        System.out.println("\n");
    }

    /**
     * Methods for save and load binary files
     * @param file is the file path
     * @param animals is the animal array
     */

    private static void saveBinaryAnimals (String file, Animal[] animals) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(animals);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static Animal[] loadBinaryAnimals (String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Animal[]) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
            return null;
        }
    }
}


