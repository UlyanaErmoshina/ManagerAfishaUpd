package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.AfishaRepository;
import ru.netology.domain.movie;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {

    @Mock
    AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;
    movie first = new movie(1, "first", "thriller", "picture");
    movie second = new movie(2, "second", "cartoon", "picture");
    movie third = new movie(3, "third", "comedy", "picture");
    movie forth = new movie(4, "forth", "thriller", "picture");

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

    }

    @Test
    void ShouldAdd() {
        movie[] returned = new movie[]{first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(forth);
        manager.add(forth);
        movie[] actual = manager.getAll();
        movie[] expected = new movie[]{forth, third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).save(forth);

    }

    @Test
    void ShouldGetAll() {
        movie[] returned = new movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        movie[] actual = manager.getAll();
        movie[] expected = new movie[]{third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }
}












