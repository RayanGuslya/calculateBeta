

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class calculatirBeta {
    public calculatirBeta() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String[] num = number.split(" ");

        try {
            FileWriter fileWriter = new FileWriter("input.txt", true);
            Throwable var5 = null;

            try {
                fileWriter.write(number + "\n");
            } catch (Throwable var26) {
                var5 = var26;
                throw var26;
            } finally {
                if (fileWriter != null) {
                    if (var5 != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable var25) {
                            var5.addSuppressed(var25);
                        }
                    } else {
                        fileWriter.close();
                    }
                }

            }
        } catch (IOException var29) {
            System.out.println("Что то пошло не так " + var29.getMessage());
        }

        scanner.close();
        double a = 0.0;
        double b = 0.0;
        boolean flag = true;

        try {
            FileWriter fileWriter = new FileWriter("output.txt", true);

            try {
                a = Double.parseDouble(num[0]);
                b = Double.parseDouble(num[2]);
            } catch (NumberFormatException var23) {
                String error = "Error! Not number";
                String entry = (int) a + " "+ num[1]+ " " + (int) b + " = " +error + "\n";
                System.out.println(error);
                fileWriter.write(entry);
                fileWriter.close();
                return;
            }
        } catch (Exception var24) {
            System.out.println("Error");
        }

        try {
            FileWriter fileWriter = new FileWriter("output.txt", true);
            String entry;
            if ("+-*/".contains(num[1]) && flag) {
                double answer;

                switch (num[1]) {
                    case "+":
                        answer = a + b;
                        System.out.println(answer);
                        entry = ((int) a + " + " + (int) b + " = " +answer + "\n");
                        fileWriter.write(entry);
                        fileWriter.close();
                        return;
                    case "-":
                        answer = a - b;
                        System.out.println(answer);
                        entry = ((int)a + " - " +(int) b + " = " + answer + "\n");
                        fileWriter.write(entry);
                        fileWriter.close();
                        break;
                    case "*":
                        answer = a * b;
                        System.out.println(answer);
                        entry = (int) a + " * " + (int) b + " = " +answer + "\n";
                        fileWriter.write(entry);
                        fileWriter.close();
                        break;
                    case "/":
                        if (b != 0.0) {
                            answer = a / b;
                            System.out.println(answer);
                            entry = (int) a + " / " + (int) b + " = " +answer + "\n";
                            fileWriter.write(entry);
                            fileWriter.close();
                        } else {
                            String error = "Error! Division by zero";
                            System.out.println(error);
                            entry = (int) a + " / " + (int) b + " = " +error + "\n";
                            fileWriter.write(entry);
                            fileWriter.close();
                        }
                }
            } else {
                String error = "Operation Error!";
                System.out.println(error);
                entry = (int) a + " / " + (int) b + " = " +error + "\n";
                fileWriter.write(entry);
                fileWriter.close();
            }
        } catch (IOException var27) {
            System.out.println("Возникла ошибка" + var27.getMessage());
        }

    }
}