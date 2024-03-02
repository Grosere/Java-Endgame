package GameType1;

import java.io.IOException;
import java.util;

public class Main {
    static Lototron lototron;

    public static void main(String[] args) throws IOException {
        init();
        lototron.createQueue();
        lototron.drop(10);
    }

    private static void init() {
        lototron = new Lototron();
    }
}