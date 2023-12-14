import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("Man1", "Man2", "Man3", "man4", "Woman1", "Woman2", "woman3", "Woman4");
        MyStreamApi<String> myStreamApi = new MyStreamApi<>();

        myStreamApi.of(input);
        myStreamApi
                .filter(p -> p.startsWith("M"))
                .forEach();
    }
}