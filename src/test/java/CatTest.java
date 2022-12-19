import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Predator predator;

    @Test
    public void getSoundMeowTrue() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        assertEquals("Кошка должна говорить Мяу", expected, cat.getSound());
    }

    @Test
    public void getFoodPredatorTrue() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        lenient().when(predator.eatMeat()).thenReturn(feline.eatMeat());
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Должен возвращаться список еды хищника", expected, cat.getFood());
    }

}
