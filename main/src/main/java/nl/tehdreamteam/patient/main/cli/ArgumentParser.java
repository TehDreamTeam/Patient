package nl.tehdreamteam.patient.main.cli;

import org.apache.commons.cli.ParseException;

public interface ArgumentParser {

    CommandLineArguments parseArguments(String... args) throws ParseException;
}
