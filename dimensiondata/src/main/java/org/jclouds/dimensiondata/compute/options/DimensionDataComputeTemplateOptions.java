/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.dimensiondata.compute.options;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.jclouds.compute.options.TemplateOptions;
import org.jclouds.domain.LoginCredentials;
import org.jclouds.javax.annotation.Nullable;
import org.jclouds.scriptbuilder.domain.Statement;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Contains options supported by the {@link org.jclouds.compute.ComputeService#createNodesInGroup(
 * String, int, org.jclouds.compute.options.TemplateOptions)} operation.
 *
 * <h2>Usage</h2> The recommended way to instantiate a {@link DimensionDataComputeTemplateOptions} object is to statically
 * import {@code AzureComputeTemplateOptions.*} and invoke a static creation method followed by an instance mutator (if
 * needed):
 * <p>
 *
 * <pre>
 * import static org.jclouds.compute.options.AzureComputeTemplateOptions.Builder.*;
 * ComputeService client = // get connection
 * templateBuilder.options(inboundPorts(22, 80, 8080, 443));
 * Set&lt;? extends NodeMetadata&gt; set = client.createNodesInGroup(tag, 2, templateBuilder.build());
 * </pre>
 *
 */
public class DimensionDataComputeTemplateOptions extends TemplateOptions implements Cloneable {

   protected String virtualNetworkName;
   protected List<String> subnetNames = ImmutableList.of();
   protected String storageAccountName;
   protected String storageAccountType;
   protected String networkSecurityGroupName;
   protected String reservedIPName;

   @Override
   public DimensionDataComputeTemplateOptions clone() {
      final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
      copyTo(options);
      return options;
   }

   @Override
   public void copyTo(final TemplateOptions to) {
      super.copyTo(to);
      if (to instanceof DimensionDataComputeTemplateOptions) {
         final DimensionDataComputeTemplateOptions eTo = DimensionDataComputeTemplateOptions.class.cast(to);
         eTo.virtualNetworkName(virtualNetworkName);
         if (!subnetNames.isEmpty()) {
            eTo.subnetNames(subnetNames);
         }
         eTo.storageAccountName(storageAccountName);
         eTo.storageAccountType(storageAccountType);
         eTo.reservedIPName(reservedIPName);
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof DimensionDataComputeTemplateOptions)) return false;
      if (!super.equals(o)) return false;

      DimensionDataComputeTemplateOptions that = (DimensionDataComputeTemplateOptions) o;

      if (networkSecurityGroupName != null ? !networkSecurityGroupName.equals(that.networkSecurityGroupName) : that.networkSecurityGroupName != null)
         return false;
      if (reservedIPName != null ? !reservedIPName.equals(that.reservedIPName) : that.reservedIPName != null) return false;
      if (storageAccountName != null ? !storageAccountName.equals(that.storageAccountName) : that.storageAccountName != null) return false;
      if (storageAccountType != null ? !storageAccountType.equals(that.storageAccountType) : that.storageAccountType != null) return false;
      if (subnetNames != null ? !subnetNames.equals(that.subnetNames) : that.subnetNames != null) return false;
      if (virtualNetworkName != null ? !virtualNetworkName.equals(that.virtualNetworkName) : that.virtualNetworkName != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = super.hashCode();
      result = 31 * result + (virtualNetworkName != null ? virtualNetworkName.hashCode() : 0);
      result = 31 * result + (subnetNames != null ? subnetNames.hashCode() : 0);
      result = 31 * result + (storageAccountName != null ? storageAccountName.hashCode() : 0);
      result = 31 * result + (storageAccountType != null ? storageAccountType.hashCode() : 0);
      result = 31 * result + (networkSecurityGroupName != null ? networkSecurityGroupName.hashCode() : 0);
      result = 31 * result + (reservedIPName != null ? reservedIPName.hashCode() : 0);
      return result;
   }

   @Override
   public String toString() {
      return Objects.toStringHelper(this)
              .add("virtualNetworkName", virtualNetworkName)
              .add("subnetNames", subnetNames)
              .add("storageAccountName", storageAccountName)
              .add("storageAccountType", storageAccountType)
              .add("networkSecurityGroupName", networkSecurityGroupName)
              .add("reservedIPName", reservedIPName)
              .toString();
   }

   public DimensionDataComputeTemplateOptions virtualNetworkName(@Nullable String virtualNetworkName) {
      this.virtualNetworkName = virtualNetworkName;
      return this;
   }

   public DimensionDataComputeTemplateOptions subnetNames(Iterable<String> subnetNames) {
      this.subnetNames = ImmutableList.copyOf(checkNotNull(subnetNames, "subnetNames"));
      return this;
   }

   public DimensionDataComputeTemplateOptions subnetNames(String...subnetNames) {
      return subnetNames(ImmutableList.copyOf(checkNotNull(subnetNames, "subnetNames")));
   }


   public DimensionDataComputeTemplateOptions networkSecurityGroupName(@Nullable String networkSecurityGroupName) {
      this.networkSecurityGroupName = networkSecurityGroupName;
      return this;
   }

   public DimensionDataComputeTemplateOptions storageAccountName(@Nullable String storageAccountName) {
      this.storageAccountName = storageAccountName;
      return this;
   }

   public DimensionDataComputeTemplateOptions storageAccountType(@Nullable String storageAccountType) {
      this.storageAccountType = storageAccountType;
      return this;
   }

   public DimensionDataComputeTemplateOptions reservedIPName(@Nullable String reservedIPName) {
      this.reservedIPName = reservedIPName;
      return this;
   }

   public String getVirtualNetworkName() {
      return virtualNetworkName;
   }

