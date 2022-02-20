package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    private Lion lion;


    // добавь два поля класса: для проверяемой строки и ожидаемого результата
    private final String checkedSex;
    private final boolean expectedResult;


    Feline mockFeline;

    // напиши конструктор с двумя параметрами
    public LionTest(String checkedSex,boolean expectedResult ) {
        this.checkedSex = checkedSex;
        this.expectedResult = expectedResult;

    }
    // напиши метод для получения тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object [][]{
                {"Самец", true},
                {"Самка", false},
        };
    }


    @Before
    public void setUp() throws Exception {
        lion = new Lion(checkedSex);
        mockFeline = Mockito.mock(Feline.class);
    }

    @Test
    public void testLionDoesHaveManeSuccess() throws Exception {
        boolean actualhasMane = lion.doesHaveMane();
        assertEquals(expectedResult, actualhasMane);

    }


    @Test
    public void testLionGetKitten(){
        Mockito.when(mockFeline.getKittens()).thenReturn(3);
        lion.feline = mockFeline;
        int kittens = lion.getKittens();
        assertEquals("getKittens works improperly", 3, kittens);

    }

    @Test
    public void testLionGetFoodSuccess() throws Exception {
        List<String> predatorFoodRequired = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.getFood(Mockito.anyString())).thenReturn(predatorFoodRequired);
        lion.feline = mockFeline;
        List<String> predatorFood = lion.getFood();
        assertEquals("getFood Lion works improperly",predatorFoodRequired, predatorFood);

    }


}
