import controller.StartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/start-view.fxml"));
        loader.setController(new StartController());
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 500);

        stage.setScene(scene);
        stage.show();
    }
}