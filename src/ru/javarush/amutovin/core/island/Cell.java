package ru.javarush.amutovin.core.island;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.core.island.Animals.Animal;

import java.util.*;

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
    private Double plants;

    @Getter
    private List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void killAnimal() {
        Iterator<Animal> iteratorAnimal = animalList.iterator();
        while (iteratorAnimal.hasNext()){
            Animal nextAnimal = iteratorAnimal.next();
            if (nextAnimal.getCurrentEat() == 0.0 && !nextAnimal.getTypeAnimal().equals("Caterpillar")){
                iteratorAnimal.remove();
            }
        }
    }
    public void startEat(Map<String, Double> weightAnimal, Map<String, TreeMap<Integer, String[]>> whoCanEat) {
        for (int i = 0; i < animalList.size(); i++) {
            Animal nextAnimal = animalList.get(i);
            if (nextAnimal == null) {
                continue;
            }
            String whoCanIEat = findRandomEat(weightAnimal, whoCanEat, nextAnimal);

            if ("Plants".equals(whoCanIEat)){
                double fullEat = nextAnimal.getFullEat();
                double currentEat = nextAnimal.getCurrentEat();
                double howCanIEat = fullEat - currentEat;
                if (plants > howCanIEat) {
                    plants = plants - howCanIEat;
                    nextAnimal.eat(howCanIEat);
                }
                else {
                    nextAnimal.eat(plants);
                    plants = 0.0;

                }
                continue;
            }
            double weightHowCanIEat = weightAnimal.get(whoCanIEat);
            for (int j = 0; j < animalList.size(); j++) {
                Animal animal = animalList.get(j);
                if (animal == null) {
                    continue;
                }
                if (whoCanIEat.equals(animalList.get(j).getTypeAnimal())){
                   // System.out.println("dell " + animalList.get(j).getTypeAnimal());
                    animalList.set(j, null);
                    nextAnimal.eat(weightHowCanIEat);
                   // System.out.println("Я " + nextAnimal.getTypeAnimal() +", " + " Съел " + whoCanIEat);
                    break;
                }
            }

        }
        Iterator<Animal> iterator = animalList.iterator();
        while (iterator.hasNext()) {
            Animal nextAnimal = iterator.next();
            if (nextAnimal == null) {
                iterator.remove();
            }
        }

    }

    private String findRandomEat(Map<String, Double> weightAnimal, Map<String, TreeMap<Integer, String[]>> whoCanEat, Animal animal) {
        TreeMap<Integer, String[]> whoCanIEat = whoCanEat.get(animal.getTypeAnimal());
        Random random = new Random();
        int chanceToEat = random.nextInt(100);

        Map.Entry<Integer, String[]> pair = whoCanIEat.ceilingEntry(chanceToEat) != null ?
                whoCanIEat.ceilingEntry(chanceToEat) : whoCanIEat.floorEntry(chanceToEat);

        String[] arrayWhoCanIEat = pair.getValue();
        return arrayWhoCanIEat[random.nextInt(arrayWhoCanIEat.length)];
    }


}
