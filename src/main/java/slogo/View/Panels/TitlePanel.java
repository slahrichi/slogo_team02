package slogo.View.Panels;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Purpose: The TitlePane holds the top part of the BorderPane, which is where the Title and logo is
 * shown
 * <p>
 * Assumptions: I assume that this is correctly created and set up in the slogoGUI class
 * <p>
 * Dependencies: Depends on the main slogoGUI class where it's created, and different Javafx scene
 * imports in order to function
 * <p>
 * Example: Created in the slogoGUI class and makes a cute Logo image and title of the GUI
 *
 * @author Eric Xie
 *
 **/

public class TitlePanel {

  private static final String DEFAULT_RESOURCE_PACKAGE = "/";
  private static final String TURTLE_TITLE_IMAGE = "turtlePictures/turtleTitleImage.png";
  private static final String APPLICATION_TITLE = "Team 2 SLogo Application";
  private static final int IMAGE_DIMENSIONS = 100;

  private HBox titleBox;
  private ImageView titleImage;
  private Label titleText;

  /**
   * Purpose: The TitlePane object constructor, sets up the elements of the title
   * <p>
   * Assumptions: I assume that this is correctly created and set up in the slogoGUI class
   * <p>
   **/

  public TitlePanel() {

    titleBox = new HBox();
    titleImage = new ImageView();

    setUpImage();
    setUpLabel();

    titleBox.getChildren().addAll(titleImage, titleText);
    titleBox.setId("titleBox");


  }

  // sets up the title label

  private void setUpLabel() {
    titleText = new Label(APPLICATION_TITLE);
    titleText.setId("titleText");

  }

  // sets up the image of the title

  private void setUpImage() {

    titleImage.setImage(
        new Image(getClass().getResource(DEFAULT_RESOURCE_PACKAGE + TURTLE_TITLE_IMAGE).toString(),
            true));
    titleImage.setFitHeight(IMAGE_DIMENSIONS);
    titleImage.setFitWidth(IMAGE_DIMENSIONS);


  }

  /**
   * Purpose: Retrieves the HBox that the elements are created in
   * <p>
   * Assumptions: Assumed called in slogoGUI class correctly whenever it is needed in order to be
   * added to the stage
   *
   * @return titleBox, the HBox holding the elements
   **/

  public HBox getTitleBox() {
    return titleBox;
  }

}
