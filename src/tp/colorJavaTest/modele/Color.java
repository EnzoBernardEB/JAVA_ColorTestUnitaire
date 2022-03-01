package tp.colorJavaTest.modele;

public class Color {
    private int rouge;
    private int vert;
    private int bleu;
    private String codeHexa;


    public Color(int rouge, int vert, int bleu) {
        if ((rouge < 0 || rouge > 255) || (vert < 0 || vert > 255) || (bleu < 0 || bleu > 255) ) {
            throw new IllegalArgumentException();
        } else {
            this.rouge = rouge;
            this.vert = vert;
            this.bleu = bleu;
            this.codeHexa = String.format("#%02X%02X%02X", this.rouge, this.vert, this.bleu);
        }
    }

    public Color(String codeHexa) {
        if ( codeHexa != null && codeHexa.length() > 0 && codeHexa.length() == 7 && codeHexa.startsWith("#") && this.verifieFormatHexa(codeHexa)) {
            this.codeHexa = codeHexa;
            this.rouge = java.awt.Color.decode(this.codeHexa).getRed();
            this.vert = java.awt.Color.decode(this.codeHexa).getGreen();
            this.bleu = java.awt.Color.decode(this.codeHexa).getBlue();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getRed() {
        return this.rouge;
    }

    public int getGreen() {
        return this.vert;
    }

    public int getBlue() {
        return this.bleu;
    }

    public String getHexValue() {
        return this.codeHexa;
    }

    public void setRed(int rouge) {
        if ((rouge < 0 || rouge > 255)) {
            throw new IllegalArgumentException();
        } else {
            this.rouge = rouge;
            String nouveauCodeHexa = String.format("#%02X%02X%02X", rouge, this.vert, this.bleu);
            this.setHexValue(nouveauCodeHexa);
        }
    }

    public void setGreen(int vert) {
        if ((vert < 0 || vert > 255)) {
            throw new IllegalArgumentException();
        } else {
            this.vert = vert;
            String nouveauCodeHexa = String.format("#%02X%02X%02X", this.rouge, vert, this.bleu);
            this.setHexValue(nouveauCodeHexa);
        }
    }

    public void setBlue(int bleu) {
        if ((bleu < 0 || bleu > 255)) {
            throw new IllegalArgumentException();
        } else {
            this.bleu = bleu;
            String nouveauCodeHexa = String.format("#%02X%02X%02X", this.rouge, this.vert, bleu);
            this.setHexValue(nouveauCodeHexa);
        }
    }

    public void setHexValue (String codeHexa) {
        if ( codeHexa != null && codeHexa.length() > 0 && codeHexa.length() == 7 && codeHexa.startsWith("#") && this.verifieFormatHexa(codeHexa)) {
            this.codeHexa = codeHexa;
            this.rouge = java.awt.Color.decode(codeHexa).getRed();
            this.vert = java.awt.Color.decode(codeHexa).getGreen();
            this.bleu = java.awt.Color.decode(codeHexa).getBlue();
        } else {
            throw new IllegalArgumentException();
        }
    }



    @Override
    public String toString() {

        return "[value="+this.getHexValue()+", r="+this.getRed()+", g="+this.getGreen()+", b="+this.getBlue()+"]";
    }

    private static boolean verifieFormatHexa(String s) {
        // Size of string
        int n = s.length() - 1;
        String chaineSansDiese = s.substring(1);

        // Iterate over string
        for (int i = 0; i < n; i++) {

            char ch = chaineSansDiese.charAt(i);

            if ((ch < '0' || ch > '9')
                    && (ch < 'A' || ch > 'F')) {

                return false;
            }
        }
        return true;
    }


}

