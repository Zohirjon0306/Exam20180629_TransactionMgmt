package transactions;

public class Request {
    private String requestID;
    private Place place;
    private String productId;
    private Transaction transaction;


    public Request(String requestID, Place place, String productId) {
        this.requestID = requestID;
        this.place = place;
        this.productId = productId;
    }


    public String getRequestID() {
        return requestID;
    }
    public Place getPlace() {
        return place;
    }
    public String getProductId() {
        return productId;
    }

    public Region getRegion() {
        return place.getRegion();
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestID='" + requestID + '\'' +
                ", place=" + place +
                ", productId='" + productId + '\'' +
                '}';
    }
}
