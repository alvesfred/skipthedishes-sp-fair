package br.sp.fair.fredericoalves.skipthedishes.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Product Entity Model
 *
 * @author frederico.alves
 *
 */
@Entity
@Table(name = "product")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements LongModel {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -8223185663438021517L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(max = 100)
	private String name;

	@Size(max = 200)
	private String description;

	@NotNull
	@DecimalMin(value = "0.01")
	private BigDecimal price;

	// storeId
	@JsonSerialize(using = StoreIdSerializer.class)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Store store;

}
