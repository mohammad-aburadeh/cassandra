package org.apache.cassandra.service;
/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

import java.util.concurrent.TimeoutException;

import org.apache.cassandra.concurrent.CreationTimeAwareFuture;
import org.apache.cassandra.net.IAsyncCallback;
import org.apache.cassandra.thrift.UnavailableException;

public interface IWriteResponseHandler extends IAsyncCallback
{
    public void get() throws TimeoutException;
    public void assureSufficientLiveNodes() throws UnavailableException;
    
    /**
     * Set a callback to be called when the write is successful.
     * Note that the callback will *not* be called in case of an exception (timeout or unavailable).
     * Also, the callback should be set before any response() call, otherwise
     * there is no guarantee it will ever be called.
     * Successive calls to this method will override the previous callback by the new one.
     */    
    public void setCallback(Runnable callback);
}
