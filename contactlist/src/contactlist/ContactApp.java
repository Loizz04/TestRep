import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;


public class ContactApp implements Initializable {
    public Button btnAdd;
    public Button btnSave;
    public Button btnDelete;
    public ImageView ivContact;
    public TextField txtPhone;
    public TextField txtLastName;
    public TextField txtFirstName;
    public TextField txtEmail;
    public TextField txtAddress;
    public ListView<Contact> listContact;

    private Contact currentContact;
    private Image currentImage ;

    private FileChooser fileChooser;

    private ObservableList<Contact> contactObservableList;

    public void addNewContact(ActionEvent actionEvent) {
        txtLastName.clear();
        txtFirstName.clear();
        txtEmail.clear();
        txtPhone.clear();
        txtAddress.clear();
        ivContact.setImage(null);
        currentContact = new Contact();
        currentImage = null;
    }

    public void changePhoto(MouseEvent mouseEvent) {
      File file  = fileChooser.showOpenDialog(ivContact.getScene().getWindow());
        try {
            currentImage = new Image(new FileInputStream(file));
            ivContact.setImage(currentImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveContact(ActionEvent actionEvent) {
        if (txtLastName.getText().isEmpty() || txtFirstName.getText().isEmpty()){
            return;
        }

        currentContact.setLastName(txtLastName.getText());
        currentContact.setFirstName(txtFirstName.getText());
        currentContact.setEmail(txtEmail.getText());
        currentContact.setPhoneNumber(txtPhone.getText());
        currentContact.setHomeAddress(txtAddress.getText());
        currentContact.setPhoto(currentImage);

        int index = contactObservableList.indexOf(currentContact);
        if (index < 0){
            contactObservableList.add(currentContact);
        }else{
            contactObservableList.set(index,null);
            contactObservableList.set(index,currentContact);
        }

        sortList();

    }

    private void sortList() {
        Comparator<Contact> comparator = (o1, o2) ->
                o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
        FXCollections.sort(contactObservableList,comparator);
    }

    public void deleteContact(ActionEvent actionEvent) {
        int index = contactObservableList.indexOf(currentContact);
        if (index >= 0){
            contactObservableList.remove(currentContact);
        }

        addNewContact(null);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contactObservableList = FXCollections.observableArrayList();
        listContact.setItems(contactObservableList);
        listContact.setCellFactory(contactListView-> new ContactListViewCell());

        currentContact = new Contact();
        currentImage = null;


        FileChooser.ExtensionFilter imageFilter = new
                FileChooser.ExtensionFilter("Images","*.jpg","*.png");
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(imageFilter);

        listContact.setOnMouseClicked(clicked -> {
            if (listContact.getSelectionModel().getSelectedItem() != currentContact){
                currentContact = listContact.getSelectionModel().getSelectedItem();
                txtLastName.setText(currentContact.getLastName());
                txtFirstName.setText(currentContact.getFirstName());
                txtEmail.setText(currentContact.getEmail());
                txtPhone.setText(currentContact.getPhoneNumber());
                txtAddress.setText(currentContact.getHomeAddress());
                ivContact.setImage(currentContact.getPhoto());
            }
        });

    }
}
