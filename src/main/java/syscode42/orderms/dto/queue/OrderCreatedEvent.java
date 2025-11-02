package syscode42.orderms.dto.queue;

import java.util.List;

public record OrderCreatedEvent(Long codigoPedido, long codigoCliente, List<OrderItemEvent> itens) { }
