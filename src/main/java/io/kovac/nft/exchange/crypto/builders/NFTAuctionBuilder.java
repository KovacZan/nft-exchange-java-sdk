package io.kovac.nft.exchange.crypto.builders;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeFees;
import io.kovac.nft.exchange.crypto.transactions.NFTAuction;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class NFTAuctionBuilder extends AbstractTransactionBuilder<NFTAuctionBuilder> {

    public NFTAuctionBuilder() {
        super();
        this.transaction.fee = NFTExchangeFees.NFT_AUCTION.getValue();
    }

    public NFTAuctionBuilder NFTAuctionAsset() {
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
