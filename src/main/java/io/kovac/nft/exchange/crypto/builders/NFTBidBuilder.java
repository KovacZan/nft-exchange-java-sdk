package io.kovac.nft.exchange.crypto.builders;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeFees;
import io.kovac.nft.exchange.crypto.transactions.NFTBid;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.util.HashMap;

public class NFTBidBuilder extends AbstractTransactionBuilder<NFTBidBuilder> {

    public NFTBidBuilder() {
        super();
        this.transaction.fee = NFTExchangeFees.NFT_BID.getValue();
    }

    public NFTBidBuilder NFTBidAsset(String auctionId, long bidAmount) {
        HashMap<String, Object> nftBid = new HashMap<>();
        nftBid.put("auctionId", auctionId);
        nftBid.put("bidAmount", bidAmount);

        HashMap<String, Object> nftBidMap = new HashMap<>();
        nftBidMap.put("nftBid", nftBid);

        this.transaction.asset.customAsset = nftBidMap;

        return this;
    }

    @Override
    protected Transaction getTransactionInstance() {
        return new NFTBid();
    }

    @Override
    protected NFTBidBuilder instance() {
        return this;
    }
}
