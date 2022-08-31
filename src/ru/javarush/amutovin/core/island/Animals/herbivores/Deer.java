package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

import java.util.Random;


public class Deer extends Animal implements Herbivore {
    public Deer(){
        setTypeAnimal("Deer");
        this.weight = 300;
        this.fullEat = 50;
        this.maxSpeed = 4;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Deer();
    }
}
