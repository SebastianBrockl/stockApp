package controller;

//system includes

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

// project includes
import utility.QueryRequest;

/**
 * Controller-class for the InputPane.fxml GUI-element
 * @author Sebastian
 *
 */
public class InputPaneController {

	//TODO read these values from an settings-file
	private ArrayList<String> symbolOptions = new ArrayList<String>(Arrays.asList("AAPL","MSFT","GOOGL","GE"));
	
	private final int maxSymbolOptions = 6;
	
	private final ArrayList<String> timeSeriesOptions = new ArrayList<String>(Arrays.asList("TIME_SERIES_INTRADAY", "TIME_SERIES_DAILY", "TIME_SERIES_DAILY_ADJUSTED" ,
			"TIME_SERIES_WEEKLY", "TIME_SERIES_WEEKLY_ADJUSTED", "TIME_SERIES_MONTHLY", "TIME_SERIES_MONTHLY_ADJUSTED"));
	
	private final ArrayList<String> timeIntervalOptions = new ArrayList<String>(Arrays.asList("1min", "5min", "15min", "30min", "60min"));
	
	private final ArrayList<String> outputSizeOptions = new ArrayList<String>(Arrays.asList("compact", "full"));
	
	private final ArrayList<String> dataSeriesOptionsFull = new ArrayList<String>(Arrays.asList("1. open", "2. high", "3. low", "4. close", "5. adjusted close", "6. volume", "7. dividend amount"));
	
	private final ArrayList<String> dataSeriesOptionsLimited = new ArrayList<String>(Arrays.asList("1. open", "2. high", "3. low", "4. close","5. volume"));

	
	@SuppressWarnings("unused")
	private TopLayoutController topLayoutController;
	
    @FXML // fx:id="inputPane"
    private HBox inputPane; // Value injected by FXMLLoader

    @FXML // fx:id="dataSeriesInput"
    private ComboBox<String> dataSeriesInput; // Value injected by FXMLLoader

    @FXML // fx:id="timeSeriesInput"
    private ComboBox<String> timeSeriesInput; // Value injected by FXMLLoader

    @FXML // fx:id="symbolInput1"
    private ComboBox<String> symbolInput1; // Value injected by FXMLLoader

    @FXML // fx:id="symbolInput2"
    private ComboBox<String> symbolInput2; // Value injected by FXMLLoader

    @FXML // fx:id="timeIntervallInput"
    private ComboBox<String> timeIntervallInput; // Value injected by FXMLLoader

    @FXML // fx:id="outputSizeInput"
    private ComboBox<String> outputSizeInput; // Value injected by FXMLLoader

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
    void timeSeriesAction(ActionEvent event) {
    	timeSeriesSelectionUpdated();
    }
    
    @FXML
    void endDateAction(ActionEvent event) {
    	validateDateSelection();
    }

    @FXML
    void outputSizeAction(ActionEvent event) {

    }

    @FXML
    void queryButtonPressed(ActionEvent event) {
    	generateQuery(symbolInput1);
    	generateQuery(symbolInput2);
    }

    @FXML
    void startDateAction(ActionEvent event) {
    	validateDateSelection();
    }

    @FXML
    void symbolInputAction1(ActionEvent event) {
    	if(symbolInput1.getValue() != null) symbolSelectionUpdated(symbolInput1);

    }

    @FXML
    void symbolInputAction2(ActionEvent event) {
    	if(symbolInput1.getValue() != null) symbolSelectionUpdated(symbolInput2);
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
		setUpSymbolInput();
		setUpOptionsInput();
		setUpCurrentDate();
	}
	
	// set symbol selection options and default values
	private void setUpSymbolInput()
	{
    	symbolInput1.getItems().addAll(
    			new ArrayList<String>(symbolOptions));
    	
    	symbolInput2.getItems().addAll(
    			new ArrayList<String>(symbolOptions));
    	
    	symbolInput1.setValue(symbolOptions.get(0));
    	symbolInput2.setValue("");
    	
    	symbolInput1.setEditable(true);
    	symbolInput2.setEditable(true);
	}
	
