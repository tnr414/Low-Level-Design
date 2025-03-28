package MediatorDesignPattern;

abstract public class Bidder {
    protected AuctionMediator auctionMediator;
    protected String name;

    Bidder(AuctionMediator auctionMediator, String name) {
        this.auctionMediator = auctionMediator;
        this.name = name;
        auctionMediator.registerBidder(this);
    }

    abstract void bid(int amount);
    abstract void update(Bidder highestBidder, int highestBid);

    public String getName() {
        return name;
    }
}
