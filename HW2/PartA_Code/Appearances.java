import java.util.*;
public class Appearances {
    public static <T> int sameCount(Collection<T> a, Collection<T> b) {
        Map<Integer,Integer> map1 = hashing(a);
        Map<Integer,Integer> map2 = hashing(b);

        int count = 0;
        for (int k : map1.keySet()) {
            if (map2.keySet().contains(k)) {
                if (map1.get(k) == map2.get(k)) count++;
            }
        }
        return count;
    }

    private static <T> Map<Integer,Integer> hashing(Collection<T> a) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int val = 0, key = 0;

        for (T t : a) {
            key = t.hashCode();
            if (map.containsKey(key)) {
                val = map.get(key);
                map.put(key, val+1);
            }
            else {
                map.put(key, 1);
            }
        }

        return map;
    }
}