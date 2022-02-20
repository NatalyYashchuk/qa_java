package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(Parameterized.class)
public class AnimalTest {
    private Animal animal;

    private final String animalType;
    private final List<String> foodType;
    private static final List<String> listOfHerbivores = List.of("Трава", "Различные растения");
    private static final List<String> listOfPredator = List.of("Животные", "Птицы", "Рыба");



    public AnimalTest (String animalType,List<String> foodType ) {
        this.animalType = animalType;
        this.foodType = foodType;
    }

    @Parameterized.Parameters
    public static Object [][] getTestAnimalData(){
        return new Object[][] {
                {"Травоядное",listOfHerbivores},
                {"Хищник", listOfPredator},

        };
    }

    @Before
    public void setUp()  {
        animal = new Animal();

    }

    @Test
    public void testAnimalGetFoodSuccess() throws Exception {
        assertEquals("getFood Animal works improperly",foodType, animal.getFood(animalType));
    }


    @Test
    public void testAnimalGetFamily() {
        String requiredGetFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals("Incorrect getFamily name",requiredGetFamily, animal.getFamily());
    }

}
