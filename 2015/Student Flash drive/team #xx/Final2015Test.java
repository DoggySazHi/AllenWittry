import java.util.*;

/**
 * The test class Final2015Test.
 *
 * @author  Don Allen
 * @version 2015 Final Witry tester
 */
public class Final2015Test  extends junit.framework.TestCase
{
   public void testStringSimilarity01()
   {
      List<String> union = StringSimilarity.stringUnion("ABC", "CDE");
      assertEquals(5, union.size());
      assertEquals(true, union.contains("A"));
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("C"));
      assertEquals(true, union.contains("D"));
      assertEquals(true, union.contains("E"));

      List<String> intersection = StringSimilarity.stringIntersection("ABC", "CDE");
      assertEquals(1, intersection.size());
      assertEquals(false, intersection.contains("A"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(true, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));
      
      assertEquals(1. / 5.0, StringSimilarity.getJaccardIndex("ABC", "CDE"), 0.005);
      assertEquals(4. / (1+2+1+3+1), StringSimilarity.getJaccardIndex("ABBCDD", "BCDDDE"), 0.005);

      union = StringSimilarity.stringUnion("AB", "ab");
      assertEquals(4, union.size());
      assertEquals(true, union.contains("A"));
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("a"));
      assertEquals(true, union.contains("b"));

