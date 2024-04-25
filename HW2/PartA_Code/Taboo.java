import java.util.*;

public class Taboo<T> {
    private List<T> rules;
    HashMap<T, HashSet<T>> database;
    Taboo(List<T> r) {
        rules = r;
        database = new HashMap<T, HashSet<T>>();
        T key = null;
        for (T val : rules) {
            if (key != null && val != null) {
                if (!database.containsKey(key)) database.put(key, new HashSet<T>());
                database.get(key).add(val);
            }
            key = val;
        }
    }

    public Set<T> noFollow(T elem) {
        if(database.containsKey(elem))
            return database.get(elem);
        return Collections.emptySet();
    }

    int i = 0;
    public void reduce(List<T> l) {
        T current = null;
        Iterator it = l.iterator();
        while(it.hasNext()){
            T next = (T)it.next();

            if (current != null && next != null && database.containsKey(current) && database.get(current).contains(next))
                it.remove();
            else
                current = next;
        }
    }
}