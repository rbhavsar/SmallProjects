package TestNGListener;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNGListenerDemo.class)
public class TestCase {

    @Test
    public void tc1()
    {
        System.out.println("Test case tc1");
        Assert.assertTrue(true);
    }

    @Test
    public void tc2()
    {
        System.out.println("Test case tc2");
        Assert.assertTrue(false);
    }
}
