import org.junit.Test;

import java.util.*;

/**
 * The test class Final2020Test.
 *
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class WittryFinal2020Test extends junit.framework.TestCase
{
    @Test
    public void testConsecutiveSums01()
    {
        int[] ans = ConsecutiveSums.theseIntsSumTo( 25, 2);
        assertEquals(2, ans.length);
        assertEquals(12, ans[0]);
        assertEquals(13, ans[1]);

        ans = ConsecutiveSums.fewestConsecutiveIntegersSumTo( 100 );
        assertEquals(5, ans.length);
        assertEquals(18, ans[0]);
        assertEquals(19, ans[1]);
        assertEquals(20, ans[2]);
        assertEquals(21, ans[3]);
        assertEquals(22, ans[4]);

        ans = ConsecutiveSums.longestConsecutiveIntegersSumTo( 200 );
        assertEquals(16, ans.length);
        assertEquals(5, ans[0]);
        assertEquals(6, ans[1]);
        assertEquals(7, ans[2]);
        assertEquals(8, ans[3]);
        assertEquals(9, ans[4]);
        assertEquals(10, ans[5]);
        assertEquals(11, ans[6]);
        assertEquals(12, ans[7]);
        assertEquals(13, ans[8]);
        assertEquals(14, ans[9]);
        assertEquals(15, ans[10]);
        assertEquals(16, ans[11]);
        assertEquals(17, ans[12]);
        assertEquals(18, ans[13]);
        assertEquals(19, ans[14]);
        assertEquals(20, ans[15]);

        assertEquals(2048, ConsecutiveSums.smallestNumberGreaterThan(2018));
    }

    public void testTheseIntsSumToOddTerms02()
    {
        int[] ans = ConsecutiveSums.theseIntsSumTo( 625, 5);
        assertEquals(5, ans.length);
        assertEquals(123, ans[0]);
        assertEquals(124, ans[1]);
        assertEquals(125, ans[2]);
        assertEquals(126, ans[3]);
        assertEquals(127, ans[4]);

        ans = ConsecutiveSums.theseIntsSumTo( 9153, 3);
        assertEquals(3, ans.length);
        assertEquals(3050, ans[0]);
        assertEquals(3051, ans[1]);
        assertEquals(3052, ans[2]);

        assertEquals(null,  ConsecutiveSums.theseIntsSumTo( 59153, 7));

        ans = ConsecutiveSums.theseIntsSumTo( 3500, 7);
        assertEquals(7, ans.length);
        assertEquals(497, ans[0]);
        assertEquals(498, ans[1]);
        assertEquals(499, ans[2]);
        assertEquals(500, ans[3]);
        assertEquals(501, ans[4]);
        assertEquals(502, ans[5]);
        assertEquals(503, ans[6]);
    }

    public void testTheseIntsSumToEvenTerms03()
    {
        int[] ans = ConsecutiveSums.theseIntsSumTo( 7419, 6);
        assertEquals(6, ans.length);
        assertEquals(1234, ans[0]);
        assertEquals(1235, ans[1]);
        assertEquals(1236, ans[2]);
        assertEquals(1237, ans[3]);
        assertEquals(1238, ans[4]);
        assertEquals(1239, ans[5]);

        ans = ConsecutiveSums.theseIntsSumTo( 9998+9999+10000+10001, 4);
        assertEquals(4, ans.length);
        assertEquals(9998, ans[0]);
        assertEquals(9999, ans[1]);
        assertEquals(10000, ans[2]);
        assertEquals(10001, ans[3]);

        ans = ConsecutiveSums.theseIntsSumTo( 5, 2);
        assertEquals(2, ans.length);
        assertEquals(2, ans[0]);
        assertEquals(3, ans[1]);
    }

    public void testFewestConsecutiveIntegersSumTo04()
    {
        int[] ans = ConsecutiveSums.fewestConsecutiveIntegersSumTo( 25987+25988 );
        assertEquals(""+(25987+25988) + "length", 2, ans.length);
        assertEquals(""+(25987+25988), 25987, ans[0]);
        assertEquals(""+(25987+25988), 25988, ans[1]);

        ans = ConsecutiveSums.fewestConsecutiveIntegersSumTo( 300 );
        assertEquals("300 length", 3, ans.length);
        assertEquals("300", 99, ans[0]);
        assertEquals("300", 100, ans[1]);
        assertEquals("300", 101, ans[2]);

        ans = ConsecutiveSums.fewestConsecutiveIntegersSumTo( 26482 );
        assertEquals("26482 length", 4, ans.length);
        assertEquals("26482", 6619, ans[0]);
        assertEquals("26482", 6620, ans[1]);
        assertEquals("26482", 6621, ans[2]);
        assertEquals("26482", 6622, ans[3]);
    }

    public void testFewestConsecutiveIntegersSumTo05()
    {
        int[] ans = ConsecutiveSums.fewestConsecutiveIntegersSumTo( 719563 );
        assertEquals("719563 length", 2, ans.length);
        assertEquals("719563", 359781, ans[0]);
        assertEquals("719563", 359782, ans[1]);

        ans = ConsecutiveSums.fewestConsecutiveIntegersSumTo( 22 );
        assertEquals("22 length", 4, ans.length);
        assertEquals("22", 4, ans[0]);
        assertEquals("22", 5, ans[1]);
        assertEquals("22", 6, ans[2]);
        assertEquals("22", 7, ans[3]);

        ans = ConsecutiveSums.fewestConsecutiveIntegersSumTo( 200024 );
        assertEquals("200024 length", 11, ans.length);
        assertEquals("200024", 18179, ans[0]);
        assertEquals("200024", 18180, ans[1]);
        assertEquals("200024", 18181, ans[2]);
        assertEquals("200024", 18182, ans[3]);
        assertEquals("200024", 18183, ans[4]);
        assertEquals("200024", 18184, ans[5]);
        assertEquals("200024", 18185, ans[6]);
        assertEquals("200024", 18186, ans[7]);
        assertEquals("200024", 18187, ans[8]);
        assertEquals("200024", 18188, ans[9]);
        assertEquals("200024", 18189, ans[10]);
    }

    public void testLongestConsecutiveIntegersSumTo06()
    {
        int[] ans = ConsecutiveSums.longestConsecutiveIntegersSumTo( 41 );
        assertEquals("41 length", 2, ans.length);
        assertEquals("41", 20, ans[0]);
        assertEquals("41", 21, ans[1]);

        ans = ConsecutiveSums.longestConsecutiveIntegersSumTo( 517 );
        assertEquals("517 length", 22, ans.length);
        assertEquals("517", 13, ans[0]);
        assertEquals("517", 14, ans[1]);
        assertEquals("517", 15, ans[2]);
        assertEquals("517", 16, ans[3]);
        assertEquals("517", 17, ans[4]);
        assertEquals("517", 18, ans[5]);
        assertEquals("517", 19, ans[6]);
        assertEquals("517", 20, ans[7]);
        assertEquals("517", 21, ans[8]);
        assertEquals("517", 22, ans[9]);
        assertEquals("517", 23, ans[10]);
        assertEquals("517", 24, ans[11]);
        assertEquals("517", 25, ans[12]);
        assertEquals("517", 26, ans[13]);
        assertEquals("517", 27, ans[14]);
        assertEquals("517", 28, ans[15]);
        assertEquals("517", 29, ans[16]);
        assertEquals("517", 30, ans[17]);
        assertEquals("517", 31, ans[18]);
        assertEquals("517", 32, ans[19]);
        assertEquals("517", 33, ans[20]);
        assertEquals("517", 34, ans[21]);

        assertEquals("357 length", 21, ConsecutiveSums.longestConsecutiveIntegersSumTo( 357 ).length);
        assertEquals("307 length", 2, ConsecutiveSums.longestConsecutiveIntegersSumTo( 307 ).length);
    }

    public void testLongestConsecutiveIntegersSumTo07()
    {
        int[] ans = ConsecutiveSums.longestConsecutiveIntegersSumTo( 306 );
        assertEquals("306 length", 17, ans.length);
        assertEquals("517", 10, ans[0]);
        assertEquals("517", 11, ans[1]);
        assertEquals("517", 12, ans[2]);
        assertEquals("517", 13, ans[3]);
        assertEquals("517", 14, ans[4]);
        assertEquals("517", 15, ans[5]);
        assertEquals("517", 16, ans[6]);
        assertEquals("517", 17, ans[7]);
        assertEquals("517", 18, ans[8]);
        assertEquals("517", 19, ans[9]);
        assertEquals("517", 20, ans[10]);
        assertEquals("517", 21, ans[11]);
        assertEquals("517", 22, ans[12]);
        assertEquals("517", 23, ans[13]);
        assertEquals("517", 24, ans[14]);
        assertEquals("517", 25, ans[15]);
        assertEquals("517", 26, ans[16]);

        ans = ConsecutiveSums.longestConsecutiveIntegersSumTo( 38 );
        assertEquals("38 length", 4, ans.length);
        assertEquals("38", 8, ans[0]);
        assertEquals("38", 9, ans[1]);
        assertEquals("38", 10, ans[2]);
        assertEquals("38", 11, ans[3]);

        ans = ConsecutiveSums.longestConsecutiveIntegersSumTo( 66 );
        assertEquals("66 length", 11, ans.length);
        assertEquals("66", 1, ans[0]);
        assertEquals("66", 2, ans[1]);
        assertEquals("66", 3, ans[2]);
        assertEquals("66", 4, ans[3]);
        assertEquals("66", 5, ans[4]);
        assertEquals("66", 6, ans[5]);
        assertEquals("66", 7, ans[6]);
        assertEquals("66", 8, ans[7]);
        assertEquals("66", 9, ans[8]);
        assertEquals("66", 10, ans[9]);
        assertEquals("66", 11, ans[10]);

        assertEquals("200 length", 16, ConsecutiveSums.longestConsecutiveIntegersSumTo( 200 ).length);
        assertEquals("1078 length", 44, ConsecutiveSums.longestConsecutiveIntegersSumTo( 1078 ).length);
    }

    public void testSmallestNumberGreaterThan08()
    {
        assertEquals("2018", 2048, ConsecutiveSums.smallestNumberGreaterThan(2018));
        assertEquals("18", 32, ConsecutiveSums.smallestNumberGreaterThan(18));
        assertEquals("100", 128, ConsecutiveSums.smallestNumberGreaterThan(100));
    }

    public void testSmallestNumberGreaterThan09()
    {
        assertEquals("999", 1024, ConsecutiveSums.smallestNumberGreaterThan(999));
        assertEquals("64", 128, ConsecutiveSums.smallestNumberGreaterThan(64));
        assertEquals("9", 16, ConsecutiveSums.smallestNumberGreaterThan(9));
    }

    public void testConsecutiveSums10()
    {
        assertEquals("8", null, ConsecutiveSums.longestConsecutiveIntegersSumTo( 8 ) );
        assertEquals("4", null, ConsecutiveSums.longestConsecutiveIntegersSumTo( 4 ) );

        assertEquals(null, ConsecutiveSums.theseIntsSumTo( 88, 5));
        
        int[] ans = ConsecutiveSums.theseIntsSumTo( 27+28+29+30+31, 5);
        assertEquals(5, ans.length);
        assertEquals(27, ans[0]);
        assertEquals(28, ans[1]);
        assertEquals(29, ans[2]);
        assertEquals(30, ans[3]);
        assertEquals(31, ans[4]);

        ans = ConsecutiveSums.fewestConsecutiveIntegersSumTo( 56 );
        assertEquals("56 length", 7, ans.length);
        assertEquals("56", 5, ans[0]);
        assertEquals("56", 6, ans[1]);
        assertEquals("56", 7, ans[2]);
        assertEquals("56", 8, ans[3]);
        assertEquals("56", 9, ans[4]);
        assertEquals("56", 10, ans[5]);
        assertEquals("56", 11, ans[6]);

        ans = ConsecutiveSums.longestConsecutiveIntegersSumTo( 27 );
        assertEquals("27 length", 6, ans.length);
        assertEquals("27", 2, ans[0]);
        assertEquals("27", 3, ans[1]);
        assertEquals("27", 4, ans[2]);
        assertEquals("27", 5, ans[3]);
        assertEquals("27", 6, ans[4]);
        assertEquals("27", 7, ans[5]);
        
        assertEquals(2, 4, ConsecutiveSums.smallestNumberGreaterThan(2));
    }

    public void testCubeIt01()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});

        assertEquals(3, c.getRightSide(1, 2));
        assertEquals(5, c.getRightSide(6, 4));

        assertEquals(true, c.isPossible(6, 4, 5));
        assertEquals(true, c.isPossible(1, 2, 3));

        c = new CubeIt( new int[] {1, 2, 3, 4, 5, 6});

        assertEquals(2, c.getRightSide(5, 3));

        assertEquals(false, c.isPossible(5, 3, 4));
        assertEquals(true, c.isPossible(5, 3, 2));

        c = new CubeIt( new int[] {1, 5, 2, 6, 3, 4});

        assertEquals(6, c.getRightSide(1, 2));
        assertEquals(1, c.getRightSide(5, 2));
        assertEquals(-1, c.getRightSide(5, 6));

        assertEquals(true, c.isPossible(1, 2, 6));
        assertEquals(true, c.isPossible(5, 2, 1));
        assertEquals(true, c.isPossible(4, 1, 6));
    }

    public void testIsPossible02()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("1 on top", true, c.isPossible(1, 2, 3));
        assertEquals("1 on top", true, c.isPossible(1, 3, 5));
        assertEquals("1 on top", true, c.isPossible(1, 5, 4));
        assertEquals("1 on top", true, c.isPossible(1, 4, 2));
        assertEquals("1 on top", false, c.isPossible(1, 6, 2));
    }

    public void testIsPossible03()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("2 on top", true, c.isPossible(2, 1, 4));
        assertEquals("2 on top", true, c.isPossible(2, 4, 6));
        assertEquals("2 on top", true, c.isPossible(2, 6, 3));
        assertEquals("2 on top", true, c.isPossible(2, 3, 1));
        assertEquals("2 on top", false, c.isPossible(2, 5, 1));
    }

    public void testIsPossible04()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("3 on top", true, c.isPossible(3, 1, 2));
        assertEquals("3 on top", true, c.isPossible(3, 2, 6));
        assertEquals("3 on top", true, c.isPossible(3, 6, 5));
        assertEquals("3 on top", true, c.isPossible(3, 5, 1));
        assertEquals("3 on top", false, c.isPossible(3, 4, 2));
    }

    public void testIsPossible05()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("4 on top", true, c.isPossible(4, 1, 5));
        assertEquals("4 on top", true, c.isPossible(4, 5, 6));
        assertEquals("4 on top", true, c.isPossible(4, 6, 2));
        assertEquals("4 on top", true, c.isPossible(4, 2, 1));
        assertEquals("4 on top", false, c.isPossible(4, 3, 2));
    }

    public void testIsPossible06()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("5 on top", true, c.isPossible(5, 1, 3));
        assertEquals("5 on top", true, c.isPossible(5, 3, 6));
        assertEquals("5 on top", true, c.isPossible(5, 6, 4));
        assertEquals("5 on top", true, c.isPossible(5, 4, 1));
        assertEquals("5 on top", false, c.isPossible(5, 2, 3));
    }

    public void testIsPossible07()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("6 on top", true, c.isPossible(6, 2, 4));
        assertEquals("6 on top", true, c.isPossible(6, 4, 5));
        assertEquals("6 on top", true, c.isPossible(6, 5, 3));
        assertEquals("6 on top", true, c.isPossible(6, 3, 2));
        assertEquals("6 on top", false, c.isPossible(6, 1, 3));
    }

    public void testGetRightSide08()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("1 on top", 3, c.getRightSide(1, 2));
        assertEquals("1 on top", 5, c.getRightSide(1, 3));
        assertEquals("1 on top", 4, c.getRightSide(1, 5));
        assertEquals("1 on top", 2, c.getRightSide(1, 4));
        assertEquals("1 on top", -1, c.getRightSide(1, 6));
    }

    public void testGetRightSide09()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("2 on top", 4, c.getRightSide(2, 1));
        assertEquals("2 on top", 6, c.getRightSide(2, 4));
        assertEquals("2 on top", 3, c.getRightSide(2, 6));
        assertEquals("2 on top", 1, c.getRightSide(2, 3));
        assertEquals("2 on top", -1, c.getRightSide(2, 5));
    }

    public void testGetRightSide10()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("3 on top", 2, c.getRightSide(3, 1));
        assertEquals("3 on top", 6, c.getRightSide(3, 2));
        assertEquals("3 on top", 5, c.getRightSide(3, 6));
        assertEquals("3 on top", 1, c.getRightSide(3, 5));
        assertEquals("3 on top", -1, c.getRightSide(3, 4));
    }

    public void testGetRightSide11()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("4 on top", 5, c.getRightSide(4, 1));
        assertEquals("4 on top", 6, c.getRightSide(4, 5));
        assertEquals("4 on top", 2, c.getRightSide(4, 6));
        assertEquals("4 on top", 1, c.getRightSide(4, 2));
        assertEquals("4 on top", -1, c.getRightSide(4, 3));
    }

    public void testGetRightSide12()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("5 on top", 3, c.getRightSide(5, 1));
        assertEquals("5 on top", 6, c.getRightSide(5, 3));
        assertEquals("5 on top", 4, c.getRightSide(5, 6));
        assertEquals("5 on top", 1, c.getRightSide(5, 4));
        assertEquals("5 on top", -1, c.getRightSide(5, 2));
    }

    public void testGetRightSide13()
    {
        CubeIt c = new CubeIt( new int[] {6, 4, 5, 3, 1, 2});
        assertEquals("6 on top", 4, c.getRightSide(6, 2));
        assertEquals("6 on top", 5, c.getRightSide(6, 4));
        assertEquals("6 on top", 3, c.getRightSide(6, 5));
        assertEquals("6 on top", 2, c.getRightSide(6, 3));
        assertEquals("6 on top", -1, c.getRightSide(6, 1));
    }
    
    public void testDecryptMe01()
    {
        assertEquals("111, 1", 3, DecryptMe.countLetter("111", 1));
        assertEquals("111, 11", 1, DecryptMe.countLetter("111", 11));
        assertEquals("110120, 2", 2, DecryptMe.countLetter("110120", 1));
        assertEquals("110120, 10", 1, DecryptMe.countLetter("110120", 10));
        assertEquals("110120, 11", 0, DecryptMe.countLetter("110120", 11));
        assertEquals("110120, 12", 0, DecryptMe.countLetter("110120", 12));
        assertEquals("110120, 20", 1, DecryptMe.countLetter("110120", 20));
        assertEquals("1020, 1", 0, DecryptMe.countLetter("1020", 1));
        assertEquals("1020, 2", 0, DecryptMe.countLetter("1020", 2));
        assertEquals("1020, 10", 1, DecryptMe.countLetter("1020", 10));
        assertEquals("1020, 20", 1, DecryptMe.countLetter("1020", 20));

        assertEquals("\"111\", [1, 2, 3, 23]", 3, DecryptMe.groupCounter("111", new int[] {1, 2, 3, 23}));
        assertEquals("\"123\", [2, 12, 23]", 1, DecryptMe.groupCounter("123", new int[] {2, 12, 23}));
        assertEquals("\"12317\", [2, 3, 17]", 3, DecryptMe.groupCounter("2317", new int[] { 2, 3, 17}));
        //  groupcounter is counting 2 when looking at 20
        assertEquals("\"12010715\", [1, 2, 7, 25]", 3, DecryptMe.groupCounter("12010715", new int[] {1, 2, 7, 25}));
        
        String[] messages = { "12345", "1111", "12233", "223435"};
        List<String> ans = DecryptMe.getBestMessage(messages, new int[] {1, 2, 3, 23});
        assertEquals(1, ans.size());
        assertEquals("12233", ans.get(0));

        String[] messages1 = { "1523423735", "221323151517", "172323513", "7223423315"};
        ans = DecryptMe.getBestMessage(messages1, new int[] {3, 7, 15, 23});
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains("1523423735"));
        assertEquals(true, ans.contains("221323151517"));
        assertEquals(true, ans.contains("7223423315"));

        assertEquals("111", 3, DecryptMe.numDecryption("111"));
        assertEquals("1210", 2, DecryptMe.numDecryption("1310"));
    }

    public void testCountLetterNoZerosInMessage02()
    {
        for(int t = 1; t < 10; t++)
            assertEquals("123456789, " + t, 1, DecryptMe.countLetter("123456789", t));

        assertEquals("312345637893, 3", 4, DecryptMe.countLetter("312345637893", 3));
        assertEquals("9129939945967989, 9", 8, DecryptMe.countLetter("9129939945967989", 9));
    }

    public void testCountLetterWithZerosInMessage03()
    {
        int[] values = {-1, 10, 6, 2, 2, 2, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for(int t = 1; t < values.length; t++)
            assertEquals("11314151617181912021223242526, all " + t, values[t], DecryptMe.countLetter("11314151617181912021223242526", t));

        assertEquals("1010314151061718109102021022324252610, all " + 10, 7, DecryptMe.countLetter("1010314151061718109102021022324252610", 10));
        assertEquals("110110314151204252610, 10", 3, DecryptMe.countLetter("110110314151204252610", 10));
        assertEquals("11011031415120411252610, 11", 1, DecryptMe.countLetter("11011031415120411252610", 11));
        assertEquals("112011031415120412512610, 12", 2, DecryptMe.countLetter("112011031415120412512610", 12));
        assertEquals("1201103141512204205206120, 20", 5, DecryptMe.countLetter("1201103141512204205206120", 20));

        assertEquals("110120, 1", 2, DecryptMe.countLetter("110120", 1));
        assertEquals("110120, 10", 1, DecryptMe.countLetter("110120", 10));
        assertEquals("110120, 12", 0, DecryptMe.countLetter("110120", 12));
        assertEquals("110120, 11", 0, DecryptMe.countLetter("110120", 11));

        assertEquals("210220, 2", 2, DecryptMe.countLetter("210220", 2));
        assertEquals("210220, 10", 1, DecryptMe.countLetter("210220", 10));
        assertEquals("210220, 20", 1, DecryptMe.countLetter("210220", 20));
        assertEquals("210220, 21", 0, DecryptMe.countLetter("210220", 21));
        assertEquals("210220, 22", 0, DecryptMe.countLetter("210220", 22));
    }

    public void testGroupCounter04()
    {
        assertEquals("\"726123942811125323122\", new int{1, 3, 6, 9}", 10, DecryptMe.groupCounter("726123942811125323122", new int[]{1, 3, 6, 9}));

        assertEquals("\"2010485247\", new int[] {2, 4, 6, 8}", 6, DecryptMe.groupCounter("20104852477", new int[] {2, 4, 7, 8}));
    }

    public void testGroupCounter05()
    {
        assertEquals("\"7261394281313126532311226\", int[]{11, 13, 26}", 7, DecryptMe.groupCounter("7261394281313126532311226", new int[]{11, 13, 26}));

        assertEquals("\"202010221019710528227\", new int[] {19, 20, 22}", 5, DecryptMe.groupCounter("202010221019710528227", new int[] {19, 20, 22}));

        assertEquals("\"202010221019710528227\", new int[] {1, 2, 19, 20, 22}", 8, DecryptMe.groupCounter("202010221019710528227", new int[] {1, 2, 19, 20, 22}));
    }

    public void testGroupCounter06()
    {
        assertEquals("\"11121513222\", int[]{1, 2, 3, 11, 13, 22}", 10, DecryptMe.groupCounter("11121513222", new int[]{1, 2, 3, 11, 13, 22}));

        assertEquals("\"11121513222\", int[]{3, 11, 13, 22}", 3, DecryptMe.groupCounter("11121513222", new int[]{3, 11, 13, 22}));
        
        assertEquals("\"2022242624222920\", new int[] {20, 22, 24, 26}", 7, DecryptMe.groupCounter("2022242624222920", new int[] {20, 22, 24, 26}));

        assertEquals("\"119320175261227361\", new int[] {3, 5, 12, 16, 20, 26}", 6, DecryptMe.groupCounter("119320175261227361", new int[] {3, 5, 12, 16, 20, 26}));

        assertEquals("\"1020\", new int[] {1, 2}", 0, DecryptMe.groupCounter("1020", new int[] {1, 2}));
        assertEquals("\"1020\", new int[] {1, 2, 10, 20}", 2, DecryptMe.groupCounter("1020", new int[] {1, 2, 10, 20}));

        assertEquals("\"110120\", new int[] {11, 12}", 0, DecryptMe.groupCounter("110120", new int[] {11, 12}));
        assertEquals("\"110120\", new int[] {1, 2, 11, 12}", 2, DecryptMe.groupCounter("110120", new int[] {1, 2, 11, 12}));
        assertEquals("\"110120\", new int[] {1, 2, 10, 11, 12, 20}", 4, DecryptMe.groupCounter("110120", new int[] {1, 2, 10, 11, 12, 20}));
    }

    public void testGetBestMeassage07()
    {
        String[] messages1 = {"122416199111", "11122551441010", "1821262442", "5161331317724", "13201320211418349" };
        List<String> ans =  DecryptMe.getBestMessage(messages1, new int[]{1, 2, 3, 11, 13, 22});
        assertEquals(1, ans.size());
        assertEquals("13201320211418349", ans.get(0));

        String[] messages2 = {"122416199124", "151959121215", "19913951759592", "11291275121", "5121551997121959" };
        ans =  DecryptMe.getBestMessage(messages2, new int[]{2, 12, 15, 19});
        assertEquals(2, ans.size());
        assertEquals(true, ans.get(0).equals(messages2[1]) || ans.get(1).equals(messages2[4]));
        assertEquals(true, ans.get(1).equals(messages2[4]) || ans.get(1).equals(messages2[1]));
        assertEquals(false, ans.get(1).equals(ans.get(0)));
    }

//  double check this testers
    public void testGetBestMeassage08()
    {
        String[] messages1 = {"2912155222513115", "10201522515131719", "10211742610", "202010151125", "115225115225310" };
        List<String> ans =  DecryptMe.getBestMessage(messages1, new int[]{ 2, 5, 11, 15, 17, 25});
        assertEquals(2, ans.size());
        assertEquals(true, ans.get(0).equals(messages1[0]) || ans.get(1).equals(messages1[0]));
        assertEquals(true, ans.get(1).equals(messages1[4]) || ans.get(1).equals(messages1[4]));
        assertEquals(false, ans.get(1).equals(ans.get(0)));

        String[] messages2 = {"791020526", "3438181421525", "24242424", "10101010", "251224222152084251324" };
        ans =  DecryptMe.getBestMessage(messages2, new int[]{3, 4, 8, 15, 22, 24, 25});
        assertEquals(1, ans.size());
        assertEquals(true, ans.get(0).equals(messages2[4]));
    }

    public void testNumDecryption09()
    {
        assertEquals("1234", 3, DecryptMe.numDecryption("1234"));
        assertEquals("123411", 6, DecryptMe.numDecryption("123411"));
        assertEquals("12341125", 15, DecryptMe.numDecryption("12341125"));
    }

    public void testNumDecryption10()
    {
        assertEquals("1010203456", 1, DecryptMe.numDecryption("1010203456"));
        assertEquals("121321820", 15, DecryptMe.numDecryption("121321820"));
    }

    public void testFunWithNaturalNumbers01()
    {
        assertEquals(3, FunWithNaturalNumbers.summation(1+2+3));
        assertEquals(9, FunWithNaturalNumbers.summation(50));
        assertEquals(13, FunWithNaturalNumbers.summation(91));

        assertEquals(5, FunWithNaturalNumbers.prod(24));
        assertEquals(7, FunWithNaturalNumbers.prod(99));
        assertEquals(10, FunWithNaturalNumbers.prod(2318));

        List<Integer> ans = FunWithNaturalNumbers.groupEm(2);
        assertEquals(3, ans.size());
        assertEquals("contains 4", true, ans.contains(new Integer(4)));
        assertEquals("contains 5", true, ans.contains(new Integer(5)));
        assertEquals("contains 6", true, ans.contains(new Integer(6)));

        ans = FunWithNaturalNumbers.groupEm(3);
        assertEquals(5, ans.size());
        assertEquals("contains 11", true, ans.contains(new Integer(11)));
        assertEquals("contains 12", true, ans.contains(new Integer(12)));
        assertEquals("contains 13", true, ans.contains(new Integer(13)));
        assertEquals("contains 14", true, ans.contains(new Integer(14)));
        assertEquals("contains 15", true, ans.contains(new Integer(15)));

        assertEquals(1, FunWithNaturalNumbers.sumThoseGroups(1));
        assertEquals(1+(4+5+6), FunWithNaturalNumbers.sumThoseGroups(2));
        assertEquals(1 + (4+5+6) + (11+12+13+14+15), FunWithNaturalNumbers.sumThoseGroups(3));
    }

    public void testSummation02()
    {
        assertEquals("summation(1+2+3+3)", 3, FunWithNaturalNumbers.summation(1+2+3+3));
        assertEquals("summation(1+2+3+4+5+6+7+8+9+10+11+12+12)", 12, FunWithNaturalNumbers.summation(1+2+3+4+5+6+7+8+9+10+11+12+12));
        assertEquals("summation(210+20)", 20, FunWithNaturalNumbers.summation(210+20));
    }

    public void testSummationExactValues03()
    {
        assertEquals("summation(4950)", 99, FunWithNaturalNumbers.summation(4950));
        assertEquals("summation(120)", 15, FunWithNaturalNumbers.summation(120));
        assertEquals("summation(91)", 13, FunWithNaturalNumbers.summation(91));
    }
    
    public void testProd04()
    {
        assertEquals("prod(602)",   9, FunWithNaturalNumbers.prod(602));
        assertEquals("prod(1905)", 10, FunWithNaturalNumbers.prod(1905));
        assertEquals("prod(200)",   7, FunWithNaturalNumbers.prod(200));
        assertEquals("prod(201)",   8, FunWithNaturalNumbers.prod(201));
    }

    public void testProd05()
    {
        assertEquals("prod(1)", 2, FunWithNaturalNumbers.prod(1));
        assertEquals("prod(2)", 3, FunWithNaturalNumbers.prod(2));
        assertEquals("prod(21887)", 12, FunWithNaturalNumbers.prod(21887));
        assertEquals("prod(21885)", 11, FunWithNaturalNumbers.prod(21885));
    }

    public void testSummationAndProd06()
    {
        testProd04();
        testProd05();
        testSummation02();
        testSummationExactValues03();
    }

    public void testGroupEm07()
    {
        List<Integer> ans = FunWithNaturalNumbers.groupEm(5);
        assertEquals(9, ans.size());
        assertEquals("contains 37", true, ans.contains(new Integer(37)));
        assertEquals("contains 38", true, ans.contains(new Integer(38)));
        assertEquals("contains 39", true, ans.contains(new Integer(39)));
        assertEquals("contains 40", true, ans.contains(new Integer(40)));
        assertEquals("contains 41", true, ans.contains(new Integer(41)));
        assertEquals("contains 42", true, ans.contains(new Integer(42)));
        assertEquals("contains 43", true, ans.contains(new Integer(43)));
        assertEquals("contains 44", true, ans.contains(new Integer(44)));
        assertEquals("contains 45", true, ans.contains(new Integer(45)));

        ans = FunWithNaturalNumbers.groupEm(7);
        assertEquals(13, ans.size());
        assertEquals("contains 78", false, ans.contains(new Integer(78)));
        assertEquals("contains 79", true, ans.contains(new Integer(79)));
        assertEquals("contains 91", true, ans.contains(new Integer(91)));
        assertEquals("contains 92", false, ans.contains(new Integer(92)));
    }

    public void testGroupEmSizeCheck08()
    {
        assertEquals(39, FunWithNaturalNumbers.groupEm(20).size());
        assertEquals(199, FunWithNaturalNumbers.groupEm(100).size());
    }

    public void testSumThoseGroups09()
    {
        assertEquals(10000, FunWithNaturalNumbers.sumThoseGroups(10));
        assertEquals(81, FunWithNaturalNumbers.sumThoseGroups(3));
    }

    public void testGroupEmAndSumThoseGroups10()
    {
        assertEquals(33, FunWithNaturalNumbers.groupEm(17).size());
        assertEquals(105, FunWithNaturalNumbers.groupEm(53).size());
        
        assertEquals(15*15*15*15, FunWithNaturalNumbers.sumThoseGroups(15));
        assertEquals(27*27*27*27, FunWithNaturalNumbers.sumThoseGroups(27));
    }

    public void testFunctionsGoneWild2020_00()
    {
        assertEquals(1, FunctionsGoneWild2020.f1(1));
        assertEquals(7, FunctionsGoneWild2020.f1(2));
        assertEquals(19, FunctionsGoneWild2020.f1(3));
        assertEquals(37, FunctionsGoneWild2020.f1(4));
        assertEquals(61, FunctionsGoneWild2020.f1(5));
        assertEquals(91, FunctionsGoneWild2020.f1(6));

        assertEquals(34, FunctionsGoneWild2020.f2("1a1b1", 3));
        assertEquals(50, FunctionsGoneWild2020.f2("ab", 2));
        assertEquals(20, FunctionsGoneWild2020.f2("3a123b", 5));

        assertEquals(324, FunctionsGoneWild2020.f3(20));
        assertEquals(304, FunctionsGoneWild2020.f3(135));
        assertEquals(127, FunctionsGoneWild2020.f3(501));
        assertEquals(500, FunctionsGoneWild2020.f3(500));

        assertEquals(250/*36+78+136*/, FunctionsGoneWild2020.f4(2, 2, 1));
