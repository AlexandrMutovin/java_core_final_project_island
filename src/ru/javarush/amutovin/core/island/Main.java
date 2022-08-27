package ru.javarush.amutovin.core.island;

public class Main {
    public static void main(String[] args) {
        Island island = InitialIsland.getInstance(10,20);
        System.out.println(island.getStatistic());
    }


}