      intersection = StringSimilarity.stringIntersection("ABc", "abc");
      assertEquals(1, intersection.size());
      assertEquals(true, intersection.contains("c"));
   }

   public void testStringUnion02()
   {
      List<String> union = StringSimilarity.stringUnion("ABC", "DEFG");
      assertEquals(7, union.size());
      assertEquals(true, union.contains("A"));
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("C"));
      assertEquals(true, union.contains("D"));
      assertEquals(true, union.contains("E"));

      union = StringSimilarity.stringUnion("ABC", "ABC");
      assertEquals(3, union.size());
      assertEquals(true, union.contains("A"));
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("C"));
      assertEquals(false, union.contains("D"));
      assertEquals(false, union.contains("E"));
   }

   public void testStringUnionWithDuplicateLetters03()
   {
      List<String> union = StringSimilarity.stringUnion("ABCA", "BC");
      assertEquals(4, union.size());
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(true, union.contains("A"));
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("C"));
      assertEquals(false, union.contains("D"));
      assertEquals(false, union.contains("E"));

      union = StringSimilarity.stringUnion("AA", "BABC");
      assertEquals(5, union.size());
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(true, union.contains("A"));
      assertEquals(true, union.contains("B"));
      union.remove("B");
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("C"));
      assertEquals(false, union.contains("D"));
      assertEquals(false, union.contains("E"));
   }

   public void testJaccardIndex04()
   {
      assertEquals(0.0, StringSimilarity.getJaccardIndex("ABC", "DEFG"), 0.005);

      assertEquals(3. / 3.0, StringSimilarity.getJaccardIndex("ABC", "ABC"), 0.005);
   }

   public void testJaccardIndexWithDuplicates05()
   {
      assertEquals(2. / 4.0, StringSimilarity.getJaccardIndex("ABCA", "BC"), 0.005);

      assertEquals(1. / 5.0, StringSimilarity.getJaccardIndex("AA", "BABC"), 0.005);

      assertEquals( (1.+2+1+1) / (2+2+3+3+3), StringSimilarity.getJaccardIndex("AABBCCCD", "BABCDDDEEE"), 0.005);
   }

   public void testStringIntersection06()
   {
      List<String> intersection = StringSimilarity.stringIntersection("ABC", "DEFG");
      assertEquals(0, intersection.size());
      assertEquals(false, intersection.contains("A"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(false, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));

      intersection = StringSimilarity.stringIntersection("ABC", "ABC");
      assertEquals(3, intersection.size());
      assertEquals(true, intersection.contains("A"));
      assertEquals(true, intersection.contains("B"));
      assertEquals(true, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));
   }

   public void testStringIntersectionWithDuplicateLetters07()
   {
      List<String> intersection = StringSimilarity.stringIntersection("ABCA", "BC");
      assertEquals(2, intersection.size());
      assertEquals(false, intersection.contains("A"));
      assertEquals(true, intersection.contains("B"));
      assertEquals(true, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));

      intersection = StringSimilarity.stringIntersection("AA", "BABAC");
      assertEquals(2, intersection.size());
      assertEquals(true, intersection.contains("A"));
      intersection.remove("A");
      assertEquals(true, intersection.contains("A"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(false, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));
   }

   public void testStringUnionIntersection08()
   {
      testStringUnion02();
      testStringIntersection06();
      
      List<String> intersection = StringSimilarity.stringIntersection("ABCDEFGHIJK", "DEFG");
      assertEquals(4, intersection.size());
      assertEquals(false, intersection.contains("A"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(false, intersection.contains("C"));
      assertEquals(true, intersection.contains("D"));
      assertEquals(true, intersection.contains("E"));
      assertEquals(true, intersection.contains("F"));
      assertEquals(true, intersection.contains("G"));
      assertEquals(false, intersection.contains("I"));
      assertEquals(false, intersection.contains("J"));
      assertEquals(false, intersection.contains("K"));
      
      List<String> union = StringSimilarity.stringUnion("ABCDEFGHIJK", "DEFG");
      assertEquals("ABCDEFGHIJK".length(), union.size());
      assertEquals(true, union.contains("A"));
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("C"));
      assertEquals(true, union.contains("D"));
      assertEquals(true, union.contains("E"));
      assertEquals(true, union.contains("F"));
      assertEquals(true, union.contains("G"));
      assertEquals(true, union.contains("I"));
      assertEquals(true, union.contains("J"));
      assertEquals(true, union.contains("K"));

      intersection = StringSimilarity.stringIntersection("EDCBA", "TRPEFD");
      assertEquals(2, intersection.size());
      assertEquals(false, intersection.contains("A"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(false, intersection.contains("C"));
      assertEquals(true, intersection.contains("D"));
      assertEquals(true, intersection.contains("E"));
      assertEquals(false, intersection.contains("T"));
      assertEquals(false, intersection.contains("R"));
      assertEquals(false, intersection.contains("P"));
      assertEquals(false, intersection.contains("F"));

      union = StringSimilarity.stringUnion("EDCBA", "TRPEFD");
      assertEquals("EDCBATRPF".length(), union.size());
      assertEquals(true, union.contains("A"));
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("C"));
      assertEquals(true, union.contains("D"));
      assertEquals(true, union.contains("E"));
      assertEquals(true, union.contains("T"));
      assertEquals(true, union.contains("R"));
      assertEquals(true, union.contains("P"));
      assertEquals(true, union.contains("F"));
   }

   public void testStringIntersectionWithDuplicateLetters09()
   {
      testStringUnionWithDuplicateLetters03();
      testStringIntersectionWithDuplicateLetters07();

      List<String> intersection = StringSimilarity.stringIntersection("DCCECAAAD", "GBCFBBABG");
      assertEquals("AC".length(), intersection.size());
      assertEquals(true, intersection.contains("A"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(true, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));

      intersection = StringSimilarity.stringIntersection("CBABACBABA", "BABAC");
      assertEquals("CBABA".length(), intersection.size());
      assertEquals(true, intersection.contains("A"));
      intersection.remove("A");
      assertEquals(true, intersection.contains("A"));
      assertEquals(true, intersection.contains("B"));
      intersection.remove("B");
      assertEquals(true, intersection.contains("B"));
      assertEquals(true, intersection.contains("C"));
      intersection.remove("C");
      assertEquals(false, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));

      List<String> union = StringSimilarity.stringUnion("DCCECAAAD", "GBCFBBABG");
      assertEquals("AAABBBBCCCDDEFGG".length(), union.size());
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(false, union.contains("A"));
      assertEquals(true, union.contains("B"));
      union.remove("B");
      assertEquals(true, union.contains("B"));
      union.remove("B");
      assertEquals(true, union.contains("B"));
      union.remove("B");
      assertEquals(true, union.contains("B"));
      assertEquals(true, union.contains("C"));
      assertEquals(true, union.contains("D"));
      assertEquals(true, union.contains("E"));
      assertEquals(true, union.contains("F"));
      assertEquals(true, union.contains("G"));

      union = StringSimilarity.stringUnion("BABAC", "CBABACBABA");
      assertEquals("CBABACBABA".length(), union.size());
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(false, union.contains("A"));

      assertEquals(true, union.contains("B"));
      union.remove("B");
      assertEquals(true, union.contains("B"));
      union.remove("B");
      assertEquals(true, union.contains("B"));
      union.remove("B");
      assertEquals(true, union.contains("B"));
      union.remove("B");
      assertEquals(false, union.contains("B"));

      assertEquals(true, union.contains("C"));
      union.remove("C");
      assertEquals(true, union.contains("C"));
      union.remove("C");
      assertEquals(false, union.contains("C"));
      assertEquals(false, union.contains("D"));
      assertEquals(false, union.contains("E"));
   }

   public void testAllWithDuplicateLetter10()
   {
      testStringUnionIntersection08();
      testStringIntersectionWithDuplicateLetters09();

      List<String> intersection = StringSimilarity.stringIntersection("", "GBCFBBABG");
      assertEquals("".length(), intersection.size());
      assertEquals(false, intersection.contains("A"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(false, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));
      assertEquals(0.0, StringSimilarity.getJaccardIndex("", "GBCFBBABG"), 0.005);

      intersection = StringSimilarity.stringIntersection("CBABACBABA", "ZYWX");
      assertEquals("".length(), intersection.size());
      assertEquals(false, intersection.contains("A"));
      assertEquals(false, intersection.contains("B"));
      assertEquals(false, intersection.contains("C"));
      assertEquals(false, intersection.contains("D"));
      assertEquals(false, intersection.contains("E"));
      assertEquals(false, intersection.contains("Z"));
      assertEquals(false, intersection.contains("Y"));
      assertEquals(false, intersection.contains("W"));
      assertEquals(false, intersection.contains("X"));
      assertEquals(0.0, StringSimilarity.getJaccardIndex("", "GBCFBBABG"), 0.005);

      intersection = StringSimilarity.stringIntersection("", "");
      assertEquals("".length(), intersection.size());
      List<String> union = StringSimilarity.stringUnion("", "");
      assertEquals("".length(), union.size());
      assertEquals(false, union.contains("A"));
      assertEquals(false, union.contains("S"));
      assertEquals(false, union.contains("C"));
      assertEquals(false, union.contains("D"));
      assertEquals(false, union.contains("E"));
      assertEquals(false, union.contains("F"));
      assertEquals(1.0, StringSimilarity.getJaccardIndex("", ""), 0.005);

      intersection = StringSimilarity.stringIntersection("ZZ", "");
      assertEquals("".length(), intersection.size());
      intersection = StringSimilarity.stringIntersection("", "AA");
      assertEquals("".length(), intersection.size());
      union = StringSimilarity.stringUnion("", "AA");
      assertEquals("AA".length(), union.size());
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(true, union.contains("A"));
      union.remove("A");
      assertEquals(false, union.contains("A"));
      assertEquals(0.0, StringSimilarity.getJaccardIndex("", "AA"), 0.005);

      union = StringSimilarity.stringUnion("CFG", "GBCFBBABG");
      assertEquals(true, union.contains("C"));
      assertEquals(true, union.contains("F"));
      assertEquals(true, union.contains("G"));
      assertEquals(true, union.contains("B"));
      assertEquals(3. / "GBCFBBABG".length(), StringSimilarity.getJaccardIndex("CFG", "GBCFBBABG"), 0.005);
   }
    private final String quad = "Quadrilateral";
    private final String parallelogram = "Parallelogram";
    private final String rectangle = "Rectangle";
    private final String rhombus = "Rhombus";
    private final String square = "Square";

    public void testQuadrilaterals01()
    {
        Quadrilaterals quads = new Quadrilaterals();
        List<Coordinate> vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(0, 0));
        vert.add(new Coordinate(1, 10));
        vert.add(new Coordinate(13, 5));
        vert.add(new Coordinate(5, -1));
        assertEquals(quad, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(0, 0));
        vert.add(new Coordinate(5, 5));
        vert.add(new Coordinate(18, 5));
        assertEquals(new Coordinate(13, 0), quads.findFourthPointofParallelogram(vert));
    }

    public void testIsQuad02()
    {
        Quadrilaterals quads = new Quadrilaterals();

        List<Coordinate> vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(2, 5));
        vert.add(new Coordinate(2, 8));
        vert.add(new Coordinate(8, 9));
        vert.add(new Coordinate(6, 5));
        assertEquals(quad, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(0, 0));
        vert.add(new Coordinate(0, 5));
        vert.add(new Coordinate(10, 5));
        vert.add(new Coordinate(6, 0));
        assertEquals(quad, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(-4, -4));
        vert.add(new Coordinate(-5, 0));
        vert.add(new Coordinate(7, 3));
        vert.add(new Coordinate(4, -2));
        assertEquals(quad, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(5, -3));
        vert.add(new Coordinate(-4, 0));
        vert.add(new Coordinate(-5, 7));
        vert.add(new Coordinate(2, 6));
        assertEquals(quad, quads.identifyQuadrilateral(vert));
    }

    public void testIsParallelogram03()
    {
        Quadrilaterals quads = new Quadrilaterals();
        List<Coordinate> vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(-5, 6));
        vert.add(new Coordinate(-3, 9));
        vert.add(new Coordinate(4, 1));
        vert.add(new Coordinate(2, -2));
        assertEquals(parallelogram, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(0, 0));
        vert.add(new Coordinate(3, 4));
        vert.add(new Coordinate(8, 4));
        assertEquals(new Coordinate(5, 0), quads.findFourthPointofParallelogram(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(-3, 2));
        vert.add(new Coordinate(-2, 6));
        vert.add(new Coordinate(2, 8));
        vert.add(new Coordinate(1, 4));
        assertEquals(parallelogram, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(5, -3));
        vert.add(new Coordinate(-4, 0));
        vert.add(new Coordinate(-5, 7));
        assertEquals(new Coordinate(4, 4), quads.findFourthPointofParallelogram(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(3, 5));
        vert.add(new Coordinate(1, 1));
        vert.add(new Coordinate(-3, 0));
        vert.add(new Coordinate(-1, 4));
        assertEquals(parallelogram, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(-1, 1));
        vert.add(new Coordinate(-3, 4));
        vert.add(new Coordinate(-5, 1));
        assertEquals(new Coordinate(-3, -2), quads.findFourthPointofParallelogram(vert));
    }

    public void testIsRectangle04()
    {
        Quadrilaterals quads = new Quadrilaterals();
        List<Coordinate> vert = new ArrayList<Coordinate>();

        vert.add(new Coordinate(-4, -4));
        vert.add(new Coordinate(-5, 0));
        vert.add(new Coordinate(3, 2));
        vert.add(new Coordinate(4, -2));
        assertEquals(rectangle, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(0, 0));
        vert.add(new Coordinate(2, 2));
        vert.add(new Coordinate(7, -3));
        assertEquals(new Coordinate(5, -5), quads.findFourthPointofParallelogram(vert));

        vert = new ArrayList<Coordinate>();

        vert.add(new Coordinate(2, 7));
        vert.add(new Coordinate(2, 0));
        vert.add(new Coordinate(-1, 0));
        vert.add(new Coordinate(-1, 7));
        assertEquals(rectangle, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(13, -7));
        vert.add(new Coordinate(13, 21));
        vert.add(new Coordinate(0, 21));
        assertEquals(new Coordinate(0, -7), quads.findFourthPointofParallelogram(vert));
    }

    public void testIsRhombus05()
    {
        Quadrilaterals quads = new Quadrilaterals();
        List<Coordinate> vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(0, 0));
        vert.add(new Coordinate(3, 4));
        vert.add(new Coordinate(8, 4));
        vert.add(new Coordinate(5, 0));
        assertEquals(rhombus, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(-10, -10));
        vert.add(new Coordinate(-7, -6));
        vert.add(new Coordinate(-2, -6));
        assertEquals(new Coordinate(-5, -10), quads.findFourthPointofParallelogram(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(-3, 2));
        vert.add(new Coordinate(-2, 6));
        vert.add(new Coordinate(2, 7));
        vert.add(new Coordinate(1, 3));
        assertEquals(rhombus, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(2, 7));
        vert.add(new Coordinate(14, 42));
        vert.add(new Coordinate(49, 30));
        assertEquals(new Coordinate(37, -5), quads.findFourthPointofParallelogram(vert));
    }

    public void testIsSquare06()
    {
        Quadrilaterals quads = new Quadrilaterals();

        List<Coordinate> vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(0, 0));
        vert.add(new Coordinate(1, 0));
        vert.add(new Coordinate(1, 1));
        vert.add(new Coordinate(0, 1));
        assertEquals(square, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(-10, -10));
        vert.add(new Coordinate(-10, 10));
        vert.add(new Coordinate(10, 10));
        assertEquals(new Coordinate(10, -10), quads.findFourthPointofParallelogram(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(1, 6));
        vert.add(new Coordinate(6, 3));
        vert.add(new Coordinate(3, -2));
        vert.add(new Coordinate(-2, 1));
        assertEquals(square, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(3, -2));
        vert.add(new Coordinate(-2, 1));
        vert.add(new Coordinate(-5, -4));
        assertEquals(new Coordinate(0, -7), quads.findFourthPointofParallelogram(vert));


        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(-7, -9));
        vert.add(new Coordinate(21, 36));
        vert.add(new Coordinate(66, 8));
        vert.add(new Coordinate(38, -37));
        assertEquals(square, quads.identifyQuadrilateral(vert));

        vert = new ArrayList<Coordinate>();
        vert.add(new Coordinate(6, -63));
        vert.add(new Coordinate(69, -47));
        vert.add(new Coordinate(53, 16));
        assertEquals(new Coordinate(-10, 0), quads.findFourthPointofParallelogram(vert));
    }

    public void testIsQuadAndIsParallelogram07()
    {
        testIsQuad02();
        testIsParallelogram03();
    }

    public void testIsRectangleAndIsSquare08()
    {
        testIsRectangle04();
        testIsSquare06();
    }

    public void testIsRhombusAndIsSquare09()
    {
        testIsRhombus05();
        testIsSquare06();
    }

    public void testAll10()
    {
        testIsQuad02();
        testIsParallelogram03();
        testIsRectangle04();
        testIsRhombus05();
        testIsSquare06();
    }
   public void testFunWith2DArrays00()
   {
      FunWith2DArrays ma = new FunWith2DArrays();
      int[][] values = { {10, 17, 13, 28, 23},
                         {17, 22, 16, 29, 23},
                         {24, 28, 22, 34, 24},
                         {11, 13,  6, 17,  7},
                         {45, 44, 32, 37, 23},
                         {36, 33, 19, 21,  6},
                         {75, 66, 51, 53, 34} };

      assertEquals(true, ma.isMongeArray( values ) );

      int[][] isArrow = { {0,  0,  0,  0},
                          {0,  0, 16, 29},
                          {0, 28,  0, 34},
                          {0, 13,  6,  0} };
      assertEquals(false, ma.isArrowHeadArray( isArrow ) );

      int[][] isArrow1 = { {10, 11, 12, -3},
                           {20, -1,  0,  0},
                           {30,  0, 33,  0},
                           {40,  0,  0,  9} };
      assertEquals(true, ma.isArrowHeadArray( isArrow1 ) );

      int[][] isgpm1 = { { 0,  0, -2,  0},
                         { 0,  0,  0, -5},
                         {10,  0,  0,  0},
                         { 0,  5,  0,  0} };
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
    }

   public void testIsArrowHeadArray01()
   {
      FunWith2DArrays ma = new FunWith2DArrays();
      int[][] isArrow1 = { {10, 22, 20, 20},
                           {10, -1,  0,  0},
                           {10,  0, 10,  0},
                           {10,  0,  0, 30} };
      assertEquals(true, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[1][1] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[1][1] = 20;
      isArrow1[0][0] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[0][0] = 30;
      assertEquals(true, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[2][2] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[3][3] = 20;
      isArrow1[2][2] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[2][2] = 110;
      assertEquals(true, ma.isArrowHeadArray( isArrow1 ) );

      isArrow1[0][1] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[0][1] = 20;
      isArrow1[0][2] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[0][2] = 10;
      assertEquals(true, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[0][3] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );

      isArrow1[0][3] = 10;
      isArrow1[1][0] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[1][0] = 10;
      assertEquals(true, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[2][0] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[2][0] = 10;
      isArrow1[3][0] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow1 ) );
      isArrow1[3][0] = -50;
      assertEquals(true, ma.isArrowHeadArray( isArrow1 ) );
   }

   public void testIsGeneralPermutationArray02()
   {
      FunWith2DArrays ma = new FunWith2DArrays();
      int[][] isgpm1 = { { 0,  0, -2,  0},
                         { 0,  0,  0, -5},
                         {10,  0,  0,  0},
                         { 0,  5,  0,  0} };
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );

      isgpm1[3][0] = -50;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
      isgpm1[3][0] = 0;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
      isgpm1[2][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
      isgpm1[2][0] = 10;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
      isgpm1[1][0] = -90;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );

      isgpm1[1][0] = 0;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
      isgpm1[0][0] = -90;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );

      isgpm1[0][0] = 0;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
      isgpm1[0][2] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );

      isgpm1[0][2] = -20;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
      isgpm1[1][3] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );

      isgpm1[1][3] = -5;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
      isgpm1[3][3] = 90;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isgpm1 ) );
   }

   public void testIsMongeArray03()
   {
      FunWith2DArrays ma = new FunWith2DArrays();
      int[][] values = { {10, 17, 13, 28, 23},
                         {17, 22, 16, 29, 23},
                         {24, 28, 22, 34, 24},
                         {11, 13,  6, 17,  7},
                         {45, 44, 32, 37, 23},
                         {36, 33, 19, 21,  6},
                         {75, 66, 51, 53, 34} };

      assertEquals(true, ma.isMongeArray( values ) );

      values[0][0] = 95;
      assertEquals(false, ma.isMongeArray( values ) );
      values[0][0] = 10;
      assertEquals(true, ma.isMongeArray( values ) );

      values[0][1] = 0;
      assertEquals(false, ma.isMongeArray( values ) );
      values[0][1] = 17;
      assertEquals(true, ma.isMongeArray( values ) );

      values[6][4] = 99;
      assertEquals(false, ma.isMongeArray( values ) );
      values[6][4] = 34;
      assertEquals(true, ma.isMongeArray( values ) );

      values[0][1] = -17;
      assertEquals(false, ma.isMongeArray( values ) );
      values[0][1] = 17;
      assertEquals(true, ma.isMongeArray( values ) );

      values[5][2] = -17;
      assertEquals(false, ma.isMongeArray( values ) );
      values[5][2] = 19;
      assertEquals(true, ma.isMongeArray( values ) );
   }

   public void testIsArrowHeadArrayAndIsGeneralPermutationArray04()
   {
      testIsArrowHeadArray01();
      testIsGeneralPermutationArray02();

      FunWith2DArrays ma = new FunWith2DArrays();

      int[][] isArrow6x6 = { {10, 22, 20, -5,  2, -99},
                             {33, -2,  0,  0,  0,  0},
                             {13,  0, 77,  0,  0,  0},
                             {-1,  0,  0, 100, 0,  0},
                             {95,  0,  0,  0, -5,  0},
                             {-6,  0,  0,  0,  0, -2} };
      assertEquals(true, ma.isArrowHeadArray( isArrow6x6 ) );

      isArrow6x6[0][5] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow6x6 ) );
      isArrow6x6[0][5] = 19;
      assertEquals(true, ma.isArrowHeadArray( isArrow6x6 ) );

      isArrow6x6[4][2] = 90;
      assertEquals(false, ma.isArrowHeadArray( isArrow6x6 ) );
      isArrow6x6[4][2] =  0;
      assertEquals(true, ma.isArrowHeadArray( isArrow6x6 ) );

      int[][] isGPM3x3 = { {10, 17, 13},
                           {17, 22, 16},
                           {75, 66, 51} };

      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM3x3 ) );
      isGPM3x3[0][2] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM3x3 ) );
      isGPM3x3[1][0] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM3x3 ) );
      isGPM3x3[2][0] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM3x3 ) );

      isGPM3x3[0][1] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM3x3 ) );
      isGPM3x3[1][2] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM3x3 ) );
      isGPM3x3[2][1] =  0;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isGPM3x3 ) );
      isGPM3x3[2][2] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM3x3 ) );

      int[][] isGPM6x6 = { {10, 22, 20, -5,  2, -99},
                           {33, -2,  0, 60, 13,  50},
                           {13,  0, 77,  5,  0, 195},
                           {-1, 14,  0, 100, 3, 236},
                           {95, 33,  0, 19, -5, -53},
                           {-6, 25, 10, -6,  0,  -2} };

      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[0][2] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[1][0] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[2][0] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[0][1] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[1][3] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[2][5] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[5][2] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[3][1] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[1][5] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[3][0] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[4][1] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[0][0] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[0][3] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[0][5] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[1][4] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[2][3] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[3][4] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[3][5] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[5][0] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[5][1] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[5][3] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[4][3] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[4][4] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[4][5] =  0;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
      isGPM6x6[4][0] =  0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPM6x6 ) );
   }

   public void testIsArrowHeadArrayAndIsGeneralPermutationArray05()
   {
      FunWith2DArrays ma = new FunWith2DArrays();
      int[][] isArrow4x4 = { {10, 22, 20, 99},
                             {10, -2,  0, 66},
                             {10, -2,  0, 66},
                             {10,  0, -9, -11} };
      assertEquals(false, ma.isArrowHeadArray( isArrow4x4 ) );

      isArrow4x4[2][1] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow4x4 ) );
      isArrow4x4[1][3] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow4x4 ) );

      isArrow4x4[3][2] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow4x4 ) );
      isArrow4x4[2][3] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow4x4 ) );
      isArrow4x4[2][2] = -990;
      assertEquals(true, ma.isArrowHeadArray( isArrow4x4 ) );
      isArrow4x4[2][0] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow4x4 ) );

      int[][] isGPS4x4 = { {10, 22, 20, 99},
                           {10, -2,  0, 66},
                           {10, -2,  0, 66},
                           {10,  0, -9, -11} };
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );

      isGPS4x4[2][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );
      isGPS4x4[1][3] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );

      isGPS4x4[3][2] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );
      isGPS4x4[2][3] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );
      isGPS4x4[3][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );
      isGPS4x4[0][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );
      isGPS4x4[0][1] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );
      isGPS4x4[0][3] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );

      isGPS4x4[1][1] = 0;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );
      isGPS4x4[2][1] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPS4x4 ) );
   }

   public void testIsArrowHeadArrayAndIsMongeArray06()
   {
      FunWith2DArrays ma = new FunWith2DArrays();

      testIsArrowHeadArray01();

      int[][] isArrow5x5 = { {10, 22, 20, -5, -99},
                             {13,  0, 77,  0,  0},
                             {-1,  0,  0, 10,  0},
                             {95,  0,  0,  0,  0},
                             {-6,  0,  0,  0, -2} };
      assertEquals(false, ma.isArrowHeadArray( isArrow5x5 ) );

      isArrow5x5[1][1] = -90;
      assertEquals(false, ma.isArrowHeadArray( isArrow5x5 ) );
      isArrow5x5[1][2] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow5x5 ) );
      isArrow5x5[2][2] = 90;
      assertEquals(false, ma.isArrowHeadArray( isArrow5x5 ) );
      isArrow5x5[2][3] =  0;
      assertEquals(false, ma.isArrowHeadArray( isArrow5x5 ) );
      isArrow5x5[3][3] = 80;
      assertEquals(true, ma.isArrowHeadArray( isArrow5x5 ) );

      testIsMongeArray03();

      int[][] values = { {37, 23, 24, 32},
                         {21,  6,  7, 10},
                         {53, 34, 30, 31},
                         {32, 13,  9,  6},
                         {43, 21, 15,  8} };

      assertEquals(true, ma.isMongeArray( values ) );
      values[0][2] = 23;
      assertEquals(false, ma.isMongeArray( values ) );
   }

   public void testIsArrowHeadArrayAndIsMongeArray07()
   {
      FunWith2DArrays ma = new FunWith2DArrays();
      int[][] isArrow3x3 = { {10, 22, 20},
                             {10, -2,  0},
                             {10,  0, -9} };
      assertEquals(true, ma.isArrowHeadArray( isArrow3x3 ) );

      isArrow3x3[0][0] = 0;
      assertEquals(false, ma.isArrowHeadArray( isArrow3x3 ) );
      isArrow3x3[0][0] = 19;
      assertEquals(true, ma.isArrowHeadArray( isArrow3x3 ) );

      int[][] values = { {23, 22},
                         { 6,  7} };

      assertEquals(false, ma.isMongeArray( values ) );
      values[1][0] = 8;
      assertEquals(true, ma.isMongeArray( values ) );
   }

   public void testIsGeneralPermutationArrayAndIsMongeArray08()
   {
      FunWith2DArrays ma = new FunWith2DArrays();

      int[][] isGPA5x5 = { {10, 22, 20, -5, -99},
                           {13,  0, 77,  0,  0},
                           {-1,  0,  0, 10,  0},
                           {95,  0,  0,  0,  0},
                           {-6,  0,  0,  0, -2} };
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA5x5 ) );

      isGPA5x5[1][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA5x5 ) );
      isGPA5x5[2][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA5x5 ) );
      isGPA5x5[4][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA5x5 ) );
      isGPA5x5[0][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA5x5 ) );
      isGPA5x5[0][3] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA5x5 ) );
      isGPA5x5[0][2] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA5x5 ) );
      isGPA5x5[0][4] = 0;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isGPA5x5 ) );


      int[][] values2X3 = { {23, 22, 11},
                            { 6,  7, 21} };

      assertEquals(false, ma.isMongeArray( values2X3 ) );
      values2X3[1][0] = 8;
      assertEquals(false, ma.isMongeArray( values2X3 ) );
      values2X3[0][2] = 38;
      assertEquals(true, ma.isMongeArray( values2X3 ) );
   }

   public void testIsGeneralPermutationArrayAndIsMongeArray09()
   {
      FunWith2DArrays ma = new FunWith2DArrays();

      int[][] isGPA4x5 = { {10, 22, 20, -5, -99},
                           {13,  0, 77,  0,  0},
                           {-1,  0,  0, 10,  0},
                           {-6,  0,  0,  0, -2} };
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA4x5 ) );


      int[][] isGPA4x4 = { {22, 20, -5, -99},
                           { 0, 77,  0,  0},
                           {-1,  0, 10,  0},
                           {-6,  0,  0, -2} };
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA4x4 ) );

      isGPA4x4[0][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA4x4 ) );
      isGPA4x4[2][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA4x4 ) );
      isGPA4x4[3][3] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA4x4 ) );
      isGPA4x4[0][1] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA4x4 ) );
      isGPA4x4[0][2] = 0;
      assertEquals(true, ma.isIntegerGeneralizedPermutationArray( isGPA4x4 ) );
      isGPA4x4[0][3] = 0;
      isGPA4x4[1][1] = 0;
      isGPA4x4[2][2] = 0;
      isGPA4x4[3][0] = 0;
      assertEquals(false, ma.isIntegerGeneralizedPermutationArray( isGPA4x4 ) );


      int[][] values3X2 = { {23, 22},
                            { 6,  7},
                            { 6, 21} };

      assertEquals(false, ma.isMongeArray( values3X2 ) );
      values3X2[1][0] = 8;
      assertEquals(false, ma.isMongeArray( values3X2 ) );
      values3X2[2][1] = -38;
      assertEquals(true, ma.isMongeArray( values3X2 ) );
   }

   public void testAllFun2DArray10()
   {
      testIsArrowHeadArray01();
      testIsGeneralPermutationArray02();
      testIsMongeArray03();
      testIsArrowHeadArrayAndIsGeneralPermutationArray04();
      testIsArrowHeadArrayAndIsGeneralPermutationArray05();
      testIsArrowHeadArrayAndIsMongeArray06();
      testIsArrowHeadArrayAndIsMongeArray07();
      testIsGeneralPermutationArrayAndIsMongeArray08();
      testIsGeneralPermutationArrayAndIsMongeArray09();
   }
   public void testPacifyingNumbers00()
   {
      PacifyingNumbers pn = new PacifyingNumbers();
      assertEquals(4+1, pn.sumDigits(41));
      assertEquals(5+9+0+3, pn.sumDigits(-5903));
      
      List<Integer> numbers = new ArrayList<Integer>();
      numbers.add(new Integer(1382));
      numbers.add(new Integer(105521));
      numbers.add(new Integer(-95));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(-734));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(14));
      assertEquals(false, pn.arePacfyingNumbers(numbers));

      numbers = new ArrayList<Integer>();
      numbers.add(new Integer(203));
      numbers.add(new Integer(10211));
      numbers.add(new Integer(-5));
      assertEquals(32, pn.getNextPacifyingNumber(numbers, 24));
      assertEquals(1031, pn.getNextPacifyingNumber(numbers, 1030));
      assertEquals(2003, pn.getNextPacifyingNumber(numbers, 2003));
   }

   public void testSumNonNegativeDigits01()
   {
      PacifyingNumbers pn = new PacifyingNumbers();
      assertEquals(0, pn.sumDigits(0));
      assertEquals(1+6+8+7+3, pn.sumDigits(16873));
      assertEquals(2+0+6+8, pn.sumDigits(2068));
      assertEquals(4+9+5+0, pn.sumDigits(4950));
      assertEquals(1+1+3+3+5+5+1+0, pn.sumDigits(11335510));
   }

   public void testSumDigitsWithNegative02()
   {
      PacifyingNumbers pn = new PacifyingNumbers();
      assertEquals(5+0, pn.sumDigits(-50));
      assertEquals(1+6+8+7+3, pn.sumDigits(-16873));
      assertEquals(2+0+6+8, pn.sumDigits(-2068));
      assertEquals(4+9+5+0, pn.sumDigits(-4950));
      assertEquals(1+1+1+0+0+0+0, pn.sumDigits(-111000));
      assertEquals(1+1+3+3+5+5+1+0, pn.sumDigits(-11335510));
   }

   public void testArePacfyingNumbersNonNegative03()
   {
      PacifyingNumbers pn = new PacifyingNumbers();
      
      List<Integer> numbers = new ArrayList<Integer>();
      numbers.add(new Integer(60487));
      numbers.add(new Integer(7846));
      numbers.add(new Integer(48760));
      numbers.add(new Integer(2286610));
      numbers.add(new Integer(861091));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(8611));
      assertEquals(false, pn.arePacfyingNumbers(numbers));

      numbers = new ArrayList<Integer>();
      numbers.add(new Integer(406));
      numbers.add(new Integer(901));
      numbers.add(new Integer(1801));
      numbers.add(new Integer(550));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(549));
      assertEquals(false, pn.arePacfyingNumbers(numbers));

      numbers = new ArrayList<Integer>();
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(4012));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(11111011));
      numbers.add(new Integer(12121));
      numbers.add(new Integer(7));
      numbers.add(new Integer(4021));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(402101));
      assertEquals(false, pn.arePacfyingNumbers(numbers));

      numbers = new ArrayList<Integer>();
      numbers.add(new Integer(0));
      assertEquals(true, pn.arePacfyingNumbers(numbers));

      numbers = new ArrayList<Integer>();
      numbers.add(new Integer(1));
      numbers.add(new Integer(10));
      numbers.add(new Integer(1000));
      numbers.add(new Integer(10000));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(100001));
      assertEquals(false, pn.arePacfyingNumbers(numbers));
   }

   public void testArePacfyingNumbersWithNegativeNumbers04()
   {
      PacifyingNumbers pn = new PacifyingNumbers();

      List<Integer> numbers = new ArrayList<Integer>();
      numbers.add(new Integer(-401));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(-2021));
      numbers.add(new Integer(-10301));
      numbers.add(new Integer(-5));
      numbers.add(new Integer(-11111));
      assertEquals(true, pn.arePacfyingNumbers(numbers));
      numbers.add(new Integer(1111));
      assertEquals(false, pn.arePacfyingNumbers(numbers));

      numbers = new ArrayList<Integer>();
      numbers.add(new Integer(1405));
      numbers.add(new Integer(2161));
      numbers.add(new Integer(-540));
      numbers.add(new Integer(10143));
      assertEquals(false, pn.arePacfyingNumbers(numbers));
   }

   public void testSumDigitsAndArePacfyingNumberNonNegative05()
   {
      testSumNonNegativeDigits01();
      testArePacfyingNumbersNonNegative03();
   }

   public void testSumDigitsAndArePacfyingNumberWithNegative06()
   {
      testArePacfyingNumbersWithNegativeNumbers04();
      testSumDigitsWithNegative02();
   }

   public void testGetNextPacfyingNumberNonNegative07()
   {
      PacifyingNumbers pn = new PacifyingNumbers();
      List<Integer> numbers = new ArrayList<Integer>();
      numbers.add(new Integer(50103));
      numbers.add(new Integer(102114));
      numbers.add(new Integer(9));
      assertEquals(45, pn.getNextPacifyingNumber(numbers, 38));
      assertEquals(1026, pn.getNextPacifyingNumber(numbers, 1019));

      numbers = new ArrayList<Integer>();
      numbers.add(new Integer(5001));
      numbers.add(new Integer(102201));
      numbers.add(new Integer(6));
      assertEquals(111111, pn.getNextPacifyingNumber(numbers, 111103));
      assertEquals(1023, pn.getNextPacifyingNumber(numbers, 1019));
      assertEquals(6, pn.getNextPacifyingNumber(numbers, 6));
      assertEquals(600, pn.getNextPacifyingNumber(numbers, 520));
      assertEquals(1005, pn.getNextPacifyingNumber(numbers, 601));
   }

   public void testGetNextPacfyingNumberWithNegativeNumbers08()
   {
      PacifyingNumbers pn = new PacifyingNumbers();
      List<Integer> numbers = new ArrayList<Integer>();
      numbers.add(new Integer(-3001));
      numbers.add(new Integer(-4));
      numbers.add(new Integer(200101));
      assertEquals(40, pn.getNextPacifyingNumber(numbers, 38));
      assertEquals(103, pn.getNextPacifyingNumber(numbers, 50));
      assertEquals(1003, pn.getNextPacifyingNumber(numbers, 500));

      numbers = new ArrayList<Integer>();
      numbers.add(new Integer(101));
      assertEquals(200000, pn.getNextPacifyingNumber(numbers, 111103));
      numbers.add(new Integer(-200));
      numbers.add(new Integer(-101));
      assertEquals(1100, pn.getNextPacifyingNumber(numbers, 1019));
      assertEquals(11, pn.getNextPacifyingNumber(numbers, 6));
      assertEquals(2, pn.getNextPacifyingNumber(numbers, 2));
      assertEquals(2, pn.getNextPacifyingNumber(numbers, 0));
   }

   public void testAllPacfyingNumber09()
   {
      testGetNextPacfyingNumberWithNegativeNumbers08();
      testGetNextPacfyingNumberNonNegative07();
      testSumDigitsAndArePacfyingNumberNonNegative05();
      testSumDigitsAndArePacfyingNumberWithNegative06();
   }
   public void testFunctionsGoneWild2015_00()
   {
      assertEquals(8, FunctionsGoneWild2015.f1(5));
      assertEquals(2.364669, FunctionsGoneWild2015.f2(5), 0.05);
      assertEquals(0.41110, FunctionsGoneWild2015.f3(2., 4., 7.), 0.05);
      assertEquals(10.5746, FunctionsGoneWild2015.f4(5., 11., 3.),  0.05);
      assertEquals(117.0, FunctionsGoneWild2015.f5(7, 1, 4), 1);
      assertEquals(2+14+27 , FunctionsGoneWild2015.f6("Think left, think right, think high and low", "ink"));
      assertEquals(true, FunctionsGoneWild2015.f7(false, false, true) );
      assertEquals(true, FunctionsGoneWild2015.f8(false, false, false, false) );
      assertEquals(5.151, FunctionsGoneWild2015.f9(1, 1, 1.1, 4.4), 0.05);
      assertEquals(true, FunctionsGoneWild2015.f10(false, false, false, false));
   }

   public void testFunctionsGoneWild2015_01()
   {
      assertEquals(3, FunctionsGoneWild2015.f1(0), 1);
      assertEquals(0, FunctionsGoneWild2015.f1(1), 1);
      assertEquals(-1, FunctionsGoneWild2015.f1(2), 1);
      assertEquals(48, FunctionsGoneWild2015.f1(9), 1);
      assertEquals(80, FunctionsGoneWild2015.f1(11), 1);
      assertEquals(323, FunctionsGoneWild2015.f1(20), 1);
      assertEquals(385, FunctionsGoneWild2015.f1(33), 1);
      assertEquals(715.0, FunctionsGoneWild2015.f1(38), 1);
      assertEquals(1051.0, FunctionsGoneWild2015.f1(42), 1);
      assertEquals(1581.0, FunctionsGoneWild2015.f1(56), 1);
      assertEquals(2285.0, FunctionsGoneWild2015.f1(60), 1);
      assertEquals(925.0, FunctionsGoneWild2015.f1(64), 1);
      assertEquals(1309.0, FunctionsGoneWild2015.f1(66), 1);
      assertEquals(2269.0, FunctionsGoneWild2015.f1(70), 1);

      assertEquals(1451.0, FunctionsGoneWild2015.f1(82), 1);
      assertEquals(1005.0, FunctionsGoneWild2015.f1(90), 1);
      assertEquals(1342.0, FunctionsGoneWild2015.f1(91), 1);
      assertEquals(654, FunctionsGoneWild2015.f1(99), 1);
      assertEquals(1917, FunctionsGoneWild2015.f1(100), 1);
      assertEquals(2285.0, FunctionsGoneWild2015.f1(102), 1);
      assertEquals(1134.0, FunctionsGoneWild2015.f1(107), 1);
   }

   public void testFunctionsGoneWild2015_02()
   {
      assertEquals(1.4515605795761664, FunctionsGoneWild2015.f2(3), 0.05);
      assertEquals(2.364668608107153, FunctionsGoneWild2015.f2(5), 0.05);
      assertEquals(3.684115747574562, FunctionsGoneWild2015.f2(15), 0.05);
      assertEquals(3.8395775705969752, FunctionsGoneWild2015.f2(17), 0.05);
      assertEquals(3.91210, FunctionsGoneWild2015.f2(18), 0.05);
      assertEquals(4.614580769905978, FunctionsGoneWild2015.f2(30), 0.05);
      assertEquals(4.663597965228747, FunctionsGoneWild2015.f2(31), 0.05);
      assertEquals(4.711572608507602, FunctionsGoneWild2015.f2(32), 0.05);
      assertEquals(4.980458250413007, FunctionsGoneWild2015.f2(38), 0.05);
      assertEquals(5.063879507676874, FunctionsGoneWild2015.f2(40), 0.05);
      assertEquals(5.104581942135671, FunctionsGoneWild2015.f2(41), 0.05);
   }

   public void testFunctionsGoneWild2015_03()
   {
      assertEquals(94.47336517643274, FunctionsGoneWild2015.f3(0.3, 14.4, 13.2), 0.5);
      assertEquals(0.05604519158628052, FunctionsGoneWild2015.f3(4.8, 7.3, 15.8), 0.5);
      assertEquals(1357.2358654986406, FunctionsGoneWild2015.f3(0.8, 16.7, 13.1), 0.5);
      assertEquals(4.626463739072331, FunctionsGoneWild2015.f3(0.6, 15.3, 12.5), 0.5);
      assertEquals(272.8329336856293, FunctionsGoneWild2015.f3(4.3, 6.9, 15.5), 0.5);
      assertEquals(400.5075089270817, FunctionsGoneWild2015.f3(1.9, 16.0, 12.2), 0.5);
      assertEquals(40.927577848866164, FunctionsGoneWild2015.f3(4.9, 23.9, 11.5), 0.5);
      assertEquals(1204.6102589634786, FunctionsGoneWild2015.f3(1.0, 28.6, 16.2), 0.5);
      assertEquals(1904.7768546501457, FunctionsGoneWild2015.f3(1.7, 14.0, 11.3), 0.5);
      assertEquals(12.931792164732746, FunctionsGoneWild2015.f3(5.4, 28.9, 16.5), 0.5);
     }

   public void testFunctionsGoneWild2015_04()
   {
      assertEquals(19.159747301374853, FunctionsGoneWild2015.f4(2.6, 5.7, 5.8), 0.05);
      assertEquals(22.313217142834393, FunctionsGoneWild2015.f4(2.0, 6.7, 6.8), 0.05);
      assertEquals(11.653538852621399, FunctionsGoneWild2015.f4(2.3, 6.8, 3.4), 0.05);
      assertEquals(15.10710405846983, FunctionsGoneWild2015.f4(2.5, 6.6, 4.5), 0.05);
      assertEquals(7.888045774314954, FunctionsGoneWild2015.f4(2.5, 6.6, 2.2), 0.05);
      assertEquals(22.321644213866627, FunctionsGoneWild2015.f4(2.4, 6.5, 6.8), 0.05);
      assertEquals(-17.224725430227956, FunctionsGoneWild2015.f4(2.7, 7.2, -5.8), 0.5);
      assertEquals(-27.65641447521751, FunctionsGoneWild2015.f4(2.8, 5.5, -9.1), 0.5);
      assertEquals(-11.923869574324572, FunctionsGoneWild2015.f4(2.1, 6.6, -4.1), 0.5);

      assertEquals(62.90536511972242, FunctionsGoneWild2015.f4(1.6, 5.6, -5.0), 0.5);
      assertEquals(20.268915779797563, FunctionsGoneWild2015.f4(2.1, 5.3, -8.7), 0.5);
      assertEquals(166.98702144190452, FunctionsGoneWild2015.f4(1.0, 5.1, -4.0), 0.5);
      assertEquals(94.06957965136849, FunctionsGoneWild2015.f4(1.7, 6.2, -5.8), 0.5);
      assertEquals(58.56120019593112, FunctionsGoneWild2015.f4(1.8, 5.9, -3.7), 0.5);
      assertEquals(-55.54675527749574, FunctionsGoneWild2015.f4(1.1, 5.7, 1.1), 0.5);
      assertEquals(-0.06045530597514165, FunctionsGoneWild2015.f4(1.0, 7.4, 5.1), 0.05);
      assertEquals(-0.8066949131687075, FunctionsGoneWild2015.f4(1.4, 6.1, 3.5), 0.05);
      assertEquals(-0.15857895259693072, FunctionsGoneWild2015.f4(1.3, 7.3, 4.6), 0.05);
      assertEquals(-0.4924708627875875, FunctionsGoneWild2015.f4(1.7, 6.7, 3.9), 0.05);
    }

   public void testFunctionsGoneWild2015_05()
   {
      assertEquals(-158.0, FunctionsGoneWild2015.f5(7, 2, 57), 1);
      assertEquals(55.0, FunctionsGoneWild2015.f5(9, 1, 31), 1);
      assertEquals(514.0, FunctionsGoneWild2015.f5(11, 2, 25), 1);
      assertEquals(175.0, FunctionsGoneWild2015.f5(9, 2, 35), 1);
      assertEquals(71.0, FunctionsGoneWild2015.f5(7, 2, 32), 1);
      assertEquals(-176.0, FunctionsGoneWild2015.f5(11, 3, 70), 1);
      assertEquals(300.0, FunctionsGoneWild2015.f5(8, 2, 19), 1);
      assertEquals(552.0, FunctionsGoneWild2015.f5(8, 3, 21), 1);
      assertEquals(112.0, FunctionsGoneWild2015.f5(7, 3, 39), 1);
      assertEquals(500.0, FunctionsGoneWild2015.f5(9, 3, 30), 1);
   }

   public void testFunctionsGoneWild2015_06()
   {
      assertEquals(26, FunctionsGoneWild2015.f6("no one can run", "n"));
      assertEquals(18, FunctionsGoneWild2015.f6("no one can run", " "));
      assertEquals(11, FunctionsGoneWild2015.f6("no one can run", "r"));
      assertEquals(-1, FunctionsGoneWild2015.f6("no one can run", "z"));
      assertEquals(7 + 15+ 25 + 34, FunctionsGoneWild2015.f6("From there to here, and here to there", "ere"));
      assertEquals(16 + 17 + 25 + 26, FunctionsGoneWild2015.f6("my password is brrr and arrrgh", "rr"));
      assertEquals(16 + 25, FunctionsGoneWild2015.f6("my password is brrr and arrrgh", "rrr"));
      assertEquals(10 + 33, FunctionsGoneWild2015.f6("I meant what I said and I said what I meant", "at"));
      assertEquals(4+10+16+20+27+33+40 , FunctionsGoneWild2015.f6("I meant what I said and I said what I meant", "a"));
      assertEquals(3+39, FunctionsGoneWild2015.f6("I meant what I said and I said what I meant", "ean"));
      assertEquals(10 + 32, FunctionsGoneWild2015.f6("six sick hicks nick six slick bricks", "icks"));
      assertEquals(6+11+17+27+33, FunctionsGoneWild2015.f6("six sick hicks nick six slick bricks", "ck"));
      assertEquals(0, FunctionsGoneWild2015.f6("help", "help"));
//                                                    0123456789x1234567892123456789312345678941234567895123456789
      assertEquals(52, FunctionsGoneWild2015.f6("aardvark aaadonta freeer feed beet jeep sell well less leek", "a"));
      assertEquals(19, FunctionsGoneWild2015.f6("aardvark aaadonta freeer feed beet jeep sell well less leek", "aa"));
      assertEquals(20, FunctionsGoneWild2015.f6("aardvark aaadonta freeer feed beet jeep sell well less leek", "eee"));
      assertEquals(56, FunctionsGoneWild2015.f6("aardvark aaadonta freeer feed beet jeep sell well less leek", "eek"));
      assertEquals(25, FunctionsGoneWild2015.f6("aardvark aaadonta freeer keep beet jeep sell well less leek", "ke"));
      assertEquals(-1, FunctionsGoneWild2015.f6("aardvark aaadonta freeer keep beet jeep sell well less leek", "kep"));
   }

   public void testFunctionsGoneWild2015_07()
   {
      assertEquals(true, FunctionsGoneWild2015.f7(false, false, false) );
      assertEquals(true, FunctionsGoneWild2015.f7(false, false, true) );
      assertEquals(false, FunctionsGoneWild2015.f7(false, true, false) );
      assertEquals(true, FunctionsGoneWild2015.f7(false, true, true) );
      assertEquals(false, FunctionsGoneWild2015.f7(true, false, false) );
      assertEquals(true, FunctionsGoneWild2015.f7(true, false, true) );
      assertEquals(true, FunctionsGoneWild2015.f7(true, true, false) );
      assertEquals(false, FunctionsGoneWild2015.f7(true, true, true) );
   }

   public void testFunctionsGoneWild2015_08()
   {
      assertEquals(true, FunctionsGoneWild2015.f8(false, false, false, false) );
      assertEquals(false, FunctionsGoneWild2015.f8(false, false, false, true) );
      assertEquals(true, FunctionsGoneWild2015.f8(false, false, true, false) );
      assertEquals(false, FunctionsGoneWild2015.f8(false, false, true, true) );
      assertEquals(true, FunctionsGoneWild2015.f8(false, true, false, false) );
      assertEquals(false, FunctionsGoneWild2015.f8(false, true, false, true) );
      assertEquals(false, FunctionsGoneWild2015.f8(false, true, true, false) );
      assertEquals(false, FunctionsGoneWild2015.f8(false, true, true, true) );

      assertEquals(true, FunctionsGoneWild2015.f8(true, false, false, false) );
      assertEquals(true, FunctionsGoneWild2015.f8(true, false, false, true) );
      assertEquals(false, FunctionsGoneWild2015.f8(true, false, true, false) );
      assertEquals(true, FunctionsGoneWild2015.f8(true, false, true, true) );
      assertEquals(true, FunctionsGoneWild2015.f8(true, true, false, false) );
      assertEquals(true, FunctionsGoneWild2015.f8(true, true, false, true) );
      assertEquals(false, FunctionsGoneWild2015.f8(true, true, true, false) );
      assertEquals(true, FunctionsGoneWild2015.f8(true, true, true, true) );
   }

   public void testFunctionsGoneWild2015_09()
   {
      assertEquals(558.1594042325241, FunctionsGoneWild2015.f9(9, 1, 1.3,6.9), 1.0);
      assertEquals(2689.0068429209805, FunctionsGoneWild2015.f9(11, 3, 1.1,6.1), 1.0);
      assertEquals(4191.9734038496945, FunctionsGoneWild2015.f9(8, 2, 1.2,6.2), 1.0);
      assertEquals(2289.01194866166, FunctionsGoneWild2015.f9(7, 1, 2.7,7.2), 1.0);
      assertEquals(4195.445036495956, FunctionsGoneWild2015.f9(8, 2, 2.6,5.9), 1.0);
      assertEquals(3283.4657202809876, FunctionsGoneWild2015.f9(7, 3, 2.4,7.2), 1.0);
      assertEquals(566.5395651877959, FunctionsGoneWild2015.f9(9, 3, 1.6,6.8), 1.0);
      assertEquals(2341.795019703776, FunctionsGoneWild2015.f9(7, 1, 1.9,5.1), 1.0);
      assertEquals(766.1204824441345, FunctionsGoneWild2015.f9(7, 3, 2.2,5.2), 1.0);
      assertEquals(2291.370453180332, FunctionsGoneWild2015.f9(7, 1, 1.2,6.3), 1.0);
      assertEquals(560.0834558061645, FunctionsGoneWild2015.f9(9, 3, 2.2,6.5), 1.0);
   }

   public void testFunctionsGoneWild2015_10()
   {
      assertEquals(true, FunctionsGoneWild2015.f10(false, false, false, false));
      assertEquals(true, FunctionsGoneWild2015.f10(false, false, false, true));
      assertEquals(true, FunctionsGoneWild2015.f10(false, false, true, false));
      assertEquals(true, FunctionsGoneWild2015.f10(false, false, true, true) );
      assertEquals(true, FunctionsGoneWild2015.f10(false, true, false, false));
      assertEquals(true, FunctionsGoneWild2015.f10(false, true, false, true));
      assertEquals(true, FunctionsGoneWild2015.f10(false, true, true, false));
      assertEquals(true, FunctionsGoneWild2015.f10(false, true, true, true));

      assertEquals(false, FunctionsGoneWild2015.f10(true, false, false, false) );
      assertEquals(false, FunctionsGoneWild2015.f10(true, false, false, true) );
      assertEquals(true, FunctionsGoneWild2015.f10(true, false, true, false) );
      assertEquals(true, FunctionsGoneWild2015.f10(true, false, true, true) );
      assertEquals(true, FunctionsGoneWild2015.f10(true, true, false, false) );
      assertEquals(true, FunctionsGoneWild2015.f10(true, true, false, true) );
      assertEquals(true, FunctionsGoneWild2015.f10(true, true, true, false) );
      assertEquals(true, FunctionsGoneWild2015.f10(true, true, true, true) );
   }

   public void testFunctionsGoneWild2015_11()
   {
      testFunctionsGoneWild2015_01();
      testFunctionsGoneWild2015_02();
      testFunctionsGoneWild2015_03();
      testFunctionsGoneWild2015_04();
   }

   public void testFunctionsGoneWild2015_12()
   {
      testFunctionsGoneWild2015_05();
      testFunctionsGoneWild2015_06();
   }

   public void testFunctionsGoneWild2015_13()
   {
      testFunctionsGoneWild2015_07();
      testFunctionsGoneWild2015_08();
      testFunctionsGoneWild2015_09();
      testFunctionsGoneWild2015_10();
   }

   public void testFunctionsGoneWild2015_14()
   {
      testFunctionsGoneWild2015_11();
      testFunctionsGoneWild2015_12();
      testFunctionsGoneWild2015_13();
   }
   public void testMaximumDamage01()
   {
      MaximumDamage mc = new MaximumDamage(20, 20);
      assertEquals(10-7+11-9, mc.distance(new Location(10, 11), new Location( 7, 9)));

      mc.addOrcCamp(new Location(10, 3));
      mc.addOrcCamp(new Location(6, 7));

      mc.addElfStation(new Location(6, 8));
      mc.addElfStation(new Location(-9,-8));
      assertEquals(0, mc.calculateDamage(new Location( 17, 9)));
      assertEquals(1, mc.calculateDamage(new Location( 6, 11)));
      assertEquals(2, mc.calculateDamage(new Location( 7, 4)));

      Location[] posLoc = { new Location(12, 7), new Location(13, 2), new Location(5, 5)};
      assertEquals(new Location(13, 2), mc.maxIncreaseDamage(posLoc));
   }

   public void testMaximumDamageDistance02()
   {
      MaximumDamage mc = new MaximumDamage(40, 40);
      assertEquals(10, mc.distance(new Location(20, 20), new Location( 10, 20)));
      assertEquals(9, mc.distance(new Location(20, 20), new Location( 17, 14)));
      assertEquals(8, mc.distance(new Location(10, 10), new Location( 15, 13)));
      assertEquals(13, mc.distance(new Location(15, 15), new Location( 22, 9)));
      assertEquals(12, mc.distance(new Location(17, 18), new Location( 29, 18)));
      assertEquals(28, mc.distance(new Location(7, 11), new Location( 35, 11)));
      assertEquals(16, mc.distance(new Location(13, 17), new Location( 24, 22)));
   }

   public void testMaximumDamageCalculateDamge03()
   {
      MaximumDamage mc = new MaximumDamage(50, 50);

      mc.addOrcCamp(new Location(10, 10));
      mc.addOrcCamp(new Location(15, 15));
      mc.addOrcCamp(new Location(10, 15));
      mc.addOrcCamp(new Location(13, 12));

      assertEquals(0, mc.calculateDamage(new Location( 21, 15)));
      assertEquals(1, mc.calculateDamage(new Location( 20, 15)));
      assertEquals(2, mc.calculateDamage(new Location( 15, 12)));
      assertEquals(3, mc.calculateDamage(new Location( 13, 15)));
      mc.addOrcCamp(new Location(13, 22));
      assertEquals(4, mc.calculateDamage(new Location( 13, 17)));
   }

   public void testMaximumDamageCalculateDamgeRowBorder04()
   {
      MaximumDamage mc = new MaximumDamage(15, 15);

      mc.addOrcCamp(new Location(4, 7));
      mc.addOrcCamp(new Location(14, 9));
      mc.addOrcCamp(new Location(8, 8));

      assertEquals(1, mc.calculateDamage(new Location( 15, 8)));
      assertEquals(2, mc.calculateDamage(new Location( 13, 8)));
      assertEquals(2, mc.calculateDamage(new Location( 4, 9)));
      assertEquals(1, mc.calculateDamage(new Location( 0, 7)));
      assertEquals(0, mc.calculateDamage(new Location( 0, 5)));
   }

   public void testMaximumDamageCalculateDamgeColBorder05()
   {
      MaximumDamage mc = new MaximumDamage(15, 15);

      mc.addOrcCamp(new Location(7, 4));
      mc.addOrcCamp(new Location(9, 9));
      mc.addOrcCamp(new Location(9, 14));

      assertEquals(0, mc.calculateDamage(new Location( 5, 11)));
      assertEquals(1, mc.calculateDamage(new Location( 9, 1)));
      assertEquals(2, mc.calculateDamage(new Location( 9, 5)));
      assertEquals(1, mc.calculateDamage(new Location( 6, 12)));
      assertEquals(2, mc.calculateDamage(new Location( 7, 12)));
   }

   public void testMaximumDamageCalculateDamgeCorner06()
   {
      MaximumDamage mc = new MaximumDamage(25, 25);

      mc.addOrcCamp(new Location(2, 3));
      mc.addOrcCamp(new Location(4, 24));
      mc.addOrcCamp(new Location(24, 1));
      mc.addOrcCamp(new Location(24, 24));

      assertEquals(0, mc.calculateDamage(new Location( 15, 15)));
      assertEquals(1, mc.calculateDamage(new Location( 1, 1)));
      assertEquals(1, mc.calculateDamage(new Location( 2, 25)));
      assertEquals(1, mc.calculateDamage(new Location( 25, 4)));
      assertEquals(1, mc.calculateDamage(new Location( 25, 25)));

      assertEquals(1, mc.calculateDamage(new Location( 20, 0)));
      assertEquals(1, mc.calculateDamage(new Location( 0, 6)));
      assertEquals(1, mc.calculateDamage(new Location( 20, 25)));
   }

   public void testMaximumDamageCalculateMaxDamageWithNoExistingElfStations07()
   {
      MaximumDamage mc = new MaximumDamage(30, 30);

      mc.addOrcCamp(new Location(8, 8));
      mc.addOrcCamp(new Location(11, 13));
      mc.addOrcCamp(new Location(7, 21));
      mc.addOrcCamp(new Location(14, 24));

      Location[] posLoc = { new Location(9, 24), new Location(12, 10), new Location(5, 5)};
      assertEquals(new Location(9, 24), mc.maxIncreaseDamage(posLoc));

      Location[] posLoc1 = { new Location(5, 11), new Location(18, 20), new Location(13, 16)};
      assertEquals(new Location(13, 16), mc.maxIncreaseDamage(posLoc1));

      Location[] posLoc2 = { new Location(9, 8), new Location(8, 12), new Location(9, 21)};
      assertEquals(new Location(8, 12), mc.maxIncreaseDamage(posLoc2));
   }

   public void testMaximumDamageCalculateMaxDamageRowBorders08()
   {
      MaximumDamage mc = new MaximumDamage(30, 30);

      mc.addOrcCamp(new Location(2, 6));
      mc.addOrcCamp(new Location(4, 13));
      mc.addOrcCamp(new Location(0, 24));
      mc.addOrcCamp(new Location(3, 19));

      mc.addElfStation(new Location(6, 6));

      Location[] posLoc = { new Location(2, 10), new Location(4, 17), new Location(1, 25),
                             new Location(4, 19), new Location(4, 8)};
      assertEquals(new Location(4, 17), mc.maxIncreaseDamage(posLoc));

      mc.addOrcCamp(new Location(6, 21));
      mc.addOrcCamp(new Location(5, 23));
      Location[] posLoc1 = { new Location(2, 10), new Location(4, 17), new Location(1, 25),
                             new Location(4, 19), new Location(4, 8)};
      assertEquals(new Location(4, 19), mc.maxIncreaseDamage(posLoc1));

      mc.addElfStation(new Location(6, 22));
      Location[] posLoc2 = { new Location(2, 23), new Location(4, 9), new Location(4, 25),
                             new Location(5, 20), new Location(5, 22)};
      assertEquals(new Location(2, 23), mc.maxIncreaseDamage(posLoc2));

      Location[] posLoc3 = { new Location(5, 22), new Location(4, 9), new Location(4, 25),
                             new Location(2, 23), new Location(5, 20)};
      assertEquals(new Location(2, 23), mc.maxIncreaseDamage(posLoc2));

      mc = new MaximumDamage(30, 30);

      mc.addOrcCamp(new Location(28, 6));
      mc.addOrcCamp(new Location(26, 12));
      mc.addOrcCamp(new Location(22, 15));
      mc.addOrcCamp(new Location(25, 18));

      mc.addElfStation(new Location(27, 19));

      Location[] posLoc4 = { new Location(28, 17), new Location(29, 14), new Location(28, 10),
                             new Location(24, 9), new Location(4, 8)};
      assertEquals(new Location(28, 10), mc.maxIncreaseDamage(posLoc4));
   }

   public void testMaximumDamageCalculateMaxDamageColBorders09()
   {
      MaximumDamage mc = new MaximumDamage(30, 30);

      mc.addOrcCamp(new Location(6, 2));
      mc.addOrcCamp(new Location(14, 3));
      mc.addOrcCamp(new Location(18, 4));
      mc.addOrcCamp(new Location(21, 0));
      mc.addOrcCamp(new Location(10, 4));
      mc.addOrcCamp(new Location(24, 4));
      mc.addOrcCamp(new Location(17, 1));

      mc.addElfStation(new Location(14, 4));

      Location[] posLoc = { new Location(15, 4), new Location(20, 1), new Location(9, 3) };
      assertEquals(new Location(20, 1), mc.maxIncreaseDamage(posLoc));

      mc.addElfStation(new Location(23, 2));
      mc.addOrcCamp(new Location(9, 2));
      Location[] posLoc1 = { new Location(25, 0), new Location(20, 4), new Location(15, 2),
                             new Location(7, 1)};
      assertEquals(new Location(7, 1), mc.maxIncreaseDamage(posLoc1));

      mc = new MaximumDamage(30, 30);

      mc.addOrcCamp(new Location(6, 28));
      mc.addOrcCamp(new Location(12, 26));
      mc.addOrcCamp(new Location(15, 29));
      mc.addOrcCamp(new Location(19, 30));
      mc.addOrcCamp(new Location(22, 27));

      mc.addElfStation(new Location(19, 27));

      Location[] posLoc4 = { new Location(18, 27), new Location(4, 30), new Location(9, 29),
                             new Location(24, 29), new Location(7, 26)};
      assertEquals(new Location(7, 26), mc.maxIncreaseDamage(posLoc4));
   }

   public void testMaximumDamageCalculateMaxDamageCornerWithNullReturn10()
   {
      MaximumDamage mc = new MaximumDamage(30, 30);

      mc.addOrcCamp(new Location(3, 3));
      mc.addOrcCamp(new Location(29, 0));
      mc.addOrcCamp(new Location(3, 30));
      mc.addOrcCamp(new Location(26, 26));

      mc.addElfStation(new Location(6, 8));
      mc.addElfStation(new Location(29, 4));

      Location[] posLoc = { new Location(12, 7), new Location(13, 2), new Location(15, 5)};
      assertEquals(null, mc.maxIncreaseDamage(posLoc));

      mc.addElfStation(new Location(1, 4));
      Location[] posLoc1 = { new Location(3, 7), new Location(27, 1),
                                    new Location(15, 5), new Location(29, 28)};
      assertEquals( new Location(29, 28), mc.maxIncreaseDamage(posLoc1));

      mc.addElfStation(new Location(23, 24));
      Location[] posLoc2 = { new Location(3, 3), new Location(27, 1),
                                    new Location(29, 25), new Location(6, 30)};
      assertEquals( new Location(6, 30), mc.maxIncreaseDamage(posLoc2));

      mc = new MaximumDamage(30, 30);

      mc.addOrcCamp(new Location(3, 3));
      mc.addOrcCamp(new Location(29, 0));
      mc.addOrcCamp(new Location(3, 30));
      mc.addOrcCamp(new Location(26, 26));
      mc.addOrcCamp(new Location(27, 27));

      Location[] posLoc3 = { new Location(3, 3), new Location(27, 1),
                                    new Location(29, 25), new Location(6, 28)};
      assertEquals( new Location(29, 25), mc.maxIncreaseDamage(posLoc3));

      mc.addElfStation(new Location(29, 25));
      mc.addOrcCamp(new Location(2, 27));
      Location[] posLoc4 = { new Location(3, 3), new Location(27, 1),
                                    new Location(29, 25), new Location(6, 28)};
      assertEquals( new Location(6, 28), mc.maxIncreaseDamage(posLoc4));

      mc.addOrcCamp(new Location(2, 2));
      mc.addOrcCamp(new Location(2, 3));
      Location[] posLoc5 = { new Location(3, 2), new Location(27, 1),
                                    new Location(29, 25), new Location(6, 28)};
      assertEquals( new Location(3, 2), mc.maxIncreaseDamage(posLoc5));

      mc.addOrcCamp(new Location(29, 2));
      mc.addOrcCamp(new Location(28, 3));
      mc.addOrcCamp(new Location(30, 0));
      Location[] posLoc6 = { new Location(3, 2), new Location(30, 1),
                                    new Location(29, 25), new Location(6, 28)};
      assertEquals( new Location(30, 1), mc.maxIncreaseDamage(posLoc6));
   }
   public void testNetworks01()
   {
      Networks net = new Networks();
      net.addConnection(new Connection("A", "B"));
      net.addConnection(new Connection("A", "C"));
      net.addConnection(new Connection("A", "D"));
      net.addConnection(new Connection("B", "D"));
      net.addConnection(new Connection("C", "E"));
      net.addConnection(new Connection("B", "E"));

      List<String> sol = net.getReachableLocations("A", 1);
      assertEquals(3, sol.size());
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("D"));

      sol = net.getReachableLocations("A", 2);
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("E"));

      sol = net.getAllReachableLocations("A");
      assertEquals(4, sol.size());
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("E"));
   }

   public void testNetworksGetReachableLocationsOneStep02()
   {
      Networks net = new Networks();

      net.addConnection(new Connection("A", "B"));
      net.addConnection(new Connection("A", "E"));
      net.addConnection(new Connection("A", "H"));
      net.addConnection(new Connection("B", "C"));
      net.addConnection(new Connection("B", "F"));
      net.addConnection(new Connection("C", "D"));
      net.addConnection(new Connection("D", "I"));
      net.addConnection(new Connection("E", "E"));
      net.addConnection(new Connection("F", "E"));
      net.addConnection(new Connection("F", "G"));
      net.addConnection(new Connection("F", "D"));
      net.addConnection(new Connection("G", "H"));
      net.addConnection(new Connection("H", "I"));
      net.addConnection(new Connection("I", "G"));

      List<String> sol = net.getReachableLocations("A", 1);
      assertEquals(3, sol.size());
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("E"));
      assertEquals(true, sol.contains("H"));

      sol = net.getReachableLocations("I", 1);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("G"));

      net.addConnection(new Connection("I", "D"));
      net.addConnection(new Connection("I", "E"));
      net.addConnection(new Connection("I", "C"));
      sol = net.getReachableLocations("I", 1);
      assertEquals(4, sol.size());
      assertEquals(true, sol.contains("G"));
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("E"));
      assertEquals(true, sol.contains("C"));
   }

   public void testNetworksGetReachableLocationsTwoOrThreeSteps03()
   {
      Networks net = new Networks();

      net.addConnection(new Connection("A", "B"));
      net.addConnection(new Connection("A", "E"));
      net.addConnection(new Connection("A", "H"));
      net.addConnection(new Connection("B", "C"));
      net.addConnection(new Connection("B", "F"));
      net.addConnection(new Connection("C", "D"));
      net.addConnection(new Connection("D", "I"));
      net.addConnection(new Connection("E", "F"));
      net.addConnection(new Connection("F", "E"));
      net.addConnection(new Connection("F", "G"));
      net.addConnection(new Connection("F", "D"));
      net.addConnection(new Connection("G", "H"));
      net.addConnection(new Connection("H", "I"));
      net.addConnection(new Connection("I", "G"));

      List<String> sol = net.getReachableLocations("A", 2);
      assertEquals(3, sol.size());
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("I"));

      sol = net.getReachableLocations("A", 3);
      assertEquals(3, sol.size());
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("E"));
      assertEquals(true, sol.contains("G"));

      sol = net.getReachableLocations("I", 2);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("H"));

      sol = net.getReachableLocations("I", 3);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("I"));

      net.addConnection(new Connection("G", "D"));
      net.addConnection(new Connection("G", "I"));
      net.addConnection(new Connection("G", "A"));
      net.addConnection(new Connection("G", "F"));
      sol = net.getReachableLocations("I", 3);
      assertEquals(6, sol.size());
      assertEquals(true, sol.contains("I"));
      assertEquals(true, sol.contains("G"));
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("E"));
      assertEquals(true, sol.contains("H"));
      assertEquals(true, sol.contains("D"));
   }

   public void testNetworksGetReachableLocationsFourSteps04()
   {
      Networks net = new Networks();

      net.addConnection(new Connection("A", "X"));
      net.addConnection(new Connection("A", "Y"));
      net.addConnection(new Connection("B", "Z"));
      net.addConnection(new Connection("C", "X"));
      net.addConnection(new Connection("C", "Z"));
      net.addConnection(new Connection("Z", "A"));
      net.addConnection(new Connection("Y", "C"));
      net.addConnection(new Connection("Y", "B"));
      net.addConnection(new Connection("X", "B"));

      List<String> sol = net.getReachableLocations("A", 4);
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("A"));
      assertEquals(true, sol.contains("B"));

      sol = net.getReachableLocations("B", 4);
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));

      net.addConnection(new Connection("X", "Y"));
      net.addConnection(new Connection("Z", "Y"));
      net.addConnection(new Connection("B", "C"));

      sol = net.getReachableLocations("X", 4);
      assertEquals(6, sol.size());
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("A"));
      assertEquals(true, sol.contains("X"));
      assertEquals(true, sol.contains("Y"));
      assertEquals(true, sol.contains("Z"));
   }

   public void testNetworksGetAllReachableLocations05()
   {
      Networks net = new Networks();

      net.addConnection(new Connection("A", "B"));
      net.addConnection(new Connection("A", "H"));
      net.addConnection(new Connection("B", "G"));
      net.addConnection(new Connection("C", "I"));
      net.addConnection(new Connection("E", "I"));
      net.addConnection(new Connection("F", "D"));
      net.addConnection(new Connection("D", "H"));
      net.addConnection(new Connection("D", "G"));
      net.addConnection(new Connection("G", "I"));
      net.addConnection(new Connection("H", "F"));

      List<String> sol = net.getAllReachableLocations("A");
      assertEquals(6, sol.size());
      assertEquals(true, sol.contains("I"));
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("G"));
      assertEquals(true, sol.contains("H"));

      sol = net.getAllReachableLocations("B");
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("I"));
      assertEquals(true, sol.contains("G"));

      net.addConnection(new Connection("A", "F"));
      net.addConnection(new Connection("B", "D"));
      net.addConnection(new Connection("C", "E"));
      net.addConnection(new Connection("D", "C"));
      net.addConnection(new Connection("E", "A"));
      net.addConnection(new Connection("F", "E"));
      net.addConnection(new Connection("G", "A"));
      net.addConnection(new Connection("H", "B"));
      net.addConnection(new Connection("I", "C"));

      sol = net.getAllReachableLocations("A");
      assertEquals(9, sol.size());
      assertEquals(true, sol.contains("A"));
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("E"));
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("G"));
      assertEquals(true, sol.contains("H"));
      assertEquals(true, sol.contains("I"));
   }

   public void testNetworksGetAllReachableLocations06()
   {
      Networks net = new Networks();

      net.addConnection(new Connection("A", "C"));
      net.addConnection(new Connection("A", "K"));
      net.addConnection(new Connection("B", "C"));
      net.addConnection(new Connection("C", "I"));
      net.addConnection(new Connection("E", "K"));
      net.addConnection(new Connection("F", "D"));
      net.addConnection(new Connection("D", "B"));
      net.addConnection(new Connection("D", "K"));
      net.addConnection(new Connection("K", "I"));
      net.addConnection(new Connection("I", "F"));

      List<String> sol = net.getAllReachableLocations("D");
      assertEquals(6, sol.size());
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("I"));
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("K"));

      sol = net.getAllReachableLocations("K");
      assertEquals(6, sol.size());
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("I"));
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("K"));

      sol = net.getAllReachableLocations("E");
      assertEquals(6, sol.size());
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("I"));
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("K"));

      net.addConnection(new Connection("E", "A"));
      net.addConnection(new Connection("B", "E"));
      sol = net.getAllReachableLocations("F");
      assertEquals(true, sol.contains("A"));
      assertEquals(8, sol.size());
      assertEquals(true, sol.contains("E"));
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("I"));
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("K"));
   }

   public void testNetworksGetAllReachableLocations07()
   {
      Networks net = new Networks();

      net.addConnection(new Connection("A", "M"));
      net.addConnection(new Connection("M", "Z"));
      net.addConnection(new Connection("P", "Z"));
      net.addConnection(new Connection("A", "P"));
      net.addConnection(new Connection("D", "Z"));
      net.addConnection(new Connection("D", "P"));

      List<String> sol = net.getAllReachableLocations("A");
      assertEquals(3, sol.size());
      assertEquals(true, sol.contains("M"));
      assertEquals(true, sol.contains("Z"));
      assertEquals(true, sol.contains("P"));

      sol = net.getAllReachableLocations("M");
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("Z"));

      sol = net.getAllReachableLocations("Z");
      assertEquals(0, sol.size());

      net.addConnection(new Connection("Z", "M"));

      sol = net.getAllReachableLocations("Z");
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("M"));
      assertEquals(true, sol.contains("Z"));

      net.addConnection(new Connection("D", "A"));
      net.addConnection(new Connection("Z", "A"));
      net.addConnection(new Connection("M", "D"));

      sol = net.getAllReachableLocations("Z");
      assertEquals(5, sol.size());
      assertEquals(true, sol.contains("A"));
      assertEquals(true, sol.contains("M"));
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("P"));
      assertEquals(true, sol.contains("Z"));
   }

   public void testNetworks02And05All08()
   {
      testNetworksGetReachableLocationsOneStep02();
      testNetworksGetAllReachableLocations05();

      Networks net = new Networks();
      net.addConnection(new Connection("A", "A"));
      net.addConnection(new Connection("C", "C"));
      net.addConnection(new Connection("D", "D"));
      net.addConnection(new Connection("B", "B"));
      net.addConnection(new Connection("E", "E"));

      List<String> sol = net.getReachableLocations("A", 1);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("A"));

      sol = net.getReachableLocations("C", 1);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("C"));

      sol = net.getAllReachableLocations("D");
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("D"));
   }

   public void testNetworks03And06All09()
   {
      testNetworksGetReachableLocationsTwoOrThreeSteps03();
      testNetworksGetAllReachableLocations06();

      Networks net = new Networks();
      net.addConnection(new Connection("A", "B"));
      net.addConnection(new Connection("B", "A"));
      net.addConnection(new Connection("C", "D"));
      net.addConnection(new Connection("D", "C"));
      net.addConnection(new Connection("F", "E"));
      net.addConnection(new Connection("E", "F"));

      List<String> sol = net.getReachableLocations("A", 1);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("B"));

      sol = net.getReachableLocations("A", 2);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("A"));

      sol = net.getAllReachableLocations("F");
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("E"));

      net.addConnection(new Connection("D", "F"));

      sol = net.getReachableLocations("D", 1);
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("F"));

      sol = net.getReachableLocations("D", 2);
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("E"));

      sol = net.getAllReachableLocations("F");
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("E"));

      sol = net.getAllReachableLocations("D");
      assertEquals(4, sol.size());
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("E"));
      assertEquals(true, sol.contains("D"));
      assertEquals(true, sol.contains("C"));
   }

   public void testNetworkS04And07All10()
   {
      testNetworksGetReachableLocationsFourSteps04();
      testNetworksGetAllReachableLocations07();

      Networks net = new Networks();
      net.addConnection(new Connection("A", "D"));
      net.addConnection(new Connection("A", "E"));
      net.addConnection(new Connection("E", "B"));
      net.addConnection(new Connection("B", "F"));
      net.addConnection(new Connection("F", "C"));
      net.addConnection(new Connection("C", "G"));

      List<String> sol = net.getReachableLocations("A", 1);
      assertEquals(2, sol.size());
      assertEquals(true, sol.contains("E"));
      assertEquals(true, sol.contains("D"));

      sol = net.getReachableLocations("E", 2);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("F"));

      sol = net.getReachableLocations("E", 3);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("C"));

      sol = net.getAllReachableLocations("G");
      assertEquals(0, sol.size());

      sol = net.getAllReachableLocations("B");
      assertEquals(3, sol.size());
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("G"));

      net.addConnection(new Connection("G", "F"));

      sol = net.getReachableLocations("A", 3);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("F"));

      sol = net.getReachableLocations("E", 5);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("F"));

      sol = net.getReachableLocations("F", 7);
      assertEquals(1, sol.size());
      assertEquals(true, sol.contains("C"));

      sol = net.getAllReachableLocations("G");
      assertEquals(3, sol.size());
      assertEquals(true, sol.contains("G"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("F"));

      sol = net.getAllReachableLocations("B");
      assertEquals(3, sol.size());
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("G"));

      sol = net.getAllReachableLocations("E");
      assertEquals(4, sol.size());
      assertEquals(true, sol.contains("F"));
      assertEquals(true, sol.contains("B"));
      assertEquals(true, sol.contains("C"));
      assertEquals(true, sol.contains("G"));
   }
   public void testFunWith1DArrays01()
   {
      FunWith1DArrays fa = new FunWith1DArrays();
      int[] num1 = {1, 2, 8, 16, 48};
      int[] num2 = {1, -2, 6, -32, 1024};
      int[] num3 = {1, 3, -27, 108, -216, 1064};
      int[] num4 = {1, 3, 81, 160, 320, 960};

      assertEquals(true, fa.hasMultiplicativeProperty(num1));
      assertEquals(false, fa.hasMultiplicativeProperty(num2));
      assertEquals(true, fa.hasMultiplicativeProperty(num1));
      assertEquals(false, fa.hasMultiplicativeProperty(num4));

      int[] fib1 = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
      int[] fib2 = {1, 6, 7, 13, 20, 33, 53, 86, 138};
      int[] fib3 = {3, 27, 30, 57, 87, 144, 231, 375, 606, 981, 1587, 2568};

      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib1));
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib2));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib3));

      int[] split1 = {1, 8, 13, 21, 3, 4, 15, 8, 9};
      int[] spilt2 = {1, 22, 21, 4, 2, 11, 7, 6, 1, 8};
      int[] spilt3 = {1, 2, 1, 6, 22};

      assertEquals(5, fa.splitArray(split1));
      assertEquals(6, fa.splitArray(spilt2));
      assertEquals(-1, fa.splitArray(spilt3));

      int[] value1 = {1, 8, 13, 21, 3, 4, 15, 8, 9};
      int[] value2 = {22, 21, 407, 2, 11, 7, 6, -15, 8};

      assertEquals(21-1, fa.arrayAbsoluteValue(value1));
      assertEquals(407- -15, fa.arrayAbsoluteValue(value2));

      int[] value3 = {1, 16, 13, 8, 3, 4};
      int[] ans1 = fa.minAbsoluteValueCut(value3);
      assertEquals(1, ans1.length);
      assertEquals(1, ans1[0]);

      int[] value4 = {22, 21, 8};
      int[] ans2 = fa.minAbsoluteValueCut(value4);
      assertEquals(1, ans2.length);
      assertEquals(2, ans2[0]);

      int[] value5 = {11, 16, 13, 14, 8, 3, 4, 5};
      int[] ans3 = fa.minAbsoluteValueCut(value5);
      assertEquals(2, ans3.length);
      assertEquals(true, ans3[0] == 4 || ans3[1] == 4);
      assertEquals(true, ans3[0] == 5 || ans3[1] == 5);
   }

   public void testFunWith1DArraysMultiplicativeProperty02()
   {
      FunWith1DArrays fa = new FunWith1DArrays();
      int[] num1 = {13, 26, -13*4, 13*8*6, -13*8*6*4};
      int[] num2 = {13, 26, -13*4, 13*8*6, -13*8*6*4+11};
      int[] num3 = {-5, 5*11, 5*11*13, -55*26, 55*26*17};
      int[] num4 = {-5, 5*11, 5*11*13, 55*26, -55*13*7};
      int[] num5 = {5, 5*11, 5*11*13, 55*26, 55*26*17, 26*17*11*5};
      int[] num6 = {1, 5, -5*11, 5*11*13, -55*26, -55*26*17, 26*17*11*5};
      int[] num7 = {1, 5, 5*11, 5*11*13, 55*26, 55*26*17, 13*17*55};

      assertEquals(true, fa.hasMultiplicativeProperty(num1));
      assertEquals(false, fa.hasMultiplicativeProperty(num2));
      assertEquals(true, fa.hasMultiplicativeProperty(num3));
      assertEquals(false, fa.hasMultiplicativeProperty(num4));
      assertEquals(true, fa.hasMultiplicativeProperty(num5));
      assertEquals(true, fa.hasMultiplicativeProperty(num6));
      assertEquals(false, fa.hasMultiplicativeProperty(num7));
   }

   public void testFunWith1DArraysGeneralizedFibonacciSequence03()
   {
      FunWith1DArrays fa = new FunWith1DArrays();

      int[] fib1 = {2, 5, 7, 12, 19, 31, 50, 81};
      int[] fib2 = {16, 73, 89, 162, 251, 413, 664};
      int[] fib3 = {27, 30, 57, 87, 144, 231, 375, 606, 981, 1587, 2568};

      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib1));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib2));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib3));

      fib1[0] = 1;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib1));
      fib1[0] = 2;
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib1));

      fib2[1] = 72;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib2));
      fib2[1] = 73;
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib2));

      fib3[2] = 56;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib3));
      fib3[2] = 57;
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib3));

      fib3[10] = 2569;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib3));
      fib3[10] = 2568;
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib3));

      int[] fib4 = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765};
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib4));

      fib4[fib4.length-1] = 6766;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib4));
      fib4[fib4.length-1] = 6765;
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib4));
   }


