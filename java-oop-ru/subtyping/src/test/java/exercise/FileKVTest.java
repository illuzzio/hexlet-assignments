package exercise;

import java.io.File;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {
    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    void testSetAndGet() {
        KeyValueStorage storage = new FileKV(filepath.toString(), Map.of("key1", "value1"));
        storage.set("key2", "value2");
        assertThat(storage.get("key1", "default")).isEqualTo("value1");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");
    }

    @Test
    void testUnset() {
        KeyValueStorage storage = new FileKV(filepath.toString(), Map.of("key1", "value1"));
        storage.unset("key1");
        assertThat(storage.get("key1", "default")).isEqualTo("default");
    }

    @Test
    void testToMap() {
        KeyValueStorage storage = new FileKV(filepath.toString(), Map.of("key1", "value1"));
        storage.set("key2", "value2");
        Map<String, String> expected = Map.of("key1", "value1", "key2", "value2");
        assertThat(storage.toMap()).isEqualTo(expected);
    }

    @Test
    void testOverWrite() {
        KeyValueStorage storage = new FileKV(filepath.toString(), Map.of("key1", "value1"));
        storage.set("key1", "value2");
        assertThat(storage.get("key1", "default")).isEqualTo("value2");
    }
    // END
}
