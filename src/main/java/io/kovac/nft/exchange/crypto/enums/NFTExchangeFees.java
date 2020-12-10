package io.kovac.nft.exchange.crypto.enums;

public enum NFTExchangeFees {
    NFT_AUCTION(500_000_000L),
    NFT_AUCTION_CANCEL(500_000_000L),
    NFT_BID(500_000_000L),
    NFT_BID_CANCEL(500_000_000L),
    NFT_ACCEPT_TRADE(500_000_000L);

    private final Long value;

    NFTExchangeFees(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
