package fig_geometricas_gi;

public class Calcular_rectangulo {
	
	private double base;
	private double altura;
	
	Calcular_rectangulo(double base, double altura){
		this.base = base;
		this.altura = altura;
	}
	
	public double Area() {
		return base*altura;
	}
	
	public double Perimetro() {
		return 2*(base+altura);
	}

}
