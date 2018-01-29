package nl.tehdreamteam.patient.main;

import nl.tehdreamteam.patient.core.PatientServer;
import nl.tehdreamteam.patient.core.nanohttpd.NanoHttpdPatientServer;
import nl.tehdreamteam.patient.main.cli.ArgumentParser;
import nl.tehdreamteam.patient.main.cli.CommandLineArguments;
import nl.tehdreamteam.patient.main.cli.patient.PatientArgumentParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, ParseException {

        logger.debug("Parsing arguments");
        CommandLineArguments arguments;

        try {
            ArgumentParser parser = new PatientArgumentParser();
            arguments = parser.parseArguments(args);
        } catch (ParseException e) {
            logger.error("Error parsing arguments.", e);
            System.exit(1);
            return;
        }

        logger.debug("Parsed arguments.");
        logger.info("Starting server at port: {}", arguments.getPort());

        PatientServer server = new NanoHttpdPatientServer();
        server.start(arguments.getPort());

        logger.info("Started server at port: {}", arguments.getPort());
    }
}
