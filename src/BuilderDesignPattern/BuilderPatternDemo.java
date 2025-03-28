package BuilderDesignPattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Computer gamingPC = ComputerDirector.buildGamingPc();
        Computer officePC = ComputerDirector.buildOfficePc();
        Computer serverPC = ComputerDirector.buildServerPc();

        System.out.println("Gaming PC config: \n" + gamingPC);
        System.out.println("Office PC config: \n" + officePC);
        System.out.println("Server PC config: \n" + serverPC);
    }
}
