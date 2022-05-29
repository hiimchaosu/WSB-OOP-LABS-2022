package com.company;

import com.company.devices.Car;
import com.company.devices.Device;
import com.company.devices.OperatingSystem;
import com.company.devices.Phone;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Animal dog = new Animal("dog", FoodType.MEAT);

        dog.name = "Szarik";

        Human me = new Human(1000.0);
        me.firstName = "Kacper";
        me.lastName = "Warda";
        me.pet = dog;
        me.hashCode();

        me.feed(1.0, FoodType.ALL);
        System.out.println(me.species);

        Phone onePlus = new Phone("onePlus",
                "8Pro",
                2.3,
                OperatingSystem.Android);

        Phone iPhone6 = new Phone("apple", "6s", 5.0, OperatingSystem.iOS);

        System.out.println("phone: " + onePlus);
        System.out.println("phone: " + iPhone6);
        System.out.println("human: " + me);


        onePlus.turnOn();

        Car fiat = new Car("fiat", "bravo");
        fiat.engineSize = 1.9;
        fiat.fuelType = "disel";
        System.out.println(fiat.producer);

        dog.feed(1.0, FoodType.MEAT);

        Human brother = new Human(1231.2);

        dog.sell(me, brother, 1.0);

        fiat.refill();

        Animal cat = new Animal("cat", FoodType.MEAT);
        cat.feed(10.0, FoodType.MEAT);


        Animal dog1 = new Animal("dog", FoodType.ALL);
        dog1.feed(10.0, FoodType.ALL);

        System.out.println("Country GDP in PLN" + Country.POLAND.getGdpInPln());

        Map<Country, Double> area = new HashMap<>();
        area.put(Country.POLAND, 654654654.654);
        area.put(Country.NORWAY, 43243212.432);
        area.put(Country.ISLEOFMAN, 97532346.456);
        area.put(Country.VIETNAM, 159725.511);
        area.put(Country.ENGLAND, 1648527.542);

        double minimum = Collections.min(area.values());
        double maximum = Collections.max(area.values());

        for (Map.Entry<Country, Double> item : area.entrySet()) {
            if (item.getValue().equals(minimum)) {
                System.out.println("The minimum value is: " + item.getValue() + " and the country code is: " + item.getKey().getCode() + " and the language is: " + item.getKey().getLanguage());
            }
            else if (item.getValue().equals(maximum)) {
                System.out.println("The maximum value is: " + item.getValue() + " and the country code is: " + item.getKey().getCode() + " and the language is: " + item.getKey().getLanguage());
            }
        }

        Map<String, Country> capital = new HashMap<>();
        capital.put("Warsaw", Country.POLAND);
        capital.put("Oslo", Country.NORWAY);
        capital.put("Douglas", Country.ISLEOFMAN);
        capital.put("Hanoi", Country.VIETNAM);
        capital.put("London", Country.ENGLAND);

        Map<String, Country> capitalSorted = new TreeMap<>(capital);

        for (Map.Entry<String, Country> cap : capitalSorted.entrySet()) {
            System.out.println("Capitals from smallest to biggest: " + cap.getKey());
        }

        Animal cziko = new Pet("dog", FoodType.MEAT, "Cziko");
        Animal evie = new Pet("cat", FoodType.MEAT, "Evie");
        Animal catto = new FarmAnimal("cat", FoodType.CROPS, "Kuro");
        Animal doggo = new FarmAnimal("dog", FoodType.CROPS, "Shiro");
        Animal name_Human = new Human(2000.0);
        Animal surname_Human = new Human(2000.0);

        List<Animal> petsList = new ArrayList<>();
        petsList.add(cziko);
        petsList.add(evie);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(catto);
        animalList.add(doggo);

        List<Animal> humanList = new ArrayList<>();
        humanList.add(name_Human);
        humanList.add(surname_Human);

        Map<FoodType, List<Animal>> animalMap = new HashMap<>();
        animalMap.put(FoodType.MEAT, petsList);
        animalMap.put(FoodType.ALL, humanList);
        animalMap.put(FoodType.CROPS, animalList);

        System.out.println(animalMap.get(FoodType.CROPS));
        System.out.println(animalMap.get(FoodType.ALL));
        System.out.println(animalMap.get(FoodType.MEAT));

        Car ferrari = new Car("Ferrari", "458");
        ferrari.startACar();

        List<Animal> animals = new LinkedList<>();

        animals.add(new Human(1000.0));
        animals.add(new Human(80.0));
        animals.add(new Pet("cat", FoodType.ALL, "Kocik"));
        animals.add(new Pet("dog", FoodType.ALL, "Piesio"));
        animals.add(new FarmAnimal("cow", FoodType.CROPS, "Stefan"));
        animals.add(new FarmAnimal("chicken", FoodType.CROPS, "Kurok"));
        animals.get(0).setWeight(80.0);
        animals.get(0).name = "Kasia";
        animals.get(1).setWeight(90.0);
        animals.get(1).name = "Rook";
        animals.get(2).setWeight(6.3);
        animals.get(3).setWeight(14.2);
        animals.get(4).setWeight(1000.0);
        animals.get(5).setWeight(1.5);

        // sorting the list using comparator
        Collections.sort(animals, new Comparator<>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(animals);

        // print out the list
        for (Animal animal : animals) {
            System.out.println("The weight of the animal " + animal.species + " is: " + animal.getWeight());
        }

        //Task 11
        Collections.sort(animals, (o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        //or
        Collections.sort(animals, Comparator.comparing(Animal::getWeight));

        //print out

        System.out.println(animals);


        //API
        //create the account

        System.out.println("***************API*************");

        APIConnector connector = new APIConnector();
        try{

            String data = connector.getCurrencyData();
            System.out.println(data.toString());
            String [] array = data.split(",");
            String numberValue;
            double plnvalue;
            for (String s : array){
                if (s.contains("PLN")) {
                    numberValue = s.split(":")[1];
                    plnvalue = Double.parseDouble(numberValue);
                    System.out.println(plnvalue);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //API Using JSON Library
        try {
            connector.getCurrency(connector.getCurrencyData());
        }catch (Exception e){
            e.printStackTrace();
        }
        // Task 12
        try {
            connector.exchangeToPln(2000.0, 4.25, connector.getCurrencyData());
        }catch (Exception e){
            e.getMessage();
        }
    }
}


