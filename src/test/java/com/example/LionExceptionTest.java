package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(Parameterized.class)
public class LionExceptionTest {
    private Lion lion;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Feline feline;



    // добавь два поля класса: для проверяемой строки и ожидаемого результата
    private final String checkedFailedSex;


    // напиши конструктор с двумя параметрами
    public LionExceptionTest(String checkedFailedSex) {
        this.checkedFailedSex = checkedFailedSex;

    }
    // напиши метод для получения тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object [][]{
                {"Самецсамка"},
                {"Самец "},
                {" Самец"},
                {" "},
                {"0"},
                {"С@мец"},

        };
    }


    @Test
    public void lionDoesHaveManeFailedTest() throws Exception {

        Exception exception = null;
        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        try {
            Lion lionNoSex = new Lion(checkedFailedSex);
        } catch (Exception ex) {
            exception = ex;

        }
        assertNotNull(exception);
        assertEquals("Exception doesn't equals to", expectedMessage, exception.getMessage());

    }

}
