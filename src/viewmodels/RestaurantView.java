package viewmodels;

import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Restaurant;

/**
 *
 * @author mga
 */
public class RestaurantView {
    private StringProperty id;
    private StringProperty name;
    private StringProperty location;
    private List<ReviewView> reviewsCollection;
      
    /**
     * A constructor which accepts a Restaurant object and creates an
     * equivalent RestaurantView object for use in JavaFX views
     * 
     * @param restaurant
     */
    public RestaurantView(Restaurant restaurant) {
    	this.id = new SimpleStringProperty(Integer.toString(restaurant.getId()));
    	this.name = new SimpleStringProperty(restaurant.getName());
    	this.location = new SimpleStringProperty(restaurant.getLocation());
    	this.reviewsCollection = restaurant.getReviewsCollection().stream().map(r -> new ReviewView(r)).collect(Collectors.toList());
    }

	/**
         * A getter for id values
         * 
	 * @return the id
	 */
	public StringProperty getId() {
		return id;
	}

	/**
         * A getter for name values
         * 
	 * @return the name
	 */
	public StringProperty getName() {
		return name;
	}

	/**
         * A getter for location values
         * 
	 * @return the location
	 */
	public StringProperty getLocation() {
		return location;
	}

	/**
         * A getter for reviewsCollection values
         * 
	 * @return the reviewsCollection
	 */
	public List<ReviewView> getReviewsCollection() {
		return reviewsCollection;
	}
}
