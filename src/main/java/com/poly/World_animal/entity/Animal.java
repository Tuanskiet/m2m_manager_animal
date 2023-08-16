package com.poly.World_animal.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "[name]")
    private String name;

    @Column(name = "[status]")
    private String status;

    @Column(name = "description", length = 4096)
    private String description;

    @Column(name = "distribution")
    private String distribution ;

    @Column(name = "value", length = 4096)
    private String value ;

    @ManyToOne
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    private SpeciesAnimal speciesAnimal;

}
