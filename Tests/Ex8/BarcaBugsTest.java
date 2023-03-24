package Ex8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BarcaBugsTest {
    BarcaBugs barcaBugs = new BarcaBugs();
    @ParameterizedTest
    @CsvSource({
        "10,02", "04,06",
        "03,21", "90,05"
    })
    void ocupaLugar(int line, int seat) {
        barcaBugs.ocupaLugar(line, seat);
        boolean[][] seatTaken = barcaBugs.getAssentos();
        assertTrue(seatTaken[line][seat]);
    }
    @ParameterizedTest
    @CsvSource({"F99A01,0",
            "F10A21,0",
            "AAAAAAAAAA,0",
            "F10A05,3",
            "F30A05,2"

    })
    void testOcupaLugar(String seat, int expectedValue) {
        assertEquals(expectedValue, barcaBugs.ocupaLugar(seat) );
    }

    @ParameterizedTest
    @CsvSource({
            "F22A05,100,2",
            "F25A05,101,3",
            "F43A15,200,2",
            "F41A10,201,3",
            "F38A14,189,3"
    })

    void testWeight(String seat, int numPassagenger, int expetedValue){
        barcaBugs.setQtdadeAssentosOcupados(numPassagenger);
        assertEquals(expetedValue, barcaBugs.ocupaLugar(seat));
    }
}