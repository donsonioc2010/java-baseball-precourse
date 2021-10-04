package baseball.Study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //TestCase 구현
    @DisplayName("요구사항1 크기확인")
    @Test
    public void confirmLength() {
        int answerSize  = 3;
        int result = numbers.size();
        assertThat(answerSize).isEqualTo(result);
    }

    @DisplayName("요구사항2 contains로 Val존재확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void confirmContains(int idx) {
        System.out.println("idx : " + idx);
        assertThat(numbers.contains(idx)).isTrue();
    }

    @DisplayName("요구사항3 true만이 아닌 false도 확인하기")
    @ParameterizedTest
    @CsvSource(value = {
            "1,true",
            "2,true",
            "3,true",
            "4,false",
            "5,false"
    }, delimiter = ',')
    void confirmTrueFalse(int confirmVal, boolean answer) {
        assertThat(numbers.contains(confirmVal)).isEqualTo(answer);
    }
}
