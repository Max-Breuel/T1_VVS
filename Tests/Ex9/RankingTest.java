package Ex9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RankingTest {
    Ranking ranking = new Ranking();
    @ParameterizedTest
    @CsvSource({
        "max,20",
        "pedro,30",
        "rolim,14"
    })
    void add(String name, int score) {
        Record record = new Record(name, score);
        assertTrue(ranking.add(record));
    }
   @ParameterizedTest
   @CsvSource ({"jose;2.Pedro;56.Antonio;49.Tomas;58,4",
            "jennifer;45.Augusto;467.Leandro;40.Alexandre;2020.pablo;49,5"
                            })
    void numRecords(String strings,int pos) {
        String[] s = strings.split("\\.");
        for (String value : s) {
            String[] s2 = value.split(";");
            ranking.add(new Record(s[0], Integer.parseInt(s2[1])));
        }
        assertEquals(pos,ranking.getPos());
    }
    @ParameterizedTest
    @CsvSource({
            "max,20",
            "pedro,30",
            "rolim,14"
    })
    void getScore() {
    }
    @ParameterizedTest
    @CsvSource({
            "max,20",
            "pedro,30",
            "rolim,14"
    })
    void worstScore() {
    }
    @ParameterizedTest
    @CsvSource({
            "max,20",
            "pedro,30",
            "rolim,14"
    })
    void bestScore() {
    }
}