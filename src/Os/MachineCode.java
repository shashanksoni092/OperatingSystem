package Os;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class MachineCode {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/shashanksoni092/input.txt");
        Scanner scanner = new Scanner(file);
        PrintWriter printWriter = new PrintWriter("output.txt");
        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split(" ");
            if (fields.length == 2) {
                printWriter.println(String.format("LD R0, %s", fields[1]));
                printWriter.println(String.format("ST %s, R0", fields[0]));
            } else if (fields.length == 4) {
                printWriter.println(String.format("LD R0, %s", fields[1]));
                switch (fields[2]) {
                    case "+":
                        printWriter.println(String.format("ADD R0, %s", fields[3]));
                        break;
                    case "-":
                        printWriter.println(String.format("SUB R0, %s", fields[3]));
                        break;
                    case "*":
                        printWriter.println(String.format("MUL R0, %s", fields[3]));
                        break;
                    case "/":
                        printWriter.println(String.format("DIV R0, %s", fields[3]));
                        break;
                    default:
                        printWriter.println("Unsupported Operator");
                }
                printWriter.println(String.format("ST %s, R0", fields[0]));
            }
        }
        printWriter.close();
    }
}
