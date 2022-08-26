package ru.javarush.amutovin.core.island.Animals.Carnivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Interfaces.Carnivore;

import java.util.Random;

public class Boa extends Animal implements Carnivore {
    public Boa(){
        setTypeAnimal("Boa");
        this.weight = 15;
        this.maxSpeed = 1;
        this.fullEat = 3;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Boa();
    }
}
