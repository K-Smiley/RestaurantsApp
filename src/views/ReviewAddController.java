package views;

import controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author mga
 */
public class ReviewAddController {
    @FXML
    private Label restaurantIdField;
    @FXML
    private TextField reviewerField;
    @FXML
    private TextField ratingField;

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
     * OK button in the Add Review form
     * 
     */  
    @FXML
    private void handleOk() {
        if (isInputValid()) {  	
        	mainController.addReview(reviewerField.getText(), Integer.parseInt(ratingField.getText()), Integer.parseInt(restaurantIdField.getText()));
            dialogStage.close();
        }
    }

    /**
     * A handler method to respond to the event of the user clicking the
     * Cancel button in the Add Review form
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

        if (reviewerField.getText() == null || reviewerField.getText().length() == 0) {
            errorMessage += "No valid reviewer!\n"; 
        }
        if (ratingField.getText() == null || ratingField.getText().length() == 0) {
            errorMessage += "No rating!\n"; 
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
     * Is called by the main controller to give a reference back to itself.
     * Restaurant Id is supplied
     * 
     * @param mainController
     * @param restaurantId
     */
    public void setMainController(Controller mainController, int restaurantId) {
        this.mainController = mainController;     
        restaurantIdField.setText(Integer.toString(restaurantId));
    }        
}
