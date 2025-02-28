package xyz.gianlu.librespot;

import xyz.gianlu.librespot.core.AuthConfiguration;
import xyz.gianlu.librespot.core.Session;
import xyz.gianlu.librespot.core.ZeroconfServer;
import xyz.gianlu.librespot.spirc.SpotifyIrc;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author Gianlu
 */
public class Main {

    public static void main(String[] args) throws IOException, GeneralSecurityException, Session.SpotifyAuthenticationException, SpotifyIrc.IrcException {
        AbsConfiguration conf = new FileConfiguration(args);
        if (conf.authStrategy() == AuthConfiguration.Strategy.ZEROCONF) {
            ZeroconfServer.create(conf);
        } else {
            new Session.Builder(conf).create();
        }
    }
}