   public List<String> getSubnetNames() {
      return subnetNames;
   }

   public String getStorageAccountName() {
      return storageAccountName;
   }

   public String getStorageAccountType() {
      return storageAccountType;
   }

   public String getNetworkSecurityGroupName() {
      return networkSecurityGroupName;
   }

   public String getReservedIPName() {
      return reservedIPName;
   }

   public static class Builder {

      /**
       * @see #virtualNetworkName
       */
      public static DimensionDataComputeTemplateOptions virtualNetworkName(final String virtualNetworkName) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.virtualNetworkName(virtualNetworkName);
      }

      /**
       * @see #subnetNames
       */
      public static DimensionDataComputeTemplateOptions subnetNames(String...subnetNames) {
         DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.subnetNames(subnetNames);
      }

      /**
       * @see #subnetNames
       */
      public static DimensionDataComputeTemplateOptions subnetNames(Iterable<String> subnetNames) {
         DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.subnetNames(subnetNames);
      }

      /**
       * @see #storageAccountName
       */
      public static DimensionDataComputeTemplateOptions storageAccountName(final String storageAccountName) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.storageAccountName(storageAccountName);
      }

      /**
       * @see #storageAccountType
       */
      public static DimensionDataComputeTemplateOptions storageAccountType(final String storageAccountType) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.storageAccountType(storageAccountType);
      }

      /**
       * @see org.jclouds.compute.options.TemplateOptions#inboundPorts(int...)
       */
      public static DimensionDataComputeTemplateOptions inboundPorts(final int... ports) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.inboundPorts(ports);
      }

      /**
       * @see org.jclouds.compute.options.TemplateOptions#blockOnPort(int, int)
       */
      public static DimensionDataComputeTemplateOptions blockOnPort(final int port, final int seconds) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.blockOnPort(port, seconds);
      }

      /**
       * @see org.jclouds.compute.options.TemplateOptions#userMetadata(Map)
       */
      public static DimensionDataComputeTemplateOptions userMetadata(final Map<String, String> userMetadata) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.userMetadata(userMetadata);
      }

      /**
       * @see org.jclouds.compute.options.TemplateOptions#userMetadata(String, String)
       */
      public static DimensionDataComputeTemplateOptions userMetadata(final String key, final String value) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.userMetadata(key, value);
      }

      /**
       * @see org.jclouds.compute.options.TemplateOptions#nodeNames(Iterable)
       */
      public static DimensionDataComputeTemplateOptions nodeNames(final Iterable<String> nodeNames) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.nodeNames(nodeNames);
      }

      /**
       * @see org.jclouds.compute.options.TemplateOptions#networks(Iterable)
       */
      public static DimensionDataComputeTemplateOptions networks(final Iterable<String> networks) {
         final DimensionDataComputeTemplateOptions options = new DimensionDataComputeTemplateOptions();
         return options.networks(networks);
      }
   }

   // methods that only facilitate returning the correct object type

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions blockOnPort(int port, int seconds) {
      return DimensionDataComputeTemplateOptions.class.cast(super.blockOnPort(port, seconds));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions inboundPorts(int... ports) {
      return DimensionDataComputeTemplateOptions.class.cast(super.inboundPorts(ports));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions authorizePublicKey(String publicKey) {
      return DimensionDataComputeTemplateOptions.class.cast(super.authorizePublicKey(publicKey));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions installPrivateKey(String privateKey) {
      return DimensionDataComputeTemplateOptions.class.cast(super.installPrivateKey(privateKey));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions blockUntilRunning(boolean blockUntilRunning) {
      return DimensionDataComputeTemplateOptions.class.cast(super.blockUntilRunning(blockUntilRunning));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions dontAuthorizePublicKey() {
      return DimensionDataComputeTemplateOptions.class.cast(super.dontAuthorizePublicKey());
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions nameTask(String name) {
      return DimensionDataComputeTemplateOptions.class.cast(super.nameTask(name));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions runAsRoot(boolean runAsRoot) {
      return DimensionDataComputeTemplateOptions.class.cast(super.runAsRoot(runAsRoot));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions runScript(Statement script) {
      return DimensionDataComputeTemplateOptions.class.cast(super.runScript(script));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions overrideLoginCredentials(LoginCredentials overridingCredentials) {
      return DimensionDataComputeTemplateOptions.class.cast(super.overrideLoginCredentials(overridingCredentials));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions overrideLoginPassword(String password) {
      return DimensionDataComputeTemplateOptions.class.cast(super.overrideLoginPassword(password));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions overrideLoginPrivateKey(String privateKey) {
      return DimensionDataComputeTemplateOptions.class.cast(super.overrideLoginPrivateKey(privateKey));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions overrideLoginUser(String loginUser) {
      return DimensionDataComputeTemplateOptions.class.cast(super.overrideLoginUser(loginUser));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions overrideAuthenticateSudo(boolean authenticateSudo) {
      return DimensionDataComputeTemplateOptions.class.cast(super.overrideAuthenticateSudo(authenticateSudo));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions userMetadata(Map<String, String> userMetadata) {
      return DimensionDataComputeTemplateOptions.class.cast(super.userMetadata(userMetadata));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions userMetadata(String key, String value) {
      return DimensionDataComputeTemplateOptions.class.cast(super.userMetadata(key, value));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions nodeNames(Iterable<String> nodeNames) {
      return DimensionDataComputeTemplateOptions.class.cast(super.nodeNames(nodeNames));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public DimensionDataComputeTemplateOptions networks(Iterable<String> networks) {
      return DimensionDataComputeTemplateOptions.class.cast(super.networks(networks));
   }

}
