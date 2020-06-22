package ru.netology.manager;

import ru.netology.domain.Movies;

public class AfishaManager {

  private Movies[] movies = new Movies[0];
  private int CustomQuantityMovies;
  private static int DefaultQuantityMovies = 10;

  public AfishaManager(int customQuantityMovies) {

    CustomQuantityMovies = customQuantityMovies;
  }

  public AfishaManager() {
  }


  public void add(Movies item) {
    // создаём новый массив размером на единицу больше
    int length = movies.length + 1;
    Movies[] tmp = new Movies[length];
    // itar + tab
    // копируем поэлементно
    // for (int i = 0; i < items.length; i++) {
    //   tmp[i] = items[i];
    // }
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    // кладём последним наш элемент
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    movies = tmp;
  }



  public Movies[] getAll() {
    Movies[] result = new Movies[movies.length];
    int lengths;
    if (movies.length<CustomQuantityMovies)
      lengths= movies.length;
    else

    if (this.CustomQuantityMovies < DefaultQuantityMovies)
      lengths = this.CustomQuantityMovies;
    else

      lengths = DefaultQuantityMovies;

    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < lengths; i++) {
      int index = movies.length - i - 1;
      result[i] = movies[index];
    }
    return result;
  }

  // наивная реализация
  public void removeById(int id) {
    int length = movies.length - 1;
    Movies[] tmp = new Movies[length];
    int index = 0;
    for (Movies item : movies) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    // меняем наши элементы
    movies = tmp;
  }
}
