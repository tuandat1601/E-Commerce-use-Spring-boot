package com.bootcamp.library.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "image"}))
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
    private long id;
	private String name;
    private String description;
    private int currentQuantity;
    private double costPrice;
    private double salePrice;
    
    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] image;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    private boolean is_activated;
    private boolean is_deleted;
}
