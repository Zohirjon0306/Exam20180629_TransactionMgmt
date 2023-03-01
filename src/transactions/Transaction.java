package transactions;

public class Transaction {
    private String transactionId;
    private String carrierName;
    private String requestId;
    private String offerId;
    private int score;


    public Transaction(String transactionId, String carrierName, String requestId, String offerId) {
        this.transactionId = transactionId;
        this.carrierName = carrierName;
        this.requestId = requestId;
        this.offerId = offerId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
