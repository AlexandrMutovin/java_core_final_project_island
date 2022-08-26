package ru.javarush.amutovin.core.island.Animals;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Interfaces.Eatable;
import ru.javarush.amutovin.core.island.Interfaces.Movable;
import ru.javarush.amutovin.core.island.Interfaces.Reproductable;

public abstract class Animal implements Eatable, Movable, Reproductable{
    @Getter
    private String typeAnimal;

    protected double weight;

    protected int maxSpeed;

    @Setter
    protected double currentEat;

    @Getter
    protected double fullEat;

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public boolean eat() {
        return false;
    }

    protected void setTypeAnimal(String typeAnimal){
        this.typeAnimal = typeAnimal;
    }
    public abstract Animal clone();
}
