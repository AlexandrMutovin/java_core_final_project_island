package ru.javarush.amutovin.core.island.Animals.Herbivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Animals.Carnivores.Boa;
import ru.javarush.amutovin.core.island.Interfaces.Herbivore;

import java.util.Random;

public class Caterpillar extends Animal implements Herbivore {
    public Caterpillar() {
        setTypeAnimal("Caterpillar");
        this.weight = 0.01;
        this.maxSpeed = 0;
        this.fullEat = 0;
    }

    @Override
    public Animal clone() {
        return new Caterpillar();
    }

}
