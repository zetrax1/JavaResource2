package View;


import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javafx.stage.Stage;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import Controler.ZoznamCh;

/**
 * 
 *@author Vladimír Veèerek
 *@version 1.0
 *Okno so zoznamom chemikálií
 *
 */

public class ZoznamChem extends Stage {
	
	
	public Label menoText = new Label();
	private ZoznamCh zoznamText =new ZoznamCh();
	

	
	
	public void prehlad() {
		JPanel hlavnyPanel = new JPanel ();
		hlavnyPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Display Area" ) );

	   
	    JTextArea textovePole = new JTextArea ( 20, 60 );
	    textovePole.setEditable (false); 
	    
	    zoznamText.otvorSubor();
	    textovePole.setText(zoznamText.citajSuborCely());
	    zoznamText.zavriSubor();
	    
	    JScrollPane posun = new JScrollPane (textovePole);
	    posun.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    hlavnyPanel.add ( posun );
	    
	    
	    JFrame frame = new JFrame ();
	    frame.setLocationRelativeTo ( null );
	    frame.setVisible ( true );
	    frame.add (hlavnyPanel);
	    frame.pack ();
        
	}
	
	
	
	

}
