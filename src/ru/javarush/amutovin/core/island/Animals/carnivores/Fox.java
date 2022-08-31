package ru.javarush.amutovin.core.island.Animals.carnivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Carnivore;

import java.util.Random;

public class Fox extends Animal implements Carnivore {
    public Fox(){
        setTypeAnimal("Fox");
        this.weight = 8;
        this.maxSpeed = 2;
        this.fullEat = 2;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Fox();
    }
}
