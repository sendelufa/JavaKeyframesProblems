package leetcode.p0091;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainTest {

    private final Solution p0091 = new Solution();

    @ParameterizedTest
    @CsvSource({"123,3", "06,0", "12,2", "226,3", "12345,3",
            "99999,1", "11111,8", "2410621,4"})
    void p0091(String input, int expected) {
        assertThat(p0091.numDecodings(input)).isEqualTo(expected);
    }

}
