package co.com.bancolombia.api;

import co.com.bancolombia.api.config.LoanAppPath;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RouterRest {

    private final LoanAppPath loanAppPath;
    @Bean
    public RouterFunction<ServerResponse> routerFunction(HandlerLoanApp handlerLoanApp) {
        return route(POST(loanAppPath.getLoanApplication()), handlerLoanApp::saveLoanApp);
    }
}
