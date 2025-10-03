package fr.uvsq.cprog.mvnjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChaineCryptee {
    private String chaineCryptee;
    private int decalage;

    private static final Logger Logger = LoggerFactory.getLogger(ChaineCryptee.class);

    private ChaineCryptee(String chaineCryptee, int decalage) {
        this.chaineCryptee = chaineCryptee;
        this.decalage = decalage;
    }

    public static ChaineCryptee deEnClair(String chaineClaire, int decalage) {
        if (chaineClaire == null) {
            return new ChaineCryptee(null, decalage);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chaineClaire.toCharArray()) {
            sb.append(CharUtil.decaleCaractere(c, decalage));
        }
        return new ChaineCryptee(sb.toString(), decalage);
    }

    public static ChaineCryptee deCryptee(String chaineCryptee, int decalage) {
        return new ChaineCryptee(chaineCryptee, decalage);
    }

    public String getChaineCryptee() {
        return chaineCryptee;
    }

    public int getDecalage() {
        return decalage;
    }

    public String decrypte() {
        if (chaineCryptee == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chaineCryptee.toCharArray()) {
            sb.append(CharUtil.decaleCaractere(c, -decalage));
        }
        return sb.toString();
    }

    public String crypte() {
        if (chaineCryptee == null) {
            return null;
        }
        return chaineCryptee;
    }

    public static void main(String[] args) {
        ChaineCryptee chaine1 = ChaineCryptee.deEnClair("BONJOUR", 3);
        System.out.println("Texte clair: BONJOUR");
        System.out.println("Crypté: " + chaine1.crypte());
        System.out.println("Décrypté: " + chaine1.decrypte());

        System.out.println();
        // logger.info("Texte clair: BONJOUR");
        // logger.info("Crypté: {}", chaine1.crypte());
        // logger.info("Décrypté: {}", chaine1.decrypte());
    }
}