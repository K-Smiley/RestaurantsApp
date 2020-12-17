package daos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Restaurant;
import model.Review;

/**
 *
 * @author mga
 */
public class TestDAO extends DAO {
	List<Restaurant> restaurantsList;
        
    /**
     * A constructor to hard code test data in the restaurantsList attribute
     */
    public TestDAO() {
        restaurantsList = new ArrayList<>();
        Restaurant restaurant;
        Review review;
        restaurant = new Restaurant(1, "Le Bistro", "Glasgow");
        review = new Review(1, "Diana Krall", 2, 1);
    	restaurant.addReview(review);
        review = new Review(2, "Herbie Hancock", 4, 1);
    	restaurant.addReview(review);    
        review = new Review(4, "k. d. Lang", 3, 1);
    	restaurant.addReview(review);   
        review = new Review(5, "Kris Kristofferson", 3, 1);
    	restaurant.addReview(review);  
        review = new Review(8, "Tori Amos", 4, 1);
    	restaurant.addReview(review);      	
        restaurantsList.add(restaurant);
        restaurant = new Restaurant(2, "Court And Spark", "Edinburgh");
        review = new Review(3, "Herbie Hancock", 5, 2);
    	restaurant.addReview(review);    
        review = new Review(7, "Norah Jones", 4, 2);
    	restaurant.addReview(review);      	
        restaurantsList.add(restaurant);  
        restaurant = new Restaurant(3, "Food Inc", "Glasgow");
        review = new Review(6, "Kris Kristofferson", 3, 3);
    	restaurant.addReview(review);      	
        restaurantsList.add(restaurant);        
    }
    
    /**
     * Overrides the abstract method specified in the DAO class
     * and returns a List of Restaurant objects as requested
     * 
     * @return List of Restaurants
     */
    @Override
	public List<Restaurant> getRestaurants() {
    	System.out.println(restaurantsList);
        return restaurantsList;
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts a restaurant id value
     * and returns a matching Restaurant object or null as requested
     * 
     * @param restaurantId
     * @return Restaurant
     */
    @Override
	public Restaurant getRestaurant(int restaurantId) {
        Iterator<Restaurant> it = restaurantsList.iterator();
        while (it.hasNext()) {
            Restaurant restaurant = (Restaurant) it.next();            
            if (restaurant.getId() == restaurantId) {
                return restaurant;
            }
        }    	
        return null;
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts a restaurant object and adds it to the list
     * 
     * @param restaurant
     */
    @Override
    public void addRestaurant(Restaurant restaurant) {
        Integer restaurantId = restaurantsList.stream().map(r -> r.getId()).max(Integer::compare).get()+1;
        restaurant.setId(restaurantId);
    	restaurantsList.add(restaurant);
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts a review object and updates a Restaurant in the list
     * 
     * @param review
     */
    @Override
	public void addReview(Review review) {
        Iterator<Restaurant> it = restaurantsList.iterator();
        while (it.hasNext()) {
            Restaurant restaurant = (Restaurant) it.next();            
            if (restaurant.getId() == review.getRestaurantId()) {
                restaurant.addReview(review);
            }
        }    	
    }  
}
