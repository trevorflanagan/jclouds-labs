package org.jclouds.dimensiondata.compute.options;

import org.jclouds.compute.options.TemplateOptions;
import org.jclouds.domain.LoginCredentials;
import org.jclouds.scriptbuilder.domain.Statement;

import java.util.Map;

public final class DimensionDataTemplateOptions extends TemplateOptions implements Cloneable
{
    
    @Override
    public DimensionDataTemplateOptions clone() {
       DimensionDataTemplateOptions options = new DimensionDataTemplateOptions();
       copyTo(options);
       return options;
    }
 
    @Override
    public void copyTo(TemplateOptions to) {
       super.copyTo(to);
       if (to instanceof DimensionDataTemplateOptions) {
          DimensionDataTemplateOptions eTo = DimensionDataTemplateOptions.class.cast(to);
       }
    }
    
    /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions blockOnPort(int port, int seconds) {
        return DimensionDataTemplateOptions.class.cast(super.blockOnPort(port, seconds));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions inboundPorts(int... ports) {
        return DimensionDataTemplateOptions.class.cast(super.inboundPorts(ports));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions authorizePublicKey(String publicKey) {
        return DimensionDataTemplateOptions.class.cast(super.authorizePublicKey(publicKey));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions installPrivateKey(String privateKey) {
        return DimensionDataTemplateOptions.class.cast(super.installPrivateKey(privateKey));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions blockUntilRunning(boolean blockUntilRunning) {
        return DimensionDataTemplateOptions.class.cast(super.blockUntilRunning(blockUntilRunning));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions dontAuthorizePublicKey() {
        return DimensionDataTemplateOptions.class.cast(super.dontAuthorizePublicKey());
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions nameTask(String name) {
        return DimensionDataTemplateOptions.class.cast(super.nameTask(name));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions runAsRoot(boolean runAsRoot) {
        return DimensionDataTemplateOptions.class.cast(super.runAsRoot(runAsRoot));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions runScript(Statement script) {
        return DimensionDataTemplateOptions.class.cast(super.runScript(script));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions overrideLoginCredentials(LoginCredentials overridingCredentials) {
        return DimensionDataTemplateOptions.class.cast(super.overrideLoginCredentials(overridingCredentials));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions overrideLoginPassword(String password) {
        return DimensionDataTemplateOptions.class.cast(super.overrideLoginPassword(password));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions overrideLoginPrivateKey(String privateKey) {
        return DimensionDataTemplateOptions.class.cast(super.overrideLoginPrivateKey(privateKey));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions overrideLoginUser(String loginUser) {
        return DimensionDataTemplateOptions.class.cast(super.overrideLoginUser(loginUser));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions overrideAuthenticateSudo(boolean authenticateSudo) {
        return DimensionDataTemplateOptions.class.cast(super.overrideAuthenticateSudo(authenticateSudo));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions userMetadata(Map<String, String> userMetadata) {
        return DimensionDataTemplateOptions.class.cast(super.userMetadata(userMetadata));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions userMetadata(String key, String value) {
        return DimensionDataTemplateOptions.class.cast(super.userMetadata(key, value));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions nodeNames(Iterable<String> nodeNames) {
        return DimensionDataTemplateOptions.class.cast(super.nodeNames(nodeNames));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions networks(Iterable<String> networks) {
        return DimensionDataTemplateOptions.class.cast(super.networks(networks));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions networks(String... networks) {
        return DimensionDataTemplateOptions.class.cast(super.networks(networks));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions tags(Iterable<String> tags) {
        return DimensionDataTemplateOptions.class.cast(super.tags(tags));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions wrapInInitScript(boolean wrapInInitScript) {
        return DimensionDataTemplateOptions.class.cast(super.wrapInInitScript(wrapInInitScript));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions runScript(String script) {
        return DimensionDataTemplateOptions.class.cast(super.runScript(script));
     }
  
     /**
      * {@inheritDoc}
      */
     @Override
     public DimensionDataTemplateOptions blockOnComplete(boolean blockOnComplete) {
        return DimensionDataTemplateOptions.class.cast(super.blockOnComplete(blockOnComplete));
     }
}