//        assertEquals(400/*2*25+10*5 + 2*36+10*6 + 2*49+7*10*/, FunctionsGoneWild2020.f4(1, 2, 5));
        assertEquals(472/*2*25+10*5 + 2*36+10*6 + 2*49+7*10*/, FunctionsGoneWild2020.f4(1, 2, 5));

        assertEquals(2, FunctionsGoneWild2020.f5(523, 3));
        assertEquals(40, FunctionsGoneWild2020.f5(1, 35));
        assertEquals(12, FunctionsGoneWild2020.f5(98, 11));
        assertEquals(0, FunctionsGoneWild2020.f5(154, 11));

        assertEquals(35.922375, FunctionsGoneWild2020.f6(4*Math.PI/5., 3, 3*Math.PI/2), 0.005);
        assertEquals(65.250785, FunctionsGoneWild2020.f6(4*Math.PI/5., 2, Math.PI/3), 0.005);

        assertEquals("abdfghjklqsvwxyz", FunctionsGoneWild2020.f7("Computer Science"));
        assertEquals("t", FunctionsGoneWild2020.f7("The quick brown fox jumps over lazy dog."));
        assertEquals("bcdfhjklpquvwxyz", FunctionsGoneWild2020.f7("Programming Contest 2020"));

        assertEquals("FGHIJKLMNO", FunctionsGoneWild2020.f8("ABCDEFGHIJ") );
        assertEquals("PQRSTUVWXYZABCDE", FunctionsGoneWild2020.f8("ZYXWVUTSRQPONMLK") );
        assertEquals("LAV NV", FunctionsGoneWild2020.f8("GOT IT") );

        assertEquals(true, FunctionsGoneWild2020.f9(false, false, false) );

        assertEquals(false, FunctionsGoneWild2020.f10(false, false, false, false) );
    }

    public void testFunctionsGoneWild2020_function01()
    {
        assertEquals(271, FunctionsGoneWild2020.f1(10));
        assertEquals(1801, FunctionsGoneWild2020.f1(25));
    }

    public void testFunctionsGoneWild2020_function02()
    {
        assertEquals(33, FunctionsGoneWild2020.f2("a490b", 3));
        assertEquals(10, FunctionsGoneWild2020.f2("a490b", 10));
        assertEquals(3, FunctionsGoneWild2020.f2("a490b", 30));
        assertEquals(0, FunctionsGoneWild2020.f2("960a3b1", 2));
        assertEquals(4, FunctionsGoneWild2020.f2("9603ab1", 29));
        assertEquals(3, FunctionsGoneWild2020.f2("960a3b1", 29));
        assertEquals(100, FunctionsGoneWild2020.f2("960a3b5", 5));
    }

    public void testFunctionsGoneWild2020_function03()
    {
        assertEquals(613, FunctionsGoneWild2020.f3(850));
        assertEquals(461, FunctionsGoneWild2020.f3(852));
        assertEquals(277, FunctionsGoneWild2020.f3(851));
        assertEquals(443, FunctionsGoneWild2020.f3(1002));
        assertEquals(1546, FunctionsGoneWild2020.f3(201));
        assertEquals(152, FunctionsGoneWild2020.f3(71));
    }

    public void testFunctionsGoneWild2020_function04()
    {
        assertEquals(17*(3*3+4*4+5*5+6*6+7*7+8*8+9*9+10*10+11*11)
                                + 2 * (3+4+5+6+7+8+9+10+11), FunctionsGoneWild2020.f4(5, 2, 3));    //   17 / 2
        /*
        a = 5 b = 2 c = 3
        max1 = 2      max2 = 3
        min1 = 13     min2 = 11
         */

//        assertEquals(6*(4*4+5*5+6*6+7*7)+12*(4+5+6+7), FunctionsGoneWild2020.f4(1, 3, 4));     ///   6 / 12
            assertEquals(1158, FunctionsGoneWild2020.f4(1, 3, 4));     ///   6 / 12
        /*
        a = 1 b = 3 c = 4
        max1 = -3     max2 = 4
        min1 = 7      min2 = 13
         */

//            assertEquals(8*(5*5+6*6+7*7+8*8+9*9+10*10+11*11+12*12)
//                                 + 14*(5+6+7+8+9+10+11+12), FunctionsGoneWild2020.f4(1, 7, 5));    //  8 / 14
            assertEquals(6210, FunctionsGoneWild2020.f4(1, 7, 5));    //  8 / 14
        /*
        a = 1 b = 7 c = 5
        max1 = -4     max2 = 5
        min1 = 12     min2 = 36
         */

//        assertEquals(14*(7*7+8*8+9*9+10*10) + 3*(7+8+9+10), FunctionsGoneWild2020.f4(7, 3, 1));    //  14 / 3
        assertEquals(5341, FunctionsGoneWild2020.f4(7, 3, 1));    //  14 / 3
        /*
        a = 7 b = 3 c = 1
        max1 = 6      max2 = 7
        min1 = 22     min2 = 10
         */

//        assertEquals(126*(6*6+7*7) + (6+7), FunctionsGoneWild2020.f4(6, 1, 1));    //    126 / 1
        assertEquals(13878, FunctionsGoneWild2020.f4(6, 1, 1));    //    126 / 1
        /*
        a = 6 b = 1 c = 1
        max1 = 5      max2 = 6
        min1 = 7      min2 = 7
         */
    }

    public void testFunctionsGoneWild2020_function05()
    {
        assertEquals(84, FunctionsGoneWild2020.f5(9, 123));
        assertEquals(0, FunctionsGoneWild2020.f5(10, 2));
        assertEquals(24, FunctionsGoneWild2020.f5(75, 99));
        assertEquals(5, FunctionsGoneWild2020.f5(10, 7));
        assertEquals(36, FunctionsGoneWild2020.f5(10, 37));
        assertEquals(13, FunctionsGoneWild2020.f5(30, 131));
        assertEquals(151, FunctionsGoneWild2020.f5(5, 101));
    }

    public void testFunctionsGoneWild2020_function06()
    {
//         for(int r = 0; r < 19; r++)
//         {
//             int h = (int)(100 * Math.random());
//             int k = (int)(100 * Math.random());
//             int m = (int)(100 * Math.random());
//             System.out.println(h + " " + k + " " + m + " = " + FunctionsGoneWild2020.f6(h, k, m));
//         }
        assertEquals(0.54686486,   FunctionsGoneWild2020.f6( 0.08, 0.02, 0.03), 0.02);
        assertEquals(-17.3816227,   FunctionsGoneWild2020.f6(0.95, 0.78, 0.08), 0.02);

        assertEquals(4.076628956,   FunctionsGoneWild2020.f6(0.21, 0.43, 0.61), 0.02);
        assertEquals(-39.0281773,   FunctionsGoneWild2020.f6(0.69, 0.61, 0.44), 0.02);
 
        assertEquals(13.92019644,   FunctionsGoneWild2020.f6(1.5, 2.1, 1.3), 0.02);
        assertEquals(100.3297723,   FunctionsGoneWild2020.f6(3.1, 2.3, 2.1), 0.02);
    }

    public void testFunctionsGoneWild2020_function07()
    {
        assertEquals("", FunctionsGoneWild2020.f7("qwertyuiopasdfghjklzxcvbnm"));
        assertEquals("abcdefghijklmnopqrstuvwxyz", FunctionsGoneWild2020.f7("HELP?"));
        assertEquals("bghijklqvwxyz", FunctionsGoneWild2020.f7("I do not fear computers"));
         assertEquals("bdjklqwxz", FunctionsGoneWild2020.f7("Physics is the operating system of the universe "));
         assertEquals("bcdfgjlmopquvwxz", FunctionsGoneWild2020.f7("Where is the any key?"));
         assertEquals("fjkquvwz", FunctionsGoneWild2020.f7("Simplicity, carried to the extreme becomes elegance"));
         assertEquals("bdjqvwxz", FunctionsGoneWild2020.f7("XML is not a language in the sense of a programming language any more than sketches on a napkin are a language"));
         assertEquals("abcdefghijklmnopqrstuvwxyz", FunctionsGoneWild2020.f7("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
         assertEquals("abcdefghiklmnoprstuvxy", FunctionsGoneWild2020.f7("zABCzDEFGHwIJKLMNOPQRSjTUVWXqYZ"));
    }

    public void testFunctionsGoneWild2020_function08()
    {
        assertEquals("VMJ YUNHE GXASB KAR OUCZW ATJX VMJ DFPQ IAL", FunctionsGoneWild2020.f8("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
        assertEquals("WUZJXHFDNKKXFLNDNWVNHJJRZNFDNIAHNAUW", FunctionsGoneWild2020.f8("SUPERCALIFFRAGILISTICEEXPIALIDOCIOUS"));
        assertEquals("FGHIJKLMNO", FunctionsGoneWild2020.f8("ABCDEFGHIJ"));
        assertEquals("PQRSTUVWXYZABCDE", FunctionsGoneWild2020.f8("ZYXWVUTSRQPONMLK"));
        assertEquals("FEMWPOJUU", FunctionsGoneWild2020.f8("AKHSZJEUU"));
    }

    public void testFunctionsGoneWild2020_function09()
    {
        assertEquals(true, FunctionsGoneWild2020.f9(false, false, false) );
        assertEquals(false, FunctionsGoneWild2020.f9(false, false, true) );
        assertEquals(false, FunctionsGoneWild2020.f9(false, true, false) );
        assertEquals(true, FunctionsGoneWild2020.f9(false, true, true) );
        assertEquals(true, FunctionsGoneWild2020.f9(true, false, false) );
        assertEquals(false, FunctionsGoneWild2020.f9(true, false, true) );
        assertEquals(true, FunctionsGoneWild2020.f9(true, true, false) );
        assertEquals(false, FunctionsGoneWild2020.f9(true, true, true) );
    }

    public void testFunctionsGoneWild2020_function10()
    {
        assertEquals(false, FunctionsGoneWild2020.f10(false, false, false, false) );
        assertEquals(true, FunctionsGoneWild2020.f10(false, false, false, true) );
        assertEquals(true, FunctionsGoneWild2020.f10(false, false, true, false) );
        assertEquals(false, FunctionsGoneWild2020.f10(false, false, true, true) );
        assertEquals(false, FunctionsGoneWild2020.f10(false, true, false, false) );
        assertEquals(true, FunctionsGoneWild2020.f10(false, true, false, true) );
        assertEquals(true, FunctionsGoneWild2020.f10(false, true, true, false) );
        assertEquals(true, FunctionsGoneWild2020.f10(false, true, true, true) );
        assertEquals(true, FunctionsGoneWild2020.f10(true, false, false, false) );
        assertEquals(false, FunctionsGoneWild2020.f10(true, false, false, true) );
        assertEquals(false, FunctionsGoneWild2020.f10(true, false, true, false) );
        assertEquals(false, FunctionsGoneWild2020.f10(true, false, true, true) );
        assertEquals(true, FunctionsGoneWild2020.f10(true, true, false, false) );
        assertEquals(true, FunctionsGoneWild2020.f10(true, true, false, true) );
        assertEquals(false, FunctionsGoneWild2020.f10(true, true, true, false) );
        assertEquals(false, FunctionsGoneWild2020.f10(true, true, true, true) );
    }

    public void testFunctionsGoneWild2020_Bonusfunction01_03()
    {
        testFunctionsGoneWild2020_function01();
        testFunctionsGoneWild2020_function02();
        testFunctionsGoneWild2020_function03();
    }

    public void testFunctionsGoneWild2020_Bonusfunction04_06()
    {
        testFunctionsGoneWild2020_function04();
        testFunctionsGoneWild2020_function05();
        testFunctionsGoneWild2020_function06();
    }

    public void testFunctionsGoneWild2020_Bonusfunction07_08()
    {
        testFunctionsGoneWild2020_function07();
        testFunctionsGoneWild2020_function08();
    }

    public void testFunctionsGoneWild2020_Bonusfunction09_10()
    {
        testFunctionsGoneWild2020_function09();
        testFunctionsGoneWild2020_function10();
    }

    public void testFunctionsGoneWild2020_Bonus_All()
    {
        testFunctionsGoneWild2020_Bonusfunction01_03();
        testFunctionsGoneWild2020_Bonusfunction04_06();
        testFunctionsGoneWild2020_Bonusfunction07_08();
        testFunctionsGoneWild2020_Bonusfunction09_10();
    }

    public void testKeithNumber01()
    {
        KeithNumber kn = new KeithNumber(14);
        int[] ans = kn.getNterms(7);
        assertEquals(7, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(4, ans[1]);
        assertEquals(5, ans[2]);
        assertEquals(9, ans[3]);
        assertEquals(14, ans[4]);
        assertEquals(23, ans[5]);
        assertEquals(37, ans[6]);
        assertEquals(true, kn.isKeithNumber());

        kn = new KeithNumber(197);
        assertEquals(true, kn.isKeithNumber());

        kn = new KeithNumber(197);
        ans = kn.getNterms(8);
        assertEquals(8, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(9, ans[1]);
        assertEquals(7, ans[2]);
        assertEquals(17, ans[3]);
        assertEquals(33, ans[4]);
        assertEquals(57, ans[5]);
        assertEquals(107, ans[6]);
        assertEquals(197, ans[7]);
        assertEquals(true, kn.isKeithNumber());

        kn = new KeithNumber(197);
        assertEquals(true, kn.isKeithNumber());

        kn = new KeithNumber(100);
        assertEquals(false, kn.isKeithNumber());
    }

    public void testwoDigitKeithNumber02()
    {
        KeithNumber kn = new KeithNumber(10);
        int[] ans = kn.getNterms(6);
        assertEquals(6, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(1, ans[2]);
        assertEquals(1, ans[3]);
        assertEquals(2, ans[4]);
        assertEquals(3, ans[5]);

        kn = new KeithNumber(47);
        ans = kn.getNterms(5);
        assertEquals(5, ans.length);
        assertEquals(4, ans[0]);
        assertEquals(7, ans[1]);
        assertEquals(11, ans[2]);
        assertEquals(18, ans[3]);
        assertEquals(29, ans[4]);

        kn = new KeithNumber(99);
        ans = kn.getNterms(6);
        assertEquals(6, ans.length);
        assertEquals(9, ans[0]);
        assertEquals(9, ans[1]);
        assertEquals(18, ans[2]);
        assertEquals(27, ans[3]);
        assertEquals(45, ans[4]);
        assertEquals(72, ans[5]);
    }

    public void testThreeDigitKeithNumber03()
    {
        KeithNumber kn = new KeithNumber(100);
        int[] ans = kn.getNterms(7);
        assertEquals(7, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(0, ans[2]);
        assertEquals(1, ans[3]);
        assertEquals(1, ans[4]);
        assertEquals(2, ans[5]);
        assertEquals(4, ans[6]);

        kn = new KeithNumber(507);
        ans = kn.getNterms(6);
        assertEquals(6, ans.length);
        assertEquals(5, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(7, ans[2]);
        assertEquals(12, ans[3]);
        assertEquals(19, ans[4]);
        assertEquals(38, ans[5]);

        kn = new KeithNumber(816);
        ans = kn.getNterms(7);
        assertEquals(7, ans.length);
        assertEquals(8, ans[0]);
        assertEquals(1, ans[1]);
        assertEquals(6, ans[2]);
        assertEquals(15, ans[3]);
        assertEquals(22, ans[4]);
        assertEquals(43, ans[5]);
        assertEquals(80, ans[6]);
    }

    public void testFourDigitKeithNumber04()
    {
        KeithNumber kn = new KeithNumber(4000);
        int[] ans = kn.getNterms(8);
        assertEquals(8, ans.length);
        assertEquals(4, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(0, ans[2]);
        assertEquals(0, ans[3]);
        assertEquals(4, ans[4]);
        assertEquals(4, ans[5]);
        assertEquals(8, ans[6]);
        assertEquals(16, ans[7]);

        kn = new KeithNumber(8070);
        ans = kn.getNterms(7);
        assertEquals(7, ans.length);
        assertEquals(8, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(7, ans[2]);
        assertEquals(0, ans[3]);
        assertEquals(15, ans[4]);
        assertEquals(22, ans[5]);
        assertEquals(44, ans[6]);

        kn = new KeithNumber(2130);
        ans = kn.getNterms(8);
        assertEquals(8, ans.length);
        assertEquals(2, ans[0]);
        assertEquals(1, ans[1]);
        assertEquals(3, ans[2]);
        assertEquals(0, ans[3]);
        assertEquals(6, ans[4]);
        assertEquals(10, ans[5]);
        assertEquals(19, ans[6]);
        assertEquals(35, ans[7]);
    }

    public void testFiveDigitKeithNumber05()
    {
        KeithNumber kn = new KeithNumber(60000);
        int[] ans = kn.getNterms(10);
        assertEquals(10, ans.length);
        assertEquals(6, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(0, ans[2]);
        assertEquals(0, ans[3]);
        assertEquals(0, ans[4]);
        assertEquals(6, ans[5]);
        assertEquals(6, ans[6]);
        assertEquals(12, ans[7]);
        assertEquals(24, ans[8]);
        assertEquals(48, ans[9]);

        kn = new KeithNumber(50700);
        ans = kn.getNterms(10);
        assertEquals(10, ans.length);
        assertEquals(5, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(7, ans[2]);
        assertEquals(0, ans[3]);
        assertEquals(0, ans[4]);
        assertEquals(12, ans[5]);
        assertEquals(19, ans[6]);
        assertEquals(38, ans[7]);
        assertEquals(69, ans[8]);
        assertEquals(138, ans[9]);

        kn = new KeithNumber(94030);
        ans = kn.getNterms(10);
        assertEquals(10, ans.length);
        assertEquals(9, ans[0]);
        assertEquals(4, ans[1]);
        assertEquals(0, ans[2]);
        assertEquals(3, ans[3]);
        assertEquals(0, ans[4]);
        assertEquals(16, ans[5]);
        assertEquals(23, ans[6]);
        assertEquals(42, ans[7]);
        assertEquals(84, ans[8]);
        assertEquals(165, ans[9]);
    }

    public void testTwoDigitIsKeithNumber06()
    {
        int[] ks = {14, 19, 28, 47, 61, 75};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }

        int[] notKs = {13, 3, 78};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }
    }

    public void testThreeDigitIsKeithNumber07()
    {
        int[] ks = {197,742};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }

        int[] notKs = {103, 300, 578};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }
    }

    public void testFourDigitIsKeithNumber08()
    {
        int[] ks = {1104 , 1537, 2208, 2580, 3684, 4788, 7385, 7647, 7909};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }

        int[] notKs = {9103, 3207, 5614};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }
    }

    public void testFiveDigitIsKeithNumber09()
    {
        int[] ks = {31331, 34285, 34348, 55604, 62662, 86935, 93993};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }

        int[] notKs = {96103, 32807, 58614};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }
    }

    public void testReallyBigIsKeithNumber10()
    {
        int[] ks = {120284, 355419, 925993, 7913837, 11436171, 44121607};

        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }

        int[] notKs = {9685103, 3622807, 29586714};
        for (int in: ks)
        {
            KeithNumber kn = new KeithNumber(in);
            assertEquals(in+" is a keith Number", true, kn.isKeithNumber());
        }
    }

    public void testLieCalculator01()
    {
        int[] nums1 = new int[] {10, 11, 15, 15, 13, 16, 23, 10};
        LieCalculator lc1 = new LieCalculator(nums1);
        assertEquals(14, lc1.getMedian(), 0.001);
        assertEquals(2, lc1.getMode().length);
        assertEquals(10, lc1.getMode()[0]);
        assertEquals(15, lc1.getMode()[1]);

        int[] nums2 = new int[] {10, 2, 38, 23, 38, 23, 21, 23};
        LieCalculator lc2 = new LieCalculator(nums2);
        assertEquals(22.25, lc2.getMean(), 0.01);
        assertEquals(23, lc2.getMedian(), 0.01);
        assertEquals(1, lc2.getMode().length);
        assertEquals(23, lc2.getMode()[0]);
        assertEquals(36, lc2.getRange());
        assertEquals((2+38)/2.0, lc2.getMidRange(), 0.01);
        assertEquals(12.3027, lc2.getStandardDeviation(), 0.01);
        assertEquals(-0.182886, lc2.getZscore(20), 0.02);
        assertEquals(29, lc2.makeMean(23));
        assertEquals(4, lc2.makeMode(11));
        assertEquals(2, lc2.makeMode(38));
        assertEquals(-2, lc2.makeRange(40)[0]);
        assertEquals(42, lc2.makeRange(40)[1]);
        assertEquals(42, lc2.makeMidRange(22));
        assertEquals(-2, lc2.makeMidRange(18));
        assertEquals(25, lc2.makeStandardDeviation(11.54459951));
        assertEquals(40, lc2.makeStandardDeviation(12.94003263));
    }

    public void testGetMean02()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25, 35, 36, 37, 19, 21, 29, 23, 30});
        assertEquals(27.941176470588, lc.getMean(), 0.01);

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 153, 149, 135, 214, 135, 164, 177, 147, 155});
        assertEquals(155.53846153846, lc.getMean(), 0.01);

        lc = new LieCalculator(new int[] {-33, -17, -9, 5, -5, -20, -11, 1, -2, -19, -13, 2, -22});
        assertEquals(-11, lc.getMean(), 0.01);
    }

    public void testGetMedian03()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25, 35, 36, 37, 19, 21, 29, 23, 30});
        assertEquals(29, lc.getMedian(), 0.01);

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 153, 149, 135, 214, 135, 164, 177, 147, 155, 163});
        assertEquals(154, lc.getMedian(), 0.01);

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 155, 155});
        assertEquals(155, lc.getMedian(), 0.01);

        lc = new LieCalculator(new int[] {-33, -17, -9, 5, -5, -20, -11, 1, -2, -19, -13, 2, -22});
        assertEquals(-11, lc.getMedian(), 0.01);
    }

    public void testGetModeMakeMode04()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25, 35, 36, 37, 19, 21, 29, 23, 30});
        int[] sol = lc.getMode();
        assertEquals(6, sol.length);
        assertEquals(19, sol[0]);
        assertEquals(22, sol[1]);
        assertEquals(25, sol[2]);
        assertEquals(29, sol[3]);
        assertEquals(35, sol[4]);
        assertEquals(37, sol[5]);
        assertEquals(1, lc.makeMode(22));
        assertEquals(2, lc.makeMode(36));
        assertEquals(3, lc.makeMode(27));

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 153, 149, 135, 214, 135, 164, 177, 147, 155});
        assertEquals(1, lc.getMode().length);
        assertEquals(135, lc.getMode()[0]);
        assertEquals(0, lc.makeMode(135));
        assertEquals(2, lc.makeMode(155));
        assertEquals(3, lc.makeMode(214));
        assertEquals(4, lc.makeMode(207));

        lc = new LieCalculator(new int[] {-33, -17, -9, 5, -5, -20, -11, 1, -2, -19, -13, 2, -22});
        assertEquals(null, lc.getMode());
        assertEquals(1, lc.makeMode(-33));
        assertEquals(2, lc.makeMode(-8));
    }

    public void testGetRangeGetMidRange05()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25, 35, 36, 37, 19, 21, 29, 23, 30});
        assertEquals(37-19, lc.getRange());
        assertEquals((37+19)/2.0, lc.getMidRange(), 0.01);

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 153, 149, 135, 214, 135, 164, 177, 147, 155});
        assertEquals(79, lc.getRange());
        assertEquals((214+135)/2.0, lc.getMidRange(), 0.01);


        lc = new LieCalculator(new int[] {-33, -17, -9, 5, -5, -20, -11, 1, -2, -19, -13, 2, -22});
        assertEquals(5+33, lc.getRange());
        assertEquals((5-33)/2.0, lc.getMidRange(), 0.01);
    }

    public void testGetStandardDeviation06()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25, 35, 36, 37, 19, 21, 29, 23, 30});
        assertEquals(6.4466133379792, lc.getStandardDeviation(), 0.01);

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 153, 149, 135, 214, 135, 164, 177, 147, 155});
        assertEquals(21.762411725325, lc.getStandardDeviation(), 0.01);

        lc = new LieCalculator(new int[] {-33, -17, -9, 5, -5, -20, -11, 1, -2, -19, -13, 2, -22});
        assertEquals(11.105554165972, lc.getStandardDeviation(), 0.01);

    }

    public void testZscore07()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25, 35, 36, 37, 19, 21, 29, 23, 30});
        assertEquals(-1.231836944, lc.getZscore(20), 0.02);
        assertEquals(0.6296055489, lc.getZscore(32), 0.02);

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 153, 149, 135, 214, 135, 164, 177, 147, 155});
        assertEquals(-2.55203615531836944, lc.getZscore(100), 0.02);
        assertEquals(3.191812532, lc.getZscore(225), 0.02);

        lc = new LieCalculator(new int[] {-33, -17, -9, 5, -5, -20, -11, 1, -2, -19, -13, 2, -22});
        assertEquals(-0.8104, lc.getZscore(-20), 0.02);
        assertEquals(0.990495, lc.getZscore(0), 0.02);
    }

    public void testMakeMean08()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25, 35, 36, 37, 19, 21, 29, 23, 30});
        assertEquals(47, lc.makeMean(29));

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 153, 149, 135, 214, 135, 164, 177, 147, 155});
        assertEquals(162, lc.makeMean(156));

        lc = new LieCalculator(new int[] {-33, -17, -9, 5, -5, -20, -11, 1, -2, -19, -13, 2, -22});
        assertEquals(-25, lc.makeMean(-12));
        assertEquals(3, lc.makeMean(-10));
    }

    public void testMakeRangeMakeMidRange09()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25, 35, 36, 37, 19, 21, 29, 23, 30});
        int[] ans = lc.makeRange(20);
        assertEquals(17, ans[0]);
        assertEquals(39, ans[1]);
        assertEquals(47, lc.makeMidRange(33));
        assertEquals(3, lc.makeMidRange(20));

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 153, 149, 135, 214, 135, 164, 177, 147, 155});
        ans = lc.makeRange(100);
        assertEquals(114, ans[0]);
        assertEquals(235, ans[1]);
        assertEquals(384-135, lc.makeMidRange(192));
        assertEquals(2*148-214, lc.makeMidRange(148));

        lc = new LieCalculator(new int[] {-33, -17, -9, 5, -5, -20, -11, 1, -2, -19, -13, 2, -22});
        ans = lc.makeRange(49);
        assertEquals(-44, ans[0]);
        assertEquals(16, ans[1]);
        assertEquals(33, lc.makeMidRange(0));
        assertEquals(-55, lc.makeMidRange(-25));
    }

    public void testMakeStandardDeviation10()
    {
        LieCalculator lc = new LieCalculator(new int[] {25, 37, 31, 29, 22, 35, 19, 22, 25});
        assertEquals(32, lc.makeStandardDeviation(6.0194130389377));

        lc = new LieCalculator(new int[] {135, 164, 155, 139, 149, 135, 214, 135, 164, 177, 147});
        assertEquals(99, lc.makeStandardDeviation(28.017716256726));

        lc = new LieCalculator(new int[] { -17, -9, 5, -5, -20, -11, 1, -2, -19, -1});
        assertEquals(0, lc.makeStandardDeviation(8.688550459709));
        assertEquals(3, lc.makeStandardDeviation(8.9757248377853));
        assertEquals(-11, lc.makeStandardDeviation(8.4196739302012));
    }

    public void testBonusPointForImplemetingAllMethods11()
    {
        testLieCalculator01();
        testGetMean02();
        testGetMedian03();
        testGetModeMakeMode04();
        testGetRangeGetMidRange05();
        testGetStandardDeviation06();
        testZscore07();
        testMakeMean08();
        testMakeRangeMakeMidRange09();
        testMakeStandardDeviation10();
    }

    public void testNumsNotChangeByAnyMethod12()
    {
        int[] copy = new int[] { -17, -9, 5, -5, 20, -11, 1, -2, 19, -1, 13, 9, 9};
        int[] nums = new int[] { -17, -9, 5, -5, 20, -11, 1, -2, 19, -1, 13, 9, 9};
        LieCalculator lc = new LieCalculator(nums);
        
        double mean =lc.getMean();
        double medain = lc.getMedian();
        int[] mode = lc.getMode();
        int range = lc.getRange();
        double midR = lc.getMidRange();
        double sd = lc.getStandardDeviation();
        double z = lc.getZscore(20);
        
        lc.makeMean(2);
        lc.makeMode(11);
        lc.makeRange(40);
        lc.makeMidRange(5);
        lc.makeStandardDeviation(11.47859929);

        for (int s = 0; s < copy.length; s++)
            assertEquals("value at index " + s + "has been changed in nums", copy[s], nums[s]);
        assertEquals(copy.length, nums.length);
    }

    public void testPalindromicNumber01()
    {
        assertEquals(true, PalindromicNumber.isPalindromic(10081));
        assertEquals(true, PalindromicNumber.isPalindromic(123321));
        assertEquals(true, PalindromicNumber.isPalindromic(110));

        assertEquals(false, PalindromicNumber.isPalindromic(1231));
        assertEquals(false, PalindromicNumber.isPalindromic(4104));

        assertEquals(123321, PalindromicNumber.getSmallestPalindrome(123321));
        assertEquals(123321, PalindromicNumber.getSmallestPalindrome(321123));
        assertEquals(101, PalindromicNumber.getSmallestPalindrome(110));
        assertEquals(12321, PalindromicNumber.getSmallestPalindrome(3211));
        assertEquals(102343201, PalindromicNumber.getSmallestPalindrome(32140));
    }

    public void testArePalindromesPalindromic02()
    {
        assertEquals(true, PalindromicNumber.isPalindromic(123321));
        assertEquals(true, PalindromicNumber.isPalindromic(100001));
        assertEquals(true, PalindromicNumber.isPalindromic(97133179));
        assertEquals(true, PalindromicNumber.isPalindromic(5555555));

        assertEquals(false, PalindromicNumber.isPalindromic(5512));
    }

    public void testNonPalindromesPalindromic03()
    {
        assertEquals(true, PalindromicNumber.isPalindromic(12132));
        assertEquals(true, PalindromicNumber.isPalindromic(1212));
        assertEquals(true, PalindromicNumber.isPalindromic(3012013));

        assertEquals(false, PalindromicNumber.isPalindromic(5512));
    }

    public void testAllNumbersAndZeroPalindromic04()
    {
        assertEquals(true, PalindromicNumber.isPalindromic(0));
        assertEquals(true, PalindromicNumber.isPalindromic(1));
        testArePalindromesPalindromic02();
        testNonPalindromesPalindromic03();

        assertEquals("123540", false, PalindromicNumber.isPalindromic(123540));
        assertEquals("12351122", false, PalindromicNumber.isPalindromic(12351122));
        assertEquals("66126", false, PalindromicNumber.isPalindromic(66126));
        assertEquals("10", false, PalindromicNumber.isPalindromic(10));
    }

    public void testGetSmallestFromPalindromeFromSamllestPalindrome05()
    {
        assertEquals("11", 11, PalindromicNumber.getSmallestPalindrome(11));
        assertEquals("11011", 11011, PalindromicNumber.getSmallestPalindrome(11011));
        assertEquals("123321", 123321, PalindromicNumber.getSmallestPalindrome(321123));
        assertEquals("202", 202, PalindromicNumber.getSmallestPalindrome(202));
    }

    public void testGetSmallestFromPalindromeFromNonSmallestPalindromeEvenLength06()
    {
        assertEquals("50044005", 40055004, PalindromicNumber.getSmallestPalindrome(50044005));
        assertEquals("210012", 102201, PalindromicNumber.getSmallestPalindrome(210012));
        assertEquals("332233", 233332, PalindromicNumber.getSmallestPalindrome(332233));
        assertEquals("759957", 579975, PalindromicNumber.getSmallestPalindrome(759957));
    }

    public void testGetSmallestFromPalindromeFromNonSmallestPalindromeOddLength07()
    {
        assertEquals("2100012", 1020201, PalindromicNumber.getSmallestPalindrome(2100012));
        assertEquals("2103012", 1023201, PalindromicNumber.getSmallestPalindrome(2103012));
        assertEquals("32123", 23132, PalindromicNumber.getSmallestPalindrome(32123));
        assertEquals("9711179", 1791971, PalindromicNumber.getSmallestPalindrome(9711179));
    }

    public void testGetSmallestFromPalindromeFromNonNonPalindromeEvenLength08()
    {
        assertEquals("210002", 1020201, PalindromicNumber.getSmallestPalindrome(210002));
        assertEquals("6200", 20602, PalindromicNumber.getSmallestPalindrome(6200));
        assertEquals("117733", 137731, PalindromicNumber.getSmallestPalindrome(117733));
        assertEquals("96713", 136797631, PalindromicNumber.getSmallestPalindrome(96713));
        assertEquals("96013", 103696301, PalindromicNumber.getSmallestPalindrome(96013));
    }

    public void testGetSmallestFromPalindromeFromNonNonPalindromeOddLength09()
    {
        assertEquals("927", 27972, PalindromicNumber.getSmallestPalindrome(927));
        assertEquals("2100023", 100232001, PalindromicNumber.getSmallestPalindrome(2100023));
        assertEquals("678", 67876, PalindromicNumber.getSmallestPalindrome(678));
    }

    public void testAllPalindromic10()
    {
        testPalindromicNumber01();
        testArePalindromesPalindromic02();
        testNonPalindromesPalindromic03();
        testAllNumbersAndZeroPalindromic04();
        testGetSmallestFromPalindromeFromSamllestPalindrome05();
        testGetSmallestFromPalindromeFromNonSmallestPalindromeEvenLength06();
        testGetSmallestFromPalindromeFromNonSmallestPalindromeOddLength07();
        testGetSmallestFromPalindromeFromNonNonPalindromeEvenLength08();
        testGetSmallestFromPalindromeFromNonNonPalindromeOddLength09();
    }

    public void testTrianglesAndRectanglesOhMy01()
    {
        int[] side1 = {1, 2, 3};
        int[] side2 = {3, 4, 5};
        int[] side3 = {5, 6, 7};
        assertEquals(10, TrianglesAndRectanglesOhMy.getNumPossibleTriangle(side1, side2, side3));

        int[] side1a = {2, 4, 4};
        int[] side2a = {1, 3, 1};
        int[] side3a = {5, 2};
        assertEquals(7, TrianglesAndRectanglesOhMy.getNumPossibleTriangle(side1a, side2a, side3a));

        int[] possibleSides = {13, 6, 9, 37, 11, 5, 2, 23, 17};
        assertEquals(13, TrianglesAndRectanglesOhMy.possibleMinThirdSideOfTriangle(7, 19, possibleSides));
        assertEquals(23, TrianglesAndRectanglesOhMy.possibleMaxThirdSideOfTriangle(7, 19, possibleSides));

        int[] sideA = {2, 4, 8, 11};
        int[] sideB = {1, 3, 6, 7, 8};
        assertEquals(2, TrianglesAndRectanglesOhMy.getNumPossibleRectangleWithArea(sideA, sideB, 24));

        int[] sideA1 = {2, 4, 8, 2, 11};
        int[] sideB1 = {12, 6, 3, 7, 8};
        assertEquals(4, TrianglesAndRectanglesOhMy.getNumPossibleRectangleWithArea(sideA1, sideB1, 24));
        
        int[] stu = TrianglesAndRectanglesOhMy.rectangleWithAreaAndMinPerimeter(sideA1, sideB1, 24);
        assertEquals(4, stu[0]);
        assertEquals(6, stu[1]);
    }

    public void testgetNumPossibleTriangle02()
    {
        int[] side1 = {4, 5};
        int[] side2 = {3, 4, 6};
        int[] side3 = {4, 1};
        assertEquals(7, TrianglesAndRectanglesOhMy.getNumPossibleTriangle(side1, side2, side3));

        int[] side1a = {1, 10};
        int[] side2a = {7, 8, 6, 9};
        int[] side3a = {2, 11, 3};
        assertEquals(7, TrianglesAndRectanglesOhMy.getNumPossibleTriangle(side1a, side2a, side3a));

        int[] side1aa = {25, 19, 28, 9};
        int[] side2aa = {13, 27, 17};
        int[] side3aa = {13, 31};
        assertEquals(20, TrianglesAndRectanglesOhMy.getNumPossibleTriangle(side1aa, side2aa, side3aa));
    }

    public void testgetNumPossibleTriangle03()
    {
        int[] side1 = {25, 19, 28};
        int[] side2 = {13, 27, 17};
        int[] side3 = {13, 31};
        assertEquals(17, TrianglesAndRectanglesOhMy.getNumPossibleTriangle(side1, side2, side3));

        int[] side1a = {5};
        int[] side2a = {1, 5, 9};
        int[] side3a = {2, 7};
        assertEquals(3, TrianglesAndRectanglesOhMy.getNumPossibleTriangle(side1a, side2a, side3a));

        int[] side1aa = {5, 19, 31};
        int[] side2aa = {13, 27, 7};
        int[] side3aa = {31};
        assertEquals(6, TrianglesAndRectanglesOhMy.getNumPossibleTriangle(side1aa, side2aa, side3aa));
    }

    public void testgetNumPossibleRectangleWithArea04()
    {
        int[] width = {1, 720, 3, 120, 10, 48, 5, 19, 21};
        int[] length = {1, 240, 6, 72, 15, 13, 7, 600, 14};
        assertEquals(5, TrianglesAndRectanglesOhMy.getNumPossibleRectangleWithArea(width, length, 720));

        int[] widtha = {10, 400, 200, 8, 5, 10, 3, 50, 17, 8};
        int[] lengtha = {50, 80, 1, 40, 3, 2, 17, 6, 70, 400};
        assertEquals(7, TrianglesAndRectanglesOhMy.getNumPossibleRectangleWithArea(widtha, lengtha, 400));
    }

    public void testgetNumPossibleRectangleWithArea05()
    {
        int[] width = {13, 17, 27, 7};
        int[] length = {5, 11, 23, 31};
        assertEquals(0, TrianglesAndRectanglesOhMy.getNumPossibleRectangleWithArea(width, length, 71));

        int[] widtha = {18, 1, 95832/4356, 9583, 0, 14641, 95832/8};   
        int[] lengtha = {95832/18, 4356, 10, 95832, 16};
        assertEquals(3, TrianglesAndRectanglesOhMy.getNumPossibleRectangleWithArea(widtha, lengtha, 2*2*2*3*3*11*11*11));
    }

    public void testgetNumPossibleRectangleWithAreaWithMinPerimeter06()
    {
        int[] widtha = {76734/2, 58, 81, 9, 76734/49, 21, 58, 3, 29, 4, 0, 76734/6, 147, 441};
        int[] lengtha = {2, 27*49,12,  0, 76734/9, 49, 76734/21, 6, 76734/3, 76734/29, 4, 174, 2};
        assertEquals(11, TrianglesAndRectanglesOhMy.getNumPossibleRectangleWithArea(widtha, lengtha, 2*3*3*3*7*7*29));  //  76734
        int[] stu = TrianglesAndRectanglesOhMy.rectangleWithAreaAndMinPerimeter(widtha, lengtha, 2*3*3*3*7*7*29);
        assertEquals(441, stu[0]);
        assertEquals(174, stu[1]);
    }

    public void testgetNumPossibleRectangleWithAreaWithMinPerimeter07()
    {
        int[] widtha = {25, 1, 5*5*73, 73, 0};
        int[] lengtha = {73*73, 5*73*73, 1, 25, 0};
        assertEquals(1, TrianglesAndRectanglesOhMy.getNumPossibleRectangleWithArea(widtha, lengtha, 5*5*73*73));

        int[] widthb = {25, 1, 5*5*73, 73, 0, 25, 5*59*73};
        int[] lengthb = {5*59*73, 73*73, 5*73*73, 1, 25, 0};
        int[] stu = TrianglesAndRectanglesOhMy.rectangleWithAreaAndMinPerimeter(widthb, lengthb, 5*5*73*73*59*59);
         assertEquals(5*59*73, stu[0]);
         assertEquals(5*59*73, stu[1]);
    }

    public void testpossibleMinThirdSideOfTriangle08()
    {
        int[] side = {11, 29, 25, 7, 16, 3, 79, 15, 20};
        assertEquals(7, TrianglesAndRectanglesOhMy.possibleMinThirdSideOfTriangle(19, 13, side));

        int[] side1 = {87, 4, 61, 115, 9, 64, 40, 22, 94, 37, 106, 61, 112, 34, 123};
        assertEquals(87, TrianglesAndRectanglesOhMy.possibleMinThirdSideOfTriangle(103, 19, side1));
    }

    public void testpossibleMaxThirdSideOfTriangle09()
    {
        int[] side = {119, 229, 125, 709, 136, 140, 3, 789, 135, 207};
        assertEquals(136, TrianglesAndRectanglesOhMy.possibleMaxThirdSideOfTriangle(31, 107, side));

        int[] side1 = {870, 942, 3017, 98, 757, 113, 757+114, 769, 902, 1, 114, 758, 129};
        assertEquals(769, TrianglesAndRectanglesOhMy.possibleMaxThirdSideOfTriangle(757, 113, side1));
    }

    public void testpossibleMinAndMaxThirdSideOfTriangle10()
    {
        testpossibleMinThirdSideOfTriangle08();
        testpossibleMaxThirdSideOfTriangle09();
    }

    public void testAddEmUp01()
   {
      int[][] nums = { { 3, 6, 8}, {2, 12, 7}, {8, 6, 4}};
      AddEmUp addEm = new AddEmUp(nums);
      List<Integer> solution = new ArrayList<Integer>();
      solution.add(new Integer(9));
      solution.add(new Integer(11));
      solution.add(new Integer(14));

      List<Integer> ans = addEm.rowSum(0);
      assertEquals("size check", solution.size(), ans.size());
      assertEquals("missing sum first two elements", true, ans.contains(solution.get(0)));
      assertEquals("missing sum first and third (last) elements", true, ans.contains(solution.get(1)));
      assertEquals("missing sum second and third (last) elements", true, ans.contains(solution.get(2)));

      assertEquals("ODD", addEm.getState(0));
      assertEquals("ODD", addEm.getState(1));
      assertEquals("EVEN", addEm.getState(2));

      ans = addEm.commonSum();
      assertEquals("common sum size", 1, ans.size());
      assertEquals("common sum element", new Integer(14), ans.get(0));

      int[][] nums1 = { { 3, -1, 3}, {2, 2, 1} };
      addEm = new AddEmUp(nums1);
      solution = new ArrayList<Integer>();
      solution.add(new Integer(2));
      solution.add(new Integer(6));

      ans = addEm.rowSum(0);
      assertEquals("size check", solution.size(), ans.size());
      assertEquals("missing sum first two elements", true, ans.contains(solution.get(0)));
      assertEquals("missing sum first and third (last) elements", true, ans.contains(solution.get(1)));

      assertEquals("EVEN", addEm.getState(0));
      assertEquals("ODD", addEm.getState(1));
    }

    public void testRowSumWithNoDuplicateSums02()
    {
        int[][] nums = { { 3, 6, 5, 12, 7}, {7, 4, 11, 15, 1} };
        AddEmUp addEm = new AddEmUp(nums);
        List<Integer> solution = new ArrayList<Integer>();
        solution.add(new Integer(9));
        solution.add(new Integer(8));
        solution.add(new Integer(15));
        solution.add(new Integer(10));
        solution.add(new Integer(11));
        solution.add(new Integer(18));
        solution.add(new Integer(13));
        solution.add(new Integer(17));
        solution.add(new Integer(12));
        solution.add(new Integer(19));

        List<Integer> ans = addEm.rowSum(0);
        assertEquals(solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + " not found in  { 3, 6, 5, 12, 7}", true, ans.contains(i));

        solution = new ArrayList<Integer>();    //  {7, 4, 11, 15, 1} 
        solution.add(new Integer(11));
        solution.add(new Integer(18));
        solution.add(new Integer(22));
        solution.add(new Integer(8));
        solution.add(new Integer(15));
        solution.add(new Integer(19));
        solution.add(new Integer(5));
        solution.add(new Integer(26));
        solution.add(new Integer(12));
        solution.add(new Integer(16));

        ans = addEm.rowSum(1);
        assertEquals(solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + " not found in {7, 4, 11, 15, 1}", true, ans.contains(i));
    }

    public void testRowSumWithDuplicateSums03()
    {
        int[][] nums = { { 3, 6, 5, 2, 1, 7}, {7, 4, 5, 11, 10, 3} };
        AddEmUp addEm = new AddEmUp(nums);
        List<Integer> solution = new ArrayList<Integer>();
        solution.add(new Integer(3));
        solution.add(new Integer(4));
        solution.add(new Integer(5));
        solution.add(new Integer(6));
        solution.add(new Integer(7));
        solution.add(new Integer(8));
        solution.add(new Integer(9));
        solution.add(new Integer(10));
        solution.add(new Integer(11));
        solution.add(new Integer(12));
        solution.add(new Integer(13));

        List<Integer> ans = addEm.rowSum(0);
        assertEquals("{ 3, 6, 5, 2, 1, 7}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in { 3, 6, 5, 2, 1, 7}", true, ans.contains(i));

        solution = new ArrayList<Integer>();     //  {7, 4, 5, 11, 10, 3}
        solution.add(new Integer(11));
        solution.add(new Integer(12));
        solution.add(new Integer(18));
        solution.add(new Integer(17));
        solution.add(new Integer(10));
        solution.add(new Integer(9));
        solution.add(new Integer(15));
        solution.add(new Integer(14));
        solution.add(new Integer(7));
        solution.add(new Integer(16));
        solution.add(new Integer(8));
        solution.add(new Integer(21));
        solution.add(new Integer(13));

        ans = addEm.rowSum(1);
        assertEquals("{7, 4, 5, 11, 10, 3}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in {7, 4, 5, 11, 10, 3}", true, ans.contains(i));

        }

