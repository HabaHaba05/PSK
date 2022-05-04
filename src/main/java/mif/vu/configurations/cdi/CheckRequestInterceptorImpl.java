package mif.vu.configurations.cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAllowedException;

@Interceptor
@CheckRequestInterceptor
public class CheckRequestInterceptorImpl {

    @Inject
    HttpServletRequest request;

    @AroundInvoke
    public Object checkAccess(InvocationContext ctx) throws Exception {
        CheckRequestInterceptor annotation = ctx.getMethod().getAnnotation(CheckRequestInterceptor.class);
        String role = annotation.role();

        String roleToken = request.getHeader("roleToken");
        if(roleToken==null && !role.equals(roleToken)){
            throw new NotAllowedException("Not allowed");
        }
        return ctx.proceed();
    }
}
