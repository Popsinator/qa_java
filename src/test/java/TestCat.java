import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

public class TestCat {

    private Cat cat;

    private Feline feline;

    @Before
    public void run() {
        feline = new Feline();
        cat = new Cat(feline);
    }


    @Test
    public void testGetSoundMau() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
