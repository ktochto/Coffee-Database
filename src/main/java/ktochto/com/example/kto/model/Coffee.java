package ktochto.com.example.kto.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sort;
    private String country;
    private String descriptions;

}
