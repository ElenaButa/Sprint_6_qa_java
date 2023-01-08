import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CatTest {

    @Test
    public void catGetSoundTest() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void catGetFoodTest() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> catFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(catFood, cat.getFood());
    }

}