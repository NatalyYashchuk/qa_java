package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CatTest {
    private Cat cat;

    Feline mockFeline;

    @Before
    public void setUp () {
        mockFeline = Mockito.mock(Feline.class);
        cat = new Cat (mockFeline);
    }

    @Test
    public void testCatGetFoodEatMeatSuccessfull() throws Exception {
        List<String> predatorFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(predatorFoodList);
        assertEquals("eatMeat Cat has not been invoked", predatorFoodList,cat.getFood());
        Mockito.verify(mockFeline).eatMeat();
    }

    @Test
    public void testCatGetSoundSuccessfull(){
        String soundCat = "Мяу";
        assertEquals("getSound Cat works improperly",soundCat,cat.getSound());
    }
}
