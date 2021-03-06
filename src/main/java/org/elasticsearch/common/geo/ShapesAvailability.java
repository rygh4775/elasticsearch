/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.common.geo;

import com.spatial4j.core.shape.impl.PointImpl;
import com.vividsolutions.jts.geom.GeometryFactory;

/**
 */
public class ShapesAvailability {

    public static final boolean SPATIAL4J_AVAILABLE;
    public static final boolean JTS_AVAILABLE;

    static {
        boolean xSPATIAL4J_AVAILABLE;
        try {
            new PointImpl(0, 0, GeoShapeConstants.SPATIAL_CONTEXT);
            xSPATIAL4J_AVAILABLE = true;
        } catch (Throwable t) {
            xSPATIAL4J_AVAILABLE = false;
        }
        SPATIAL4J_AVAILABLE = xSPATIAL4J_AVAILABLE;

        boolean xJTS_AVAILABLE;
        try {
            new GeometryFactory();
            xJTS_AVAILABLE = true;
        } catch (Throwable t) {
            xJTS_AVAILABLE = false;
        }
        JTS_AVAILABLE = xJTS_AVAILABLE;
    }


    private ShapesAvailability() {

    }
}
