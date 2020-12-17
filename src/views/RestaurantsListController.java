package views;

import controllers.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import viewmodels.RestaurantView;
import viewmodels.ReviewView;

/**
 *
 * @author mga
 */
public class RestaurantsListController {
    @FXML
    private TableView<RestaurantView> restaurantsTable;
    @FXML
    private TableColumn<RestaurantView, String> restaurantIdColumn;
    @FXML
    private TableColumn<RestaurantView, String> restaurantNameColumn;
    @FXML
    private TableColumn<RestaurantView, String> locationColumn;
    @FXML
    private TableView<ReviewView> reviewsTable;    
    @FXML
    private TableColumn<ReviewView, String> reviewerColumn;
    @FXML
    private TableColumn<ReviewView, String> ratingColumn;    
 	
    private Controller mainController;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public RestaurantsListController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the restaurants table with the three columns.
    	restaurantIdColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
    	restaurantNameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
    	locationColumn.setCellValueFactory(cellData -> cellData.getValue().getLocation());
        // Initialize the reviews table with the two columns.
    	reviewerColumn.setCellValueFactory(cellData -> cellData.getValue().getReviewer());
    	ratingColumn.setCellValueFactory(cellData -> cellData.getValue().getRating());   	
    	
        // Listen for selection changes and show the person details when changed.
    	restaurantsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> updateReviews(newValue));    	
    }
    
    /**
     *
     * @param restaurantView
     */
    public void updateReviews(RestaurantView restaurantView) {
    	ObservableList<ReviewView> reviewsList = FXCollections.observableArrayList(); 
    	reviewsList.setAll(restaurantView.getReviewsCollection());
    	reviewsTable.setItems(reviewsList);
    }
    
    /**
     * A handler method to respond to the event of the user clicking the
     * Add Restaurant button in the Restaurants List view
     * 
     */     
    @FXML
    private void handleAddRestaurant() {
    	mainController.addRestaurantForm();
    }
    
    /**
     * A handler method to respond to the event of the user clicking the
     * Add Review button in the Restaurants List view
     * 
     */     
    @FXML
    private void handleAddReview() {
        RestaurantView selectedRestaurant = restaurantsTable.getSelectionModel().getSelectedItem();
        if (selectedRestaurant != null) {
        	int restaurantId = Integer.parseInt(selectedRestaurant.getId().getValue().toString());
        	mainController.addReviewForm(restaurantId);
        }    	
    } 
    
    /**
     * Is called by the main controller to give a reference back to itself.
     * Restaurant Data is supplied
     * 
     * @param mainController
     * @param restaurantsData
     */
    public void setMainController(Controller mainController, ObservableList<RestaurantView> restaurantsData) {
        this.mainController = mainController;
        // Add observable list data to the table
        restaurantsTable.setItems(restaurantsData);
        restaurantsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);        
        ObservableList<ReviewView> reviewsdata = FXCollections.observableArrayList();         
        reviewsdata.setAll(restaurantsData.get(0).getReviewsCollection());
        reviewsTable.setItems(reviewsdata);
        reviewsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);         
    }    
}
