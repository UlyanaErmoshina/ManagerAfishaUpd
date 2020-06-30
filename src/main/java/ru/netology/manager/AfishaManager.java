package ru.netology.manager;

import ru.netology.domain.movie;
import ru.netology.AfishaRepository;

public class AfishaManager {
  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }

  private AfishaRepository repository;

  public void add(movie item) {
    repository.save(item);
  }


  public movie[] getAll() {
    movie[] items = repository.findAll();
    movie[] result = new movie[items.length];
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

}