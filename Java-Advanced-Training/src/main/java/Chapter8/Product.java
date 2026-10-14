package Chapter8;

/**
 * @author : Kabelo Tlhape
 * Project : Java-Advanced-Training
 * Date   : 2026/10/13
 * <ol>
 *     <li>A product description should be at least 5 characters long</li>
 *     <li>Price cannot be negative or zero</li>
 *     <li>Quantity to sell cannot be more quantity in stock</li>
 *     <li>Price increase should be less than R10</li>
 * </ol>
 **/
public class Product {
    private String code, description;
    private double price;
    private int qtyInStock;

    public Product(String code, String description, double price, int qtyInStock) {
        setCode(code);
        setDescription(description);
        setPrice(price);
        setQtyInStock(qtyInStock);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the Product
     * @param description Product description
     * @throws IllegalArgumentException When a product description is less than 5 characters
     */
    public void setDescription(String description) throws IllegalArgumentException {
        if (description.length() < 5){
            throw new IllegalArgumentException("Description should be at least 5 characters long."
                    + "\nCurrent description: [" + description + "]");
        }
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    /**
     * Sells the product by subtracting the requested quantity from the current quantity in stock
     * @param qtyToSell Requested quantity to sell
     * @throws LowStockException When the requested quantity is more than the available quantity in stock
     */
    public void sell(int qtyToSell) throws LowStockException{
        if (qtyToSell > qtyInStock){
            throw new LowStockException("Not enough quantity to sell " +
                    getDescription() + "\nCurrent Qty In Stock: " + getQtyInStock() +
                    "\nRequested Qty to sell: " + qtyToSell);
        }
        this.qtyInStock -= qtyToSell;
    }

    /**
     * Increase the Product price by a percentage
     * @param percentage Percentage to increase the price by
     * @throws HighPriceIncreaseException When the price increase is more or equals to 10
     */
    public void increasePrice(double percentage) throws HighPriceIncreaseException{
        double increase = this.price * (percentage / 100);
        if (increase >= 10){
            throw new HighPriceIncreaseException("The price increase on " + getDescription() +
                    " is too high [" + increase + "]" +
                    "/nIncrease should be less than 10.00");
        }
        this.price += increase;
    }

    @Override
    public String toString() {
        return String.format("""
                ====== Product Details for %s [%s] ======
                Code            :   %s
                Description     :   %s
                Price           :   %.2f
                Qty In Stock    :   %d""",getDescription(), getCode(), getCode(),
                getDescription(), getPrice(), getQtyInStock());
    }
}