import com.example.Animal;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalClass;
    private final List<String> food;

    public AnimalTest(String animalClass, List<String> food) {
        this.animalClass = animalClass;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void animalGetFoodExeptionTest() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Водоплавающее");
        });

        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void animalGetFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> animalFood = food;
        Assert.assertEquals(animalFood, animal.getFood(animalClass));
    }


    @Test
    public void animalGetChildrenTest() {
        Animal animal = new Animal();
        Assert.assertEquals(0, animal.getChildren());
    }


    @Test
    public void animalGetFamilyTest() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}