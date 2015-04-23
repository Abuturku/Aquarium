
public class AquariumManager {

	public static void main(String[] args) {
		//Ausgabe leeres Aquarium testen -> übergabe Konstruktor parameter
		Aquarium aqua = new Aquarium (30,7);
		aqua.printAquarium();
		
		//Ausgabe volles Aquarium testen -> "--"
		aqua.seaworlds();
		
		
		
		
		//Scan: einlesen übergabewerte
		//	unzulässige Eingaben prüfen -> fehlerbehandlung (try/catch / if)
	}

}
