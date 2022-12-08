package interactors;

public class BidModel {

    /**
     * ID of the bidder.
     */
    String bidderId;
    /**
     * Name of the bidder.
     */
    String bidderName;
    /**
     * Amount that was bid.
     */
    float bidAmount;

    /**
     * Constructor for the bid model, assigns its attributes.
     *
     * @param id: id of bid.
     * @param name: name of bid.
     * @param bid: bid amount.
     */
    public BidModel(String id, String name, float bid) {
        this.bidderId = id;
        this.bidderName = name;
        this.bidAmount = bid;
    }

    /**
     * Gets the id of the bidder.
     * @return String representation of the ID of the bidder.
     */
    public String getID() {
        return this.bidderId;
    }

    /**
     * Gets the name of the bidder.
     * @return String representation of the name of the bidder.
     */
    public String getName() {
        return this.bidderName;
    }

    /**
     * Gets the bid amount of the bid.
     * @return float representation of the bid amount.
     */
    public float getBid() {
        return this.bidAmount;
    }
}
