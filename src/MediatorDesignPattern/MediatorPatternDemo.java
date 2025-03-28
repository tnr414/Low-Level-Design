package MediatorDesignPattern;

public class MediatorPatternDemo {
    public static void main(String[] args) {
        Auction auction = new Auction();

        Bidder bidder1 = new ConcreteBidder(auction, "Alice");
        Bidder bidder2 = new ConcreteBidder(auction, "Bob");
        Bidder bidder3 = new ConcreteBidder(auction, "Charlie");

        bidder1.bid(100);
        bidder2.bid(150);
        bidder3.bid(130);
        bidder1.bid(200);
    }
}
