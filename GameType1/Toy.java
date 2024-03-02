package GameType1;

import lombok;

public class Toy implements Comparable {
    private int id;

    @Getter
    private String name;

    @Getter
    @Setter
    private int dropPercent;

    public Toy(int id, String name, int dropPercent) {
        this.id = id;
        this.name = name;
        this.dropPercent = dropPercent;
    }

    public Toy() {
    }

    @Override
    public String toString() {
        return STR."\{name}";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}