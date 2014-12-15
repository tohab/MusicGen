import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	static Pane grid = new Pane();
	int tone = 1;
	Slider slider = new Slider();
	Slider volume = new Slider();

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
		setupVolume(primaryStage);
		setupWelcome(primaryStage);
		setupCanvas();

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

	int x = 0;
	private Canvas canvas = new Canvas(394, 100);
	private GraphicsContext gc = canvas.getGraphicsContext2D();

	private void setupCanvas() {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		

		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), 2);
		gc.fillRect(0, canvas.getHeight()-2, canvas.getWidth(), 2);
		for (int i = 0; i <= 14; i += 1) {
			gc.fillRect(i * 28, 0, 2, canvas.getHeight());
			if (i%7 != 0 && i%7 !=3) {
				gc.fillRect(i * 28 - 8, 0, 20, 70);
			}
		}

		canvas.setLayoutX(25);
		canvas.setLayoutY(275);
		grid.getChildren().add(canvas);
	}

	private void updateCanvas(int note) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), 2);
		gc.fillRect(0, canvas.getHeight()-2, canvas.getWidth(), 2);
		for (int i = 0; i <= 14; i += 1) {
			gc.fillRect(i * 28, 0, 2, canvas.getHeight());
			if (i%7 != 0 && i%7 !=3) {
				gc.fillRect(i * 28 - 8, 0, 20, 70);
			}
		}
	}

	private void setupImage() {

		Image image2 = new Image("back.jpg");

		// simple displays ImageView the image as is
		/*
		 * ImageView iv2 = new ImageView(); iv2.setImage(image2);
		 * 
		 * iv2.setLayoutY(0); iv2.setLayoutX(0); grid.getChildren().addAll(iv2);
		 */

		Image image = new Image("gob.png");

		// simple displays ImageView the image as is
		ImageView iv1 = new ImageView();
		iv1.setImage(image);

		iv1.setLayoutY(-20);
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
		rb1.setLayoutY(115);

		RadioButton rb2 = new RadioButton("Minor");
		rb2.setToggleGroup(group);

		rb2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tone = 0;
			}
		});
		rb2.setLayoutX(175);
		rb2.setLayoutY(115);

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
		slider.setLayoutY(160);
		grid.getChildren().addAll(slider);
	}

	private void setupVolume(Stage primaryStage) {
		volume.setMin(0);
		volume.setMax(200);
		volume.setValue(100);
		volume.setShowTickLabels(true);
		volume.setShowTickMarks(true);
		volume.setMajorTickUnit(50);
		volume.setMinorTickCount(5);
		volume.setBlockIncrement(5);
		volume.setScaleX(1.5);
		volume.setScaleY(1.3125);

		volume.setLayoutX(125);
		volume.setLayoutY(210);
		grid.getChildren().addAll(volume);
	}

	private void setupWelcome(Stage primaryStage) {
		// TODO Auto-generated method stub
		Text tempo = new Text("Volume:");
		tempo.setFont(Font.font("helvetica", FontWeight.NORMAL, 16));
		tempo.setLayoutX(30);
		tempo.setLayoutY(218);

		Text volume = new Text("Tempo:");
		volume.setFont(Font.font("helvetica", FontWeight.NORMAL, 16));
		volume.setLayoutX(30);
		volume.setLayoutY(168);

		grid.getChildren().addAll(tempo, volume);
	}

	private void setupButton(Stage primaryStage) {
		// Create button and effect of pressing it.
		Button btn = new Button();
		btn.setText("Start!");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (chords == null) {
					chords = new Chords(5, tone, tempoConversion(slider
							.getValue()), (int) volume.getValue());
					chords.startMusic();
					chords.start();
				}
				x += 30;
				updateCanvas();
			}
		});
		btn.setLayoutX(420);
		btn.setLayoutY(100);
		grid.getChildren().addAll(btn);

		Button btn1 = new Button();
		btn1.setText("Stop!");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				chords.stopMusic();
				chords = null;
			}
		});

		btn1.setLayoutX(475);
		btn1.setLayoutY(100);

		grid.getChildren().addAll(btn1);

		// Add button to the world.
		// grid.add(btn, 5, 5);
	}

	public static int tempoConversion(double d) {
		double beatsPerMillisec = (60000 / d);
		return (int) beatsPerMillisec;
	}

}
