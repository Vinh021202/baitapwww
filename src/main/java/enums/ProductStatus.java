package enums;

public enum ProductStatus {
    WORKING(1), UN_WORKING(0), QUITTED(-1);
    private final int status;

    private ProductStatus(int status) {
        this.status = status;
    }



    public int getStatus() {
        return status;
    }
}
