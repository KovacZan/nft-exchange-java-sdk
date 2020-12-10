package io.kovac.nft.exchange.client.implementations;

import io.kovac.nft.exchange.client.interfaces.IAuctions;
import org.arkecosystem.client.http.Client;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.Map;

public class Auctions implements IAuctions {

    private final Client client;

    public Auctions(Client client) {
        this.client = client;
    }

    @Override
    public Map<String, Object> all() throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> show(String id) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> showWallet(String id) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> search(Map<String, Object> parameters) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> allCanceled() throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> showCanceled(String id) throws IOException {
        throw new NotImplementedException();
    }
}
