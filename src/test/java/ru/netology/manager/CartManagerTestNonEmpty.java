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
  private Movie fourth = new Movie(4, "fourth", "comedy", "picture");

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
  public void shouldNotRemoveIfNotExists() {
    int idToRemove = 3;

    manager.removeById(idToRemove);

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{second, first};

    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldGetAll() {
    Movie[] returned = new Movie[]{first, second, third};

    manager.getAll();

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
  @Test
  void ShouldAdd() {
    Movie[] returned = new Movie[]{first, second, third,fourth};
    manager.add(fourth);
    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{fourth,third, second, first};
    assertArrayEquals(expected, actual);

  }
}