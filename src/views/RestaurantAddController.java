package views;

import controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 *
 * @author mga
 */
public class RestaurantAddController {
    @FXML
    private TextField restaurantNameField;
    @FXML
    private TextField locationField;

    private Stage dialogStage;
    
    // Reference to the main controller.
    private Controller mainController;       

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * A handler method to respond to the event of the user clicking the
     * OK button in the Add Restaurant form
     * 
     */ 
    @FXML
    private void handleOk() {
        if (isInputValid()) {  	
        	mainController.addRestaurant(restaurantNameField.getText(), locationField.getText());
            dialogStage.close();
        }
    }

    /**
     * A handler method to respond to the event of the user clicking the
     * Cancel button in the Add Restaurant form
     * 
     */ 
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (restaurantNameField.getText() == null || restaurantNameField.getText().length() == 0) {
            errorMessage += "No valid restaurant name!\n"; 
        }
        if (locationField.getText() == null || locationField.getText().length() == 0) {
            errorMessage += "No location!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
    
    /**
     * Accepts a reference to the main Controller
     * 
     * @param mainController
     */
    public void setMainController(Controller mainController) {
        this.mainController = mainController;     
    }        
}
