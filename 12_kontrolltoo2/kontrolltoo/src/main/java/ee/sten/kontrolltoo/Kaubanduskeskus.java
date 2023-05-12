package ee.sten.kontrolltoo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kaubanduskeskus {
    @Id
    private int id;

    private String nimetus;

    @ManyToMany
    private List<Pood> poed;

    @ElementCollection
    @MapKeyColumn(name="tund")
    @Column(name="kulastusarv")
    @CollectionTable(name="kaubanduskeskus_kulastused", joinColumns=@JoinColumn(name="kaubanduskeskus_id"))
    private Map<Integer, Integer> kulastatudTunnid;
}
