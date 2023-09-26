package telegramStore.goodsService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "store_id")
    private int storeId;

    @Column(name = "name")
    private  String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;


}
