package syscode42.orderms.dto.http;

import java.util.List;

public record ApiResponse<T>(
        List<T> data,
        PaginationResponse pagination
) { }
