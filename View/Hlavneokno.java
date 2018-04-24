package View;

import Controler.Aktualizuj;
import Controler.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * 
 *@author Vladimír Veèerek
 *@version 1.0
 *Hlavné okno 
 *
 */

public class Hlavneokno extends Stage {										//inicializácia tlacidiel...
	
	private Aktualizuj aktualizuj;
	
	private Button prehladTlacidlo = new Button("Prehlad skladov");
	private Button objednatTlacidlo = new Button("Objednat");
	private Button zoznamTlacidlo = new Button("Zoznam Objednavok");
	private Button odhlasTlacidlo = new Button("Odhlasit");
	private Button chemTlacidlo = new Button("Zoznam chemickych latok");
	
	
	private Text zoznamSkladovText = new Text ("Zoznam Skladov");
	private Button firmaTlacidlo = new Button("Firma");
	private Button skladStupenJednaTlacidlo = new Button("Sklad stupen 1");
	private Button skladStupenDvaTlacidlo = new Button("Sklad stupen 2");
	private Button skladStupenTriTlacidlo = new Button("Sklad stupen 3");
	private Button skladStupenStyriTlacidlo = new Button("Sklad stupen 4");
	private Button skladStupenPatTlacidlo = new Button("Sklad stupen 5");
	

	
	private Button podrobnostiTlacidlo = new Button("Podrobnosti");
	private Text mnozstvoText = new Text ("Mnozstvo chemickych latok v kg.");
	private Text skupenstvoText = new Text ("Skupenstvo");
	private Text pevneText = new Text ("pevne");
	private Text kvapalneText = new Text ("kvapalne");
	private Text plynneText = new Text ("plynne");
	private Text celkomText = new Text ("celkom");
	private Text menoText = new Text();
	private Text mPevneText = new Text();
	private Text mPlynneText = new Text();
	private Text mKvapalneText = new Text();
	private Text spoluText = new Text();
	
	private Controller controller;
	

