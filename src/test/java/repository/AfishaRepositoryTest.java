package repository;

import org.junit.jupiter.api.Test;
import ru.netology.AfishaRepository;
import ru.netology.domain.movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();


    @Test
    void ShouldSave() {
        movie first = new movie(1, "first", "thriller", "picture");
        repository.save(first);
        movie second = new movie(2, "second", "cartoon", "picture");
        movie third = new movie(3, "third", "comedy", "picture");

        repository.save(first);
        repository.save(second);
        repository.save(third);


        movie[] actual = repository.findAll();
        movie[] expected = new movie[]{third, second, first};

        assertArrayEquals(expected, actual);


    }

    @Test
    void ShouldFindAll() {
        movie first = new movie(1, "first", "thriller", "picture");
        movie second = new movie(2, "second", "cartoon", "picture");
        movie third = new movie(3, "third", "comedy", "picture");
        repository.findAll();
        movie[] actual = repository.findAll();
        movie[] expected = new movie[]{first,second,third};

        assertArrayEquals(expected, actual);

    }

    @Test

    void ShouldFindById() {
        movie first = new movie(1, "first", "thriller", "picture");
        repository.save(first);
        movie second = new movie(2, "second", "cartoon", "picture");
        movie third = new movie(3, "third", "comedy", "picture");

        repository.save(first);
        repository.save(second);
        repository.save(third);

        int id = 2;

        repository.findById(id);
        movie actual = repository.findById(2);
        movie expected = second;

        assertEquals(expected, actual);

    }

    @Test

    void ShouldRemoveById(){
        movie first = new movie(1, "first", "thriller", "picture");
        repository.save(first);
        movie second = new movie(2, "second", "cartoon", "picture");
        movie third = new movie(3, "third", "comedy", "picture");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        int id = 3;
        repository.removeById(id);

    }

    @Test

    void ShouldRemoveAll(){
        movie first = new movie(1, "first", "thriller", "picture");
        movie second = new movie(2, "second", "cartoon", "picture");
        movie third = new movie(3, "third", "comedy", "picture");

        repository.removeAll();

        }
    }
