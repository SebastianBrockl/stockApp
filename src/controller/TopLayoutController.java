package controller;

// system includes
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller-class for the TopLayout.fxml GUI-element
 * @author Sebastian
 *
 */
public class TopLayoutController {

	@FXML private OutputPaneController outputPaneController;
	@FXML private InputPaneController inputPaneController;
	
	@FXML
    private void initialize() {
        outputPaneController.injectTopLayoutController(this);
        inputPaneController.injectTopLayoutController(this);
    }   
    

}
