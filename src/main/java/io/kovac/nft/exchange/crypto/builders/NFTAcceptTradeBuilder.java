package io.kovac.nft.exchange.crypto.builders;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeFees;
import io.kovac.nft.exchange.crypto.transactions.NFTAcceptTrade;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.util.HashMap;

public class NFTAcceptTradeBuilder extends AbstractTransactionBuilder<NFTAcceptTradeBuilder> {

    public NFTAcceptTradeBuilder() {
        super();
        this.transaction.fee = NFTExchangeFees.NFT_ACCEPT_TRADE.getValue();
    }

    public NFTAcceptTradeBuilder NFTAcceptTradeAsset(String auctionId, String bidId) {
        HashMap<String, Object> nftAcceptTrade = new HashMap<>();
        nftAcceptTrade.put("auctionId", auctionId);
        nftAcceptTrade.put("bidId", bidId);

        HashMap<String, Object> nftAcceptTradedMap = new HashMap<>();
        nftAcceptTradedMap.put("nftAcceptTrade", nftAcceptTrade);

        this.transaction.asset.customAsset = nftAcceptTradedMap;

        return this;
    }

    @Override
    protected Transaction getTransactionInstance() {
        return new NFTAcceptTrade();
    }

    @Override
    protected NFTAcceptTradeBuilder instance() {
        return this;
    }
}
