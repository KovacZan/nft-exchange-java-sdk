package io.kovac.nft.exchange.examples;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import io.kovac.nft.exchange.crypto.builders.NFTAcceptTradeBuilder;
import io.kovac.nft.exchange.crypto.builders.NFTBidCancelBuilder;
import org.arkecosystem.client.Connection;
import org.arkecosystem.crypto.configuration.Network;
import org.arkecosystem.crypto.identities.Address;
import org.arkecosystem.crypto.networks.Testnet;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NFTAcceptTrade {

    public static long getNonce(Connection connection, String senderWallet) throws IOException {
        return Long.valueOf (((Map<String, Object>) connection.api().wallets.show(senderWallet).get("data")).get("nonce").toString());
    }

    public static void main(String[] args) throws IOException {
        Network.set(new Testnet());

        Map<String, Object> map = new HashMap<>();
        map.put("host", "http://localhost:4003/api/");
        map.put("content-type","application/json");

        Connection connection = new Connection(map);

        long nonce = getNonce(connection, Address.fromPassphrase("clay harbor enemy utility margin pretty hub comic piece aerobic umbrella acquire")) + 1;

        List payload = new ArrayList<>();

        Transaction transaction = new NFTAcceptTradeBuilder()
                .nonce(nonce)
                .NFTAcceptTradeAsset("e8a6c48b4496babaeeec29be7731db8f04493285e5c440793a47142621b16eca", "4cd1bd54aaa594e8981d99e7297415899eddd01f4838eccfcfe29131c3de70c9")
                .sign("clay harbor enemy utility margin pretty hub comic piece aerobic umbrella acquire")
                .transaction;


        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Formatted Json");
        System.out.println(GSON.toJson(JsonParser.parseString(transaction.toJson())));

        payload.add(transaction.toHashMap());

        System.out.println("Payload response");
        Map<String, Object> postResponse = connection.api().transactions.create(payload);
        System.out.println(postResponse);
    }
}
