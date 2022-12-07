package interactors.input_boundary;

public interface RefreshListingInput {
    void updateFilter(String price, String sqft, boolean house, boolean condo,
                      boolean office, boolean restaurant);
}
