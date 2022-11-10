import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

public class TestFeline {

    private final String animalKind = "Хищник";
    private final List<String> food = List.of("Животные", "Птицы", "Рыба");
    private Feline feline;

    @Before
    public void run() {
        feline = new Feline();
    }

    @Test
    public void testGetFoodFeline() throws Exception {
        Assert.assertEquals(food, feline.eatMeat());
    }

    @Test
    public void testGetLionFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetLionKittens() {
        Assert.assertEquals(1, feline.getKittens());
    }
}
