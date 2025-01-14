/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.agent.constant;

/**
 * k8s information
 */
public class KubernetesConstants {

    public static final String HTTPS = "https://";
    public static final String KUBERNETES_SERVICE_HOST = "KUBERNETES_SERVICE_HOST";
    public static final String KUBERNETES_SERVICE_PORT = "KUBERNETES_SERVICE_PORT";

    // k8s information
    public static final String NAMESPACE = "namespace";
    public static final String POD_NAME = "pod.name";
    public static final String CONTAINER_NAME = "container.name";
    public static final String CONTAINER_ID = "container.id";

    // k8s metadata
    public static final String METADATA_CONTAINER_ID = "_container_id_";
    public static final String METADATA_CONTAINER_NAME = "_container_name_";
    public static final String METADATA_NAMESPACE = "_namespace_";
    public static final String METADATA_POD_UID = "_pod_uid_";
    public static final String METADATA_POD_NAME = "_pod_name_";
    public static final String METADATA_POD_LABEL = "_pod_label_";
    public static final String DATA_CONTENT = "_content_";
    public static final String DATA_CONTENT_TIME = "_time_";


}
