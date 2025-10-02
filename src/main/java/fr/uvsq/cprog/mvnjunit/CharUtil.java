package fr.uvsq.cprog.mvnjunit;

public class CharUtil {
    public static char decaleCaractere(char c, int decalage) {
        return (c < 'A' || c > 'Z') ? c : (char) (((c - 'A' + decalage + 26) % 26) + 'A');
    }
}
