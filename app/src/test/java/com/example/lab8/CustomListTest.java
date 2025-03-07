package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return Custom List
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     * */
    @Test
    public void addCityTest() {
        list=MockCityList();
        int listSize=list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize+1);
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Victoria", "BC");
        list.addCity(city);
        int listSize = list.getCount();
        list.deleteCity(city);
        assertEquals(list.getCount(),listSize-1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city1 = new City("Regina", "SK");
        list.addCity(city1);
        assertTrue(list.hasCity(city1));
        City city2 = new City("Yellowknife", "NT");
        assertFalse(list.hasCity(city2));
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        list.addCity(new City("Iqaluit", "NU"));
        int listSize1=list.getCount();
        assertEquals(list.countCities(),listSize1);
        City city = new City("Halifax", "NS");
        list.addCity(city);
        int listSize2 = list.getCount();
        assertEquals(list.countCities(),listSize2);
        list.deleteCity(city);
        assertEquals(list.countCities(),listSize2-1);
    }
}
