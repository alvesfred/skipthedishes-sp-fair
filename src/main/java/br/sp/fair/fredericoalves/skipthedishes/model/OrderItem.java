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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author 
 */
@Entity
@Table(name = "order_items")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderItem implements LongModel {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 6880481962201551254L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@JsonSerialize(using = OrderIdSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Order order;

	@NotNull
	@JsonSerialize(using = ProductIdSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Product product;

	@NotNull
	@DecimalMin(value = "0.1")
	private BigDecimal price; 

	@NotNull
	@DecimalMin(value = "0.1")
	private BigDecimal quantity;

	public BigDecimal total() {
		return quantity.multiply(price);
	}

    @Override
    public String toString() {
        return "OrderItem { " +
                "id = " + id  +
                ", order = "  + order +
        '}';
    }
}
