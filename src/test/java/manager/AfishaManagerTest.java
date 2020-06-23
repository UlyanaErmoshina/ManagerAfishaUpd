package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.AfishaRepository;
import ru.netology.domain.Movies;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

    @ExtendWith(MockitoExtension.class)
    @Mock
    AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;
    Movies first = new Movies(1, 1, "first", 1, 1);
    Movies second = new Movies(2, 2, "second", 1, 1);
    Movies third = new Movies(3, 3, "third", 1, 1);

    @BeforeEach
    public void SetUp() {
       manager.add(first);
       manager.add(second);
       manager.add(third);

    }
    @Test
    void ShouldAdd(){
        Movies first = new Movies(1, 1, "first", 1, 1);
        Movies second = new Movies(2, 2, "second", 1, 1);
        Movies third = new Movies(3, 3, "third", 1, 1);
        manager.add();
        Movies[] actual = manager.getAll();
        Movies[] expected =

    }
    @Test





}