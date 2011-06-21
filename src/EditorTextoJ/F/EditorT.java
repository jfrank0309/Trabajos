
package EditorTextoJ.F;



import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

final class EditorT extends JFrame {
	private int tamaño=17;
	private JTextArea areaTexto;
	private JButton cortar,copiar,pegar,nuevo,guardar,abrir,acerca,ayuda,imprimir,seleccionar;
	private JScrollPane scroll;
	private JComboBox tFuente;
	private Font areaFuente;


	public EditorT () {
		   super(" >Menu De Opciones<                                  Editor de Textos  by J-Frank             ");
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al intentar cargar L&F");
		}
		areaFuente= new Font("Arial", Font.PLAIN, tamaño);
		areaTexto= new JTextArea();
		areaTexto.setFont(areaFuente);


		menu ();
		barra();
		scroll= new JScrollPane(areaTexto);
		getContentPane().add(scroll,BorderLayout.CENTER);
		JPanel panel= new JPanel();
		JPanel panel1= new JPanel();
		JPanel panel2= new JPanel();
		panel.setBackground(Color.lightGray);
		panel1.setBackground(Color.lightGray);
		panel2.setBackground(Color.lightGray);
		getContentPane().add(panel,BorderLayout.SOUTH);
		getContentPane().add(panel1,BorderLayout.WEST);
		getContentPane().add(panel2,BorderLayout.EAST);

