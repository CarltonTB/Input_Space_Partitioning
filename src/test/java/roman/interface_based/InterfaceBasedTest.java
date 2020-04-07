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

    @Test
    public void testFromRomanEmptyString(){
        try {
            romanConverter.fromRoman("");
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
            Assert.assertEquals(e.getMessage(), "Invalid Roman numeral: ");
        }
    }

    @Test
    public void testFromRomanNull(){
        try {
            romanConverter.fromRoman(null);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), NullPointerException.class);
        }
    }

    @Test
    public void testFromRomanLengthOne(){
        Assert.assertEquals(1, romanConverter.fromRoman("I"));
    }

    @Test
    public void testFromRomanLengthGreaterThanOne() {
        Assert.assertEquals(9, romanConverter.fromRoman("IX"));
    }
}
