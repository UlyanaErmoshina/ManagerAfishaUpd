package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private Movie first = new Movie(1, "first", "thriller", "picture");
    private Movie second = new Movie(2, "second", "cartoon", "picture");
    private Movie third = new Movie(3, "third", "comedy", "picture");
    private Movie fourth = new Movie(4, "fourth", "comedy", "picture");
    private Movie fifth = new Movie(5, "fifth", "comedy", "picture");
    private Movie sixth = new Movie(6, "sixth", "comedy", "picture");
    private Movie seventh = new Movie(7, "seventh", "comedy", "picture");
    private Movie eighth = new Movie(8, "eighth", "comedy", "picture");
    private Movie ninth = new Movie(9, "ninth", "comedy", "picture");
    private Movie tenth = new Movie(10, "tenth", "comedy", "picture");
    private Movie eleventh = new Movie(11, "eleventh", "comedy", "picture");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAll() {
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAdd() {
        manager.add(fourth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSuccessfulAddMoreThenTenWithDefaultLength() {
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);


        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSuccessfulAddFourWithCustomLength() {
        AfishaManager manager = new AfishaManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSuccessfulAddSixWithCustomLength() {
        AfishaManager manager = new AfishaManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }
}