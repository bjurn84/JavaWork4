//Реализовать консольное приложение, которое:
//
//        Принимает от пользователя строку вида text~num
//
//        Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//
//        Если введено print~num, выводит строку из позиции num в связном списке.
//
//        Если введено exit, завершаем программу
//
//        Пример:
//        string~4
//        num~3
//        print~3
//
//        num
//        print~4
//        string
//        my_value~1
//        print~1
//        my_value




import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> resultList = new ArrayList<>();
        menu(resultList);
    }

    public static void menu(ArrayList<String> source) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                1. Введите текст в формате 'text~num'.\\s
                2. Введите 'print~(num)' для вывода в консоль.\\s
                3. Введите 'exit' для завершения программы.""");
        while (true) {
            String text = sc.nextLine();
            try {
                if (text.equals("exit")) {
                    break;
                }
                String[] split = text.split("~");
                Integer.parseInt(split[1]);
                addArray(text, list);
            } catch (Exception e) {
                System.out.println("Неправильная команда");
            }
        }
    }

    public static void addArray(String text, ArrayList<String> list) {
        String[] subArray = text.split("~");
        int num = Integer.parseInt(subArray[1]);
        int localSize = num - list.size();
        for (int i = 0; i <= localSize; i++) {
            list.add(null);
        }
        if (subArray[0].equals("print")) {
            System.out.println(list.get(num));
        } else {
            list.set(num, subArray[0]);
        }
    }
}

