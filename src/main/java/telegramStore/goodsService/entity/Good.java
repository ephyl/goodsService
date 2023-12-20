package telegramStore.goodsService.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productId;

    @Column(name = "store_id")
    private int storeId;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int goodsQuantity;

    @Column(name = "price")
    private BigDecimal price;


}
