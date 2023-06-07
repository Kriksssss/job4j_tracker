package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "item1"));
        items.add(new Item(2, "item2"));
        items.add(new Item(3, "item3"));

        List<Item> expected = new ArrayList<>(items);
        expected.sort(new ItemAscByName());

        items.sort(new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    public void testSortDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "item1"));
        items.add(new Item(2, "item2"));
        items.add(new Item(3, "item3"));

        List<Item> expected = new ArrayList<>(items);
        expected.sort(new ItemDescByName());

        items.sort(new ItemDescByName());
        assertEquals(expected, items);
    }
}