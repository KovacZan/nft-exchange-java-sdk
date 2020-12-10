package io.kovac.nft.exchange.crypto.builders;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeFees;
import io.kovac.nft.exchange.crypto.transactions.NFTBidCancel;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.util.HashMap;

public class NFTBidCancelBuilder extends AbstractTransactionBuilder<NFTBidCancelBuilder> {

    public NFTBidCancelBuilder() {
        super();
        this.transaction.fee = NFTExchangeFees.NFT_BID_CANCEL.getValue();
    }

    public NFTBidCancelBuilder NFTBidCancelAsset(String bidId) {
        HashMap<String, Object> nftBidCancel = new HashMap<>();
        nftBidCancel.put("bidId", bidId);

        HashMap<String, Object> nftBidCancelMap = new HashMap<>();
        nftBidCancelMap.put("nftBidCancel", nftBidCancel);

        this.transaction.asset.customAsset = nftBidCancelMap;

        return this;
    }

    @Override
    protected Transaction getTransactionInstance() {
        return new NFTBidCancel();
    }

    @Override
    protected NFTBidCancelBuilder instance() {
        return this;
    }
}
