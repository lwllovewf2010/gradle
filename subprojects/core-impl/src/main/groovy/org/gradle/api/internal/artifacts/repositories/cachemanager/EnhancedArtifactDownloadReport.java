/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.artifacts.repositories.cachemanager;

import org.apache.ivy.core.cache.ArtifactOrigin;
import org.apache.ivy.core.module.descriptor.Artifact;
import org.apache.ivy.core.report.ArtifactDownloadReport;
import org.apache.ivy.core.report.DownloadStatus;
import org.gradle.api.internal.artifacts.ivyservice.ivyresolve.ArtifactOriginWithMetaData;

public class EnhancedArtifactDownloadReport extends ArtifactDownloadReport {
    private Throwable failure;
    private ArtifactOriginWithMetaData artifactOrigin;

    public EnhancedArtifactDownloadReport(Artifact artifact) {
        super(artifact);
    }

    public Throwable getFailure() {
        return failure;
    }

    @Override
    public ArtifactOriginWithMetaData getArtifactOrigin() {
        return artifactOrigin;
    }

    @Override
    public void setArtifactOrigin(ArtifactOrigin origin) {
        if (origin instanceof ArtifactOriginWithMetaData) {
            artifactOrigin = (ArtifactOriginWithMetaData) origin;
            super.setArtifactOrigin(origin);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void failed(Throwable throwable) {
        setDownloadStatus(DownloadStatus.FAILED);
        setDownloadDetails(throwable.getMessage());
        failure = throwable;
    }
}