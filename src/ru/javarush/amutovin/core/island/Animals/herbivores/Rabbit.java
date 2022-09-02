package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

import java.util.Random;


public class Rabbit extends Animal implements Herbivore {
    public Rabbit(){
        setTypeAnimal("Rabbit");
        this.weight = 2;
        this.maxDistance = 2;
        this.fullEat = 0.45;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Rabbit();
    }
}
