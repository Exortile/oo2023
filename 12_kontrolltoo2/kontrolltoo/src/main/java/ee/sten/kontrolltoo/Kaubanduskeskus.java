package ee.sten.kontrolltoo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
}
