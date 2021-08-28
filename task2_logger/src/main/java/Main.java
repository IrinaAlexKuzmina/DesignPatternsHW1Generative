import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getInstance();
        log.log("Начинаем в main");

        Scanner scan = new Scanner(System.in);
        log.log("scanner is run");

        log.log("Просим пользователя ввести размер списка");
        System.out.println("Введите размер списка: ");
        int n = scan.nextInt();
        log.log("размер списка = " + n);

        log.log("Просим пользователя ввести верхнюю границу для значений");
        System.out.println("Введите верхнюю границу для значений: ");
        int maxValue = scan.nextInt();
        log.log("верхняя граница для значений = " + maxValue);

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) list.add(random.nextInt(maxValue));
        log.log("создали массив " + list.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));

        log.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");
        MyFilter filter = new MyFilter(scan.nextInt());
        log.log("filter = " + filter.getTreshold() + ". Вызываем фильтрацию");
        list = filter.filterOut(list);

        log.log("Выводим отфильтрованный список на экран");
        System.out.println("Отфильтрованный список: " + list.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));

        log.log("Все прошло успешно");
    }
}