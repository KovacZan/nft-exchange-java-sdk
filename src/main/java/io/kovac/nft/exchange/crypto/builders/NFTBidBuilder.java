package io.kovac.nft.exchange.crypto.builders;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeFees;
import io.kovac.nft.exchange.crypto.transactions.NFTBid;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class NFTBidBuilder extends AbstractTransactionBuilder<NFTBidBuilder> {

    public NFTBidBuilder() {
        super();
        this.transaction.fee = NFTExchangeFees.NFT_BID.getValue();
    }

    public NFTBidBuilder NFTBidAsset() {
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
