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
package org.jclouds.dimensiondata;

import org.jclouds.providers.ProviderMetadata;
import org.jclouds.providers.internal.BaseProviderMetadata;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.util.Properties;

@Repository
public class DimensionDataProviderMetadata extends BaseProviderMetadata
{

    public static Builder builder()
    {
        return new Builder();
    }

    @Override
    public Builder toBuilder()
    {
        return builder().fromProviderMetadata(this);
    }

    public DimensionDataProviderMetadata()
    {
        super(builder());
    }

    public static Properties defaultProperties()
    {
        return new Properties();
    }

    public DimensionDataProviderMetadata(final Builder builder)
    {
        super(builder);
    }

    public static class Builder extends BaseProviderMetadata.Builder
    {

        protected Builder()
        {
            super();

            id("dimensiondata")
                    .name("Dimension Data Cloud Control Service Api")
                    .apiMetadata(new DimensionDataApiMetadata())
                    .endpoint("http://localhost:8081/oec")
                    .homepage(URI.create("http://localhost:8081/"))
                    .console(URI.create("http://localhost:8081/"))
                    .linkedService("dimensiondata")
                    .defaultProperties(DimensionDataProviderMetadata.defaultProperties());
        }

        @Override
        public DimensionDataProviderMetadata build()
        {
            return new DimensionDataProviderMetadata(this);
        }

        @Override
        public Builder fromProviderMetadata(final ProviderMetadata providerMetadata)
        {
            super.fromProviderMetadata(providerMetadata);
            return this;
        }
    }
}
