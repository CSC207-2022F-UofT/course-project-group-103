package Properties.Interfaces;

public interface Buyable {
    int estimateMortgage();
    int getAskingPrice();
    int getCurrentBuyBid();
    int getMinimumBuyBid();
    void setBuyBid(int price);
}
