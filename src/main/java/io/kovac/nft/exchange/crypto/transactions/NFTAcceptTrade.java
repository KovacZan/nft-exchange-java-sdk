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

public class NFTAcceptTrade extends Transaction {

    @Override
    public int getTransactionType() {
        return NFTExchangeTransactionTypes.NFT_ACCEPT_TRADE.getValue();
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
        Map<String, String> nftAcceptTrade = (Map<String, String>) this.asset.customAsset.get("nftAcceptTrade");
        String auctionId = nftAcceptTrade.get("auctionId");
        String bidId = nftAcceptTrade.get("bidId");

        ByteBuffer buffer = ByteBuffer.allocate(32 + 32);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.put(Hex.decode(auctionId));
        buffer.put(Hex.decode(bidId));

        return buffer.array();
    }

    @Override
    public void deserialize(ByteBuffer buffer) {
        throw new NotImplementedException();
    }
}
