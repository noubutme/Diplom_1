import org.junit.Test;
import praktikum.Bun;

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
        Bun testBun = new Bun("GG", price);
        assertEquals(price, testBun.getPrice(), 0);
    }
}
