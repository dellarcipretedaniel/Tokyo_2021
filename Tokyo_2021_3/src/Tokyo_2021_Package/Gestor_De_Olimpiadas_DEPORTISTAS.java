package Tokyo_2021_Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;  
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

public class Gestor_De_Olimpiadas_DEPORTISTAS {

	//private String[] Title_Table2 = {"Nombre y Apellido","Pa�s","Disciplina"};
	
	public static void create(JFrame frame) {
        //BUTTON NEW
		JButton Button_New = new JButton("NUEVO");
		Button_New.setBounds(160,20,100,50);
        Button_New.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_New.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_New);
			      //BEGINNING SET UP RETURN
			        Button_New.addActionListener( new ActionListener(){
			        	@Override
			 			 public void actionPerformed(ActionEvent e) {
			        		Gestor_De_Olimpiadas_NUEVO_DEPORTISTA.createWindow();
						 }
			 		 }); 
			        //END  SET UP RETURN
        //EXPORT CSV
        JButton Button_Export = new JButton("EXPORTAR CSV");
        Button_Export.setBounds(280,20,140,50);
        Button_Export.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Export.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Export);
      //  Button_Export.addActionListener(Button_Export);
        //				Generar_CSV
        //VOLVER
        JButton Button_Return = new JButton("VOLVER");
		Button_Return.setBounds(440,20,100,50);
		Button_Return.setVerticalTextPosition(SwingConstants.BOTTOM);
		Button_Return.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Return); 
        Button_Return.addActionListener( new ActionListener(){
				        	@Override
				 			 public void actionPerformed(ActionEvent e) {
				        		//BEGINNING SET UP ACCION�S 
				        		//MODIFICATION BBDD
				    	        //END  SET UP ACCION�S 
				        		frame.dispose();
							 }
				 		 }); 
				        //END  SET UP RETURN
        //BARRA DE TITULO DEPORTISTAS
        JLabel Title_Table = new JLabel(" Deportistas ");
        Title_Table.setBounds(160,20,360,75);
        Title_Table.setVerticalTextPosition(SwingConstants.BOTTOM);
        Title_Table.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Title_Table);
        //VISUALIZACION DE TABLA DEPORTISTAS
        
        JTable estructura;
	    JTable tabla = new JTable();
        String[] encabezado = {"nombre","pais","disciplina","boton","boton"};
	    //String[] aCargar = new String[5];//[apellido][pais][disciplina][editar][eliminar]
	    Object[][] pepe = {{"h","h","h","h","h"}};
	    pepe[0][0] = "lolo";
	    System.out.println(pepe[0][0]);
	    
	    //DefaultTableModel modelo = new DefaultTableModel();
	    
	    List<Deportista> listaDeportista = FactoryDAO.getDeportistaDAO().load();
	    PaisDAO pais_bbdd = FactoryDAO.getPaisDAO();
	    DisciplinaDAO disciplina_bbdd = FactoryDAO.getDisciplinaDAO();
	    Pais pais = new Pais();
	    for (int i = 0; i< listaDeportista.size(); i++) {
	    	   pepe[0][i] = listaDeportista.get(i).getApellido();
	    	   System.out.println(pepe[0][i]);
	    	   pais = pais_bbdd.find(listaDeportista.get(i).getPais());
	    	   pepe[1][i] = pais.getNombre();
	    	   pepe[2][i] = disciplina_bbdd.find(listaDeportista.get(i).getId());
	    	   pepe[3][i] = "edit";
	    	   pepe[4][i] = "eliminar";
	    	   
	    }
	    
	       
	       
	      // JTable datos a mostrar
	    	   
	       
	       tabla.setModel(new Modelo(pepe, encabezado));
	      // Container contentPane = frame.getContentPane();
	     //  tabla.getTableHeader().setReorderingAllowed(false);
	      // contentPane.setLayout(new BorderLayout());
	       tabla.setBounds(15,120,500,160);
	       JScrollPane scroll = new JScrollPane(tabla);
	       scroll.setBounds(15,120,600,160);
	       frame.getContentPane().add(scroll);
	       frame.setVisible(true);
	      // frame.getContentPane().add(tabla);
	      // contentPane.add(new JScrollPane(tabla), BorderLayout.CENTER);
	     //  frame.pack();
	       frame.setVisible(true);
	       
		}
	
	
	

	public String[] Listado(){
		String[] Cadena = null;
		 
	return Cadena;}
	public static void createWindow() {
		JFrame Window = new JFrame("Gestor de Olimpiadas - DEPORTISTAS ");
		Window.setBounds(100, 100, 700, 500);
		Window.getContentPane().setLayout(null);
		create(Window);
		Window.setResizable(false);
		Window.setVisible(true);
	}
}	
	


