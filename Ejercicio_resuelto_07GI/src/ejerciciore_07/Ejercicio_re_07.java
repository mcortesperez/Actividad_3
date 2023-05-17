package ejerciciore_07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio_re_07 {

	public static void main(String[] args) {
		
		Marco marco_ab = new Marco();
		marco_ab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Marco(){
		
		setBounds(400,150,600,450);
		Lamina lamina_ab = new Lamina();
		add(lamina_ab);
		setTitle("Comparación entre A y B");
		setVisible(true);
	}

}

class Lamina extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField campoA;
	private JTextField campoB;
	private JTextArea salida;
	
	public Lamina() {
		
		setLayout(new BorderLayout());
		
		// Laminas
		JPanel lamina_top = new JPanel();
		add(lamina_top, BorderLayout.NORTH);
		
		JPanel lamina_bottom = new JPanel();
		add(lamina_bottom, BorderLayout.SOUTH);
		
		lamina_top.setLayout(new GridLayout(3,1,10,10));
		
		// Componentes lamina top
		JLabel valor_a = new JLabel("Ingrese un número A: ",JLabel.CENTER);
		lamina_top.add(valor_a);
		campoA = new JTextField();
		lamina_top.add(campoA);
		
		JLabel valor_b = new JLabel("Ingrese un número B: ",JLabel.CENTER);
		lamina_top.add(valor_b);
		campoB = new JTextField();
		lamina_top.add(campoB);
		
		// Salida lamina bottom (center)
		salida = new JTextArea();
		add(salida, BorderLayout.CENTER);
		
		// Botones bottom
		JButton resultado = new JButton("Resultado");
		lamina_bottom.add(resultado);
		
		JButton salir = new JButton("Salir");
		lamina_bottom.add(salir);
		
		Mostrar_salario evento = new Mostrar_salario();
		resultado.addActionListener(evento);
		
		Cerrar_ventana evento_cerrar = new Cerrar_ventana();
		salir.addActionListener(evento_cerrar);
		
	}
	
	private class Mostrar_salario implements ActionListener{
		
		private double A;
		private double B;
		private String resp;
		
		public void actionPerformed(ActionEvent e) {
			
			A = Double.parseDouble(campoA.getText().trim());
			B = Double.parseDouble(campoB.getText().trim());
			
			if(A<B) {
				resp = "A es menor que B";
			}
			else if(A>B) {
				resp = "A es mayor que B";
			}
			else {
				resp = "A es igual a B";
			}
			
			salida.setText(resp);
			
		}
		
		
		
	}
	
	private class Cerrar_ventana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.getWindowAncestor(Lamina.this).dispose();
			
		}
		
		
	}
		
}