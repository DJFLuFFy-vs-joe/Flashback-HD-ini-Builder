package nl.vsjoe.java.fbhdiniwriter;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import nl.vsjoe.java.fbhdiniwriter.libs.Loc;
import nl.vsjoe.java.fbhdiniwriter.view.RootLayoutController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FlashBack HD ini Builder");
		
		initRootLayout();
	}
	
	
	
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Loc.getLayout("Rootlayout")));
			rootLayout = loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			RootLayoutController controller = loader.getController();
			controller.setMain(this);
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//TODO create some Logic
		
	}



	public static void main(String[] args) {
		launch(args);
	}
}
