package transactions;

public class Transaction {
    private String transactionId;
    private Carrier carrier;
    private Request request;
    private Offer offer;

    public Transaction(String transactionId, Carrier carrier, Request request, Offer offer) {
        this.transactionId = transactionId;
        this.carrier = carrier;
        this.request = request;
        this.offer = offer;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public Request getRequest() {
        return request;
    }

    public Offer getOffer() {
        return offer;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", carrier=" + carrier +
                ", request=" + request +
                ", offer=" + offer +
                '}';
    }
}
