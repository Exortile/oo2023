package ee.sten.primitiivid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToodeController {
    Toode toode = new Toode(1,"Koola", 1.5, true);

    @GetMapping("toode")
    public Toode saaToode() {
        return toode;
    }

    @GetMapping("kustuta-toode1")
    public void kustutaToode1() {
        toode = null;
    }

    @GetMapping("kustuta-toode2")
    public String kustutaToode2() {
        toode = null;
        return "Edukalt kustutatud!";
    }

    @GetMapping("suurenda-hinda")
    public Toode suurendaHinda() {
        toode.setHind( toode.getHind()+1 );
        return toode;
    }

    @GetMapping("muuda-aktiivsus")
    public Toode muudaAktiivsus() {
        toode.setAktiivne(!toode.isAktiivne());
        return toode;
    }

    @GetMapping("muuda-nimi/{nimi}")
    public Toode muudaNimi(@PathVariable String nimi) {
        toode.setNimi(nimi);
        return toode;
    }
}
