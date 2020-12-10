package io.kovac.nft.exchange.crypto.enums;

public enum NFTExchangeTypeGroup {
    NFT_EXCHANGE_TYPE_GROUP(9001);

    private final int value;

    NFTExchangeTypeGroup(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
