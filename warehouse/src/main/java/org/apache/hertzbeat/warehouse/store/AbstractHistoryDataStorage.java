/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hertzbeat.warehouse.store;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.hertzbeat.common.entity.dto.Value;
import org.apache.hertzbeat.common.entity.message.CollectRep;
import org.springframework.beans.factory.DisposableBean;

/**
 * data storage abstract class
 */
@Slf4j
public abstract class AbstractHistoryDataStorage implements DisposableBean {
    protected boolean serverAvailable;

    /**
     * @return data storage available
     */
    public boolean isServerAvailable() {
        return serverAvailable;
    }

    /**
     * save metrics data
     * @param metricsData metrics data
     */
    abstract void saveData(CollectRep.MetricsData metricsData);

    /**
     * query history range metrics data from tsdb
     * @param monitorId monitor id
     * @param app monitor type
     * @param metrics metrics
     * @param metric metric
     * @param label label
     * @param history range
     * @return metrics data
     */
    public abstract Map<String, List<Value>> getHistoryMetricData(
            Long monitorId, String app, String metrics, String metric, String label, String history);

    /**
     * query history range interval metrics data from tsdb
     * max min mean metrics value
     * @param monitorId monitor id
     * @param app monitor type
     * @param metrics metrics
     * @param metric metric
     * @param label label
     * @param history history range
     * @return metrics data
     */
    public abstract Map<String, List<Value>> getHistoryIntervalMetricData(
            Long monitorId, String app, String metrics, String metric, String label, String history);
}
