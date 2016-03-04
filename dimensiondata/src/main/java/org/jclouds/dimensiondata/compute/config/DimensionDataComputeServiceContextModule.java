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
package org.jclouds.dimensiondata.compute.config;

import com.dimensiondata.cloud.client.model.CustomerImageType;
import com.dimensiondata.cloud.client.model.DatacenterType;
import com.dimensiondata.cloud.client.model.NodeType;
import com.dimensiondata.cloud.client.model.OsImageType;
import com.google.common.base.Function;
import com.google.inject.TypeLiteral;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.ComputeServiceAdapter;
import org.jclouds.compute.config.ComputeServiceAdapterContextModule;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.Image;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.OperatingSystem;
import org.jclouds.compute.options.TemplateOptions;
import org.jclouds.dimensiondata.DimensionDataComputeService;
import org.jclouds.dimensiondata.compute.DimesionDataComputeServiceAdapter;
import org.jclouds.dimensiondata.compute.functions.*;
import org.jclouds.dimensiondata.compute.options.DimensionDataTemplateOptions;
import org.jclouds.domain.Location;

public class DimensionDataComputeServiceContextModule
        extends ComputeServiceAdapterContextModule<NodeType, CustomerImageType, OsImageType, DatacenterType>
{

    @Override
    protected void configure()
    {
        super.configure();

        bind(ComputeService.class).to(DimensionDataComputeService.class);

        bind(new TypeLiteral<ComputeServiceAdapter<NodeType, CustomerImageType, OsImageType, DatacenterType>>()
        {
        }).to(DimesionDataComputeServiceAdapter.class);

        // Use compute service to supply locations, which are always zones.
        install(new LocationsFromComputeServiceAdapterModule<NodeType, CustomerImageType, OsImageType, DatacenterType>()
        {
        });

        bind(new TypeLiteral<Function<OsImageType, Image>>()
        {
        }).to(OsImageTypeToImage.class);

        bind(new TypeLiteral<Function<CustomerImageType, Hardware>>()
        {
        }).to(CustomerImageTypeToHardware.class);

        bind(new TypeLiteral<Function<OsImageType, OperatingSystem>>()
        {
        }).to(OsImageTypeToOperatingSystem.class);

        bind(new TypeLiteral<Function<NodeType, NodeMetadata>>()
        {
        }).to(NodeTypeToNodeMetadata.class);

        bind(new TypeLiteral<Function<DatacenterType, Location>>()
        {
        }).to(DatacenterTypeToLocation.class);


        bind(TemplateOptions.class).to(DimensionDataTemplateOptions.class);


    }

}
