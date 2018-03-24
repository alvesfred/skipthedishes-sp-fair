package br.sp.fair.fredericoalves.skipthedishes.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Order Entity Model
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@Entity
@Table(name = "orders")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements LongModel {
    /**
	 * serial
	 */
	private static final long serialVersionUID = 3388988255791406627L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime creation;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime lastUpdate;

	@NotNull
    private String deliveryAddress;

	@NotNull
	private String contact;

	@Transient
	private Double total;

	@NotNull
	private String status; // following challenge but i would like to suggest to use ENUM types

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Customer customer;

	//@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Store store; // Restaurant

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<OrderItem> items;

	public BigDecimal total() {
		return Optional.ofNullable(items).orElse(new HashSet<>()).stream().map(OrderItem::total).reduce(
				BigDecimal.ZERO, BigDecimal::add);
	}    

    @Override
    public String toString() {
        return "Orders { " +
                "id = " + id +
                ", creationDate = " + creation +
                ", status = '"  + status + '\'' +
                ", customer = " + customer +
        '}';
    }
}
