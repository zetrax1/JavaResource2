package View;

import Controler.Controller;
import Controler.VlastnaVynimka;
import Controler.ZoznamCh;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 
 *@author VladimÌr VeËerek
 *@version 1.0
 *Okno Preprvava, sl˙ûi na zobrazenie vytvorenej formy prepravy
 *
 */

public class PrepravaOkno extends Stage{
	
	
	private TextArea vypis = new TextArea();
	private ZoznamCh zoznam =new ZoznamCh();
	private Button obnovit = new Button("Obnoviù");
	
	
	public PrepravaOkno(Controller controller) {
		super();
		
		GridPane root = new GridPane();
		
		root.getChildren().addAll(vypis,obnovit);
		
		root.setVgap(1);
		root.setHgap(1);
		
		
		GridPane.setConstraints(vypis, 0, 0);
		GridPane.setConstraints(vypis, 1, 1);
		
		
obnovit.setOnAction(e -> {													//akcia pre tlacidlo obnoviù
			
			try{
				vypis.appendText(controller.pouziteVozidla());
			
			}
	
			catch (Exception e1){
				Alert Chyba = new Alert(AlertType.ERROR);
				Chyba.setTitle("Chyba");
				Chyba.setContentText("Program zlyhal");
				Chyba.showAndWait();
			}
			
			});
			
	
		Scene scene = new Scene(root);
		setScene(scene);
		show();
        
	}

}
