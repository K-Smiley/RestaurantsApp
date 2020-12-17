package controllers;

import app.RestaurantApp;
import helpers.InputHelper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Restaurant;
import model.Review;
import repositories.Repository;
import viewmodels.RestaurantView;
import views.RestaurantAddController;
import views.RootLayoutController;
import views.RestaurantsListController;
import views.ReviewAddController;

/**
 *
 * @author mga
 */
public class Controller {
    private Repository repository;
    private InputHelper inputHelper;
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * Instantiates the repository and inputHelper objects
     * for the console app - we could remove the attribute definitions
     * and this constructor
     *
     */
    public Controller() {
        repository = new Repository(); 
        inputHelper = new InputHelper();    
    }     
    
    /**
     * Initializes the primarystage attribute with a value
     * passed from RestaurantApp
     * 
     * @param primaryStage
     */
    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    /**
     *
     * Run after the Controller object is created
     * Used to load the RootLayout view.
     * A reference to this controller is passed into the view controller
     * for the RootLayout using the setMainController() method so
     * that the view controller can communicate back to this main Controller
     * in order to interact with the Repository.
     * Runs the listRestaurants() method to display the RestaurantsList view
     * on top of the Root Layout.
     */
    public void initRootLayout() {
       try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(RestaurantApp.class
                        .getResource("../views/RootLayout.fxml"));
          rootLayout = (BorderPane) loader.load();

          Scene scene = new Scene(rootLayout);
          primaryStage.setScene(scene);

          RootLayoutController rootLayoutController = 
             loader.getController();
          rootLayoutController.setMainController(this);

          primaryStage.show();
          listRestaurants();            
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    
    /**
     * Creates a Repository object and uses it to request Restaurant data.
     * The restaurant data is provided in the form of a List of Restaurant
     * objects which need to be converted to RestaurantView objects.
     * An ObservableList is populated to pass into the RestaurantsListController
     * as we will need to detect changes in focus in the Restaurants display.
     * The RestaurantsList view is loaded and the RestaurantsListController
     * passed a reference to this Controller and the restaurantData to be 
     * displayed.
     * 
     */
    public void listRestaurants() {
        ObservableList<RestaurantView> restaurantData = FXCollections.observableArrayList();  
        repository = new Repository();
        System.out.println(repository.getItems());
        List<RestaurantView> restaurantsList = repository.getItems().stream().map(r -> new RestaurantView(r)).collect(Collectors.toList());
        restaurantData.setAll(restaurantsList);        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RestaurantApp.class.getResource("../views/RestaurantsList.fxml"));
            AnchorPane restaurantsListPane = (AnchorPane) loader.load();

            rootLayout.setCenter(restaurantsListPane);     
            
            // Give the controller access to the main app.
            RestaurantsListController restaurantsListcontroller = loader.getController();
            restaurantsListcontroller.setMainController(this, restaurantData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }      
    
    /**
     * This method runs in response to the RestaurantsListController's
     * method for handling the Add Restaurant button click.
     * It loads the RestaurantAdd view as a popup window and passes a
     * reference to this Controller to the RestaurantAddController.
     * This reference will be needed to allow the view controller to pass back
     * the new restaurant's details to the addRestaurant() method below.
     * The Dialog Stage is shown and the app waits until it is closed by
     * clicking on the OK or Cancel buttons.
     * The default display of Restaurants List is then rendered through calling
     * the listRestaurants() method.
     * 
     */
    public void addRestaurantForm() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RestaurantApp.class.getResource("../views/RestaurantAdd.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Restaurant");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            RestaurantAddController controller = loader.getController();           
            controller.setDialogStage(dialogStage);
            controller.setMainController(this);
            
            dialogStage.showAndWait();
            listRestaurants();
        } catch (IOException e) {
            e.printStackTrace();
        }         
    }
    
    /**
     * This method is executed when the RestaurantAddController runs its
     * handleOK() method in response to the user entering new restaurant
     * details.
     * It creates a new Restaurant object and sends an add() message to the
     * repository.
     * 
     * @param restaurantName
     * @param restaurantLocation
     */
    public void addRestaurant(String restaurantName, String restaurantLocation) {      
        Restaurant newRestaurant = new Restaurant(restaurantName, restaurantLocation);
        repository.add(newRestaurant); 	
    }
    
    /**
     * This method runs in response to the RestaurantsListController's
     * method for handling the Add Review button click.
     * It loads the ReviewAdd view as a popup window and passes a
     * reference to this Controller to the ReviewAddController.
     * This reference will be needed to allow the view controller to pass back
     * the new review's details to the addReview() method below.
     * The Dialog Stage is shown and the app waits until it is closed by
     * clicking on the OK or Cancel buttons.
     * The default display of Restaurants List is then rendered through calling
     * the listRestaurants() method.
     * 
     * @param restaurantId
     */
    public void addReviewForm(int restaurantId) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RestaurantApp.class.getResource("../views/ReviewAdd.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Review");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ReviewAddController controller = loader.getController();           
            controller.setDialogStage(dialogStage);
            controller.setMainController(this, restaurantId);
            
            dialogStage.showAndWait();
            listRestaurants();
        } catch (IOException e) {
            e.printStackTrace();
        }          
           
    }
    
    /**
     * This method is executed when the ReviewAddController runs its
     * handleOK() method in response to the user entering new review
     * details.
     * It creates a new Review object and sends an addReview() message to the
     * repository.
     * 
     * @param reviewer
     * @param rating
     * @param restaurantId
     */
    public void addReview(String reviewer, int rating, int restaurantId) {   
        Review newReview = new Review(reviewer, rating, restaurantId);      
        repository.addReview(newReview);    	
    }  
}
