package com.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class TestCodeGenerator {
    
     public static void main(String[] args) {
        
        String fichier = "testCases.txt";
        String testCaseFile = fichier;
        String fichier2 = "src\\test\\java\\com\\example\\QuadraticEquationSolverTest.java";
        String filePath = fichier2;
        String testPrefixMethod = "testSolve";

        String fileHeader="package com.example;\n" + 
                "import static org.junit.Assert.assertEquals;\n" +
                "import org.junit.Test;\n" +
                "import java.io.FileWriter;\n" +
                "import java.io.IOException;\n" +
                "import java.io.PrintWriter;\n" +
                "import java.lang.reflect.InvocationTargetException;\n\n" +
                "public class QuadraticEquationSolverTest {\n\n"+
                " private static void writeResultToCSV(String testName,String x1, String x2, String result, boolean isSuccess) {\n"+
                "    try (PrintWriter writer = new PrintWriter(new FileWriter(\"test_results.csv\", true))) {\n"+
                "        writer.println(testName + \",                                               \" + x1 + \",            \" + x2 + \",        \" + result + \",      \" + (isSuccess ? \"Passed\" : \"Failed\") );\n"+
                "    } catch (IOException e) {\n"+
                "        e.printStackTrace();\n"+
                "    }\n"+
                " }";

        String fileFooter ="}\n";

        String fileContent="";

        try (BufferedReader br = new BufferedReader(new FileReader(testCaseFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");

                 // Add a check to ensure the array has the expected length
                if (values.length < 4) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
                System.out.println("String " + values[1]);
                HashMap<String,Double> a = equivalentClassesRandomValue(values[1]);
                HashMap<String,Double> b = equivalentClassesRandomValue(values[2]);
                HashMap<String,Double> c = equivalentClassesRandomValue(values[3]);
                System.out.println("a " + a + " b " + b +" c "+ c);


                String testName = testPrefixMethod;
                String a_key="";
                String b_key="";
                String c_key="";

                for (String key : a.keySet()) {
                    a_key=key;
                }
                 for (String key : b.keySet()) {
                    b_key=key;
                }
                for (String key : c.keySet()) {
                    c_key=key;
                }

                
                fileContent+= generateTestCode(testName+a_key+b_key+c_key, a.get(a_key), b.get(b_key), c.get(c_key));
                System.out.println("fileContent "+ fileContent);

            }
        } catch (IOException e) {
            System.out.println("HERE "+ e);

            e.printStackTrace();
        }


         try (FileWriter writer = new FileWriter(filePath)) {
                    writer.write(fileHeader+fileContent+fileFooter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
       
    }

    private  static String generateTestCode(String testName, double a, double b, double c) {

        double tolerance = 1e-5;
        if(Math.abs(a) < tolerance){
            
            
            return String.format(
                " @Test(expected = InvocationTargetException.class)\n" +
                " public void %s() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {\n"+
                "        double a = %s;\n" +
                "        double b = %s;\n" +
                "        double c = %s;\n\n" +
                "        Class<?> dynamicClass = Class.forName(\"com.example.equation.QuadraticEquationSolver\");\n" +
                "        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();\n" +
                "        try {\n"+
                "          writeResultToCSV(\"(\"+a+\")\"+\"x^2 + \"+\"(\"+b+\")\"+\"x + \"+\"(\"+c+\")\"+\" = 0\", \"N/a\", \"N/a\", \"liniear equation\", true);\n"+
                "          dynamicClass.getMethod(\"solve\", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);\n"+
                "        } catch (IllegalArgumentException e) {\n"+
                "          System.err.println(e.getMessage());\n"+
                "         }\n"+ 
                " }\n\n\n",
                testName, a, b, c);
        } else{
            return String.format(
                " @Test\n" +
                " public void %s() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {\n"+
                "        double a = %s;\n" +
                "        double b = %s;\n" +
                "        double c = %s;\n\n" +
                "        Class<?> dynamicClass = Class.forName(\"com.example.equation.QuadraticEquationSolver\");\n" +
                "        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();\n" +
                "        try {\n"+
                "          double[] solutions = (double[]) dynamicClass.getMethod(\"solve\", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);\n"+
                "          if (solutions.length > 0) {\n"+
                "              System.out.print(\"Solutions : \");\n"+
                "              double expected = 0;\n"+
                "              for (double solution : solutions) {\n"+
                "                  System.out.print(solution + \" \");\n"+
                "                  // Use assert for each solution\n"+
                "                  expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;\n"+
                "                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));\n"+
                "                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision\n"+
                "                  assertEquals(0, expected, delta);\n"+
                "              }\n"+
                "              writeResultToCSV(\"(\"+a+\")\"+\"x^2 + \"+\"(\"+b+\")\"+\"x + \"+\"(\"+c+\")\"+\" = 0\", \"\" + solutions[0], \"\"+solutions[1], \"\"+expected, true);\n"+
                "          } else {\n"+
                "              System.out.println(\"Pas de solution réelle.\");\n"+
                "              // Use assert for the case with no solution\n"+
                "              assertEquals(0, solutions.length);\n"+
                "              writeResultToCSV(\"(\"+a+\")\"+\"x^2 + \"+\"(\"+b+\")\"+\"x + \"+\"(\"+c+\")\"+\" = 0\", \"N/a\", \"N/a\", \" \", true);\n"+
                "          }\n"+
                "        } catch (IllegalArgumentException e) {\n"+
                "          System.err.println(e.getMessage());\n"+
                "         }\n"+ 
                " }\n\n\n",
                testName, a, b, c);
        }
    }

     ///gives a random value in the corresponding equivalent class
    ///@param String value eg 1a or 2e or 3d
    static HashMap<String, Double>  equivalentClassesRandomValue(String input) {
        //Create a Map to store the string and value
        HashMap<String, Double> result = new HashMap<>();

        System.out.println("input:" + input +"lenght:"+ input.length() + "character"+ input.charAt(3));

        char letter = input.charAt(3);
        
        double value = 0.0;
        String label;
        if (input.contains("1")) {
            label = "A";
        } else if (input.contains("2")) {
            label = "B";
        } else {
            label = "C";
        }

        System.out.println("letter" + letter);

        switch (letter) {
            case 'a':
                value = 0.0;
                label = label + "_Zero_";
                break;
            case 'b':
                value = ThreadLocalRandom.current().nextDouble(1e-7, 1e-6);
                label = label + "_TresProcheDeZeroPositif_";
                break;
            case 'c':
                value = ThreadLocalRandom.current().nextDouble(-1e-6, -1e-7);
                label = label + "_TresProcheDeZeroNegatif_";
                break;
            case 'd':
                value = ThreadLocalRandom.current().nextDouble(1, 5);
                label = label + "_ProcheDeZeroPositif_";
                break;
            case 'e':
                value = ThreadLocalRandom.current().nextDouble(-5, -1);
                label = label + "_ProcheDeZeroNegatif_";
                break;
            case 'f':
                value = ThreadLocalRandom.current().nextDouble(10, 500);
                label = label + "_PositifNormal_";
                break;
            case 'g':
                value = ThreadLocalRandom.current().nextDouble(-500, -10);
                label = label + "_NegatifNormal_";
                break;
            case 'h':
                value = ThreadLocalRandom.current().nextDouble(1e6, 1e9);
                label = label + "_TresGrandPositif_";
                break;
            case 'i':
                value = ThreadLocalRandom.current().nextDouble(-1e9, -1e6);
                label = label + "_TresGrandNegatif_";
                break;
            default:
                throw new IllegalArgumentException("Caractère invalide dans la chaîne d'entrée.");
        }

        result.put(label, value);
        return result;
    }
    

}


