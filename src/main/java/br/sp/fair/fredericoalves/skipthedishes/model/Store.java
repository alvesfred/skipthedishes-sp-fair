package br.sp.fair.fredericoalves.skipthedishes.model;

import java.util.List;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Store Entity Model
 *
 * @author frederico.alves
 *
 */
@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Store implements LongModel {

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
	//@JsonSerialize(using = ProductIdSerializer.class)
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> items;

}
