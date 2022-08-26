package ru.javarush.amutovin.core.island.Animals.Carnivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Interfaces.Carnivore;

import java.util.Random;

public class Eagle extends Animal implements Carnivore {
    public Eagle(){
        setTypeAnimal("Eagle");
        this.weight = 6;
        this.maxSpeed = 3;
        this.fullEat = 1;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Eagle();
    }
}
