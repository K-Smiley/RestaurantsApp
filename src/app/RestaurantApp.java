package app;

import controllers.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author mga
 */
public class RestaurantApp extends Application {
    private Stage primaryStage;

    /**
     * Sets the primaryStage
     * Creates a Controller object passing in the primaryStage
     * Requests the controller to run its initRootLayout() method
     * 
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("Restaurants App");
      Controller controller = new Controller(primaryStage);
      controller.initRootLayout();        
    }

    /**
     * Launches the JavaFX application
     * 
     * @param args
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
