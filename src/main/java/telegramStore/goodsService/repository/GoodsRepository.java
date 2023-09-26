package telegramStore.goodsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import telegramStore.goodsService.entity.Good;

import java.util.List;
import java.util.UUID;
@Repository
public interface GoodsRepository extends JpaRepository<Good, UUID> {
    List<Good> findByStoreIdAndQuantityIsGreaterThan(int storeId, int quantity);



}
