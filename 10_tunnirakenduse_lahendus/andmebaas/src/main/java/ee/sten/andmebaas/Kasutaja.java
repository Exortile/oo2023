package ee.sten.andmebaas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kasutaja {
    @Id
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String permission;
}
