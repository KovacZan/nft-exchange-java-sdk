package io.kovac.nft.exchange.crypto.transactions;

import io.kovac.nft.exchange.crypto.enums.NFTExchangeTransactionTypes;
import io.kovac.nft.exchange.crypto.enums.NFTExchangeTypeGroup;
import org.arkecosystem.crypto.encoding.Hex;
import org.arkecosystem.crypto.transactions.types.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return this.asset.customAsset;
    }

    @Override
    public byte[] serialize() {
        Map<String, Object> nftAuction = (Map<String, Object>) this.asset.customAsset.get("nftAuction");

        List<String> nftIds = (List<String>) nftAuction.get("nftIds");

        long startAmount = (long) nftAuction.get("startAmount");

        int blockHeightExpiration = (int) ((HashMap<String, Object>) nftAuction.get("expiration")).get("blockHeight");

        ByteBuffer buffer = ByteBuffer.allocate(1 + 32 * nftIds.size() + 8 + 4);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.put((byte) nftIds.size());
        for (String nft : nftIds) {
            buffer.put(Hex.decode(nft));
        }

        buffer.putLong(startAmount);

        buffer.putInt(blockHeightExpiration);

        return buffer.array();
    }

    @Override
    public void deserialize(ByteBuffer buffer) {
        throw new NotImplementedException();
    }
}
