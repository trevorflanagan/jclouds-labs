package org.jclouds.dimensiondata;

import org.jclouds.ContextBuilder;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.compute.domain.ComputeMetadata;
import org.jclouds.domain.Location;
import org.jclouds.providers.ProviderMetadata;

import java.util.Set;

public class DimensionDataCloud
{
    public static void main(String[] args)
    {
        ProviderMetadata metadata = new DimensionDataProviderMetadata();
        ComputeServiceContext context = ContextBuilder.newBuilder(metadata)
                .credentials("seeded-test-user-1","Password1").buildView(ComputeServiceContext.class);
        Set<? extends ComputeMetadata> computeMetadatas = context.getComputeService().listNodes();
        context.getComputeService().listAssignableLocations()
    }
}
