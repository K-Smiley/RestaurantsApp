package repositories;

import daos.DAO;
import daos.SQLDAO;
import daos.TestDAO;
import java.util.List;
import model.Restaurant;
import model.Review;

/**
 *
 * @author mga
 */
public class Repository implements RepositoryInterface {
    private DAO dao;
	
    /**
     * The default constructor which instantiates the dao attribute as a 
     * specified type of Data Access Object
     */
    public Repository() { 
    	//dao = new TestDAO(); 
    	dao = new SQLDAO();     	
    }
    
    /**
     * Responds to a request from the Controller to provide a List of 
     * Restaurant objects.
     * Fulfils this request by sending a getRestaurants() message to the
     * data access object
     * 
     * @return List of Restaurants
     */
    @Override
    public List<Restaurant> getItems() {       	
        return dao.getRestaurants();
    }
    
    /**
     * Responds to a request from the Controller to add a 
     * Restaurant object.
     * Fulfils this request by sending a addRestaurant() message to the
     * data access object
     * 
     * @param item
     */    
    @Override
    public void add(Restaurant item) {
        dao.addRestaurant(item);
    }
    
    /**
     * Responds to a request from the Controller to add a 
     * Review object.
     * Fulfils this request by sending a addReview() message to the
     * data access object
     * 
     * @param review
     */     
    @Override
    public void addReview(Review review) {
    	dao.addReview(review);
    }    
       
    /**
     * Responds to a request from the Controller to provide a specified
     * Restaurant object.
     * Fulfils this request by sending a getRestaurant() message to the
     * data access object
     * 
     * @param id
     * @return Restaurant
     */    
    @Override
    public Restaurant getItem(int id) {
        return dao.getRestaurant(id);
    }
    
    /**
     * Constructs and returns a String representing the state of the object
     * 
     * @return String
     */    
    @Override
    public String toString() {
        return "\nItems: " + getItems();
    }   
}
