/*
 * Copyright 2013 the original author or authors.
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

package org.gradle.api.file;

import org.gradle.api.Incubating;

/**
 * Strategies for dealing with the potential creation of duplicate files for or archive entries.
 */
@Incubating
public enum DuplicatesStrategy {

    /**
     * Do not attempt to prevent duplicates.
     * <p>
     * If the destination of the operation supports duplicates (e.g. zip files) then a duplicate entry will be created.
     * If the destination does not support duplicates, the existing destination entry will be overridden with the duplicate.
     */
    INCLUDE,

    /**
     * Do not allow duplicates by ignoring subsequent items to be created at the same path.
     * <p>
     * If an attempt is made to create a duplicate file/entry during an operation, ignore the item.
     * This will leave the file/entry that was first copied/created in place.
     */
    EXCLUDE

}
