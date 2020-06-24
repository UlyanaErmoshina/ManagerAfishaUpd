package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.AfishaRepository;
import ru.netology.domain.Movies;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {

    @Mock
    AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;
    Movies first = new Movies(1, 1, "first", 1, 1);
    Movies second = new Movies(2, 2, "second", 1, 1);
    Movies third = new Movies(3, 3, "third", 1, 1);
    Movies forth = new Movies(4, 4, "forth", 1, 2);

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

    }

    @Test
    void ShouldAdd() {
        Movies[] returned = new Movies[]{first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(forth);
        manager.add(forth);
        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{forth, third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).save(forth);

    }

    @Test
    void ShouldGetAll() {
        Movies[] returned = new Movies[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }
}












