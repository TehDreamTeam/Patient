package nl.tehdreamteam.patient.core.nanohttpd;

import fi.iki.elonen.NanoHTTPD;

public class EmbeddedNanoHttpdServer extends NanoHTTPD {

    public EmbeddedNanoHttpdServer(int port) {
        super(port);
    }

    @Override
    public Response serve(IHTTPSession session) {

        System.out.println(session.getRemoteIpAddress());
        for(String key : session.getHeaders().keySet()) {
            String header = session.getHeaders().get(key);
            System.out.println(key + ":" + header);
        }

        return newFixedLengthResponse("Henlo!");
    }
}
