package comPackage.lld8.models;

public enum SeatType {
    SILVER(450d),
    GOLD(500d),
    LOUNGE(550d);


    Double price;

    SeatType(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
