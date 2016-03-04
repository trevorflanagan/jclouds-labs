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
package org.jclouds.dimensiondata.compute;

import com.dimensiondata.cloud.client.*;
import com.dimensiondata.cloud.client.http.CloudImpl;
import com.dimensiondata.cloud.client.model.*;
import org.jclouds.compute.ComputeServiceAdapter;
import org.jclouds.compute.domain.Template;
import org.jclouds.compute.reference.ComputeServiceConstants;
import org.jclouds.dimensiondata.compute.options.DimensionDataTemplateOptions;
import org.jclouds.logging.Logger;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Defines the connection between the {@link Cloud} implementation and the jclouds
 * {@link org.jclouds.compute.ComputeService}.
 */
@Singleton
public class DimesionDataComputeServiceAdapter implements ComputeServiceAdapter<NodeType, CustomerImageType, OsImageType, DatacenterType>
{


    @Resource
    @Named(ComputeServiceConstants.COMPUTE_LOGGER)
    private Logger logger = Logger.NULL;

    private final Cloud cloudApi;

    DimesionDataComputeServiceAdapter()
    {
        UserSession.set(new User("seeded-org-id-1", "seeded-test-user-1", "Password1!"));
        this.cloudApi = new CloudImpl("http://localhost:8081/oec");
    }


    @Override
    public NodeAndInitialCredentials<NodeType> createNodeWithGroupEncodedIntoName(String group, String name, Template template)
    {
        DimensionDataTemplateOptions options = DimensionDataTemplateOptions.class.cast(template.getOptions());

        return null;  //TODO Implement this method
    }

    @Override
    public Iterable<CustomerImageType> listHardwareProfiles()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<OsImageType> listImages()
    {
        return cloudApi.image().listOsImages(100, 100, OrderBy.EMPTY).getOsImage();
    }

    @Override
    public OsImageType getImage(String id)
    {
        return cloudApi.image().getOsImage(id);
    }

    @Override
    public Iterable<DatacenterType> listLocations()
    {
        return cloudApi.datacenter().listDatacenters(100,100,OrderBy.EMPTY).getDatacenter();
    }

    @Override
    public NodeType getNode(String id)
    {
        return cloudApi.node().getNode(id);
    }

    @Override
    public void destroyNode(String id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void rebootNode(String id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void resumeNode(String id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void suspendNode(String id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<NodeType> listNodes()
    {
        Nodes nodes = cloudApi.node().listNodes(100, 100, OrderBy.EMPTY, Filter.EMPTY);
        return nodes.getNode();
    }

    @Override
    public Iterable<NodeType> listNodesByIds(Iterable<String> ids)
    {
        throw new UnsupportedOperationException();
    }
}
