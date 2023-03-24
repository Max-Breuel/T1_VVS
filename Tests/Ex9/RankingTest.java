package Ex9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


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
            "jose;2.Pedro;56.Antonio;49.Tomas;58,0,58",
            "jennifer;45.Augusto;467.Leandro;40.Alexandre;2020.pablo;49,4,40",
            "jose;2.Pedro;56.Antonio;49.Tomas;58,3,2",
            "jennifer;45.Augusto;467.Leandro;40.Alexandre;2020.pablo;49,0,2020"
    })
    void getScore(String strings, int pos, int res) {
        String[] s = strings.split("\\.");
        for (String value : s) {
            String[] s2 = value.split(";");
            ranking.add(new Record(s[0], Integer.parseInt(s2[1])));
        }
        assertEquals(ranking.getScore(pos).getScore(),res);
    }
    @ParameterizedTest
    @CsvSource({
            "jose;2.Pedro;56.Antonio;49.Tomas;58,2",
            "jennifer;45.Augusto;467.Leandro;40.Alexandre;2020.pablo;49,40",
            "federico;9.roger;57.leo;4.amanda;50.frida;40,4"
    })
    void worstScore(String strings, int expectedValue) {
        String[] s = strings.split("\\.");
        for (String value : s) {
            String[] s2 = value.split(";");
            ranking.add(new Record(s[0], Integer.parseInt(s2[1])));
        }
        assertEquals(ranking.worstScore().getScore(), expectedValue);
    }
    @ParameterizedTest
    @CsvSource({
            "jose;2.Pedro;56.Antonio;49.Tomas;58,58",
            "jennifer;45.Augusto;467.Leandro;40.Alexandre;2020.pablo;49,2020",
            "federico;9.roger;57.leo;4.amanda;50.frida;40,57"
    })
    void bestScore(String strings, int expectedValue) {
        String[] s = strings.split("\\.");
        for (String value : s) {
            String[] s2 = value.split(";");
            ranking.add(new Record(s[0], Integer.parseInt(s2[1])));
        }
        assertEquals(ranking.bestScore().getScore(),expectedValue);
    }
}