package org.jclouds.dimensiondata.compute.functions;

import com.dimensiondata.cloud.client.model.CustomerImageType;
import com.google.common.base.Function;
import org.jclouds.compute.domain.Hardware;

public class CustomerImageTypeToHardware implements Function<CustomerImageType,Hardware>
{
    @Override
    public Hardware apply(CustomerImageType customerImageType)
    {
        return null;  //TODO Implement this method
    }
}
