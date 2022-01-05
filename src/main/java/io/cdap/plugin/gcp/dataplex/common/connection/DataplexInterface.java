/*
 * Copyright © 2021 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.plugin.gcp.dataplex.common.connection;

import com.google.auth.oauth2.GoogleCredentials;
import io.cdap.plugin.gcp.dataplex.common.exception.DataplexException;
import io.cdap.plugin.gcp.dataplex.common.model.Asset;
import io.cdap.plugin.gcp.dataplex.common.model.Entity;
import io.cdap.plugin.gcp.dataplex.common.model.Job;
import io.cdap.plugin.gcp.dataplex.common.model.Lake;
import io.cdap.plugin.gcp.dataplex.common.model.Location;
import io.cdap.plugin.gcp.dataplex.common.model.Task;
import io.cdap.plugin.gcp.dataplex.common.model.Zone;

import java.util.List;

/**
 * Exposes the APIs to connect with and execute programs in Dataplex
 */
public interface DataplexInterface {

    List<Location> listLocations(GoogleCredentials credentials, String projectId) throws DataplexException;

    Location getLocation(GoogleCredentials credentials, String projectId, String location) throws DataplexException;

    List<Lake> listLakes(GoogleCredentials credentials, String projectId,
                         String location) throws DataplexException;

    Lake getLake(GoogleCredentials credentials, String projectId, String location, String lakeId)
      throws DataplexException;

    List<Zone> listZones(GoogleCredentials credentials, String projectId,
                         String location, String lakeId) throws DataplexException;

    Zone getZone(GoogleCredentials credentials, String projectId, String location, String lakeId, String zoneId)
      throws DataplexException;

    List<Asset> listAssets(GoogleCredentials credentials, String projectId,
                           String location, String lakeId, String zoneId) throws DataplexException;

    Asset getAsset(GoogleCredentials credentials, String projectId,
                   String location, String lakeId, String zoneId, String assetId) throws DataplexException;

    List<Entity> listEntities(GoogleCredentials credentials, String projectId,
                              String location, String lakeId, String zoneId) throws DataplexException;

    Entity getEntity(GoogleCredentials credentials, String projectId,
                     String location, String lakeId, String zoneId, String entityId) throws DataplexException;

    String createTask(GoogleCredentials credentials, String projectId,
                      String location, String lakeId, Task task) throws DataplexException;

    Task getTasks(GoogleCredentials credentials, String projectId,
                  String location, String lakeId, String taskId) throws DataplexException;

    List<Job> listJobs(GoogleCredentials credentials, String projectId,
                       String location, String lakeId, String taskId) throws DataplexException;

    boolean isJobCreated(GoogleCredentials credentials, String projectId,
                         String location, String lakeId, String taskId) throws DataplexException;

    Job getJob(GoogleCredentials credentials, String projectId,
               String location, String lakeId, String taskId, String jobId) throws DataplexException;
}
