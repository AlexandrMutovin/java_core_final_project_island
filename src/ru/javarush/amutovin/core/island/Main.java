package ru.javarush.amutovin.core.island;

public class Main {
    public static void main(String[] args) {
        int sizeX = Integer.parseInt(args[0]);
        int sizeY = Integer.parseInt(args[1]);
        int countOfDay = Integer.parseInt(args[1]);

        Island island = InitialIsland.getInstance(sizeX,sizeY);
        System.out.println(island.getStatistic());
        island.startNewDay(countOfDay);
        System.out.println();
        System.out.printf("Прошло %d дней,  статистика следующая:",countOfDay);
        System.out.println();
        System.out.println(island.getStatistic());

    }


}
