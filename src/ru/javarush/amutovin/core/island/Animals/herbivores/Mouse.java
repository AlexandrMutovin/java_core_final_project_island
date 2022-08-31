package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

import java.util.Random;

public class Mouse extends Animal implements Herbivore {
    public Mouse(){
        setTypeAnimal("Mouse");
        this.weight = 0.05;
        this.fullEat = 0.01;
        this.maxSpeed = 1;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Mouse();
    }
}
