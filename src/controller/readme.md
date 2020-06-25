# the controller package

Contains the control-logic acting as glue between GUI-frontend and model-backend. Currently includes all the GUI-input validation which i feel should really be in the view-package.

### InputPaneController.java

Control logic for the view/Inputpane.fxml layout. Reads and validates user input before sending to Model.

### OutputPaneController

Control logic for the view/OutputPane.fxml layout. Displays data coming in ffrom Model.

### TopLayoutController

Iinitializes input- and outputPanes. 
