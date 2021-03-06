package br.sp.fair.fredericoalves.skipthedishes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Customer Entity Model
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@Entity
@Table(name = "customer")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer implements LongModel {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -5297305315360692784L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String address;
	
	@NotEmpty
	private String email;

	@NotEmpty
	private String password;
	
	//@Convert(converter = LocalDateConverter.class)
	@NotEmpty
	private Date creation;

	// Avoiding orders "many" mapping references
	//@JsonIgnore
	//@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//private Set<Order> orders;

}
