package ru.netology.manager;

import ru.netology.domain.Movies;
import ru.netology.AfishaRepository;

public class AfishaManager {
  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }

  private AfishaRepository repository;

  public void add(Movies item) {
    repository.save(item);
  }


  public Movies[] getAll() {
    Movies[] items = repository.findAll();
    Movies[] result = new Movies[items.length];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

}