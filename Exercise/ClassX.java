package Exercise;

public class ClassX {
          private String name;
          public ClassX(String n) { name = n; }
       
      public static void main(String[] args) {
               ClassX one = new ClassX("g1");
               ClassX two = new ClassX("g2");
               System.out.println(one.name);
               System.out.println(two.name);
              one = two;
              two = null;
              one = null;
              System.out.println(one.name);
              System.out.println(two.name);
         }}
