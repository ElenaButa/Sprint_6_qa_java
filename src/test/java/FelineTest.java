import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void felineEatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> foodsFeline = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(foodsFeline, feline.eatMeat());
    }

    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void felineGetChildrenTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getChildren());
    }
}