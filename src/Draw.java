import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Draw {
    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> exmp = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
//
//        StringBuilder str = new StringBuilder();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        int rowNum = 0;
//        while (scanner.hasNextLine()) {
//            ArrayList<Integer> integerArrayList = new ArrayList<>();
//            String retrievedStr = scanner.next();
//            if (retrievedStr.matches("(\\s*\\d+)+")) {
//                String[] retrievedDigits = retrievedStr.split("\\s+");
//                for (String digit : retrievedDigits) {
//                    integerArrayList.add(Integer.parseInt(digit));
//                }
//                /// здесь делаем проверку n-ой строки матрици с первой строкой
//                if (exmp.isEmpty()) {
//                    exmp.add(rowNum, integerArrayList);
//                    rowNum++;
//                } else if (exmp.get(0).size() != integerArrayList.size()) {
//                    System.out.println("Строка " + integerArrayList + " не сответствует ко-лву колонок первой строки "+ exmp.get(0));
//                    break;
//                }
//            } else {
//                System.out.println("Некорректный ввод матрици, начните заново!");
//                break;
//            }
//        }
//        System.out.println( "Матрица: " +exmp);
////            System.out.println(str);
//
//    }
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(arrayList.size());
    }
}