package it2.develhope.HibernateExample.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products") // posso rinominare la tabella, posso anche scrivere solo table in questo caso
public class Product extends BaseEntityData{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private Double height;
    private Double width;
    private Double lenght;

}
