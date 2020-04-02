package roman.interface_based;

import org.junit.Assert;
import org.junit.Test;
import roman.RomanConverter;

public class InterfaceBasedTest {

    RomanConverter romanConverter = new RomanConverter();

    @Test
    public void testToRomanGreaterThanZero(){
        Assert.assertEquals("I",romanConverter.toRoman(1));
    }

    @Test
    public void testToRomanEqualToZero(){
        try {
            romanConverter.toRoman(0);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
            Assert.assertEquals(e.getMessage(), "number out of range (must be 1..3999)");
        }
    }

    @Test
    public void testToRomanLessThanZero(){
        try {
            romanConverter.toRoman(-1);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
            Assert.assertEquals(e.getMessage(), "number out of range (must be 1..3999)");
        }
    }
}
