package nl.tehdreamteam.patient.main.cli.patient;

import nl.tehdreamteam.patient.main.cli.CommandLineArgumentsMutator;

public class PatientCommandLineArguments implements CommandLineArgumentsMutator {
    private int port;

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }
}
