package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.manager.AfishaManager;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {

    @Mock
    AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;
    Movie first = new Movie(1, "first", "thriller", "picture");
    Movie second = new Movie(2, "second", "cartoon", "picture");
    Movie third = new Movie(3, "third", "comedy", "picture");
    Movie forth = new Movie(4, "forth", "thriller", "picture");
    Movie fifth = new Movie(5, "fifth", "comedy", "picture");
    Movie sixth = new Movie(6, "sixth", "comedy", "picture");

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldAdd() {
        Movie[] returned = new Movie[]{first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(forth);
        manager.add(forth);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{forth, third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).save(forth);
    }

    @Test
    void shouldGetAll() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldGetAllWithCustomLength() {
        AfishaManager manager = new AfishaManager(5, repository);
        Movie[] returned = new Movie[]{first, second, third, forth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{sixth, fifth, forth, third, second};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}













