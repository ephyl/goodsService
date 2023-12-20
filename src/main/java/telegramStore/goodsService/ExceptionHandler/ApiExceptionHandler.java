package telegramStore.goodsService.ExceptionHandler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import telegramStore.goodsService.dto.ErrorTransferDto;


import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorTransferDto onConstraintValidationException(
            ConstraintViolationException ex) {
        return handle(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ErrorTransferDto handleValidationIncomingTransferDtoExceptions(MethodArgumentNotValidException ex
           ) {
        List<String> errorsList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> errorsList.add(error.getDefaultMessage()));
        String errorResponse = String.join(", ", errorsList);
        return handle(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), errorResponse);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorTransferDto handleBadRequestException(MissingServletRequestParameterException ex) {

        return ErrorTransferDto.builder()
                .errorMessage(ex.getMessage())
                .errorCode("400")
                .build();
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorTransferDto handleNoHandlerFoundException(NoHandlerFoundException ex) {

        return ErrorTransferDto.builder()
                .errorMessage(ex.getMessage())
                .errorCode("404")
                .build();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorTransferDto handleCommissionNotFoundException(Exception ex) {

        return ErrorTransferDto.builder()
                .errorMessage(ex.getMessage())
                .errorCode("500")
                .build();
    }


    private ErrorTransferDto handle(int errorCode, String errorMessage, String failReason) {
        return ErrorTransferDto.builder()
                .errorCode(String.valueOf(errorCode))
                .errorMessage(errorMessage)
                .failReason(failReason)
                .build();
    }

    private ErrorTransferDto handle(int errorCode, String errorMessage, String failReason, int remainingAttempts) {
        return ErrorTransferDto.builder()
                .errorCode(String.valueOf(errorCode))
                .errorMessage(errorMessage)
                .failReason(failReason)
                .remainingAttempts(remainingAttempts)
                .build();
    }
}