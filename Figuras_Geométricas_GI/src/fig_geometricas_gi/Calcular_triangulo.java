package fig_geometricas_gi;

public class Calcular_triangulo {
	
	private double base;
	private double altura;
	
	Calcular_triangulo(double base, double altura){
		this.base = base;
		this.altura = altura;
	}
	
	public double Area() {
		return (base*altura)/2;
	}
	public double Hipotenusa() {
		return (float)Math.sqrt(Math.pow(base, 2)+Math.pow(altura, 2));
	}
	public double Perimetro() {
		return base + altura + Hipotenusa();
	}
	public String TipoTriangulo() {
		if (base == altura) {
			return "isóceles";
		}else {
			return "escaleno";
		}
	/* Note que para que el ejercicio tenga sentido debe ser construido un triángulo
	 * rectángulo, un triángulo rectángulo no podrá ser equilátero bajo ninguna 
	 * circunstancia, la hipotenusa no podrá ser igual a ninguno de los catetos. Por
	 * lo tanto, sólo existe la posibilidad de ser isóceles(base = altura) o escaleno.
	 */
	}

}
