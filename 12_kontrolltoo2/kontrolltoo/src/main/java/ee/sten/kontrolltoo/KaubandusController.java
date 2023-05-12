package ee.sten.kontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KaubandusController {
    @Autowired
    KaubanduskeskusRepository kaubanduskeskusRepository;

    @Autowired
    PoodRepository poodRepository;

    @GetMapping("kaubanduskeskused")
    public List<Kaubanduskeskus> getKaubanduskeskused() {
        return kaubanduskeskusRepository.findAll();
    }

    // http://localhost:8080/lisa-kaubanduskeskus?id=1&nimetus=Rocca&poed=1,2
    @GetMapping("lisa-kaubanduskeskus")
    public List<Kaubanduskeskus> lisaKaubanduskeskus(
            @RequestParam int id,
            @RequestParam String nimetus,
            @RequestParam int[] poed
    ) {
        List<Pood> koikPoed = new ArrayList<>();
        for (int poodId:
             poed) {
            koikPoed.add(poodRepository.findById(poodId).get());
        }

        kaubanduskeskusRepository.save(new Kaubanduskeskus(id, nimetus, koikPoed));
        return kaubanduskeskusRepository.findAll();
    }

    // http://localhost:8080/kaubanduskeskuse-lahti-poed?id=1&kellaaeg=10:00:00
    @GetMapping("kaubanduskeskuse-lahti-poed")
    public List<Pood> getLahtiOlevadPoed(
            @RequestParam int id,
            @RequestParam String kellaaeg
    ) {
        Kaubanduskeskus kaubanduskeskus = kaubanduskeskusRepository.findById(id).get();
        Time kellaaegTime = Time.valueOf(kellaaeg);
        List<Pood> poed = new ArrayList<>();

        for (Pood pood:
             kaubanduskeskus.getPoed()) {
            Time avamiseAeg = pood.getAvamiseAeg();
            Time sulgemiseAeg = pood.getSulgemiseAeg();

            if (kellaaegTime.after(avamiseAeg) && kellaaegTime.before(sulgemiseAeg) || kellaaegTime.compareTo(avamiseAeg) == 0)
            {
                poed.add(pood);
            }
        }

        return poed;
    }

    // http://localhost:8080/kaubanduskeskus-kulastanud/1
    @GetMapping("kaubanduskeskus-kulastanud/{id}")
    public int getKulastanudArvPoodides(@PathVariable int id) {
        Kaubanduskeskus kaubanduskeskus = kaubanduskeskusRepository.findById(id).get();
        int kulastatud = 0;

        for (Pood pood:
             kaubanduskeskus.getPoed()) {
            kulastatud += pood.getKulastanuteArv();
        }

        return kulastatud;
    }
}
