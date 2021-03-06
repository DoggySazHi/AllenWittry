import java.util.*;
/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2017 Wittry programming contest
 */
public class Wittry2017FinalTest extends junit.framework.TestCase
{
   public void testSubprimeFibs01()
   {
      SubprimeFibs sf = new SubprimeFibs(1, 1);

      assertEquals(true, sf.isPrime(2));
      assertEquals(true, sf.isPrime(3));
      assertEquals(true, sf.isPrime(11));
      assertEquals(true, sf.isPrime(1783));
      assertEquals(true, sf.isPrime(7919));
      assertEquals(true, sf.isPrime(20639));
      assertEquals(true, sf.isPrime(906767));

      assertEquals(false, sf.isPrime(1));
      assertEquals(false, sf.isPrime(4));
      assertEquals(false, sf.isPrime(9));
      assertEquals(false, sf.isPrime(7919 * 20639));
      assertEquals(false, sf.isPrime(20639 * 48623));
      assertEquals(false, sf.isPrime(906767 * 11));

      assertEquals(1, sf.getNthTerm(1));
      assertEquals(1, sf.getNthTerm(2));
      assertEquals(5, sf.getNthTerm(5));
      assertEquals(4, sf.getNthTerm(6));

      sf = new SubprimeFibs(5, 5);
      assertEquals(1, sf.getCycleIndex());

      sf = new SubprimeFibs(339, 113);
      assertEquals(4, sf.getCycleIndex());

      sf = new SubprimeFibs(17, 48);
      assertEquals(2, sf.getCycleIndex());

      sf = new SubprimeFibs(5, 11);
      assertEquals(71, sf.getCycleIndex());
   }

   public void testSubprimeFibs_IsPrime02()
   {
      SubprimeFibs sf = new SubprimeFibs(5, 5);

      assertEquals(true, sf.isPrime(841979));
      assertEquals(true, sf.isPrime(511177));
      assertEquals(true, sf.isPrime(290209));

      assertEquals(false, sf.isPrime(182813 * 19));
      assertEquals(false, sf.isPrime(255473 * 347));
      assertEquals(false, sf.isPrime(81281 * 53));
   }

   public void testSubprimeFibs_IsPrime03()
   {
      SubprimeFibs sf = new SubprimeFibs(5, 5);

      assertEquals(true, sf.isPrime(841979));
      assertEquals(true, sf.isPrime(511177));
      assertEquals(true, sf.isPrime(290209));

      assertEquals(false, sf.isPrime(384757 * 73));
      assertEquals(false, sf.isPrime(403979 * 439));
      assertEquals(false, sf.isPrime(785627 * 607));
   }

   public void testSubprimeFibs_getNthTerm04()
   {
      SubprimeFibs sf = new SubprimeFibs(5, 13);

      assertEquals(5, sf.getNthTerm(1));
      assertEquals(13, sf.getNthTerm(2));
      assertEquals(10, sf.getNthTerm(5));
      assertEquals(17, sf.getNthTerm(7));
      assertEquals(73, sf.getNthTerm(13));
      assertEquals(101, sf.getNthTerm(17));
      assertEquals(24, sf.getNthTerm(44));
      assertEquals(19, sf.getNthTerm(101));
      assertEquals(25, sf.getNthTerm(102));
   }

   public void testSubprimeFibs_getNthTerm05()
   {
      SubprimeFibs sf = new SubprimeFibs(19, 25);

      assertEquals(22, sf.getNthTerm(3));
      assertEquals(47, sf.getNthTerm(4));
      assertEquals(31, sf.getNthTerm(10));
      assertEquals(19, sf.getNthTerm(13));
      assertEquals(19, sf.getNthTerm(20));
      assertEquals(43, sf.getNthTerm(26));
      assertEquals(31, sf.getNthTerm(30));
      assertEquals(11, sf.getNthTerm(34));
      assertEquals(51, sf.getNthTerm(40));
      assertEquals(19, sf.getNthTerm(48));
      assertEquals(11, sf.getNthTerm(49));
      assertEquals(9, sf.getNthTerm(53));
      assertEquals(127, sf.getNthTerm(67));
      assertEquals(19, sf.getNthTerm(156));
      assertEquals(29, sf.getNthTerm(157));

      sf = new SubprimeFibs(11981, 11981);

      assertEquals(11981, sf.getNthTerm(1));
      assertEquals(11981, sf.getNthTerm(857));
   }
   
   public void testSubprimeFibs_getNthTerm06()
   {
      SubprimeFibs sf = new SubprimeFibs(739, 997);

      assertEquals(868, sf.getNthTerm(3));
      assertEquals(60, sf.getNthTerm(10));
      assertEquals(13, sf.getNthTerm(21));
      assertEquals(206, sf.getNthTerm(71));
      assertEquals(71, sf.getNthTerm(82));
      assertEquals(63, sf.getNthTerm(111));
      assertEquals(45, sf.getNthTerm(160));
      assertEquals(46, sf.getNthTerm(161));
      assertEquals(13, sf.getNthTerm(162));
   }
   
   public void testSubprimeFibs_getNthTerm07()
   {
      SubprimeFibs sf = new SubprimeFibs(2909, 3307-2909);
//      for (int m = 1; m < 259; m++) System.out.println(m + " " + sf.getNthTerm(m));

      assertEquals(3307, sf.getNthTerm(3));
      assertEquals(1089, sf.getNthTerm(9));
      assertEquals(59, sf.getNthTerm(19));
      assertEquals(7, sf.getNthTerm(28));
      assertEquals(9, sf.getNthTerm(82));
      assertEquals(23, sf.getNthTerm(161));
      assertEquals(25, sf.getNthTerm(162));
      assertEquals(24, sf.getNthTerm(163));
      assertEquals(7, sf.getNthTerm(164));
   }

   public void testSubprimeFibs_getCycleIndex08()
   {
      SubprimeFibs sf = new SubprimeFibs(19, 29);
      assertEquals(1, sf.getCycleIndex());

      sf = new SubprimeFibs(2909, 3307-2909);
      assertEquals(27, sf.getCycleIndex());

      sf = new SubprimeFibs(11981, 11981);
      assertEquals(1, sf.getCycleIndex());
   }

   public void testSubprimeFibs_getCycleIndex09()
   {
      SubprimeFibs sf = new SubprimeFibs(55, 1979-55);
      assertEquals(70, sf.getCycleIndex());

      sf = new SubprimeFibs(1901, 3);
      assertEquals(49, sf.getCycleIndex());

      sf = new SubprimeFibs(1001279, 1001279);
      assertEquals(1, sf.getCycleIndex());
   }

   public void testSubprimeFibs_getCycleIndex10()
   {
      SubprimeFibs sf = new SubprimeFibs(3967, 7307);
      assertEquals(163, sf.getCycleIndex());

      sf = new SubprimeFibs(8699, 12613);
      assertEquals(154, sf.getCycleIndex());
   }

   public void testPyramidCoordinates01()
    {
        List<ArrayList<String>> objs = new ArrayList<ArrayList<String>>();
        ArrayList row1 = new ArrayList<String>();
        row1.add("5");
        objs.add(row1);
        ArrayList row2 = new ArrayList<String>();
        row2.add("1");
        row2.add("3");
        objs.add(row2);
        ArrayList row3 = new ArrayList<String>();
        row3.add("2");
        row3.add("9");
        row3.add("7");
        objs.add(row3);
        ArrayList row4 = new ArrayList<String>();
        row4.add("6");
        row4.add("10");
        row4.add("4");
        row4.add("8");
        objs.add(row4);
        ArrayList row5 = new ArrayList<String>();
        row5.add("15");
        row5.add("13");
        row5.add("14");
        row5.add("11");
        row5.add("12");
        objs.add(row5);
        PyramidCoordinates myP = new PyramidCoordinates(objs);

        assertEquals("7", myP.get(3, 3));
        assertEquals("4", myP.get(4, 3));
        assertEquals("15", myP.get(5, 1));

        List<String> answers = new ArrayList<String>();
        answers.add("2");
        answers.add("9");
        answers.add("6");
        answers.add("4");
        answers.add("13");
        answers.add("14");
        String[] neighbors = myP.getNeighbors(4, 2);
        assertEquals(6, neighbors.length);
        assertEquals("10", myP.get(4, 2));
        for (int ind = 0; ind < neighbors.length; ind++)
        {
            assertEquals(true, answers.contains(neighbors[ind]));
            answers.remove(neighbors[ind]);
        }

        PyramidCoordinates result = myP.getSubPyramid(3, 3);
        assertEquals("7", result.get(1, 1));

        assertEquals("4", result.get(2, 1));
        assertEquals("8", result.get(2, 2));

        assertEquals("14", result.get(3, 1));
        assertEquals("11", result.get(3, 2));
        assertEquals("12", result.get(3, 3));
    }

    public void testPyramidCoordinatesGet02()
    {
        List<ArrayList<String>> objs = new ArrayList<ArrayList<String>>();
        ArrayList row1 = new ArrayList<String>();
        row1.add("A");
        objs.add(row1);
        ArrayList row2 = new ArrayList<String>();
        row2.add("B");
        row2.add("C");
        objs.add(row2);
        ArrayList row3 = new ArrayList<String>();
        row3.add("D");
        row3.add("E");
        row3.add("F");
        objs.add(row3);
        ArrayList row4 = new ArrayList<String>();
        row4.add("G");
        row4.add("H");
        row4.add("I");
        row4.add("J");
        objs.add(row4);
        ArrayList row5 = new ArrayList<String>();
        row5.add("K");
        row5.add("L");
        row5.add("M");
        row5.add("N");
        row5.add("O");
        objs.add(row5);
        ArrayList row6 = new ArrayList<String>();
        row6.add("P");
        row6.add("Q");
        row6.add("R");
        row6.add("S");
        row6.add("T");
        row6.add("U");
        objs.add(row6);
        ArrayList row7 = new ArrayList<String>();
        row7.add("V");
        row7.add("W");
        row7.add("X");
        row7.add("Y");
        row7.add("Z");
        row7.add("AA");
        row7.add("AB");
        objs.add(row7);
        PyramidCoordinates hp = new PyramidCoordinates(objs);

        assertEquals("A", hp.get(1, 1));
        assertEquals("E", hp.get(3, 2));
        assertEquals("L", hp.get(5, 2));
        assertEquals("O", hp.get(5, 5));
        assertEquals("R", hp.get(6, 3));
        assertEquals("M", hp.get(5, 3));
        assertEquals("Q", hp.get(6, 2));
        assertEquals("S", hp.get(6, 4));
        assertEquals("AB", hp.get(7, 7));
    }

    public void testPyramidCoordinatesGetNeighborsNonBorder03()
    {
        List<ArrayList<String>> objs = new ArrayList<ArrayList<String>>();
        ArrayList row1 = new ArrayList<String>();
        row1.add("A");
        objs.add(row1);
        ArrayList row2 = new ArrayList<String>();
        row2.add("B");
        row2.add("C");
        objs.add(row2);
        ArrayList row3 = new ArrayList<String>();
        row3.add("D");
        row3.add("E");
        row3.add("F");
        objs.add(row3);
        ArrayList row4 = new ArrayList<String>();
        row4.add("G");
        row4.add("H");
        row4.add("I");
        row4.add("J");
        objs.add(row4);
        ArrayList row5 = new ArrayList<String>();
        row5.add("K");
        row5.add("L");
        row5.add("M");
        row5.add("N");
        row5.add("O");
        objs.add(row5);
        ArrayList row6 = new ArrayList<String>();
        row6.add("P");
        row6.add("Q");
        row6.add("R");
        row6.add("S");
        row6.add("T");
        row6.add("U");
        objs.add(row6);
        ArrayList row7 = new ArrayList<String>();
        row7.add("V");
        row7.add("W");
        row7.add("X");
        row7.add("Y");
        row7.add("Z");
        row7.add("AA");
        row7.add("AB");
        objs.add(row7);
        PyramidCoordinates hp = new PyramidCoordinates(objs);

        List<String> answers = new ArrayList<String>();
        answers.add("B");
        answers.add("C");
        answers.add("D");
        answers.add("F");
        answers.add("H");
        answers.add("I");
        String[] neighbors = hp.getNeighbors(3, 2);
        assertEquals(answers.size(), neighbors.length);
        for (String ns : neighbors)
        {
            assertEquals(true, answers.contains(ns));
            answers.remove(ns);
        }

        answers = new ArrayList<String>();
        answers.add("M");
        answers.add("N");
        answers.add("R");
        answers.add("T");
        answers.add("Y");
        answers.add("Z");
        String[] neighbors1 = hp.getNeighbors(6, 4);
        assertEquals(answers.size(), neighbors1.length);
        for (String ns : neighbors1)
        {
            assertEquals(true, answers.contains(ns));
            answers.remove(ns);
        }
    }

