package it2.develhope.HibernateExample.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity // obbligatorio
@Table // obbligatorio
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntityData{

    @Id //annotiamo con Id per generarlo in automatico, anche questo è obbligatorio
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    //assegno la chiave UNIQUE e rinomino email in userEmail.
    //hibernate trasforma userEmail(camelCase) in user_email(snake_case) in sql non c'è il case-sensitive
    //possiamo dare anche la lunghezza al VARCHAR in tabella
    @Column(unique = true, name = "userEmail", length = 100)
    private String email;
    //devo usare le wrapper class se voglio che un int come age possa essere nullable in tabella
    //private int age;
    private Integer age;
    private String city;
    private String placeOfBirth;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders;
}
// create = crea db(si usa generalmente in fase di sviluppo)
// create-drop,
// create-only,
// drop,
// update = aggiorna il database(non posso inserire colonne nuove, pena errore)
// none,
// validate
