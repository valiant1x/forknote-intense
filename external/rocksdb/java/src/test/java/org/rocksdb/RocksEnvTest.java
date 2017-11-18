<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RocksEnvTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Test
<<<<<<< HEAD
  public void rocksEnv(){
    Env rocksEnv = RocksEnv.getDefault();
    rocksEnv.setBackgroundThreads(5);
    // default rocksenv will always return zero for flush pool
    // no matter what was set via setBackgroundThreads
    assertThat(rocksEnv.getThreadPoolQueueLen(RocksEnv.FLUSH_POOL)).
        isEqualTo(0);
    rocksEnv.setBackgroundThreads(5, RocksEnv.FLUSH_POOL);
    // default rocksenv will always return zero for flush pool
    // no matter what was set via setBackgroundThreads
    assertThat(rocksEnv.getThreadPoolQueueLen(RocksEnv.FLUSH_POOL)).
        isEqualTo(0);
    rocksEnv.setBackgroundThreads(5, RocksEnv.COMPACTION_POOL);
    // default rocksenv will always return zero for compaction pool
    // no matter what was set via setBackgroundThreads
    assertThat(rocksEnv.getThreadPoolQueueLen(RocksEnv.COMPACTION_POOL)).
        isEqualTo(0);
=======
  public void rocksEnv() {
    try (final Env rocksEnv = RocksEnv.getDefault()) {
      rocksEnv.setBackgroundThreads(5);
      // default rocksenv will always return zero for flush pool
      // no matter what was set via setBackgroundThreads
      assertThat(rocksEnv.getThreadPoolQueueLen(RocksEnv.FLUSH_POOL)).
          isEqualTo(0);
      rocksEnv.setBackgroundThreads(5, RocksEnv.FLUSH_POOL);
      // default rocksenv will always return zero for flush pool
      // no matter what was set via setBackgroundThreads
      assertThat(rocksEnv.getThreadPoolQueueLen(RocksEnv.FLUSH_POOL)).
          isEqualTo(0);
      rocksEnv.setBackgroundThreads(5, RocksEnv.COMPACTION_POOL);
      // default rocksenv will always return zero for compaction pool
      // no matter what was set via setBackgroundThreads
      assertThat(rocksEnv.getThreadPoolQueueLen(RocksEnv.COMPACTION_POOL)).
          isEqualTo(0);
    }
>>>>>>> forknote/master
  }
}
