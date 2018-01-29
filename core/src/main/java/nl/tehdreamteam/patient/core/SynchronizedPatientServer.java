package nl.tehdreamteam.patient.core;

import java.io.IOException;

public abstract class SynchronizedPatientServer implements PatientServer {
    private final Object lock = new Object();


    @Override
    public final void start(int port) throws IOException {
        stop();

        synchronized (lock) {
            _start(port);
        }
    }

    protected abstract void _start(int port) throws IOException;

    @Override
    public final void stop() throws IOException {
        if (!isAlive()) {
            return;
        }

        synchronized (lock) {
            _stop();
        }
    }

    protected abstract void _stop() throws IOException;

    @Override
    public boolean isAlive() {
        synchronized (lock) {
            return _isAlive();
        }
    }

    protected abstract boolean _isAlive();
}