/*
 *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
 *    
 *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
 */
    public void testGetStateNoDuplicates04()
    {
        int[][] nums = { { 3, 61, 81}, {21, 12, 7}, {8, 6, 4}};
        AddEmUp addEm = new AddEmUp(nums);

        assertEquals("EVEN", addEm.getState(0));
        assertEquals("ODD", addEm.getState(1));
        assertEquals("EVEN", addEm.getState(2));

        int[][] nums1 = { { 3, 61, 81, 8}, {21, 12, 7, 22}, {3, 8, 6, 4}, {7, 51, 61, 43}};
        addEm = new AddEmUp(nums1);

        assertEquals("NEITHER", addEm.getState(0));
        assertEquals("ODD", addEm.getState(1));
        assertEquals("NEITHER", addEm.getState(2));
        assertEquals("EVEN", addEm.getState(3));
    }

/*
 *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
 *    
 *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
 */
    public void testGetStateWithDuplicate05()
    {
        int[][] nums = { { 3, 61, 81, 3}, {21, 12, 7, 12}, {8, 6, 6, 7}};
        AddEmUp addEm = new AddEmUp(nums);

        assertEquals("EVEN", addEm.getState(0));
        assertEquals("ODD", addEm.getState(1));
        assertEquals("NEITHER", addEm.getState(2));

        int[][] nums1 = { { 3, 1, 1, 8, 1}, {2, 2, 7, 2, 2}, {3, 0, 0, 6, 4}, {21, 0, 0, -1, 0}, {10, 10, 10, 1, 0}};
        addEm = new AddEmUp(nums1);

        assertEquals("EVEN", addEm.getState(0));
        assertEquals("EVEN", addEm.getState(1));
        assertEquals("EVEN", addEm.getState(2));
        assertEquals("ODD", addEm.getState(3));
        assertEquals("EVEN", addEm.getState(4));
    }

