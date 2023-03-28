import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import  org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

private final IngredientType testIngredientType;

public IngredientTest(IngredientType testIngredientType) {
        this.testIngredientType = testIngredientType;
        }

@Parameterized.Parameters
public static Object[][] getTypeParameters() {
        return new Object[][]{
        {SAUCE},
        {FILLING}
        };
}
    @Test
    public void getIngredientNameTest(){
        String name = "С корочкой";
       Ingredient testIngredient = new Ingredient(testIngredientType, name, 500);
        assertEquals(name,testIngredient.getName());
    }
    @Test
    public void ingredientGetPriceTest() {
       float price = 1000;
        Ingredient testIngredient = new Ingredient(SAUCE, "Супер-соус", price);
        assertEquals(price, testIngredient.getPrice(), 0);
    }
    @Test
    public void ingredientGetTypeTest() {
        Ingredient testIngredient = new Ingredient(testIngredientType, "Голоктычискый", 500);
        assertEquals(testIngredientType, testIngredient.getType());
    }
}
