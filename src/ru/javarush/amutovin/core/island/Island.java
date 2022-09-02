package ru.javarush.amutovin.core.island;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;

import java.util.*;
import java.util.stream.Collectors;

public class Island {
    private static final int RANGE_FOR_SELECT_AXIS = 2;
    private static final int X_AXIS = 0;
    private static final int Y_AXIS = 0;

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
        stringBuilder.append(getUniqueAnimalCount(cells));
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

    private String getUniqueAnimalCount(Cell[][] cells) {
        Map<String, Integer> mapAminal = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        List<Animal> allAnimalList = new ArrayList<>();

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                allAnimalList.addAll(cells[x][y].getAnimalList());
            }

            mapAminal = allAnimalList.stream()
                    .collect(Collectors.toMap(key -> key.getClass().getSimpleName(),
                            value -> 1, (value, value2) -> (int) value + 1,
                            TreeMap::new
                    ));

        }

        for (Map.Entry<String, Integer> pair : mapAminal.entrySet()) {
            stringBuilder.append(pair.getKey() + " = " + pair.getValue());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }


    public void startNewDay(int countOfDay) {
        for (int dayNum = 0; dayNum < countOfDay; dayNum++) {
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    cells[x][y].setPlants(new Random().nextDouble(1000.0));
                    cells[x][y].hungry();
                    cells[x][y].startEat(Data.getWeightAnimal(), Data.getWhoCanEat());
                    cells[x][y].killAnimal();
                }
            }
            reproductable();
            startMove();
        }
    }

    public void startMove() {
        Cell[][] tempCells = initialTempCells();

        List<Animal> currentAnimalList = new ArrayList<>();
        Random random = new Random();
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                currentAnimalList = cells[x][y].getAnimalList();

                for (int i = 0; i< currentAnimalList.size(); i++){
                    Animal nextAnimal = currentAnimalList.get(i);
                    int newCoordinatesMove = nextAnimal.move();
                    int selectAxis = random.nextInt(RANGE_FOR_SELECT_AXIS);
                    if (selectAxis == X_AXIS) {
                        if ((newCoordinatesMove + x) < sizeX) {
                            tempCells[newCoordinatesMove + x][y].addAnimal(nextAnimal);
                        } else {
                            tempCells[x][y].addAnimal(nextAnimal);
                        }
                    } else if ((newCoordinatesMove + y) < sizeY){

                        tempCells[x][newCoordinatesMove + y].addAnimal(nextAnimal);
                    } else {
                        tempCells[x][y].addAnimal(nextAnimal);
                    }
                }
            }
        }

        for (int x = 0; x < tempCells.length; x++){
            for (int y = 0; y < tempCells[x].length; y++){
                cells[x][y].setAnimalList(tempCells[x][y].getAnimalList());
            }
        }
    }
    private Cell[][] initialTempCells(){
        Cell[][] tempCells= new Cell[sizeX][sizeY];
        for (int x = 0; x < tempCells.length; x++){
            for (int y = 0; y < tempCells[x].length; y++){
                tempCells[x][y] = new Cell();
            }
        }
        return tempCells;
    }

    public void reproductable(){
        List<String> animalHowReproductable = new ArrayList<>();
        List<Animal> animalList = new ArrayList<>();
        for (int x = 0; x < cells.length; x++){
            for (int y = 0; y < cells[x].length; y++){
                animalList = cells[x][y].getAnimalList();
                for (int i = 0; i < animalList.size(); i++){
                    Animal nextAnimal = animalList.get(i);
                    if (!animalHowReproductable.contains(nextAnimal.getTypeAnimal())){
                        cells[x][y].addAnimal(animalList.get(i).clone());
                        animalHowReproductable.add(nextAnimal.getTypeAnimal());
                    }

                }
            }
        }
    }




}
