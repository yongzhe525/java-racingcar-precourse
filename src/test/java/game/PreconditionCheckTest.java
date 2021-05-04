package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.PreconditionCheck;
import static org.assertj.core.api.Assertions.assertThat;

public class PreconditionCheckTest {

    @DisplayName(value = "입력받은 숫자 문자열에 대한 오류처리가 잘 되는지 확인")
    @Test
    void isValidRaceCountCheck() {
        assertThat(PreconditionCheck.isValidRaceCount("1")).isTrue();
        assertThat(PreconditionCheck.isValidRaceCount("12")).isTrue();
        assertThat(PreconditionCheck.isValidRaceCount("1A")).isFalse();
        assertThat(PreconditionCheck.isValidRaceCount("ABC")).isFalse();
    }

    @Test
    @DisplayName("차량 이름 입력 정상 여부 확인")
    public void isValidCarNameForSizeTest() {
        String[] validCarNames = new String[]{"K3", "K5", "K7", "G70", "G80"};
        String[] inValidCarNames = new String[]{"K3", "K5", "abc123", "A123!", "A12345!"};
        assertThat(PreconditionCheck.isValidCarName(validCarNames)).isTrue();
        assertThat(PreconditionCheck.isValidCarName(inValidCarNames)).isFalse();
    }
}