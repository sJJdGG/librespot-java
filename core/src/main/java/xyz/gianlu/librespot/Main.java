package xyz.gianlu.librespot;

import xyz.gianlu.librespot.core.AuthConfiguration;
import xyz.gianlu.librespot.core.Session;
import xyz.gianlu.librespot.core.ZeroconfServer;
import xyz.gianlu.librespot.debug.TimingsDebugger;
import xyz.gianlu.librespot.mercury.MercuryClient;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author Gianlu
 */
public class Main {

    public static void main(String[] args) throws IOException, GeneralSecurityException, Session.SpotifyAuthenticationException, MercuryClient.MercuryException {
        AbsConfiguration conf = new FileConfiguration(new File("conf.properties"), args);
        TimingsDebugger.init(conf.enableTimingsDebugger());

        if (conf.authStrategy() == AuthConfiguration.Strategy.ZEROCONF) ZeroconfServer.create(conf);
        else new Session.Builder(conf).create();
    }
}
