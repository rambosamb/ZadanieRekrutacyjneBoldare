import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestyDoZadania {
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void singleRest() {
        String input = "1,30\n2\n";
        provideInput(input);
        try {
            ZadanieRekrutacyjne.mainMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String output = outputContent.toString();
        String expectedOutput = "Podaj wartość reszty (w zł, liczba musi być większa od 0): \r\n" +
                "Wydaj 1 monet 1 zł\r\n" +
                "Wydaj 1 monet 20 gr\r\n" +
                "Wydaj 1 monet 10 gr\r\n" +
                "Czy chcesz kontynuować? 1 - tak, 2 - nie\r\n";

        assertEquals(expectedOutput, output);
    }
    @Test
    public void moreRests() {
        String input = "1,30\n1\n11,70\n1\n6,70\n1\n4,30\n2\n";
        provideInput(input);

        try {
            ZadanieRekrutacyjne.mainMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String output = outputContent.toString();

        String expectedOutput = "Podaj wartość reszty (w zł, liczba musi być większa od 0): \r\n" +
                "Wydaj 1 monet 1 zł\r\n" +
                "Wydaj 1 monet 20 gr\r\n" +
                "Wydaj 1 monet 10 gr\r\n" +
                "Czy chcesz kontynuować? 1 - tak, 2 - nie\r\n" +
                "Podaj wartość reszty (w zł, liczba musi być większa od 0): \r\n" +
                "Wydaj 1 monet 5 zł\r\n" +
                "Wydaj 3 monet 2 zł\r\n" +
                "Wydaj 1 monet 50 gr\r\n" +
                "Wydaj 1 monet 20 gr\r\n" +
                "Czy chcesz kontynuować? 1 - tak, 2 - nie\r\n" +
                "Podaj wartość reszty (w zł, liczba musi być większa od 0): \r\n" +
                "Wydaj 4 monet 1 zł\r\n" +
                "Wydaj 5 monet 50 gr\r\n" +
                "Wydaj 1 monet 20 gr\r\n" +
                "Czy chcesz kontynuować? 1 - tak, 2 - nie\r\n" +
                "Podaj wartość reszty (w zł, liczba musi być większa od 0): \r\n" +
                "Wydaj 4 monet 50 gr\r\n" +
                "Wydaj 11 monet 20 gr\r\n" +
                "Wydaj 1 monet 10 gr\r\n" +
                "Czy chcesz kontynuować? 1 - tak, 2 - nie\r\n";
        assertEquals(expectedOutput, output);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
}
