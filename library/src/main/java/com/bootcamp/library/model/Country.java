package com.bootcamp.library.model;
import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "country_id")
	    private Long id;
	    private String name;
}
