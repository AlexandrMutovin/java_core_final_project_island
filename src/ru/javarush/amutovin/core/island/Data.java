package ru.javarush.amutovin.core.island;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Data {

    @Getter
    private static Map<String, Double> weightAnimal = new HashMap<>(){{
        put("Wolf", 50.0);
        put("Boa", 15.0);
        put("Fox", 8.0);
        put("Boar", 500.0);
        put("Eagle", 6.0);
        put("Horse", 400.0);
        put("Deer", 300.0);
        put("Rabbit", 2.0);
        put("Mouse", 0.05);
        put("Goat", 60.0);
        put("Sheep", 70.0);
        put("Boar", 400.0);
        put("Buffalo", 700.0);
        put("Duck", 1.0);
        put("Caterpillar", 0.01);
    }};
    @Getter
    private static Map<String, TreeMap<Integer, String[]>> whoCanEat = new HashMap<>();

    static {
        whoCanEat.put("Wolf",new TreeMap<>(){{
            put(10, new String[]{"Duck"});
            put(15, new String[]{"Boar", "Deer"});
            put(40, new String[]{"Duck"});
            put(60, new String[]{"Rabbit", "Goat"});
            put(70, new String[]{"Sheep"});
            put(80, new String[]{"Mouse"});
        }});
        whoCanEat.put("Boa",new TreeMap<>(){{
            put(10, new String[]{"Duck"});
            put(15, new String[]{"Fox"});
            put(20, new String[]{"Rabbit"});
            put(40, new String[]{"Mouse"});
        }});
        whoCanEat.put("Fox",new TreeMap<>(){{
            put(40, new String[]{"Caterpillar"});
            put(60, new String[]{"Duck"});
            put(70, new String[]{"Rabbit"});
            put(90, new String[]{"Mouse"});
        }});
        whoCanEat.put("Bear",new TreeMap<>(){{
            put(10, new String[]{"Duck"});
            put(20, new String[]{"Buffalo"});
            put(40, new String[]{"Horse"});
            put(50, new String[]{"Boar"});
            put(70, new String[]{"Sheep","Goat"});
            put(80, new String[]{"Boa", "Deer", "Rabbit"});
            put(90, new String[]{"Mouse"});
        }});
        whoCanEat.put("Eagle",new TreeMap<>(){{
            put(10, new String[]{"Fox"});
            put(80, new String[]{"Duck"});
            put(90, new String[]{"Rabbit", "Mouse"});
        }});
        whoCanEat.put("Horse",new TreeMap<>(){{
            put(100, new String[]{"Plants"});
        }});
        whoCanEat.put("Deer",new TreeMap<>(){{
            put(100, new String[]{"Plants"});
        }});
        whoCanEat.put("Rabbit",new TreeMap<>(){{
            put(100, new String[]{"Plants"});
        }});
        whoCanEat.put("Mouse",new TreeMap<>(){{
            put(90, new String[]{"Caterpillar", "Plants"});
        }});
        whoCanEat.put("Goat",new TreeMap<>(){{
            put(90, new String[]{"Plants"});
        }});
        whoCanEat.put("Sheep",new TreeMap<>(){{
            put(90, new String[]{"Plants"});
        }});
        whoCanEat.put("Boar",new TreeMap<>(){{
            put(50, new String[]{"Mouse"});
            put(90, new String[]{"Caterpillar", "Plants"});
        }});
        whoCanEat.put("Buffalo",new TreeMap<>(){{
            put(100, new String[]{"Plants"});
        }});
        whoCanEat.put("Duck",new TreeMap<>(){{
            put(90, new String[]{"Caterpillar"});
            put(100, new String[]{"Plants"});
        }});
        whoCanEat.put("Caterpillar",new TreeMap<>(){{
            put(100, new String[]{"Plants"});
        }});
    }
}
