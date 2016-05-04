package github.meifans.hello.filter;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationManager extends ProviderManager {

    public MyAuthenticationManager(List<AuthenticationProvider> providers) {
        super(providers);
    }

}
