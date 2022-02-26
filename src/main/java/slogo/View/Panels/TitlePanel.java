package slogo.View.Panels;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class TitlePanel {

  private static final String DEFAULT_RESOURCE_PACKAGE = "/";
  private static final String TURTLE_TITLE_IMAGE = "turtlePictures/turtleTitleImage.png";
  private static final String APPLICATION_TITLE = "Team 9 SLogo Application";

  private HBox titleBox;
  private ImageView titleImage;
  private Label titleText;



  public TitlePanel(){

    titleBox = new HBox();
    titleImage = new ImageView();


    setUpImage();
    setUpLabel();

    titleBox.getChildren().addAll(titleImage, titleText);
    titleBox.setId("titleBox");


  }

  private void setUpLabel(){
    titleText = new Label(APPLICATION_TITLE);
    titleText.setId("titleText");

  }

  private void setUpImage(){

    titleImage.setImage(
        new Image(getClass().getResource(DEFAULT_RESOURCE_PACKAGE + TURTLE_TITLE_IMAGE).toString(), true));
    titleImage.setFitHeight(100);
    titleImage.setFitWidth(100);


  }

  public HBox getTitleBox(){
    return titleBox;
  }

}
