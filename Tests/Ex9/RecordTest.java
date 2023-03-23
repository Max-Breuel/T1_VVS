package Ex9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {
    @ParameterizedTest
    @CsvSource({
        "max,20",
        "pedro,30",
        "rolim,14"
    })
    void getName(String name, int score) {
        Record record = new Record(name, score);
        assertEquals(name, record.getName());
    }

    @ParameterizedTest
    @CsvSource({
            "max,20",
            "pedro,30",
            "rolim,14"
    })
    void getScore(String name, int score) {
        Record record = new Record(name, score);
        assertEquals(score, record.getScore());
    }
    @ParameterizedTest
    @CsvSource({
            "max,20",
            "pedro,30",
            "rolim,14"
    })
    void testToString(String name, int score) {
        Record record = new Record(name, score);
        assertEquals("Record [name=" + name + ", score=" + score + "]", record.toString());
    }
}