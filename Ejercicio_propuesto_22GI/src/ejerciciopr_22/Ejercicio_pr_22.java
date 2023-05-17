package ejerciciopr_22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio_pr_22 {

	public static void main(String[] args) {
		
		Marco marco_empleado = new Marco();
		marco_empleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Marco(){
		
		setBounds(400,150,600,450);
		Lamina lamina_empleado = new Lamina();
		add(lamina_empleado);
		setTitle("Salario por empleado");
		setVisible(true);
	}

}

class Lamina extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField campo_nombre;
	private JTextField campo_salario_hora;
	private JTextField campo_horas;
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
		JLabel texto_nombre = new JLabel("Nombre del empleado: ", JLabel.CENTER);
		lamina_top.add(texto_nombre);
		campo_nombre = new JTextField();
		lamina_top.add(campo_nombre);
		
		JLabel texto_valor_hora = new JLabel("Salario básico por hora: ", JLabel.CENTER);
		lamina_top.add(texto_valor_hora);
		campo_salario_hora = new JTextField();
		lamina_top.add(campo_salario_hora);
		
		JLabel texto_horas = new JLabel("Horas trabajadas: ", JLabel.CENTER);
		lamina_top.add(texto_horas);
		campo_horas = new JTextField();
		lamina_top.add(campo_horas);
		
		// Salida lamina bottom (center)
		salida = new JTextArea();
		add(salida, BorderLayout.CENTER);
		
		// Botones bottom
		JButton ver_datos = new JButton("Ver datos");
		lamina_bottom.add(ver_datos);
		
		JButton salir = new JButton("Salir");
		lamina_bottom.add(salir);
		
		Mostrar_salario evento = new Mostrar_salario();
		ver_datos.addActionListener(evento);
		
		Cerrar_ventana evento_cerrar = new Cerrar_ventana();
		salir.addActionListener(evento_cerrar);
		
	}
	
	private class Mostrar_salario implements ActionListener{
		
		private String nombre;
		private double salario_hora;
		private double horas;
		private double salario_mensual;
		private String datos_empleado;
		
		public void actionPerformed(ActionEvent e) {
			
			nombre = campo_nombre.getText().trim();
			salario_hora = Double.parseDouble(campo_salario_hora.getText().trim());
			horas = Double.parseDouble(campo_horas.getText().trim());
			salario_mensual = horas*salario_hora;
			
			if (salario_mensual>450000) {
				datos_empleado = "Nombre: "+ nombre +
						"\nSalario mensual: $"+ salario_mensual;
			}
			else{
				datos_empleado = "Nombre: "+ nombre;
			}
			
			salida.setText(datos_empleado);
			
		}
		
	}
	
	private class Cerrar_ventana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.getWindowAncestor(Lamina.this).dispose();
			
		}
			
	}
		
}