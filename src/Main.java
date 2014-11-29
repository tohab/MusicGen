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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	GridPane grid = new GridPane();
	int tempo = 124;
	int tone = 1;
	Slider slider = new Slider();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Music Generator");
		
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		setupButton(primaryStage);
		setupWelcome(primaryStage);
		setupSlider(primaryStage);
		setupKey(primaryStage);
		
		// Set red button to close window.
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				System.out.println("Stage is closing");
			}
		});
		
		// Add grid to the scene.
		primaryStage.close();
		primaryStage.setScene(new Scene(grid, 600, 400));
		primaryStage.show();
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

		RadioButton rb2 = new RadioButton("Minor");
		rb2.setToggleGroup(group);
		
		rb2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tone = 0;
			}
		});
		
		grid.add(rb1, 15, 17);
		grid.add(rb2, 15, 18);		
	}

	private void setupSlider(Stage primaryStage) {
		slider.setMin(40);
		slider.setMax(208);
		slider.setValue(124);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(40);
		slider.setMinorTickCount(5);
		slider.setBlockIncrement(5);
		slider.setScaleX(2);
		slider.setScaleY(2);
		
		grid.add(slider, 15, 25);
	}

	private void setupWelcome(Stage primaryStage) {
		// TODO Auto-generated method stub
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 15, 5);
	}

	private void setupButton(Stage primaryStage) {
		// Create button and effect of pressing it.
		Button btn = new Button();
		btn.setText("Start!");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Start da' music!");
				
				try {
					new Chords().start(3, tone, tempoConversion(slider.getValue())) ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MidiUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				primaryStage.close();

			}
		});

		//Add button to the world.	
		grid.add(btn, 5, 5);
	}
	
	public static int tempoConversion (double d) {
	    double beatsPerMillisec = (60000/d);
	    return (int) beatsPerMillisec;
	   }

}
