package ee.sten.kontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
public class PoodController {
    @Autowired
    PoodRepository poodRepository;

    @GetMapping("poed")
    public List<Pood> getPoed() {
        return poodRepository.findAll();
    }

    // http://localhost:8080/lisa-pood?id=1&nimetus=Selver&avamiseAeg=09:00:00&sulgemiseAeg=21:00:00
    @GetMapping("lisa-pood")
    public List<Pood> lisaPood(
            @RequestParam int id,
            @RequestParam String nimetus,
            @RequestParam String avamiseAeg,
            @RequestParam String sulgemiseAeg
    ) {
        Time avamiseAegTime = Time.valueOf(avamiseAeg);
        Time sulgemiseAegTime = Time.valueOf(sulgemiseAeg);

        poodRepository.save(new Pood(id, nimetus, avamiseAegTime, sulgemiseAegTime, 0));
        return poodRepository.findAll();
    }

    // http://localhost:8080/uuri-kellaaeg?id=1&kellaaeg=20:00:00
    @GetMapping("uuri-kellaaeg")
    public String uuriKellaaeg(
            @RequestParam int id,
            @RequestParam String kellaaeg
    ) {
        Pood pood = poodRepository.findById(id).get();
        Time avamiseAeg = pood.getAvamiseAeg();
        Time sulgemiseAeg = pood.getSulgemiseAeg();
        Time kellaaegTime = Time.valueOf(kellaaeg);

        if (kellaaegTime.after(avamiseAeg) && kellaaegTime.before(sulgemiseAeg) || kellaaegTime.compareTo(avamiseAeg) == 0)
        {
            return "Pood on avatud sel kellaajal!";
        }
        return "Pood ei ole avatud sel kellaajal!";
    }

    @GetMapping("kulasta/{id}")
    public String kulasta(@PathVariable int id) {
        Pood pood = poodRepository.findById(id).get();
        pood.setKulastanuteArv(pood.getKulastanuteArv() + 1);
        poodRepository.save(pood);
        return "Külastasite poodi!";
    }
}
