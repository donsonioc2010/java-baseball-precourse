package baseball.Study;

import static org.assertj.core.api.Assertions.*;


import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class StringTest {
    private static Stream<Arguments> stringSplitVal() {
        return Stream.of(
                Arguments.of("1,2", Arrays.array("1", "2")),
                Arguments.of("1", Arrays.array("1"))
        );
    }

    @DisplayName("Junit 요구사항 1 Split")
    @ParameterizedTest
    @MethodSource("stringSplitVal")
    public void stringSplit(String input, String[] stream) {
        String[] result = input.split(",");
        System.out.println("Split결과물 : " + java.util.Arrays.toString(result));

        assertThat(stream).contains(result);
        assertThat(stream).containsExactly(result);
    }

    private static Stream<Arguments> stringSubStringVal() {
        return Stream.of(
                Arguments.of("(1,2)", "1,2")
        );
    }

    @DisplayName("Junit 요구사항 2 SubString")
    @ParameterizedTest
    @MethodSource("stringSubStringVal")
    public void stringSubString(final String input, final String result) {
        String subStrVal = input.substring(input.indexOf("(") + 1,input.indexOf(")"));
        System.out.println(subStrVal);
        System.out.println(result);
        assertThat(result).isEqualTo(subStrVal);
    }

    @DisplayName("Junit 요구사항 3 - charAt")
    @ParameterizedTest
    @CsvSource({
            "abc, 0, a",
            "abc, 1, b",
            "abc, 2, c"
    })
    public void stringCharAt(String str, int idx, char answer) {
        //assertThat으로 대조해서 테스트..?
        System.out.println(str + " " + idx + " " + answer);
        assertThat(answer).isEqualTo(str.charAt(idx));
    }

    @DisplayName("Junit 요구사항 3 - charAt - StringIndexOutOfBoundsException")
    @Test
    public void stringCharAtException() {
        // 테스트케이스가 통과하는건 익셉션 hasMessageContaining에서 같은 메세지로 포멧이 일치시에..
        String testStr = "abc";
        int index = testStr.length();
        int idx = 11;

        assertThatThrownBy(() -> testStr.charAt(idx))
                .isInstanceOf(IndexOutOfBoundsException.class);
               // .hasMessageContaining(String.format("String index out of range: %d", idx)); // 선택...
    }
}
