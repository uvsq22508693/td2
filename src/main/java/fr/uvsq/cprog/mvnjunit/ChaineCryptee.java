package fr.uvsq.cprog.mvnjunit;

public class ChaineCryptee {
    private String chaineCryptee;
    private int decalage;

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
        return chaineCryptee;
    }

    public static void main(String[] args) {
        ChaineCryptee chaine1 = ChaineCryptee.deEnClair("BONJOUR", 3);
        System.out.println("Texte clair: BONJOUR");
        System.out.println("Crypté: " + chaine1.crypte());
        System.out.println("Décrypté: " + chaine1.decrypte());

        System.out.println();
    }
}