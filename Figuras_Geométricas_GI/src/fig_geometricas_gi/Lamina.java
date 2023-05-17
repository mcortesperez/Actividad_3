package fig_geometricas_gi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lamina extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JButton circulo_button;
	private JButton cuadrado_button;
	private JButton triangulo_button;
	private JButton rectangulo_button;
	
	public Lamina() {
		
		//Ordenamiento
		setLayout(new GridLayout(2,2,10,10));
		
		circulo_button = new JButton("Circulo");
		add(circulo_button);
		Crear_circulo evento_circulo = new Crear_circulo();
		circulo_button.addActionListener(evento_circulo);
		
		cuadrado_button = new JButton("Cuadrado");
		add(cuadrado_button);
		Crear_cuadrado evento_cuadrado = new Crear_cuadrado();
		cuadrado_button.addActionListener(evento_cuadrado);
		
		triangulo_button = new JButton("Triangulo");
		add(triangulo_button);
		Crear_triangulo evento_triangulo = new Crear_triangulo();
		triangulo_button.addActionListener(evento_triangulo);
		
		rectangulo_button = new JButton("Rectangulo");
		add(rectangulo_button);
		Crear_rectangulo evento_rectangulo = new Crear_rectangulo();
		rectangulo_button.addActionListener(evento_rectangulo);
	
	}
	
	private class Crear_circulo implements ActionListener{
		
		private Marco_figura marco_circulo;
		private JTextField campo_radio;
		private JLabel valor_radio;
		private JPanel lamina_circulo;
		private JPanel lamina_top;
		private JPanel lamina_bottom;
		private JButton boton_circulo;
		private JButton salir_circulo;
		private JTextArea salida_circulo;
		
		public void actionPerformed(ActionEvent e) {
			
			marco_circulo = new Marco_figura();
			marco_circulo.setBounds(300,150,550,400);
			marco_circulo.setTitle("Circulo");
			marco_circulo.setVisible(true);
			marco_circulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			lamina_circulo = new JPanel();
			lamina_circulo.setLayout(new BorderLayout());
			
			lamina_top = new JPanel();
			lamina_top.setLayout(new GridLayout(3,2,10,10));
			lamina_circulo.add(lamina_top, BorderLayout.NORTH);
			
			lamina_bottom = new JPanel();
			lamina_circulo.add(lamina_bottom, BorderLayout.SOUTH);
			
			campo_radio = new JTextField();
			valor_radio = new JLabel("Ingrese el radio del circulo: ", JLabel.CENTER);
			lamina_top.add(valor_radio);
			lamina_top.add(campo_radio);
			
			salida_circulo = new JTextArea();
			lamina_circulo.add(salida_circulo, BorderLayout.CENTER);
			
			boton_circulo = new JButton("Ver características");
			lamina_bottom.add(boton_circulo);
			
			salir_circulo = new JButton("Salir");
			lamina_bottom.add(salir_circulo);
			
			Mostrar_circulo evento_rescirculo = new Mostrar_circulo();
			boton_circulo.addActionListener(evento_rescirculo);
			
			Cerrar_circulo evento_cerrar = new Cerrar_circulo();
			salir_circulo.addActionListener(evento_cerrar);
			
			marco_circulo.add(lamina_circulo);
			
		}
		
		private class Mostrar_circulo implements ActionListener{
			
			private double radius;
			private String solucion_circulo;
			private Calcular_circulo circulo;
			
			public void actionPerformed(ActionEvent e) {
				
				radius = Double.parseDouble(campo_radio.getText().trim());
				circulo = new Calcular_circulo(radius);
				solucion_circulo = "Area: "+circulo.Area()+
						" m².\nPerímetro: "+circulo.Perimetro()+" m.";
				
				salida_circulo.setText(solucion_circulo);
			}
			
		}
		
		private class Cerrar_circulo implements ActionListener{

			public void actionPerformed(ActionEvent e) {
		        Component component = (Component) e.getSource();
		        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
		        frame.dispose();
		    }
			
			
		}
		
		
		
	}
	
	private class Crear_cuadrado implements ActionListener{
		
		private Marco_figura marco_cuadrado;
		private JTextField campo_lado;
		private JLabel valor_lado;
		private JPanel lamina_cuadrado;
		private JPanel lamina_top;
		private JPanel lamina_bottom;
		private JButton boton_cuadrado;
		private JButton salir_cuadrado;
		private JTextArea salida_cuadrado;
		
		public void actionPerformed(ActionEvent e) {
			
			marco_cuadrado = new Marco_figura();
			marco_cuadrado.setBounds(300,150,550,400);
			marco_cuadrado.setTitle("Cuadrado");
			marco_cuadrado.setVisible(true);
			marco_cuadrado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			lamina_cuadrado = new JPanel();
			lamina_cuadrado.setLayout(new BorderLayout());
			
			lamina_top = new JPanel();
			lamina_top.setLayout(new GridLayout(3,2,10,10));
			lamina_cuadrado.add(lamina_top, BorderLayout.NORTH);
			
			lamina_bottom = new JPanel();
			lamina_cuadrado.add(lamina_bottom, BorderLayout.SOUTH);
			
			campo_lado = new JTextField();
			valor_lado = new JLabel("Ingrese el lado del cuadrado: ", JLabel.CENTER);
			lamina_top.add(valor_lado);
			lamina_top.add(campo_lado);
			
			salida_cuadrado = new JTextArea();
			lamina_cuadrado.add(salida_cuadrado, BorderLayout.CENTER);
			
			boton_cuadrado = new JButton("Ver características");
			lamina_bottom.add(boton_cuadrado);
			
			salir_cuadrado = new JButton("Salir");
			lamina_bottom.add(salir_cuadrado);
			
			Mostrar_cuadrado evento_rescuadrado = new Mostrar_cuadrado();
			boton_cuadrado.addActionListener(evento_rescuadrado);
			
			Cerrar_cuadrado evento_cerrar = new Cerrar_cuadrado();
			salir_cuadrado.addActionListener(evento_cerrar);
			
			marco_cuadrado.add(lamina_cuadrado);
			
		}
		
		private class Mostrar_cuadrado implements ActionListener{
			
			private double side;
			private String solucion_cuadrado;
			private Calcular_cuadrado cuadrado;
			
			public void actionPerformed(ActionEvent e) {
				
				side = Double.parseDouble(campo_lado.getText().trim());
				cuadrado = new Calcular_cuadrado(side);
				solucion_cuadrado = "Area: "+cuadrado.Area()+
						" m².\nPerímetro: "+cuadrado.Perimetro()+" m.";
				
				salida_cuadrado.setText(solucion_cuadrado);
			}
			
		}
		
		private class Cerrar_cuadrado implements ActionListener{

			public void actionPerformed(ActionEvent e) {
		        Component component = (Component) e.getSource();
		        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
		        frame.dispose();
		    }
			
			
		}
		
		
		
	}
	
	private class Crear_triangulo implements ActionListener{
		
		private Marco_figura marco_triangulo;
		private JTextField campo_base;
		private JTextField campo_altura;
		private JLabel valor_base;
		private JLabel valor_altura;
		private JPanel lamina_triangulo;
		private JPanel lamina_top;
		private JPanel lamina_bottom;
		private JButton boton_triangulo;
		private JButton salir_triangulo;
		private JTextArea salida_triangulo;
		
		public void actionPerformed(ActionEvent e) {
			
			marco_triangulo = new Marco_figura();
			marco_triangulo.setBounds(300,150,550,400);
			marco_triangulo.setTitle("Triangulo");
			marco_triangulo.setVisible(true);
			marco_triangulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			lamina_triangulo = new JPanel();
			lamina_triangulo.setLayout(new BorderLayout());
			
			lamina_top = new JPanel();
			lamina_top.setLayout(new GridLayout(3,2,10,10));
			lamina_triangulo.add(lamina_top, BorderLayout.NORTH);
			
			lamina_bottom = new JPanel();
			lamina_triangulo.add(lamina_bottom, BorderLayout.SOUTH);
			
			campo_base = new JTextField();
			valor_base = new JLabel("Ingrese la base del triangulo: ", JLabel.CENTER);
			lamina_top.add(valor_base);
			lamina_top.add(campo_base);
			
			campo_altura = new JTextField();
			valor_altura = new JLabel("Ingrese la altura del triangulo: ", JLabel.CENTER);
			lamina_top.add(valor_altura);
			lamina_top.add(campo_altura);
			
			salida_triangulo = new JTextArea();
			lamina_triangulo.add(salida_triangulo, BorderLayout.CENTER);
			
			boton_triangulo = new JButton("Ver características");
			lamina_bottom.add(boton_triangulo);
			
			salir_triangulo = new JButton("Salir");
			lamina_bottom.add(salir_triangulo);
			
			Mostrar_triangulo evento_restriangulo = new Mostrar_triangulo();
			boton_triangulo.addActionListener(evento_restriangulo);
			
			Cerrar_triangulo evento_cerrar = new Cerrar_triangulo();
			salir_triangulo.addActionListener(evento_cerrar);
			
			marco_triangulo.add(lamina_triangulo);
			
		}
		
		private class Mostrar_triangulo implements ActionListener{
			
			private double baset;
			private double height;
			private String solucion_triangulo;
			private Calcular_triangulo triangulo;
			
			public void actionPerformed(ActionEvent e) {
				
				baset = Double.parseDouble(campo_base.getText().trim());
				height = Double.parseDouble(campo_altura.getText().trim());
				
				triangulo = new Calcular_triangulo(baset,height);
				
				solucion_triangulo = "Area: "+triangulo.Area()+
						" m².\nPerímetro: "+triangulo.Perimetro()+
						" m.\nHipotenusa: "+triangulo.Hipotenusa()+
						" m.\nTipo de triangulo: "+triangulo.TipoTriangulo();
				
				salida_triangulo.setText(solucion_triangulo);
			}
			
		}
		
		private class Cerrar_triangulo implements ActionListener{

			public void actionPerformed(ActionEvent e) {
		        Component component = (Component) e.getSource();
		        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
		        frame.dispose();
		    }
			
			
		}
		
		
		
	}
	
	private class Crear_rectangulo implements ActionListener{
		
		private Marco_figura marco_rectangulo;
		private JTextField campo_base;
		private JTextField campo_altura;
		private JLabel valor_base;
		private JLabel valor_altura;
		private JPanel lamina_rectangulo;
		private JPanel lamina_top;
		private JPanel lamina_bottom;
		private JButton boton_rectangulo;
		private JButton salir_rectangulo;
		private JTextArea salida_rectangulo;
		
		public void actionPerformed(ActionEvent e) {
			
			marco_rectangulo = new Marco_figura();
			marco_rectangulo.setBounds(300,150,550,400);
			marco_rectangulo.setTitle("Rectángulo");
			marco_rectangulo.setVisible(true);
			marco_rectangulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			lamina_rectangulo = new JPanel();
			lamina_rectangulo.setLayout(new BorderLayout());
			
			lamina_top = new JPanel();
			lamina_top.setLayout(new GridLayout(3,2,10,10));
			lamina_rectangulo.add(lamina_top, BorderLayout.NORTH);
			
			lamina_bottom = new JPanel();
			lamina_rectangulo.add(lamina_bottom, BorderLayout.SOUTH);
			
			campo_base = new JTextField();
			valor_base = new JLabel("Ingrese la base del rectangulo: ", JLabel.CENTER);
			lamina_top.add(valor_base);
			lamina_top.add(campo_base);
			
			campo_altura = new JTextField();
			valor_altura = new JLabel("Ingrese la altura del rectangulo: ", JLabel.CENTER);
			lamina_top.add(valor_altura);
			lamina_top.add(campo_altura);
			
			salida_rectangulo = new JTextArea();
			lamina_rectangulo.add(salida_rectangulo, BorderLayout.CENTER);
			
			boton_rectangulo = new JButton("Ver características");
			lamina_bottom.add(boton_rectangulo);
			
			salir_rectangulo = new JButton("Salir");
			lamina_bottom.add(salir_rectangulo);
			
			Mostrar_rectangulo evento_resrectangulo = new Mostrar_rectangulo();
			boton_rectangulo.addActionListener(evento_resrectangulo);
			
			Cerrar_rectangulo evento_cerrar = new Cerrar_rectangulo();
			salir_rectangulo.addActionListener(evento_cerrar);
			
			marco_rectangulo.add(lamina_rectangulo);
			
		}
		
		private class Mostrar_rectangulo implements ActionListener{
			
			private double baset;
			private double height;
			private String solucion_rectangulo;
			private Calcular_rectangulo rectangulo;
			
			public void actionPerformed(ActionEvent e) {
				
				baset = Double.parseDouble(campo_base.getText().trim());
				height = Double.parseDouble(campo_altura.getText().trim());
				
				rectangulo = new Calcular_rectangulo(baset,height);
				
				solucion_rectangulo = "Area: "+rectangulo.Area()+
						" m².\nPerímetro: "+rectangulo.Perimetro()+" m.";
				
				salida_rectangulo.setText(solucion_rectangulo);
			}
			
		}
		
		private class Cerrar_rectangulo implements ActionListener{

			public void actionPerformed(ActionEvent e) {
		        Component component = (Component) e.getSource();
		        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
		        frame.dispose();
		    }
			
			
		}
		
		
		
	}

}
