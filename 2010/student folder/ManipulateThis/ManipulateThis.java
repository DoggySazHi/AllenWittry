import java.util.*;

public class ManipulateThis 
{
   // add your own instance variables
   private StringBuilder sb;

   public ManipulateThis(String s)
   {
      sb = new StringBuilder(s);
   }

   public String toString()   // directive 1
   {
      // add your own implementation
       return sb.toString();
   }

   public void assign(String s)   // directive 2
   {
      sb = new StringBuilder(s);
   }

   public void reverse(int a, int b)  // directive 3
   {
      sb.replace(a, b + 1, new StringBuilder(sb.substring(a, b + 1)).reverse().toString());
   }

   public void swap(int a, int b)  // directive  4
   {
      var temp = sb.charAt(a);
      sb.setCharAt(a, sb.charAt(b));
      sb.setCharAt(b, temp);
   }

   public void insert(String s, int a)  // directive 5
   {
      sb.insert(a, s);
   }

   public void substitute(String s1, String s2)   // directive 6
   {
      var a = sb.indexOf(s1);
      if (a < 0)
         return;
      sb.replace(a, a + s1.length(), s2);
   }

   public void delete(int a, int b)    // directive 7
   {
      sb.delete(a, b + 1);
   }

   public void replace(String s1, String s2)  // directive 8
   {
      for(int i = sb.length() - s1.length(); i >= 0; --i)
         if (i + s1.length() <= sb.length() && sb.substring(i, i + s1.length()).equals(s1))
            sb.replace(i, i + s1.length(), s2);
   }

   public void changeCase()    // directive 9
   {
      for (int i = 0; i < sb.length(); i++) {
         if (Character.isUpperCase(sb.charAt(i)))
            sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
         else if (Character.isLowerCase(sb.charAt(i)))
            sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
      }
   }

   public void append(String temp)    // directive 10
   {
      sb.append(temp);
   }

   public void repeat(int a, int b)    // directive 11
   {
      sb.append(sb.substring(a, b + 1));
   }
}