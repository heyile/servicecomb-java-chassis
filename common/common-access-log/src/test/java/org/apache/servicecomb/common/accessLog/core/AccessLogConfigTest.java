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

package org.apache.servicecomb.common.accessLog.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.apache.servicecomb.common.accessLog.AccessLogConfig;
import org.junit.Test;

public class AccessLogConfigTest {

  @Test
  public void getAccessLogEnabled() {
    boolean serverEnabled = AccessLogConfig.INSTANCE.isServerLogEnabled();
    boolean clientEnabled = AccessLogConfig.INSTANCE.isClientLogEnabled();
    assertFalse(serverEnabled);
    assertFalse(clientEnabled);
  }

  @Test
  public void getAccesslogPattern() {
    String clientLogPattern = AccessLogConfig.INSTANCE.getClientLogPattern();
    String serverLogPattern = AccessLogConfig.INSTANCE.getServerLogPattern();

    assertEquals("%h - - %t %r %s %B %D", serverLogPattern);
    assertEquals("%h %SCB-transport - - %t %r %s %D", clientLogPattern);
  }
}
