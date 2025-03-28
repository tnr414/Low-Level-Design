package MediatorDesignPattern;

public class ConcreteBidder extends Bidder {

    ConcreteBidder(AuctionMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    void bid(int amount) {
        System.out.println(name + " places a bid of $" + amount);
        auctionMediator.placeBid(this, amount);
    }

    @Override
    void update(Bidder highestBidder, int highestBid) {
        System.out.println(name + " is notified: New highest bid is $" + highestBid + " by " + highestBidder.getName());
    }
}
