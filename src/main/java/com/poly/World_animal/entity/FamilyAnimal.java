package com.poly.World_animal.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="family_animal")
public class FamilyAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "[name]")
    private String name;

    @Column(name = "description", length = 4096)
    private String description;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderAnimal orderAnimal;
}
