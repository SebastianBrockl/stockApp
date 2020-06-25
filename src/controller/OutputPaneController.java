package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * controller class for the OutputPane.fxml gui-element
 * @author Sebastian
 *
 */
public class OutputPaneController {

	@SuppressWarnings("unused")
	private TopLayoutController topLayoutController;

    @FXML // fx:id="outputPane"
    private GridPane outputPane; // Value injected by FXMLLoader

    @FXML // fx:id="outputTextArea"
    private TextArea outputTextArea; // Value injected by FXMLLoader

	public void injectTopLayoutController(TopLayoutController topLayoutController) {
		this.topLayoutController = topLayoutController;
	}

}
