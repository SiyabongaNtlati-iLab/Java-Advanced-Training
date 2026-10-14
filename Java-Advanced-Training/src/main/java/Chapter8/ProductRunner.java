package Chapter8;

/**
 * @author : Siyabonga Ntlati
 * Project : Java-Advanced-Training
 * Date   : 2026/10/13
 **/
public class ProductRunner {
    public static void main(String[] args) {

        try {
            Product objProduct = new Product("code123", "microwave", 500, 5);

            objProduct.increasePrice(1);
            objProduct.sell(2);
            System.out.println(objProduct);
        }catch (IllegalArgumentException | LowStockException | HighPriceIncreaseException ex){
            System.err.println(ex.getMessage());
        }

    }
}