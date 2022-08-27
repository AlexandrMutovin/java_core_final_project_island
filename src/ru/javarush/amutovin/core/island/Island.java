package ru.javarush.amutovin.core.island;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
        stringBuilder.append(sizeX + " X " + sizeY);
        stringBuilder.append(separator);
        stringBuilder.append("Количество животных на острове: ");
        stringBuilder.append(getAnimalCount());
        stringBuilder.append(separator);
        stringBuilder.append("Из них: ");
        stringBuilder.append(separator);
        stringBuilder.append(getUniqueAnimalCount());
        stringBuilder.append("Количество растений на острове: ");
        stringBuilder.append(getPlantCount());
        return stringBuilder.toString();
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

    private String getUniqueAnimalCount(){
        Map<String, Integer>  mapAminal = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        List<Animal> allAnimalList = new ArrayList<>();

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                allAnimalList.addAll(cells[x][y].getAnimalList());
            }

            mapAminal = allAnimalList.stream()
            .collect(Collectors.toMap(key -> key.getClass().getSimpleName(),
             value -> 1, (value, value2) -> (int)value + 1,
             TreeMap::new
             ));

        }

        for (Map.Entry<String, Integer> pair: mapAminal.entrySet()) {
            stringBuilder.append(pair.getKey() + " = " + pair.getValue());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }

}