    public void testPyramidCoordinatesGetAndGetNeighborsNonBorder04()
    {
        testPyramidCoordinatesGet02();
        testPyramidCoordinatesGetNeighborsNonBorder03();
    }

    public void testPyramidCoordinatesGetNeighborsOnTheBorder05()
    {
        List<ArrayList<String>> objs = new ArrayList<ArrayList<String>>();
        ArrayList row1 = new ArrayList<String>();
        row1.add("A");
        objs.add(row1);
        ArrayList row2 = new ArrayList<String>();
        row2.add("B");
        row2.add("C");
        objs.add(row2);
        ArrayList row3 = new ArrayList<String>();
        row3.add("D");
        row3.add("E");
        row3.add("F");
        objs.add(row3);
        ArrayList row4 = new ArrayList<String>();
        row4.add("G");
        row4.add("H");
        row4.add("I");
        row4.add("J");
        objs.add(row4);
        ArrayList row5 = new ArrayList<String>();
        row5.add("K");
        row5.add("L");
        row5.add("M");
        row5.add("N");
        row5.add("O");
        objs.add(row5);
        ArrayList row6 = new ArrayList<String>();
        row6.add("P");
        row6.add("Q");
        row6.add("R");
        row6.add("S");
        row6.add("T");
        row6.add("U");
        objs.add(row6);
        ArrayList row7 = new ArrayList<String>();
        row7.add("V");
        row7.add("W");
        row7.add("X");
        row7.add("Y");
        row7.add("Z");
        row7.add("AA");
        row7.add("AB");
        objs.add(row7);
        PyramidCoordinates hp = new PyramidCoordinates(objs);

        assertEquals("A", hp.get(1, 1));
        assertEquals("G", hp.get(4, 1));
        assertEquals("V", hp.get(7, 1));
        assertEquals("Z", hp.get(7, 5));
        assertEquals("AB", hp.get(7, 7));
        assertEquals("F", hp.get(3, 3));
    }

    public void testPyramidCoordinatesGetAndGetNeighborsOnTheBorder06()
    {
        testPyramidCoordinatesGetNeighborsOnTheBorder05();
        List<ArrayList<String>> objs = new ArrayList<ArrayList<String>>();
        ArrayList row1 = new ArrayList<String>();
        row1.add("A");
        objs.add(row1);
        ArrayList row2 = new ArrayList<String>();
        row2.add("B");
        row2.add("C");
        objs.add(row2);
        ArrayList row3 = new ArrayList<String>();
        row3.add("D");
        row3.add("E");
        row3.add("F");
        objs.add(row3);
        ArrayList row4 = new ArrayList<String>();
        row4.add("G");
        row4.add("H");
        row4.add("I");
        row4.add("J");
        objs.add(row4);
        PyramidCoordinates hp = new PyramidCoordinates(objs);

        assertEquals("A", hp.get(1, 1));
        assertEquals("D", hp.get(3, 1));
        assertEquals("G", hp.get(4, 1));
        assertEquals("J", hp.get(4, 4));
        assertEquals("F", hp.get(3, 3));
        assertEquals("C", hp.get(2, 2));
    }

    public void testPyramidCoordinatesGetSubPyramidOnTheBorder07()
    {
        List<ArrayList<String>> objs = new ArrayList<ArrayList<String>>();
        ArrayList row1 = new ArrayList<String>();
        row1.add("A");
        objs.add(row1);
        ArrayList row2 = new ArrayList<String>();
        row2.add("B");
        row2.add("C");
        objs.add(row2);
        ArrayList row3 = new ArrayList<String>();
        row3.add("D");
        row3.add("E");
        row3.add("F");
        objs.add(row3);
        ArrayList row4 = new ArrayList<String>();
        row4.add("G");
        row4.add("H");
        row4.add("I");
        row4.add("J");
        objs.add(row4);
        ArrayList row5 = new ArrayList<String>();
        row5.add("K");
        row5.add("L");
        row5.add("M");
        row5.add("N");
        row5.add("O");
        objs.add(row5);
        ArrayList row6 = new ArrayList<String>();
        row6.add("P");
        row6.add("Q");
        row6.add("R");
        row6.add("S");
        row6.add("T");
        row6.add("U");
        objs.add(row6);
        ArrayList row7 = new ArrayList<String>();
        row7.add("V");
        row7.add("W");
        row7.add("X");
        row7.add("Y");
        row7.add("Z");
        row7.add("AA");
        row7.add("AB");
        objs.add(row7);
        PyramidCoordinates hp = new PyramidCoordinates(objs);

        List<String> answers = new ArrayList<String>();
        answers.add("D");
        answers.add("H");
        answers.add("K");
        answers.add("L");
        String[] neighbors = hp.getNeighbors(4, 1);
        assertEquals(answers.size(), neighbors.length);
        for (String ns : neighbors)
        {
            assertEquals(true, answers.contains(ns));
            answers.remove(ns);
        }

        answers = new ArrayList<String>();
        answers.add("O");
        answers.add("T");
        answers.add("AA");
        answers.add("AB");
        neighbors = hp.getNeighbors(6, 6);
        assertEquals(answers.size(), neighbors.length);
        for (String ns : neighbors)
        {
            assertEquals(true, answers.contains(ns));
            answers.remove(ns);
        }

        answers = new ArrayList<String>();
        answers.add("Q");
        answers.add("R");
        answers.add("W");
        answers.add("Y");
        neighbors = hp.getNeighbors(7, 3);
        assertEquals(answers.size(), neighbors.length);
        for (String ns : neighbors)
        {
            assertEquals(true, answers.contains(ns));
            answers.remove(ns);
        }

        answers = new ArrayList<String>();
        answers.add("B");
        answers.add("C");
        neighbors = hp.getNeighbors(1, 1);
        assertEquals(answers.size(), neighbors.length);
        for (String ns : neighbors)
        {
            assertEquals(true, answers.contains(ns));
            answers.remove(ns);
        }
    }

    public void testPyramidCoordinatesGetSubPyramidOnTheBorder08()
    {
        List<ArrayList<String>> objs = new ArrayList<ArrayList<String>>();
        ArrayList row1 = new ArrayList<String>();
        row1.add("A");
        objs.add(row1);
        ArrayList row2 = new ArrayList<String>();
        row2.add("B");
        row2.add("C");
        objs.add(row2);
        ArrayList row3 = new ArrayList<String>();
        row3.add("D");
        row3.add("E");
        row3.add("F");
        objs.add(row3);
        ArrayList row4 = new ArrayList<String>();
        row4.add("G");
        row4.add("H");
        row4.add("I");
        row4.add("J");
        objs.add(row4);
        ArrayList row5 = new ArrayList<String>();
        row5.add("K");
        row5.add("L");
        row5.add("M");
        row5.add("N");
        row5.add("O");
        objs.add(row5);
        ArrayList row6 = new ArrayList<String>();
        row6.add("P");
        row6.add("Q");
        row6.add("R");
        row6.add("S");
        row6.add("T");
        row6.add("U");
        objs.add(row6);
        ArrayList row7 = new ArrayList<String>();
        row7.add("V");
        row7.add("W");
        row7.add("X");
        row7.add("Y");
        row7.add("Z");
        row7.add("AA");
        row7.add("AB");
        objs.add(row7);
        PyramidCoordinates hp = new PyramidCoordinates(objs);

        PyramidCoordinates result = hp.getSubPyramid(3, 3);
        assertEquals("F", result.get(1, 1));

        assertEquals("I", result.get(2, 1));
        assertEquals("J", result.get(2, 2));

        assertEquals("M", result.get(3, 1));
        assertEquals("N", result.get(3, 2));
        assertEquals("O", result.get(3, 3));

        assertEquals("R", result.get(4, 1));
        assertEquals("S", result.get(4, 2));
        assertEquals("T", result.get(4, 3));
        assertEquals("U", result.get(4, 4));

        assertEquals("X", result.get(5, 1));
        assertEquals("Y", result.get(5, 2));
        assertEquals("Z", result.get(5, 3));
        assertEquals("AA", result.get(5, 4));
        assertEquals("AB", result.get(5, 5));

        result = hp.getSubPyramid(5, 1);
        assertEquals("K", result.get(1, 1));

        assertEquals("P", result.get(2, 1));
        assertEquals("Q", result.get(2, 2));

        assertEquals("V", result.get(3, 1));
        assertEquals("W", result.get(3, 2));
        assertEquals("X", result.get(3, 3));
    }

    public void testPyramidCoordinatesAllNonBorder09()
    {
        testPyramidCoordinatesGetAndGetNeighborsNonBorder04();
        testPyramidCoordinatesGetSubPyramidOnTheBorder07();
    }

    public void testPyramidCoordinatesAllOnTheBorder10()
    {
        testPyramidCoordinatesGetAndGetNeighborsOnTheBorder06();
        testPyramidCoordinatesGetSubPyramidOnTheBorder08();
    }

    public void testPiDayProblem01()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(1);

        assertEquals(9, solution.size());

        assertEquals(true, solution.contains(""+1));
        assertEquals(true, solution.contains(""+2));
        assertEquals(true, solution.contains(""+3));
        assertEquals(true, solution.contains(""+4));
        assertEquals(true, solution.contains(""+5));
        assertEquals(true, solution.contains(""+6));
        assertEquals(true, solution.contains(""+7));
        assertEquals(true, solution.contains(""+8));
        assertEquals(true, solution.contains(""+9));

        solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(2);

        assertEquals(41, solution.size());

