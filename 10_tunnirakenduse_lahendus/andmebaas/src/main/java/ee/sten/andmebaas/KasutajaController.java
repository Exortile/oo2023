package ee.sten.andmebaas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KasutajaController {
    @Autowired
    KasutajaRepository kasutajaRepository;

    @GetMapping("kasutajad")
    public List<Kasutaja> getKasutajad() {
        return kasutajaRepository.findAll();
    }

    // http://localhost:8080/lisa-kasutaja?id=1&name=Ville&email=ville@hotmail.com&username=ville231&password=villeparool&permission=Tavakasutaja
    @GetMapping("lisa-kasutaja")
    public List<Kasutaja> addKasutaja(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String permission
    ) {
        kasutajaRepository.save(new Kasutaja(id, name, email, username, password, permission));

        return kasutajaRepository.findAll();
    }

    @GetMapping("muuda-oigus")
    public String changePermission(
            @RequestParam int id,
            @RequestParam String permission
    ) {
        Kasutaja kasutaja = kasutajaRepository.findById(id).get();
        kasutaja.setPermission(permission);
        kasutajaRepository.save(kasutaja);
        return "Õigus muudetud!";
    }
}
