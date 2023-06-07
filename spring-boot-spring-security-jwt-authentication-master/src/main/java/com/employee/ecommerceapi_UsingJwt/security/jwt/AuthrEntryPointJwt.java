 package com.employee.ecommerceapi_UsingJwt.security.jwt;

 import com.fasterxml.jackson.databind.ObjectMapper;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.http.MediaType;
 import org.springframework.security.access.AccessDeniedException;
 import org.springframework.security.web.access.AccessDeniedHandler;
 import org.springframework.stereotype.Component;

 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.io.IOException;
 import java.util.HashMap;
 import java.util.Map;

@Component
public class AuthrEntryPointJwt  implements AccessDeniedHandler {

  private static final Logger logger = LoggerFactory.getLogger(AuthrEntryPointJwt.class);
  
  
@Override
public void handle(HttpServletRequest request, HttpServletResponse response,
		AccessDeniedException accessDeniedException) throws IOException, ServletException {
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);

    final Map<String, Object> body = new HashMap<>();
    body.put("status", HttpServletResponse.SC_FORBIDDEN);
    body.put("error", "Forbidden");
    body.put("message", accessDeniedException.getMessage()+"|"+"please contact administrator");
    body.put("path", request.getServletPath());

    final ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(response.getOutputStream(), body);

	
}
 
}
