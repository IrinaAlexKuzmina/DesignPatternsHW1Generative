import java.util.ArrayList;
import java.util.List;

public class MyFilter {
    private final int treshold;

    public int getTreshold() {
        return treshold;
    }

    public MyFilter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger log = Logger.getInstance();
        log.log("Запускается фильтрация с treshold = " + this.treshold);
        List<Integer> result = new ArrayList<>();
        log.log("source.size() = " + source.size());
        for (int i : source) {
            if (i < this.treshold) {
                log.log(" Элемент " + i + " пропускаем");
            } else {
                result.add(i);
                log.log(" Элемент  " + i + " был добавлен в массив");
            }
        }
        log.log("result.size() = " + result.size());
        log.log("Фильтрация прошла успешно, выходим");
        return result;
    }
}