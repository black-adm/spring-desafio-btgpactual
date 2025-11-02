package syscode42.orderms.controller;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import syscode42.orderms.factory.OrderResponseFactory;
import syscode42.orderms.service.OrderService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    OrderService orderService;

    @InjectMocks
    OrderController orderController;

    @Nested
    class ListOrders {

        @Test
        void shouldReturnHttpOk() {

            var customerId = 1L;
            var page = 0;
            var pageSize = 10;

            doReturn(OrderResponseFactory.buildWithOneItem())
                    .when(orderService)
                    .findAllByCustomerId(anyLong(), any());

            doReturn(BigDecimal.valueOf(2.50))
                    .when(orderService)
                    .findTotalOnOrdersByCustomerId(anyLong());

            var response = orderController.listOrders(customerId, page, pageSize);

            assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        }

        @Test
        void shouldPassCorrectParamtersToService() {

        }

        @Test
        void shouldReturnResponseBodyCorrectly() {

        }
    }
}