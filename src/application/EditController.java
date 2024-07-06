package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tools.Settings;

/**
 * @author Victor Yuste Vara
 * Class that controls the Edit view
 */
public class EditController implements Initializable{
	
	/**
	 * Attributes
	 */
	
	@FXML
	private Button chooseFileButton;
	
	@FXML
	private Button saveFileButton;
	
	@FXML
	private Button chooseImageButton;
	
	@FXML
	private Button saveImageButton;
	
	@FXML
	private Button saveNameButton;
	
	@FXML 
	private Label selectedFileLabel;
	
	@FXML 
	private Label selectedImageLabel;
	
	@FXML 
	private TextField nameField;
	
	private ResourceBundle bundle;
	
	private Settings settings;
	
	private String lang;
	
	private File selectedFile;
	
	private File selectedImage;
	
	private int appNumber;
	
	private MainController mainController;
	
	
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
		
	}
	
	/**
	 * Changes the Locale Bundle to the given one
	 * @param bundle Selected bundle 
	 */
	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}
	
	/**
	 * Chooses the file selected by the user
	 * @param event GUI event
	 */
	public void chooseFile(ActionEvent event) {
		
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File(System.getProperty("user.dir")));
		selectedFile = fc.showOpenDialog(currentStage);
		
		if(selectedFile != null) {			
			String selectedFileName = selectedFile.getName();
			selectedFileLabel.setText(selectedFileName);			
		}	
	
	}
	
	/**
	 * Chooses the image selected by the user
	 * @param event GUI event
	 */
	public void chooseImage(ActionEvent event) {
		
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File(System.getProperty("user.dir")));
		selectedImage = fc.showOpenDialog(currentStage);
		
		if(selectedImage != null) {			
			String selectedImageName = selectedImage.getName();
			selectedImageLabel.setText(selectedImageName);
		}	
	
	}
	
	/**
	 * Determines to what App corresponds this controller
	 * @param int Number of the App
	 */
	public void setAppNumber(int number) {
		this.appNumber = number;
	}
	
	/**
	 * Saves the file selected by the user in the settings file
	 * @param event GUI event
	 */
	public void saveFile(ActionEvent event) {
		
		if(selectedFile != null) {
			String selectedFileName = selectedFile.getName();
			settings.changeFile(appNumber, selectedFile);
			
			if(selectedFileName.endsWith(".sh") || selectedFileName.endsWith(".bat") || selectedFileName.endsWith(".exe")) {
				settings.changeFile(appNumber, selectedFile);
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle(bundle.getString("fileFormatError"));
				alert.setHeaderText(bundle.getString("appFormatErrorText"));
				alert.show();
				return;
			}
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(bundle.getString("fileChangedOKTitle"));
			alert.setHeaderText(bundle.getString("fileChangedOK"));
			alert.show();			
		}
		
	}
	
	/**
	 * Saves the image selected by the user in the settings file
	 * @param event GUI event
	 */
	public void saveImage(ActionEvent event) {
		
		if(selectedImage != null) {
			String selectedImageName = selectedImage.getName();
			
			if(selectedImageName.endsWith(".bmp") || selectedImageName.endsWith(".gif") 
						|| selectedImageName.endsWith(".jpg") || selectedImageName.endsWith(".png")){
				settings.changeImage(appNumber, selectedImage);
				mainController.updateImage(appNumber);
				
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle(bundle.getString("fileFormatError"));
				alert.setHeaderText(bundle.getString("appFormatErrorText"));
				alert.show();
				return;
			}
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(bundle.getString("fileChangedOKTitle"));
			alert.setHeaderText(bundle.getString("fileChangedOK"));
			alert.show();			
		}
		
	}
		
	/**
	 * Saves the name entered by the user in the settings file
	 * @param event GUI event
	 */
	public void saveName(ActionEvent event) {
		
		String name = nameField.getText();
		settings.changeAppName(appNumber, name);
		mainController.updateTitle(appNumber);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(bundle.getString("appNameChangedTitle"));
		alert.setHeaderText(bundle.getString("appNameChanged"));
		alert.show();
	}
	
	/**
	 * Sets the controller of the Main view that precedes Edit view
	 * @param mc MainController that precedes Edit view
	 */
	public void setMainController(MainController mc) {
		this.mainController = mc;
	}
	 
	/**
	 * Restores the given App to its default values (no App)
	 * @param mc MainController that precedes Edit view
	 */
	public void deleteApp(ActionEvent event) {
		
		settings.changeAppName(appNumber, "null");
		settings.changeFile(appNumber, null);
		settings.changeImage(appNumber, null);
		
		mainController.defaultImage(appNumber);
		mainController.defaultName(appNumber);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(bundle.getString("deleteAppOKTitle"));
		alert.setHeaderText(bundle.getString("deleteAppOK"));
		alert.show();
		
	}
	
}
