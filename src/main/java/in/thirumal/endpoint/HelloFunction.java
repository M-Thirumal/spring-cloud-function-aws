/**
 * 
 */
package in.thirumal.endpoint;

import java.util.function.Function;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

/**
 * @author Thirumal
 *
 */
@Component
public class HelloFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	@Override
	public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent input) {
		APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();
		apiGatewayProxyResponseEvent.setStatusCode(HttpStatus.OK.value());
		apiGatewayProxyResponseEvent.setBody("hello lambda function from " + input.getBody() == null ? "get method" : " post/put/patch method");
		return apiGatewayProxyResponseEvent;
	}

}