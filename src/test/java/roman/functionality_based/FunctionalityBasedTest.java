package roman.functionality_based;

import org.junit.Assert;
import org.junit.Test;
import roman.RomanConverter;

public class FunctionalityBasedTest {

    RomanConverter romanConverter = new RomanConverter();

    // toRoman Tests
    @Test
    public void testToRomanInvalid() {
        try {
            romanConverter.toRoman(4000);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
            Assert.assertEquals(e.getMessage(), "number out of range (must be 1..3999)");
        }
    }

    @Test
    public void testToRomanI(){
        Assert.assertEquals("I", romanConverter.toRoman(1));
    }

    @Test
    public void testToRomanV(){
        Assert.assertEquals("V", romanConverter.toRoman(5));
    }

    @Test
    public void testToRomanX(){
        Assert.assertEquals("X", romanConverter.toRoman(10));
    }

    @Test
    public void testToRomanL(){
        Assert.assertEquals("L", romanConverter.toRoman(50));
    }

    @Test
    public void testToRomanC(){
        Assert.assertEquals("C", romanConverter.toRoman(100));
    }

    @Test
    public void testToRomanD(){
        Assert.assertEquals("D", romanConverter.toRoman(500));
    }

    @Test
    public void testToRomanM(){
        Assert.assertEquals("M", romanConverter.toRoman(1000));
    }

    @Test
    public void testToRomanMultipleRomanNumerals(){
        Assert.assertEquals("CLXV", romanConverter.toRoman(165));
    }

    // fromRoman Tests
    @Test
    public void testFromRomanOneDigit(){
        Assert.assertEquals(5, romanConverter.fromRoman("V"));
    }

    @Test
    public void testFromRomanTwoDigits(){
        Assert.assertEquals(78, romanConverter.fromRoman("LXXVIII"));
    }

    @Test
    public void testFromRomanThreeDigits(){
        Assert.assertEquals(364, romanConverter.fromRoman("CCCLXIV"));
    }

    @Test
    public void testFromRomanFourDigits(){
        Assert.assertEquals(1984, romanConverter.fromRoman("MCMLXXXIV"));
    }

    @Test
    public void testFromRomanInvalidUppercase(){
        try {
            romanConverter.fromRoman("POP");
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
            Assert.assertEquals(e.getMessage(), "Invalid Roman numeral: POP");
        }
    }

    @Test
    public void testFromRomanInvalidLowercase(){
        try {
            romanConverter.fromRoman("asd");
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
            Assert.assertEquals(e.getMessage(), "Invalid Roman numeral: asd");
        }
    }

    @Test
    public void sequentialConversionTest(){
        for(int n = 1; n<4000; n++){
            Assert.assertEquals(n, romanConverter.fromRoman(romanConverter.toRoman(n)));
        }
    }
}
