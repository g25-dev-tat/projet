package labyrinthe;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import jfox.javafx.util.ConverterStringLocalDate;

public class ControllerSolution {
	@FXML 
    TextField circuit;
	@FXML
	DatePicker datedebut;
	@FXML
	DatePicker datefin;
	@Inject 
	private ManagerGui   managerGui;
	@Inject
	modelecompetition mo;
	@FXML
	private void initialize()
	{
		circuit.textProperty().bindBidirectional(mo.c.circuitProperty());
		datedebut.getEditor().textProperty().bindBidirectional(mo.c.datedebutProperty(),new ConverterStringLocalDate());
		datefin.getEditor().textProperty().bindBidirectional(mo.c.datefinProperty(),new ConverterStringLocalDate());	
	}
	
    @FXML    
    private void doCreer() {        
    	 mo.inserer();
}
    
    }
