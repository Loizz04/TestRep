import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ContactListViewCell extends ListCell<Contact> {

    @FXML
    public ImageView ivPhoto;
    @FXML
    public Label lblName;
    @FXML
    public AnchorPane rootPane;

    private FXMLLoader mLoader;

    @Override
    protected void updateItem(Contact item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null){
            setText(null);
            setGraphic(null);
        }else{
            if (mLoader == null){
                try {
                    mLoader = new FXMLLoader(getClass().getResource("contact_cell.fxml"));
                    mLoader.setController(this);
                    mLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            lblName.setText(item.getFirstName() + " " + item.getLastName());
            ivPhoto.setImage(item.getPhoto());
            setText(null);
            setGraphic(rootPane);
        }
    }
}