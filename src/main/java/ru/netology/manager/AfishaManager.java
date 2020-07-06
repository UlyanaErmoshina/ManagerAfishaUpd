package ru.netology.manager;

import ru.netology.domain.Movie;

public class AfishaManager {

    private Movie[] movies = new Movie[0];
    private int CustomQuantityMovies;
    private static int DefaultQuantityMovies = 10;

    public AfishaManager(int customQuantityMovies) {

        CustomQuantityMovies = customQuantityMovies;
    }

    public AfishaManager() {
        CustomQuantityMovies = 0;
    }


    public void add(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }


    public Movie[] getAll() {
        int lengths;
        if (CustomQuantityMovies == 0)
            if (movies.length < DefaultQuantityMovies)
                lengths = movies.length;
            else
                lengths = DefaultQuantityMovies;
        else
            lengths = Math.min(movies.length, CustomQuantityMovies);

        Movie[] result = new Movie[lengths];
        for (int i = 0; i < lengths; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : movies) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }

        movies = tmp;
    }
}
