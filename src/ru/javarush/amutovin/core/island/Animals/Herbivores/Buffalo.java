package ru.javarush.amutovin.core.island.Animals.Herbivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Animals.Carnivores.Boa;
import ru.javarush.amutovin.core.island.Interfaces.Herbivore;

import java.util.Random;

public class Buffalo extends Animal implements Herbivore {
    public Buffalo(){
        setTypeAnimal("Buffalo");
        this.weight = 700;
        this.maxSpeed = 3;
        this.fullEat = 100;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Buffalo();
    }
}
