import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2010 programming contest
 *   { (stu), (11 individual), (1-3), (5-8), (9-11), (1-11) 
 */
public class ManipulateThisFinalTest extends junit.framework.TestCase
{
   public void testManipulateThis01()
   {
      ManipulateThis str = new ManipulateThis("Manipulate");
      str.reverse(0,3);
      assertEquals("inaMpulate", str.toString());

      str.swap(3, 8);
      assertEquals("inatpulaMe", str.toString());

      str.insert("This", 8);
      assertEquals("inatpulaThisMe", str.toString());

      str.substitute("This", "Rgua");
      assertEquals("inatpulaRguaMe", str.toString());

      str.delete(2, 7);
      assertEquals("inRguaMe", str.toString());

      str.insert("wRg", 0);
      assertEquals("wRginRguaMe", str.toString());

      str.replace("Rg", "aBc");
      assertEquals("waBcinaBcuaMe", str.toString());

      str.changeCase();
      assertEquals("WAbCINAbCUAmE", str.toString());

      str.append("append");
      assertEquals("WAbCINAbCUAmEappend", str.toString());

      str.repeat(1, 4);
      assertEquals("WAbCINAbCUAmEappendAbCI", str.toString());
   }

   public void testManipulateThis02() 
   {
      ManipulateThis str = new ManipulateThis("Programming");
      assertEquals("Programming", str.toString());

      str = new ManipulateThis("test me!");
      assertEquals("test me!", str.toString());

      str = new ManipulateThis("123456789 || $%&()_");
      assertEquals("123456789 || $%&()_", str.toString());
   }

   public void testManipulateThis03() 
   {
      ManipulateThis str = new ManipulateThis("Programming");

      str.assign("!@#$%^&");
      assertEquals("!@#$%^&", str.toString());

      str = new ManipulateThis("test me!");
      assertEquals("test me!", str.toString());
      str.assign("ASDFGlkjhg");
      assertEquals("ASDFGlkjhg", str.toString());

      str = new ManipulateThis("123456789 || $%&()_");
      assertEquals("123456789 || $%&()_", str.toString());
      str.assign("");
      assertEquals("", str.toString());
   }

   public void testManipulateThis04() 
   {
      ManipulateThis str = new ManipulateThis("Programming");
      str.reverse(2, 4);
      assertEquals("Prrgoamming", str.toString());

      str = new ManipulateThis("Test me!");
      str.reverse(0, 6);
      assertEquals("em tseT!", str.toString());

      str = new ManipulateThis("0123456789xABCDEF");
      str.reverse(11, 16);
      assertEquals("0123456789xFEDCBA", str.toString());

      str = new ManipulateThis("01234");
      str.reverse(1, 2);
      assertEquals("02134", str.toString());
    }

   public void testManipulateThis05() 
   {
      ManipulateThis str = new ManipulateThis("Programming");
      str.swap(3, 8);
      assertEquals("Proirammgng", str.toString());

      str = new ManipulateThis("Test me!");
      str.swap(0, 7);
      assertEquals("!est meT", str.toString());

      str = new ManipulateThis("01234");
      str.swap(2, 3);
      assertEquals("01324", str.toString());
    }

   public void testManipulateThis06() 
   {
      ManipulateThis str = new ManipulateThis("Programming");
      str.insert(" Contest", "Programming".length());
      assertEquals("Programming Contest", str.toString());

      str = new ManipulateThis("Test me!");
      str.insert("Please ", 0);
      assertEquals("Please Test me!", str.toString());

      str = new ManipulateThis("01234");
      str.insert("-", 2);
      assertEquals("01-234", str.toString());
      str.insert("-", 4);
      assertEquals("01-2-34", str.toString());
      str.insert("- ", 1);
      assertEquals("0- 1-2-34", str.toString());
    }

   public void testManipulateThis07() 
   {
      ManipulateThis str = new ManipulateThis("Programming");
      str.substitute("gramm", "GRAMM");
      assertEquals("ProGRAMMing", str.toString());

      str = new ManipulateThis("123456789");
      str.substitute("23", "WXYZ");
      assertEquals("1WXYZ456789", str.toString());

      str = new ManipulateThis("01234");
      str.substitute("0", "---");
      assertEquals("---1234", str.toString());
      str.substitute("-", "20");
      assertEquals("20--1234", str.toString());
      str.substitute("4", "**");
      assertEquals("20--123**", str.toString());
    }


   public void testManipulateThis08() 
   {
      ManipulateThis str = new ManipulateThis("Programming");
      str.delete(2, 7);
      assertEquals("Pring", str.toString());

      str = new ManipulateThis("123456789");
      str.delete(0, 0);
      assertEquals("23456789", str.toString());
      str.delete(str.toString().length()-1, str.toString().length()-1);
      assertEquals("2345678", str.toString());
      str.delete(1, 2);
      assertEquals("25678", str.toString());
      str.delete(0, str.toString().length()-1);
      assertEquals("", str.toString());
    }

   public void testManipulateThis09() 
   {
      ManipulateThis mt = new ManipulateThis("abcabcab");
      mt.replace("bcab", "wxyz");
      assertEquals("abcawxyz", mt.toString());

      mt = new ManipulateThis("abcabbcab");
      mt.replace("bcab", "wxyz");
      assertEquals("awxyzwxyz", mt.toString());

      mt = new ManipulateThis("abcabcab");
      mt.replace("bcab", "b");
      assertEquals("ab", mt.toString());

      ManipulateThis str = new ManipulateThis("Programming");
      str.replace("mm", "aBc");
      assertEquals("PrograaBcing", str.toString());

      str = new ManipulateThis("123456789");
      str.replace("12", "xx");
      assertEquals("xx3456789", str.toString());
      str.replace("9", "xx");
      assertEquals("xx345678xx", str.toString());
      str.replace("x", "er");
      assertEquals("erer345678erer", str.toString());
      str.replace("re", "-");
      assertEquals("e-r345678e-r", str.toString());

      str = new ManipulateThis("0011223344");
      str.replace("0", "a");
      assertEquals("aa11223344", str.toString());
      str.replace("a1", "xy");
      assertEquals("axy1223344", str.toString());
      str.replace("4", "**");
      assertEquals("axy12233****", str.toString());
   }

   public void testManipulateThis10() 
   {
      ManipulateThis str = new ManipulateThis("Programming");
      str.changeCase();
      assertEquals("pROGRAMMING", str.toString());

      str = new ManipulateThis("A1234B56789C");
      str.changeCase();
      assertEquals("a1234b56789c", str.toString());
      str.changeCase();
      assertEquals("A1234B56789C", str.toString());

      str = new ManipulateThis("asd123JKL#5");
      str.changeCase();
      assertEquals("ASD123jkl#5", str.toString());
      str.changeCase();
      assertEquals("asd123JKL#5", str.toString());

      str = new ManipulateThis("asd123JKL#5QWE");
      str.changeCase();
      assertEquals("ASD123jkl#5qwe", str.toString());
      str.changeCase();
      assertEquals("asd123JKL#5QWE", str.toString());
   }

   public void testManipulateThis11() 
   {
      ManipulateThis str = new ManipulateThis("Programming");
      str.append("append");
      assertEquals("Programmingappend", str.toString());

      str = new ManipulateThis("A1234B56789C");
      str.append("append");
      assertEquals("A1234B56789Cappend", str.toString());
      str.append("append");
      assertEquals("A1234B56789Cappendappend", str.toString());

      str = new ManipulateThis("asd123JKL#5");
      str.append("append");
      assertEquals("asd123JKL#5append", str.toString());
      str.append("append");
      assertEquals("asd123JKL#5appendappend", str.toString());

      str = new ManipulateThis("asd123JKL#5QWE");
      str.append("append");
      assertEquals("asd123JKL#5QWEappend", str.toString());
      str.append("append");
      assertEquals("asd123JKL#5QWEappendappend", str.toString());
   }
   public void testManipulateThis12() 
   {
      ManipulateThis str = new ManipulateThis("Programming");

      str.repeat(1, 4);
      assertEquals("Programmingrogr", str.toString());

      str.repeat(0,1);
      assertEquals("ProgrammingrogrPr", str.toString());

      str.repeat( str.toString().length()-2, str.toString().length()-1);
      assertEquals("ProgrammingrogrPrPr", str.toString());

      str.repeat(0, str.toString().length()-1);
      assertEquals("ProgrammingrogrPrPrProgrammingrogrPrPr", str.toString());
    }
//   { (stu), (11 individual), (2-4), (5-8), (9-11), (1-11) 

   public void testManipulateThis13()  // 2 - 4
   {
      ManipulateThis str = new ManipulateThis("Programming");
      
      str.reverse(2, 4);
      assertEquals("Prrgoamming", str.toString());
      str.assign("sdffd");
      assertEquals("sdffd", str.toString());

      testManipulateThis02();
      testManipulateThis03();
      testManipulateThis04();
   }

   public void testManipulateThis14()  // 5 - 8
   {
      ManipulateThis str = new ManipulateThis("Programming");
      str.swap(3, 8);
      assertEquals("Proirammgng", str.toString());
      str.insert(" Contest", "Programming".length());
      assertEquals("Proirammgng Contest", str.toString());
      str.insert(" -", str.toString().indexOf(" "));
      assertEquals("Proirammgng - Contest", str.toString());
      str.substitute(" ", ":)");
      assertEquals("Proirammgng:)- Contest", str.toString());
      str.delete(0, 4);
      assertEquals("ammgng:)- Contest", str.toString());

      testManipulateThis05();
      testManipulateThis06();
      testManipulateThis07();
      testManipulateThis08();
   }

   public void testManipulateThis15()  // 9 - 12
   {

      ManipulateThis str = new ManipulateThis("Programming");
      str.replace("mm", "aBc");
      assertEquals("PrograaBcing", str.toString());
      str.changeCase();
      assertEquals("pROGRAAbCING", str.toString());
      str.append("append NOTHING");
      assertEquals("pROGRAAbCINGappend NOTHING", str.toString());
      str.repeat(1, 4);
      assertEquals("pROGRAAbCINGappend NOTHINGROGR", str.toString());
      str.replace("a", "-");
      assertEquals("pROGRAAbCING-ppend NOTHINGROGR", str.toString());
      str.replace("A", "-");
      assertEquals("pROGR--bCING-ppend NOTHINGROGR", str.toString());
      str.replace("R", "*");
      assertEquals("p*OG*--bCING-ppend NOTHING*OG*", str.toString());
      str.replace("p", "=");
      assertEquals("=*OG*--bCING-==end NOTHING*OG*", str.toString());

      testManipulateThis09();
      testManipulateThis10();
      testManipulateThis11();
      testManipulateThis12();
   }

   public void testManipulateThis16()  // all
   {
      testManipulateThis13();
      testManipulateThis14();
      testManipulateThis15();
   }
}