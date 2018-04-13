package demo.springboot.monitor;

import org.apache.juli.logging.Log;
import org.apache.tomcat.util.net.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.net.InetSocketAddress;

public class StatusEndPoint extends AbstractEndpoint<String>
        implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    protected SSLHostConfig.Type getSslConfigType() {
        return null;
    }

    @Override
    protected void createSSLContext(SSLHostConfig sslHostConfig) throws Exception {

    }

    @Override
    protected void releaseSSLContext(SSLHostConfig sslHostConfig) {

    }

    @Override
    protected InetSocketAddress getLocalAddress() throws IOException {
        return null;
    }

    @Override
    public boolean isAlpnSupported() {
        return false;
    }

    @Override
    protected boolean getDeferAccept() {
        return false;
    }

    @Override
    protected SocketProcessorBase<String> createSocketProcessor(SocketWrapperBase<String> socketWrapperBase, SocketEvent socketEvent) {
        return null;
    }

    @Override
    public void bind() throws Exception {

    }

    @Override
    public void unbind() throws Exception {

    }

    @Override
    public void startInternal() throws Exception {

    }

    @Override
    public void stopInternal() throws Exception {

    }

    @Override
    protected Acceptor createAcceptor() {
        return null;
    }

    @Override
    protected Log getLog() {
        return null;
    }
}
