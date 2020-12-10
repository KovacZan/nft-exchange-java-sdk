package io.kovac.nft.exchange.crypto.transactions;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeTransactionTypes;
import io.kovac.nft.exchange.crypto.enums.NFTExchangeTypeGroup;
import org.arkecosystem.crypto.encoding.Hex;
import org.arkecosystem.crypto.transactions.types.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class NFTBid extends Transaction {

    @Override
    public int getTransactionType() {
        return NFTExchangeTransactionTypes.NFT_BID.getValue();
    }

    @Override
    public int getTransactionTypeGroup() {
        return NFTExchangeTypeGroup.NFT_EXCHANGE_TYPE_GROUP.getValue();
    }

    @Override
    public HashMap<String, Object> assetToHashMap() {
        return this.asset.customAsset;
    }

    @Override
    public byte[] serialize() {
        Map<String, Object> nftBurn = (Map<String, Object>) this.asset.customAsset.get("nftBid");
        String auctionId = (String) nftBurn.get("auctionId");
        long bidAmount = (long) nftBurn.get("bidAmount");

        ByteBuffer buffer = ByteBuffer.allocate(32 + 8);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.put(Hex.decode(auctionId));
        buffer.putLong(bidAmount);

        return buffer.array();
    }

    @Override
    public void deserialize(ByteBuffer buffer) {
        throw new NotImplementedException();
    }
}
