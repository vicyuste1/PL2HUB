package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tools.Settings;

/**
 * @author Victor Yuste Vara
 * Class that controls the Main view
 */
public class MainController implements Initializable{

	/**
	 * Attributes
	 */
	@FXML
	private Button btn_programs, btn_settings, btn_help, btn_close;
	
	@FXML
	private Button launchButton1, launchButton2, launchButton3, launchButton4, launchButton5, launchButton6;
	
	@FXML
	private Button editButton1, editButton2, editButton3, editButton4, editButton5, editButton6;
	
	@FXML
	private ImageView image1, image2, image3, image4, image5, image6;
	
	@FXML
	private Label app_title1, app_title2, app_title3, app_title4, app_title5, app_title6;
	
	private ArrayList<ImageView> images = new ArrayList<>();
	
	private ArrayList<Label> titles = new ArrayList<>();
	
	@FXML
	private Pane mainPane;
	
	private Settings settings;
	
	private ResourceBundle bundle;
	
	private String lang;
	
	
	/**
	 * Closes the Program with all its views
	 * @param event GUI event
	 */
	public void close(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Close");
		alert.setHeaderText(bundle.getString("closeAlert"));
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			//currentStage = (Stage) mainPane.getScene().getWindow();
			//currentStage.close();
			Platform.exit();
		}
		
	}
	
	/**
	 * Opens the Help view
	 * @param event GUI event
	 */
	public void openHelp(ActionEvent event) {
	
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Help.fxml"), bundle);
			Parent root = loader.load();
			HelpController helpController = loader.getController();
			helpController.setBundle(bundle);
			Scene scene = new Scene(root);
			Image logo = new Image("file:src/resources/HUB_logo_white.png");
			Stage helpStage = new Stage();
			helpStage.setTitle("HUB help");
			helpStage.getIcons().add(logo);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			helpStage.setScene(scene);
			helpStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Opens the Settings view
	 * @param event GUI event
	 */
	public void openSettings(ActionEvent event) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"), bundle);
			Parent root = loader.load();
			SettingsController settingsController = loader.getController();
			settingsController.setBundle(bundle);
			Scene scene = new Scene(root);
			Image logo = new Image("file:src/resources/HUB_logo_white.png");
			Stage settingsStage = new Stage();
			settingsStage.setTitle("HUB Settings");
			settingsStage.getIcons().add(logo);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			settingsStage.setScene(scene);
			settingsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Opens the Edit view
	 * @param event GUI event
	 */
	public void openEdit(ActionEvent event) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit.fxml"), bundle);
			Parent root = loader.load();
			EditController editController = loader.getController();
			editController.setBundle(bundle);
			editController.setMainController(this);
			
			String buttonID = ((Button)event.getSource()).getId();
			int buttonNumber = Integer.parseInt(buttonID.substring(buttonID.length()-1, buttonID.length()));
			editController.setAppNumber(buttonNumber);
			
			Scene scene = new Scene(root);
			Image logo = new Image("file:src/resources/HUB_logo_white.png");
			Stage settingsStage = new Stage();
			settingsStage.setTitle("Edit App");
			settingsStage.getIcons().add(logo);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			settingsStage.setScene(scene);
			settingsStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Initializes the controller
	 * @param URL 
	 * @param arg1 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		settings = Settings.getInstance();
		bundle = settings.getBundle();
		lang = settings.getLang();
		
		images.add(image1); 
		images.add(image2); 
		images.add(image3);
		images.add(image4);
		images.add(image5);
		images.add(image6);
		
		titles.add(app_title1);
		titles.add(app_title2);
		titles.add(app_title3);
		titles.add(app_title4);
		titles.add(app_title5);
		titles.add(app_title6);
		
		//We initialize all apps
		
		for(int i = 1; i <= 6; i++) {			
			updateImage(i);
			updateTitle(i);			
		}
		
	}
	
	/**
	 * Updates the App title for the given App slot from the settings file
	 * @param AppNumber Number of the App 
	 */
	public void updateTitle(int AppNumber) {
		if(settings.nameExists(AppNumber)) {
			String appName = settings.getSettingsLine("app" + AppNumber + "_name=");
			titles.get(AppNumber-1).setText(appName);
		}
	}
	
	/**
	 * Updates the App image for the given App slot from the settings file
	 * @param AppNumber Number of the App 
	 */
	public void updateImage(int AppNumber) {
		if(settings.imageExists(AppNumber)) {
			String imagePath = settings.getSettingsLine("app" + AppNumber + "_image=");
			
			try {
				images.get(AppNumber-1).setImage(new Image(getClass().getResourceAsStream(imagePath)));			
			} catch(Exception e) {
				
				e.printStackTrace();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle(bundle.getString("imageLoadProblemTitle"));
				alert.setHeaderText(bundle.getString("imageLoadProblem"));
				alert.showAndWait();
			}
			
		}
	}
	
	/**
	 * Loads the default App image into the given App slot
	 * @param AppNumber Number of the App 
	 */
	public void defaultImage(int AppNumber) {
		images.get(AppNumber-1).setImage(new Image("file:src/resources/HUB_logo.png"));
	}
	
	/**
	 * Loads the default App name into the given App slot
	 * @param AppNumber Number of the App 
	 */
	public void defaultName(int AppNumber) {
		titles.get(AppNumber-1).setText(bundle.getString("noAppTitle"));
	}
	
	/**
	 * Launches the chosen App as a new process
	 * @param event GUI event
	 */
	public void launch1(ActionEvent event) {
		
		Launcher launcher = new Launcher();
		launcher.setBundle(bundle);
		launcher.launch1();
		
	}
	
	/**
	 * Launches the chosen App as a new process
	 * @param event GUI event
	 */
	public void launch2(ActionEvent event) {
		
		Launcher launcher = new Launcher();
		launcher.setBundle(bundle);
		launcher.launch2();
		
	}
	
	/**
	 * Launches the chosen App as a new process
	 * @param event GUI event
	 */
	public void launch3(ActionEvent event) {
		
		Launcher launcher = new Launcher();
		launcher.setBundle(bundle);
		launcher.launch3();
		
	}
	
	/**
	 * Launches the chosen App as a new process
	 * @param event GUI event
	 */
	public void launch4(ActionEvent event) {
		
		Launcher launcher = new Launcher();
		launcher.setBundle(bundle);
		launcher.launch4();
		
	}
	
	/**
	 * Launches the chosen App as a new process
	 * @param event GUI event
	 */
	public void launch5(ActionEvent event) {
		
		Launcher launcher = new Launcher();
		launcher.setBundle(bundle);
		launcher.launch5();
		
	}
	
	/**
	 * Launches the chosen App as a new process
	 * @param event GUI event
	 */
	public void launch6(ActionEvent event) {
		
		Launcher launcher = new Launcher();
		launcher.setBundle(bundle);
		launcher.launch6();
		
	}
	
}
