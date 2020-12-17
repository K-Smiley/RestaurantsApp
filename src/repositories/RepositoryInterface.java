package repositories;

import java.util.List;
import model.Restaurant;
import model.Review;

/**
 *
 * @author mga
 */
public interface RepositoryInterface {

    /**
     * A class that implements this interface must provide this method
     * 
     * @param item
     */
    void add(Restaurant item);

    /**
     * A class that implements this interface must provide this method
     * 
     * @param id
     * @return Restaurant
     */
    Restaurant getItem(int id);

    /**
     * A class that implements this interface must provide this method
     * 
     * @return Restaurant
     */
    List<Restaurant> getItems();

    /**
     * A class that implements this interface must provide this method
     * 
     * @return List<Restaurant>
     */
    
    /**
     * A class that implements this interface must provide this method
     * 
     * @param review
     */
    void addReview(Review review);
    
    /**
     * A class that implements this interface must provide this method
     * 
     * @return String
     */
    @Override
    String toString();
    
}
