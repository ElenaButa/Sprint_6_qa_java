import com.example.Feline;
import com.example.LionAlex;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LionAlexTest {
    @Test
    public void lionAlexGetFriendsTest() throws Exception {
        Feline feline = new Feline();
        LionAlex lionAlex = new LionAlex(feline);
        List<String> alexFriends = List.of("Марти", "Глория", "Мелман");
        Assert.assertEquals(alexFriends, lionAlex.getFriends());
    }

    @Test
    public void lionAlexGetPlaceOfLivingTest() throws Exception {
        Feline feline = new Feline();
        LionAlex lionAlex = new LionAlex(feline);
        Assert.assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    public void lionAlexGetKittensTest() throws Exception {
        Feline feline = new Feline();
        LionAlex lionAlex = new LionAlex(feline);
        Assert.assertEquals(0, lionAlex.getKittens());
    }

}