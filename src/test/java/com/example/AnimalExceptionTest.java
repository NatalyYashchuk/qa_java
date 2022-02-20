package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class AnimalExceptionTest {
    private Animal animal;


    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testAnimalGetFoodException() {
        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception ex = null;
        try {
            animal.getFood("Неизвестный");
        } catch (Exception e) {
            ex = e;

        }
        assertNotNull(ex);
        assertEquals("Incorrect exception text",expectedExceptionMessage, ex.getMessage());
    }
}
