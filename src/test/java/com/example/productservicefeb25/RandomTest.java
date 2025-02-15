package com.example.productservicefeb25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomTest {
    @Test
    public void test() {
        int i = 1 + 1;
        assert i == 2;
       // assert i*i == 4;

        assertTrue(i==2);
        assertEquals(3,i);

    }
}
