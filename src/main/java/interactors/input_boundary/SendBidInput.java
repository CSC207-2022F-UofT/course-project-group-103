package interactors.input_boundary;

public interface SendBidInput {

    /**
     * Adds a bid to the property associated with the given id.
     *
     * @param propertyID: ID of property to add bid to.
     * @param bid: the bid amount.
     * @param bidderID: the ID of the user who placed the bid.
     */
    void sendBid(String propertyID, String bid, String bidderID);
}
