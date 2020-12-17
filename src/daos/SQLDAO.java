package daos;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Restaurant;
import model.Review;

/**
 *
 * @author mga
 */
public class SQLDAO extends DAO {
    static private String driver = "com.mysql.jdbc.Driver";
    static private String server_name = "localhost";
    static private String port_name = "3306";
    static private String dbms = "mysql";
    static private String dbName = "restaurants";
    static private String userName = "root";
    static private String password = "";		
    static private Connection connection = null;
    static private Statement statement = null;
    static private ResultSet resultSet = null;  
        
    /**
     * The constructor tries to create a connection to a database
     * server using the specified credentials
     */
    public SQLDAO() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:" + dbms + "://"
                       + server_name + ":" + port_name,
                       userName, password);
            connection.setCatalog(dbName);
            statement = connection.createStatement();        
            System.out.println("Connected To Database");
        } catch (SQLException ex) {} 
    }
    
    /**
     * Overrides the abstract method specified in the DAO class
     * and returns a List of Restaurant objects as requested
     * 
     * @return List of Restaurants
     */
    @Override
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurantsList = new ArrayList<>();
        try {
           String queryString = "CALL GETRESTAURANTS()";
            resultSet = statement.executeQuery(queryString);
            
            while (resultSet.next()) {
                int restaurantId = resultSet.getInt("RESTAURANTID");
                String restaurantName = resultSet.getString("RESTAURANTNAME");
                String location = resultSet.getString("LOCATION");                
                Restaurant restaurant = new Restaurant(restaurantId, restaurantName, location);             
                List<Review> reviewsCollection = new ArrayList<>();
                String queryString2 = "CALL GETRESTAURANTREVIEWS(" + Integer.toString(restaurantId) + ")";
                Statement statement2 = connection.createStatement();                
                ResultSet resultSet2 = statement2.executeQuery(queryString2);
                while (resultSet2.next()) {
                    int reviewId = resultSet2.getInt("REVIEWID");                	
                    String reviewer = resultSet2.getString("REVIEWER");
                    int rating = resultSet2.getInt("RATING");
                    Review review = new Review(reviewId, reviewer, rating, restaurantId);
                    reviewsCollection.add(review);                    
                }
                restaurant.setReviewsCollection(reviewsCollection);    
                restaurantsList.add(restaurant);
            }
        } catch (SQLException ex) {}        
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
        try {
            String queryString = "CALL GETTOUR(" + Integer.toString(restaurantId) + ")";
            resultSet = statement.executeQuery(queryString);
            
            if (resultSet.next()) {
                String restaurantName = resultSet.getString("RESTAURANTNAME");
                String location = resultSet.getString("LOCATION");                
                Restaurant restaurant = new Restaurant(restaurantId, restaurantName, location);
                List<Review> reviewsCollection = new ArrayList<>();
                String queryString2 = "CALL GETRESTAURANTREVIEWS(" + Integer.toString(restaurantId) + ")";
                Statement statement2 = connection.createStatement();                
                ResultSet resultSet2 = statement2.executeQuery(queryString);
                while (resultSet2.next()) {
                    int reviewId = resultSet2.getInt("REVIEWID");                	
                    String reviewer = resultSet2.getString("REVIEWER");
                    int rating = resultSet2.getInt("RATING");
                    Review review = new Review(reviewId, reviewer, rating, restaurantId);
                    reviewsCollection.add(review);                    
                }
                restaurant.setReviewsCollection(reviewsCollection);
                return restaurant;                
            }
        } catch (SQLException ex) {}       	
        return null;
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts a restaurant object and stores it in the database
     * 
     * @param restaurant
     */
    @Override
    public void addRestaurant(Restaurant restaurant) {
        String queryString = "CALL ADDRESTAURANT('";
        queryString += restaurant.getName() + "', '";        
        queryString += restaurant.getLocation() + "')";
        System.out.println(queryString);
        try {
            statement.executeUpdate(queryString);
        } catch (SQLException ex) {}          
    }
     
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts a review object and stores it in the database
     * 
     * @param review
     */
    public void addReview(Review review) {
        String queryString = "CALL ADDREVIEW('";
        queryString += review.getReviewer() + "', ";
        queryString += review.getRating() + ", ";       
        queryString += review.getRestaurantId() + ")";
        System.out.println(queryString);
        try {
            statement.executeUpdate(queryString);
        } catch (SQLException ex) {}    	   			        
    }
}	
