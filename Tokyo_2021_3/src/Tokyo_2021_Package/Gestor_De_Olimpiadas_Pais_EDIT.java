package Tokyo_2021_Package;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Gestor_De_Olimpiadas_Pais_EDIT{
	
		private static JLabel Label_Name; 
		private static JTextField Text_Name;  
		private static JButton Save;

		public static void create(JFrame frame,Pais pais) {		 		
			
			
			Label_Name = new JLabel("NOMBRE: ");
			Label_Name.setBounds(120,80,60,20);
			
			Text_Name  = new JTextField("",10); 
			Text_Name.setEditable(true);  
			Text_Name.setText(pais.getNombre());
			Text_Name.setBounds(200,80,240,20);

	        frame.getContentPane().add(Label_Name);
	        frame.getContentPane().add(Text_Name);

	        //BENINNG SAVE
			Save = new JButton("GUARDAR");
	        frame.getContentPane().add(Save);
	        Save.setBounds(220,140,120,20);
	        //END SAVE
			//BEGINNING SET UP SAVE
		    Save.addActionListener( new ActionListener(){
	        	@Override
	 			 public void actionPerformed(ActionEvent e) {
	        		//BEGINNING SET UP ACCION�S 
	        		Pais p = new Pais();
	        		PaisDAOjdbc p_ddbb = new PaisDAOjdbc();
	        		
	        		p.setNombre(Text_Name.getText());
	        		p.setId(pais.getId()); 
	        		//MODIFICATION BBDD
	        		p_ddbb.update(p);;
	        		
	    	        //END  SET UP ACCION�S 
	        		frame.dispose();
	        		Gestor_De_Olimpiadas_PAIS.createWindow();
				 }
	 		 }); 
	        //END  SET UP SAVE
		    
		    
	        
		 }

		public static void createWindow(Pais pais) {
				JFrame Window = new JFrame("Gestor de Olimpiadas");
				Window.setBounds(100, 100, 600, 300);
				Window.getContentPane().setLayout(null);
				create(Window,pais);
				Window.setResizable(false);
				Window.setVisible(true);
		}
	
		
}