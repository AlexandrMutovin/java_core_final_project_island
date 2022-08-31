package ru.javarush.amutovin.core.island;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Animals.carnivores.*;
import ru.javarush.amutovin.core.island.Animals.herbivores.*;

import java.util.*;

public class InitialIsland {
    static Map<String, Integer> maxAnimalInCell = new HashMap<>();
    static List<Animal> animalList = new ArrayList<>();

    static {
        maxAnimalInCell.put("Bear", 30);
        maxAnimalInCell.put("Boa", 30);
        maxAnimalInCell.put("Eagle", 20);
        maxAnimalInCell.put("Fox", 30);
        maxAnimalInCell.put("Wolf", 30);
        maxAnimalInCell.put("Boar", 50);
        maxAnimalInCell.put("Buffalo", 10);
        maxAnimalInCell.put("Caterpillar", 1000);
        maxAnimalInCell.put("Deer", 20);
        maxAnimalInCell.put("Duck", 200);
        maxAnimalInCell.put("Goat", 140);
        maxAnimalInCell.put("Horse", 20);
        maxAnimalInCell.put("Mouse", 500);
        maxAnimalInCell.put("Rabbit", 150);
        maxAnimalInCell.put("Sheep", 140);

        animalList.add(new Bear());
        animalList.add(new Boa());
        animalList.add(new Eagle());
        animalList.add(new Fox());
        animalList.add(new Wolf());
        animalList.add(new Boar());
        animalList.add(new Buffalo());
        animalList.add(new Caterpillar());
        animalList.add(new Deer());
        animalList.add(new Duck());
        animalList.add(new Goat());
        animalList.add(new Horse());
        animalList.add(new Mouse());
        animalList.add(new Rabbit());
        animalList.add(new Sheep());
    }

    public static Island getInstance(int maxX, int maxY) {
        Cell[][] cells = new Cell[maxX][maxY];

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[0].length; y++) {
                cells[x][y] = getCell(x, y);
            }
        }

        Island island = new Island(cells);
        return island;
    }

    private static Cell getCell(int x, int y) {
        Cell cell = new Cell();
        for (int nextAnimal = 0; nextAnimal < animalList.size(); nextAnimal++) {
            Animal animal = animalList.get(nextAnimal);
            int maxCountAnimalThisType = maxAnimalInCell.get(animal.getTypeAnimal());
            Random random = new Random();
            int randomCount = random.nextInt(maxCountAnimalThisType);
            cell.setPlants(random.nextDouble(1000.0));
            cell.setCurrentX(x);
            cell.setCurrentY(y);

            for (int k = 0; k < randomCount; k++) {
                cell.addAnimal(animal.clone());
            }
        }

        return cell;
    }


}
