package co.com.bancolombia.api;

import co.com.bancolombia.api.config.UserPath;
import co.com.bancolombia.api.handler.HandlerUser;
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
    private final UserPath userPath;

    @Bean
    @RouterOperation(
            path = "/api/v1/usuarios", 
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.POST,
            beanClass = HandlerUser.class,
            beanMethod = "registerUser",
            operation = @Operation(
                    operationId = "registerUser",
                    summary = "Registrar un usuario",
                    description = "Crea un nuevo usuario en el sistema",
                    responses = {
                            @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente"),
                            @ApiResponse(responseCode = "400", description = "Datos inválidos")
                    }
            )
    )
    public RouterFunction<ServerResponse> routerFunction(HandlerUser handlerUser) {
        return route(POST(userPath.getUsers()),handlerUser::registerUser);

    }
}
