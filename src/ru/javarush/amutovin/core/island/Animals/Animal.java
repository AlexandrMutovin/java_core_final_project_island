package ru.javarush.amutovin.core.island.Animals;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.interfaces.Eatable;
import ru.javarush.amutovin.core.island.interfaces.Movable;
import ru.javarush.amutovin.core.island.interfaces.Reproductable;

import java.util.*;

public abstract class Animal implements Eatable, Movable, Reproductable {

    protected static final int RANGE_FOR_AXIS_SELECTION = 2;
    @Getter
    private String typeAnimal;

    protected double weight;

    protected int maxDistance;

    @Getter
    @Setter
    protected double currentEat;

    @Getter
    protected double fullEat;

    @Override
    public Integer move() {
        Random random = new Random();
        int selectAxis = random.nextInt(RANGE_FOR_AXIS_SELECTION);
        return  random.nextInt(maxDistance +1);

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
        if (fullEat > currentEat) {
            double diff = fullEat - currentEat;
            if (whoCanIEat > diff){
                currentEat = fullEat;
            } else currentEat = currentEat + whoCanIEat;
        }
    }

    protected void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public abstract Animal clone();
}
