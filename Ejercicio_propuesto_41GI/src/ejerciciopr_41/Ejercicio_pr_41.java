package ejerciciopr_41;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio_pr_41 {

	public static void main(String[] args) {
		
		Marco marco_mayor = new Marco();
		marco_mayor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Marco(){
		
		setBounds(400,150,600,450);
		Lamina lamina_mayor = new Lamina();
		add(lamina_mayor);
		setTitle("Número mayor");
		setVisible(true);
	}

}

class Lamina extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField[] campos;
	private JTextArea salida;
	
	public Lamina() {
		
		setLayout(new BorderLayout());
		
		// Laminas
		JPanel lamina_top = new JPanel();
		add(lamina_top, BorderLayout.NORTH);
		
		JPanel lamina_bottom = new JPanel();
		add(lamina_bottom, BorderLayout.SOUTH);
		
		lamina_top.setLayout(new GridLayout(3,4,10,10));
		
		// Componentes lamina top
		
		campos = new JTextField[6];
		
		for (int i=0; i<campos.length; i++) {
			JLabel ind = new JLabel("Ingrese No. "+i, JLabel.CENTER);
			lamina_top.add(ind);
			campos[i]=new JTextField();
			lamina_top.add(campos[i]);
		}
		
		// Salida lamina bottom (center)
		salida = new JTextArea();
		add(salida, BorderLayout.CENTER);
		
		// Botones bottom
		
		JButton mostrar_mayor = new JButton("Mostrar número mayor");
		lamina_bottom.add(mostrar_mayor);
		
		JButton salir = new JButton("Salir");
		lamina_bottom.add(salir);
		
		Mostrar_mayor evento = new Mostrar_mayor();
		mostrar_mayor.addActionListener(evento);
		
		Cerrar_ventana evento_cerrar = new Cerrar_ventana();
		salir.addActionListener(evento_cerrar);
		
	}
	
	private class Mostrar_mayor implements ActionListener{
		
		private double num;
		private double mayor;
		
		public void actionPerformed(ActionEvent e) {
			
			mayor=0;
			
			for (int cam=0; cam < campos.length; cam++) {
				
				num = Double.parseDouble(campos[cam].getText().trim());
				
				if (num>mayor) {
					mayor = num;
				}
				
			}
			
			salida.setText(""+mayor);
			
		}
		
		
		
	}
	
	private class Cerrar_ventana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.getWindowAncestor(Lamina.this).dispose();
			
		}
		
		
	}
		
}