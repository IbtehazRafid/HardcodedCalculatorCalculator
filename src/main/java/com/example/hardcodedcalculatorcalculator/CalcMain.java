package com.example.hardcodedcalculatorcalculator;

import java.io.*;

public class CalcMain {
    public static void calculate(double num1, double num2, String operation) throws IOException, InterruptedException {
        double result = 0;
        switch (operation) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
        }

        String className = "HardcodedCalc";
        String baseDir = System.getProperty("user.dir") + "/src/main/java/com/example/hardcodedcalculatorcalculator/";
        String filePath = baseDir + className + ".java";
        makeNewClassFile(className, filePath, num1, num2, operation, result);
        String classOutput = System.getProperty("user.dir") + "/src/main/java";
        Process compile = Runtime.getRuntime().exec(
                new String[] {
                        "javac",
                        "-d", classOutput,
                        filePath
                }
        );
        compile.waitFor();
        String classpath = System.getProperty("user.dir") + "/src/main/java";
        Process proc = Runtime.getRuntime().exec(
                new String[] {
                        "java",
                        "-cp", classpath,
                        "com.example.hardcodedcalculatorcalculator." + className
                }
        );
        new Thread(() -> copy(proc.getInputStream(), System.out)).start();
        new Thread(() -> copy(proc.getErrorStream(), System.err)).start();
        proc.waitFor();
    }

    public static void makeNewClassFile(String className, String filePath, double a, double b, String operation, double result) throws IOException {
        try (PrintWriter theThinker = new PrintWriter(new FileWriter(filePath))) {
            theThinker.println("package com.example.hardcodedcalculatorcalculator;");
            theThinker.println("import java.io.FileWriter;");
            theThinker.println("import java.io.IOException;");
            theThinker.println("import java.io.PrintWriter;");
            theThinker.println("public class " + className + " {");
            theThinker.println("    public static void main(String[] args) {");
            theThinker.println("        double a = " + a + ";");
            theThinker.println("        double b = " + b + ";");
            theThinker.println("        String operation = \"" + operation + "\";");
            theThinker.println("        if (a == " + a + " && operation.equals(\"" + operation + "\") && b == " + b + ") {");
            theThinker.println("            double result = "+ result +";");
            theThinker.println("            try (PrintWriter out = new PrintWriter(new FileWriter("
                    + "\"src/main/java/com/example/hardcodedcalculatorcalculator/result.txt\", false))) {");
            theThinker.println("                out.println(result);");
            theThinker.println("            } catch (IOException e) { e.printStackTrace(); }");
            theThinker.println("        } else {");
            theThinker.println("            System.out.println(\"I couldn't hardcode myself to do this :(\");");
            theThinker.println("        }");
            theThinker.println("    }");
            theThinker.println("}");
        }
    }

    private static void copy(InputStream in, OutputStream out) {
        try (in; out) {
            in.transferTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}