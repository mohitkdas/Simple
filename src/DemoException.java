import java.io.FileReader;

public class DemoException {
    static class MyException1 extends Exception { }

    static class MyException2 extends Exception { }

    public static void method1() throws Exception {
        try {
            System.out.println("5");
            throw new MyException1();
        } catch (Exception e) {
            System.out.println("6");
            throw new MyException2();
        } finally {
            System.out.println("7");
            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        try (FileReader fileReader = new FileReader("F:\\temp\\dummy.txt")) {
            System.out.println(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("1");
            method1();
            System.out.println("2");
        } catch (Exception e) {
            System.out.println("3");
            throw new MyException2();
        } finally {
            System.out.println("4");
            throw new MyException1();
        }
    }
}
