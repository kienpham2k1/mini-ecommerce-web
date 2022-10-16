package com.springboot.miniecommercewebapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "tblCategories", schema = "dbo", catalog = "MiniEcommerce")
public class Categories {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "catagoryID", nullable = false)
    private int catagoryId;
    @Basic
    @Column(name = "catagoryName", nullable = false, length = 100)
    private String catagoryName;
    @OneToMany(mappedBy = "tblCategoriesByCatagoryId")
    @JsonIgnore
    private Collection<Product> tblProductsByCatagoryId;
}