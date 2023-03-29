package transactions;

public class Request {

    private String code;
    private String place;
    private String product;
    private Transaction transaction;

    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Request(String requestId, String placeName, String productId) {
        this.code = requestId;
        this.place = placeName;
        this.product = productId;
    }

    public String getPlace() {
        return this.place;
    }

    public String getProduct() {
        return this.product;
    }

    public String getCode() {
        return this.code;
    }
}
