

import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String gender;
    private final boolean expected;
    private final int kittens;

    public LionTest(String gender, boolean expected, int kittens) {
        this.gender = gender;
        this.expected = expected;
        this.kittens = kittens;

    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getLionData() {
        return new Object[][]{
                {"Самец", true, 1},
                {"Самка", false, 1},
        };
    }

    @Test
    public void lionGenderUnknownTest() {
        Feline feline = new Feline();
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Тип не определен", feline);
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage.contains(expectedMessage),false);
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(gender, feline);
        List<String> lionFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(lionFood, lion.getFood());
    }

    @Test
    public void lionDoesHaveManeTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(gender, feline);
        Assert.assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void lionGetKittensTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(gender, feline);
        Assert.assertEquals(kittens, lion.getKittens());
    }
}