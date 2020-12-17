package model;

/**
 *
 * @author mga
 */
public class Review {
	
    private int reviewId;
    private String reviewer;
    private int rating;
    private int restaurantId;

    /**
     * The default Review constructor
     */
    public Review() {
    }
    
    /**
     * A constructor which accepts reviewer, rating and restaurant id values
     * 
     * @param reviewer
     * @param rating
     * @param restaurantId
    */
   public Review(String reviewer, int rating, int restaurantId) {  	
       this.reviewer = reviewer;
       this.rating = rating;
       this.restaurantId = restaurantId;
   }    

    /**
     * A constructor which accepts review id, reviewer, rating and restaurant id values
     * 
     * @param reviewId
     * @param reviewer
     * @param rating
     * @param restaurantId
     */
    public Review(int reviewId, String reviewer, int rating, int restaurantId) {
    	this.reviewId = reviewId;    	
        this.reviewer = reviewer;
        this.rating = rating;
        this.restaurantId = restaurantId;        
    }
      
    /**
     * A getter for review id values
     * 
     * @return int
     */
    public int getReviewId() {
        return reviewId;
    }

    /**
     * A setter method for review id values
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }    

    /**
     * A getter for reviewer values
     * 
     * @return String
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * A setter method for reviewer values
     * 
     * @param reviewer
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * A getter for rating values
     * 
     * @return int
     */
    public int getRating() {
        return rating;
    }

    /**
     * A setter method for rating values
     * 
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }    
    
    /**
     * A getter for restaurant id values
     * 
     * @return int
     */
    public int getRestaurantId() {
        return restaurantId;
    }

    /**
     * A setter method for restaurant id values
     * 
     * @param restaurantId
     */
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }       
    
    /**
     * Constructs and returns a String representing the state of the object
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Review{" + "id-" + Integer.toString(reviewId) + " reviewer=" + reviewer + ", rating=" + Integer.toString(rating) + ", restaurant=" + Integer.toString(restaurantId) + '}';
    }   
    
}
