package controller;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
//system includes
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Controller-class for the InputPane.fxml GUI-element
 * @author Sebastian
 *
 */
public class InputPaneController {

	@SuppressWarnings("unused")
	private TopLayoutController topLayoutController;
	
    @FXML // fx:id="inputPane"
    private HBox inputPane; // Value injected by FXMLLoader

    @FXML // fx:id="dataSeriesInput"
    private ComboBox<?> dataSeriesInput; // Value injected by FXMLLoader

    @FXML // fx:id="timeSeriesInput"
    private ComboBox<?> timeSeriesInput; // Value injected by FXMLLoader

    @FXML // fx:id="symbolInput1"
    private ComboBox<String> symbolInput1; // Value injected by FXMLLoader

    @FXML // fx:id="symbolInput2"
    private ComboBox<String> symbolInput2; // Value injected by FXMLLoader

    @FXML // fx:id="timeIntervallInput"
    private ComboBox<?> timeIntervallInput; // Value injected by FXMLLoader

    @FXML // fx:id="outputSizeInput"
    private ComboBox<?> outputSizeInput; // Value injected by FXMLLoader

    @FXML // fx:id="startDateInput"
    private DatePicker startDateInput; // Value injected by FXMLLoader

    @FXML // fx:id="endDateInput"
    private DatePicker endDateInput; // Value injected by FXMLLoader

    @FXML // fx:id="queryButton"
    private Button queryButton; // Value injected by FXMLLoader

    @FXML // fx:id="statusLabel"
    private Label statusLabel; // Value injected by FXMLLoader

    @FXML
    void dataSeriesAction(ActionEvent event) {

    }

    @FXML
    void endDateAction(ActionEvent event) {

    }

    @FXML
    void outputSizeAction(ActionEvent event) {

    }

    @FXML
    void queryButtonPressed(ActionEvent event) {
    	System.out.println("QUERY!");
    }

    @FXML
    void startDateAction(ActionEvent event) {

    }

    @FXML
    void symbolInputAction1(ActionEvent event) {
    	System.out.println("input 1!");

    }

    @FXML
    void symbolInputAction2(ActionEvent event) {

    }

    @FXML
    void timeIntervallAction(ActionEvent event) {

    }

	public void injectTopLayoutController(TopLayoutController topLayoutController) {
		this.topLayoutController = topLayoutController;
		
	}
	
	@FXML
    private void initialize()
	{
		setupComboBoxes();
	}
	
	private void setupComboBoxes()
	{
    	symbolInput1.getItems().addAll(
    			new ArrayList<String>(
    					Arrays.asList("AAPL","MSFT","GOOGL","GE")));
    	
    	symbolInput2.getItems().addAll(
    			new ArrayList<String>(
    					Arrays.asList("AAPL","MSFT","GOOGL","GE")));
    	
    	symbolInput1.setValue("AAPL");
    	symbolInput2.setValue("");
    	
    	symbolInput1.setEditable(true);
    	symbolInput2.setEditable(true);
	}

}
