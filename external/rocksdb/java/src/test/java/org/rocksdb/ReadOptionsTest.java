<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

import java.util.Random;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadOptionsTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
<<<<<<< HEAD
  public void verifyChecksum(){
    ReadOptions opt = null;
    try {
      opt = new ReadOptions();
      Random rand = new Random();
      boolean boolValue = rand.nextBoolean();
      opt.setVerifyChecksums(boolValue);
      assertThat(opt.verifyChecksums()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
  public void verifyChecksum() {
    try (final ReadOptions opt = new ReadOptions()) {
      final Random rand = new Random();
      final boolean boolValue = rand.nextBoolean();
      opt.setVerifyChecksums(boolValue);
      assertThat(opt.verifyChecksums()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
  public void fillCache(){
    ReadOptions opt = null;
    try {
      opt = new ReadOptions();
      Random rand = new Random();
      boolean boolValue = rand.nextBoolean();
      opt.setFillCache(boolValue);
      assertThat(opt.fillCache()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
  public void fillCache() {
    try (final ReadOptions opt = new ReadOptions()) {
      final Random rand = new Random();
      final boolean boolValue = rand.nextBoolean();
      opt.setFillCache(boolValue);
      assertThat(opt.fillCache()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
  public void tailing(){
    ReadOptions opt = null;
    try {
      opt = new ReadOptions();
      Random rand = new Random();
      boolean boolValue = rand.nextBoolean();
      opt.setTailing(boolValue);
      assertThat(opt.tailing()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
  public void tailing() {
    try (final ReadOptions opt = new ReadOptions()) {
      final Random rand = new Random();
      final boolean boolValue = rand.nextBoolean();
      opt.setTailing(boolValue);
      assertThat(opt.tailing()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
  public void snapshot(){
    ReadOptions opt = null;
    try {
      opt = new ReadOptions();
      opt.setSnapshot(null);
      assertThat(opt.snapshot()).isNull();
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
  public void snapshot() {
    try (final ReadOptions opt = new ReadOptions()) {
      opt.setSnapshot(null);
      assertThat(opt.snapshot()).isNull();
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
  public void failSetVerifyChecksumUninitialized(){
    ReadOptions readOptions = setupUninitializedReadOptions(
        exception);
    readOptions.setVerifyChecksums(true);
  }

  @Test
  public void failVerifyChecksumUninitialized(){
    ReadOptions readOptions = setupUninitializedReadOptions(
        exception);
    readOptions.verifyChecksums();
  }

  @Test
  public void failSetFillCacheUninitialized(){
    ReadOptions readOptions = setupUninitializedReadOptions(
        exception);
    readOptions.setFillCache(true);
  }

  @Test
  public void failFillCacheUninitialized(){
    ReadOptions readOptions = setupUninitializedReadOptions(
        exception);
    readOptions.fillCache();
  }

  @Test
  public void failSetTailingUninitialized(){
    ReadOptions readOptions = setupUninitializedReadOptions(
        exception);
    readOptions.setTailing(true);
  }

  @Test
  public void failTailingUninitialized(){
    ReadOptions readOptions = setupUninitializedReadOptions(
        exception);
    readOptions.tailing();
  }

  @Test
  public void failSetSnapshotUninitialized(){
    ReadOptions readOptions = setupUninitializedReadOptions(
        exception);
    readOptions.setSnapshot(null);
  }

  @Test
  public void failSnapshotUninitialized(){
    ReadOptions readOptions = setupUninitializedReadOptions(
        exception);
    readOptions.snapshot();
=======
  public void readTier() {
    try (final ReadOptions opt = new ReadOptions()) {
      opt.setReadTier(ReadTier.BLOCK_CACHE_TIER);
      assertThat(opt.readTier()).isEqualTo(ReadTier.BLOCK_CACHE_TIER);
    }
  }

  @Test
  public void managed() {
    try (final ReadOptions opt = new ReadOptions()) {
      opt.setManaged(true);
      assertThat(opt.managed()).isTrue();
    }
  }

  @Test
  public void totalOrderSeek() {
    try (final ReadOptions opt = new ReadOptions()) {
      opt.setTotalOrderSeek(true);
      assertThat(opt.totalOrderSeek()).isTrue();
    }
  }

  @Test
  public void prefixSameAsStart() {
    try (final ReadOptions opt = new ReadOptions()) {
      opt.setPrefixSameAsStart(true);
      assertThat(opt.prefixSameAsStart()).isTrue();
    }
  }

  @Test
  public void pinData() {
    try (final ReadOptions opt = new ReadOptions()) {
      opt.setPinData(true);
      assertThat(opt.pinData()).isTrue();
    }
  }

  @Test
  public void failSetVerifyChecksumUninitialized() {
    try (final ReadOptions readOptions =
             setupUninitializedReadOptions(exception)) {
      readOptions.setVerifyChecksums(true);
    }
  }

  @Test
  public void failVerifyChecksumUninitialized() {
    try (final ReadOptions readOptions =
             setupUninitializedReadOptions(exception)) {
      readOptions.verifyChecksums();
    }
  }

  @Test
  public void failSetFillCacheUninitialized() {
    try (final ReadOptions readOptions =
             setupUninitializedReadOptions(exception)) {
      readOptions.setFillCache(true);
    }
  }

  @Test
  public void failFillCacheUninitialized() {
    try (final ReadOptions readOptions =
             setupUninitializedReadOptions(exception)) {
      readOptions.fillCache();
    }
  }

  @Test
  public void failSetTailingUninitialized() {
    try (final ReadOptions readOptions =
             setupUninitializedReadOptions(exception)) {
      readOptions.setTailing(true);
    }
  }

  @Test
  public void failTailingUninitialized() {
    try (final ReadOptions readOptions =
             setupUninitializedReadOptions(exception)) {
      readOptions.tailing();
    }
  }

  @Test
  public void failSetSnapshotUninitialized() {
    try (final ReadOptions readOptions =
             setupUninitializedReadOptions(exception)) {
      readOptions.setSnapshot(null);
    }
  }

  @Test
  public void failSnapshotUninitialized() {
    try (final ReadOptions readOptions =
             setupUninitializedReadOptions(exception)) {
      readOptions.snapshot();
    }
>>>>>>> forknote/master
  }

  private ReadOptions setupUninitializedReadOptions(
      ExpectedException exception) {
<<<<<<< HEAD
    ReadOptions readOptions = new ReadOptions();
    readOptions.dispose();
=======
    final ReadOptions readOptions = new ReadOptions();
    readOptions.close();
>>>>>>> forknote/master
    exception.expect(AssertionError.class);
    return readOptions;
  }
}
