package interactors.input_boundary;

public interface RefreshListingInput {

    /**
     * Deletes account if passwords match.
     *
     * @param price: ID of account to delete.
     * @param sqft: password of account to delete.
     * @param house: whether house's should be filtered.
     * @param condo: whether condo's should be filtered.
     * @param office : whether office's should be filtered.
     * @param restaurant: whether restaurant's should be filtered.
     */
    void updateFilter(String price, String sqft, boolean house, boolean condo,
                      boolean office, boolean restaurant);
}
