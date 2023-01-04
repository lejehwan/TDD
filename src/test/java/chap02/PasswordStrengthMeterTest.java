package chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 암호 검사기
 * 조건1: 길이가 8글자 이상
 * 조건2: 0~9 사이의 숫자를 포함
 * 조건3: 대문자 포함
 * 조건4: 조건1~3을 모두 만족하면 강함, 2개만 만족하면 보통, 1개만 만족하면 약함
 */
public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        Assertions.assertEquals(expStr, result);
    }

    @Test
    @DisplayName("모든 규칙을 충족하는 경우")
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!ADD", PasswordStrength.STRONG);
    }

    @Test
    @DisplayName("길이만 8글자 미만이고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("값이 null인 경우")
    void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("값이 빈 문자열인 경우")
    void emptyInput_Then_Invalid(){
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("길이가 8글자 이상인 조건만 충족하는 경우")
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("숫자 포함 조건만 충족하는 경우")
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("대문자 포함 조건만 충족하는 경우")
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("아무 조건도 충족하지 않는 경우")
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abc", PasswordStrength.WEAK);
    }

}
