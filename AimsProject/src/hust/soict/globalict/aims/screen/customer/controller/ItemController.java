package hust.soict.globalict.aims.screen.customer.controller;
import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.DuplicateException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.playable.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

public class ItemController {
	private Media media;
	private Cart cart;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;
    
    
    public ItemController(Cart cart) {
		super();
		this.cart = cart;
	}

	public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event){
    	try {
			cart.addMedia(media);
		} catch (LimitExceededException e) {
			System.err.println(e.getMessage());
		} catch (DuplicateException e) {
			System.err.println(e.getMessage());
		}
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Playing Media");
		alert.setHeaderText(null);
		alert.setContentText("Playing " + media.getTitle());

		alert.showAndWait();
    }

}
