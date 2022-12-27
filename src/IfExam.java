public class IfExam {
    public static void main(String[] args) {
        // 1. 輸入一個整數，判斷是否為奇數，是就顯示奇數；不是顯示偶數
        int i = 50;
        if (i % 2 == 0) {
            System.out.println("奇數");
        } else {
            System.out.println("偶數");
        }


        // 2. 輸入兩個整數，判斷第一個整數是否是第二個整數的倍數，是就顯示是；不是就顯示不是
        int a = 100;
        int b = 50;
        if (a % b == 0) {
            System.out.println("是");
        } else {
            System.out.println("不是");
        }

        // 3. 輸入兩個整數，一個年份和一個月份，顯示有這個月有多少天
        int year = 2000;
        int month = 5;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.println(31);
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println(30);
        } else if (month == 2) {
            if (year / 4 == 0 && year / 400 == 0) {
                System.out.println(29);
            } else {
                System.out.println(28);
            }
        }

        // 4. 輸入一個年份，顯示該年份是閏年還是平年
        // 提示：4 的倍數是閏年，但 100 的倍數不是閏年，又 400 的倍數也是閏年
        int y = 1900;
        if (y / 4 == 0 && y / 400 == 0) {
            System.out.println("閏年");
        } else {
            System.out.println("平年");
        }
    }
}
