package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

import java.util.Random;

public class Duck extends Animal implements Herbivore {
    public Duck(){
        setTypeAnimal("Duck");
        this.weight = 1;
        this.maxSpeed = 4;
        this.fullEat = 0.15;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Duck();
    }
}
