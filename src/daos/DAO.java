package daos;

import java.util.List;

import model.Restaurant;
import model.Review;

/**
 *
 * @author mga
 */
public abstract class DAO {

    /**
     * A Data Access Object needs to be able to fulfill an
     * addRestaurant() request
     * 
     * @param restaurant
     */
    public abstract void addRestaurant(Restaurant restaurant);	

    /**
     * A Data Access Object needs to be able to fulfill an
     * addReview() request
     * 
     * @param review
     */
    public abstract void addReview(Review review);	

    /**
     * A Data Access Object needs to be able to fulfill an
     * getRestaurant() request when supplied with a restaurant id
     * 
     * @param restaurantId
     * @return
     */
    public abstract Restaurant getRestaurant(int restaurantId);

    /**
     * A Data Access Object needs to be able to fulfill an
     * getRestaurants() request and return a List of Restaurant objects
     * 
     * @return List of Restaurants
     */
    public abstract List<Restaurant> getRestaurants();
}