package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

import java.util.Random;

public class Buffalo extends Animal implements Herbivore {
    public Buffalo(){
        setTypeAnimal("Buffalo");
        this.weight = 700;
        this.maxDistance = 3;
        this.fullEat = 100;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Buffalo();
    }
}
