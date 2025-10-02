package fr.uvsq.cprog.mvnjunit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ChaineCrypteeTest {

    @Test
    public void testChiffrementDecalageNegatif() {
        ChaineCryptee c = ChaineCryptee.deEnClair("BONJOUR", -3);
        assertEquals("YLKGLRO", c.crypte());
    }

    @Test
    public void testDechiffrementDecalageNegatif() {
        ChaineCryptee c = ChaineCryptee.deEnClair("YLKGLRO", -3);
        assertEquals("BONJOUR", c.decrypte());
    }

    @Test
    public void testMajusculesEtEspaces() {
        ChaineCryptee c = ChaineCryptee.deEnClair("HELLO WORLD", 5);
        assertEquals("MJQQT BTWQI", c.crypte());
    }

    @Test
    public void testCaracteresNonAlphabetiques() {
        ChaineCryptee c = ChaineCryptee.deEnClair("BONJOUR123!@#", 3);
        assertEquals("ERQMRXU123!@#", c.crypte());
    }

    @Test
    public void testChaineVide() {
        ChaineCryptee c = ChaineCryptee.deEnClair("", 3);
        assertEquals("", c.crypte());
    }

    @Test
    public void testDecalageSuperieur26() {
        ChaineCryptee c = ChaineCryptee.deEnClair("BONJOUR", 29); // 29 % 26 = 3
        assertEquals("ERQMRXU", c.crypte());
    }
}
