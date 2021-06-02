package exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.employee.payrole.entites.ErrorMessage;
@Provider
public class DataNotFoundExceptionMapper 
	implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage message = new ErrorMessage
				(exception.getMessage(), 404, null);
		return Response
				.status(javax.ws.rs.core.Response.Status.NOT_FOUND)
				.entity(message)
				.build();
	}
	
}
