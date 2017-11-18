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

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ColumnFamilyOptionsTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  public static final Random rand = PlatformRandomHelper.
      getPlatformSpecificRandomFactory();

  @Test
  public void getColumnFamilyOptionsFromProps() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      // setup sample properties
      Properties properties = new Properties();
      properties.put("write_buffer_size", "112");
      properties.put("max_write_buffer_number", "13");
      opt = ColumnFamilyOptions.
          getColumnFamilyOptionsFromProps(properties);
=======
    Properties properties = new Properties();
    properties.put("write_buffer_size", "112");
    properties.put("max_write_buffer_number", "13");

    try (final ColumnFamilyOptions opt = ColumnFamilyOptions.
        getColumnFamilyOptionsFromProps(properties)) {
      // setup sample properties
>>>>>>> forknote/master
      assertThat(opt).isNotNull();
      assertThat(String.valueOf(opt.writeBufferSize())).
          isEqualTo(properties.get("write_buffer_size"));
      assertThat(String.valueOf(opt.maxWriteBufferNumber())).
          isEqualTo(properties.get("max_write_buffer_number"));
<<<<<<< HEAD
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void failColumnFamilyOptionsFromPropsWithIllegalValue() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      // setup sample properties
      Properties properties = new Properties();
      properties.put("tomato", "1024");
      properties.put("burger", "2");
      opt = ColumnFamilyOptions.
          getColumnFamilyOptionsFromProps(properties);
      assertThat(opt).isNull();
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    // setup sample properties
    final Properties properties = new Properties();
    properties.put("tomato", "1024");
    properties.put("burger", "2");

    try (final ColumnFamilyOptions opt =
             ColumnFamilyOptions.getColumnFamilyOptionsFromProps(properties)) {
      assertThat(opt).isNull();
>>>>>>> forknote/master
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void failColumnFamilyOptionsFromPropsWithNullValue() {
<<<<<<< HEAD
    ColumnFamilyOptions.getColumnFamilyOptionsFromProps(null);
=======
    try (final ColumnFamilyOptions opt =
             ColumnFamilyOptions.getColumnFamilyOptionsFromProps(null)) {
    }
>>>>>>> forknote/master
  }

  @Test(expected = IllegalArgumentException.class)
  public void failColumnFamilyOptionsFromPropsWithEmptyProps() {
<<<<<<< HEAD
    ColumnFamilyOptions.getColumnFamilyOptionsFromProps(
        new Properties());
=======
    try (final ColumnFamilyOptions opt =
             ColumnFamilyOptions.getColumnFamilyOptionsFromProps(
                 new Properties())) {
    }
>>>>>>> forknote/master
  }

  @Test
  public void writeBufferSize() throws RocksDBException {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      long longValue = rand.nextLong();
      opt.setWriteBufferSize(longValue);
      assertThat(opt.writeBufferSize()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final long longValue = rand.nextLong();
      opt.setWriteBufferSize(longValue);
      assertThat(opt.writeBufferSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxWriteBufferNumber() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setMaxWriteBufferNumber(intValue);
      assertThat(opt.maxWriteBufferNumber()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setMaxWriteBufferNumber(intValue);
      assertThat(opt.maxWriteBufferNumber()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void minWriteBufferNumberToMerge() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setMinWriteBufferNumberToMerge(intValue);
      assertThat(opt.minWriteBufferNumberToMerge()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setMinWriteBufferNumberToMerge(intValue);
      assertThat(opt.minWriteBufferNumberToMerge()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void numLevels() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setNumLevels(intValue);
      assertThat(opt.numLevels()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setNumLevels(intValue);
      assertThat(opt.numLevels()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void levelZeroFileNumCompactionTrigger() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setLevelZeroFileNumCompactionTrigger(intValue);
      assertThat(opt.levelZeroFileNumCompactionTrigger()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setLevelZeroFileNumCompactionTrigger(intValue);
      assertThat(opt.levelZeroFileNumCompactionTrigger()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void levelZeroSlowdownWritesTrigger() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setLevelZeroSlowdownWritesTrigger(intValue);
      assertThat(opt.levelZeroSlowdownWritesTrigger()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setLevelZeroSlowdownWritesTrigger(intValue);
      assertThat(opt.levelZeroSlowdownWritesTrigger()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void levelZeroStopWritesTrigger() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setLevelZeroStopWritesTrigger(intValue);
      assertThat(opt.levelZeroStopWritesTrigger()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setLevelZeroStopWritesTrigger(intValue);
      assertThat(opt.levelZeroStopWritesTrigger()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void targetFileSizeBase() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      long longValue = rand.nextLong();
      opt.setTargetFileSizeBase(longValue);
      assertThat(opt.targetFileSizeBase()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final long longValue = rand.nextLong();
      opt.setTargetFileSizeBase(longValue);
      assertThat(opt.targetFileSizeBase()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void targetFileSizeMultiplier() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setTargetFileSizeMultiplier(intValue);
      assertThat(opt.targetFileSizeMultiplier()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setTargetFileSizeMultiplier(intValue);
      assertThat(opt.targetFileSizeMultiplier()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxBytesForLevelBase() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      long longValue = rand.nextLong();
      opt.setMaxBytesForLevelBase(longValue);
      assertThat(opt.maxBytesForLevelBase()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final long longValue = rand.nextLong();
      opt.setMaxBytesForLevelBase(longValue);
      assertThat(opt.maxBytesForLevelBase()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void levelCompactionDynamicLevelBytes() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
>>>>>>> forknote/master
      final boolean boolValue = rand.nextBoolean();
      opt.setLevelCompactionDynamicLevelBytes(boolValue);
      assertThat(opt.levelCompactionDynamicLevelBytes())
          .isEqualTo(boolValue);
<<<<<<< HEAD
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxBytesForLevelMultiplier() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setMaxBytesForLevelMultiplier(intValue);
      assertThat(opt.maxBytesForLevelMultiplier()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setMaxBytesForLevelMultiplier(intValue);
      assertThat(opt.maxBytesForLevelMultiplier()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void expandedCompactionFactor() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setExpandedCompactionFactor(intValue);
      assertThat(opt.expandedCompactionFactor()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setExpandedCompactionFactor(intValue);
      assertThat(opt.expandedCompactionFactor()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void sourceCompactionFactor() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setSourceCompactionFactor(intValue);
      assertThat(opt.sourceCompactionFactor()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setSourceCompactionFactor(intValue);
      assertThat(opt.sourceCompactionFactor()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxGrandparentOverlapFactor() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setMaxGrandparentOverlapFactor(intValue);
      assertThat(opt.maxGrandparentOverlapFactor()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setMaxGrandparentOverlapFactor(intValue);
      assertThat(opt.maxGrandparentOverlapFactor()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void softRateLimit() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      double doubleValue = rand.nextDouble();
      opt.setSoftRateLimit(doubleValue);
      assertThat(opt.softRateLimit()).isEqualTo(doubleValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final double doubleValue = rand.nextDouble();
      opt.setSoftRateLimit(doubleValue);
      assertThat(opt.softRateLimit()).isEqualTo(doubleValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void hardRateLimit() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      double doubleValue = rand.nextDouble();
      opt.setHardRateLimit(doubleValue);
      assertThat(opt.hardRateLimit()).isEqualTo(doubleValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final double doubleValue = rand.nextDouble();
      opt.setHardRateLimit(doubleValue);
      assertThat(opt.hardRateLimit()).isEqualTo(doubleValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void rateLimitDelayMaxMilliseconds() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setRateLimitDelayMaxMilliseconds(intValue);
      assertThat(opt.rateLimitDelayMaxMilliseconds()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setRateLimitDelayMaxMilliseconds(intValue);
      assertThat(opt.rateLimitDelayMaxMilliseconds()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void arenaBlockSize() throws RocksDBException {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      long longValue = rand.nextLong();
      opt.setArenaBlockSize(longValue);
      assertThat(opt.arenaBlockSize()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final long longValue = rand.nextLong();
      opt.setArenaBlockSize(longValue);
      assertThat(opt.arenaBlockSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void disableAutoCompactions() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setDisableAutoCompactions(boolValue);
      assertThat(opt.disableAutoCompactions()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setDisableAutoCompactions(boolValue);
      assertThat(opt.disableAutoCompactions()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void purgeRedundantKvsWhileFlush() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setPurgeRedundantKvsWhileFlush(boolValue);
      assertThat(opt.purgeRedundantKvsWhileFlush()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setPurgeRedundantKvsWhileFlush(boolValue);
      assertThat(opt.purgeRedundantKvsWhileFlush()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void verifyChecksumsInCompaction() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setVerifyChecksumsInCompaction(boolValue);
      assertThat(opt.verifyChecksumsInCompaction()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
    }
  }

  @Test
  public void filterDeletes() {
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setFilterDeletes(boolValue);
      assertThat(opt.filterDeletes()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setVerifyChecksumsInCompaction(boolValue);
      assertThat(opt.verifyChecksumsInCompaction()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxSequentialSkipInIterations() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      long longValue = rand.nextLong();
      opt.setMaxSequentialSkipInIterations(longValue);
      assertThat(opt.maxSequentialSkipInIterations()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final long longValue = rand.nextLong();
      opt.setMaxSequentialSkipInIterations(longValue);
      assertThat(opt.maxSequentialSkipInIterations()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void inplaceUpdateSupport() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setInplaceUpdateSupport(boolValue);
      assertThat(opt.inplaceUpdateSupport()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setInplaceUpdateSupport(boolValue);
      assertThat(opt.inplaceUpdateSupport()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void inplaceUpdateNumLocks() throws RocksDBException {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      long longValue = rand.nextLong();
      opt.setInplaceUpdateNumLocks(longValue);
      assertThat(opt.inplaceUpdateNumLocks()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
    }
  }

  @Test
  public void memtablePrefixBloomBits() {
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      int intValue = rand.nextInt();
      opt.setMemtablePrefixBloomBits(intValue);
      assertThat(opt.memtablePrefixBloomBits()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final long longValue = rand.nextLong();
      opt.setInplaceUpdateNumLocks(longValue);
      assertThat(opt.inplaceUpdateNumLocks()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
  public void memtablePrefixBloomProbes() {
    ColumnFamilyOptions opt = null;
    try {
      int intValue = rand.nextInt();
      opt = new ColumnFamilyOptions();
      opt.setMemtablePrefixBloomProbes(intValue);
      assertThat(opt.memtablePrefixBloomProbes()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
  public void memtablePrefixBloomSizeRatio() {
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final double doubleValue = rand.nextDouble();
      opt.setMemtablePrefixBloomSizeRatio(doubleValue);
      assertThat(opt.memtablePrefixBloomSizeRatio()).isEqualTo(doubleValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void bloomLocality() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      int intValue = rand.nextInt();
      opt = new ColumnFamilyOptions();
      opt.setBloomLocality(intValue);
      assertThat(opt.bloomLocality()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setBloomLocality(intValue);
      assertThat(opt.bloomLocality()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxSuccessiveMerges() throws RocksDBException {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      long longValue = rand.nextLong();
      opt = new ColumnFamilyOptions();
      opt.setMaxSuccessiveMerges(longValue);
      assertThat(opt.maxSuccessiveMerges()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final long longValue = rand.nextLong();
      opt.setMaxSuccessiveMerges(longValue);
      assertThat(opt.maxSuccessiveMerges()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void minPartialMergeOperands() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      int intValue = rand.nextInt();
      opt = new ColumnFamilyOptions();
      opt.setMinPartialMergeOperands(intValue);
      assertThat(opt.minPartialMergeOperands()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final int intValue = rand.nextInt();
      opt.setMinPartialMergeOperands(intValue);
      assertThat(opt.minPartialMergeOperands()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void optimizeFiltersForHits() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      boolean aBoolean = rand.nextBoolean();
      opt = new ColumnFamilyOptions();
      opt.setOptimizeFiltersForHits(aBoolean);
      assertThat(opt.optimizeFiltersForHits()).isEqualTo(aBoolean);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      final boolean aBoolean = rand.nextBoolean();
      opt.setOptimizeFiltersForHits(aBoolean);
      assertThat(opt.optimizeFiltersForHits()).isEqualTo(aBoolean);
>>>>>>> forknote/master
    }
  }

  @Test
  public void memTable() throws RocksDBException {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      opt.setMemTableConfig(new HashLinkedListMemTableConfig());
      assertThat(opt.memTableFactoryName()).
          isEqualTo("HashLinkedListRepFactory");
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      opt.setMemTableConfig(new HashLinkedListMemTableConfig());
      assertThat(opt.memTableFactoryName()).
          isEqualTo("HashLinkedListRepFactory");
>>>>>>> forknote/master
    }
  }

  @Test
  public void comparator() throws RocksDBException {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      opt.setComparator(BuiltinComparator.BYTEWISE_COMPARATOR);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      opt.setComparator(BuiltinComparator.BYTEWISE_COMPARATOR);
>>>>>>> forknote/master
    }
  }

  @Test
  public void linkageOfPrepMethods() {
<<<<<<< HEAD
    ColumnFamilyOptions options = null;
    try {
      options = new ColumnFamilyOptions();
=======
    try (final ColumnFamilyOptions options = new ColumnFamilyOptions()) {
>>>>>>> forknote/master
      options.optimizeUniversalStyleCompaction();
      options.optimizeUniversalStyleCompaction(4000);
      options.optimizeLevelStyleCompaction();
      options.optimizeLevelStyleCompaction(3000);
      options.optimizeForPointLookup(10);
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
  public void shouldSetTestPrefixExtractor() {
<<<<<<< HEAD
    ColumnFamilyOptions options = null;
    try {
      options = new ColumnFamilyOptions();
      options.useFixedLengthPrefixExtractor(100);
      options.useFixedLengthPrefixExtractor(10);
    } finally {
      if (options != null) {
        options.dispose();
      }
    }
  }


  @Test
  public void shouldSetTestCappedPrefixExtractor() {
    ColumnFamilyOptions options = null;
    try {
      options = new ColumnFamilyOptions();
      options.useCappedPrefixExtractor(100);
      options.useCappedPrefixExtractor(10);
    } finally {
      if (options != null) {
        options.dispose();
      }
=======
    try (final ColumnFamilyOptions options = new ColumnFamilyOptions()) {
      options.useFixedLengthPrefixExtractor(100);
      options.useFixedLengthPrefixExtractor(10);
    }
  }

  @Test
  public void shouldSetTestCappedPrefixExtractor() {
    try (final ColumnFamilyOptions options = new ColumnFamilyOptions()) {
      options.useCappedPrefixExtractor(100);
      options.useCappedPrefixExtractor(10);
>>>>>>> forknote/master
    }
  }

  @Test
  public void compressionTypes() {
<<<<<<< HEAD
    ColumnFamilyOptions columnFamilyOptions = null;
    try {
      columnFamilyOptions = new ColumnFamilyOptions();
      for (CompressionType compressionType :
=======
    try (final ColumnFamilyOptions columnFamilyOptions
             = new ColumnFamilyOptions()) {
      for (final CompressionType compressionType :
>>>>>>> forknote/master
          CompressionType.values()) {
        columnFamilyOptions.setCompressionType(compressionType);
        assertThat(columnFamilyOptions.compressionType()).
            isEqualTo(compressionType);
        assertThat(CompressionType.valueOf("NO_COMPRESSION")).
            isEqualTo(CompressionType.NO_COMPRESSION);
      }
<<<<<<< HEAD
    } finally {
      if (columnFamilyOptions != null) {
        columnFamilyOptions.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void compressionPerLevel() {
<<<<<<< HEAD
    ColumnFamilyOptions columnFamilyOptions = null;
    try {
      columnFamilyOptions = new ColumnFamilyOptions();
      assertThat(columnFamilyOptions.compressionPerLevel()).isEmpty();
      List<CompressionType> compressionTypeList = new ArrayList<>();
      for (int i=0; i < columnFamilyOptions.numLevels(); i++) {
=======
    try (final ColumnFamilyOptions columnFamilyOptions
             = new ColumnFamilyOptions()) {
      assertThat(columnFamilyOptions.compressionPerLevel()).isEmpty();
      List<CompressionType> compressionTypeList = new ArrayList<>();
      for (int i = 0; i < columnFamilyOptions.numLevels(); i++) {
>>>>>>> forknote/master
        compressionTypeList.add(CompressionType.NO_COMPRESSION);
      }
      columnFamilyOptions.setCompressionPerLevel(compressionTypeList);
      compressionTypeList = columnFamilyOptions.compressionPerLevel();
      for (CompressionType compressionType : compressionTypeList) {
        assertThat(compressionType).isEqualTo(
            CompressionType.NO_COMPRESSION);
      }
<<<<<<< HEAD
    } finally {
      if (columnFamilyOptions != null) {
        columnFamilyOptions.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void differentCompressionsPerLevel() {
<<<<<<< HEAD
    ColumnFamilyOptions columnFamilyOptions = null;
    try {
      columnFamilyOptions = new ColumnFamilyOptions();
=======
    try (final ColumnFamilyOptions columnFamilyOptions
             = new ColumnFamilyOptions()) {
>>>>>>> forknote/master
      columnFamilyOptions.setNumLevels(3);

      assertThat(columnFamilyOptions.compressionPerLevel()).isEmpty();
      List<CompressionType> compressionTypeList = new ArrayList<>();

      compressionTypeList.add(CompressionType.BZLIB2_COMPRESSION);
      compressionTypeList.add(CompressionType.SNAPPY_COMPRESSION);
      compressionTypeList.add(CompressionType.LZ4_COMPRESSION);

      columnFamilyOptions.setCompressionPerLevel(compressionTypeList);
      compressionTypeList = columnFamilyOptions.compressionPerLevel();

      assertThat(compressionTypeList.size()).isEqualTo(3);
      assertThat(compressionTypeList).
          containsExactly(
              CompressionType.BZLIB2_COMPRESSION,
              CompressionType.SNAPPY_COMPRESSION,
              CompressionType.LZ4_COMPRESSION);

<<<<<<< HEAD
    } finally {
      if (columnFamilyOptions != null) {
        columnFamilyOptions.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void compactionStyles() {
<<<<<<< HEAD
    ColumnFamilyOptions ColumnFamilyOptions = null;
    try {
      ColumnFamilyOptions = new ColumnFamilyOptions();
      for (CompactionStyle compactionStyle :
          CompactionStyle.values()) {
        ColumnFamilyOptions.setCompactionStyle(compactionStyle);
        assertThat(ColumnFamilyOptions.compactionStyle()).
=======
    try (final ColumnFamilyOptions columnFamilyOptions
             = new ColumnFamilyOptions()) {
      for (final CompactionStyle compactionStyle :
          CompactionStyle.values()) {
        columnFamilyOptions.setCompactionStyle(compactionStyle);
        assertThat(columnFamilyOptions.compactionStyle()).
>>>>>>> forknote/master
            isEqualTo(compactionStyle);
        assertThat(CompactionStyle.valueOf("FIFO")).
            isEqualTo(CompactionStyle.FIFO);
      }
<<<<<<< HEAD
    } finally {
      if (ColumnFamilyOptions != null) {
        ColumnFamilyOptions.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxTableFilesSizeFIFO() {
<<<<<<< HEAD
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
=======
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
>>>>>>> forknote/master
      long longValue = rand.nextLong();
      // Size has to be positive
      longValue = (longValue < 0) ? -longValue : longValue;
      longValue = (longValue == 0) ? longValue + 1 : longValue;
      opt.setMaxTableFilesSizeFIFO(longValue);
      assertThat(opt.maxTableFilesSizeFIFO()).
          isEqualTo(longValue);
<<<<<<< HEAD
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }
}
