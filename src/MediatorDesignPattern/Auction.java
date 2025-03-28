package MediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator{
    List<Bidder> bidders = new ArrayList<>();
    int highestBid = 0;
    Bidder highestBidder = null;


    @Override
    public void placeBid(Bidder bidder, int amount) {
        if (amount > highestBid) {
            highestBidder = bidder;
            highestBid = amount;
            System.out.println(bidder.getName() + " has the highest bid of $" + amount);
            notifyAllBidder();
        }
    }

    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    private void notifyAllBidder() {
        for (Bidder bidder: bidders) {
            if (bidder != highestBidder) {
                bidder.update(highestBidder, highestBid);
            }
        }
    }
}
