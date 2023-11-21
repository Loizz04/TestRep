//Controller that handles  the calculate buttons events 
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;


public class MPGcontroller {

    @FXML
    private TextField mpgTF;

    @FXML
    private TextField nogTF;

    @FXML
    private TextField nomTF;

    @FXML
    // GUI controls defined in FXML and used by the controller's code

    void calcB(ActionEvent event) {
    	try {
    		BigDecimal miles = new BigDecimal(nomTF.getText());
    		BigDecimal gallons = new BigDecimal(nogTF.getText());
    		BigDecimal total = miles.divide(gallons,3,RoundingMode.CEILING);
    		
    		mpgTF.setText(String.format("%.2f",total));

    	}
    	catch (NumberFormatException e) {
    		mpgTF.setText("Value");
    		mpgTF.selectAll();
    		mpgTF.requestFocus();
    }
    }}


