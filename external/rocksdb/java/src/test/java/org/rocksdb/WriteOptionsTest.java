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

public class WriteOptionsTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Test
<<<<<<< HEAD
  public void writeOptions(){
    WriteOptions writeOptions = new WriteOptions();
    writeOptions.setDisableWAL(true);
    assertThat(writeOptions.disableWAL()).isTrue();
    writeOptions.setDisableWAL(false);
    assertThat(writeOptions.disableWAL()).isFalse();
    writeOptions.setSync(true);
    assertThat(writeOptions.sync()).isTrue();
    writeOptions.setSync(false);
    assertThat(writeOptions.sync()).isFalse();
=======
  public void writeOptions() {
    try (final WriteOptions writeOptions = new WriteOptions()) {
      writeOptions.setDisableWAL(true);
      assertThat(writeOptions.disableWAL()).isTrue();
      writeOptions.setDisableWAL(false);
      assertThat(writeOptions.disableWAL()).isFalse();
      writeOptions.setSync(true);
      assertThat(writeOptions.sync()).isTrue();
      writeOptions.setSync(false);
      assertThat(writeOptions.sync()).isFalse();
    }
>>>>>>> forknote/master
  }
}
