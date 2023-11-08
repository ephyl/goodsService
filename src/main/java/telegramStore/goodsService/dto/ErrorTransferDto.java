package telegramStore.goodsService.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorTransferDto {

    private String errorCode;

    private String errorMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String failReason;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer remainingAttempts;
}
