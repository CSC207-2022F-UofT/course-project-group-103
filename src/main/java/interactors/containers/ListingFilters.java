package interactors.containers;

import java.util.List;

public class ListingFilters {

    /**
     * Minimum price to filter by.
     */
    private float minPrice;
    /**
     * Maximum price to filter by.
     */
    private float maxPrice;
    /**
     * Minimum square footage to filter by.
     */
    private int minSqFt;
    /**
     * Maximum square footage to filter by.
     */
    private int maxSqFt;
    /**
     * Whether house should be filtered (false) or not (true).
     */
    private boolean showHouse;
    /**
     * Whether condo should be filtered (false) or not (true).
     */
    private boolean showCondo;
    /**
     * Whether office should be filtered (false) or not (true).
     */
    private boolean showOffice;
    /**
     * Whether restaurant should be filtered (false) or not (true).
     */
    private boolean showRestaurant;

    /**
     * Sets the price range of the filter.
     *
     * @param min: minimum price to filter.
     * @param max: maximum price to filter.
     */
    public void setPriceRange(float min, float max) {
        this.minPrice = min;
        this.maxPrice = max;
    }

    /**
     * Sets the square footage range of the filter.
     *
     * @param min: minimum square footage to filter.
     * @param max: maximum square footage to filter.
     */
    public void setSqFtRange(int min, int max) {
        this.minSqFt = min;
        this.maxSqFt = max;
    }

    /**
     * Returns the minimum price to filter.
     * @return float of minimum price to filter.
     */
    public float getMinPrice() {
        return this.minPrice;
    }

    /**
     * Returns the maximum price to filter.
     * @return float of maximum price to filter.
     */
    public float getMaxPrice() {
        return this.maxPrice;
    }

    /**
     * Returns the minimum square footage to filter.
     * @return integer of minimum square footage to filter.
     */
    public int getMinSqFt() {
        return this.minSqFt;
    }

    /**
     * Returns the maximum square footage to filter.
     * @return integer of maximum square footage to filter.
     */
    public int getMaxSqFt() {
        return this.maxSqFt;
    }

    /**
     * Sets whether house should be filtered.
     *
     * @param b: whether house should be filtered (false) or not (true).
     */
    public void setShowHouse(Boolean b) {
        this.showHouse = b;
    }

    /**
     * Sets whether condo should be filtered.
     *
     * @param b: whether condo should be filtered (false) or not (true).
     */
    public void setShowCondo(Boolean b) {
        this.showCondo = b;
    }

    /**
     * Sets whether office should be filtered.
     *
     * @param b: whether office should be filtered (false) or not (true).
     */
    public void setShowOffice(Boolean b) {
        this.showOffice = b;
    }

    /**
     * Sets whether restaurant should be filtered.
     *
     * @param b: whether restaurant should be filtered (false) or not (true).
     */
    public void setShowRestaurant(Boolean b) {
        this.showRestaurant = b;
    }

    /**
     * Returns whether house should be filtered.
     * @return boolean on whether house should be filtered (false) or not (true).
     */
    public boolean getShowHouse() {
        return this.showHouse;
    }

    /**
     * Returns whether condo should be filtered.
     * @return boolean on whether condo should be filtered (false) or not (true).
     */
    public boolean getShowCondo() {
        return this.showCondo;
    }

    /**
     * Returns whether office should be filtered.
     * @return boolean on whether office should be filtered (false) or not (true).
     */
    public boolean getShowOffice() {
        return this.showOffice;
    }

    /**
     * Returns whether restaurant should be filtered.
     * @return boolean on whether restaurant should be filtered (false) or not (true).
     */
    public boolean getShowRestaurant() {
        return this.showRestaurant;
    }
}
