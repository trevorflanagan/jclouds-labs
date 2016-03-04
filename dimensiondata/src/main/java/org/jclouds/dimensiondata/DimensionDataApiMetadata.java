package org.jclouds.dimensiondata;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.dimensiondata.compute.config.DimensionDataComputeServiceContextModule;
import org.jclouds.rest.internal.BaseHttpApiMetadata;

import java.net.URI;

import static org.jclouds.reflect.Reflection2.typeToken;

public class DimensionDataApiMetadata extends BaseHttpApiMetadata<DimensionDataApi>
{

    @Override
    public Builder toBuilder()
    {
        return new Builder().fromApiMetadata(this);
    }

    protected DimensionDataApiMetadata(Builder builder)
    {
        super(builder);
    }

    public DimensionDataApiMetadata()
    {
        this(new Builder());
    }

    public static class Builder extends BaseHttpApiMetadata.Builder<DimensionDataApi, Builder>
    {

        protected Builder()
        {
            id("dimensiondata")
                    .name("Dimension Data Cloud Control Service Api")
                    .version("v1")
                    .identityName("IdentityName")
                    .documentation(URI.create("https://dimensiondata.com/docs"))
                    .defaultProperties(DimensionDataApiMetadata.defaultProperties())
                    .view(typeToken(ComputeServiceContext.class))
                    .defaultModules(ImmutableSet.<Class<? extends Module>>builder()
                            .add(DimensionDataComputeServiceContextModule.class)
                            .build());
        }

        @Override
        public DimensionDataApiMetadata build()
        {
            return new DimensionDataApiMetadata(this);
        }

        @Override
        protected Builder self()
        {
            return this;
        }
    }
}
