package ee.sten.kontrolltoo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pood {
    @Id
    private int id;
    private String nimetus;
    private Time avamiseAeg;
    private Time sulgemiseAeg;
    private int kulastanuteArv;
}
