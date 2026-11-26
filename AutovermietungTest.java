import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AutovermietungTest {

    @Test
    void sucheFindetAutoTrotzKleinschreibungUndLeerzeichen() {
        Autovermietung vermietung = new Autovermietung();
        Auto auto = new Auto("ZH 123456", 5, false, "rot", 180);
        vermietung.fahrzeugHinzufuegen(auto);
        Fahrzeug gefunden = vermietung.sucheNachKennzeichen(" zh 123456 ");
        assertEquals(auto, gefunden);
    }

    @Test
    void sucheGibtNullBeiUnbekanntemKennzeichen() {
        Autovermietung vermietung = new Autovermietung();
        vermietung.fahrzeugHinzufuegen(new Auto("ZH 123456", 5, false, "rot", 180));
        Fahrzeug gefunden = vermietung.sucheNachKennzeichen("XX 000");
        assertNull(gefunden);
    }
    @Test
    void mietpreisAutoMitFuenfSitzplaetzenIst55() {
        Auto auto = new Auto("ZH 123456", 5, false, "rot", 180);
        assertEquals(55.0, auto.berechneMietPreisProTag(), 0.001);
    }

    @Test
    void versicherungsPraemieMotorradMitZweiSitzplaetzenIst200Komma10() {
        Motorrad motorrad = new Motorrad("LU 4321", 2, false, "schwarz", 220);
        assertEquals(200.10, motorrad.berechneVersicherungsPrämie(), 0.001);
    }
}