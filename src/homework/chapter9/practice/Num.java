package homework.chapter9.practice;

public class Num {
    /**
     * set1~set4 方法不可修改
     * set5 方法要改
     */
    public static void main(String[] args) {
        Num num = new Num();
        // 以下5個方法是錯的，請修改正確
        num.set1();
        num.set2();
        num.set3();
        num.set4(); // 必須印出 yes 才是對的

        num.set5();
    }

    private void set1(One o) {
    }

    private void set2(Two t) {
    }

    private void set3(Three t) {
    }

    private void set4(Four t) {
        if (t.a == 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private Five set5(Four t) {
        return;
    }

}

class One {
}

class Two {
}

class Three {
}

class Four {
    public int a;
}

class Five {
}
