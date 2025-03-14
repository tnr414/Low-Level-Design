package HashMap;

public class Demo {
    public static void main(String[] args) {
        HashMap<Integer, String> mp = new HashMap<Integer, String>(16);
        mp.put(12, "Raj");
        mp.put(10, "Rahul");
        try {
            String val = mp.get(12);
            System.out.println("Value at 12 is " + val);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            String val = mp.get(10);
            System.out.println("Value at 12 is " + val);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            String val = mp.get(9);
            System.out.println("Value at 12 is " + val);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
