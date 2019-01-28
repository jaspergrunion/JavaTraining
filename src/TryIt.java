public class TryIt {
    public static void main(String[] args) {

        System.out.println("Hello World");

        String name = "Jason";
        System.out.println("Hello " + name);

        System.out.println(
                args[0] + " " + args[1] + " " +
                (args[0] + args[1]) + " " +
                (Integer.valueOf(args[0]) + Integer.valueOf(args[1])) + " " +
                (Double.valueOf(args[0]) + Double.valueOf(args[1]))
        );

        String[] myStrArray = {"First", "Second", "Third"};
        System.out.println(myStrArray[1]);

        String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for (int i = 0; i < alphabet.length; i++) {
            System.out.println((i+1) + " " + alphabet[i]);
        }
    }
}
