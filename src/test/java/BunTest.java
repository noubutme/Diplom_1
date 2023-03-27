import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import static org.junit.Assert.assertEquals;


public class BunTest {

    @Test
    public void getBunNameTest(){
        String name = "С корочкой";
        Bun testBun = new Bun(name,1000);
        assertEquals(name,testBun.getName());
    }
    @Test
    public void bunGetPriceTest() {
        float price = 770;
        Bun testBun = new Bun("stopWar", price);
        assertEquals(price, testBun.getPrice(), 0);
    }
}
