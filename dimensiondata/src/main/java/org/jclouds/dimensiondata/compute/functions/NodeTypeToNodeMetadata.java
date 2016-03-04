package org.jclouds.dimensiondata.compute.functions;

import com.dimensiondata.cloud.client.model.NodeType;
import com.google.common.base.Function;
import org.jclouds.compute.domain.NodeMetadata;

public class NodeTypeToNodeMetadata implements Function<NodeType, NodeMetadata>
{
    @Override
    public NodeMetadata apply(NodeType nodeType)
    {
        return null;  //TODO Implement this method
    }
}
