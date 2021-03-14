import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class FunWithTriangles
{
    private final TriangleCoordinate vertexA;
    private final TriangleCoordinate vertexB;

    public FunWithTriangles(TriangleCoordinate ptA, TriangleCoordinate ptB)
    {
        vertexA = ptA;
        vertexB = ptB;
    }

    private TriangleCoordinate[] generateThings(double myArea) {
        // C'mon, Cirno's perfect math class didn't teach me this!
        var b = Math.sqrt(Math.pow(vertexA.getX() - vertexB.getX(), 2) + Math.pow(vertexA.getY() - vertexB.getY(), 2));
        // A = 1/2bh -> h = 2A / b
        var h = myArea * 2.0 / b;
        var mp = new TriangleCoordinate((vertexA.getX() + vertexB.getX()) / 2.0, (vertexA.getY() + vertexB.getY()) / 2.0);
        // Inverse slope
        var m = Math.atan2(vertexB.getY() - vertexA.getY(), vertexB.getX() - vertexA.getX());
        var m1 = m + Math.PI / 2;
        var m2 = m - Math.PI / 2;
        var p1 = new TriangleCoordinate(mp.getX() + h * Math.cos(m1), mp.getY() + h * Math.sin(m1));
        var p2 = new TriangleCoordinate(mp.getX() + h * Math.cos(m2), mp.getY() + h * Math.sin(m2));
        return new TriangleCoordinate[] {p1, p2};
    }

    /*
     *   Given two Vertices A and B of a rtiangle,
     *      there are two verices such that the triangle is isosceles and has area == myArea
     *      return the TriangleCoordinate of the third vertice with larger x value
     *      If both vertices have the same x coordinate, return the vetex witht he larger y coordinate
     */
    public TriangleCoordinate generateAreaWithLargestXcoordinate(double myArea)
    {
        var data = generateThings(myArea);
        if (data[0].getX() == data[1].getX())
            if (data[0].getY() > data[1].getY())
                return data[0];
            else
                return data[1];
        else if (data[0].getX() > data[1].getX())
            return data[0];
        return data[1];
    }

    /*
     *   Given two Vertices A and B of a rtiangle,
     *      there are two verices such that the triangle is isosceles and has area == myArea
     *      return the TriangleCoordinate of the third vertice with smaller x value
     *      IF both vertices have the same x coordinate, return the vetex witht he smaller y coordinate
     */    
    public TriangleCoordinate generateAreaWithSmallestXcoordinate(double myArea)
    {
        var data = generateThings(myArea);
        if (data[0].getX() == data[1].getX())
            if (data[0].getY() > data[1].getY())
                return data[1];
            else
                return data[0];
        else if (data[0].getX() > data[1].getX())
            return data[1];
        return data[0];
    }

}