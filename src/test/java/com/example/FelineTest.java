package com.example;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FelineTest {
    Feline feline;

    @Before
    public void setUp(){
        feline = new Feline();
    }

    @Test
    public void testGetKittensSuccess(){
        assertEquals("getKittens should return 1", 1,feline.getKittens());
    }

    @Test
    public void testGetKittensCountSuccess(){
        assertEquals("getKittens should return 3", 3,feline.getKittens(3));
    }
}
