package Chapter8;

/**
 * @author : Siyabonga Ntlati
 * Project : Java-Advanced-Training
 * Date   : 2026/10/13
 * Thrown when there is a high price increase on a {@code Product}
 **/
public class HighPriceIncreaseException extends Exception{
    public HighPriceIncreaseException(String message){
        super(message);
    }
}