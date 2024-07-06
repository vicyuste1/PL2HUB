setlocal
cd /d %~dp0
java --module-path "hub_lib/javafx-sdk-22.0.1/lib" --add-modules javafx.controls,javafx.fxml,javafx.web -jar hub.jar