/*
 *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
 *    
 *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
 */
    public void testCommonSumNoDuplicates06()
    {
        int[][] nums = { { 3, 6, 8, 2, 13}, {7, 8, 6, 4, 1} };
        AddEmUp addEm = new AddEmUp(nums);

        List<Integer> ans = addEm.commonSum();
        assertEquals("common sum size", 7, ans.size());
        assertEquals("common sum element", true, ans.contains(new Integer(15)));
        assertEquals("common sum element", true, ans.contains(new Integer(11)));
        assertEquals("common sum element", true, ans.contains(new Integer(14)));
        assertEquals("common sum element", true, ans.contains(new Integer(10)));
        assertEquals("common sum element", true, ans.contains(new Integer(9)));
        assertEquals("common sum element", true, ans.contains(new Integer(5)));
        assertEquals("common sum element", true, ans.contains(new Integer(8)));

        int[][] nums1 = { { 3, 6, 8, 2, 13}, {7, 8, 6, 4, 1}, {1, 4, 11, 23, 31} };
        addEm = new AddEmUp(nums1);

        ans = addEm.commonSum();
        assertEquals("common sum size", 2, ans.size());
        assertEquals("common sum element", true, ans.contains(new Integer(15)));
        assertEquals("common sum element", true, ans.contains(new Integer(5)));
    }

