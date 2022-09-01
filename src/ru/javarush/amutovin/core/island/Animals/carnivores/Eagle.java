package ru.javarush.amutovin.core.island.Animals.carnivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Carnivore;

import java.util.Random;

public class Eagle extends Animal implements Carnivore {
    public Eagle(){
        setTypeAnimal("Eagle");
        this.weight = 6;
        this.maxDistance = 3;
        this.fullEat = 1;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Eagle();
    }
}
