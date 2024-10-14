import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

public class DatabaseTest {
    @Mock
    Bun testBun;

    @Mock
    Ingredient testIngredient;

    @Test
    public void getAvalibleBunsTest(){
        Database testDataBase = new Database();
        testDataBase.availableBuns().add(testBun);
        Assert.assertTrue(testDataBase.availableBuns().contains(testBun));
    }

    @Test
    public void getAvalibleIngridientTest(){
        Database testDataBase = new Database();
        testDataBase.availableIngredients().add(testIngredient);
        Assert.assertTrue(testDataBase.availableIngredients().contains(testIngredient));
    }
}
