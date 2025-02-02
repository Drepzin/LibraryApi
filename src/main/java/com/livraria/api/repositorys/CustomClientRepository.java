package com.livraria.api.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Component;

@Component
public class CustomClientRepository implements RegisteredClientRepository {

    private ClientSettings clientSettings;
    private TokenSettings tokenSettings;
    private ClientRepo clientRepo;

    public CustomClientRepository(ClientSettings clientSettings, ClientRepo clientRepo, TokenSettings tokenSettings) {
        this.clientSettings = clientSettings;
        this.clientRepo = clientRepo;
        this.tokenSettings = tokenSettings;
    }

    @Override
    public void save(RegisteredClient registeredClient) {}

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var client = clientRepo.findByClientId(clientId);
        return RegisteredClient.withId(client.getClientId().toString())
                .clientId(client.getClientId())
                .clientSecret(client.getClientSecret())
                .redirectUri(client.getRedirectUri())
                .scope(client.getScope())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .build();
    }
}
