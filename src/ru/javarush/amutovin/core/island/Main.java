package ru.javarush.amutovin.core.island;

public class Main {
    public static void main(String[] args) {
        Island island = InitialIsland.getInstance(1,1);
        System.out.println(island.getStatistic());
        island.goEat();
        System.out.println(island.getStatistic());

    }


}
