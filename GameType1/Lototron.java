package GameType1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Lototron {
    Random random = new Random();

    private final Queue<Toy> toyCollection = new PriorityQueue<>(dropChanceComparator);

    public Lototron() {
    }

    public static Comparator<Toy> dropChanceComparator = new Comparator<Toy>() {
        @Override
        public int compare(Toy o1, Toy o2) {
            return Math.max(o1.getDropPercent(), o2.getDropPercent());
        }
    };

    public void createQueue() {
        toyCollection.add(new Toy(1, "Машинка", 25));
        toyCollection.add(new Toy(2, "Кукла", 25));
        toyCollection.add(new Toy(3, "Вайфу", 25));
        toyCollection.add(new Toy(4, "Робот", 25));
    }

    public void addToy(Toy toy) {
        toyCollection.add(toy);
    }

    public void drop(int times) throws IOException {
        FileWriter fw = new FileWriter("src/toyShop/logs.txt");
        for (int i = 0; i < times; i++) {
            int randomDropChance = random.nextInt(100);
            Toy targetToy = new Toy();
            int difference;
            int minDifference = Integer.MAX_VALUE;
            for (Toy toy : toyCollection) {
                difference = randomDropChance - toy.getDropPercent();
                if (Math.abs(difference) <= minDifference) {
                    targetToy = toy;
                    minDifference = difference;
                }
            }
            fw.write(STR."Выпала игрушка: \{targetToy}" +
                    STR.", шанс - \{targetToy.getDropPercent()}%\n");
        }
        fw.close();
    }
}