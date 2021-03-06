package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaTest {
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
    int idToRemove = 1;
    manager.removeById(idToRemove);

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{third, second};

    assertArrayEquals(expected, actual);
  }

}