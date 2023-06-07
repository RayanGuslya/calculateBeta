import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class calculatirBeta {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String html = "D:" + separator + "java" + separator + "ReadingAFile" + separator + "input.txt";
        File file = new File(html);
        Scanner scanner = new Scanner(file);

        String num[] = scanner.nextLine().split(" ");
        scanner.close();
        double a, b;
        boolean flag = true;
        try{
            a = Double.parseDouble(num[0]);
            b = Double.parseDouble(num[2]);
        }catch (NumberFormatException ex){
            System.out.println("Error! Not number");
            flag = false;
            return;
        }
        if ("+-*/".contains(num[1]) && flag){
            switch (num[1]){
                case "+":{
                    System.out.println(a+b);
                    break;
                }
                case "-": {
                    System.out.println(a-b);
                    break;
                }
                case "*": {
                    System.out.println(a*b);
                    break;
                } case "/": {
                    if (b != 0.0){
                        System.out.println(a/b);
                    }else System.out.println("Error! Division by zero");
//                    if (b ==0.0){
//                        throw new ArithmeticException("Деление на ноль недопутсимо");
//                    }
//                    System.out.println(a/b);
                    break;
                    }

            }
        }else {
            System.out.println("Operation Error!");
        }
    }
}
