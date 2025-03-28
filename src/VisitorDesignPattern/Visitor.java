package VisitorDesignPattern;

public interface Visitor {
    void visit(Book book);
    void visit(Fruit fruit);
}
