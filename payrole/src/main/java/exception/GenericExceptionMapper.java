package exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


import com.employee.payrole.entites.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage message =
				new ErrorMessage(exception.getMessage(), 500, null);
		return Response
				.status(javax.ws.rs.core.Response.Status.NOT_FOUND)
				.entity(message)
				.build();
	}
	
	public void statusOk() {
		System.out.println("deleted");
	}

}
