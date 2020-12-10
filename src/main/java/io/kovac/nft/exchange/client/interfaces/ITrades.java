package io.kovac.nft.exchange.client.interfaces;

import java.io.IOException;
import java.util.Map;

public interface ITrades {

    Map<String, Object> all() throws IOException;

    Map<String, Object> show(String id) throws IOException;

    Map<String, Object> search(Map<String, Object> parameters) throws IOException;

}