/*
 *    Find the index in the array which would split the array such that
 *    the product of all elements before the index is strictly greater than
 *    the product of remaining elements in the array starting at the index (includes the index).
 *    You should return the smallest such index.
 *    
 *    If no such index exist, return -1;
 */
   public void testFunWith1DArraysSplitArray04()
   {
      FunWith1DArrays fa = new FunWith1DArrays();

      int[] split1 = {11, 130, 21, 13, 4, 0};
      assertEquals(1, fa.splitArray(split1));
      split1[5] = 1;
      assertEquals(2, fa.splitArray(split1));

      int[] spilt2 = {0, 1, 1, 1, 1, 1};
      assertEquals(-1, fa.splitArray(spilt2));

      spilt2[0] = 4;
      assertEquals(1, fa.splitArray(spilt2));

      spilt2[1] = 4;
      assertEquals(2, fa.splitArray(spilt2));

      spilt2[2] = 16;
      assertEquals(3, fa.splitArray(spilt2));

      spilt2[3] = 256;
      assertEquals(4, fa.splitArray(spilt2));

      spilt2[4] = 1024;
      assertEquals(4, fa.splitArray(spilt2));

      spilt2[5] = 24;
      assertEquals(4, fa.splitArray(spilt2));

      spilt2[1] = 1;
      assertEquals(5, fa.splitArray(spilt2));
   }

