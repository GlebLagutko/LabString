package test.java;

import LabStringMain.LabString;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void shouldAnswerWithTrue() {
        try {
            LabString.main(new String[]{});
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
        try {
            LabString.main(new String[]{"dfdsfsd"});
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
