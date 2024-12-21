package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filepath;
    private Map<String, String> dictionary;

    public FileKV(String filepath, Map<String, String> dictionary) {
        this.filepath = filepath;
        this.dictionary = new HashMap<>(dictionary);
        Utils.writeFile(filepath, Utils.serialize(dictionary));
    }

    @Override
    public void set(String key, String value) {
        dictionary.put(key, value);
        Utils.writeFile(filepath, Utils.serialize(dictionary));
    }

    @Override
    public void unset(String key) {
        dictionary.remove(key);
        Utils.writeFile(filepath, Utils.serialize(dictionary));
    }

    @Override
    public String get(String key, String defVal) {
        String data = Utils.readFile(filepath);
        Map<String, String> newDictionary = Utils.deserialize(data);
        return newDictionary.getOrDefault(key, defVal);
    }

    @Override
    public Map<String, String> toMap() {
        String data = Utils.readFile(filepath);
        return Utils.deserialize(data);
    }
}
// END