		setSize(800,580);
		setVisible(true);
		show ();
	}
 
	public void menu () {
		JMenuBar menu = new JMenuBar();
		JMenu editar= new JMenu("Editar");
		JMenuItem cor= new JMenuItem("Cortar");
		cor.addActionListener (
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					cortar ();
				}
			}
		);
		JMenuItem cop= new JMenuItem("Copiar");
		cop.addActionListener (
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					copiar ();
				}
			}
		);
		JMenuItem peg= new JMenuItem ("Pegar");
		peg.addActionListener (
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					pegar ();
				}
			}
		);
                JMenuItem selec= new JMenuItem ("Seleccionar Todo");
		selec.addActionListener (
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					seleccionar ();
				}
			}
		);
		
                editar.add(cop);
		editar.add(cor);
		editar.add(peg);
                editar.add(selec);
		editar.addSeparator();
		setJMenuBar(menu);

	}
 
	public void barra () {
		JToolBar barras= new JToolBar();

		nuevo= new JButton (">Nuevo");
		nuevo.setMargin(new Insets(2,0,0,0));
		nuevo.addActionListener(
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					nuevo ();
				}
			}
		);
		barras.add(nuevo);
                barras.addSeparator();

                abrir= new JButton(">Abrir");
		abrir.setMargin(new Insets(-2,0,0,0));
		abrir.addActionListener(
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					abrir ();
				}
			}
		);
		barras.add(abrir);
                barras.addSeparator();

		guardar= new JButton(">Guardar");
		guardar.setMargin(new Insets(2,0,0,0));
		guardar.addActionListener(
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					guardar ();
				}
			}
		);
		barras.add(guardar);
                barras.addSeparator();

		cortar= new JButton(">Cortar");
		cortar.setMargin(new Insets(-2,0,0,0));
		cortar.addActionListener (
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					cortar ();
				}
			}
		);
		barras.add(cortar);
                barras.addSeparator();

		copiar= new JButton(">Copiar");
		copiar.setMargin(new Insets(2,0,0,0));
		copiar.addActionListener (
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					copiar ();
				}
			}
		);
		barras.add(copiar);
                barras.addSeparator();

		pegar= new JButton(">Pegar");
		pegar.setMargin(new Insets(-2,0,0,0));
		pegar.addActionListener (
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					pegar ();
				}
			}
		);
		barras.add(pegar);
                barras.addSeparator();

		JButton del= new JButton(">Barrar todo");
		del.setMargin(new Insets(2,0,0,0));
		del.addActionListener (
			new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					areaTexto.setText("");
				}
			}
		);
		barras.add(del);
		barras.addSeparator();

                // Metodo para la opcion del tamanio de las letras
		tFuente= new JComboBox();
		tFuente.addItem("Tamaño de Fuente");
		tFuente.addItem("10");
		tFuente.addItem("20");
		tFuente.addItem("30");
		tFuente.addItem("40");
		tFuente.addItem("50");
		tFuente.addItem("Personalizar");
		tFuente.setToolTipText("Tamaño de Fuente");
		tFuente.addItemListener(
			new ItemListener () {
				public void itemStateChanged(ItemEvent e) {

					int elegido;
					elegido=tFuente.getSelectedIndex();
					switch (elegido) {

						case 1:
							areaFuente= new Font("Arial", Font.PLAIN, 10);
							areaTexto.setFont(areaFuente);
							break;

						case 2:
							areaFuente= new Font("Arial", Font.PLAIN, 20);
							areaTexto.setFont(areaFuente);
							break;

						case 3:
							areaFuente= new Font("Arial", Font.PLAIN, 30);
							areaTexto.setFont(areaFuente);
							break;

						case 4:
							areaFuente= new Font("Arial", Font.PLAIN, 40);
							areaTexto.setFont(areaFuente);
							break;

						case 5:
							areaFuente= new Font("Arial", Font.PLAIN, 50);
							areaTexto.setFont(areaFuente);
							break;
						case 6:
							tamaño=Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño de la fuente"));
							areaFuente= new Font("Arial", Font.PLAIN, tamaño);
							areaTexto.setFont(areaFuente);
							break;
					}
				}
			}
		);
		barras.add(tFuente);
		barras.addSeparator();

		getContentPane().add(barras,BorderLayout.NORTH);
	}

	public void nuevo () {
		new EditorT ();
	}

	public void abrir () { // Metodo para abrir los Archivos (.txt)
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result= fileChooser.showOpenDialog(this);
		if (result== JFileChooser.CANCEL_OPTION) return;
		File name= fileChooser.getSelectedFile();
		if(name.exists()) {
			if (name.isFile()) {
				try {
					BufferedReader input= new BufferedReader(new FileReader (name));
					StringBuilder buffer= new StringBuilder();
					String text;
					areaTexto.setText("");
					while ((text=input.readLine()) !=null)
						buffer.append(text).append("\n");
					areaTexto.append(buffer.toString());
				}
				catch (IOException ioException) {
					JOptionPane.showMessageDialog(null,"Error en el archivo", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (name.isDirectory ()) {
				String directory[] = name.list();
				areaTexto.append("\n\nContenido del directorio:\n");
				for (int i=0;i<directory.length; i++)
					areaTexto.append(directory [i]+"\n");
			}
			else {
				JOptionPane.showMessageDialog(null," No existe "," Error ",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void guardar () { // Metodo para guardar los Archivos en formato (.txt)
		JOptionPane.showMessageDialog(null,"¡Por favor no olvide colocar la extension del archivo (*.txt)!");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result= fileChooser.showSaveDialog(this);
		if (result== JFileChooser.CANCEL_OPTION) return;
			File name= fileChooser.getSelectedFile();
			try {
				PrintWriter output= new PrintWriter(new FileWriter( name));
				output.write(areaTexto.getText());
				output.close();
			}
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(null,"Error en el archivo","Error",JOptionPane.ERROR_MESSAGE);
			}
	}
      public   void imprimir ()// Metodo para imprimir el Archivo
       {
       	   String todo=areaTexto.getText();
     	  	PrintJob pjob = getToolkit().getPrintJob(this,"Imprimir Hoja",null);
	     	  	Graphics pg=  pjob.getGraphics();
	     	  	pg.setFont(new Font("SansSerif",Font.PLAIN,10));
	     	  	pg.drawString("Imprimido:",100,100);
	     	  	int inicio=0;
	     	  	int numlineas=1;
	     	  	for (int i=0; i<todo.length();i++)
	     	  	 {
	     	  	    if((int) todo.charAt(i)==10)
	     	  	     {
	     	  	    	pg.drawString(todo.substring(inicio,i-1),100,100 + (15 * numlineas));
	     	  	    	inicio=i+1;
	     	  	    	numlineas ++;
	     	  	     }
	     	  	 }
	     	  	pg.drawString (todo.substring(inicio,todo.length()),100,100 + (15 * numlineas));
	     	  	pg.dispose (); //Finalizar pagina
	     	  	pjob.end(); //Termina trabajo y escupe pagina
       }


	public void cortar () {
		areaTexto.cut();
	}

	public void copiar () {
		areaTexto.copy();
	}

	public void pegar () {
		areaTexto.paste();
	}

        public void seleccionar()
        {
	     areaTexto.requestFocus();
	     areaTexto.selectAll();
	}



	public void ayuda () {
		JOptionPane.showMessageDialog(null," Nuevo: Abre una nueva ventana\n Abrir: Abre un documento existente\n Guardar: Guarda el documento\n Salir: Salir del programa\n Cortar: ctrl+x\n Copiar: ctrl+c\n Pegar: ctrl+v\n Salir sin guardar: alt+F4");
	}

	public void tamaño_f () {
		tamaño=Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño de la fuente"));
		areaFuente= new Font("Arial", Font.PLAIN, tamaño);
		areaTexto.setFont(areaFuente);
	}

	public void acerca () {
		JOptionPane.showMessageDialog(null,"                Editor de Textos"
                                                 + "\nInstituto Tecnologico de Las Americas (ITLA)"
                                                 + "\nProgramacion I"
                                                 + "\nDesarrollado por: Juan Francisco Guzman Garcia"
                                                 + "\nMatricuala: 2009-2562"
                                                 + "\nE-mail: frank-juan_0309@hotmail.com");
	}

	public static void main (String []args) {
		JOptionPane.showMessageDialog(null,"Para el correto funcionamiento del Editor de Textos\n Por favor Abrir solo Archivos de Tipo *.txt");
		new EditorT();
	}
}