package fig_geometricas_gi;

public class Calcular_cuadrado {
		
		private double lado;
		
		Calcular_cuadrado(double lado){
			this.lado = lado;
		}
		
		public double Area(){
			return lado*lado;
		}
		
		public double Perimetro() {
			return 4*lado;
		}

}
