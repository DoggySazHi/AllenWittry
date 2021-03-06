import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2010 programming contest
 */
public class TrainTracksFinalTest extends junit.framework.TestCase
{
   public void testTrainTracks01()
   {
      int k = 0;
      int [][] tracks= { {3, 1, 3, 2, 3}, {3, 1, 1, 1, 2}, {1, 1, 3, 2, 1} };
      TrainTracks thomas = new TrainTracks( tracks );
      ArrayList<String> sol = thomas.getRoute();
      assertEquals(15, sol.size());
      String[] blocks = {"A1", "A2", "A3", "B3", "C3", "C4", "B4", "A4", "A5", "B5", "B4", "B3", "B2", "B1", "A1"};
      for(String b : blocks)
      {
         assertEquals(b, sol.get(k));
         k++;
      }
   }

   public void testTrainTracks02()
   {
      int k = 0;
      int [][] tracks1 = { {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}};
      var thomas = new TrainTracks( tracks1 );
      var sol = thomas.getRoute();
      assertEquals(9, sol.size());
      String [] b1 = {"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1", "I1"};
      for(String b : b1)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks= { {2, 1, 3, 2, 3}, {3, 1, 1, 1, 2}, {1, 1, 3, 2, 1} };
      thomas = new TrainTracks( tracks );
      sol = thomas.getRoute();
      assertEquals(1, sol.size());
      assertEquals("A1", sol.get(0));

      k = 0;
      int [][] tracks2 = { {1}, {1}, {1}, {1}, {2}, {1}, {1}, {1}, {1}};
      thomas = new TrainTracks( tracks2 );
      sol = thomas.getRoute();
      assertEquals(5, sol.size());
      String []b2 = {"A1", "B1", "C1", "D1", "E1"};
      for(String b : b2)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks3 = { {1, 3}, {2, 2}};
      thomas = new TrainTracks( tracks3 );
      sol = thomas.getRoute();
      assertEquals(2, sol.size());
      String [] b11 = {"A1", "B1"};
      for(String b : b11)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks4 = { {1, 3}, {1, 1}, {1, 3} };
      thomas = new TrainTracks( tracks4 );
      sol = thomas.getRoute();
      assertEquals(3, sol.size());
      String []b12 = {"A1", "B1", "C1"};
      for(String b : b12)
      {
         assertEquals(b, sol.get(k));
         k++;
      }
   }

   public void testTrainTracks03()
   {
      int k = 0;
      int [][] tracks= { {3, 3, 2}, {1, 3, 3}, {1, 1, 3} };
      TrainTracks thomas = new TrainTracks( tracks );
      ArrayList<String> sol = thomas.getRoute();
      assertEquals(5, sol.size());
      String [] blocks = {"A1", "A2", "B2", "B3", "C3"};
      for(String b : blocks)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks1= { {3, 3, 2, 1}, {1, 3, 3, 3}, {2, 1, 3, 3} };
      thomas = new TrainTracks( tracks1 );
      sol = thomas.getRoute();
      assertEquals(6, sol.size());
      String [] b1 =  {"A1", "A2", "B2", "B3", "C3", "C4"};
      for(String b : b1)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks2 = { {1, 1, 2}, {3, 1, 3}, {2, 3, 1}};
      thomas = new TrainTracks( tracks2 );
      sol = thomas.getRoute();
      assertEquals(5, sol.size());
      String []b2 = {"A1", "B1", "B2", "B3", "C3"};
      for(String b : b2)
      {
         assertEquals(b, sol.get(k));
         k++;
      }
   }

   public void testTrainTracks04()
   {
      int k = 0;
      int [][] tracks= { {3, 3, 2}, {2, 2, 1}, {2, 1, 3} };
      TrainTracks thomas = new TrainTracks( tracks );
      ArrayList<String> sol = thomas.getRoute();
      assertEquals(5, sol.size());
      String [] blocks = {"A1", "A2", "B2", "B1", "C1"};
      for(String b : blocks)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks1= { {3, 1, 3, 2}, {1, 3, 1, 2}, {3, 2, 2, 1}, {3, 3, 1, 2} };
      thomas = new TrainTracks( tracks1 );
      sol = thomas.getRoute();
      assertEquals(11, sol.size());
      String [] b1 =  {"A1", "A2", "A3", "B3", "C3", "C2", "D2","D3", "D4", "C4", "B4"};
      for(String b : b1)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks2 = { {3, 1, 3, 2, 1}, {1, 3, 1, 2, 2}, {3, 2, 2, 1, 1}, {3, 3, 1, 2, 3} };
      thomas = new TrainTracks( tracks2 );
      sol = thomas.getRoute();
      assertEquals(13, sol.size());
      String [] b2 =  {"A1", "A2", "A3", "B3", "C3", "C2", "D2","D3", "D4", "C4", "B4", "B5", "A5"};
      for(String b : b2)
      {
         assertEquals(b, sol.get(k));
         k++;
      }
   }

