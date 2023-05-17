package fig_geometricas_gi;

import javax.swing.*;

public class Figura {

	public static void main(String[] args) {
		
		Marco_figura marco = new Marco_figura();
		Lamina lamina_figuras = new Lamina();
		marco.add(lamina_figuras);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
