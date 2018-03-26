package br.sp.fair.fredericoalves.skipthedishes.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(of = "id")
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
	@Column(name = "lastUpdate")
	private LocalDateTime lastUpdate;

	@NotNull
	@Column(name = "deliveryAddress")
    private String deliveryAddress;

	@NotNull
	private String contact;

	@Transient
	private Double total;

	@NotNull
	private String status; // following challenge but i would like to suggest to use ENUM types

	@NotNull
	@JsonSerialize(using = CustomerIdSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Customer customer;

	//@NotNull
	@JsonSerialize(using = StoreIdSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Store store;

	@JsonIgnore
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderItem> items;

	public BigDecimal total() {
		return Optional.ofNullable(items).orElse(new ArrayList<>()).stream().map(OrderItem::total).reduce(
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
