package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.AfishaRepository;

public class AfishaManager {
  private Movie[] movies = new Movie[0];
  private int CustomQuantityMovies;
  private int DefaultQuantityMovies = 10;

  private AfishaRepository repository;

  public AfishaManager(int customQuantityMovies) {
    CustomQuantityMovies = customQuantityMovies;
  }

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }


  public void add(Movie item) {
    repository.save(item);
  }


//  public movie[] getAll() {
//    movie[] items = repository.findAll();
//    movie[] result = new movie[items.length];
//    for (int i = 0; i < result.length; i++) {
//      int index = items.length - i - 1;
//      result[i] = items[index];
//    }
//    return result;
//  }
  public Movie[] getAll() {
    int lengths;

//    lengths = Math.min (Math.min(movies.length, CustomQuantityMovies), DefaultQuantityMovies);

    if (movies.length<CustomQuantityMovies)
      lengths= movies.length;
    else
    if (CustomQuantityMovies < DefaultQuantityMovies)
      lengths = CustomQuantityMovies;
    else
      lengths = DefaultQuantityMovies;
    Movie[] result = new Movie[lengths];
    for (int i = 0; i < lengths; i++) {
      int index = movies.length - i - 1;
      result[i] = movies[index];
    }
    return result;
  }

}