package ru.javarush.amutovin.core.island.Animals.herbivores;

import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.interfaces.Herbivore;

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
