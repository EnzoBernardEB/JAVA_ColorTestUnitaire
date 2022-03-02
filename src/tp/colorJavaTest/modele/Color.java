package tp.colorJavaTest.modele;

import tp.colorJavaTest.modele.outils.Constante;


public class Color {
    private int rouge;
    private int vert;
    private int bleu;
    private String codeHexa;


    public Color(int rouge, int vert, int bleu) {
            this.setRed(rouge);
            this.setGreen(vert);
            this.setBlue(bleu);
    }

    public Color(String codeHexa) {
        this.setHexValue(codeHexa);
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
        if (verifierParametreValideRGB(rouge)) {
            this.rouge = rouge;
            String nouveauCodeHexa = convertirRGBEnHexa(rouge,this.vert,this.bleu);
            this.setHexValue(nouveauCodeHexa);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setGreen(int vert) {
        if (verifierParametreValideRGB(vert)) {
            this.vert = vert;
            String nouveauCodeHexa = convertirRGBEnHexa(this.rouge,vert,this.bleu);
            this.setHexValue(nouveauCodeHexa);
        } else {
            throw new IllegalArgumentException();

        }
    }

    public void setBlue(int bleu) {
        if (verifierParametreValideRGB(bleu)) {
            this.bleu = bleu;
            String nouveauCodeHexa = convertirRGBEnHexa(this.rouge,this.vert,bleu);
            this.setHexValue(nouveauCodeHexa);
        } else {
            throw new IllegalArgumentException();

        }
    }

    public void setHexValue (String codeHexa) {
        if (codeHexa != null && codeHexa.length() == Constante.TAILLEHEXA && codeHexa.startsWith("#") && verifieFormatHexaValide(codeHexa)) {
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

    private static boolean verifieFormatHexaValide(String s) {
        int n = s.length() - 1;
        String chaineSansDiese = s.substring(1);

        for (int i = 0; i < n; i++) {

            char ch = chaineSansDiese.charAt(i);

            if ((ch < '0' || ch > '9')
                    && (ch < 'A' || ch > 'F')) {

                return false;
            }
        }
        return true;
    }

    private boolean verifierParametreValideRGB(int couleur) {
        if( couleur < Constante.MINRGB ||  couleur > Constante.MAXRGB)
            return false;
        return true;
    }

    private String convertirRGBEnHexa(int rouge, int vert, int bleu) {
        return String.format(Constante.FORMATHEXA, rouge, vert, bleu);
    }
}

