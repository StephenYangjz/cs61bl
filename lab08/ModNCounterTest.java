/**
 * Created by hugh on 16/7/1.
 */
import static org.junit.Assert.*;

public class ModNCounterTest {

    @org.junit.Test
    public void testConstructor() {
        ModNCounter c = new ModNCounter();
        assertTrue(c.value() == 0);
    }

    @org.junit.Test
    public void testIncrement() throws Exception {
        ModNCounter c = new ModNCounter();
        c.increment();
        assertTrue(c.value()  == 1);
        c.increment();
        assertTrue(c.value() == 2);
        c.increment();
        assertTrue(c.value() == 0);
    }

    @org.junit.Test
    public void testReset() throws Exception {
        ModNCounter c = new ModNCounter();
        c.increment();
        c.reset();
        assertTrue(c.value() == 0);
    }
}
