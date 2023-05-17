package ejerciciopr_40;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio_pr_40 {

	public static void main(String[] args) {
		
		Marco marco_operaciones = new Marco();
		marco_operaciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Marco(){
		
		setBounds(400,150,600,450);
		Lamina lamina_operaciones = new Lamina();
		add(lamina_operaciones);
		setTitle("Raíz, cuadrado y cubo");
		setVisible(true);
	}

}

class Lamina extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField[] campos;
	private JTextArea salida;
	private JScrollPane scrollPane;
	
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
		scrollPane = new JScrollPane(salida);
		add(scrollPane, BorderLayout.CENTER);
		
		// Botones bottom
		
		JButton mostrar_resultados = new JButton("Mostrar resultados");
		lamina_bottom.add(mostrar_resultados);
		
		JButton salir = new JButton("Salir");
		lamina_bottom.add(salir);
		
		Mostrar_resultados evento = new Mostrar_resultados();
		mostrar_resultados.addActionListener(evento);
		
		Cerrar_ventana evento_cerrar = new Cerrar_ventana();
		salir.addActionListener(evento_cerrar);
		
	}
	
	private class Mostrar_resultados implements ActionListener{
		
		private double num;
		private String solucion = "";
		
		public void actionPerformed(ActionEvent e) {
			
			for (int cam=0; cam < campos.length; cam++) {
				
				num = Double.parseDouble(campos[cam].getText().trim());
				solucion += cam+". Número: "+num+", Raíz cuadrada: "+Math.sqrt(num)+", Cuadrado: "+
				Math.pow(num,2)+", Cubo: "+Math.pow(num, 3)+"\n";
				
			}
			
			salida.setText(solucion);
			
		}
		
		
		
	}
	
	private class Cerrar_ventana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.getWindowAncestor(Lamina.this).dispose();
			
		}
		
		
	}
		
}