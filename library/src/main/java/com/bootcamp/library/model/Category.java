package com.bootcamp.library.model;
import jakarta.persistence.*;

@Entity
@Table(name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "category_id")
	    private Long id;
	    private String name;
	    @Column(name = "is_activated")
	    private boolean activated;
	    @Column(name = "is_deleted")
	    private boolean deleted;
}
