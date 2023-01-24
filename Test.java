
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(validate(in.nextLine()));

    }

    private static String validate(String str) {
        if (str == null || str.length() < 1 || str.matches("[^()]")) {
            return "";
        }

        String[] array = new String[str.length()];
        StringBuilder result = new StringBuilder();
        String[] input = str.split("");

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                array[i] = input[i];
            }else {
                if (i != 0) {
                    for (int k = i; k >= 0; k--) {
                        if (k == 0){
                            array[i] = input[i];
                            break;
                        }
                        if(array[k - 1] != null && !array[k - 1].equals(")")) {
                            array[k - 1] = null;
                            break;
                        }
                    }
                }else {
                    array[i] = input[i];
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (array[i] == null) {
                result.append(input[i]);
            }
        }
        if (result.length() != 0) {
            return result.length() + "-" + result;
        } else {
            return "0";
        }
    }
}
