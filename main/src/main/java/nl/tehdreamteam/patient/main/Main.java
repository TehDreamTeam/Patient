package nl.tehdreamteam.patient.main;

import nl.tehdreamteam.patient.core.PatientServer;
import nl.tehdreamteam.patient.core.nanohttpd.NanoHttpdPatientServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("STARTING THA PATIENT");
        long start = System.currentTimeMillis();
        PatientServer server = new NanoHttpdPatientServer();

        server.start(1201);
        long end = System.currentTimeMillis();
        System.out.println("Started tha patient");
        System.out.println("It took so many ms: " + (end-start));
    }
}
