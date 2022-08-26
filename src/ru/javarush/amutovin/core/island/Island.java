package ru.javarush.amutovin.core.island;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Island {
    @Getter
    @Setter
    private int sizeX;

    @Getter
    @Setter
    private int sizeY;

    @Getter
    @Setter
    private Cell[][] cells;

    public Island(Cell[][] cells) {
        this.cells = cells;
        this.sizeX = cells.length;
        this.sizeY = cells[0].length;

    }

    public String getStatistic() {
        String separator = System.getProperty("line.separator");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Остров содержит: ");
        stringBuilder.append(separator);
        stringBuilder.append("Размер острова (количество клеток x, y): ");
        stringBuilder.append(sizeX + " " + sizeY);
        stringBuilder.append(separator);
        stringBuilder.append("Количество животных на острове: ");
        stringBuilder.append(getAnimalCount());
        stringBuilder.append(separator);
        stringBuilder.append("Количество растений на острове: ");
        stringBuilder.append(getPlantCount());
        return "";
    }

    private int getAnimalCount() {
        int animalCount = 0;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                animalCount += cells[x][y].getAnimalList().size();
            }

        }
        return animalCount;
    }

    private int getPlantCount() {
        int plantCount = 0;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                plantCount += cells[x][y].getPlants();
            }

        }
        return plantCount;
    }

}
