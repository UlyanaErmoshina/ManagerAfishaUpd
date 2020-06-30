package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmpty {
  @Test
  public void shouldRemoveIfExists() {
    AfishaManager manager = new AfishaManager(5);
    int idToRemove = 1;
    Movie first = new Movie(1,  "first", "thriller", "picture");
    Movie second = new Movie(2,  "second", "cartoon", "picture");
    Movie third = new Movie(3, "third", "comedy", "picture");
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{third, second};

//    assertEquals(expected, actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    AfishaManager manager = new AfishaManager();
    int idToRemove = 4;
    Movie first = new Movie(1, "first", "thriller", "picture");
    Movie second = new Movie(2, "second", "cartoon", "picture");
    Movie third = new Movie(3, "third", "comedy", "picture");
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
}