package BuilderDesignPattern;

public class ComputerDirector {
    public static Computer buildGamingPc() {
        return new ComputerBuilder("Intel i9", "32GB")
                .setGraphicsCard("NVIDIA 4409x")
                .setStorage("2TB SSD")
                .setOs("Windows 11")
                .setCoolingSystem("Liquid Cooling")
                .build();
    }

    public static Computer buildOfficePc() {
        return new ComputerBuilder("Intel i5", "16GB")
                .setStorage("512GB SSD")
                .setOs("Windows 10")
                .build();
    }

    public static Computer buildServerPc() {
        return new ComputerBuilder("AMD EPYC", "64GB")
                .setStorage("4TB NVMe SSD")
                .setCoolingSystem("Advanced Air Cooling")
                .setOs("Linux")
                .build();
    }

}
