package com.bootcamp.library.model;
import jakarta.persistence.*;
@Entity
@Table(name = "cities")
public class City {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
	    private Country country;
}
