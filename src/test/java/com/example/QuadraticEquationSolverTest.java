package com.example;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class QuadraticEquationSolverTest {

 private static void writeResultToCSV(String testName,String x1, String x2, String result, boolean isSuccess) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("test_results.csv", true))) {
        writer.println(testName + ",                                               " + x1 + ",            " + x2 + ",        " + result + ",      " + (isSuccess ? "Passed" : "Failed") );
    } catch (IOException e) {
        e.printStackTrace();
    }
 } @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_TresGrandNegatif_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -8.47188040884873E8;
        double c = 4.308886599969666E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_TresProcheDeZeroPositif_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.496494377222994E-7;
        double b = 9.67646323233986E-7;
        double c = -5.391455603670232E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_TresGrandPositif_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.150309980809922E-7;
        double b = 1.0192767450254987E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_TresProcheDeZeroNegatif_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.1721351455715574;
        double b = -5.315535668269894E-7;
        double c = -1.1867169950204634E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_ProcheDeZeroNegatif_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.3303905518604564;
        double b = -3.2583835729367303;
        double c = 94.03770064143211;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_NegatifNormal_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 111.02947809107067;
        double b = -170.43283709147101;
        double c = -1.447728871845817;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_Zero_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -367.3707995074564;
        double b = 0.0;
        double c = 5.227636446539286E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_ProcheDeZeroPositif_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.3567337071117413E8;
        double b = 1.3487956745094642;
        double c = 1.969140496778527;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_PositifNormal_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.7655405950665855E8;
        double b = 69.92083983748242;
        double c = -422.8487045049683;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_Zero_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 0.0;
        double c = -9.000415028332279E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_Zero_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 6.064445288205587E-7;
        double b = 0.0;
        double c = 2.470825587678944;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_Zero_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.655637403108914E-7;
        double b = 0.0;
        double c = -4.112635729685522;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_Zero_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.867347714692491;
        double b = 0.0;
        double c = 9.550428886221555E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_Zero_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.9731824706718042;
        double b = 0.0;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_Zero_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 79.02638254964289;
        double b = 0.0;
        double c = 436.90378115337705;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_TresProcheDeZeroPositif_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -64.46594749825397;
        double b = 9.99031888684411E-7;
        double c = -256.3255858246358;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_Zero_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.910868517698131E8;
        double b = 0.0;
        double c = -2.0111594486000387E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_Zero_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.13457191551518E8;
        double b = 0.0;
        double c = 134.57574422924267;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_TresProcheDeZeroNegatif_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -3.5547334839610555E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_ProcheDeZeroPositif_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 4.40205076778375;
        double c = -2.251759397078684;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_ProcheDeZeroNegatif_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -2.0852187638955755;
        double c = 3.007559035092372;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_PositifNormal_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 111.5081308093522;
        double c = -8.464248894463781E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_NegatifNormal_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -169.90627828479415;
        double c = -10.920829525990655;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_TresGrandPositif_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 4.5728495655664486E8;
        double c = 7.124176083271793E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_TresGrandNegatif_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.508297423489171E-7;
        double b = -6.997693022695395E8;
        double c = -4.958622982452169E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_ProcheDeZeroNegatif_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.509031854436958E-7;
        double b = -4.278663233506482;
        double c = -4.11237417963673E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_TresGrandNegatif_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.6299204196254067;
        double b = -4.299582447754675E8;
        double c = -9.236648447118664E7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_TresProcheDeZeroNegatif_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.6921786149042166;
        double b = -7.635592164594087E-7;
        double c = -9.993124082865427E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_TresGrandPositif_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 338.93549566984774;
        double b = 4.005209179020137E8;
        double c = -6.873619673737164E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_ProcheDeZeroPositif_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -105.15471718785022;
        double b = 2.2649193636928002;
        double c = -1.712160873640821E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_PositifNormal_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 6.965953813351082E8;
        double b = 119.03076493294816;
        double c = -8.483937486478161E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_NegatifNormal_C_TresGrandNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.5353505844087493E8;
        double b = -422.4187475423706;
        double c = -9.376087737011182E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_Zero_B_TresProcheDeZeroPositif_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 3.147212849045153E-7;
        double c = 423.2435557702306;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_ProcheDeZeroPositif_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.97292070789317E-7;
        double b = 3.145307279481161;
        double c = 6.011782501399921E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_TresGrandNegatif_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.892453859214318;
        double b = -4.786332590713494E8;
        double c = 3.733344254455257E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_TresGrandNegatif_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.705438419764439E-7;
        double b = -9.011138725705091E8;
        double c = -43.18755120741923;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_ProcheDeZeroPositif_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.3794510643589253;
        double b = 3.985731543546182;
        double c = -451.01875697249085;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_ProcheDeZeroNegatif_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 152.95171878365355;
        double b = -2.156653760835839;
        double c = -436.2221264049111;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_TresProcheDeZeroNegatif_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -281.8322350483351;
        double b = -7.442993604192827E-7;
        double c = 20.965767676407296;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_TresGrandPositif_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 6.298403377825955E8;
        double b = 2.746949988524992E7;
        double c = -119.24314536569977;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_ProcheDeZeroPositif_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.3302401926517498E8;
        double b = 2.5457430642913135;
        double c = 2.63707899615138E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_TresProcheDeZeroPositif_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.5447126266267874;
        double b = 2.4020511103896347E-7;
        double c = -1.4193473006656792;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_PositifNormal_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.0612075428237445E-7;
        double b = 453.41093964196097;
        double c = 27.168346481087866;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_NegatifNormal_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 6.112202629961219E8;
        double b = -355.7459613820815;
        double c = 7.005826985695889E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_PositifNormal_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 441.7773873122135;
        double b = 345.05750181860236;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_PositifNormal_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -9.315621680366241E-7;
        double b = 392.14958067875756;
        double c = 9.16430167781734E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_NegatifNormal_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.844992493639279E-7;
        double b = -167.8069513308543;
        double c = 4.456072219770071;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_TresGrandPositif_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.075604812951422;
        double b = 9.880962506420002E8;
        double c = -3.6909422606319198;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_TresGrandPositif_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -470.47899297041266;
        double b = 1.544192453877563E8;
        double c = 2.1709058461028587;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_TresGrandNegatif_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.211989918707646E8;
        double b = -1.3534021508495557E8;
        double c = 4.490603862133437;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_TresProcheDeZeroPositif_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 177.71488670982248;
        double b = 2.094921022968004E-7;
        double c = 4.299350894227459;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_TresProcheDeZeroNegatif_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.823182866731797E-7;
        double b = -1.5499954794137786E-7;
        double c = -285.4177756598795;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_ProcheDeZeroNegatif_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 6.73023106658809E-7;
        double b = -3.9221976151530185;
        double c = 1.617025325480435E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_ProcheDeZeroPositif_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 40.84441315408174;
        double b = 3.425087024186079;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_ProcheDeZeroNegatif_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.882079487865663E8;
        double b = -1.6731841726564207;
        double c = 3.930293075276871E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_NegatifNormal_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -23.235606614776373;
        double b = -64.06594510973417;
        double c = -6.44911272644851E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_TresProcheDeZeroPositif_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.101661459607252;
        double b = 5.394298956525694E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_PositifNormal_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.4123962429083012;
        double b = 305.68138695863405;
        double c = -279.88277782524403;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_TresGrandNegatif_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.8543875598888054E8;
        double b = -2.1693413236366284E8;
        double c = -1.356596741429421;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_TresProcheDeZeroNegatif_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 107.39979317498192;
        double b = -7.215506546657392E-7;
        double c = 2.706797507598834E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_TresProcheDeZeroPositif_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -5.594381735348139E8;
        double b = 8.501502497017077E-7;
        double c = -5.787450323146682E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_NegatifNormal_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.3774535569382775E-7;
        double b = -147.20187249803058;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_TresGrandPositif_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.372851730764587;
        double b = 7.474068143839954E8;
        double c = 85.14191731815919;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_TresProcheDeZeroPositif_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -9.894176151085384E-7;
        double b = 4.661172762813564E-7;
        double c = 3.6467556489897925E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_TresGrandPositif_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.381768350106146;
        double b = 1.9231036296480364E8;
        double c = 4.7909410418909015;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_ProcheDeZeroNegatif_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -177.65555880314264;
        double b = -4.596048230831251;
        double c = 6.631249989287144E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_ProcheDeZeroNegatif_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.0268137303558236E8;
        double b = -2.3975415907491997;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_TresProcheDeZeroNegatif_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.6105946564894438E8;
        double b = -6.69784594621729E-7;
        double c = -2.3923564469729155;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_ProcheDeZeroPositif_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.348258277890847E-7;
        double b = 2.0855472271518614;
        double c = -6.295352497409538E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_PositifNormal_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.7577480816274016;
        double b = 196.88825683728638;
        double c = 1.1805842365972015E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_TresProcheDeZeroPositif_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.7295162624155235E8;
        double b = 3.66588882661064E-7;
        double c = 1.626543473301858E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_TresGrandNegatif_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.714633226641777E8;
        double b = -5.14973253067472E7;
        double c = 342.7222107770022;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_NegatifNormal_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.759604468018395;
        double b = -498.2826378484479;
        double c = 3.0347683419002376E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_TresGrandNegatif_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -53.16494239838232;
        double b = -5.3305313326113063E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandPositif_B_TresProcheDeZeroNegatif_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.735332822385613E8;
        double b = -2.151338139404537E-7;
        double c = 4.8292231828808845;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_TresGrandPositif_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.654976460127265E-7;
        double b = 2.69586644739298E8;
        double c = -5.950769271762718E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_PositifNormal_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -28.531533913764918;
        double b = 464.41466041006254;
        double c = -1.0546183837631382;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_ProcheDeZeroNegatif_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.2990164576205183;
        double b = -1.665175561130967;
        double c = -1.3253710580082934;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_TresGrandNegatif_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 228.01211385438748;
        double b = -8.829214862967399E8;
        double c = -8.013719861819792E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_ProcheDeZeroPositif_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.497333490442328E-7;
        double b = 2.9313371817321863;
        double c = 429.8364367880105;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_NegatifNormal_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.684284543223291;
        double b = -344.66053703581855;
        double c = 2.5909533454824403;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroNegatif_B_ProcheDeZeroPositif_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.3474983103412437;
        double b = 2.3546720618691315;
        double c = -5.206506859807133E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_TresGrandNegatif_B_TresGrandPositif_C_Zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.298387194445417E8;
        double b = 7.026955560699801E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroNegatif_B_TresProcheDeZeroNegatif_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.613310559853002E-7;
        double b = -5.939012179376766E-7;
        double c = 6.829779747924505E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_TresProcheDeZeroPositif_C_ProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.121038497466858E-7;
        double b = 2.2524178061130052E-7;
        double c = -4.2521127249310595;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_Zero_C_TresGrandPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 325.7108366541379;
        double b = 0.0;
        double c = 8.100505240799689E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_NegatifNormal_B_Zero_C_NegatifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -232.18140989822882;
        double b = 0.0;
        double c = -337.82981181450816;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_ProcheDeZeroNegatif_C_TresProcheDeZeroNegatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.390948327393937;
        double b = -3.399588004833753;
        double c = -9.669997165457707E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveA_TresProcheDeZeroPositif_B_PositifNormal_C_ProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.630649557088944E-7;
        double b = 487.97532996291875;
        double c = 1.9328979451949442;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_PositifNormal_B_NegatifNormal_C_PositifNormal_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 319.7390179564926;
        double b = -439.1479611541207;
        double c = 364.84105323611004;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveA_ProcheDeZeroPositif_B_TresGrandPositif_C_TresProcheDeZeroPositif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.223898099792806;
        double b = 5.309861808642752E7;
        double c = 9.195814962925743E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


}
