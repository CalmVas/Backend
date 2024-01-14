package prometheus.KhuT.Exception.handler;

import org.springframework.security.core.AuthenticationException;
import prometheus.KhuT.Common.status.ErrorStatus;

public class JwtHandler extends AuthenticationException {
    public JwtHandler(ErrorStatus status){
        super(status.name());
    }
}
