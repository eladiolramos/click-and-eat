package com.clickandeat.backend.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringUtilsTest {

    @Test
    @DisplayName("lowerCase letters")
    public void testCapitalizeLowerCase() {

        //Arrange
        String name = "pizzas";

        //Act
        String resultado = StringUtils.capitalize(name);

        //Assert
        assertEquals("Pizzas", resultado);
    }

    @Test
    @DisplayName("upperCase letters")
    public void testCapitalizeUpperCase() {

        //Arrange
        String name = "PIZZAS";

        //Act
        String resultado = StringUtils.capitalize(name);

        //Assert
        assertEquals("Pizzas", resultado);
    }

    @Test
    @DisplayName("With null name")
    public void testCapitalizeNull() {

        //Arrange

        //Act
        String resultado = StringUtils.capitalize(null);

        //Assert
        assertNull(resultado);
    }

    @Test
    @DisplayName("With the name blanck")
    public void testCapitalizeNameBlank() {

        //Arrange
        String name = "";

        //Act
        String resultado = StringUtils.capitalize(name);

        //Assert
        assertEquals("", resultado);
    }

}
