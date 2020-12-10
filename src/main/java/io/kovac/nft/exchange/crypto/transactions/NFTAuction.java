package io.kovac.nft.exchange.crypto.transactions;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeTransactionTypes;
import io.kovac.nft.exchange.crypto.enums.NFTExchangeTypeGroup;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.nio.ByteBuffer;
import java.util.HashMap;

public class NFTAuction extends Transaction {

    @Override
    public int getTransactionType() {
        return NFTExchangeTransactionTypes.NFT_AUCTION.getValue();
    }

    @Override
    public int getTransactionTypeGroup() {
        return NFTExchangeTypeGroup.NFT_EXCHANGE_TYPE_GROUP.getValue();
    }

    @Override
    public HashMap<String, Object> assetToHashMap() {
        return null;
    }

    @Override
    public byte[] serialize() {
        return new byte[0];
    }

    @Override
    public void deserialize(ByteBuffer buffer) {

    }
}