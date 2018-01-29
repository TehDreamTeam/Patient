package nl.tehdreamteam.patient.main.cli.patient;

import nl.tehdreamteam.patient.main.cli.ArgumentParser;
import nl.tehdreamteam.patient.main.cli.CommandLineArguments;
import nl.tehdreamteam.patient.main.cli.CommandLineArgumentsMutator;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientArgumentParser implements ArgumentParser {

    //private static final Logger logger = LoggerFactory.getLogger(PatientArgumentParser.class.getName());
    private CommandLineArgumentsMutator argumentsMutator;

    public PatientArgumentParser(CommandLineArgumentsMutator clam) {
        this.argumentsMutator = clam;
    }

    public PatientArgumentParser() {
        this(new PatientCommandLineArguments());
    }

    @Override
    public CommandLineArguments parseArguments(String... args) throws ParseException {
        Options options = new Options();

        Option port = Option.builder("p")
                .longOpt("port")
                .hasArg()
                .required()
                .argName("port")
                .desc("The port at which this Patient will service HTTP-requests.")
                .build();
        options.addOption(port);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            formatter.printHelp("Patient", options);
            throw e;
        }

        argumentsMutator.setPort(Integer.parseInt(cmd.getOptionValue("port")));

        return argumentsMutator;
    }
}
