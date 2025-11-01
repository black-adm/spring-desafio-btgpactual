package syscode42.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import syscode42.orderms.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
