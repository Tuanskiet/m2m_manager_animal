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
@Table(name="species_animal")
public class SpeciesAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "[name]")
    private String name;

    @Column(name = "description", length = 4096)
    private String description;

    @Column(name = "distribution")
    private String distribution ;

    @Column(name = "raiting", length = 45)
    private String raiTing ;

    @Column(name = "value", columnDefinition = "TEXT")
    private String value ;

    @Column(name = "biology_ecology", columnDefinition = "TEXT")
    private String biologyEcology ;

    @Column(name = "[status]")
    private String status;

    @Column(name = "protective", columnDefinition = "TEXT")
    private String protective;

    @Column(name = "[document]", columnDefinition = "TEXT")
    private String document;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "family_id", referencedColumnName = "id")
    private FamilyAnimal familyAnimal;
}