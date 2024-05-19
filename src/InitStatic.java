public class InitStatic {
    int a = 20;
    {
        System.out.println("Inside init block");
        a = 10;
    }
    static {
        System.out.println("Inside static block");
    }
    public static void main(String[] args) {
        InitStatic initStatic = new InitStatic();
        System.out.println(initStatic.a);
        System.out.println("Inside main method");
    }
}
