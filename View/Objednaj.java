package View;




import Controler.Controller;
import Controler.VlastnaVynimka;
import Controler.ZoznamCh;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 *@author Vladimír Veèerek
 *@version 1.1
 *Okno na zadanie objednávky
 *
 */

public class Objednaj extends Stage{
	
	
	private Text chemikalieText = new Text ("Chemikalie");
	private Text hmotnostText = new Text ("Hmotnost v kg.");
	private TextField chemikalia = new TextField();
	private TextField hmotnost = new TextField();		
	private Button pridajTlacidlo = new Button("Pridaj");
	//private Button objednajTlacidlo = new Button("Objednaj");
	private int i=3;
	
	public Objednaj(Controller controller){
		super();
		
//		LinkedList<ObjednaneChemikalie> zoznamObChemikalii = new LinkedList<ObjednaneChemikalie>();
		
		setTitle("Objednavka");
		GridPane objednajOkno = new GridPane();
		
		objednajOkno.setHgap(10);
		objednajOkno.setVgap(5);
		objednajOkno.setPadding(new Insets(10,20,10,20));
		
		objednajOkno.add(chemikalieText,1,2);
		objednajOkno.add(hmotnostText,3,2);
		objednajOkno.add(pridajTlacidlo,1,1);
		//objednajOkno.add(objednajTlacidlo,5,1);
		objednajOkno.add(chemikalia,1,i);
		objednajOkno.add(hmotnost,3,i);
		
		
		pridajTlacidlo.setOnAction(e -> {											// akcia po kliknutí tlacidla ak sa nevykoná vypíš chybu
			
			try{
			ZoznamCh zoznam = new ZoznamCh();
			if(zoznam.zistiIdZoznam(chemikalia.getText())){
				controller.getFirma().pridajDoListu(Integer.parseInt(chemikalia.getText()), Integer.parseInt(hmotnost.getText()));
				chemikalia.clear();
				hmotnost.clear();
				
				
				Alert Chyba = new Alert(AlertType.INFORMATION);
				Chyba.setTitle("Chyba");
				Chyba.setContentText("Úspešne pridané");
				Chyba.showAndWait();
			}
			} catch (VlastnaVynimka vl){
				
				Alert Chyba = new Alert(AlertType.ERROR);
				Chyba.setTitle("Chyba");
				Chyba.setContentText("Neplatné údaje");
				Chyba.showAndWait();
			
			}
			catch (Exception e1){
				Alert Chyba = new Alert(AlertType.ERROR);
				Chyba.setTitle("Chyba");
				Chyba.setContentText("Program zlyhal");
				Chyba.showAndWait();
			}
			
			});
		
		
		
		Scene scene = new Scene(objednajOkno,700,350);
		 setScene(scene);
		 show();
	}
	
	
	
	
	

}
