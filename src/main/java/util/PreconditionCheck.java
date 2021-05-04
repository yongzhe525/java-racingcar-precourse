package util;

public class PreconditionCheck {

    private static final String INVALID_NUMBER = "숫자만 입력하세요.";
    private static final String INVALID_NAME = "이름이 5자리가 넘어가는 차 이름이 존재합니다. 다시 입력해주세요.";

    public static boolean isValidRaceCount(String times) {
        try {
            Integer.valueOf(String.valueOf(times));
        } catch (Exception e) {
            System.out.println(INVALID_NUMBER);
    }
        return true;
    }

    public static boolean isValidCarName(String[] carNames) {
        boolean result = true;
        for (int index = 0; index < carNames.length; index++) {
            result = result & carNames[index].length() <= 5;
        }
        if (!result) {
            System.out.println(INVALID_NAME);
        }
        return result;
    }
}