package ru.javarush.amutovin.core.island.Animals.Herbivores;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Animals.Carnivores.Boa;
import ru.javarush.amutovin.core.island.Interfaces.Herbivore;

import java.util.Random;

public class Sheep extends Animal implements Herbivore {
    public Sheep(){
        setTypeAnimal("Sheep");
        this.weight = 70;
        this.fullEat = 15;
        this.maxSpeed = 3;
        Random random = new Random();
        this.currentEat = random.nextDouble(fullEat);
    }

    @Override
    public Animal clone() {
        return new Sheep();
    }
}
