package ru.javarush.amutovin.core.island.Animals.Carnivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Interfaces.Carnivore;

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