	public Hlavneokno(String meno, Controller Kontroller){        					//hlavné menu 
		
		super();
		
		this.controller=Kontroller;
		
		menoText.setText(meno);
		setTitle("Hlavne menu");
		GridPane hlOkno = new GridPane();
		
		hlOkno.setHgap(9);
		hlOkno.setVgap(5);
		hlOkno.setPadding(new Insets(10,20,10,20));
		
		hlOkno.getChildren().addAll(menoText,prehladTlacidlo,objednatTlacidlo,zoznamTlacidlo,chemTlacidlo,zoznamSkladovText,firmaTlacidlo,skladStupenDvaTlacidlo,
				skladStupenJednaTlacidlo,skladStupenPatTlacidlo,skladStupenStyriTlacidlo,skladStupenTriTlacidlo,podrobnostiTlacidlo,odhlasTlacidlo,mnozstvoText,
				skupenstvoText,pevneText,kvapalneText,plynneText,celkomText,mPevneText,mPlynneText,mKvapalneText,spoluText);
		
		GridPane.setConstraints(prehladTlacidlo,1,1);
		GridPane.setConstraints(menoText,5,2);
		GridPane.setConstraints(objednatTlacidlo,2,1);
		GridPane.setConstraints(zoznamTlacidlo,3,1);
		GridPane.setConstraints(chemTlacidlo,4,1);
		GridPane.setConstraints(odhlasTlacidlo,5,1);
		GridPane.setConstraints(zoznamSkladovText,1,3);
		GridPane.setConstraints(firmaTlacidlo,1,4);
		GridPane.setConstraints(skladStupenJednaTlacidlo,1,5);
		GridPane.setConstraints(skladStupenDvaTlacidlo,1,6);
		GridPane.setConstraints(skladStupenTriTlacidlo,1,7);
		GridPane.setConstraints(skladStupenStyriTlacidlo,1,8);
		GridPane.setConstraints(skladStupenPatTlacidlo,1,9);
		GridPane.setConstraints(podrobnostiTlacidlo,5,9);
		GridPane.setConstraints(mnozstvoText,3,3);
		GridPane.setConstraints(skupenstvoText,3,4);
		GridPane.setConstraints(pevneText,3,5);
		GridPane.setConstraints(kvapalneText,3,6);
		GridPane.setConstraints(plynneText,3,7);
		GridPane.setConstraints(celkomText,3,8);
		GridPane.setConstraints(mPevneText,4,5);
		GridPane.setConstraints(mKvapalneText,4,6);
		GridPane.setConstraints(mPlynneText,4,7);
		GridPane.setConstraints(spoluText,4,8);
		
		aktualizuj =new Aktualizuj(controller);
		controller.addSledovatel(aktualizuj);
		GridPane.setConstraints(aktualizuj, 4, 9);
		
		hlOkno.getChildren().add(aktualizuj);
		zoznamTlacidlo.setOnAction(e->{
			new Objednavka(controller);
			
		});
		
		objednatTlacidlo.setOnAction(e -> {                                             //funkcie pre tlacidlá
			new Objednaj(controller);
			});
		 
		
		
		chemTlacidlo.setOnAction(e -> {
			ZoznamChem a = new ZoznamChem();
			a.prehlad();
			
			});
		
		
		
		firmaTlacidlo.setOnAction(e ->{
			mPevneText.setText(Integer.toString(controller.zistiHmotnostFirma("tuhe")));
			mKvapalneText.setText(Integer.toString(controller.zistiHmotnostFirma("kvapalne")));
			mPlynneText.setText(Integer.toString(controller.zistiHmotnostFirma("plynne")));
			spoluText.setText(Integer.toString(controller.zistiHmotnostFirma("tuhe") + controller.zistiHmotnostFirma("kvapalne")+controller.zistiHmotnostFirma("plynne")));
			
			
		});
		
	
		skladStupenJednaTlacidlo.setOnAction(e->{
			
			mPevneText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "jedna")));
			mKvapalneText.setText(Integer.toString(controller.zistiHmotnost("kvapalne", "jedna")));
			mPlynneText.setText(Integer.toString(controller.zistiHmotnost("plynne", "jedna")));
			spoluText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "jedna")+controller.zistiHmotnost("kvapalne", "jedna")+controller.zistiHmotnost("plynne", "jedna")));
		});
		
		skladStupenDvaTlacidlo.setOnAction(e->{
			
			mPevneText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "2")));
			mKvapalneText.setText(Integer.toString(controller.zistiHmotnost("kvapalne", "2")));
			mPlynneText.setText(Integer.toString(controller.zistiHmotnost("plynne", "2")));
			spoluText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "2")+controller.zistiHmotnost("kvapalne", "2")+controller.zistiHmotnost("plynne", "2")));
		});
		
		skladStupenTriTlacidlo.setOnAction(e->{
			
			mPevneText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "3")));
			mKvapalneText.setText(Integer.toString(controller.zistiHmotnost("kvapalne", "3")));
			mPlynneText.setText(Integer.toString(controller.zistiHmotnost("plynne", "3")));
			spoluText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "3")+controller.zistiHmotnost("kvapalne", "3")+controller.zistiHmotnost("plynne", "3")));
		});
		
		skladStupenStyriTlacidlo.setOnAction(e->{
			
			mPevneText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "4")));
			mKvapalneText.setText(Integer.toString(controller.zistiHmotnost("kvapalne", "4")));
			mPlynneText.setText(Integer.toString(controller.zistiHmotnost("plynne", "4")));
			spoluText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "4")+controller.zistiHmotnost("kvapalne", "4")+controller.zistiHmotnost("plynne", "4")));
		});
		
		skladStupenPatTlacidlo.setOnAction(e->{
			
			mPevneText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "5")));
			mKvapalneText.setText(Integer.toString(controller.zistiHmotnost("kvapalne", "5")));
			mPlynneText.setText(Integer.toString(controller.zistiHmotnost("plynne", "5")));
			spoluText.setText(Integer.toString(controller.zistiHmotnost("tuhe", "5")+controller.zistiHmotnost("kvapalne", "5")+controller.zistiHmotnost("plynne", "5")));
		});
		
		
		
		
		 Scene scene = new Scene(hlOkno,850,350);
		 setScene(scene);
		 show();
		
		
		 
		 
		 
		 
		
	}


}
