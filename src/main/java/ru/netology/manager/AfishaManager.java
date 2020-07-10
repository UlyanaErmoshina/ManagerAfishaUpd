package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private Movie[] movies = new Movie[0];
  private int itemsToShow = defaultQuantityMovies;
  private static int defaultQuantityMovies = 10;

  private AfishaRepository repository;

  public AfishaManager(int customQuantityMovies) {
    if (customQuantityMovies > 0) {

      itemsToShow = customQuantityMovies;
    }
    else
      itemsToShow = defaultQuantityMovies;
  }

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }


  public void add(Movie item) {
    repository.save(item);
  }

  public Movie[] getAll() {
    Movie[] items = repository.findAll();
    int lengths;

    lengths = Math.min (items.length, itemsToShow);


    Movie[] result = new Movie[lengths];
    for (int i = 0; i < lengths; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

}