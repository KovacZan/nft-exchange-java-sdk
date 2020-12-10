package io.kovac.nft.exchange.crypto.enums;

public enum NFTExchangeTransactionTypes {
    NFT_AUCTION(0),
    NFT_AUCTION_CANCEL(1),
    NFT_BID(2),
    NFT_BID_CANCEL(3),
    NFT_ACCEPT_TRADE(4);

    private final int value;

    NFTExchangeTransactionTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
