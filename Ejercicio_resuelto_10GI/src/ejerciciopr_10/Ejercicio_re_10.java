package ejerciciopr_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio_re_10 {

	public static void main(String[] args) {
		
		Marco marco_matricula = new Marco();
		marco_matricula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Marco(){
		
		setBounds(400,150,600,450);
		Lamina lamina_matricula = new Lamina();
		add(lamina_matricula);
		setTitle("Valor de matricula");
		setVisible(true);
	}

}

class Lamina extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField campoins;
	private JTextField camponom;
	private JTextField campopat;
	private JTextField campoest;
	
	private JTextArea salida;
	
	public Lamina() {
		
		setLayout(new BorderLayout());
		
		// Laminas
		JPanel lamina_top = new JPanel();
		add(lamina_top, BorderLayout.NORTH);
		
		JPanel lamina_bottom = new JPanel();
		add(lamina_bottom, BorderLayout.SOUTH);
		
		lamina_top.setLayout(new GridLayout(5,2,10,10));
		
		// Componentes lamina top
		JLabel num_ins = new JLabel("Ingrese su número de inscripción: ",
				JLabel.CENTER);
		lamina_top.add(num_ins);
		campoins = new JTextField();
		lamina_top.add(campoins);
		
		JLabel texto_nombre = new JLabel("Ingrese su nombre completo: ",
				JLabel.CENTER);
		lamina_top.add(texto_nombre);
		camponom = new JTextField();
		lamina_top.add(camponom);
		
		JLabel texto_pat = new JLabel("Ingrese el valor de su patrimonio: ",
				JLabel.CENTER);
		lamina_top.add(texto_pat);
		campopat = new JTextField();
		lamina_top.add(campopat);
		
		JLabel texto_est = new JLabel("Ingrese su estrato: ",
				JLabel.CENTER);
		lamina_top.add(texto_est);
		campoest = new JTextField();
		lamina_top.add(campoest);
		
		// Salida lamina bottom (center)
		salida = new JTextArea();
		add(salida, BorderLayout.CENTER);
		
		// Botones bottom
		JButton ver_matricula = new JButton("Ver valor de matrícula");
		lamina_bottom.add(ver_matricula);
		
		JButton salir = new JButton("Salir");
		lamina_bottom.add(salir);
		
		Mostrar_salario evento = new Mostrar_salario();
		ver_matricula.addActionListener(evento);
		
		Cerrar_ventana evento_cerrar = new Cerrar_ventana();
		salir.addActionListener(evento_cerrar);
		
	}
	
	private class Mostrar_salario implements ActionListener{
		
		private String inscripcion;
		private String nombre;
		private double patrimonio;
		private int estrato;
		private double matricula;
		private String info;
		
		public void actionPerformed(ActionEvent e) {
			
			inscripcion = campoins.getText().trim();
			nombre = camponom.getText().trim();
			patrimonio = Double.parseDouble(campopat.getText().trim());
			estrato = Integer.parseInt(campoest.getText().trim());
			matricula = 50000;
			
			if(patrimonio > 2000000 && estrato > 3 ) {
				matricula += patrimonio*0.03;
			}
			
			info = "No. Inscripcion: "+inscripcion+ "\nNombre del estudiante: "+
			nombre+ "\nValor de pago de matrícula: "+matricula;
			
			salida.setText(info);
			
		}
		
		
		
	}
	
	private class Cerrar_ventana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.getWindowAncestor(Lamina.this).dispose();
			
		}
		
		
	}
		
}