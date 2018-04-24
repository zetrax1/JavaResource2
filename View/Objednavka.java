package View;


import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Controler.Controller;
import Controler.VlastnaVynimka;
import Controler.ZoznamCh;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * 
 *@author Vladim�r Ve�erek
 *@version 1.0
 *Okno z objednan�mi chemik�liami
 *
 */

public class Objednavka extends Stage {
	
	private Button kosik = new Button("Ko��k");
	private Button vymaz = new Button("Zru�");
	private Button preprava = new Button("Preprava");
	private TextArea vypis = new TextArea();
	
	
	
	private ZoznamCh zoznam =new ZoznamCh();
	
	
	public Objednavka(Controller controller) {
		super();
		
		GridPane root = new GridPane();
		
		root.getChildren().addAll(kosik,vymaz,vypis,preprava);
		
		root.setVgap(3);
		root.setHgap(4);
		
		GridPane.setConstraints(kosik, 2, 3);
		GridPane.setConstraints(vymaz, 1, 3);
		GridPane.setConstraints(vypis, 1, 0);
		GridPane.setConstraints(preprava, 1, 2);
																					// nastavenie funkcii tla�idiel
		kosik.setOnAction(e->{
			try{
			vypis.appendText(controller.getFirma().zistiInfo());
			}
			catch (Exception e3) {
				Alert Chyba = new Alert(AlertType.ERROR);
				Chyba.setContentText("Ko��k neobsahuje �iadne chemik�lie");
				Chyba.showAndWait();
			}
		});
		
		vymaz.setOnAction(e->{
			controller.zmazObjednavku();
			vypis.appendText("Ko��k neobsahuje �iadne polo�ky\n");
		});
		
		preprava.setOnAction(e->{
			
						new PrepravaOkno(controller);
			
		});
		
		
		Scene scene = new Scene(root);
		setScene(scene);
		show();
        
	}

}
