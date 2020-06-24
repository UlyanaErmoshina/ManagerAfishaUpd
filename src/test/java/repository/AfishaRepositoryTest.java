package repository;

import org.junit.jupiter.api.Test;
import ru.netology.AfishaRepository;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();


    @Test
    void ShouldSave() {
        Movies first = new Movies(1, 1, "first", 1, 1);
        repository.save(first);
        Movies second = new Movies(2, 2, "second", 1, 1);
        Movies third = new Movies(3, 3, "third", 1, 1);

        repository.save(first);
        repository.save(second);
        repository.save(third);


        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[]{third, second, first};

        assertArrayEquals(expected, actual);


    }

    @Test
    void ShouldFindAll() {
        Movies first = new Movies(1, 1, "first", 1, 1);
        Movies second = new Movies(2, 2, "second", 1, 1);
        Movies third = new Movies(3, 3, "third", 1, 1);
        repository.findAll();
        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[]{first,second,third};

        assertArrayEquals(expected, actual);

    }

    @Test

    void ShouldFindById() {
        Movies first = new Movies(1, 1, "first", 1, 1);
        repository.save(first);
        Movies second = new Movies(2, 2, "second", 1, 1);
        Movies third = new Movies(3, 3, "third", 1, 1);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        int id = 2;

        repository.findById(id);
        Movies actual = repository.findById(2);
        Movies expected = second;

        assertEquals(expected, actual);

    }

    @Test

    void ShouldRemoveById(){
        Movies first = new Movies(1, 1, "first", 1, 1);
        repository.save(first);
        Movies second = new Movies(2, 2, "second", 1, 1);
        Movies third = new Movies(3, 3, "third", 1, 1);

        repository.save(first);
        repository.save(second);
        repository.save(third);
        int id = 3;
        repository.removeById(id);

    }

    @Test

    void ShouldRemoveAll(){
        Movies first = new Movies(1, 1, "first", 1, 1);
        Movies second = new Movies(2, 2, "second", 1, 1);
        Movies third = new Movies(3, 3, "third", 1, 1);

        repository.removeAll();

        }
    }
