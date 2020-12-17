package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mga
 */
public class Restaurant {
    private int id;
    private String name;
    private String location;
    private List<Review> reviewsCollection;

    /**
     * The default Restaurant constructor
     */
    public Restaurant() {
    }

    /**
     * A constructor which accepts name and location values
     * 
     * @param name
     * @param location
     */
    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.reviewsCollection = new ArrayList<>();
    }

    /**
     * A constructor which accepts name, location and reviewsCollection values
     * 
     * @param name
     * @param location
     * @param reviewsCollection
     */
    public Restaurant(String name, String location, List<Review> reviewsCollection) {        
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
    }
    
    /**
     * A constructor which accepts id, name and location values
     * 
     * @param id
     * @param name
     * @param location
    */
   public Restaurant(int id, String name, String location) {
       this.id = id;        
       this.name = name;
       this.location = location;
       this.reviewsCollection = new ArrayList<>();
   }    

    /**
     * A constructor which accepts id, name, location  and reviewsCollection values
     * 
     * @param id
     * @param name
     * @param location
     * @param reviewsCollection
     */
    public Restaurant(int id, String name, String location, List<Review> reviewsCollection) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
    }
    
    /**
     * A getter for id values
     * 
     * @return int
     */
    public int getId() {
        return id;
    }    
    
    /**
     * A setter method for id values
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }    

    /**
     * A getter for name values
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * A setter method for name values
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A getter for location values
     * 
     * @return String
     */
    public String getLocation() {
        return location;
    }

    /**
     * A setter method for location values
     * 
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * A getter for reviewsCollection values
     * 
     * @return List of Reviews
     */
    public List<Review> getReviewsCollection() {
        return reviewsCollection;
    }

    /**
     * A setter method for reviewsCollection values
     * 
     * @param reviewsCollection
     */
    public void setReviewsCollection(List<Review> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }
    
    /**
     * Adds a supplied Review object to the reviewsCollection attribute
     * 
     * @param review
     */
    public void addReview(Review review) {
        this.reviewsCollection.add(review);
    }
    
    /**
     * Constructs and returns a String representing the state of the object
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "\nRestaurant Id: " + id + " - Name: " + name +            
                " - Location: " + location + "\nReviews: " + reviewsCollection + "\n";
    }
}
