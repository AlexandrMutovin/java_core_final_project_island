package ru.javarush.amutovin.core.island.Animals.Herbivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Animals.Carnivores.Boa;
import ru.javarush.amutovin.core.island.Interfaces.Herbivore;

import java.util.Random;


public class Rabbit extends Animal implements Herbivore {
    public Rabbit(){
        setTypeAnimal("Rabbit");
        this.weight = 2;
        this.maxSpeed = 2;
        this.fullEat = 0.45;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Rabbit();
    }
}
