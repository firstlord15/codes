import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamApi<T> {
    List<T> list;

    public MyStreamApi(List<T> list) {
        this.list = list;
    }

    public MyStreamApi() {
        this.list = new ArrayList<>();
    }

    public void of(List<T> data) {
        this.list = data;
    }

    public MyStreamApi<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return new MyStreamApi<>(result);
    }

    public MyStreamApi<T> forEach() {
        for (T element: list){
            System.out.println(element);
        }

        return new MyStreamApi<>(list);
    }

    public MyStreamApi<T> forEach(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T element: list){
            if (predicate.test(element)){
                System.out.println(element);
                result.add(element);
            }
        }
        list.stream().map(String::valueOf);
        return new MyStreamApi<>(result);
    }


    public <R> MyStreamApi<R> map(Function<? super T, ? extends R> mapper) {
        List<R> result = new ArrayList<>();

        return new MyStreamApi<R>();
    }
}
