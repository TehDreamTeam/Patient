package nl.tehdreamteam.patient.core.nanohttpd;

import fi.iki.elonen.NanoHTTPD;
import nl.tehdreamteam.patient.core.PatientServer;

import java.io.IOException;

public class NanoHttpdPatientServer implements PatientServer {

    private EmbeddedNanoHttpdServer server;

    @Override
    public void start(int port) throws IOException {
        server = new EmbeddedNanoHttpdServer(port);
        server.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
    }

    @Override
    public void stop() {
        server.stop();
        server = null;
    }

    @Override
    public boolean isAlive() {
        return server != null && server.isAlive();
    }
}
