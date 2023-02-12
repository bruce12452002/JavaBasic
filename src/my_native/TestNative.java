package my_native;

public class TestNative {
    public native void helloNative1();
    public static native void helloNative2();

    static {
        System.load(System.getProperty("user.dir") + "/src/my_native/xxx.dll");
    }

    public static void main(String[] args) {
        new TestNative().helloNative1();
        TestNative.helloNative2();
    }
}
