package org.jclouds.dimensiondata.compute.functions;

import com.dimensiondata.cloud.client.model.OsImageType;
import com.google.common.base.Function;
import org.jclouds.compute.domain.Image;
import org.jclouds.compute.domain.ImageBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class OsImageTypeToImage implements Function<OsImageType, Image>
{


    public OsImageTypeToImage()
    {
    }

    @Override
    public Image apply(OsImageType osImageType)
    {
        URI uri = null;
        try
        {
            uri = new URI("www.google.com");
            ImageBuilder builder = new ImageBuilder()
                    .id(osImageType.getId())
                    .providerId(osImageType.getId())
                    .name(osImageType.getName())
                    .description(osImageType.getDescription())
                    .status(Image.Status.AVAILABLE)
                    .uri(uri);
            return builder.build();
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();  //TODO - remove
        }
        return null;
    }
}