/*
 *   The absolute value of an array is defined to be the maximum value of the array minus the minimum value of the array.
 *   
 *   return the absolute value of an array.
 *
 *   You may assume the array is not empty.
 *   The absolute value of an array with one element is defined to be 0.
 */
   public void testFunWith1DArrayAbsoluteValue05()
   {
      FunWith1DArrays fa = new FunWith1DArrays();

      int[] value1 = {1, 8, -13, 21, 3, 4, 15, 98, 9};
      assertEquals(98 - -13, fa.arrayAbsoluteValue(value1));

      int[] value2 = {322, 21, 40, 2, 11, 7, 6, -158};
      assertEquals(322 - -158, fa.arrayAbsoluteValue(value2));

      int[] value3 = {-322, 21, 40, 2, 11, 158};
      assertEquals(158 - -322, fa.arrayAbsoluteValue(value3));

      value3[1] = -400;
      assertEquals(158 - -400, fa.arrayAbsoluteValue(value3));

      value3[2] = -410;
      assertEquals(158 - -410, fa.arrayAbsoluteValue(value3));

      value3[3] = -415;
      assertEquals(158 - -415, fa.arrayAbsoluteValue(value3));

      value3[4] = -435;
      assertEquals(158 - -435, fa.arrayAbsoluteValue(value3));

      value3[5] = -445;
      assertEquals(-322 - -445, fa.arrayAbsoluteValue(value3));

      value3[1] = 100;
      assertEquals(100 - -445, fa.arrayAbsoluteValue(value3));

      value3[2] = 410;
      assertEquals(410 - -445, fa.arrayAbsoluteValue(value3));

      value3[3] = 415;
      assertEquals(415 - -445, fa.arrayAbsoluteValue(value3));

      value3[4] = 435;
      assertEquals(435 - -445, fa.arrayAbsoluteValue(value3));
   }

