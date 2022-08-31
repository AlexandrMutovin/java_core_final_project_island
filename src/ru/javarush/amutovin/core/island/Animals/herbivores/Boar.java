package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Animals.carnivores.Bear;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

import java.util.Random;

public class Boar extends Animal implements Herbivore {
    public Boar(){
        setTypeAnimal("Boar");
        this.weight = 400;
        this.maxSpeed = 2;
        this.fullEat = 50;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Bear();
    }


}
