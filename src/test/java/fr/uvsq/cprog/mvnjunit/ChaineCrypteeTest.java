package fr.uvsq.cprog.mvnjunit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ChaineCrypteeTest {

    @Test
    public void testCrypteDecrypte() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("BONJOUR", 3);
        assertEquals("ERQMRXU", chaine.crypte());
        assertEquals("BONJOUR", chaine.decrypte());
    }
}
