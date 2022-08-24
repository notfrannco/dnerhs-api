package py.gov.mspbs.config;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import py.gov.mspbs.exception.ApiException;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler({ ConstraintViolationException.class, MethodArgumentNotValidException.class, ApiException.class })
	@ResponseBody
	public ResponseEntity<Object> badRequest(HttpServletRequest request, Exception ex) {

		List<String> errors = null;
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", HttpStatus.NOT_ACCEPTABLE.value());
		
		if (ex instanceof ApiException) {
			body.put("error", ex.getMessage());
		}else if (ex instanceof MethodArgumentNotValidException) {
			errors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors().stream()
					.map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			body.put("errors", errors);
		} else if (ex instanceof ConstraintViolationException) {
			errors = ((ConstraintViolationException) ex).getConstraintViolations().stream()
					.map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
					.collect(Collectors.toList());
			body.put("errors", errors);
		}
		
		return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);

	}
	
}
