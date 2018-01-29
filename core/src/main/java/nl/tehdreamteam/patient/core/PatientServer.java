package nl.tehdreamteam.patient.core;

import java.io.IOException;

public interface PatientServer {

    void start(int port) throws IOException;

    void stop() throws IOException;

    boolean isAlive();
}
