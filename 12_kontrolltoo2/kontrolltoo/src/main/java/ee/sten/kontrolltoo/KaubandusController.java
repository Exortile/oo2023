package ee.sten.kontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
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

        kaubanduskeskusRepository.save(new Kaubanduskeskus(id, nimetus, koikPoed, new HashMap<>()));
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

    // http://localhost:8080/kaubanduskeskus-kulasta-tund?id=1&tund=15
    @GetMapping("kaubanduskeskus-kulasta-tund")
    public String kulastaKaubanduskeskustTunnil(
            @RequestParam int id,
            @RequestParam int tund
    ) {
        Kaubanduskeskus kaubanduskeskus = kaubanduskeskusRepository.findById(id).get();
        if (kaubanduskeskus.getKulastatudTunnid().containsKey(tund)) {
            int kulastatud = kaubanduskeskus.getKulastatudTunnid().get(tund);
            kaubanduskeskus.getKulastatudTunnid().replace(tund, kulastatud + 1);
        } else {
            kaubanduskeskus.getKulastatudTunnid().put(tund, 1);
        }

        kaubanduskeskusRepository.save(kaubanduskeskus);

        return "Külastasite kaubanduskeskust!";
    }

    // http://localhost:8080/kaubanduskeskust-kulastanud?id=1&tund=17
    @GetMapping("kaubanduskeskust-kulastanud")
    public int getKaubanduskeskustKulastanudTunnil(
            @RequestParam int id,
            @RequestParam int tund
    ) {
        Kaubanduskeskus kaubanduskeskus = kaubanduskeskusRepository.findById(id).get();
        return kaubanduskeskus.getKulastatudTunnid().getOrDefault(tund, 0);
    }


    // http://localhost:8080/kaubanduskeskus-koige-kulastatum/16
    @GetMapping("kaubanduskeskus-koige-kulastatum/{tund}")
    public Kaubanduskeskus getKulastatumKaubanduskeskus(@PathVariable int tund) {
        var kaubanduskeskused = kaubanduskeskusRepository.findAll();
        Kaubanduskeskus koigeKulastatum = kaubanduskeskused.get(0);

        for (Kaubanduskeskus k:
             kaubanduskeskused) {
            int kulastatudArv = k.getKulastatudTunnid().getOrDefault(tund, 0);
            if (kulastatudArv > koigeKulastatum.getKulastatudTunnid().getOrDefault(tund, 0)) {
                koigeKulastatum = k;
            }
        }

        return koigeKulastatum;
    }
}
