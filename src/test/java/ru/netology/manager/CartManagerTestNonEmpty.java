package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmpty {
  private AfishaManager manager = new AfishaManager();
  private Movie first = new Movie(1, "first", "thriller", "picture");
  private Movie second = new Movie(2, "second", "cartoon", "picture");
  private Movie third = new Movie(3, "third", "comedy", "picture");

  @BeforeEach
  public void setUp() {
    manager.add(first);
    manager.add(second);
    manager.add(third);
  }
  @Test
  public void shouldRemoveIfExists() {
    AfishaManager manager = new AfishaManager(5);
    int idToRemove = 1;

    manager.removeById(idToRemove);

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{third, second};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    AfishaManager manager = new AfishaManager();
    int idToRemove = 3;

    manager.removeById(idToRemove);

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
}