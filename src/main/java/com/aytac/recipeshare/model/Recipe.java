package com.aytac.recipeshare.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.tuple.GenerationTiming;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
@Data
public class Recipe {

    //image data, byte[] imageData etc.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;

    @CurrentTimestamp(timing = GenerationTiming.INSERT) //on create
    LocalDateTime createTime;
    @CurrentTimestamp(timing = GenerationTiming.ALWAYS) // on update
    LocalDateTime updateTime;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    User user;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //cascade type?
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //cascade type?
    private List<Rate> rates = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns =
            @JoinColumn(name = "ingredient_id"))
    List<Ingredient> ingredients = new ArrayList<>();


}
