package LabStringMain;


import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testArgs() {
        try {
            LabString.main(new String[]{});
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
        try {
            LabString.main(new String[]{"dfdsfsd vcvx"});
            Assert.assertTrue(true);
        } catch (Exception e) {

            Assert.fail();
        }
    }

    @Test
    public void checkSubctr(){
      StringBuilder str1 = new StringBuilder("asdfghj");
      StringBuilder str2 = new StringBuilder("fgdhsdfjhuas");
      Assert.assertEquals("sdf",LabString.findSubstring(str1,str2,1,4).toString());
      str1 = new StringBuilder("sadd");
      str2 = new StringBuilder("afgdf");
      Assert.assertEquals("a",LabString.findSubstring(str1,str2,1,0).toString());
      str1 = new StringBuilder("rqereqqer");
      str2 = new StringBuilder("r");
      Assert.assertEquals("r",LabString.findSubstring(str1,str2,3,0).toString());
      str1 = new StringBuilder("asdf2");
      str2 = new StringBuilder("asdf1");
      Assert.assertEquals("asdf",LabString.findSubstring(str1,str2,0,0).toString());
    }



    @Test
    public void checkMaxSubstr(){
        Assert.assertEquals("",LabString.findMaxSubstring("qwerty","asdf").toString());
        Assert.assertEquals("fff",LabString.findMaxSubstring("ahfffpo","qwefff").toString());
        Assert.assertEquals("t123y",LabString.findMaxSubstring("mkot123yuiop","ert123ytiop").toString());
    }

    @Test
    public void checkParse(){
        String[] str = {"asdf","q1wer"};
        Assert.assertArrayEquals(str,LabString.parseString("asdf q1wer"));
        str = new String[]{"asdf","q1wer","123yuewrri"};
        Assert.assertArrayEquals(str,LabString.parseString("asdf q1wer 123yuewrri"));
        str = new String[]{};
        Assert.assertArrayEquals(str,LabString.parseString(""));
    }



}
