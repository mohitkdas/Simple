public class EnumDemo {
    public enum Level {
        HIGH(1),
        MEDIUM(2),
        LOW(3);

        private int intValue;

        Level(int intValue) {
            this.intValue = intValue;
        }

        public int getLevel() {
            return this.intValue;
        }
    }

    public static void main(String[] args) {
        Level level = Level.MEDIUM;

        switch (level) {
            case HIGH -> System.out.println(Level.HIGH);
            case MEDIUM -> System.out.println(Level.MEDIUM);
            case LOW -> System.out.println(Level.LOW);
            default -> System.out.println("NOTHING");
        }

        Level[] values = Level.values();
        for (Level lvl : values) {
            System.out.println(lvl);
        }

        Level high = Level.valueOf("HIGH");
        System.out.println(high);
        System.out.println(high.getLevel());
    }
}
