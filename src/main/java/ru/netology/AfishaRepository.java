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
        Movies[] result = new Movies[items.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
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


            public void removeAll() {
                    items = new Movies[0];

            }
        }
    }
}

