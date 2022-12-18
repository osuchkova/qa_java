import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int kittensCount;
    private final int expected;

    public FelineTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getKittensCount() {
        return new Object[][]{
                {-1, 0},
                {0, 0},
                {1, 1},
        };
    }

    @Test
    public void eatMeatPredatorTrue() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Должен возвращаться список еды хищника", expected, feline.eatMeat());
    }

    @Test
    public void getFamilyFelineTrue() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        assertEquals("Должна возвращаться семья Кошачьи", expected, feline.getFamily());
    }

    @Test
    public void getKittensOneTrue() {
        Feline feline = new Feline();
        int expected = 1;
        assertEquals("Должен возвращаться 1 котёнок", expected, feline.getKittens());
    }

    @Test
    public void shouldReturnKittensCount() {
        Feline feline = new Feline();
        int actual = Math.max(feline.getKittens(kittensCount), 0);
        assertEquals("Должно возвращаться некоторое число котят", expected, actual);
    }
}
