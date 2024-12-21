package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage database) {
        Map<String, String> originalData = database.toMap();
        Map<String, String> swappedData = new HashMap<>();

        Set<Entry<String, String>> entries = originalData.entrySet();
        for (Entry<String, String> entry : entries) {
            swappedData.put(entry.getValue(), entry.getKey());
        }

        for (String key : originalData.keySet()) {
            database.unset(key);
        }

        for (Entry<String, String> entry : swappedData.entrySet()) {
            database.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
