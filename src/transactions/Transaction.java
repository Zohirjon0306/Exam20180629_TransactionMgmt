package transactions;

public class Transaction {

    private String transactionId;
    private String carrierName;
    private String requestId;
    private String offerId;
    private int score;

    public Transaction (String transactionId, String carrierName, String requestId, String offerId) {
        this.transactionId = transactionId;
        this.carrierName = carrierName;
        this.requestId = requestId;
        this.offerId = offerId;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getCarrierName() {
        return this.carrierName;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int s) {
        this.score = s;
    }
}
