package github.meifans.hello.service;

import org.junit.Test;

public class Demo {

    @Test(expected = NullPointerException.class)
    public void testEnumNull() {
        Temp temp = null;
        switch (temp) {
            case warm:
                System.out.println("warm");
                break;
            default:
                System.out.println("default case!");
        }

        /**
         * Temp temp = Temp.warm; switch (temp.ordinal()) { case
         * Temp.warm.ordinal(): System.out.println("warm"); break; default:
         * System.out.println("default case!"); } this is back what happen as
         * above.
         */
    }

    enum Temp {
        warm,
        cold;
    }
}
