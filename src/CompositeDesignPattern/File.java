package CompositeDesignPattern;

public class File implements FileSystemComponent{
    private final String name;

    File(String name) {
        this.name = name;
    }


    @Override
    public void showDetails() {
        System.out.println("File name : " + name);
    }
}
