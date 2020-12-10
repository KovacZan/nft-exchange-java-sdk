package io.kovac.nft.exchange.client;

import org.arkecosystem.client.Connection;

import java.util.Map;

public class NFTExchangeConnection extends Connection {

    private final NFTExchangeApi nftExchangeApi;

    public NFTExchangeConnection(Map<String, Object> config) {
        super(config);
        this.nftExchangeApi = new NFTExchangeApi(this.client());
    }

    public NFTExchangeApi nftExchangeApi () {
        return this.nftExchangeApi;
    }

}
