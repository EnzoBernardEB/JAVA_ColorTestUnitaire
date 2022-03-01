package tp.colorJavaTest.modele;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    private Color color;

    @BeforeEach
    public void setUp()  {
        color = new Color(213, 141,53);
    }

    @Test
    public void colorCréeAvecTroisArgument() {
        assertNotNull(new Color(213, 141,53),"Instance pas crée");
    }

    @Test
    public void constructeurInvalideLeveIllegalArgumentExceptionPourRouge() {
        assertThrows(IllegalArgumentException.class,() -> new Color(2133, 141,53));
    }
    @Test
    public void constructeurInvalideLeveIllegalArgumentExceptionPourVert() {
        assertThrows(IllegalArgumentException.class, () -> new Color(213, 1411,53));
    }
    @Test
    public void constructeurInvalideLeveIllegalArgumentExceptionPourBleu() {
        assertThrows(IllegalArgumentException.class, () -> new Color(213, 141,533));
    }

    @Test
    public void colorCréeAvecUnArgument() {
        assertNotNull(new Color("#D58D35"),"Instance pas crée");
    }

    @Test
    public void constructeurUnArgumentHexadecimalLeveIllegalArgumentExceptionSiCommencePasParDiese(){
        assertThrows(IllegalArgumentException.class, () -> new Color("DD58D35"));
    }

    @Test
    public void constructeurUnArgumentHexadecimalLeveIllegalArgumentExceptionSiCommenceParDieseMaisSuperieurA7(){
        assertThrows(IllegalArgumentException.class, () -> new Color("#D58D352"));
    }

    @Test
    public void constructeurUnArgumentHexadecimalLeveIllegalArgumentExceptionSiFormatHexaPasValideLettreSupF(){
        assertThrows(IllegalArgumentException.class, () -> new Color("#Z58D35"));
    }

    @Test
    public void constructeurUnArgumentHexadecimalLeveIllegalArgumentExceptionSiFormatHexaPasValideLettreMinucscule(){
        assertThrows(IllegalArgumentException.class, () -> new Color("#d58D35"));
    }

    @Test
    public void getRGB() {
        assertEquals(213,color.getRed(),"Parametre rouge invalide");
        assertEquals(141,color.getGreen(),"Parametre vert invalide");
        assertEquals(53,color.getBlue(),"Parametre blue invalide");
    }


    @Test
    public void testSetRed() {
        color.setRed(155);
        assertEquals(155,color.getRed());
        assertEquals(141,color.getGreen());
        assertEquals(53,color.getBlue());
    }

    @Test
    public void testSetGreen() {
        color.setGreen(155);
        assertEquals(155,color.getGreen());
        assertEquals(213,color.getRed());
        assertEquals(53,color.getBlue());
    }

    @Test
    public void testSetBlue() {
        color.setBlue(0);
        assertEquals(0,color.getBlue());
        assertEquals(213,color.getRed());
        assertEquals(53,color.getGreen());
    }

    @Test
    public void testGetHex() {
        assertEquals("#D58D35", color.getHexValue());
        assertEquals(213,color.getRed());
        assertEquals(141,color.getGreen());
        assertEquals(53,color.getBlue());
    }

    @Test
    public void testSetHexLeveIllegalArgumentExceptionSiParametreInvalide() {
        Color colorHex = new Color("#D58D35");
        assertThrows(IllegalArgumentException.class, () -> colorHex.setHexValue("#Z58D35"));
    }

    @Test
    public void testSetRedLeveIllegalArgumentExceptionSiParametreRougeInvalide() {
        assertThrows(IllegalArgumentException.class,() -> color.setRed(1565));
    }
    @Test
    public void testSetRedLeveIllegalArgumentExceptionSiParametreVertInvalide() {
        assertThrows(IllegalArgumentException.class,() -> color.setGreen(1565));
    }
    @Test
    public void testSetRedLeveIllegalArgumentExceptionSiParametreBleuInvalide() {
        assertThrows(IllegalArgumentException.class,() -> color.setBlue(1565));
    }

    @Test
    public void testToStringValideAvecColorInstancie() {
        assertEquals("[value=#D58D35, r=213, g=141, b=53]",color.toString());
    }



    @AfterEach
    public void tearDown() {
        color = null;
    }
}