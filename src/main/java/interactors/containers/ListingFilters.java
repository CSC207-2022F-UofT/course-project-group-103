package interactors.containers;

import java.util.List;

public class ListingFilters {
    private float minPrice;
    private float maxPrice;
    private float minSqFt;
    private float maxSqFt;
    private boolean showHouse;
    private boolean showCondo;
    private boolean showOffice;
    private boolean showRestaurant;

    public void setPriceRange(float min, float max) {
        this.minPrice = min;
        this.maxPrice = max;
    }

    public void setSqFtRange(float min, float max) {
        this.minSqFt = min;
        this.maxSqFt = max;
    }

    public float getMinPrice() {
        return this.minPrice;
    }

    public float getMaxPrice() {
        return this.maxPrice;
    }

    public float getMinSqFt() {
        return this.minSqFt;
    }

    public float getMaxSqFt() {
        return this.maxSqFt;
    }

    public void setShowHouse(Boolean b) {
        this.showHouse = b;
    }

    public void setShowCondo(Boolean b) {
        this.showCondo = b;
    }

    public void setShowOffice(Boolean b) {
        this.showOffice = b;
    }

    public void setShowRestaurant(Boolean b) {
        this.showRestaurant = b;
    }

    public boolean getShowHouse() {
        return this.showHouse;
    }

    public boolean getShowCondo() {
        return this.showCondo;
    }

    public boolean getShowOffice() {
        return this.showOffice;
    }

    public boolean getShowRestaurant() {
        return this.showRestaurant;
    }
}
