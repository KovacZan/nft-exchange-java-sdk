package io.kovac.nft.exchange.crypto.builders;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeFees;
import io.kovac.nft.exchange.crypto.transactions.NFTAuctionCancel;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class NFTAuctionCancelBuilder extends AbstractTransactionBuilder<NFTAuctionCancelBuilder> {

    public NFTAuctionCancelBuilder() {
        super();
        this.transaction.fee = NFTExchangeFees.NFT_AUCTION_CANCEL.getValue();
    }

    public NFTAuctionCancelBuilder NFTAuctionCancelAsset() {
        return this;
    }

    @Override
    protected Transaction getTransactionInstance() {
        return new NFTAuctionCancel();
    }

    @Override
    protected NFTAuctionCancelBuilder instance() {
        return this;
    }
}
