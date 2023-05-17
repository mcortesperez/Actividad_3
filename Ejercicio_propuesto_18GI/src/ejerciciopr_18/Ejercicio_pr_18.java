package ejerciciopr_18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio_pr_18 {

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
	
	private JTextField campo_codigo;
	private JTextField campo_nombre;
	private JTextField campo_horas;
	private JTextField campo_valorhora;
	private JTextField campo_retefuente;
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
		JLabel texto_codigo = new JLabel("Codigo de empleado: ", JLabel.CENTER);
		lamina_top.add(texto_codigo);
		campo_codigo = new JTextField();
		lamina_top.add(campo_codigo);
		
		JLabel texto_nombre = new JLabel("Nombre completo: ", JLabel.CENTER);
		lamina_top.add(texto_nombre);
		campo_nombre = new JTextField();
		lamina_top.add(campo_nombre);
		
		JLabel texto_horas = new JLabel("Horas trabajadas en el mes: ", JLabel.CENTER);
		lamina_top.add(texto_horas);
		campo_horas = new JTextField();
		lamina_top.add(campo_horas);
		
		JLabel texto_valorhora = new JLabel("Valor de la hora trabajada: ", JLabel.CENTER);
		lamina_top.add(texto_valorhora);
		campo_valorhora = new JTextField();
		lamina_top.add(campo_valorhora);
		
		JLabel texto_retefuente = new JLabel("Porcentaje de retención en la fuente: ", JLabel.CENTER);
		lamina_top.add(texto_retefuente);
		campo_retefuente = new JTextField();
		lamina_top.add(campo_retefuente);
		
		// Salida lamina bottom (center)
		salida = new JTextArea();
		add(salida, BorderLayout.CENTER);
		
		// Botones bottom
		JButton ver_salario = new JButton("Ver salario");
		lamina_bottom.add(ver_salario);
		
		JButton salir = new JButton("Salir");
		lamina_bottom.add(salir);
		
		Mostrar_salario evento = new Mostrar_salario();
		ver_salario.addActionListener(evento);
		
		Cerrar_ventana evento_cerrar = new Cerrar_ventana();
		salir.addActionListener(evento_cerrar);
		
	}
	
	private class Mostrar_salario implements ActionListener{
		
		private String codigo;
		private String nombre;
		private String salario;
		
		private double horas;
		private double valor_hora;
		private double retefuente;
		private double salario_bruto;
		private double salario_neto;
		
		public void actionPerformed(ActionEvent e) {
			
			codigo = campo_codigo.getText().trim();
			nombre = campo_nombre.getText().trim();
			horas = Double.parseDouble(campo_horas.getText().trim());
			valor_hora = Double.parseDouble(campo_valorhora.getText().trim());
			retefuente = Double.parseDouble(campo_retefuente.getText().trim())/100;
			salario_bruto = horas*valor_hora;
			salario_neto = salario_bruto-salario_bruto*retefuente;
			
			salario = "Codigo: "+ codigo +
					"\nNombre: "+ nombre +
					"\nSalario bruto: "+ salario_bruto +
					"\nSalario neto: "+ salario_neto;
			
			salida.setText(salario);
			
		}
		
		
		
	}
	
	private class Cerrar_ventana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.getWindowAncestor(Lamina.this).dispose();
			
		}
		
		
	}
		
}
