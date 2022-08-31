package ru.javarush.amutovin.core.island.Animals.carnivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Carnivore;

import java.util.Random;

public class Bear extends Animal implements Carnivore {
    @Override
    public Animal clone() {
        return new Bear();
    }

    public Bear(){
        setTypeAnimal("Bear");
        this.weight = 500;
        this.maxSpeed = 2;
        this.fullEat = 80;

        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }
}
