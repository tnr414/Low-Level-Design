package CompositeDesignPattern;

public class Demo {
    public static void main(String[] args) {
        File document1 = new File("Document1.txt");
        File document2 = new File("Document2.txt");
        Directory documents = new Directory("Documents");
        documents.addComponent(document1);
        documents.addComponent(document2);

        File photo = new File("photo.jpg");
        Directory media = new Directory("Media");
        media.addComponent(photo);


        Directory root = new Directory("Root");
        root.addComponent(documents);
        root.addComponent(media);

        root.showDetails();
    }
}
