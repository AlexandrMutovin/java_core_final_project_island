package ru.javarush.amutovin.core.island.Animals;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.interfaces.Eatable;
import ru.javarush.amutovin.core.island.interfaces.Movable;
import ru.javarush.amutovin.core.island.interfaces.Reproductable;

import java.util.*;

public abstract class Animal implements Eatable, Movable, Reproductable {
    @Getter
    private String typeAnimal;

    protected double weight;

    protected int maxSpeed;

    @Getter
    protected double currentEat;

    @Getter
    protected double fullEat;

    @Override
    public boolean move() {
        return false;
    }

    private String findRandomEat(Map<String, Double> weightAnimal, Map<String, TreeMap<Integer, String[]>> whoCanEat) {
        TreeMap<Integer, String[]> whoCanIEat = whoCanEat.get(typeAnimal);
        Random random = new Random();
        int chanceToEat = random.nextInt(100);

        Map.Entry<Integer, String[]> pair = whoCanIEat.ceilingEntry(chanceToEat) != null ?
                whoCanIEat.ceilingEntry(chanceToEat) : whoCanIEat.floorEntry(chanceToEat);

        String[] arrayWhoCanIEat = pair.getValue();
        return arrayWhoCanIEat[random.nextInt(arrayWhoCanIEat.length)];
    }

    @Override
    public void eat(double whoCanIEat) {
        currentEat += currentEat;
    }

    protected void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public abstract Animal clone();
}
