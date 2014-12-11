import java.awt.Canvas;

import javax.sound.midi.*;
import javax.swing.Timer;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;

public class Main extends Application {

	static Pane grid = new Pane();
	int tone = 1;
	Slider slider = new Slider();

	Chords chords;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Music Generator");
		
		// grid.setAlignment(Pos.TOP_LEFT);
		// grid.setHgap(10);
		// grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		setupButton(primaryStage);
		// setupWelcome(primaryStage);
		setupSlider(primaryStage);
		setupKey(primaryStage);
		setupImage();

		// Set red button to close window.
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				System.out.println("Stage is closing");
				System.exit(0);
			}
		});
		
		// Add grid to the scene.
		primaryStage.close();
		primaryStage.setScene(new Scene(grid, 600, 400));
		primaryStage.show();
	}

	private void setupImage() {
		
		Image image2 = new Image("back.jpg");

		// simple displays ImageView the image as is
		/*ImageView iv2 = new ImageView();
		iv2.setImage(image2);

		iv2.setLayoutY(0);
		iv2.setLayoutX(0);
		grid.getChildren().addAll(iv2);*/
		
		Image image = new Image("gob.png");

		// simple displays ImageView the image as is
		ImageView iv1 = new ImageView();
		iv1.setImage(image);

		iv1.setLayoutY(0);
		iv1.setLayoutX(0);
		grid.getChildren().addAll(iv1);
		
		
	}

	private void setupKey(Stage primaryStage) {
		final ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Major");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);
		rb1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tone = 1;
				System.out.println("major??");
			}
		});
		rb1.setLayoutX(100);
		rb1.setLayoutY(175);

		RadioButton rb2 = new RadioButton("Minor");
		rb2.setToggleGroup(group);

		rb2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tone = 0;
			}
		});
		rb2.setLayoutX(175);
		rb2.setLayoutY(175);

		// grid.add(rb1, 15, 17);
		// grid.add(rb2, 15, 18);
		grid.getChildren().addAll(rb1, rb2);
	}

	private void setupSlider(Stage primaryStage) {
		slider.setMin(40);
		slider.setMax(320);
		slider.setValue(144);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(70);
		slider.setMinorTickCount(5);
		slider.setBlockIncrement(5);
		slider.setScaleX(1.5);
		slider.setScaleY(1.3125);

		slider.setLayoutX(125);
		slider.setLayoutY(210);
		grid.getChildren().addAll(slider);
	}

	private void setupWelcome(Stage primaryStage) {
		// TODO Auto-generated method stub
		Text scenetitle = new Text("Music Generator");
		scenetitle.setFont(Font.font("sansserif", FontWeight.NORMAL, 48));
		scenetitle.setLayoutX(150);
		scenetitle.setLayoutY(60);

		grid.getChildren().addAll(scenetitle);
	}

	private void setupButton(Stage primaryStage) {
		// Create button and effect of pressing it.
		Button btn = new Button();
		btn.setText("Start!");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				chords = new Chords(5, tone, tempoConversion(slider.getValue()));
				chords.start();

			}
		});
		
		btn.setLayoutX(300);
		btn.setLayoutY(300);
		grid.getChildren().addAll(btn);
		
		Button btn1 = new Button();
		btn1.setText("Stop!");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				chords.stopMusic();
			}
		});
		
		btn1.setLayoutX(350);
		btn1.setLayoutY(300);

		grid.getChildren().addAll(btn1);

		// Add button to the world.
		// grid.add(btn, 5, 5);
	}

	public static int tempoConversion(double d) {
		double beatsPerMillisec = (60000 / d);
		return (int) beatsPerMillisec;
	}

}
