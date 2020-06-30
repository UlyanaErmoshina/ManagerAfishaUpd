package ru.netology;

import ru.netology.domain.movie;

public class AfishaRepository {

    private movie[] items = new movie[0];

    public void save(movie item) {
        int length = items.length + 1;
        movie[] tmp = new movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public movie[] findAll() {
        return items;
    }

    public movie findById(int id) {
        movie temp=null;
        for (movie item : items) {
            if (item.getId() == id) {
                temp = item;

            }
        }
        return temp;

    }

    public void removeById(int id) {
        int length = items.length - 1;
        movie[] tmp = new movie[length];
        int index = 0;
        for (movie item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
    }


            public void removeAll() {
                    movie[] tmp = new movie[0];
                    items = tmp;

            }
        }


