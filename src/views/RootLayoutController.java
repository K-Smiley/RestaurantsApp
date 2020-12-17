package views;

import controllers.Controller;
import javafx.fxml.FXML;

/**
 *
 * @author mga
 */
public class RootLayoutController {
    private Controller mainController;

    /**
     * A handler method to respond to the event of the user selecting the
     * Exit option from the menu
     * 
     */    
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    /**
     * A handler method to respond to the event of the user selecting the
     * List Restaurants option from the menu
     * 
     */    
    @FXML
    private void handleListRestaurants() {
    	mainController.listRestaurants();
    }

    /**
     * A handler method to respond to the event of the user selecting the
     * Add Restaurant option from the menu
     * 
     */    
    @FXML
    private void handleAddRestaurant() {
    	mainController.addRestaurantForm();
    }

    /**
     * Is called by the main controller to give a reference back to itself.
     * 
     * @param mainController
     */
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }
}
