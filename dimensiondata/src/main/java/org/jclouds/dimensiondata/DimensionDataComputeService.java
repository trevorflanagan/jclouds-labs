package org.jclouds.dimensiondata;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListeningExecutorService;
import org.jclouds.Constants;
import org.jclouds.collect.Memoized;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.compute.callables.RunScriptOnNode;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.Image;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.TemplateBuilder;
import org.jclouds.compute.extensions.ImageExtension;
import org.jclouds.compute.extensions.SecurityGroupExtension;
import org.jclouds.compute.internal.BaseComputeService;
import org.jclouds.compute.internal.PersistNodeCredentials;
import org.jclouds.compute.options.TemplateOptions;
import org.jclouds.compute.reference.ComputeServiceConstants;
import org.jclouds.compute.strategy.*;
import org.jclouds.dimensiondata.compute.options.DimensionDataTemplateOptions;
import org.jclouds.domain.Credentials;
import org.jclouds.domain.Location;
import org.jclouds.scriptbuilder.functions.InitAdminAccess;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import static org.jclouds.compute.config.ComputeServiceProperties.*;

@Singleton
public class DimensionDataComputeService extends BaseComputeService
{
    @Inject
    protected DimensionDataComputeService(
            ComputeServiceContext context,
            Map<String, Credentials> credentialStore,
            @Memoized Supplier<Set<? extends Image>> images,
            @Memoized Supplier<Set<? extends Hardware>> hardwareProfiles,
            @Memoized Supplier<Set<? extends Location>> locations,
            ListNodesStrategy listNodesStrategy,
            GetImageStrategy getImageStrategy,
            GetNodeMetadataStrategy getNodeMetadataStrategy,
            CreateNodesInGroupThenAddToSet runNodesAndAddToSetStrategy,
            RebootNodeStrategy rebootNodeStrategy,
            DestroyNodeStrategy destroyNodeStrategy,
            ResumeNodeStrategy resumeNodeStrategy,
            SuspendNodeStrategy suspendNodeStrategy,
            Provider<TemplateBuilder> templateBuilderProvider,
            @Named("DEFAULT") Provider<TemplateOptions> templateOptionsProvider,
            @Named(TIMEOUT_NODE_RUNNING) Predicate<AtomicReference<NodeMetadata>> nodeRunning,
            @Named(TIMEOUT_NODE_TERMINATED) Predicate<AtomicReference<NodeMetadata>> nodeTerminated,
            @Named(TIMEOUT_NODE_SUSPENDED) Predicate<AtomicReference<NodeMetadata>> nodeSuspended,
            InitializeRunScriptOnNodeOrPlaceInBadMap.Factory initScriptRunnerFactory,
            InitAdminAccess initAdminAccess,
            RunScriptOnNode.Factory runScriptOnNodeFactory,
            PersistNodeCredentials persistNodeCredentials,
            ComputeServiceConstants.Timeouts timeouts,
            @Named(Constants.PROPERTY_USER_THREADS) ListeningExecutorService userExecutor,
            Optional<ImageExtension> imageExtension,
            Optional<SecurityGroupExtension> securityGroupExtension)
    {
        super(context, credentialStore, images, hardwareProfiles, locations, listNodesStrategy, getImageStrategy, getNodeMetadataStrategy, runNodesAndAddToSetStrategy, rebootNodeStrategy, destroyNodeStrategy, resumeNodeStrategy, suspendNodeStrategy, templateBuilderProvider, templateOptionsProvider, nodeRunning, nodeTerminated, nodeSuspended, initScriptRunnerFactory, initAdminAccess, runScriptOnNodeFactory, persistNodeCredentials, timeouts, userExecutor, imageExtension, securityGroupExtension);
    }

    @Override
    public DimensionDataTemplateOptions templateOptions()
    {
        return DimensionDataTemplateOptions.class.cast(super.templateOptions());
    }
}