	// set general input options and default values
	private void setUpOptionsInput()
	{
		timeSeriesInput.getItems().addAll(timeSeriesOptions);
		timeSeriesInput.setValue(timeSeriesOptions.get(0));
		
		timeIntervallInput.getItems().addAll(timeIntervalOptions);
		timeIntervallInput.setValue(timeIntervalOptions.get(4));
		
		outputSizeInput.getItems().addAll(outputSizeOptions);
		outputSizeInput.setValue(outputSizeOptions.get(0));
		
		dataSeriesInput.getItems().addAll(dataSeriesOptionsLimited);
		dataSeriesInput.setValue(dataSeriesOptionsLimited.get(0));
	}
	
	// set a default date interval based on local current date
	private void setUpCurrentDate()
	{
		endDateInput.setValue(LocalDate.now());
		startDateInput.setValue(LocalDate.now().minusDays(5));
//		System.out.println(startDateInput.getValue().toString());
	}
	
	/**
	 * Convenience function that updates the contents of the symbol selection comboBoxes if a new value was added
	 * @param comboBox the ComboBox that was changed
	 */
	private void symbolSelectionUpdated(ComboBox<String> comboBox)
	{
		String selectedValue = comboBox.getValue();
		if(symbolOptions.contains(selectedValue) || selectedValue.equals(""))
		{
			// do nothing
			return;
		}
		else
		{
			symbolOptions.add(0, selectedValue);
			if(symbolOptions.size() > maxSymbolOptions)
			{
				symbolOptions.remove(maxSymbolOptions);
			}
			refreshSymbolOptions();
		}
		return;
	}
	
	/**
	 * Convenience function that refreshes the contents of the comboBoxes
	 */
	private void refreshSymbolOptions()
	{	
		String symbol1 = symbolInput1.getValue();
		String symbol2 = symbolInput2.getValue();
		
		symbolInput1.getItems().setAll(symbolOptions);
		symbolInput2.getItems().setAll(symbolOptions);
		
    	symbolInput1.setValue(symbol1);
    	symbolInput2.setValue(symbol2);	
	}
	
	/**
	 * function that sets/disables the other options based on the state of the time series selection
	 */
	private void timeSeriesSelectionUpdated()
	{
		String selectedValue = timeSeriesInput.getValue();
		
		if(selectedValue.equals("TIME_SERIES_INTRADAY"))
		{
			// require -> enable time interval
			timeIntervallInput.setDisable(false);
		}
		else
		{
			// disable time interval
			timeIntervallInput.setDisable(true);
		}
		
		if(selectedValue.equals("TIME_SERIES_DAILY_ADJUSTED") || selectedValue.equals("TIME_SERIES_WEEKLY_ADJUSTED") || selectedValue.equals("TIME_SERIES_MONTHLY_ADJUSTED"))
		{
			// expand data point options
			dataSeriesInput.getItems().setAll(dataSeriesOptionsFull);
			dataSeriesInput.setValue(dataSeriesOptionsFull.get(0));
		}
		else
		{
			// limit data-point options
			dataSeriesInput.getItems().setAll(dataSeriesOptionsLimited);
			dataSeriesInput.setValue(dataSeriesOptionsFull.get(0));
		}		
	}
	
	
	// disable queries while start-end dates are mismatched or in the future
	private void validateDateSelection()
	{
		if(startDateInput.getValue().isAfter(endDateInput.getValue()) ||
				endDateInput.getValue().isAfter(LocalDate.now().plusDays(1)))
		{
			// invalid parameters -> disable query button
			queryButton.setDisable(true);
		}
		else
		{
			// enable query button
			queryButton.setDisable(false);
		}
	}
	

	private QueryRequest generateQuery(ComboBox<String> symbolSelection)
	{
		QueryRequest request = new QueryRequest();
		
		request.setTimeIntervall(timeIntervallInput.getValue());
		if(timeIntervallInput.isDisabled()) request.setTimeIntervall("");
		
		request.setTimeSeries(timeSeriesInput.getValue());
		request.setOutputSize(outputSizeInput.getValue());
		request.setOutputSize(outputSizeInput.getValue());
		
		request.setStartTime(startDateInput.getValue());
		request.setEndTime(endDateInput.getValue());
		
		request.setSymbol(symbolSelection.getValue());
				
		return request;
	}

}
