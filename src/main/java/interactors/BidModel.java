package interactors;

public class BidModel {

    String bidderId;
    String bidderName;
    float bidAmount;

    public BidModel(String id, String name, float bid) {
        this.bidderId = id;
        this.bidderName = name;
        this.bidAmount = bid;
    }

    public String getID() {
        return this.bidderId;
    }

    public String getName() {
        return this.bidderName;
    }

    public float getBid() {
        return this.bidAmount;
    }
}
