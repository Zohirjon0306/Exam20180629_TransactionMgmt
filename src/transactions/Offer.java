package transactions;
public class Offer {
    private String offerId;
    private String placeName;
    private String productId;
    private Transaction transaction;

    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Offer(String offerId, String placeName, String productId) {
        this.offerId =  offerId;
        this.placeName = placeName;
        this.productId = productId;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public String getProductId() {
        return this.productId;
    }
}
