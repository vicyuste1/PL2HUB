package application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import tools.Settings;

public class Launcher {

	private Settings settings;
	private ResourceBundle bundle;
	
	public Launcher() {
		settings = Settings.getInstance();
	}
	
	
	
	public void launch1() {
		
		String executablePath = "";
		
		if(settings.fileExists(1)) {
			executablePath = settings.getSettingsLine("app1_file=");
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			return;
		}
		
		/*
		ArrayList<String> commands = new ArrayList<>();
		commands.add("java");
		commands.add("--module-path");
		commands.add("hub_lib/javafx-sdk-22.0.1/lib");
		commands.add("--add-modules");
		commands.add("javafx.controls,javafx.fxml,javafx.web");
		commands.add("-jar");
		commands.add(jarPath);
		*/

		ProcessBuilder processBuilder = new ProcessBuilder(executablePath);
		
		try {
			Process process = processBuilder.start();
		} catch (IOException e) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			e.printStackTrace();
			return;
			
		}
		

	}
	
	
	public void launch2() {
		
		String executablePath = "";
		
		if(settings.fileExists(2)) {
			executablePath = settings.getSettingsLine("app2_file=");
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			return;
		}
				
		/*
		ArrayList<String> commands = new ArrayList<>();
		commands.add("java");
		commands.add("--module-path");
		commands.add("hub_lib/javafx-sdk-22.0.1/lib");
		commands.add("--add-modules");
		commands.add("javafx.controls,javafx.fxml,javafx.web");
		commands.add("-jar");
		commands.add(jarPath);
		*/

		ProcessBuilder processBuilder = new ProcessBuilder(executablePath);
		
		try {
			Process process = processBuilder.start();
		} catch (IOException e) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			e.printStackTrace();
			return;
			
		}
		

	}
	
	
	public void launch3() {
		
		String executablePath = "";
		
		if(settings.fileExists(3)) {
			executablePath = settings.getSettingsLine("app3_file=");
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			return;
		}
				
		/*
		ArrayList<String> commands = new ArrayList<>();
		commands.add("java");
		commands.add("--module-path");
		commands.add("hub_lib/javafx-sdk-22.0.1/lib");
		commands.add("--add-modules");
		commands.add("javafx.controls,javafx.fxml,javafx.web");
		commands.add("-jar");
		commands.add(jarPath);
		*/

		ProcessBuilder processBuilder = new ProcessBuilder(executablePath);
		
		try {
			Process process = processBuilder.start();
		} catch (IOException e) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			e.printStackTrace();
			return;
			
		}
		

	}
	
	
	public void launch4() {
		
		String executablePath = "";
		
		if(settings.fileExists(4)) {
			executablePath = settings.getSettingsLine("app4_file=");
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			return;
		}
				
		/*
		ArrayList<String> commands = new ArrayList<>();
		commands.add("java");
		commands.add("--module-path");
		commands.add("hub_lib/javafx-sdk-22.0.1/lib");
		commands.add("--add-modules");
		commands.add("javafx.controls,javafx.fxml,javafx.web");
		commands.add("-jar");
		commands.add(jarPath);
		*/

		ProcessBuilder processBuilder = new ProcessBuilder(executablePath);
		
		try {
			Process process = processBuilder.start();
		} catch (IOException e) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			e.printStackTrace();
			return;
			
		}
		

	}
	
	
	public void launch5() {
		
		String executablePath = "";
		
		if(settings.fileExists(5)) {
			executablePath = settings.getSettingsLine("app5_file=");
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			return;
		}
				
		/*
		ArrayList<String> commands = new ArrayList<>();
		commands.add("java");
		commands.add("--module-path");
		commands.add("hub_lib/javafx-sdk-22.0.1/lib");
		commands.add("--add-modules");
		commands.add("javafx.controls,javafx.fxml,javafx.web");
		commands.add("-jar");
		commands.add(jarPath);
		*/

		ProcessBuilder processBuilder = new ProcessBuilder(executablePath);
		
		try {
			Process process = processBuilder.start();
		} catch (IOException e) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			e.printStackTrace();
			return;
			
		}
		

	}
	
	
	public void launch6() {
		
		String executablePath = "";
		
		if(settings.fileExists(6)) {
			executablePath = settings.getSettingsLine("app6_file=");
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			return;
		}
				
		/*
		ArrayList<String> commands = new ArrayList<>();
		commands.add("java");
		commands.add("--module-path");
		commands.add("hub_lib/javafx-sdk-22.0.1/lib");
		commands.add("--add-modules");
		commands.add("javafx.controls,javafx.fxml,javafx.web");
		commands.add("-jar");
		commands.add(jarPath);
		*/

		ProcessBuilder processBuilder = new ProcessBuilder(executablePath);
		
		try {
			Process process = processBuilder.start();
		} catch (IOException e) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(bundle.getString("appLoadProblemTitle"));
			alert.setHeaderText(bundle.getString("appLoadProblem"));
			alert.showAndWait();
			e.printStackTrace();
			return;
			
		}
		

	}
	
	
	
	
	public ResourceBundle getBundle() {
		return bundle;
	}


	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}


}
