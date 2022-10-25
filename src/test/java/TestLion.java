import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class TestLion {

    private final String sex;
    private final boolean isPredator;

    private final List<String> foodLion;

    public TestLion(String sex, boolean isPredator, List<String> foodLion) {
        this.sex = sex;
        this.isPredator = isPredator;
        this.foodLion = foodLion;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Самец", true, List.of("Животные", "Птицы", "Рыба")},
                {"Самка", false, List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Mock
    Lion lion;

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);//.openMocks(this);//.initMocks(this);
    }

    @Test
    public void testSexValidValue() throws Exception {
            lion = new Lion(sex, feline);
            Assert.assertEquals(isPredator, lion.doesHaveMane());
    }

    @Test
    public void testSexNotValidValue() {
        try {
            lion = new Lion("ОНО", feline);
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage());
        }
    }

    @Test
    public void testLionKittenWithValidValue() throws Exception {
            lion = new Lion(sex, feline);
            Mockito.when(feline.getKittens()).thenReturn(5);
            Assert.assertEquals(5, lion.getKittens());
    }

    @Test
    public void testLionFood() throws Exception {
            lion = new Lion(sex, feline);
            Mockito.when(feline.eatMeat()).thenReturn(foodLion);
            Assert.assertEquals(foodLion, lion.getFood());
    }
}
