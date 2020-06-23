package ru.netology;

import ru.netology.domain.Movies;

public class AfishaRepository {

    private Movies[] items = new Movies[0];

    public void save(Movies item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Movies[] tmp = new Movies[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movies[] findAll() {
        return items;
    }

    public Movies findById(int id) {
        Movies temp = null;
        for (Movies item : items) {
            if (item.getId() == id) {
                temp = item;

            }
        }
        return temp;

    }

    public void removeById(int id) {
        int length = items.length - 1;
        Movies[] tmp = new Movies[length];
        int index = 0;
        for (Movies item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
    }


            public void removeAll() {
                    Movies[] tmp = new Movies[0];
                    items = tmp;

            }
        }


