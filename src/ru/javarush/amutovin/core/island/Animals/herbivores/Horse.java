package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


public class Horse extends Animal implements Herbivore {
    public Horse(){
        setTypeAnimal("Horse");
        this.weight = 400;
        this.maxDistance = 4;
        this.fullEat = 60;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Horse();
    }


}
