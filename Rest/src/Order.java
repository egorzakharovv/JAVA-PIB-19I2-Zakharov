public class Order {
    private Dish dish;
    private double price;
    private String description;
    private PaymentStatus paymentStatus;

    public Order(Dish dish, double price, String description) {
        this.dish = dish;
        this.price = price;
        this.description = description;
        this.paymentStatus = PaymentStatus.NOT_PAY;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Заказ{" +
                "блюдо='" + dish + '\'' +
                ", цена=" + price + '\'' +
                ", примечание ='" + description + '\'' +
                ", статус оплаты ='" + paymentStatus + '\'' +
                '}';
    }
}
