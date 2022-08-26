package ru.javarush.amutovin.core.island;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;
import ru.javarush.amutovin.core.island.Animals.Carnivores.Boa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cell {
    @Setter
    private int maxX;

    @Setter
    private int maxY;

    @Setter
    @Getter
    private int currentX;

    @Setter
    @Getter
    private int currentY;


    @Setter
    @Getter
    private int plants;

    @Getter
    private List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

   /* public int getCountAnimal(Boa v){
        List<Animal> list = animalList.stream()
                .filter(s -> s instanceof Boa
                ).collect(Collectors.toList());
        return list.size();
    }*/
}
