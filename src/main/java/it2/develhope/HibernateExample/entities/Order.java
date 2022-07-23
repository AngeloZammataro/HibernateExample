package it2.develhope.HibernateExample.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders") // è una parola riservata, è necessario cambiare il nome
public class Order extends BaseEntityData{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime checkoutDate;

    @ManyToOne(fetch = FetchType.LAZY)
    //@Column(nullable = false)
    private User user;

    @ManyToMany
    private List<Product> products;
}
