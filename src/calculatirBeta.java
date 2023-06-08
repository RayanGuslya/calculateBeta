

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
            FileWriter fileWriter = new FileWriter("input.txt", false);
            Throwable var5 = null;

            try {
                fileWriter.write(number);
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
            FileWriter fileWriter = new FileWriter("output.txt", false);

            try {
                a = Double.parseDouble(num[0]);
                b = Double.parseDouble(num[2]);
            } catch (NumberFormatException var23) {
                String error = "Error! Not number";
                System.out.println(error);
                fileWriter.write(error);
                fileWriter.close();
                return;
            }
        } catch (Exception var24) {
            System.out.println("Fuck");
        }

        try {
            FileWriter fileWriter = new FileWriter("output.txt", false);
            if ("+-*/".contains(num[1]) && flag) {
                double answer;
                switch (num[1]) {
                    case "+":
                        answer = a + b;
                        System.out.println(answer);
                        fileWriter.write(Double.toString(answer));
                        fileWriter.close();
                        break;
                    case "-":
                        answer = a - b;
                        System.out.println(answer);
                        fileWriter.write(Double.toString(answer));
                        fileWriter.close();
                        break;
                    case "*":
                        answer = a * b;
                        System.out.println(answer);
                        fileWriter.write(Double.toString(answer));
                        fileWriter.close();
                        break;
                    case "/":
                        if (b != 0.0) {
                            answer = a / b;
                            System.out.println(answer);
                            fileWriter.write(Double.toString(answer));
                            fileWriter.close();
                        } else {
                            String error = "Error! Division by zero";
                            System.out.println(error);
                            fileWriter.write(error);
                            fileWriter.close();
                        }
                }
            } else {
                String error = "Operation Error!";
                System.out.println(error);
                fileWriter.write(error);
                fileWriter.close();
            }
        } catch (IOException var27) {
            System.out.println("Возникла ошибка" + var27.getMessage());
        }

    }
}