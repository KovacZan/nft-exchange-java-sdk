package io.kovac.nft.exchange.client;

import io.kovac.nft.exchange.client.implementations.Auctions;
import io.kovac.nft.exchange.client.implementations.Bids;
import io.kovac.nft.exchange.client.implementations.Configurations;
import io.kovac.nft.exchange.client.implementations.Trades;
import io.kovac.nft.exchange.client.interfaces.IAuctions;
import io.kovac.nft.exchange.client.interfaces.IBids;
import io.kovac.nft.exchange.client.interfaces.IConfigurations;
import io.kovac.nft.exchange.client.interfaces.ITrades;
import org.arkecosystem.client.http.Client;

public class NFTExchangeApi {

    public final IAuctions auctions;
    public final IBids bids;
    public final IConfigurations configurations;
    public final ITrades trades;

    public NFTExchangeApi(Client client) {
        this.auctions = new Auctions(client);
        this.bids = new Bids(client);
        this.configurations = new Configurations(client);
        this.trades = new Trades(client);
    }

}
