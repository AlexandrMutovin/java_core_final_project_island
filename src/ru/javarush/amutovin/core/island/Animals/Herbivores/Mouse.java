package ru.javarush.amutovin.core.island.Animals.Herbivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Animals.Carnivores.Boa;
import ru.javarush.amutovin.core.island.Interfaces.Herbivore;

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
