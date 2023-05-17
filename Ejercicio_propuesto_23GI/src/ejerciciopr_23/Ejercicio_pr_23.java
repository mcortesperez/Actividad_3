package ejerciciopr_23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio_pr_23 {

	public static void main(String[] args) {
		
		Marco marco_cuadratica = new Marco();
		marco_cuadratica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Marco(){
		
		setBounds(400,150,600,450);
		Lamina lamina_equilatero = new Lamina();
		add(lamina_equilatero);
		setTitle("Solución ecuación cuadrática");
		setVisible(true);
	}

}

class Lamina extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField campo_a;
	private JTextField campo_b;
	private JTextField campo_c;
	private JTextArea salida;
	
	public Lamina() {
		
		setLayout(new BorderLayout());
		
		// Laminas
		JPanel lamina_top = new JPanel();
		add(lamina_top, BorderLayout.NORTH);
		
		JPanel lamina_bottom = new JPanel();
		add(lamina_bottom, BorderLayout.SOUTH);
		
		lamina_top.setLayout(new GridLayout(4,2,10,10));
		
		// Componentes lamina top
		JLabel valor_a = new JLabel("Ingrese el parámetro a: ",JLabel.CENTER);
		lamina_top.add(valor_a);
		campo_a = new JTextField();
		lamina_top.add(campo_a);
		
		JLabel valor_b = new JLabel("Ingrese el parámetro b: ",JLabel.CENTER);
		lamina_top.add(valor_b);
		campo_b = new JTextField();
		lamina_top.add(campo_b);
		
		JLabel valor_c = new JLabel("Ingrese el parámetro c: ",JLabel.CENTER);
		lamina_top.add(valor_c);
		campo_c = new JTextField();
		lamina_top.add(campo_c);
		
		// Salida lamina bottom (center)
		salida = new JTextArea();
		add(salida, BorderLayout.CENTER);
		
		// Botones bottom
		JButton ver_sol = new JButton("Ver soluciones de la ecuación");
		lamina_bottom.add(ver_sol);
		
		JButton salir = new JButton("Salir");
		lamina_bottom.add(salir);
		
		Mostrar_salario evento = new Mostrar_salario();
		ver_sol.addActionListener(evento);
		
		Cerrar_ventana evento_cerrar = new Cerrar_ventana();
		salir.addActionListener(evento_cerrar);
		
	}
	
	private class Mostrar_salario implements ActionListener{
		
		private double a;
		private double b;
		private double c;
		private double sol_1;
		private double sol_2;
		private double det;
		private String Soluciones;
		
		public void actionPerformed(ActionEvent e) {
			
			a = Double.parseDouble(campo_a.getText().trim());
			b = Double.parseDouble(campo_b.getText().trim());
			c = Double.parseDouble(campo_c.getText().trim());
			det = Math.pow(b, 2)-(4*a*c);
			
			if(det<0) {
				Soluciones = "La ecuación ingresada no tiene solucion en los reales.";
			}
			else if(det==0) {
				sol_1 = -b/(2*a);
				Soluciones = "La ecuación tiene una única solución, x = "+ sol_1;
			}
			else {
				sol_1 = (-b+Math.sqrt(det))/(2*a);
				sol_2 = (-b-Math.sqrt(det))/(2*a);
				
				Soluciones = "Las soluciones de la ecuación son, x = "+ sol_1 +
						" y x = "+ sol_2;
			}
			
			salida.setText(Soluciones);
			
		}
		
		
		
	}
	
	private class Cerrar_ventana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.getWindowAncestor(Lamina.this).dispose();
			
		}
		
		
	}
		
}