/*
 *   find all indices such that the sum of
 *      (1) the absolute value of the values in the array before the index
 *      and (2) the absolute of the values from the index (that means including the value at the index) to the end is the smallest. 
 *
 *   You may assume the array is not empty.
 *   The absolute value of an array with one element is defined to be 0.
 */
   public void testFunWith1DArrayMinAbsoluteValueCut06()
   {
      FunWith1DArrays fa = new FunWith1DArrays();

      int[] value3 = {15, 16, 13, 8, 3, 14};
      int[] ans1 = fa.minAbsoluteValueCut(value3);
      assertEquals(1, ans1.length);
      assertEquals(2, ans1[0]);

      int[] value4 = {22, 2, 8};
      int[] ans2 = fa.minAbsoluteValueCut(value4);
      assertEquals(1, ans2.length);
      assertEquals(1, ans2[0]);

      int[] value1 = {15, 13, 16, 8, 3, 10};
      ans1 = fa.minAbsoluteValueCut(value1);
      assertEquals(1, ans1.length);
      assertEquals(3, ans1[0]);

      int[] value2 = {15, 10, 16, 8, 13, 9, 14};
      ans1 = fa.minAbsoluteValueCut(value2);
      assertEquals(2, ans1.length);
      assertEquals(true, 1 == ans1[0] || 6 == ans1[0]);
      assertEquals(true, 1 == ans1[1] || 6 == ans1[1]);
      assertEquals(true, ans1[0] != ans1[1]);

      int[] value5 = {25, 30, 31, 28, 23, 29, 24};
      ans1 = fa.minAbsoluteValueCut(value5);
      assertEquals(2, ans1.length);
      assertEquals(true, 1 == ans1[0] || 6 == ans1[0]);
      assertEquals(true, 1 == ans1[1] || 6 == ans1[1]);
      assertEquals(true, ans1[0] != ans1[1]);

      int[] value6 = {25, 22, 23, 24, 26, 27, 25};
      ans1 = fa.minAbsoluteValueCut(value6);
      assertEquals(3, ans1.length);
      assertEquals(true, 1 == ans1[0] || 4 == ans1[0] || 6 == ans1[0]);
      assertEquals(true, 1 == ans1[1] || 4 == ans1[1] || 6 == ans1[1]);
      assertEquals(true, 1 == ans1[2] || 4 == ans1[2] || 6 == ans1[2]);
      assertEquals(true, ans1[0] != ans1[1] && ans1[0] != ans1[2] && ans1[2] != ans1[1]);
   }

   public void testFunWith1DArraysMultiplicativeAndFibonacciAndSplitArray07()
   {
      testFunWith1DArraysMultiplicativeProperty02();
      testFunWith1DArraysGeneralizedFibonacciSequence03();
      testFunWith1DArraysSplitArray04();

      FunWith1DArrays fa = new FunWith1DArrays();
      int[] num1 = {0, 2, 8, 16, 48};
      int[] num2 = {1, -2, 6, -32, 0};

      assertEquals(false, fa.hasMultiplicativeProperty(num1));
      num1[0] = -1;
      assertEquals(true, fa.hasMultiplicativeProperty(num1));
      assertEquals(false, fa.hasMultiplicativeProperty(num2));

      int[] fib1 = {0, 0, 0, 0, 0, 0};
      int[] fib2 = {-1, -6, -7, -13, -20, -33, -53, -86};
      int[] fib3 = {-3, 27, 24, 51, 75, 126, 201, 327, 528};

      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib1));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib2));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib3));
      fib3[0]=3;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib3));

      int[] split1 = {11, 0, 21, 13, 4, 0};
      assertEquals(1, fa.splitArray(split1));
      split1[5] = 1;
      split1[1] = 1;
      assertEquals(3, fa.splitArray(split1));
      split1[2] = 1;
      split1[4] = 30;
      assertEquals(4, fa.splitArray(split1));
      split1[4] = 3;
      split1[5] = 300;
      assertEquals(5, fa.splitArray(split1));
   }

   public void testFunWith1DArraysMultiplicativeAndFibonacciAndSplitAndAbsoluteValue08()
   {
      testFunWith1DArraysMultiplicativeProperty02();
      testFunWith1DArraysGeneralizedFibonacciSequence03();
      testFunWith1DArraysSplitArray04();
      testFunWith1DArrayAbsoluteValue05();

      FunWith1DArrays fa = new FunWith1DArrays();
      int[] num1 = {0, 1, 2, 8, 16, 48};
      int[] num2 = {1, -2, 8, -32, 1024};

      assertEquals(false, fa.hasMultiplicativeProperty(num1));
      assertEquals(true, fa.hasMultiplicativeProperty(num2));
      num2[3] = 0;
      assertEquals(false, fa.hasMultiplicativeProperty(num2));
      num2[3] = 32;
      num2[4] = 0;
      assertEquals(false, fa.hasMultiplicativeProperty(num2));

      int[] fib1 = {0, 7, 7, 14, 21, 35, 56, 91, 147, 238, 385};
      int[] fib2 = {-10, 6, -4, 2, -2, 0, -2, -2, -4, -6, -10};
      int[] fib3 = {-13, 7, -6, 1, -5, -4, -9, -13, -22, -35};

      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib1));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib2));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib3));

      fib1[5] = 34;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib1));
      fib2[10] = 10;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib2));
      fib3[9] = -21;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib3));

      int[] split1 = {11, 8, 13, 21, 3, 4, 15, 8, 9};
      int[] spilt2 = {12, 1, 8, 2, 1, 2, 6, 5, 1, 4};
      int[] spilt3 = {1, 1, 1, 2, 1, 2, 2, 5, 1, 4000};

      assertEquals(4, fa.splitArray(split1));
      assertEquals(6, fa.splitArray(spilt2));
      assertEquals(-1, fa.splitArray(spilt3));

      int[] value1 = {-1, 8, 13, 21, 3, 4, 15, 8, 99};
      int[] value2 = {22, 21, 407, 2, 11, 7, 6, 15, -88};

      assertEquals(99 - -1, fa.arrayAbsoluteValue(value1));
      assertEquals(407 - -88, fa.arrayAbsoluteValue(value2));
   }

   public void testFunWith1DArraysMultiplicativeAndFibonacci09()
   {
      testFunWith1DArraysMultiplicativeProperty02();
      testFunWith1DArraysGeneralizedFibonacciSequence03();

      FunWith1DArrays fa = new FunWith1DArrays();
      int[] num1 = {1, 2, 8, 16, 8};
      int[] num2 = {1, -2, 8, -32, 1024, 2048, 4096};

      assertEquals(false, fa.hasMultiplicativeProperty(num1));
      assertEquals(true, fa.hasMultiplicativeProperty(num2));
      num2[3] = 0;
      assertEquals(false, fa.hasMultiplicativeProperty(num2));

      int[] fib1 = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
      int[] fib2 = {-1, 1, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
      int[] fib3 = {-3, 2, -1, 1, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34};

      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib1));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib2));
      assertEquals(true, fa.isGeneralizedFibonacciSequence(fib3));

      fib1[5] = 4;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib1));
      fib2[10] = 22;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib2));
      fib3[13] = 33;
      assertEquals(false, fa.isGeneralizedFibonacciSequence(fib3));
   }

   public void testFunWith1DArraysTestAll10()
   {
      testFunWith1DArraysMultiplicativeProperty02();
      testFunWith1DArraysGeneralizedFibonacciSequence03();
      testFunWith1DArraysSplitArray04();
      testFunWith1DArrayAbsoluteValue05();
      testFunWith1DArrayMinAbsoluteValueCut06();
      testFunWith1DArraysMultiplicativeAndFibonacciAndSplitArray07();
      testFunWith1DArraysMultiplicativeAndFibonacciAndSplitAndAbsoluteValue08();
      testFunWith1DArraysMultiplicativeAndFibonacci09();

      FunWith1DArrays fa = new FunWith1DArrays();

      int[] value3 = {5, 6, 4, 8, 3, 7};
      int[] ans1 = fa.minAbsoluteValueCut(value3);
      assertEquals(2, ans1.length);
      Arrays.sort(ans1);
      assertEquals(1, ans1[0]);
      assertEquals(5, ans1[1]);

      int[] value4 = {2, 2, 2, 2, 2, 2, 2};
      int[] ans2 = fa.minAbsoluteValueCut(value4);
      assertEquals(6, ans2.length);
      Arrays.sort(ans2);
      assertEquals(1, ans2[0]);
      assertEquals(2, ans2[1]);
      assertEquals(3, ans2[2]);
      assertEquals(4, ans2[3]);
      assertEquals(5, ans2[4]);
      assertEquals(6, ans2[5]);

      int[] value1 = {-11, -13, -16, 8, -3, -10};
      ans1 = fa.minAbsoluteValueCut(value1);
      assertEquals(1, ans1.length);
      assertEquals(3, ans1[0]);

      int[] value2 = {-15, -20, 16, 8, 13, 9};
      ans1 = fa.minAbsoluteValueCut(value2);
      assertEquals(1, ans1.length);
      assertEquals(2, ans1[0]);

      int[] value5 = {25, 30, 23, 28, 24, -29, -24};
      ans1 = fa.minAbsoluteValueCut(value5);
      assertEquals(1, ans1.length);
      assertEquals(5, ans1[0]);
   }
   public void testContractBridge01()
   {
      ArrayList<Card> hand = new ArrayList<Card>();
      hand.add( new Card("K", "S"));
      hand.add( new Card("Q", "S"));
      hand.add( new Card("10", "H"));
      hand.add( new Card("8", "H"));
      hand.add( new Card("4", "H"));
      hand.add( new Card("A", "C"));
      hand.add( new Card("Q", "C"));
      hand.add( new Card("10", "C"));
      hand.add( new Card("5", "C"));
      hand.add( new Card("K", "D"));
      hand.add( new Card("Q", "D"));
      hand.add( new Card("J", "D"));
      hand.add( new Card("8", "D"));
      ContractBridge cb = new ContractBridge(hand);

      assertEquals(17, cb.getPoints());
      assertEquals("D", cb.getSuit());
   }