        assertEquals(true, solution.contains(""+10));
        assertEquals(true, solution.contains(""+12));
        assertEquals(true, solution.contains(""+14));
        assertEquals(true, solution.contains(""+16));
        assertEquals(true, solution.contains(""+18));
        assertEquals(true, solution.contains(""+20));
        assertEquals(true, solution.contains(""+24));
        assertEquals(true, solution.contains(""+26));
        assertEquals(true, solution.contains(""+28));
        assertEquals(true, solution.contains(""+30));
        assertEquals(true, solution.contains(""+32));
        assertEquals(true, solution.contains(""+34));
        assertEquals(true, solution.contains(""+36));
        assertEquals(true, solution.contains(""+38));
        assertEquals(true, solution.contains(""+40));
        assertEquals(true, solution.contains(""+42));
        assertEquals(true, solution.contains(""+46));
        assertEquals(true, solution.contains(""+48));
        assertEquals(true, solution.contains(""+50));
        assertEquals(true, solution.contains(""+52));
        assertEquals(true, solution.contains(""+54));
        assertEquals(true, solution.contains(""+56));
        assertEquals(true, solution.contains(""+58));
        assertEquals(true, solution.contains(""+60));
        assertEquals(true, solution.contains(""+62));
        assertEquals(true, solution.contains(""+64));
        assertEquals(true, solution.contains(""+68));
        assertEquals(true, solution.contains(""+70));
        assertEquals(true, solution.contains(""+72));
        assertEquals(true, solution.contains(""+74));
        assertEquals(true, solution.contains(""+76));
        assertEquals(true, solution.contains(""+78));
        assertEquals(true, solution.contains(""+80));
        assertEquals(true, solution.contains(""+82));
        assertEquals(true, solution.contains(""+84));
        assertEquals(true, solution.contains(""+86));
        assertEquals(true, solution.contains(""+90));
        assertEquals(true, solution.contains(""+92));
        assertEquals(true, solution.contains(""+94));
        assertEquals(true, solution.contains(""+96));
        assertEquals(true, solution.contains(""+98));
    }

    public void testPiDayProblem02()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(2);

        int[] ansSeed = { 10, 12, 14, 16, 18, 20, 24, 26, 28, 30, 32, 34, 36, 38, 
                40, 42, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 68, 
                70, 72, 74, 76, 78, 80, 82, 84, 86, 90, 92, 94, 96, 98}; 

        assertEquals(ansSeed.length, solution.size());

        for(int i : ansSeed)
            assertEquals(true, solution.contains(""+i));
    }

    public void testPiDayProblem03()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(3);

        int[] ansSeed = { 549, 546, 825, 285, 567, 804, 564, 807, 801, 561, 261, 267, 264,
                789, 306, 309, 786, 528, 768, 540, 783, 543, 780, 342, 609, 348,
                345, 621, 627, 864, 327, 324, 624, 867, 321, 102, 849, 369, 582,
                381, 108, 861, 105, 843, 126, 603, 840, 846, 123, 360, 120, 687,
                408, 684, 681, 129, 948, 402, 945, 405, 702, 942, 387, 147, 384,
                927, 924, 168, 648, 921, 645, 162, 165, 642, 186, 426, 429, 906,
                189, 903, 183, 420, 180, 423, 204, 207, 201, 468, 741, 465, 762,
                462, 765, 987, 984, 504, 507, 705, 501, 708, 981, 729, 489, 249,
                720, 246, 963, 486, 723, 960, 480, 243, 483, 726, 240}; 

        assertEquals(ansSeed.length, solution.size());

        for(int i : ansSeed)
            assertEquals(true, solution.contains(""+i));
    }

    public void testPiDayProblem04()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(4);

        int[] ansSeed = { 7652, 6812, 7052, 7412, 5496, 7892, 8256, 5492, 4620, 7896, 4892,
                9216, 2436, 7416, 4628, 1896, 9480, 9240, 2460, 3812, 3276, 9064, 3816,
                1892, 9068, 7056, 1652, 7084, 7620, 5468, 6840, 9248, 7628, 5460, 4652,
                2468, 7624, 1624, 1864, 4896, 1628, 9276, 4052, 9032, 4056, 9036, 1620,
                1860, 3216, 5432, 6872, 3456, 5436, 5640, 1024, 4680, 7836, 8076, 1296,
                1028, 7832, 8072, 2496, 1836, 3064, 1832, 3068, 1052, 4208, 4028, 9840,
                5408, 3480, 5648, 8460, 3248, 7860, 8496, 5672, 1056, 7864, 7296, 1804,
                9816, 1084, 3240, 8492, 9812, 5824, 4268, 5016, 8012, 5012, 2856, 2076,
                4260, 2048, 1236, 2016, 3420, 1476, 6452, 9604, 3692, 1472, 5612, 9608,
                8016, 7268, 8640, 6092, 7264, 7260, 4236, 5048, 7804, 3428, 1260, 3452,
                9876, 1268, 9632, 9872, 6420, 1264, 8436, 7236, 8432, 6428, 8672, 3096,
                5280, 5284, 6032, 3876, 5072, 9420, 3872, 3092, 5076, 9428, 7208, 6240,
                7684, 7680, 7204, 6248, 2640, 4296, 3608, 2648, 3604, 9452, 4832, 2408,
                4836, 3840, 7024, 1684, 9456, 7028, 1680, 6480, 1204, 4860, 1208, 5820, 8612}; 

        assertEquals(ansSeed.length, solution.size());

        for(int i : ansSeed)
            assertEquals(true, solution.contains(""+i)); 
    }

    public void testPiDayProblem05()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(5);

        int[] ansSeed = { 76520, 72605, 16520, 90325, 36920, 12645, 36925, 12640, 16285, 16280,
                18960, 90365, 18965, 30645, 86405, 72085, 82560, 92765, 92760, 64520,
                38405, 54920, 92165, 14760, 92160, 14765, 30685, 78605, 12605, 48365,
                98125, 48360, 98120, 46205, 84605, 72640, 72645, 24360, 24365, 14720,
                98165, 42365, 14725, 98160, 42360, 58240, 72680, 78645, 72685, 34560,
                78640, 48325, 54960, 48320, 94560, 32165, 38125, 80725, 32160, 38120,
                34805, 76805, 18045, 78325, 64205, 78320, 98720, 76840, 76845, 98725,
                96045, 24680, 20765, 24685, 80765, 10845, 20165, 34285, 18605, 62485,
                34280, 62480, 54360, 68125, 68725, 68120, 92405, 68720, 16205, 60325,
                34205, 18640, 98765, 18645, 90685, 98760, 54320, 10245, 80165, 96085,
                72045, 24605, 56480, 46805, 94520, 46285, 46280, 90645, 42960, 42965,
                12680, 12685, 60925, 16240, 32765, 72960, 10285, 16245, 32760, 72965,
                64805, 76245, 76240, 36045, 92480, 80125, 62405, 38720, 92485, 38725,
                52840, 76285, 96320, 72365, 76280, 96325, 72360, 12365, 36085, 12360,
                56120, 16805, 38760, 38765, 18360, 78965, 78365, 24085, 18365, 78960,
                42605, 78360, 64280, 16840, 64285, 16845, 24965, 86725, 24960, 86720,
                42085, 18320, 38160, 18325, 38165, 54680, 48605, 84320, 78925, 84325,
                78920, 70245, 76205, 98405, 68405, 84920, 94805, 46520, 84925, 32405,
                30965, 70285, 42685, 84365, 42680, 84360, 48925, 12085, 48920, 26405,
                20485, 12045, 78045, 28560, 34520, 30925, 94280, 40285, 94285, 74120,
                48960, 48965, 74125, 26485, 94205, 26480, 70845, 84965, 86120, 84960,
                86125, 18920, 18925, 12965, 12960, 32485, 32480, 74160, 74165, 56720}; 

        assertEquals(ansSeed.length, solution.size());

        for(int i : ansSeed)
            assertEquals(true, solution.contains(""+i)); 
    }

    public void testPiDayProblem06()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(6);

        int[] ansSeed = { 783204, 762450, 102456, 183654, 381654, 387204, 108456, 789654, 369204,
                963258, 567204, 867204, 147258, 561204, 201654, 162804, 768450, 162408,
                903258, 987204, 789204, 165204, 807654, 786054, 708456, 183204, 186054,
                981654, 783654, 327654, 168450, 963204, 765204, 309654, 309258, 129654,
                762054, 903654, 186402, 726408, 162054, 861204, 723654, 780456, 168402,
                702456, 981204, 186450, 180456, 768402, 603258, 189204, 126408, 120456,
                741258, 360852, 786402, 369258, 306852, 786450, 609258, 681204, 126804,
                126054, 729654, 126450, 162450, 321654, 387654, 123654, 726804, 207654,
                768054, 720456, 687204, 960852, 726054, 762804, 726450, 801654, 168054,
                921654, 987654, 762408, 189654, 927654, 381204, 906852}; 

        assertEquals(ansSeed.length, solution.size());

        for(int i : ansSeed)
            assertEquals(true, solution.contains(""+i)); 
    }

    public void testPiDayProblem07()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(7);

        int[] ansSeed = { 3096541, 1620549, 7264089, 7412580, 1296547, 7836549, 9068521, 9632581,
                3692584, 7684502, 9216543, 6092583, 7892045, 1296540, 3068527, 1024569,
                3812046, 7684509, 2076543, 1204567, 3096548, 3816547, 1472583, 7296541,
                7024563, 1268043, 7264509, 7204568, 7652043, 3092586, 7204561, 7624085,
                6812043, 3216549, 8672041, 1652049, 1832047, 7836542, 3608521, 5612047,
                9812047, 9276540, 7620543, 7832041, 3692045, 1864023, 1264508, 7296548,
                8016547, 3816540, 1684025}; 

        assertEquals(ansSeed.length, solution.size());

        for(int i : ansSeed)
            assertEquals(true, solution.contains(""+i)); 
    }

    public void testPiDayProblem08()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(8);

        int[] ansSeed = { 78920456, 72965480, 12965408, 38165472, 78320416, 80165472,
                36925840, 92765408, 30925864}; 

        assertEquals(ansSeed.length, solution.size());

        for(int i : ansSeed)
            assertEquals(true, solution.contains(""+i)); 
    }

    public void testPiDayProblem09()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(9);

        int[] ansSeed = { 801654723, 381654729, 783204165, 381654720}; 

        assertEquals(ansSeed.length, solution.size());

        for(int i : ansSeed)
            assertEquals(true, solution.contains(""+i)); 
    }

    public void testPiDayProblem10()
    {
        List<String> solution = PizzaHutPiDayProblem1.pizzaHut2016EasyPiDayProblem(10);

        assertEquals(1, solution.size());

        assertEquals("3816547290", solution.get(0)); 
    }

    public void testPeriodicWords01()
    {
        List<Element> inStock = new ArrayList<Element>();
        inStock.add( new Element("H", 1));
        inStock.add( new Element("He", 2));
        inStock.add( new Element("O", 8));
        inStock.add( new Element("C", 6));
        PeriodicWords pw = new PeriodicWords(inStock);

        List<Element>  mix = new ArrayList<Element>();
        mix.add( new Element("H", 1));
        mix.add( new Element("Li", 3));
        mix.add( new Element("O", 8));

        List<Element> missing = pw.getMissingElements(mix);
        assertEquals(4, inStock.size());
        assertEquals(3, mix.size());
        assertEquals(1, missing.size());
        assertEquals(new Element("Li", 3), missing.get(0));

        pw = new PeriodicWords();
        assertEquals(true, pw.isPeriodicSpellingPossible("BACON"));
        assertEquals(true, pw.isPeriodicSpellingPossible("HER"));
        assertEquals(true, pw.isPeriodicSpellingPossible("HERE"));
        assertEquals(true, pw.isPeriodicSpellingPossible("SPOONS"));
        assertEquals(true, pw.isPeriodicSpellingPossible("BYTE"));
        assertEquals(true, pw.isPeriodicSpellingPossible("LIKES"));
        assertEquals(false, pw.isPeriodicSpellingPossible("TEST"));
        assertEquals(false, pw.isPeriodicSpellingPossible("COMPUTER"));
    }

    public void testMissingElements_SingleElements02()
    {
        List<Element> inStock = new ArrayList<Element>();
        inStock.add( new Element("H", 1));
        inStock.add( new Element("V", 23));
        inStock.add( new Element("O", 8));
        inStock.add( new Element("N", 7));
        inStock.add( new Element("C", 6));
        inStock.add( new Element("Sc", 21));
        inStock.add( new Element("Tb", 65));
        PeriodicWords pw = new PeriodicWords(inStock);

        List<Element>  mix = new ArrayList<Element>();
        List<Element> missing = pw.getMissingElements(mix);
        List<Element>  ans = new ArrayList<Element>();
        assertEquals(ans.size(), missing.size());

        mix = new ArrayList<Element>();
        mix.add( new Element("H", 1));
        mix.add( new Element("Li", 3));
        mix.add( new Element("O", 8));
        missing = pw.getMissingElements(mix);

        ans = new ArrayList<Element>();
        ans.add( new Element("Li", 3));
        assertEquals(7, inStock.size());
        assertEquals(3, mix.size());
        assertEquals(1, ans.size());
        assertEquals(ans.size(), missing.size());
        assertEquals(new Element("Li", 3), missing.get(0));
        //      assertEquals(true, missing.indexOf(new Element("Li", 3)) >= 0);

        mix.add( new Element("Mg", 12));
        mix.add( new Element("Uus", 117));
        mix.add( new Element("F", 9));
        missing = pw.getMissingElements(mix);

        ans = new ArrayList<Element>();
        ans.add( new Element("Li", 3));
        ans.add( new Element("Mg", 12));
        ans.add( new Element("Uus", 117));
        ans.add( new Element("F", 9));
        assertEquals(7, inStock.size());
        assertEquals(6, mix.size());
        assertEquals(4, ans.size());
        assertEquals(ans.size(), missing.size());
        assertEquals(true, missing.indexOf(new Element("Mg", 12)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Li", 3)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Uus", 117)) >= 0);
        assertEquals(true, missing.indexOf(new Element("F", 9)) >= 0);
    }

    public void testMissingElements_MultipleElements03()
    {
        List<Element> inStock = new ArrayList<Element>();
        inStock.add( new Element("H", 1));
        inStock.add( new Element("He", 2));
        inStock.add( new Element("O", 8));
        inStock.add( new Element("Tb", 65));
        inStock.add( new Element("C", 6));
        inStock.add( new Element("H", 1));
        inStock.add( new Element("He", 2));
        inStock.add( new Element("O", 8));
        inStock.add( new Element("Sc", 21));
        inStock.add( new Element("Tb", 65));
        inStock.add( new Element("O", 8));
        inStock.add( new Element("Sc", 21));
        inStock.add( new Element("Bk", 97));
        inStock.add( new Element("Cf", 98));
        inStock.add( new Element("O", 8));
        inStock.add( new Element("Sc", 21));
        inStock.add( new Element("Tb", 65));
        inStock.add( new Element("O", 8));
        /*  H - 2, He - 2, C - 1, O - 5, Sc - 2, Tb - 3, Bk - 1, Cf - 1  */
        PeriodicWords pw = new PeriodicWords(inStock);

        List<Element>  mix = new ArrayList<Element>();
        mix.add( new Element("H", 1));
        mix.add( new Element("C", 6));
        mix.add( new Element("Cf", 98));
        mix.add( new Element("O", 8));
        mix.add( new Element("H", 1));
        mix.add( new Element("O", 8));
        mix.add( new Element("Os", 76));
        mix.add( new Element("O", 8));
        mix.add( new Element("Cf", 98));
        mix.add( new Element("O", 8));
        mix.add( new Element("Bk", 97));
        mix.add( new Element("C", 6));
        mix.add( new Element("O", 8));
        mix.add( new Element("H", 1));
        mix.add( new Element("O", 8));
        mix.add( new Element("O", 8));
        /*  H - 2, He - 2, C - 1, O - 5, Sc - 2, Tb - 3, Bk - 1, Cf - 1  */

        List<Element>  ans = new ArrayList<Element>();
        ans.add( new Element("O", 8));
        ans.add( new Element("O", 8));
        ans.add( new Element("Os", 76));
        ans.add( new Element("C", 6));
        ans.add( new Element("H", 1));
        ans.add( new Element("Cf", 98));

        List<Element> missing = pw.getMissingElements(mix);
        assertEquals(18, inStock.size());
        assertEquals(16, mix.size());
        assertEquals(6, ans.size());
        assertEquals(ans.size(), missing.size());
        assertEquals(true, missing.indexOf(new Element("C", 6)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Os", 76)) >= 0);
        assertEquals(true, missing.indexOf(new Element("H", 1)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Cf", 98)) >= 0);
        assertEquals(true, missing.indexOf(new Element("O", 8)) >= 0);
        missing.remove(new Element("O", 8));
        assertEquals(true, missing.indexOf(new Element("O", 8)) >= 0);

        /*  H - 2, He - 2, C - 1, Sc - 2, Tb - 3*/
        mix.add( new Element("Ba", 56));
        mix.add( new Element("Ru", 44));
        mix.add( new Element("Cf", 98));

        ans.add( new Element("Ba", 56));
        ans.add( new Element("Ru", 44));
        ans.add( new Element("Cf", 98));

        missing = pw.getMissingElements(mix);
        assertEquals(18, inStock.size());
        assertEquals(19, mix.size());
        assertEquals(9, ans.size());
        assertEquals(ans.size(), missing.size());
        assertEquals(true, missing.indexOf(new Element("C", 6)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Os", 76)) >= 0);
        assertEquals(true, missing.indexOf(new Element("H", 1)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Cf", 98)) >= 0);
        assertEquals(true, missing.indexOf(new Element("O", 8)) >= 0);
        missing.remove(new Element("O", 8));
        assertEquals(true, missing.indexOf(new Element("O", 8)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Ba", 56)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Ru", 44)) >= 0);
        assertEquals(true, missing.indexOf(new Element("Cf", 98)) >= 0);
    }

    public void testMissingElements_All04()
    {
        testMissingElements_SingleElements02();
        testMissingElements_MultipleElements03();
    }

    public void testSpellingWithSingleLetterElements05()
    {
        PeriodicWords pw = new PeriodicWords();

        assertEquals(true, pw.isPeriodicSpellingPossible("WHUPS"));
        assertEquals(true, pw.isPeriodicSpellingPossible("OBIS"));
        assertEquals(true, pw.isPeriodicSpellingPossible("PICNIC"));
        assertEquals(true, pw.isPeriodicSpellingPossible("YUK"));
        assertEquals(true, pw.isPeriodicSpellingPossible("FOV"));
        assertEquals(true, pw.isPeriodicSpellingPossible("UWIYKVPSBCNOFH"));

        assertEquals(false, pw.isPeriodicSpellingPossible("AWHUPS"));
        assertEquals(false, pw.isPeriodicSpellingPossible("OBDIS"));
        assertEquals(false, pw.isPeriodicSpellingPossible("PICNICYE"));
        assertEquals(false, pw.isPeriodicSpellingPossible("YGUK"));
        assertEquals(false, pw.isPeriodicSpellingPossible("FOVJ"));
        assertEquals(false, pw.isPeriodicSpellingPossible("LTMQR"));
        assertEquals(false, pw.isPeriodicSpellingPossible("XZ"));
    }

    public void testSpellingWithDoubleLetterElements06()
    {
        PeriodicWords pw = new PeriodicWords();

        assertEquals(true, pw.isPeriodicSpellingPossible("NE"));
        assertEquals(true, pw.isPeriodicSpellingPossible("HE"));
        assertEquals(true, pw.isPeriodicSpellingPossible("LIBENE"));
        assertEquals(true, pw.isPeriodicSpellingPossible("CASCTICRMNFECO"));
        assertEquals(true, pw.isPeriodicSpellingPossible("NICUZNGAGEASSEBRKR"));
        assertEquals(true, pw.isPeriodicSpellingPossible("RBSRZRNBMOTCRURHPD"));
        assertEquals(true, pw.isPeriodicSpellingPossible("AGCDINSNSBTEXE"));
        assertEquals(true, pw.isPeriodicSpellingPossible("CSBAHFTAREOSIRPTAUHG"));
        assertEquals(true, pw.isPeriodicSpellingPossible("TLPBBIPOATRNFRRARFDB"));
        assertEquals(true, pw.isPeriodicSpellingPossible("SGBHHSMTDSRGLACEPRNDPMSM"));
        assertEquals(true, pw.isPeriodicSpellingPossible("EUGDTBDYHOERTMYBLUACTHPANPPUAMCMBKCFESFMMDNOLR"));

        assertEquals(false, pw.isPeriodicSpellingPossible("AB"));
        assertEquals(false, pw.isPeriodicSpellingPossible("LIHR"));
        assertEquals(false, pw.isPeriodicSpellingPossible("CAZQSCTICRMNFECO"));
        assertEquals(false, pw.isPeriodicSpellingPossible("NICUZNGAGEASSEBRRRKR"));
    }

    public void testSpellingWithTripleLetterElements07()
    {
        PeriodicWords pw = new PeriodicWords();

        assertEquals(true, pw.isPeriodicSpellingPossible("UUBUUTUUPUUS"));
        assertEquals(true, pw.isPeriodicSpellingPossible("UUTUUQUUPUUHUUSUUO"));
        assertEquals(false, pw.isPeriodicSpellingPossible("UUA"));
        assertEquals(false, pw.isPeriodicSpellingPossible("UUD"));
        assertEquals(false, pw.isPeriodicSpellingPossible("UUSA"));
        assertEquals(false, pw.isPeriodicSpellingPossible("USA"));
    }

    public void testSpellingWithMixedLengthElements08()
    {
        PeriodicWords pw = new PeriodicWords();
        assertEquals(true, pw.isPeriodicSpellingPossible("HEUUH"));
        assertEquals(true, pw.isPeriodicSpellingPossible("FSGUUTVZR"));
        assertEquals(true, pw.isPeriodicSpellingPossible("VICTIRY"));
        assertEquals(true, pw.isPeriodicSpellingPossible("MNUUUTHBAL"));
        assertEquals(true, pw.isPeriodicSpellingPossible("OSYUUPATKMG"));
        assertEquals(true, pw.isPeriodicSpellingPossible("WATER"));

        assertEquals(false, pw.isPeriodicSpellingPossible("LIBYCG"));
        assertEquals(false, pw.isPeriodicSpellingPossible("WATERING"));
        assertEquals(false, pw.isPeriodicSpellingPossible("SOAP"));
        assertEquals(false, pw.isPeriodicSpellingPossible("PROGRAMERS"));
        //      assertEquals(false, true);
    }

    public void testMissingElementsAndSpelling09()
    {
        testMissingElements_SingleElements02();
        testMissingElements_MultipleElements03();
        testSpellingWithSingleLetterElements05();
        testSpellingWithDoubleLetterElements06();
        testSpellingWithTripleLetterElements07();
    }

    public void testAll_MissingElementsAndSpelling10()
    {
        testMissingElements_All04();
        testSpellingWithMixedLengthElements08();
        testMissingElementsAndSpelling09();
    }

    public void testEgyptianMultiplication01()
    {
        assertEquals(1, EgyptianMultiplication.toDecimal("|"));
        assertEquals(37, EgyptianMultiplication.toDecimal("|||||||nnn"));
        assertEquals(3103, EgyptianMultiplication.toDecimal("|||9888"));
        assertEquals(50290, EgyptianMultiplication.toDecimal("nnnnnnnnn99rrrrr"));

        assertEquals("|", EgyptianMultiplication.toEgyptianNumber(1));
        assertEquals("|||||||nnn", EgyptianMultiplication.toEgyptianNumber(37));
assertEquals("|||9888", EgyptianMultiplication.toEgyptianNumber(3103));
      assertEquals("nnnnnnnnn99rrrrr", EgyptianMultiplication.toEgyptianNumber(50290));

      String [] ans = EgyptianMultiplication.multiply("|||", "|n");
      assertEquals("|     |n", ans[0]);
      assertEquals("||     ||nn", ans[1]);
      assertEquals("|||nnn", ans[2]);

      ans = EgyptianMultiplication.multiply("|||||||||n", "|||nnnnnnnn");
      assertEquals("|     |||nnnnnnnn", ans[0]);
      assertEquals("||     ||||||nnnnnn9", ans[1]);
      assertEquals("||||||n     ||||||||nn9998", ans[2]);
      assertEquals("|||||||nnnnnnn999998", ans[3]);
   }

   public void testToDecimal02()
   {
      assertEquals(29099, EgyptianMultiplication.toDecimal("|||||||||nnnnnnnnn888888888rr"));
      assertEquals(90100, EgyptianMultiplication.toDecimal("9rrrrrrrrr"));
      assertEquals(1932, EgyptianMultiplication.toDecimal("||nnn9999999998"));
      assertEquals(10503, EgyptianMultiplication.toDecimal("|||99999r"));
      assertEquals(10, EgyptianMultiplication.toDecimal("n"));
      assertEquals(1, EgyptianMultiplication.toDecimal("|"));
   }

   public void testToDecimal03()
   {
      assertEquals(36000, EgyptianMultiplication.toDecimal("888888rrr"));
      assertEquals(1481, EgyptianMultiplication.toDecimal("|nnnnnnnn99998"));
      assertEquals(170, EgyptianMultiplication.toDecimal("nnnnnnn9"));
      assertEquals(3166, EgyptianMultiplication.toDecimal("||||||nnnnnn9888"));
      assertEquals(10000, EgyptianMultiplication.toDecimal("r"));
      assertEquals(1000, EgyptianMultiplication.toDecimal("8"));
   }

   public void testToDecimal04()
   {
      assertEquals(40047, EgyptianMultiplication.toDecimal("|||||||rrrrnnnn"));
      assertEquals(4001, EgyptianMultiplication.toDecimal("|8888"));
      assertEquals(770, EgyptianMultiplication.toDecimal("nnnnnnn9999999"));
      assertEquals(73166, EgyptianMultiplication.toDecimal("||||||nnnnnn9888rrrrrrr"));
      assertEquals(100, EgyptianMultiplication.toDecimal("9"));
   }

   public void testToEgyptianNumber05()
   {
      assertEquals("|||||||||nnnnnnnnn999999999888888888rrrrrrrrr",
                                      EgyptianMultiplication.toEgyptianNumber(99999));
      assertEquals("|", EgyptianMultiplication.toEgyptianNumber(1));
      assertEquals("||||||nnnnnnnrr", EgyptianMultiplication.toEgyptianNumber(20076));
      assertEquals("99988888rrrrrr", EgyptianMultiplication.toEgyptianNumber(65300));
   }

   public void testToEgyptianNumber06()
   {
      assertEquals("n", EgyptianMultiplication.toEgyptianNumber(10));
      assertEquals("||nnnnn9999998888888", EgyptianMultiplication.toEgyptianNumber(7652));
      assertEquals("9", EgyptianMultiplication.toEgyptianNumber(100));
      assertEquals("|nnnnnnn988rrr", EgyptianMultiplication.toEgyptianNumber(32171));
   }

   public void testToEgyptianNumber07()
   {
      assertEquals("8", EgyptianMultiplication.toEgyptianNumber(1000));
      assertEquals("|||nnnnnnn", EgyptianMultiplication.toEgyptianNumber(73));
      assertEquals("nnnnnnnnnrrrrrrrrr", EgyptianMultiplication.toEgyptianNumber(90090));
      assertEquals("r", EgyptianMultiplication.toEgyptianNumber(10000));
   }

   public void testEgyptianMultiplication08_13x72_38x607()
   {
      String [] ans = EgyptianMultiplication.multiply("|||n", "||nnnnnnn");
      assertEquals("|     ||nnnnnnn", ans[0]);
      assertEquals("||||     ||||||||nnnnnnnn99", ans[1]);
      assertEquals("||||||||     ||||||nnnnnnn99999", ans[2]);
      assertEquals("||||||nnn999999999", ans[3]);

      ans = EgyptianMultiplication.multiply("nnn||||||||", "|||||||999999");
      assertEquals("||     ||||n998", ans[0]);
      assertEquals("||||     ||||||||nn999988", ans[1]);
      assertEquals("||nnn     ||||nn9999888888888r", ans[2]);
      assertEquals("||||||nnnnnn888rr", ans[3]);
   }

   public void testEgyptianMultiplication09_32x128_64x128()
   {
      String [] ans = EgyptianMultiplication.multiply("||nnn", "||||||||nn9");
      assertEquals("||nnn     ||||||nnnnnnnnn8888", ans[0]);
      assertEquals("||||||nnnnnnnnn8888", ans[1]);

      ans = EgyptianMultiplication.multiply("||||nnnnnn", "||||||||nn9");
      assertEquals("||||nnnnnn     ||nnnnnnnnn988888888", ans[0]);
      assertEquals("||nnnnnnnnn988888888", ans[1]);
   }

/*
*	| for one (careful, it's a vertical line, not 1) 
*	n for ten 
*	9 for hundred 
*	8 for thousand 
*	r for ten-thousand 
*	
*	For the purpose of this problem, we will not consider numbers greater than 99,999
*/

   public void testEgyptianMultiplication10_misc()
   {
      /*   219 * 451  = 98769 */
      String [] ans = EgyptianMultiplication.multiply("|||||||||n99", "|nnnnn9999");
      assertEquals("|     |nnnnn9999", ans[0]);
      assertEquals("||     ||999999999", ans[1]);
      assertEquals("||||||||     ||||||||999999888", ans[2]);
      assertEquals("||||||n     ||||||n998888888", ans[3]);
      assertEquals("||||nnnnnn     ||||nnnnnn9999999988888888rr", ans[4]);
      assertEquals("||||||||nn9     ||||||||nn99999998888888rrrrr", ans[5]);
      assertEquals("|||||||||nnnnnn999999988888888rrrrrrrrr", ans[6]);

      /*   418 * 79  = 33022       418 = 256 + 128 + 32 +2*/
      ans = EgyptianMultiplication.multiply("||||||||n9999", "|||||||||nnnnnnn");
      assertEquals("||     ||||||||nnnnn9", ans[0]);
      assertEquals("||nnn     ||||||||nn9999988", ans[1]);
      assertEquals("||||||||nn9     ||n9r", ans[2]);
      assertEquals("||||||nnnnn99     ||||nn99rr", ans[3]);
      assertEquals("||nn888rrr", ans[4]);

      /*   1 * 7879   */
      ans = EgyptianMultiplication.multiply("|", "|||||||||nnnnnnn999999998888888");
      assertEquals("|     |||||||||nnnnnnn999999998888888", ans[0]);
      assertEquals("|||||||||nnnnnnn999999998888888", ans[1]);

      /*   2048 * 1   */
      ans = EgyptianMultiplication.multiply("||||||||nnnn88", "|");
      assertEquals("||||||||nnnn88     ||||||||nnnn88", ans[0]);
      assertEquals("||||||||nnnn88", ans[1]);
   }

   public void testForestPlayGround01()
    {
        String[] figure1 = {"0", "1", "2", "3", "4", "5", "6", "7"};
        ForestPlayGround t = new ForestPlayGround(figure1);

        assertEquals(8, t.getNumNodes());
        assertEquals(4, t.getNumLeafs());

        String[] figure2 = {"A", "B", "C", "D", null, "E"};
        ForestPlayGround t2 = new ForestPlayGround(figure2);

        assertEquals(5, t2.getNumNodes());
        assertEquals(2, t2.getNumLeafs());

        String ans = t.getLeftChild(4);
        assertEquals(null, ans);
        ans = t.getRightChild(2);
        assertEquals("6", ans);
        ans = t.getParent(5);
        assertEquals("2", ans);
        ans = t.getParent(5);
        assertEquals("2", ans);
        List<String> ancestors = t.getAncestors(6);
        assertEquals(2, ancestors.size());
        assertEquals(true, ancestors.contains("2"));
        assertEquals(true, ancestors.contains("0"));
        List<String> descendants = t.getDescendants(1);
        assertEquals(3, descendants.size());
        assertEquals(true, descendants.contains("3"));
        assertEquals(true, descendants.contains("4"));
        assertEquals(true, descendants.contains("7"));

        assertEquals(false, t.isFull());

        String[] emptyTree = {};
        ForestPlayGround emptyT = new ForestPlayGround(emptyTree);
        assertEquals(true, emptyT.isFull());

        String[] tree1 = {"A", "B", "C", null, null, "D", "E"};
        t = new ForestPlayGround(tree1);
        assertEquals(false, t.isComplete());

        String[] tree2 = {"A", "B", "C", "D"};
        t = new ForestPlayGround(tree2);
        assertEquals(true, t.isComplete());
        assertEquals(true, emptyT.isComplete());
    }

    public void testGetNumNodes02()
    {
        String[] tree = {};
        ForestPlayGround t = new ForestPlayGround(tree);
        assertEquals(0, t.getNumNodes());

        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        assertEquals(tree1.length, t1.getNumNodes());

        String[] tree2 = {"0", "1", null, null, "4", null, null, null, null, "9", "10", null, null, null};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        assertEquals(5, t2.getNumNodes());
    }

    public void testGetNumLeafs03()
    {
        String[] tree = {};
        ForestPlayGround t = new ForestPlayGround(tree);
        assertEquals(0, t.getNumLeafs());

        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        assertEquals(5, t1.getNumLeafs());

        String[] tree2 = {"0", "1", null, null, "4", null, null, null, null, "9", "10", null, null, null};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        assertEquals(2, t2.getNumLeafs());
    }

    public void testGetRightChild04()
    {
        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        assertEquals("10", t1.getRightChild(4));
        assertEquals("2", t1.getRightChild(0));

        String[] tree2 = {"0", "1", null, null, "4", null, null, null, null, "9", "10", null, null, null, null, null, null,
                null, null, "19", "20"};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        assertEquals(null, t2.getRightChild(0));
        assertEquals("4", t2.getRightChild(1));
        assertEquals("20", t2.getRightChild(9));
        assertEquals(null, t2.getRightChild(20));
    }

    public void testGetLeftChild05()
    {
        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        assertEquals("3", t1.getLeftChild(1));
        assertEquals("1", t1.getLeftChild(0));
        assertEquals("7", t1.getLeftChild(3));

        String[] tree2 = {"0", "1", null, null, "4", null, null, null, null, "9", "10", null, null, null, null, null, null,
                null, null, "19", "20", "21", null};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        assertEquals("1", t2.getLeftChild(0));
        assertEquals(null, t2.getLeftChild(1));
        assertEquals("19", t2.getLeftChild(9));
        assertEquals("21", t2.getLeftChild(10));
    }

    public void testGetEitherChild06()
    {
        testGetRightChild04();
        testGetLeftChild05();
    }

    public void testGetParent07()
    {
        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        assertEquals("0", t1.getParent(1));
        assertEquals(null, t1.getParent(0));
        assertEquals("2", t1.getParent(5));
        assertEquals("2", t1.getParent(6));
        assertEquals("4", t1.getParent(10));

        String[] tree2 = {"0", "1", null, null, "4", null, null, null, null, "9", "10", null, null, null, null, null, null,
                null, null, "19", "20", "21", null};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        assertEquals("1", t2.getParent(4));
        assertEquals("4", t2.getParent(9));
        assertEquals("9", t2.getParent(20));
        assertEquals("10", t2.getParent(21));
    }

    public void testGetAncestors08()
    {
        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        List<String> results = t1.getAncestors(6);
        assertEquals(2, results.size());
        assertEquals(true, results.contains("2"));
        assertEquals(true, results.contains("0"));

        results = t1.getAncestors(19);
        assertEquals(4, results.size());
        assertEquals(true, results.contains("9"));
        assertEquals(true, results.contains("4"));
        assertEquals(true, results.contains("1"));
        assertEquals(true, results.contains("0"));

        results = t1.getAncestors(41);
        assertEquals(5, results.size());
        assertEquals(true, results.contains("20"));
        assertEquals(true, results.contains("9"));
        assertEquals(true, results.contains("4"));
        assertEquals(true, results.contains("1"));
        assertEquals(true, results.contains("0"));

        String[] tree2 = {"0", "1", null, null, "4", null, null, null, null, "9", "10", null, null, null, null, null, null,
                null, null, "19", "20", "21", null};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        results = t2.getAncestors(10);
        assertEquals(3, results.size());
        assertEquals(true, results.contains("4"));
        assertEquals(true, results.contains("1"));
        assertEquals(true, results.contains("0"));
    }

    public void testGetDescendants09()
    {
        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        List<String> results = t1.getDescendants(20);
        assertEquals(1, results.size());
        assertEquals(true, results.contains("41"));

        results = t1.getDescendants(12);
        assertEquals(2, results.size());
        assertEquals(true, results.contains((2*12+1)+""));
        assertEquals(true, results.contains((2*12+2)+""));

        results = t1.getDescendants(2);
        assertEquals(14, results.size());
        assertEquals(true, results.contains("5"));
        assertEquals(true, results.contains("6"));
        assertEquals(true, results.contains("11"));
        assertEquals(true, results.contains("12"));
        assertEquals(true, results.contains("13"));
        assertEquals(true, results.contains("14"));
        assertEquals(true, results.contains("23"));
        assertEquals(true, results.contains("24"));
        assertEquals(true, results.contains("25"));
        assertEquals(true, results.contains("26"));
        assertEquals(true, results.contains("27"));
        assertEquals(true, results.contains("28"));
        assertEquals(true, results.contains("29"));
        assertEquals(true, results.contains("30"));

        String[] tree2 = {"0", "1", null, null, "4", null, null, null, null, "9", "10", null, null, null, null, null, null,
                null, null, "19", "20", "21", null};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        results = t2.getDescendants(1);
        assertEquals(6, results.size());
        assertEquals(true, results.contains("4"));
        assertEquals(true, results.contains("9"));
        assertEquals(true, results.contains("10"));
        assertEquals(true, results.contains("19"));
        assertEquals(true, results.contains("20"));
        assertEquals(true, results.contains("21"));

        t2 = new ForestPlayGround(tree2);
        results = t2.getDescendants(19);
        assertEquals(0, results.size());
    }

    public void testGetAncestorsAndGetDescendants10()
    {
        testGetAncestors08();
        testGetDescendants09();
    }

    /*
     *    A full binary tree is a tree in which every node in the tree has either 0 or 2 children.
     */
    public void testIsFull11()
    {
        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        assertEquals(false, t1.isFull());

        String[] tree2 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38"};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        assertEquals(true, t2.isFull());

        String[] tree3 = {"0", "1", "2", "3", "4", "5", "6", null, "8", "9", "10",
                "11", "12", "13", "14", null, null, "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                null, null, null, null, "35", "36", "37", "38"};
        ForestPlayGround t3 = new ForestPlayGround(tree3);
        assertEquals(false, t3.isFull());
        tree3[8] = null;
        tree3[17] = null;
        tree3[18] = null;
        tree3[35] = null;
        tree3[36] = null;
        tree3[37] = null;
        tree3[38] = null;
        assertEquals(true, t3.isFull());
        //      assertEquals(true, false);;
    }

    /*
     *    In a complete binary tree, every level, except possibly the last, is completely filled,
     *    and all nodes in the last level are as far left as possible.
     */
    public void testIsComplete12()
    {
        String[] tree1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41"};
        ForestPlayGround t1 = new ForestPlayGround(tree1);
        assertEquals(true, t1.isComplete());

        String[] tree2 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", null};
        ForestPlayGround t2 = new ForestPlayGround(tree2);
        assertEquals(true, t2.isComplete());

        String[] tree3 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                null, null, null, null, null, null, null, null, null, null, null};
        ForestPlayGround t3 = new ForestPlayGround(tree3);
        assertEquals(true, t3.isComplete());

        String[] tree4 = {"0", null, null, null, null, null, null, null, null, null, null, null};
        ForestPlayGround t4 = new ForestPlayGround(tree4);
        assertEquals(true, t4.isComplete());

        String[] tree5 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                null, "w", null, null, null, null, null, null, null, null, null};
        ForestPlayGround t5 = new ForestPlayGround(tree5);
        assertEquals(false, t5.isComplete());

        String[] tree6 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", null, "40", null};
        ForestPlayGround t6 = new ForestPlayGround(tree6);
        assertEquals(false, t6.isComplete());

        String[] tree7 = {"0", "1", null, "3", "4", "5", "6", "7", "8", "9", "10",
                "31", "32", "33", "34", "35", "36", "37", "38", "40", null};
        ForestPlayGround t7 = new ForestPlayGround(tree7);
        assertEquals(false, t7.isComplete());

        //      assertEquals(true, false);;
    }

    public void testIsFullAndIsComplete13()
    {
        testIsFull11();
        testIsComplete12();
    }

    public void testGetAncestorsAndGetDescendantsAndIsFullAndIsComplete14()
    {
        testGetAncestorsAndGetDescendants10();
        testIsFullAndIsComplete13();
    }

    public void test_All15()
    {
        testGetAncestorsAndGetDescendantsAndIsFullAndIsComplete14();
        testGetEitherChild06();
        testGetNumNodes02();
        testGetNumLeafs03();
        testGetParent07();
    }

    public void testFunctionsGoneWild2017_00()
    {
        assertEquals(35, FunctionsGoneWild2017.f1(11));
        assertEquals(-42, FunctionsGoneWild2017.f1(44));
        assertEquals(-429, FunctionsGoneWild2017.f1(389));
        assertEquals(-2275.8365, FunctionsGoneWild2017.f2(7), 0.05);
        assertEquals(24.6868, FunctionsGoneWild2017.f3(5., 3.2), 0.05);
        assertEquals(-5.8241, FunctionsGoneWild2017.f4(50.51, 86.7855),  0.000025);

        assertEquals(1.21058, FunctionsGoneWild2017.f5(1, 3, 8), 0.05);
        assertEquals(72.38373, FunctionsGoneWild2017.f5(2, 4, -1), 0.05);
        assertEquals(4+6+8+10+12+14, FunctionsGoneWild2017.f6(5, 2, 7));
        assertEquals("VPZQIYRT DVORMVR", FunctionsGoneWild2017.f7("COMPUTER SCIENCE") );
        assertEquals("NOGIC", FunctionsGoneWild2017.f8("ANALOGICAL", "AL") );
        assertEquals("COMUTSCINC", FunctionsGoneWild2017.f8("COMPUTER SCIENCE", "RE P") );
        assertEquals(true, FunctionsGoneWild2017.f9(false, false, false) );
        assertEquals(true, FunctionsGoneWild2017.f10(false, false, false, false) );
    }

    public void testFunctionsGoneWild2017_function01()
    {
        assertEquals(-21, FunctionsGoneWild2017.f1(3));
        assertEquals(321, FunctionsGoneWild2017.f1(22));

        assertEquals(-34, FunctionsGoneWild2017.f1(25));
        assertEquals(-10, FunctionsGoneWild2017.f1(77));
        assertEquals(120, FunctionsGoneWild2017.f1(117));
        assertEquals(254, FunctionsGoneWild2017.f1(149));

        assertEquals(-258, FunctionsGoneWild2017.f1(150));
        assertEquals(-8239, FunctionsGoneWild2017.f1(3072));
        assertEquals(-12, FunctionsGoneWild2017.f1(201));
        assertEquals(-3503, FunctionsGoneWild2017.f1(2913));
    }

    public void testFunctionsGoneWild2017_function02()
    {
        assertEquals(-37.877747, FunctionsGoneWild2017.f2(82), 0.05);
        assertEquals(-1649.63189, FunctionsGoneWild2017.f2(-18), 0.05);
        assertEquals(-15.8299049, FunctionsGoneWild2017.f2(11), 0.05);
        assertEquals(292.22167, FunctionsGoneWild2017.f2(34), 0.05);
        assertEquals(3098.47216, FunctionsGoneWild2017.f2(-48), 0.05);
        assertEquals(-27.201990, FunctionsGoneWild2017.f2(0), 0.05);
    }

    public void testFunctionsGoneWild2017_function03()
    {
        assertEquals(82.845, FunctionsGoneWild2017.f3(46.5, 30.3), 0.05);
        assertEquals(8.167333, FunctionsGoneWild2017.f3(69.2, 56.7), 0.05);
        assertEquals(-6.348, FunctionsGoneWild2017.f3(88.4, 76.3), 0.05);
        assertEquals(4.5401, FunctionsGoneWild2017.f3(27/2., 13/3.), 0.05);
        assertEquals(-11.55656, FunctionsGoneWild2017.f3(27/5., 13/3.), 0.05);
    }

    public void testFunctionsGoneWild2017_function04()
    {
        assertEquals(-22.808, FunctionsGoneWild2017.f4(84.0, -37), 0.05);
        assertEquals(-4.8558, FunctionsGoneWild2017.f4(71.1, 55.1), 0.05);
        assertEquals(-448.4120, FunctionsGoneWild2017.f4(17.2, 35.5), 0.05);
        assertEquals(2.4340, FunctionsGoneWild2017.f4(131/17., 201/37.), 0.05);
        assertEquals(70.3245, FunctionsGoneWild2017.f4(-26.5, 86.5), 0.05);
    }

    public void testFunctionsGoneWild2017_function05()
    {
        assertEquals(16.0345, FunctionsGoneWild2017.f5(60.7, -20.5, 12.7), 0.0005);  //  >
        assertEquals(0.0,     FunctionsGoneWild2017.f5(-78.6, 57.1, -50.14), 0.025);  //  <
        assertEquals(18.2583, FunctionsGoneWild2017.f5(-47.0, -46.8, 16.6), 0.025);   //  >
        assertEquals(52.7293, FunctionsGoneWild2017.f5(96.1, -45.0, -90.5), 0.025);   //  >
        assertEquals(635.190, FunctionsGoneWild2017.f5(1, 1, 1), 0.025);              //  ==
        assertEquals(51.4076,  FunctionsGoneWild2017.f5(1, 2, 0), 0.025);            //  <
    }

    public void testFunctionsGoneWild2017_function06()
    {
        //       for(int r = 0; r < 19; r++)
        //       {
        //          int h = (int)(200 * Math.random());
        //          int k = (int)(200 * Math.random());
        //          int m = (int)(200 * Math.random());
        //          System.out.println(h + " " + k + " " + m + " = " + FunctionsGoneWild2017.f6(h, k, m));
        //       }
        assertEquals(12, FunctionsGoneWild2017.f6(1, 2, 4));
        assertEquals(343, FunctionsGoneWild2017.f6(6, 7, 10));
        assertEquals(8400, FunctionsGoneWild2017.f6(10, 20, 99));
        assertEquals(1512, FunctionsGoneWild2017.f6(15, 7, 21));
        assertEquals(264, FunctionsGoneWild2017.f6(10, 6, 9));

        assertEquals(-3916, FunctionsGoneWild2017.f6(27, 13, 3));
        assertEquals(-70, FunctionsGoneWild2017.f6(27, 5, 13));
    }

    public void testFunctionsGoneWild2017_function07()
    {
        assertEquals("YJR", FunctionsGoneWild2017.f7("THE"));
        assertEquals("GOBR", FunctionsGoneWild2017.f7("FIVE"));
        assertEquals("NPCOMH", FunctionsGoneWild2017.f7("BOXING"));
        assertEquals("EOXSTFD", FunctionsGoneWild2017.f7("WIZARDS"));
        assertEquals("KIZQ WIOVLAU", FunctionsGoneWild2017.f7("JUMP QUICKLY"));
    }

    public void testFunctionsGoneWild2017_function08()
    {
        assertEquals("HMHMNNAPAA", FunctionsGoneWild2017.f8("HUMUHUMUNUKUNUKUAPUAA", "UK"));
        assertEquals("OR", FunctionsGoneWild2017.f8("ASSESSORESSES", "AES"));
        assertEquals("OXNG ARS", FunctionsGoneWild2017.f8("BOXING WIZARDS", "ZWIDB"));
        assertEquals("BKKP", FunctionsGoneWild2017.f8("BOOKKEEPER", "ERO"));
        assertEquals("BRI IENS UM", FunctionsGoneWild2017.f8("BRIGHT VIXENS JUMP", "TGVPHJX"));
        assertEquals("PAKMBOX", FunctionsGoneWild2017.f8("PACK MY BOX", "C Y"));
        assertEquals("UICK A IES", FunctionsGoneWild2017.f8("QUICK MAN FLIES", "QMNFL"));
        assertEquals("HOW VEXINGLY QUICK DAFT ZEBRAS JUMP", FunctionsGoneWild2017.f8("HOW VEXINGLY QUICK DAFT ZEBRAS JUMP", ""));
    }

    public void testFunctionsGoneWild2017_function09()
    {
        assertEquals(true, FunctionsGoneWild2017.f9(false, false, false) );
        assertEquals(false, FunctionsGoneWild2017.f9(false, false, true) );
        assertEquals(true, FunctionsGoneWild2017.f9(false, true, false) );
        assertEquals(false, FunctionsGoneWild2017.f9(false, true, true) );
        assertEquals(true, FunctionsGoneWild2017.f9(true, false, false) );
        assertEquals(false, FunctionsGoneWild2017.f9(true, false, true) );
        assertEquals(false, FunctionsGoneWild2017.f9(true, true, false) );
        assertEquals(true, FunctionsGoneWild2017.f9(true, true, true) );
    }

    public void testFunctionsGoneWild2017_function10()
    {
        assertEquals(true, FunctionsGoneWild2017.f10(false, false, false, false) );
        assertEquals(false, FunctionsGoneWild2017.f10(false, false, false, true) );
        assertEquals(true, FunctionsGoneWild2017.f10(false, false, true, false) );
        assertEquals(false, FunctionsGoneWild2017.f10(false, false, true, true) );
        assertEquals(false, FunctionsGoneWild2017.f10(false, true, false, false) );
        assertEquals(true, FunctionsGoneWild2017.f10(false, true, false, true) );
        assertEquals(false, FunctionsGoneWild2017.f10(false, true, true, false) );
        assertEquals(true, FunctionsGoneWild2017.f10(false, true, true, true) );
        assertEquals(true, FunctionsGoneWild2017.f10(true, false, false, false) );
        assertEquals(false, FunctionsGoneWild2017.f10(true, false, false, true) );
        assertEquals(false, FunctionsGoneWild2017.f10(true, false, true, false) );
        assertEquals(true, FunctionsGoneWild2017.f10(true, false, true, true) );
        assertEquals(false, FunctionsGoneWild2017.f10(true, true, false, false) );
        assertEquals(true, FunctionsGoneWild2017.f10(true, true, false, true) );
        assertEquals(false, FunctionsGoneWild2017.f10(true, true, true, false) );
        assertEquals(true, FunctionsGoneWild2017.f10(true, true, true, true) );
    }

    public void testFunctionsGoneWild2017_Bonusfunction01_03()
    {
        testFunctionsGoneWild2017_function01();
        testFunctionsGoneWild2017_function02();
        testFunctionsGoneWild2017_function03();
    }

    public void testFunctionsGoneWild2017_Bonusfunction04_06()
    {
        testFunctionsGoneWild2017_function04();
        testFunctionsGoneWild2017_function05();
        testFunctionsGoneWild2017_function06();
    }

    public void testFunctionsGoneWild2017_Bonusfunction07_08()
    {
        testFunctionsGoneWild2017_function07();
        testFunctionsGoneWild2017_function08();
    }

    public void testFunctionsGoneWild2017_Bonusfunction09_10()
    {
        testFunctionsGoneWild2017_function09();
        testFunctionsGoneWild2017_function10();
    }

    public void testFunctionsGoneWild2017_Bonus_All()
    {
        testFunctionsGoneWild2017_Bonusfunction01_03();
        testFunctionsGoneWild2017_Bonusfunction04_06();
        testFunctionsGoneWild2017_Bonusfunction07_08();
        testFunctionsGoneWild2017_Bonusfunction09_10();
    }

    public void testGuideMe01()
    {
        int[][] values = { { 1, 17, 19, 13},
                {41, 55,  3, 18},
                {29, 22, 23,  1},
                {31, 20, 17,  4} };
        GuideMe gm = new GuideMe(values);

        int cost = gm.getMinPathCost(new Position(0, 0), new Position(2, 1));
        assertEquals(85, cost);

        cost = gm.getMinPathCost(new Position(3, 0), new Position(2, 3));
        assertEquals(73, cost);

        int[][] values1 = { { 12, 26,  7,  31},
                {101,  8, 61,  44},
                { 18, 82, 13, 119},
                { 83,  3, 47, 251} };
        gm = new GuideMe(values1);

        List<Position> ans = gm.getSummationPath(new Position(0, 0), new Position(3, 3));
        assertEquals(9, ans.size());

        assertEquals(new Position(0, 0), ans.get(0));
        assertEquals(new Position(0, 1), ans.get(1));
        assertEquals(new Position(0, 2), ans.get(2));
        assertEquals(new Position(1, 2), ans.get(3));
        assertEquals(new Position(2, 2), ans.get(4));
        assertEquals(new Position(2, 1), ans.get(5));
        assertEquals(new Position(3, 1), ans.get(6));
        assertEquals(new Position(3, 2), ans.get(7));
        assertEquals(new Position(3, 3), ans.get(8));
    }

    public void testGuideMeMinPathCost02()
    {
        int[][] values = { { 21, 29,  9, 40, 12},
                { 31, 81, 43, 53, 86},
                { 12,  3, 63, 67, 68},
                { 19,  8, 41,  5, 16},
                { 62,  9, 30, 18,  7},
                { 17, 29,  0, 84,  3} };
        GuideMe gm = new GuideMe(values);

        int cost = gm.getMinPathCost(new Position(2, 2), new Position(5, 4));
        assertEquals(63+41+5+16+7+3, cost);

        cost = gm.getMinPathCost(new Position(4, 3), new Position(0, 1));
        assertEquals(18+30+9+8+3+12+31+21+29, cost);

    }

    public void testGuideMeMinPathCost03()
    {
        int[][] values = { { 21, 29,  9, 40, 12,  2, 11, 49},
                { 31, 81, 43, 53, 86, 37, 13, 76},
                { 12,  3, 63, 67, 68, 81,  2, 54},
                { 19,  8, 14,  5, 16,  9,  1, 38},
                { 62, 49, 30, 18, 27, 29,  7, 21},
                { 17, 91,  0, 84, 53,  4, 10, 63},
                {  7, 43, 50,  4, 83,  7, 61, 11},
                { 73, 46, 70,  8, 75, 47, 99, 38} };
        GuideMe gm = new GuideMe(values);

        int cost = gm.getMinPathCost(new Position(3, 1), new Position(1, 4));
        assertEquals(8+14+5+16+9+1+2+13+11+2+12+86, cost);

        cost = gm.getMinPathCost(new Position(6, 5), new Position(5, 5));
        assertEquals(7+4, cost);
    }

    public void testGuideMeMinPathCost04()  /*  copy of # 3 */
    {
        int[][] values = { {  0, 30, 79, 34, 20,  7, 61,  9},
                { 31,  0, 24, 63, 17, 21, 19, 13},
                { 12, 43,  0, 14, 10,  4,  5, 28},
                { 89, 14, 26,  0, 48, 30,  7, 60},
                { 16,  4, 37,  1,  0, 16, 18, 52},
                { 23, 11, 34, 27, 19,  0, 13,  1},
                { 18,  9, 17, 26, 41, 38,  0,  7},
                { 18,  7, 15, 14,  8,  9, 57,  0} };
        GuideMe gm = new GuideMe(values);

        int cost = gm.getMinPathCost(new Position(5, 6), new Position(4, 3));
        assertEquals(13+0+16+0+1, cost);

        cost = gm.getMinPathCost(new Position(6, 1), new Position(0, 5));
        assertEquals(9+11+4+37+1+0+14+10+4+21+7, cost);

        cost = gm.getMinPathCost(new Position(3, 5), new Position(7, 1));
        assertEquals(30+16+0+1+37+4+11+9+7, cost);
        //       assertEquals(30+16+0+13+0+38+9+8+14+15+7, cost);
    }

    public void testGuideMeSummationPath05()
    {
        int rc = (1+29+9+3+36+3+8+41);
        int[][] values = { {  1, 29,  9, 40, 12},
                { 31, 81,  3, 53, 86},
                { 12,  3, 36, 67, 68},
                { 19,  8, 41, rc, 16},
                { 62, 49, 30, 18,  7},
                { 17, 29,  0, 84,  3} };
        GuideMe gm = new GuideMe(values);

        ArrayList<Position> ans = gm.getSummationPath(new Position(0, 0), new Position(3, 3));
        assertEquals(9, ans.size());

        assertEquals(new Position(0, 0), ans.get(0));
        assertEquals(new Position(0, 1), ans.get(1));
        assertEquals(new Position(0, 2), ans.get(2));
        assertEquals(new Position(1, 2), ans.get(3));
        assertEquals(new Position(2, 2), ans.get(4));
        assertEquals(new Position(2, 1), ans.get(5));
        assertEquals(new Position(3, 1), ans.get(6));
        assertEquals(new Position(3, 2), ans.get(7));
        assertEquals(new Position(3, 3), ans.get(8));
    }

    public void testGuideMeSummationPath06()
    {
        int[][] values = { { 21, 29,  9, 12},
                { 31, 81, -1, 86},
                { 12, 63, 67, 68},
                { 24,  9, 18,  7},
                { 17, 29, 20,  3} };
        GuideMe gm = new GuideMe(values);
        ArrayList<Position> ans = gm.getSummationPath(new Position(3, 3), new Position(1, 2));
        assertEquals(null, ans);

        values[1][2] = (7+68+86+12+9);
        gm = new GuideMe(values);
        ans = gm.getSummationPath(new Position(3, 3), new Position(1, 2));
        assertEquals(6, ans.size());

        assertEquals(new Position(3, 3), ans.get(0));
        assertEquals(new Position(2, 3), ans.get(1));
        assertEquals(new Position(1, 3), ans.get(2));
        assertEquals(new Position(0, 3), ans.get(3));
        assertEquals(new Position(0, 2), ans.get(4));
        assertEquals(new Position(1, 2), ans.get(5));
    }

    public void testGuideMeSummationPath07() 
    {
        int rc = 8+29;
        int[][] values = { { 21, 71,  9, 12},
                { 31, 81, 75, 68},
                { 19,  8, 156,  7},
                { 17, 29, 37,  3} };
        GuideMe gm = new GuideMe(values);

        ArrayList<Position> ans = gm.getSummationPath(new Position(2, 1), new Position(3, 2));
        assertEquals(3, ans.size());

        assertEquals(new Position(2, 1), ans.get(0));
        assertEquals(new Position(3, 1), ans.get(1));
        assertEquals(new Position(3, 2), ans.get(2));

        ans = gm.getSummationPath(new Position(2, 3), new Position(1, 2));
        assertEquals(3, ans.size());

        assertEquals(new Position(2, 3), ans.get(0));
        assertEquals(new Position(1, 3), ans.get(1));
        assertEquals(new Position(1, 2), ans.get(2));

        ans = gm.getSummationPath(new Position(2, 0), new Position(0, 1));
        assertEquals(4, ans.size());

        assertEquals(new Position(2, 0), ans.get(0));
        assertEquals(new Position(1, 0), ans.get(1));
        assertEquals(new Position(0, 0), ans.get(2));
        assertEquals(new Position(0, 1), ans.get(3));

        ans = gm.getSummationPath(new Position(1, 1), new Position(2, 2));
        assertEquals(3, ans.size());

        assertEquals(new Position(1, 1), ans.get(0));
        assertEquals(new Position(1, 2), ans.get(1));
        assertEquals(new Position(2, 2), ans.get(2));
    }

    public void testGuideMeMinPathAndSummationPath08()
    {
        testGuideMeMinPathCost02();
        testGuideMeSummationPath05();
    }

    public void testGuideMeMinPathAndSummationPath09()
    {
        testGuideMeMinPathCost03();
        testGuideMeSummationPath06();
    }

    public void testGuideMeMinPathAndSummationPath10()
    {
        testGuideMeMinPathCost04();
        testGuideMeSummationPath07();
    }

    public void testBabyNames01()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("JAMES", "MARY");
        assertEquals(5, ans.size());

        assertEquals("JAMARY", ans.get(0));
        assertEquals("JAMERY", ans.get(1));
        assertEquals("JAMEY", ans.get(2));
        assertEquals("JARY", ans.get(3));
        assertEquals("JAY", ans.get(4));

        ans = bn.getBabyNames("MARY", "JAMES");
        assertEquals(5, ans.size());
        assertEquals("MAMES", ans.get(0));
        assertEquals("MARAMES", ans.get(1));
        assertEquals("MARES", ans.get(2));
        assertEquals("MAS", ans.get(3));
        assertEquals("MES", ans.get(4));

        ans = bn.getBabyNames("ABE", "JO");
        assertEquals(1, ans.size());
        assertEquals("ABO", ans.get(0));

        ans = bn.getBabyNames("JO", "ABE");
        assertEquals(1, ans.size());
        assertEquals("JE", ans.get(0));
    }

    public void testBabyNames02MASON_SOPHIA()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("MASON", "SOPHIA");
        String[] names1 = {"MASOPHIA", "MASOHIA", "MAPHIA", "MAHIA", "MASIA", "MASA",
                "MOPHIA", "MIA", "MA"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

        ans = bn.getBabyNames("SOPHIA", "MASON");
        String[] names2 = {"SOPHISON", "SOPHIN", "SOSON", "SON", "SOPHASON", "SOPHON", "SOPASON",
                "SOPON", "SASON"};
        Arrays.sort(names2);
        assertEquals(names2.length, ans.size());

        for (int k = 0; k < names2.length; k++)
            assertEquals(names2[k], ans.get(k));
    }

    public void testBabyNames03ROBIN_ROBIN()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("ROBIN", "ROBIN");
        String[] names1 = {"ROBIBIN", "ROBIN", "RON", "ROBOBIN", "RIN"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

    }

    public void testBabyNames04JACKSON_SCARLETT()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("JACKSON", "SCARLETT");
        String[] names1 = {"JACKSARLETT", "JACKSETT", "JACKETT", "JACKARLETT",
                "JACETT", "JARLETT", "JETT",
                "JACKSOCARLETT", "JACKSORLETT", "JACKSOLETT", "JACKSOTT", "JACKSOT",
                "JACARLETT", "JALETT", "JATT", "JAT"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

        ans = bn.getBabyNames("SCARLETT", "JACKSON");
        String[] names2 = {"SCARLETACKSON", "SCARLACKSON", "SCARACKSON", "SCACKSON", "SACKSON",
                "SCARLETON", "SCARLON", "SCARON", "SCON", "SON",
                "SCARLECKSON", "SCARLEKSON", "SCARLESON", "SCARLEN",
                "SCAKSON", "SCASON", "SCAN"};
        Arrays.sort(names2);
        assertEquals(names2.length, ans.size());

        for (int k = 0; k < names2.length; k++)
            assertEquals(names2[k], ans.get(k));
    }

    public void testBabyNames05ELI_ELLA()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("ELI", "ELLA");
        String[] names1 = {"ELA", "ELLA"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

        ans = bn.getBabyNames("ELLA", "ELI");

        String[] names2 = {"ELLI", "ELI"};
        Arrays.sort(names2);
        assertEquals(names2.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names2[k], ans.get(k));
    }

    public void testBabyNames06TOM_MIA()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("TOM", "MIA");

        String[] names1 = {"TIA", "TA"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

        ans = bn.getBabyNames("MIA", "TOM");

        String[] names2 = {"MIM", "MOM"};
        Arrays.sort(names2);

        assertEquals(names2.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names2[k], ans.get(k));
    }

    /*

    System.out.println("ans = " + ans);
    System.out.print("nam = ");
    for (String s : names2) System.out.print(s + " ");

     */

    public void testBabyNames07FLYNN_DAPHNE()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("FLYNN", "DAPHNE");

        String[] names1 = {"FLYNAPHNE", "FLYNE", "FLYAPHNE", "FLYE", "FLAPHNE", "FLE", "FAPHNE", "FE"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

        ans = bn.getBabyNames("DAPHNE", "FLYNN");

        String[] names2 = {"DALYNN", "DAYNN", "DANN", "DAN"};
        Arrays.sort(names2);
        assertEquals(names2.length, ans.size());

        for (int k = 0; k < names2.length; k++)
            assertEquals(names2[k], ans.get(k));
    }

    public void testBabyNames08KATO_AZIZI()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("KATO", "AZIZI");

        String[] names1 = {"KATIZI", "KATI", "KIZI", "KAZIZI", "KAZI", "KI"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

        ans = bn.getBabyNames("AZIZI", "KATO");

        String[] names2 = {"AZIZATO", "AZIZO", "AZATO", "AZO", "AZITO", "ATO"};
        Arrays.sort(names2);
        assertEquals(names2.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names2[k], ans.get(k));
    }

    public void testBabyNames09REMUS_MERIALL()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("REMUS", "MERIALL");

        String[] names1 = {"REMURIALL", "REMULL", "REMUL", "RERIALL", "RELL", "REL",
                "REMERIALL", "REMIALL", "REMALL", "RIALL", "RALL"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

        ans = bn.getBabyNames("MERIALL", "REMUS");

        String[] names2 = {"MERIALEMUS", "MERIALUS", "MEREMUS", "MERUS", "MEMUS", "MUS", 
                "MERIAMUS", "MERIAS", "MERIMUS", "MERIS", "MES"};
        Arrays.sort(names2);
        assertEquals(names2.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names2[k], ans.get(k));
    }

    public void testBabyNames10MAXIMILIAN_ARA()
    {
        BabyNames bn = new BabyNames();

        List<String> ans = bn.getBabyNames("MAXIMILIAN", "ARA");

        String[] names1 = {"MAXIMILIARA", "MAXIMILIRA", "MAXIMIRA", "MAXIRA", "MARA",
                "MAXIMILA", "MAXIMA", "MAXA", "MA"};
        Arrays.sort(names1);
        assertEquals(names1.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names1[k], ans.get(k));

        ans = bn.getBabyNames("ARA", "MAXIMILIAN");

        String[] names2 = {"ARAXIMILIAN", "ARIMILIAN", "ARILIAN", "ARIAN", "ARAN",
                "AXIMILIAN", "AMILIAN", "ALIAN", "AN"};
        Arrays.sort(names2);
        assertEquals(names2.length, ans.size());

        for (int k = 0; k < names1.length; k++)
            assertEquals(names2[k], ans.get(k));
    }

    public void testDevilNumber01()
   {
      assertEquals(false, DevilNumbers.isDevilNumber(2));
      assertEquals(false, DevilNumbers.isDevilNumber(4305));
      assertEquals(false, DevilNumbers.isDevilNumber(714));
      assertEquals(false, DevilNumbers.isDevilNumber(471));
      assertEquals(false, DevilNumbers.isDevilNumber(18047));
      assertEquals(false, DevilNumbers.isDevilNumber(52370));

      assertEquals(true, DevilNumbers.isDevilNumber(76));
      assertEquals(true, DevilNumbers.isDevilNumber(472));
      assertEquals(true, DevilNumbers.isDevilNumber(111111));
      assertEquals(true, DevilNumbers.isDevilNumber(207060));
      assertEquals(true, DevilNumbers.isDevilNumber(273021));
      assertEquals(true, DevilNumbers.isDevilNumber(7152021));

      assertEquals(false, DevilNumbers.isTrueDevilNumber(472));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(76));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(720310));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(43027));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(10471));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(52370));

      assertEquals(true, DevilNumbers.isTrueDevilNumber(452));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(643));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(111111));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(20060));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(213021));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(9152021));

      assertEquals(-1, DevilNumbers.getLargestDevilNumber(5));
      assertEquals(720310, DevilNumbers.getLargestDevilNumber(720310));
      assertEquals(43093, DevilNumbers.getLargestDevilNumber(43095));
      assertEquals(1036, DevilNumbers.getLargestDevilNumber(1040));

      assertEquals(-1, DevilNumbers.getLargestTrueDevilNumber(4));
      assertEquals(111106, DevilNumbers.getLargestTrueDevilNumber(111110));
      assertEquals(6999, DevilNumbers.getLargestTrueDevilNumber(7060));
      assertEquals(216999, DevilNumbers.getLargestTrueDevilNumber(217819));
   }

   public void testIsDevilNumber02()
   {
      assertEquals(false, DevilNumbers.isDevilNumber(2530));
      assertEquals(false, DevilNumbers.isDevilNumber(85053));
      assertEquals(false, DevilNumbers.isDevilNumber(13947));
      assertEquals(false, DevilNumbers.isDevilNumber(52370));

      assertEquals(true, DevilNumbers.isDevilNumber(2349));
      assertEquals(true, DevilNumbers.isDevilNumber(18950));
      assertEquals(true, DevilNumbers.isDevilNumber(2403));
      assertEquals(true, DevilNumbers.isDevilNumber(3513));
   }

   public void testIsDevilNumber03()
   {
      assertEquals(true, DevilNumbers.isDevilNumber(11111100));
      assertEquals(true, DevilNumbers.isDevilNumber(12021));
      assertEquals(true, DevilNumbers.isDevilNumber(130171));
      assertEquals(true, DevilNumbers.isDevilNumber(181211));
      assertEquals(true, DevilNumbers.isDevilNumber(212701));
      assertEquals(true, DevilNumbers.isDevilNumber(137101));
      assertEquals(true, DevilNumbers.isDevilNumber(739201));

      assertEquals(false, DevilNumbers.isDevilNumber(1111100));
      assertEquals(false, DevilNumbers.isDevilNumber(180111));
      assertEquals(false, DevilNumbers.isDevilNumber(207050));
      assertEquals(false, DevilNumbers.isDevilNumber(27));
      assertEquals(false, DevilNumbers.isDevilNumber(71021));
   }

   public void testIsTrueDevilNumber04()
   {
      assertEquals(false, DevilNumbers.isTrueDevilNumber(10228));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(102725));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(572121));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(5230));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(5));

      assertEquals(true, DevilNumbers.isTrueDevilNumber(10205));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(103102));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(213021));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(912021));
   }

   public void testIsTrueDevilNumber05()
   {
      assertEquals(true, DevilNumbers.isTrueDevilNumber(666));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(1302));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(1041));
      assertEquals(true, DevilNumbers.isTrueDevilNumber(52301));

      assertEquals(false, DevilNumbers.isTrueDevilNumber(76667));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(13072));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(888));
      assertEquals(false, DevilNumbers.isTrueDevilNumber(5));
   }

   public void testGetLargestDevilNumber06()
   {
      assertEquals(7776, DevilNumbers.getLargestDevilNumber(7777));
      assertEquals(-1, DevilNumbers.getLargestDevilNumber(5));
      assertEquals(66, DevilNumbers.getLargestDevilNumber(66));
   }

   public void testGetLargestDevilNumber07()
   {
      assertEquals(69, DevilNumbers.getLargestDevilNumber(75));
      assertEquals(6, DevilNumbers.getLargestDevilNumber(7));
      assertEquals(-1, DevilNumbers.getLargestDevilNumber(5));
      assertEquals(55551, DevilNumbers.getLargestDevilNumber(55555));
   }

   public void testGetLargestTrueDevilNumber08()
   {
      assertEquals(6999, DevilNumbers.getLargestTrueDevilNumber(7777));
      assertEquals(169999, DevilNumbers.getLargestTrueDevilNumber(171111));
      assertEquals(-1, DevilNumbers.getLargestTrueDevilNumber(2));
      assertEquals(6, DevilNumbers.getLargestTrueDevilNumber(14));
   }

   public void testGetLargestTrueDevilNumber09()
   {
      assertEquals(999996, DevilNumbers.getLargestTrueDevilNumber(999999));
      assertEquals(8699, DevilNumbers.getLargestTrueDevilNumber(8777));
      assertEquals(-1, DevilNumbers.getLargestTrueDevilNumber(5));
   }

   public void testAll10()
   {
      testDevilNumber01();
      testIsDevilNumber02();
      testIsDevilNumber03();
      testIsTrueDevilNumber04();
      testIsTrueDevilNumber05();
      testGetLargestDevilNumber06();
      testGetLargestDevilNumber07();
      testGetLargestTrueDevilNumber08();
      testGetLargestTrueDevilNumber09();
   }
}