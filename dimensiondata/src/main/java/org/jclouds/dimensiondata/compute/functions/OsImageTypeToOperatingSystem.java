package org.jclouds.dimensiondata.compute.functions;

import com.dimensiondata.cloud.client.model.OsImageType;
import com.google.common.base.Function;
import org.jclouds.compute.domain.OperatingSystem;
import org.jclouds.compute.domain.OsFamily;

public class OsImageTypeToOperatingSystem implements Function<OsImageType, OperatingSystem>
{
    @Override
    public OperatingSystem apply(OsImageType osImageType)
    {
//        OperatingSystem.Builder builder = defaultOperatingSystem(osImageType.getOsImageKey());
//            builder.family(OsFamily.fromValue());
//        builder.description(osImageType.getDescription()).name(osImageType.getName()).version(osImageType.)
//
//        return builder.build();  //TODO Implement this method
        return null;
    }

    private OperatingSystem.Builder defaultOperatingSystem(String name)
    {
        return OperatingSystem.builder().family(OsFamily.LINUX).is64Bit(true).description(name);
    }
}
