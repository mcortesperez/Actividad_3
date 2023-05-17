package fig_geometricas_gi;

public class Calcular_circulo {
		
		private double radio;
		
		Calcular_circulo(double radio){
			this.radio = radio;
		}
		
		public double Area() {
			return Math.PI*Math.pow(radio, 2);
		}
		public double Perimetro() {
			return 2*Math.PI*radio;
		}

}
