package com.handtruth.lessons.lesson1.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTest {
    private static Simple simple;

    @BeforeAll
    static void setObjects() {
        simple = new Simple();
    }

    @Test
    void discriminant() {
        assertEquals(0.0, simple.discriminant(0.0, 0.0, 0.0), 1e-5);
        assertEquals(0.0, simple.discriminant(1.0, -2.0, 1.0), 1e-5);
        assertEquals(1.0, simple.discriminant(1.0, 3.0, 2.0), 1e-5);
    }

    @Test
    void sqRoot() {
        assertEquals(1.0, simple.sqRoot(1.0, -2.0, 1.0), 1e-5);
        assertEquals(-3.0, simple.sqRoot(1.0, 6.0, 9.0), 1e-5);
    }

    @Test
    void seconds() {
        assertEquals(30035, simple.seconds(8, 20, 35));
        assertEquals(86400, simple.seconds(24, 0, 0));
        assertEquals(13, simple.seconds(0, 0, 13));
    }

    @Test
    void numberRevert() {
        assertEquals(874, simple.numberRevert(478));
        assertEquals(201, simple.numberRevert(102));
    }
}