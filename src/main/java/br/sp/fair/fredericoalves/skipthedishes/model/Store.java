package br.sp.fair.fredericoalves.skipthedishes.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Store Entity Model
 *
 * @author frederico.alves
 *
 */
@Entity
@Table(name = "store")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Model {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 7865138127303888694L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String address;

	@JsonIgnore
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> items;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//private Set<Order> order;

}
