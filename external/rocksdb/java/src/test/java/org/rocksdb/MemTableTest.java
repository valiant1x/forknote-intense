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

public class MemTableTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Test
  public void hashSkipListMemTable() throws RocksDBException {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
=======
    try(final Options options = new Options()) {
>>>>>>> forknote/master
      // Test HashSkipListMemTableConfig
      HashSkipListMemTableConfig memTableConfig =
          new HashSkipListMemTableConfig();
      assertThat(memTableConfig.bucketCount()).
          isEqualTo(1000000);
      memTableConfig.setBucketCount(2000000);
      assertThat(memTableConfig.bucketCount()).
          isEqualTo(2000000);
      assertThat(memTableConfig.height()).
          isEqualTo(4);
      memTableConfig.setHeight(5);
      assertThat(memTableConfig.height()).
          isEqualTo(5);
      assertThat(memTableConfig.branchingFactor()).
          isEqualTo(4);
      memTableConfig.setBranchingFactor(6);
      assertThat(memTableConfig.branchingFactor()).
          isEqualTo(6);
      options.setMemTableConfig(memTableConfig);
<<<<<<< HEAD
    } finally {
      if (options != null) {
        options.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void skipListMemTable() throws RocksDBException {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
=======
    try(final Options options = new Options()) {
>>>>>>> forknote/master
      SkipListMemTableConfig skipMemTableConfig =
          new SkipListMemTableConfig();
      assertThat(skipMemTableConfig.lookahead()).
          isEqualTo(0);
      skipMemTableConfig.setLookahead(20);
      assertThat(skipMemTableConfig.lookahead()).
          isEqualTo(20);
      options.setMemTableConfig(skipMemTableConfig);
<<<<<<< HEAD
      options.dispose();
    } finally {
      if (options != null) {
        options.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void hashLinkedListMemTable() throws RocksDBException {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
=======
    try(final Options options = new Options()) {
>>>>>>> forknote/master
      HashLinkedListMemTableConfig hashLinkedListMemTableConfig =
          new HashLinkedListMemTableConfig();
      assertThat(hashLinkedListMemTableConfig.bucketCount()).
          isEqualTo(50000);
      hashLinkedListMemTableConfig.setBucketCount(100000);
      assertThat(hashLinkedListMemTableConfig.bucketCount()).
          isEqualTo(100000);
      assertThat(hashLinkedListMemTableConfig.hugePageTlbSize()).
          isEqualTo(0);
      hashLinkedListMemTableConfig.setHugePageTlbSize(1);
      assertThat(hashLinkedListMemTableConfig.hugePageTlbSize()).
          isEqualTo(1);
      assertThat(hashLinkedListMemTableConfig.
          bucketEntriesLoggingThreshold()).
          isEqualTo(4096);
      hashLinkedListMemTableConfig.
          setBucketEntriesLoggingThreshold(200);
      assertThat(hashLinkedListMemTableConfig.
          bucketEntriesLoggingThreshold()).
          isEqualTo(200);
      assertThat(hashLinkedListMemTableConfig.
          ifLogBucketDistWhenFlush()).isTrue();
      hashLinkedListMemTableConfig.
          setIfLogBucketDistWhenFlush(false);
      assertThat(hashLinkedListMemTableConfig.
          ifLogBucketDistWhenFlush()).isFalse();
      assertThat(hashLinkedListMemTableConfig.
          thresholdUseSkiplist()).
          isEqualTo(256);
      hashLinkedListMemTableConfig.setThresholdUseSkiplist(29);
      assertThat(hashLinkedListMemTableConfig.
          thresholdUseSkiplist()).
          isEqualTo(29);
      options.setMemTableConfig(hashLinkedListMemTableConfig);
<<<<<<< HEAD
    } finally {
      if (options != null) {
        options.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void vectorMemTable() throws RocksDBException {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
=======
    try(final Options options = new Options()) {
>>>>>>> forknote/master
      VectorMemTableConfig vectorMemTableConfig =
          new VectorMemTableConfig();
      assertThat(vectorMemTableConfig.reservedSize()).
          isEqualTo(0);
      vectorMemTableConfig.setReservedSize(123);
      assertThat(vectorMemTableConfig.reservedSize()).
          isEqualTo(123);
      options.setMemTableConfig(vectorMemTableConfig);
<<<<<<< HEAD
      options.dispose();
    }  finally {
      if (options != null) {
        options.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }
}