   public void testTrainTracks05()
   {
      int k = 0;
      int [][] tracks = { {3, 1, 3}, {1, 2, 1}, {1, 3, 1}, {3, 3, 2} };
      TrainTracks thomas = new TrainTracks( tracks );
      ArrayList<String> sol = thomas.getRoute();
      assertEquals(9, sol.size());
      String [] blocks = {"A1", "A2", "A3", "B3", "C3", "D3", "D2", "C2", "C1"};
      for(String b : blocks)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks1 = { {3, 1, 1, 3}, {3, 1, 2, 1}, {2, 1, 3, 1}, {1, 3, 3, 2} };
      thomas = new TrainTracks( tracks1 );
      sol = thomas.getRoute();
      assertEquals(12, sol.size());
      String [] b1 = {"A1", "A2", "A3", "A4", "B4", "C4", "D4", "D3", "C3", "C2", "C1", "D1"};
      for(String b : b1)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks2 = { {3, 1, 1, 1, 1, 1, 1, 3} };
      thomas = new TrainTracks( tracks2 );
      sol = thomas.getRoute();
      assertEquals(8, sol.size());
      String [] b2 =  {"A1", "A2", "A3", "A4", "A5", "A6", "A7","A8"};
      for(String b : b2)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks3 = { {3, 1, 1, 1, 1, 1, 1, 2} };
      thomas = new TrainTracks( tracks3 );
      sol = thomas.getRoute();
      assertEquals(8, sol.size());
      String [] b3 =  {"A1", "A2", "A3", "A4", "A5", "A6", "A7","A8"};
      for(String b : b3)
      {
         assertEquals(b, sol.get(k));
         k++;
      }
   }

   public void testTrainTracks06()
   {
      int k = 0;
      int [][] tracks = { {1, 3, 2, 3, 1, 2}, {3, 1, 1, 2, 2, 3}, {2, 1, 3, 1, 1, 2}, {2, 3, 1, 1, 1, 1}, {1, 3, 1, 1, 1,3}
                          , {3, 1, 2, 2, 3, 2}};
      TrainTracks thomas = new TrainTracks( tracks );
      ArrayList<String> sol = thomas.getRoute();
      assertEquals(36, sol.size());
      String [] blocks = {"A1", "B1", "B2", "B3", "B4", "A4", "A3", "B3", "C3", "C4", "C5", "C6", "B6", "B5", "C5", "D5", "E5", 
                          "F5", "F6", "E6", "E5", "E4", "E3", "E2", "D2", "D1", "E1", "F1", "F2", "F3", "E3", "D3", "C3", "C2",
                          "C1", "D1"};
      for(String b : blocks)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

      k = 0;
      int [][] tracks1 = { {1, 3, 2, 1, 3, 2, 2, 2, 2, 2, 2, 3}, {3, 1, 3, 1, 3, 1, 1, 1, 1, 1, 2, 2},
                           {1, 3, 3, 1, 2, 2, 1, 2, 3, 1, 3, 3}, {1, 1, 1, 3, 2, 2, 2, 1, 3, 3, 1, 1},
                           {3, 3, 3, 1, 2, 2, 1, 2, 3, 1, 3, 1}, {1, 1, 1, 3, 2, 2, 2, 3, 1, 1, 2, 1},
                           {3, 2, 1, 1, 2, 2, 1, 3, 2, 3, 2, 2} };
      thomas = new TrainTracks( tracks1 );
      sol = thomas.getRoute();
      assertEquals(31, sol.size());
      String [] b1 = {"A1", "B1", "B2", "B3", "C3", "C4", "C5", "B5", "B4", "B3", "A3", "A4", "A5", "B5", "B6", "B7", "B8", 
                      "B9", "B10", "B11", "A11", "A12", "B12", "B11", "C11", "C12", "D12", "E12", "F12", "G12", "G11"};
      for(String b : b1)
      {
         assertEquals(b, sol.get(k));
         k++;
      }

   }

   public void testTrainTracks07()
   {
       testTrainTracks01();
       testTrainTracks02();
   }

   public void testTrainTracks08()
   {
       testTrainTracks03();
       testTrainTracks04();
   }

   public void testTrainTracks09()
   {
       testTrainTracks05();
       testTrainTracks06();
   }

   public void testTrainTracks10()
   {
       testTrainTracks08();
       testTrainTracks09();
   }
}