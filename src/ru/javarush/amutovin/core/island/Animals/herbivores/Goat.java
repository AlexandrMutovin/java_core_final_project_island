package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

import java.util.Map;
import java.util.Random;

public class Goat extends Animal implements Herbivore {
    public Goat(){
        setTypeAnimal("Goat");

        this.weight = 60;
        this.maxDistance = 3;
        this.fullEat = 10;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Goat();
    }

}
