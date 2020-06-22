package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmpty {
  @Test
  public void shouldRemoveIfExists() {
    AfishaManager manager = new AfishaManager(5);
    int idToRemove = 1;
    Movies first = new Movies(1, 1, "first", 1, 1);
    Movies second = new Movies(2, 2, "second", 1, 1);
    Movies third = new Movies(3, 3, "third", 1, 1);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    Movies[] actual = manager.getAll();
    Movies[] expected = new Movies[]{third, second};

//    assertEquals(expected, actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    AfishaManager manager = new AfishaManager();
    int idToRemove = 4;
    Movies first = new Movies(1, 1, "first", 1, 1);
    Movies second = new Movies(2, 2, "second", 1, 1);
    Movies third = new Movies(3, 3, "third", 1, 1);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    Movies[] actual = manager.getAll();
    Movies[] expected = new Movies[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
}