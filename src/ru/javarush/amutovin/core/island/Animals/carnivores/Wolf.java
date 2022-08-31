package ru.javarush.amutovin.core.island.Animals.carnivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Carnivore;

import java.util.Random;

public class Wolf extends Animal implements Carnivore {
    public Wolf(){
        setTypeAnimal("Wolf");
        this.weight = 50;
        this.fullEat = 8;
        this.maxSpeed = 3;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Wolf();
    }
}
