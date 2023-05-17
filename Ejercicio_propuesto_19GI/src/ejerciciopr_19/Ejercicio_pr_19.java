package ejerciciopr_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio_pr_19 {

	public static void main(String[] args) {
		
		Marco marco_equilatero = new Marco();
		marco_equilatero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Marco(){
		
		setBounds(400,150,600,450);
		Lamina lamina_equilatero = new Lamina();
		add(lamina_equilatero);
		setTitle("Triángulo equilátero");
		setVisible(true);
	}

}

class Lamina extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField campo_lado;
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
		JLabel valor_lado = new JLabel("Ingrese la medida del lado de un triángulo equilátero: ",
				JLabel.CENTER);
		lamina_top.add(valor_lado);
		campo_lado = new JTextField();
		lamina_top.add(campo_lado);
		
		// Salida lamina bottom (center)
		salida = new JTextArea();
		add(salida, BorderLayout.CENTER);
		
		// Botones bottom
		JButton ver_triangulo = new JButton("Ver características del triangulo");
		lamina_bottom.add(ver_triangulo);
		
		JButton salir = new JButton("Salir");
		lamina_bottom.add(salir);
		
		Mostrar_salario evento = new Mostrar_salario();
		ver_triangulo.addActionListener(evento);
		
		Cerrar_ventana evento_cerrar = new Cerrar_ventana();
		salir.addActionListener(evento_cerrar);
		
	}
	
	private class Mostrar_salario implements ActionListener{
		
		private double lado;
		private double perimetro;
		private double altura;
		private double area;
		private String Caracteristicas;
		
		public void actionPerformed(ActionEvent e) {
			
			lado = Double.parseDouble(campo_lado.getText().trim());
			perimetro = lado*3;
			altura = Math.sqrt(Math.pow(lado, 2)-Math.pow(lado/2, 2));
			area = (altura*lado)/2;
			
			Caracteristicas = "Las características del triángulo "
					+ "equilátero con lado "+ lado +
					" son: \n\nPerímetro: "+ perimetro +
					"\nAltura: "+ altura +
					"\nÁrea: "+ area;
			
			salida.setText(Caracteristicas);
			
		}
		
		
		
	}
	
	private class Cerrar_ventana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.getWindowAncestor(Lamina.this).dispose();
			
		}
		
		
	}
		
}
