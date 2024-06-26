
import java.util.Scanner;

public class MainCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //объявляем сканер sc
        System.out.println("Введите данные:"); // сообщение о вводе данных
        String in = sc.nextLine(); //чтение строки ввода читает следующую строку

        try { //обрабатываем исключения определяем блок где происходит исключение
            String res = calc(in); //ввод данных
            System.out.println("Результат:" + res); //выводим текст
        } catch (ArithmeticException e) { //определяем блок кода где происходит исключение
            System.out.println("Ошибка " + e.getMessage()); //ловим ошибку
        }
    }

    public static String calc(String in) { //объявляем метод калькулятор
        String[] numbers = in.split(" "); // ввод данных массива и разделение строки на части возврат
        if (numbers.length != 3) { //если длинна чисел не три
            throw new IllegalArgumentException("Неправильный ввод, введите в формате a + b"); //вывод ошибки
        }
        int num1 = Integer.parseInt(numbers[0]); //преобразование строки ввода первого числа в целое число
        String operator = numbers[1];// ввод арифметического оператора
        int num2 = Integer.parseInt(numbers[2]); //преобразование строки ввода второго числа в целое число
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) { // исключаем диапазон чисел
            throw new IllegalArgumentException("Веедите от 1 до 10");
        }
        return operation (num1, operator, num2);
        // выполнение операции и возврат в виде строки
    }

    public static String operation(int num1, String operator, int num2)
    {
        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Деление на 0 невозможно");
                }
                result = num1 / num2;
                break;

            default:
                throw new IllegalArgumentException("используйте правильный оператор");
        }
        return Integer.toString(result);
    }

}







