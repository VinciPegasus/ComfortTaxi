package application;
	
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage)throws Exception{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/PrimoScenario.fxml"));
			Scene scena1 = new Scene(root);
			 //Crea Transizione
	        FadeTransition ft = new FadeTransition(javafx.util.Duration.seconds(2), root);
	        ft.setFromValue(0.2);
	        ft.setToValue(1.0);
			primaryStage.setTitle("NeoProject");
			primaryStage.setScene(scena1);
			primaryStage.show();
			ft.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