/*
 *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
 *    
 *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
 */
    public void testCommonSumWithDuplicates07()
    {
        int[][] nums = { { 3, 2, 8, 0, 2}, {2, 0, 12, 7, 7}, {1, 8, 1, 6, 1}};
        AddEmUp addEm = new AddEmUp(nums);

        List<Integer> ans = addEm.commonSum();
        assertEquals("common sum size", 1, ans.size());
        assertEquals("common sum element", new Integer(2), ans.get(0));

        int[][] nums1 = { { 3, 2, 8, 0, 2}, {2, 0, 11, 4, 4}, {1, 8, 1, 3, 1}, {0, 2, 4, 11, 0}};
        addEm = new AddEmUp(nums1);

        ans = addEm.commonSum();
        assertEquals("common sum size", 3, ans.size());
        assertEquals("common sum element", true, ans.contains(new Integer(2)));
        assertEquals("common sum element", true, ans.contains(new Integer(4)));
        assertEquals("common sum element", true, ans.contains(new Integer(11)));
    }

/*
 *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
 *    
 *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
 */
    public void testRowSumWithDuplicateSumsAgain08()
    {
        int[][] nums = { { 1, 0, 5, 0, 1, 0}, {0, -1, 1, 1, 0, 1} };
        AddEmUp addEm = new AddEmUp(nums);
        List<Integer> solution = new ArrayList<Integer>();
        solution.add(new Integer(0));
        solution.add(new Integer(1));
        solution.add(new Integer(2));
        solution.add(new Integer(5));
        solution.add(new Integer(6));

        List<Integer> ans = addEm.rowSum(0);
        assertEquals("{ 1, 0, 5, 0, 1, 0 }", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in { 1, 0, 5, 0, 1, 0}", true, ans.contains(i));

        solution = new ArrayList<Integer>();     //  {0, -1, 1, 1, 0, 1}
        solution.add(new Integer(-1));
        solution.add(new Integer(0));
        solution.add(new Integer(1));
        solution.add(new Integer(2));

        ans = addEm.rowSum(1);
        assertEquals("{0, -1, 1, 1, 0, 1}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in {0, -1, 1, 1, 0, 1}", true, ans.contains(i));
    }

/*
 *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
 *    
 *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
 */
    public void testRowSumWithDuplicateSumsAndCommonSum09()
    {
        int[][] nums = { { 3, 0, 0, 1}, {2, 0, 1, -1}, {-1, 0, 3, 0}, {0, 0, 1, 2} };
        AddEmUp addEm = new AddEmUp(nums);
        List<Integer> solution = new ArrayList<Integer>();
        solution.add(new Integer(0));
        solution.add(new Integer(1));
        solution.add(new Integer(3));
        solution.add(new Integer(4));

        List<Integer> ans = addEm.rowSum(0);
        assertEquals("{ 3, 0, 0, 1}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in { 3, 0, 0, 1}", true, ans.contains(i));

        solution = new ArrayList<Integer>();     //  {2, 0, 1, -1}
        solution.add(new Integer(-1));
        solution.add(new Integer(0));
        solution.add(new Integer(1));
        solution.add(new Integer(2));
        solution.add(new Integer(3));

        ans = addEm.rowSum(1);
        assertEquals("{2, 0, 1, -1}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in {2, 0, 1, -1}", true, ans.contains(i));

        solution = new ArrayList<Integer>();     //  {-1, 0, 3, 0}
        solution.add(new Integer(-1));
        solution.add(new Integer(0));
        solution.add(new Integer(2));
        solution.add(new Integer(3));

        ans = addEm.rowSum(2);
        assertEquals("{-1, 0, 3, 0}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in {-1, 0, 3, 0}", true, ans.contains(i));

        solution = new ArrayList<Integer>();     //  {0, 0, 1, 2}
        solution.add(new Integer(0));
        solution.add(new Integer(1));
        solution.add(new Integer(2));
        solution.add(new Integer(3));

        ans = addEm.rowSum(3);
        assertEquals("{0, 0, 1, 2}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in {0, 0, 1, 2}", true, ans.contains(i));

        ans = addEm.commonSum();
        assertEquals("common sum size", 2, ans.size());
        assertEquals("common sum element", true, ans.contains(new Integer(0)));
        assertEquals("common sum element", true, ans.contains(new Integer(3)));

        int[][] nums1 = { { 3, 0, 0, 1}, {2, 0, 1, -1}, {-1, 0, 3, 0}, {0, 0, 1, 2}, {-2, -8, 0, 11} };
        addEm = new AddEmUp(nums1);
        ans = addEm.commonSum();
        assertEquals("common sum size", 1, ans.size());
        assertEquals("common sum element", true, ans.contains(new Integer(3)));

        int[][] nums2 = { { 3, 7, 10, 1}, { 3, 0, 0, 1}, {2, 0, 1, -1}, {-1, 0, 3, 0}, {0, 0, 1, 2}, {-2, -8, 0, 11} };
        addEm = new AddEmUp(nums2);
        ans = addEm.commonSum();
        assertEquals("common sum size", 0, ans.size());
    }

/*
 *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
 *    
 *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
 */
    public void testRowSumWithDuplicateSumsAndCommonSum10()
    {
        int[][] nums = { { 1, 2, 4}, {4, 2, 1} };
        AddEmUp addEm = new AddEmUp(nums);
        List<Integer> solution = new ArrayList<Integer>();
        solution.add(new Integer(3));
        solution.add(new Integer(5));
        solution.add(new Integer(6));

        List<Integer> ans = addEm.rowSum(0);
        assertEquals("{  1, 2, 4}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in {  1, 2, 4}}", true, ans.contains(i));

        solution = new ArrayList<Integer>();     //  {4, 2, 1}
        solution.add(new Integer(6));
        solution.add(new Integer(5));
        solution.add(new Integer(3));

        ans = addEm.rowSum(1);
        assertEquals("{  1, 2, 4}", solution.size(), ans.size());
        for (Integer i : solution)
            assertEquals(i + "no found in {  1, 2, 4}}", true, ans.contains(i));

        ans = addEm.commonSum();
        assertEquals("common sum size", 3, ans.size());
        assertEquals("common sum element", true, ans.contains(new Integer(3)));
        assertEquals("common sum element", true, ans.contains(new Integer(6)));
        assertEquals("common sum element", true, ans.contains(new Integer(5)));

        int[][] nums1 = { { 0, 6, 0}, { 0, 5, 0}, { 1, 2, 4}, {4, 2, 1}, { 0, 6, 5 } };
        addEm = new AddEmUp(nums1);

        ans = addEm.commonSum();
        assertEquals("common sum size", 0, ans.size());
    }
}