package sample.Controllers;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import sample.Models.Place;
import sample.utils.AttractionRecommender;

public class PlacePaneController {

    @FXML
    private Label nameLabel, priceLabel;
    @FXML
    private javafx.scene.image.ImageView placeImageView;
    @FXML
    private JFXCheckBox selectedCheckBox;

    private Place place;

    public void setAttraction(Place place) {
        this.place = place;
    }

    public void setupPlacePane(){
        nameLabel.setText(place.getName());
        priceLabel.setText(Double.toString(place.getPrice()));
        try {
            placeImageView.setImage(new Image(place.getImageId()));
        }catch (Exception e){
            placeImageView.setImage(new Image(AttractionRecommender.EMPTY_IMAGE_URL));
        }
    }
}
