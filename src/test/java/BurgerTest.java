import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun testBun;
    @Mock
    private Ingredient testIngredient;

    @Test
    public void getPriceTest(){
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient);
        Mockito.when(testBun.getPrice()).thenReturn(42F);
        Mockito.when(testIngredient.getPrice()).thenReturn(15F);
        float testBurgerPrice = testBurger.getPrice();
        Assert.assertEquals(99F,testBurgerPrice,99F - testBurgerPrice);
    }
    @Test
    public void burgerGetReceiptTest() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        testBurger.setBuns(testBun);
        Mockito.when(testBun.getName()).thenReturn("MockBun");
        Mockito.when(testBun.getPrice()).thenReturn(320f);
        testBurger.setBuns(testBun);
        Mockito.when(testIngredient.getName()).thenReturn("mockIngredient");
        Mockito.when(testIngredient.getPrice()).thenReturn(265f);
        Mockito.when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        String expectedReceipt = String.format(("(==== " +
                        testBun.getName() +
                        " ====)%n= " +
                        testIngredient.getType().toString().toLowerCase() +
                        " " +
                        testIngredient.getName() +
                        " =%n(==== " +
                        testBun.getName() +
                        " ====)%n%nPrice: %f%n"),
                testBurger.getPrice());
        Assert.assertEquals(expectedReceipt, testBurger.getReceipt());
    }
    @Test
    public void removeIngredientTest(){
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        int countBeforeRemove = testBurger.ingredients.size();
        testBurger.removeIngredient(countBeforeRemove-1);
        int countAfterRemove = testBurger.ingredients.size();
        Assert.assertEquals(1,countBeforeRemove - countAfterRemove);
    }

    @Test
    public void moveIngredientTest(){
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        Ingredient newIngredient = new Ingredient(IngredientType.SAUCE,"Тучный", 300F);
        testBurger.addIngredient(newIngredient);
        int FirstIndexOfNewIngredient = testBurger.ingredients.indexOf(newIngredient);
        testBurger.moveIngredient(FirstIndexOfNewIngredient,0);
        int SecondIndexOfIngredient = testBurger.ingredients.indexOf(newIngredient);
        Assert.assertEquals(1,FirstIndexOfNewIngredient);
        Assert.assertEquals(0,SecondIndexOfIngredient);
    }
}
