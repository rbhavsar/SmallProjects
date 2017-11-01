package Mockito;

import Car.Calculator;
import Car.CalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    Calculator cal = null;
    @Mock
    CalculatorService service=Mockito.mock(CalculatorService.class);

    @Before
    public void setUp()
    {
        cal = new Calculator(service);
    }

    @Test
    public void testPerform()
    {
        when(service.add(2,3)).thenReturn(5);
        Assert.assertEquals(10,cal.perform(2,3));
        verify(service).add(2,3);
    }
}

