package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	//private EclipseGUI eclipse;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader fx = new FXMLLoader(getClass().getResource("eclipse.fxml"));
		EclipseGUI eclipse = new EclipseGUI(primaryStage);
		fx.setController(eclipse);
		Parent root = fx.load();
		Scene sc = new Scene(root);
		primaryStage.setScene(sc);
		primaryStage.setTitle("Eclipse lunar");
		primaryStage.show();
		
	}

}
