package ProxyDesignPattern;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();

        try {
            internet.connectTo("example.com");
            internet.connectTo("banned.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
