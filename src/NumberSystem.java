public class NumberSystem {
    private static final StringBuilder SB = new StringBuilder();

    /**
     * 10 進位轉任何進位(10進位以上不支援)
     *
     * @param num    10 進位的數字
     * @param system 轉成幾進位的數字
     * @return 轉成 system 進位的值
     */
    public static String decToXSystem(int num, int system) {
        if (num < 0) throw new RuntimeException("num 不可傳負數");
        int quotient = num / system;
        int remainder = num % system;

        if (quotient >= system) {
            decToXSystem(quotient, system);
        }
        if (quotient < system) {
            SB.append(quotient);
        }
        return SB.append(remainder).toString();
    }

    /**
     * 任何進位(10進位以上不支援)轉 10 進位
     *
     * @param numStr system 進位的值
     * @param system 用幾進位轉成 10 進位的數字
     * @return 10 進位的值
     */
    public static int xSystemToDec(String numStr, int system) {
        if (numStr == null || numStr.isEmpty()) throw new RuntimeException("numStr 不可為空");
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            String n = numStr.substring(i, i + 1);
            if ("0".equals(n)) {
                continue;
            }
            double r = Math.pow(system, numStr.length() - i - 1);
            sum += (int) r * Integer.parseInt(n);
        }
        return sum;
    }

    public static void main(String[] args) {
        final int system10 = 78;
        final int system = 4;

        final String result = NumberSystem.decToXSystem(system10, system);
        System.out.println(system10 + "轉成" + system + "進位=" + result);
        System.out.println(result + "轉成10進位=" + xSystemToDec(result, system));
    }
}
