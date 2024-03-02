package GameType2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore {
    public static void main(String[] args) {
        int[] ids = {1, 2, 3};
        String[] names = {"Doll", "Car", "Teddy Bear"};
        int[] frequencies = {25, 25, 50};

        PriorityQueue<Toy> toyQueue = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            toyQueue.offer(new Toy(ids[i], names[i], frequencies[i]));
        }

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < 10; i++) {
                Toy toy = toyQueue.poll();
                writer.write("Toy ID: " + toy.id + ", Name: " + toy.name + "\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}