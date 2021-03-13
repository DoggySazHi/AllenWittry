import java.util.*;

public class PedalTriangle 
{
   OrderedPair pt1;
   OrderedPair pt2;
   OrderedPair pt3;

   public PedalTriangle(List<OrderedPair> triangle)
   {
      pt1 = triangle.get(0);
      pt2 = triangle.get(1);
      pt3 = triangle.get(2);
   }

   public List<OrderedPair> getPedalTriangle(OrderedPair p)
   {
      // I could probably solve this with some linear algebra, but no.
      ArrayList<OrderedPair> ans = new ArrayList<>();
      ans.add(getOrthogonalIntersection(p, pt1, pt2));
      ans.add(getOrthogonalIntersection(p, pt2, pt3));
      ans.add(getOrthogonalIntersection(p, pt1, pt3));

      return ans;
   }

   private static double slope(OrderedPair a, OrderedPair b) {
      return (a.getY() - b.getY())/(a.getX() - b.getX());
   }

   // Point p, two points which make up a side of the triangle.
   private static OrderedPair getOrthogonalIntersection(OrderedPair p, OrderedPair p1, OrderedPair p2) {
      var m1 = slope(p1, p2);

      if (m1 == 0) {
         // Horizontal; we need vertical
         return new OrderedPair(p.getX(), p1.getY());
      } else if (!Double.isFinite(m1)) {
         // Vertical; we need horizontal
         return new OrderedPair(p1.getX(), p.getY());
      }

      var b1 = -1.0 * m1 * p1.getX() + p1.getY();
      var m2 = -1.0 / m1;
      var b2 = -1.0 * m2 * p.getX() + p.getY();

      var result = Determinants.cramer(new double[][] {
              {m1, -1, -b1},
              {m2, -1, -b2}
      });

      if (result == null)
         return null;
      return new OrderedPair(result[0][0], result[1][0]);
   }
}