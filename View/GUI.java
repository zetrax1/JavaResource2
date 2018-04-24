package View;


import Controler.*;








import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 *@author Vladimír Veèerek
 *@version 1.0
 *Prihlasovacie okno 
 *
 */
public class GUI extends Application {
		
		 
	private TextField prihlasovacieHeslo = new PasswordField();								//tlacidla a textfieldy 
	private TextField prihlasovacieMeno = new TextField();
	private Button prihlasovacieTlacidlo = new Button("Prihlasit");
	private Text nadpisMeno = new Text ("Prihlasovacie meno");
	private Text nadpisHeslo = new Text ("Heslo");
	
	private Controller controller = new Controller();
	
	public static void main(String[] args) {		
		launch(args);	
	}

	

	@Override
	public void start(Stage prihlasovacieOkno) throws Exception {						// prihlasovacie okno
		
		prihlasovacieOkno.setTitle("Prihlasenie");
				
		GridPane prihlasenie= new GridPane();
		
		 prihlasenie.setHgap(5);
		 prihlasenie.setVgap(5);
		 prihlasenie.setPadding(new Insets(10,20,10,20));
		 
		 
		 prihlasenie.add(prihlasovacieTlacidlo=new Button("Prihlasit"),3,5);
		 prihlasenie.add(nadpisMeno,2,3);
		 prihlasenie.add(nadpisHeslo,2,4);
		 prihlasenie.add(prihlasovacieMeno,3,3);
		 prihlasenie.add(prihlasovacieHeslo,3,4);
		 
		 Scene scene = new Scene(prihlasenie,400,200);
		 prihlasovacieOkno.setScene(scene);
		prihlasovacieOkno.show();

		prihlasovacieTlacidlo.setOnAction(e -> {								// over prihlásenie ,ak nie vypíš chybu

			OverPrihlasenie over = new OverPrihlasenie();
			if (over.overPrihlasenie(prihlasovacieMeno.getText(), prihlasovacieHeslo.getText())) {
				new Hlavneokno(prihlasovacieMeno.getText(), controller);
				prihlasovacieOkno.close();
			}
			else{
			Alert Chyba = new Alert(AlertType.ERROR);
			Chyba.setContentText("Nespravne meno alebo heslo");
			Chyba.showAndWait();
			}
		});

	}
	
}
