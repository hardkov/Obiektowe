package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
	private final UUID id;
    private final List<Product> products;
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;
    private double discount;

    public Order(List<Product> products) {
        if(products == null){
            throw new IllegalArgumentException();
        }

        this.products = products;
        id = UUID.randomUUID();
        paid = false;
        this.discount = 0;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if(discount > 1 || discount < 0){
            throw new IllegalArgumentException();
        }

        this.discount = discount;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }

    public BigDecimal getPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for(Product product: this.products){
            totalPrice = totalPrice.add(product.getPrice());
        }

        return totalPrice.multiply(new BigDecimal(1-this.discount));
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }


    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
