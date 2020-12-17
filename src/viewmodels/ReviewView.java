package viewmodels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Review;

/**
 *
 * @author mga
 */
public class ReviewView {
    private StringProperty reviewId;	
    private StringProperty reviewer;
    private StringProperty rating;
    private StringProperty restaurantId;    
    
    /**
     * A constructor which accepts a Review object and creates an
     * equivalent ReviewView object for use in JavaFX views
     * 
     * @param review
     */
    public ReviewView(Review review) {
    	this.reviewId = new SimpleStringProperty(Integer.toString(review.getReviewId()));     	
    	this.reviewer = new SimpleStringProperty(review.getReviewer());  
    	this.rating = new SimpleStringProperty(Integer.toString(review.getRating()));  
    	this.restaurantId = new SimpleStringProperty(Integer.toString(review.getRestaurantId()));     	
    }
    
	/**
         * A getter for rating values
         * 
	 * @return the rating
	 */
	public StringProperty getReviewId() {
		return reviewId;
	}    

	/**
         * A getter for reviewer values
         * 
	 * @return the reviewer
	 */
	public StringProperty getReviewer() {
		return reviewer;
	}

	/**
         * A getter for rating values
         * 
	 * @return the rating
	 */
	public StringProperty getRating() {
		return rating;
	}
	
	/**
         * A getter for restaurant id values
         * 
	 * @return the restaurant id
	 */
	public StringProperty getRestaurantId() {
		return restaurantId;
	}	
}
