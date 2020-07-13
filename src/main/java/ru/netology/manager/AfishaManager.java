package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private int defaultQuantityMovies = 10;
  private AfishaRepository repository;

  public AfishaManager() {
  }

  public AfishaManager(int defaultQuantityMovies, AfishaRepository repository) {
    this.defaultQuantityMovies = defaultQuantityMovies;
    this.repository = repository;
  }

  public void add(Movie item) {
    repository.save(item);
  }

  public Movie[] getAll() {
    Movie[] items = repository.findAll();
    int lengths = Math.min(items.length, defaultQuantityMovies);
    Movie[] result = new Movie[lengths];
    for (int i = 0; i < lengths; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }
}