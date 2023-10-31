import javax.swing.plaf.IconUIResource;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Auto auto = new Auto();

        auto.forward(100);
        System.out.println(auto.toString());

        auto.stop();
        System.out.println(auto.toString());

        auto.reverse();
        System.out.println(auto.toString());

        auto.stop();
        System.out.println(auto.toString());
    }
}