package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;

	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
	}


	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
				"Un nouvel enseignant doit avoir 0 heures prévues");
	}

	@Test
	public void testAjouteHeuresTD() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

		// 20h TD pour UML
		untel.ajouteEnseignement(uml, 0, 20, 0);

		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

	}

	@Test
	public void testAjouteHeuresTP() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 0, 10);

		assertEquals(Math.round(10 * 0.75), untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 7,5 heures prévues pour l'UE 'uml'");

		// 20h TD pour UML
		untel.ajouteEnseignement(uml, 0, 0, 20);

		assertEquals(Math.round(10 * 0.75 + 20 * 0.75), untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 22,5 heures prévues pour l'UE 'uml'");

	}

	@Test
	public void testAjouteHeuresCM() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 10, 0, 0);

		assertEquals(10 * 1.5, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 15 heures prévues pour l'UE 'uml'");

		// 20h TD pour UML
		untel.ajouteEnseignement(uml, 20, 0, 0);

		assertEquals(10 * 1.5 + 20 * 1.5, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 45 heures prévues pour l'UE 'uml'");

	}

	@Test
	public void testSousEffectif() {
		untel.ajouteEnseignement(uml, 0, 12, 0);
		assertEquals(true, untel.estEnSousEffectif(),
				"L'enseignant est en sous effectif car il a moins de 192 (heures équivalentes TD) a effectué");
		untel.ajouteEnseignement(uml, 0, 200, 0);
		assertEquals(false, untel.estEnSousEffectif(),
				"L'enseignant n'est pas en sous effectif car il a plus de 192 (heures équivalentes TD) a effectué");
		untel.ajouteEnseignement(uml, 0, 192, 0);
		assertEquals(false, untel.estEnSousEffectif(),
				"L'enseignant n'est pas en sous effectif car il a 192 (heures équivalentes TD) a effectué");
	}

	@Test
	public void testHeuresPrévues() {
		untel.ajouteEnseignement(uml, 10, 12, 5);
		untel.ajouteEnseignement(java, 5, 12, 10);
		assertEquals(Math.round((10+5) * 1.5 + 12 + 12 + (5+10) * 0.75 ), untel.heuresPrevues(),
				"L'enseignant doit avoir 58 heures de prévues");
	}
}