/*
 *    rule 2   -1   - King in suit with no additional cards in suit
 *                       (that is, King is the only card in that suit)
 *    rule 6   +2   - for each suit of which the hand contains exactly one card
 */
   public void testContractBridgeRule1AndRule2AndRule6Only_02()
   {
      ArrayList<Card> hand = new ArrayList<Card>();
      /*  0 */ hand.add( new Card("A", "S"));
      /*  1 */ hand.add( new Card("A", "H"));
      /*  2 */ hand.add( new Card("K", "C"));
      /*  3 */ hand.add( new Card("9", "D"));
      /*  4 */ hand.add( new Card("8", "S"));
      /*  5 */ hand.add( new Card("7", "D"));
      /*  6 */ hand.add( new Card("7", "H"));
      /*  7 */ hand.add( new Card("6", "D"));
      /*  8 */ hand.add( new Card("5", "H"));
      /*  9 */ hand.add( new Card("4", "S"));
      /* 10 */ hand.add( new Card("2", "D"));
      /* 11 */ hand.add( new Card("3", "S"));
      /* 12 */ hand.add( new Card("A", "D"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals(4*3+3-1*1+2, cb.getPoints());

      hand.set(2, new Card("K", "S") );
      hand.set(0, new Card("A", "C") );
      hand.set(4, new Card("8", "C") );
      hand.set(9, new Card("4", "C") );
      hand.set(11, new Card("3", "C") );
      cb = new ContractBridge(hand);
      assertEquals(4*3+3-1*1+2, cb.getPoints());

      hand.set(2, new Card("K", "D") );
      hand.set(3, new Card("9", "S") );
      hand.set(4, new Card("7", "S") );
      hand.set(5, new Card("6", "S") );
      hand.set(10, new Card("2", "S") );
      hand.set(12, new Card("A", "S") );
      cb = new ContractBridge(hand);
      assertEquals(4*3+3-1*1+2, cb.getPoints());

      hand.set(2, new Card("K", "H") );
      hand.set(1, new Card("A", "D") );
      hand.set(6, new Card("7", "D") );
      hand.set(7, new Card("6", "D") );
      cb = new ContractBridge(hand);
      assertEquals(4*3+3-1*1+2, cb.getPoints());
   }

/*
 *    rule 6   +2   - for each suit of which the hand contains exactly one card
 */
   public void testContractBridgeRule1AndRule6_03()
   {
      ArrayList<Card> hand = new ArrayList<Card>();
      /*  0 */ hand.add( new Card("A", "S"));
      /*  1 */ hand.add( new Card("K", "S"));
      /*  2 */ hand.add( new Card("K", "H"));
      /*  3 */ hand.add( new Card("Q", "H"));
      /*  4 */ hand.add( new Card("Q", "C"));
      /*  5 */ hand.add( new Card("Q", "D"));
      /*  6 */ hand.add( new Card("10", "C"));
      /*  7 */ hand.add( new Card("9", "D"));
      /*  8 */ hand.add( new Card("9", "H"));
      /*  9 */ hand.add( new Card("8", "S"));
      /* 10 */ hand.add( new Card("8", "D"));
      /* 11 */ hand.add( new Card("5", "S"));
      /* 12 */ hand.add( new Card("2", "D"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals(4+3*2+2*3, cb.getPoints());

      hand.set(0, new Card("J", "S") );
      hand.set(1, new Card("J", "D") );
      hand.set(2, new Card("J", "H") );
      hand.set(4, new Card("Q", "S") );
      hand.set(6, new Card("10", "H") );
      hand.set(12, new Card("2", "C") );
      cb = new ContractBridge(hand);
      assertEquals(2*3+3+2, cb.getPoints());
   }

/*
 *    rule 3   -1   - Queen in suit with one or fewer additional cards in suit
 *                       (that is, only two cards in suit counting queen)
 *    rule 5   +1   - for each suit of which the hand contains exactly two cards
 *    rule 6   +2   - for each suit of which the hand contains exactly one card
 */
   public void testContractBridgeRule1AndRule3AndRule5AndRule6_04()
   {
      ArrayList<Card> hand = new ArrayList<Card>();
      /*  0 */ hand.add( new Card("Q", "H"));
      /*  1 */ hand.add( new Card("Q", "S"));
      /*  2 */ hand.add( new Card("10", "H"));
      /*  3 */ hand.add( new Card("8", "D"));
      /*  4 */ hand.add( new Card("7", "D"));
      /*  5 */ hand.add( new Card("2", "C"));
      /*  6 */ hand.add( new Card("9", "C"));
      /*  7 */ hand.add( new Card("10", "C"));
      /*  8 */ hand.add( new Card("5", "D"));
      /*  9 */ hand.add( new Card("3", "D"));
      /* 10 */ hand.add( new Card("5", "D"));
      /* 11 */ hand.add( new Card("6", "C"));
      /* 12 */ hand.add( new Card("8", "D"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals(2*2-1-1+2+1, cb.getPoints());

      hand.set(0, new Card("Q", "S") );
      hand.set(1, new Card("Q", "H") );
      hand.set(2, new Card("10", "S") );
      cb = new ContractBridge(hand);
      assertEquals(2*2-1-1+2+1, cb.getPoints());

      hand = new ArrayList<Card>();
      /*  0 */ hand.add( new Card("Q", "C"));
      /*  1 */ hand.add( new Card("Q", "D"));
      /*  2 */ hand.add( new Card("10", "C"));
      /*  3 */ hand.add( new Card("8", "S"));
      /*  4 */ hand.add( new Card("7", "S"));
      /*  5 */ hand.add( new Card("2", "H"));
      /*  6 */ hand.add( new Card("9", "H"));
      /*  7 */ hand.add( new Card("10", "H"));
      /*  8 */ hand.add( new Card("5", "S"));
      /*  9 */ hand.add( new Card("3", "S"));
      /* 10 */ hand.add( new Card("5", "S"));
      /* 11 */ hand.add( new Card("6", "H"));
      /* 12 */ hand.add( new Card("8", "S"));
      cb = new ContractBridge(hand);
      assertEquals(2*2-1-1+2+1, cb.getPoints());

      hand.set(0, new Card("Q", "D") );
      hand.set(1, new Card("Q", "C") );
      hand.set(2, new Card("10", "D") );
      cb = new ContractBridge(hand);
      assertEquals(2*2-1-1+2+1, cb.getPoints());
   }

/*
 *    rule 4   -1   - Jack in suit with two or fewer additional cards in suit
 *                       (that is, only three cards in suit counting jack)
 *    rule 6   +2   - for each suit of which the hand contains exactly one card
 */
   public void testContractBridgeRule1AndRule4AndAndRule6_05()
   {
      ArrayList<Card> hand = new ArrayList<Card>();
      /*   0 */ hand.add( new Card("J", "S"));
      /*   1 */ hand.add( new Card("J", "D"));
      /*   2 */ hand.add( new Card("10", "H"));
      /*   3 */ hand.add( new Card("8", "H"));
      /*   4 */ hand.add( new Card("4", "H"));
      /*   5 */ hand.add( new Card("9", "C"));
      /*   6 */ hand.add( new Card("4", "C"));
      /*   7 */ hand.add( new Card("10", "C"));
      /*   8 */ hand.add( new Card("5", "C"));
      /*   9 */ hand.add( new Card("3", "H"));
      /*  10 */ hand.add( new Card("7", "C"));
      /*  11 */ hand.add( new Card("6", "H"));
      /*  12 */ hand.add( new Card("8", "C"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals(1+1-1-1+2+2, cb.getPoints());

      hand = new ArrayList<Card>();
      /*   0 */ hand.add( new Card("J", "C"));
      /*   1 */ hand.add( new Card("J", "H"));
      /*   2 */ hand.add( new Card("10", "D"));
      /*   3 */ hand.add( new Card("8", "D"));
      /*   4 */ hand.add( new Card("4", "D"));
      /*   5 */ hand.add( new Card("9", "D"));
      /*   6 */ hand.add( new Card("4", "D"));
      /*   7 */ hand.add( new Card("10", "D"));
      /*   8 */ hand.add( new Card("5", "D"));
      /*   9 */ hand.add( new Card("3", "H"));
      /*  10 */ hand.add( new Card("7", "D"));
      /*  11 */ hand.add( new Card("6", "H"));
      /*  12 */ hand.add( new Card("8", "S"));
      cb = new ContractBridge(hand);
      assertEquals(1+1-1-1+2+2, cb.getPoints());
   }

/*
 *    rule 7   +3   - for each suit of which the hand contains exactly zero card
 */
   public void testContractBridgeRule1AndRule7_06()
   {
      ArrayList<Card> hand = new ArrayList<Card>();
      /*   0 */ hand.add( new Card("J", "S"));
      /*   1 */ hand.add( new Card("J", "D"));
      /*   2 */ hand.add( new Card("J", "H"));
      /*   3 */ hand.add( new Card("K", "S"));
      /*   4 */ hand.add( new Card("K", "D"));
      /*   5 */ hand.add( new Card("K", "H"));
      /*   6 */ hand.add( new Card("Q", "D"));
      /*   7 */ hand.add( new Card("9", "D"));
      /*   8 */ hand.add( new Card("8", "D"));
      /*   9 */ hand.add( new Card("7", "S"));
      /*  10 */ hand.add( new Card("6", "H"));
      /*  11 */ hand.add( new Card("5", "H"));
      /*  12 */ hand.add( new Card("5", "S"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals(1*3+3*3+2+3, cb.getPoints());   // No Club

      hand.set( 0, new Card("J", "C") );
      hand.set( 3, new Card("Q", "C") );
      hand.set( 9, new Card("7", "C") );
      hand.set(12, new Card("5", "C") );
      cb = new ContractBridge(hand);
      assertEquals(1*3+3*2+2*2+3, cb.getPoints());   // No Spades to Club

      hand.set( 2, new Card("J", "S") );
      hand.set( 5, new Card("A", "S") );
      hand.set(10, new Card("10", "S") );
      hand.set(11, new Card("5", "S") );
      cb = new ContractBridge(hand);
      assertEquals(4+1*3+3+2*2+3, cb.getPoints());   // No Heart to Spades

      hand.set( 1, new Card("A", "C") );
      hand.set( 4, new Card("K", "H") );
      hand.set( 6, new Card("Q", "H") );
      hand.set( 8, new Card("8", "H") );
      cb = new ContractBridge(hand);
      assertEquals(4+2*3+2+2*2+3, cb.getPoints());   // No Diamonds to Heats
   }

/*       
 *    rule 2   -1   - King in suit with no additional cards in suit
 *                       (that is, King is the only card in that suit)
 *    rule 3   -1   - Queen in suit with one or fewer additional cards in suit
 *                       (that is, only two cards in suit counting queen)
 *    rule 4   -1   - Jack in suit with two or fewer additional cards in suit
 *                       (that is, only three cards in suit counting jack)
 *    rule 5   +1   - for each suit of which the hand contains exactly two cards
 *    rule 6   +2   - for each suit of which the hand contains exactly one card
 *    rule 7   +3   - for each suit of which the hand contains exactly zero card
 */
   public void testContractBridgeRule1_07()
   {
      ArrayList<Card> hand = new ArrayList<Card>();

      /*   0 */ hand.add( new Card("A", "S"));
      /*   1 */ hand.add( new Card("K", "S"));
      /*   2 */ hand.add( new Card("Q", "S"));
      /*   3 */ hand.add( new Card("A", "H"));
      /*   4 */ hand.add( new Card("K", "H"));
      /*   5 */ hand.add( new Card("Q", "H"));
      /*   6 */ hand.add( new Card("A", "D"));
      /*   7 */ hand.add( new Card("K", "D"));
      /*   8 */ hand.add( new Card("Q", "D"));
      /*   9 */ hand.add( new Card("A", "C"));
      /*  10 */ hand.add( new Card("K", "C"));
      /*  11 */ hand.add( new Card("Q", "C"));
      /*  12 */ hand.add( new Card("8", "C"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals(4*4+3*4+2*4, cb.getPoints());

      hand.set( 12, new Card("J", "C") );
      cb = new ContractBridge(hand);
      assertEquals(4*4+3*4+2*4+1, cb.getPoints());

      hand.set(12, new Card("J", "S") );
      cb = new ContractBridge(hand);
      assertEquals(4*4+3*4+2*4+1, cb.getPoints());

      hand.set(12, new Card("J", "H") );
      cb = new ContractBridge(hand);
      assertEquals(4*4+3*4+2*4+1, cb.getPoints());
   }

/*
 *    rule 4   -1   - Jack in suit with two or fewer additional cards in suit
 *                       (that is, only three cards in suit counting jack)
 */
   public void testContractBridgeRule1AndRule4_08()
   {
      ArrayList<Card> hand = new ArrayList<Card>();

      /*   0 */ hand.add( new Card("2", "D"));
      /*   1 */ hand.add( new Card("3", "D"));
      /*   2 */ hand.add( new Card("4", "D"));
      /*   3 */ hand.add( new Card("5", "C"));
      /*   4 */ hand.add( new Card("6", "C"));
      /*   5 */ hand.add( new Card("7", "C"));
      /*   6 */ hand.add( new Card("8", "H"));
      /*   7 */ hand.add( new Card("9", "H"));
      /*   8 */ hand.add( new Card("2", "H"));
      /*   9 */ hand.add( new Card("7", "S"));
      /*  10 */ hand.add( new Card("5", "S"));
      /*  11 */ hand.add( new Card("2", "S"));
      /*  12 */ hand.add( new Card("5", "S"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals(0, cb.getPoints());

      hand.set(12, new Card("J", "S") );
      cb = new ContractBridge(hand);
      assertEquals(1, cb.getPoints());

      hand.set( 6, new Card("J", "H") );
      cb = new ContractBridge(hand);
      assertEquals(2-1, cb.getPoints());

      hand.set( 0, new Card("J", "D") );
      cb = new ContractBridge(hand);
      assertEquals(3-1-1, cb.getPoints());

      hand.set( 5, new Card("J", "C") );
      cb = new ContractBridge(hand);
      assertEquals(4-1-1-1, cb.getPoints());
   }

/*       
 * 
 *    rule 2   -1   - King in suit with no additional cards in suit
 *                       (that is, King is the only card in that suit)
 *    rule 3   -1   - Queen in suit with one or fewer additional cards in suit
 *                       (that is, only two cards in suit counting queen)
 *    rule 4   -1   - Jack in suit with two or fewer additional cards in suit
 *                       (that is, only three cards in suit counting jack)
 *    rule 5   +1   - for each suit of which the hand contains exactly two cards
 *    rule 6   +2   - for each suit of which the hand contains exactly one card
 *    rule 7   +3   - for each suit of which the hand contains exactly zero card
 */
   public void testContractBridgeGetSuitWithOutNoTrumpBids09()
   {
//  test 02
      ArrayList<Card> hand = new ArrayList<Card>();
      /*  0 */ hand.add( new Card("A", "S"));
      /*  1 */ hand.add( new Card("A", "H"));
      /*  2 */ hand.add( new Card("K", "C"));
      /*  3 */ hand.add( new Card("9", "D"));
      /*  4 */ hand.add( new Card("8", "S"));
      /*  5 */ hand.add( new Card("7", "D"));
      /*  6 */ hand.add( new Card("7", "H"));
      /*  7 */ hand.add( new Card("6", "D"));
      /*  8 */ hand.add( new Card("5", "H"));
      /*  9 */ hand.add( new Card("4", "S"));
      /* 10 */ hand.add( new Card("2", "D"));
      /* 11 */ hand.add( new Card("3", "S"));
      /* 12 */ hand.add( new Card("5", "D"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals("D", cb.getSuit());

// TEST 06
      hand = new ArrayList<Card>();
      /*   0 */ hand.add( new Card("J", "S"));
      /*   1 */ hand.add( new Card("J", "D"));
      /*   2 */ hand.add( new Card("J", "H"));
      /*   3 */ hand.add( new Card("K", "S"));
      /*   4 */ hand.add( new Card("K", "D"));
      /*   5 */ hand.add( new Card("K", "H"));
      /*   6 */ hand.add( new Card("Q", "D"));
      /*   7 */ hand.add( new Card("9", "D"));
      /*   8 */ hand.add( new Card("8", "D"));
      /*   9 */ hand.add( new Card("7", "S"));
      /*  10 */ hand.add( new Card("6", "H"));
      /*  11 */ hand.add( new Card("5", "H"));
      /*  12 */ hand.add( new Card("5", "S"));
      cb = new ContractBridge(hand);
      assertEquals("D", cb.getSuit());
      
// MORE TEST

      hand = new ArrayList<Card>();

      /*   0 */ hand.add( new Card("A", "D"));
      /*   1 */ hand.add( new Card("3", "D"));
      /*   2 */ hand.add( new Card("K", "D"));
      /*   3 */ hand.add( new Card("K", "C"));
      /*   4 */ hand.add( new Card("6", "C"));
      /*   5 */ hand.add( new Card("7", "C"));
      /*   6 */ hand.add( new Card("K", "H"));
      /*   7 */ hand.add( new Card("9", "H"));
      /*   8 */ hand.add( new Card("2", "H"));
      /*   9 */ hand.add( new Card("7", "S"));
      /*  10 */ hand.add( new Card("5", "S"));
      /*  11 */ hand.add( new Card("2", "S"));
      /*  12 */ hand.add( new Card("5", "S"));
      cb = new ContractBridge(hand);
      assertEquals(13, cb.getPoints());
      assertEquals("pass", cb.getSuit());

      hand.set(12, new Card("J", "S") );
      cb = new ContractBridge(hand);
      assertEquals("S", cb.getSuit());

      hand = new ArrayList<Card>();
      /*   0 */ hand.add( new Card("A", "D"));
      /*   1 */ hand.add( new Card("A", "S"));
      /*   2 */ hand.add( new Card("A", "C"));
      /*   3 */ hand.add( new Card("Q", "H"));
      /*   4 */ hand.add( new Card("6", "C"));
      /*   5 */ hand.add( new Card("7", "C"));
      /*   6 */ hand.add( new Card("8", "H"));
      /*   7 */ hand.add( new Card("9", "H"));
      /*   8 */ hand.add( new Card("2", "S"));
      /*   9 */ hand.add( new Card("7", "S"));
      /*  10 */ hand.add( new Card("5", "D"));
      /*  11 */ hand.add( new Card("2", "D"));
      /*  12 */ hand.add( new Card("5", "C"));
      cb = new ContractBridge(hand);
      assertEquals("C", cb.getSuit());

      hand.set(12, new Card("5", "H") );
      cb = new ContractBridge(hand);
      assertEquals("H", cb.getSuit());

      hand.set( 4, new Card("6", "S") );
      cb = new ContractBridge(hand);
      assertEquals("S", cb.getSuit());

      hand.set( 8, new Card("2", "D") );
      cb = new ContractBridge(hand);
      assertEquals("H", cb.getSuit());

      hand.set(12, new Card("5", "C") );
      hand.set( 1, new Card("A", "C") );
      cb = new ContractBridge(hand);
      assertEquals("D", cb.getSuit());

      hand.set(11, new Card("2", "C") );
      cb = new ContractBridge(hand);
      assertEquals("C", cb.getSuit());
   }

/*       
 * 
 *    rule 2   -1   - King in suit with no additional cards in suit
 *                       (that is, King is the only card in that suit)
 *    rule 3   -1   - Queen in suit with one or fewer additional cards in suit
 *                       (that is, only two cards in suit counting queen)
 *    rule 4   -1   - Jack in suit with two or fewer additional cards in suit
 *                       (that is, only three cards in suit counting jack)
 *    rule 5   +1   - for each suit of which the hand contains exactly two cards
 *    rule 6   +2   - for each suit of which the hand contains exactly one card
 *    rule 7   +3   - for each suit of which the hand contains exactly zero card
 */
   public void testContractBridgeGetSuitWithNoTrumpBids10()
   {
      testContractBridgeRule1AndRule2AndRule6Only_02();
      testContractBridgeRule1AndRule6_03();
      testContractBridgeRule1AndRule3AndRule5AndRule6_04();
      testContractBridgeRule1AndRule4AndAndRule6_05();
      testContractBridgeRule1AndRule7_06();
      testContractBridgeRule1_07();
      testContractBridgeRule1AndRule4_08();
      testContractBridgeGetSuitWithOutNoTrumpBids09();

      ArrayList<Card> hand = new ArrayList<Card>();

      hand = new ArrayList<Card>();
      /*  0 */ hand.add( new Card("A", "S"));
      /*  1 */ hand.add( new Card("A", "H"));
      /*  2 */ hand.add( new Card("A", "C"));
      /*  3 */ hand.add( new Card("A", "D"));
      /*  4 */ hand.add( new Card("9", "S"));
      /*  5 */ hand.add( new Card("8", "H"));
      /*  6 */ hand.add( new Card("7", "C"));
      /*  7 */ hand.add( new Card("6", "D"));
      /*  8 */ hand.add( new Card("5", "S"));
      /*  9 */ hand.add( new Card("4", "H"));
      /* 10 */ hand.add( new Card("3", "C"));
      /* 11 */ hand.add( new Card("2", "D"));
      /* 12 */ hand.add( new Card("2", "S"));
      ContractBridge cb = new ContractBridge(hand);
      assertEquals("no-trump", cb.getSuit());

      hand.set( 0, new Card("K", "S") );
      hand.set( 1, new Card("K", "H") );
      hand.set( 2, new Card("K", "C") );
      hand.set( 3, new Card("K", "D") );
      hand.set( 4, new Card("Q", "S") );
      hand.set( 5, new Card("Q", "H") );
      cb = new ContractBridge(hand);
      assertEquals("no-trump", cb.getSuit());

      hand.set( 0, new Card("Q", "S") );
      hand.set( 1, new Card("Q", "H") );
      hand.set( 2, new Card("Q", "C") );
      hand.set( 3, new Card("Q", "D") );
      hand.set( 4, new Card("A", "S") );
      hand.set( 5, new Card("A", "H") );
      cb = new ContractBridge(hand);
      assertEquals("no-trump", cb.getSuit());

      hand.set( 4, new Card("4", "S") );
      hand.set( 5, new Card("3", "H") );
      hand.set( 4, new Card("A", "C") );
      hand.set( 5, new Card("A", "D") );
      cb = new ContractBridge(hand);
      assertEquals("no-trump", cb.getSuit());
   }
/*
 *    escape sequences will NOT be contain in any password
 */
   public void testPasswordAnalyzer01()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals(false, pwa.isValid("pass word"));
      assertEquals(true, pwa.isValid("computer123456789ABC!!!!!"));

      assertEquals(3*2, pwa.getLengthBonus("brrrItIscold!!!!!"));
      assertEquals(7*2+ 6, pwa.getLengthBonus("computer123456789ABC!!!!!"));
      assertEquals(2*2, pwa.getLengthBonus("<#CS$$2004?>"));
      assertEquals(15, pwa.getLengthBonus("i.luv.programming"));
      assertEquals(19, pwa.getLengthBonus("<2015@Wittry@Contest>"));

      assertEquals(2+5, pwa.getUpperCaseBonus("<#CS$$2004?>"));
      assertEquals(5+5, pwa.getUpperCaseBonus("UPPERlower"));
      assertEquals(2+5, pwa.getUpperCaseBonus("CS12345678"));
      assertEquals(0+5, pwa.getUpperCaseBonus("i.luv.programming"));
      assertEquals(2+5, pwa.getUpperCaseBonus("<2015@Wittry@Contest>"));

      assertEquals(5+2, pwa.getDigitBonus("@Digit27"));
      assertEquals(4+5, pwa.getDigitBonus("<#CS$$2004?>"));
      assertEquals(0+5, pwa.getDigitBonus("i.luv.programming"));
      assertEquals(4+5, pwa.getDigitBonus("<2015@Wittry@Contest>"));

      assertEquals(5+3, pwa.getSymbolBonus("@Symbol!!"));
      assertEquals(6+5, pwa.getSymbolBonus("<#CS$$2004?>"));
      assertEquals(2+5, pwa.getSymbolBonus("i.luv.programming"));
      assertEquals(4+5, pwa.getSymbolBonus("<2015@Wittry@Contest>"));

      assertEquals(1, pwa.getCombinationBonus("@Symbol!!"));
      assertEquals(3, pwa.getCombinationBonus("<#CS$$2004?>"));
      assertEquals(2, pwa.getCombinationBonus("i.luv.programming"));
      assertEquals(4, pwa.getCombinationBonus("<2015@Wittry@Contest>"));

      assertEquals(50, pwa.getPoints("word"));
      assertEquals(50+4+7+9+11+3/*72*/, pwa.getPoints("<#CS$$2004?>"));
      assertEquals("rejected", pwa.getRating("word"));
      assertEquals(84, pwa.getPoints("i.luv.programming"));
      assertEquals(98, pwa.getPoints("<2015@Wittry@Contest>"));
      assertEquals("average", pwa.getRating("i.luv.programming"));
      assertEquals("good", pwa.getRating("<2015@Wittry@Contest>"));
   }

   public void testPasswordAnalyzerIsValid02()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals(false, pwa.isValid("passord"));
      assertEquals(false, pwa.isValid("passWord "));
      assertEquals(false, pwa.isValid("1passwor "));
      assertEquals(false, pwa.isValid(" p@ssWor"));
      assertEquals(false, pwa.isValid("passWord "));

      assertEquals(true, pwa.isValid("computeR"));
      assertEquals(true, pwa.isValid("c0mputer"));
      assertEquals(true, pwa.isValid("co^^putr"));
   }

   public void testPasswordAnalyzerLengthBonus03()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals(0, pwa.getLengthBonus("bookkeeper"));
      assertEquals(0, pwa.getLengthBonus("Bookkeer"));
      assertEquals((12-8)*2, pwa.getLengthBonus("#CSc<>2015<>"));
      assertEquals((13-8)*2, pwa.getLengthBonus("#CSc<<9>>2015<>"));
      assertEquals((15-8)*2+1, pwa.getLengthBonus("#CSc<2015><2015>"));
      assertEquals((15-8)*2+1+4, pwa.getLengthBonus("######CSc<2015><2015>1234"));
      assertEquals((15-8)*2+1+6/*21*/, pwa.getLengthBonus("######CSc<<2015>><2015><1234>"));
      assertEquals((15-8)*2+1+10, pwa.getLengthBonus("######CSci<<2015>>$$<2015>$$$$<1234>&&&&"));
      assertEquals((15-8)*2+1+10, pwa.getLengthBonus("######CSci<<2015!>>$$<2015@>$$$$<$1234%>&&&&"));
   }

/*
 *   Upper case bonus:  (total max = 10 points)
 *      Repeated Upper case letters are treated as separate letters (example “PASS” is 4 upper case letters)
 *   +1 for each upper case letter (max 5 points)
 *   +1 for each non upper case letter (lower case, numbers or symbols, max 5 points)
 */
   public void testPasswordAnalyzerUpperCaseBonus04()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals(0, pwa.getUpperCaseBonus("COMPUTERSCIENCE"));
      assertEquals(5, pwa.getUpperCaseBonus("#computers"));
      assertEquals(0, pwa.getUpperCaseBonus("UPPER"));
      assertEquals(2+5, pwa.getUpperCaseBonus("ComputerScience"));
      assertEquals(4+5, pwa.getUpperCaseBonus("#CCSSci<<2015!>>"));
      assertEquals(5+5, pwa.getUpperCaseBonus("@@COMP<2015>Sc"));
      assertEquals(5+5, pwa.getUpperCaseBonus("BOOK<2015>KEEPER"));
   }

/*
 *   Digit (number) Bonus (total max = 15 points)
 *   +1 for each digit contained in the password.  (The digits 10 counts as two numbers. Max of 10 points)
 *   +1 for each non digit (lower/upper case symbols, or symbols, max 5 points)
 *      Repeated non digits are counted seperately.  For example, AAA is three non digits
 */
   public void testPasswordAnalyzerDigitBonus05()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals(0, pwa.getDigitBonus("MMCXLVII"));
      assertEquals(5, pwa.getDigitBonus("MMCX%^VV"));
      assertEquals(4+4, pwa.getDigitBonus("MMis2000"));
      assertEquals(8+2, pwa.getDigitBonus("#2014v2015"));
      assertEquals(4+5, pwa.getDigitBonus("#2014=MMXIV"));
      assertEquals(7+1, pwa.getDigitBonus("2345678o"));
      assertEquals(10+5, pwa.getDigitBonus("&23456789101112WWWWWWWWWWWWW"));
   }

/*
 *   Symbol Bonus (total max = 15 points)
 *       A symbol is any character that is not a letter and not a digit/number
 *   +1 for each Symbol contained in the password.  (max 10 points)
 *   +1 for each non Symbol (lower/upper case letter, or digit, max 5 points)
 */
   public void testPasswordAnalyzerSymbolBonus06()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals(7+2, pwa.getSymbolBonus("e<<#2$$>>"));
      assertEquals(0, pwa.getSymbolBonus(">>"));
      assertEquals(9+2, pwa.getSymbolBonus("!@#$%Cs^&*("));
      assertEquals(10+2, pwa.getSymbolBonus(")_+=H;i<>?/:"));
      assertEquals(6+5, pwa.getSymbolBonus("[`i2]ff{}ff&"));
      assertEquals(0, pwa.getSymbolBonus("&)&_&%&^&*&{}"));
      assertEquals(10+2, pwa.getSymbolBonus("w&)&_&%&^&*&{}4"));
   }

/*
 *  Combination Bonus (total max = 10 points)
 *     A combination is defined to be any of the following
 *     -   Letter (upper of lower case) followed by a digit
 *     -   letter (upper of lower case) followed by a symbol
 *     -   Digit followed by a symbol
 *     -   Symbol followed by a digit
 *     The password containing “A7#” has two combinations
 *  +1 for each combination in the password.  (max 10 points)
 */
   public void testPasswordAnalyzerCombinationBonus07()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

//      assertEquals(false, true);
      assertEquals(4, pwa.getCombinationBonus("1#3@ymbol!!"));
      assertEquals(4, pwa.getCombinationBonus("CS$$200r4?>"));
      assertEquals(6, pwa.getCombinationBonus("1#x3@5ym!bol!!"));
      assertEquals(10, pwa.getCombinationBonus("1#x3@5ym!bol!=1#x3@5ym!bol!"));
   }
/*
 *    int points = 50;
 *    points += getLengthBonus(password);
 *    points += getUpperCaseBonus(password);
 *    points += getDigitBonus(password);
 *    points += getSymbolBonus(password);
 *    points += getCombinationBonus(password);
 */ 
   public void testPasswordAnalyzerGetPoints08()
   {
      testPasswordAnalyzerIsValid02();
      testPasswordAnalyzerLengthBonus03();
      testPasswordAnalyzerUpperCaseBonus04();
      testPasswordAnalyzerDigitBonus05();
      testPasswordAnalyzerSymbolBonus06();
      testPasswordAnalyzerCombinationBonus07();

      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals(50, pwa.getPoints("word"));
      assertEquals(50+(14-8)*2+(2+5)+(8+5)+(8+5)+4, pwa.getPoints("######CSc<2015>1234"));
      assertEquals(50+4+7+9+11+3+(0), pwa.getPoints("<#CS$$2004?>"));
      assertEquals(50+0+(5+3)+(1+5)+(2+5)+3, pwa.getPoints("COMPS<3>"));
      assertEquals(50+(15-8)*2+4+(5)+(1+5)+(6+5)+5, pwa.getPoints("#xyz!abc!#def@5ghi@"));
      assertEquals(50+(15-8)*2+7+(2+5)+(8+5)+(10+5)+5, pwa.getPoints("####CSci<<2015!>>$$$$<$1234%>&&&&"));
      assertEquals(50+0+(5+3)+(0+5)+(0+5)+0, pwa.getPoints("COMscien"));

      String pw = "ComScien";
      assertEquals(0, pwa.getLengthBonus(pw));
      assertEquals(2+5, pwa.getUpperCaseBonus(pw));
      assertEquals(0+5, pwa.getDigitBonus(pw));
      assertEquals(0+5, pwa.getSymbolBonus(pw));
      assertEquals(0, pwa.getCombinationBonus(pw));
      assertEquals(67, pwa.getPoints("ComScien"));
   }

   public void testPasswordAnalyzerGetRating09()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals("rejected", pwa.getRating("word"));
      assertEquals("unacceptable", pwa.getRating("ComScien"));
      assertEquals("average", pwa.getRating("COM#1scien15"));
      assertEquals("average", pwa.getRating("<#CS$$2004?>"));
      assertEquals("good", pwa.getRating("######CSc<2015>1234"));
      assertEquals("good", pwa.getRating("#xyz!abc!#def@5ghi@0"));
      assertEquals("weak", pwa.getRating("#COMscien"));
      assertEquals("excellent", pwa.getRating("0A####CompSci<<2015!>>$$$$<$01234%>&&&&"));
   }

/*
 *   Passwords that are not valid receive a rating of rejected.  
 *   Valid password with 70 or fewer points received a rating of unacceptable.
 *   Passwords receiving more than 70 points and 80 points or less receive a rating of weak.
 *   Passwords receiving more than 80 points and 95 points or less receive a rating of average.
 *   Passwords receiving more than 95 points and 115 points or less receive a rating of good.
 *   Passwords receiving more than 115 points receive a rating of excellent.
 */
   public void testPasswordAnalyzerGetRating10()
   {
      PasswordAnalyzer pwa = new PasswordAnalyzer();

      assertEquals("weak", pwa.getRating("notMyPassword"));
      assertEquals("average", pwa.getRating("00Password#2015"));
      assertEquals("good", pwa.getRating("1234567890m!@#$%^&*()"));
      assertEquals("excellent", pwa.getRating("{*Qwerty<(+)>2014-2015ASDFGH}"));
      assertEquals("unacceptable", pwa.getRating("myPassword"));
      assertEquals("rejected", pwa.getRating("1234567890"));
      assertEquals("weak", pwa.getRating("#COMscien"));
      assertEquals("excellent", pwa.getRating("0A####CompSci<<2015!>>$$$$<$01234%>&&&&"));
   }
}