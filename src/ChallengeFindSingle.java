import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ChallengeFindSingle {
    public static void main(String[] args) throws Exception {
        int[] arr = {7, 3, 7, 3, 12};
        int result = findSingle(arr);
        System.out.printf("%d is single", result);
    }

    public static int findSingle(int[] arr) throws Exception {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int key : arr) {
            counter.compute(key, (k, v) -> v == null ? 1 : v + 1);
        }
        Set<Integer> result = counter.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        if (result.isEmpty()) throw new Exception("No single integer found");
        if (result.size() > 1) throw new Exception("More than one single integer found");
        return result.iterator().next();
    }
}
