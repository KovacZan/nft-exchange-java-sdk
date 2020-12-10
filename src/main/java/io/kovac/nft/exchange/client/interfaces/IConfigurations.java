package io.kovac.nft.exchange.client.interfaces;

import java.io.IOException;
import java.util.Map;

public interface IConfigurations {

    Map<String, Object> all() throws IOException;

}
