package Properties.Interfaces;

public interface Rentable {
    int getRentalPrice();
    int getCurrentRentBid();
    int getMinimumRentBid();
    void setRentBid(int price);
}
