import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expected;

    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] hasMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                //{"Оно", false},
        };
    }

    @Test
    public void getKittensFalse() {
        //Lion lion = new Lion();
        //boolean expected = false;
    }

    @Test
    public void doesHaveManeMaleTrue() throws Exception {
        Lion lion = new Lion(sex);
        boolean actual = lion.doesHaveMane();
        assertEquals("Используйте допустимые значения пола животного - самей или самка", expected, lion.doesHaveMane());
    }

    @Test
    public void getFoodPredicatorTrue() throws Exception {
        Predator feline = new Feline();
        Lion lion = new Lion(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Должен возвращаться список еды хищника", expected, lion.getFood());
    }
}
