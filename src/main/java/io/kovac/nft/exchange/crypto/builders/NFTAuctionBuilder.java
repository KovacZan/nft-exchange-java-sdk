package io.kovac.nft.exchange.crypto.builders;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeFees;
import io.kovac.nft.exchange.crypto.transactions.NFTAuction;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.util.HashMap;
import java.util.List;

public class NFTAuctionBuilder extends AbstractTransactionBuilder<NFTAuctionBuilder> {

    public NFTAuctionBuilder() {
        super();
        this.transaction.fee = NFTExchangeFees.NFT_AUCTION.getValue();
    }

    public NFTAuctionBuilder NFTAuctionAsset(List<String> nftIds, long startAmount, int blockHeightExpiration) {
        HashMap<String, Object> nftAuction = new HashMap<>();
        nftAuction.put("nftIds", nftIds);
        nftAuction.put("startAmount", startAmount);
        HashMap<String, Integer> expiration = new HashMap<>();
        expiration.put("blockHeight", blockHeightExpiration);
        nftAuction.put("expiration", expiration);

        HashMap<String, Object> nftAuctionMap = new HashMap<>();
        nftAuctionMap.put("nftAuction", nftAuction);

        this.transaction.asset.customAsset = nftAuctionMap;

        return this;
    }

    @Override
    protected Transaction getTransactionInstance() {
        return new NFTAuction();
    }

    @Override
    protected NFTAuctionBuilder instance() {
        return this;
    }
}
