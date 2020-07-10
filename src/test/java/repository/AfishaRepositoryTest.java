package repository;

import org.junit.jupiter.api.Test;
import ru.netology.repository.AfishaRepository;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    Movie first = new Movie(1, "first", "thriller", "picture");
    Movie second = new Movie(2, "second", "cartoon", "picture");
    Movie third = new Movie(3, "third", "comedy", "picture");


    @Test
    void shouldSave() {
        repository.save(first);
        repository.save(second);
        repository.save(third);


        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAll() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first,second,third};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        int id = 2;

        repository.findById(id);
        Movie actual = repository.findById(2);
        Movie expected = second;

        assertEquals(expected, actual);

    }

    @Test
    void shouldRemoveById(){

        repository.save(first);
        repository.save(second);
        repository.save(third);
        int id = 3;
        repository.removeById(id);

    }

    @Test
    void shouldRemoveAll(){

        repository.removeAll();

        }
    }
