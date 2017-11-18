<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
<<<<<<< HEAD
=======

>>>>>>> forknote/master
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class OptionsTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  public static final Random rand = PlatformRandomHelper.
      getPlatformSpecificRandomFactory();

  @Test
  public void setIncreaseParallelism() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      final int threads = Runtime.getRuntime().availableProcessors() * 2;
      opt.setIncreaseParallelism(threads);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int threads = Runtime.getRuntime().availableProcessors() * 2;
      opt.setIncreaseParallelism(threads);
>>>>>>> forknote/master
    }
  }

  @Test
  public void writeBufferSize() throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setWriteBufferSize(longValue);
      assertThat(opt.writeBufferSize()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setWriteBufferSize(longValue);
      assertThat(opt.writeBufferSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxWriteBufferNumber() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setMaxWriteBufferNumber(intValue);
      assertThat(opt.maxWriteBufferNumber()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setMaxWriteBufferNumber(intValue);
      assertThat(opt.maxWriteBufferNumber()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void minWriteBufferNumberToMerge() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setMinWriteBufferNumberToMerge(intValue);
      assertThat(opt.minWriteBufferNumberToMerge()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setMinWriteBufferNumberToMerge(intValue);
      assertThat(opt.minWriteBufferNumberToMerge()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void numLevels() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setNumLevels(intValue);
      assertThat(opt.numLevels()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setNumLevels(intValue);
      assertThat(opt.numLevels()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void levelZeroFileNumCompactionTrigger() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setLevelZeroFileNumCompactionTrigger(intValue);
      assertThat(opt.levelZeroFileNumCompactionTrigger()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setLevelZeroFileNumCompactionTrigger(intValue);
      assertThat(opt.levelZeroFileNumCompactionTrigger()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void levelZeroSlowdownWritesTrigger() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setLevelZeroSlowdownWritesTrigger(intValue);
      assertThat(opt.levelZeroSlowdownWritesTrigger()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setLevelZeroSlowdownWritesTrigger(intValue);
      assertThat(opt.levelZeroSlowdownWritesTrigger()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void levelZeroStopWritesTrigger() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setLevelZeroStopWritesTrigger(intValue);
      assertThat(opt.levelZeroStopWritesTrigger()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setLevelZeroStopWritesTrigger(intValue);
      assertThat(opt.levelZeroStopWritesTrigger()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void targetFileSizeBase() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setTargetFileSizeBase(longValue);
      assertThat(opt.targetFileSizeBase()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setTargetFileSizeBase(longValue);
      assertThat(opt.targetFileSizeBase()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void targetFileSizeMultiplier() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setTargetFileSizeMultiplier(intValue);
      assertThat(opt.targetFileSizeMultiplier()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setTargetFileSizeMultiplier(intValue);
      assertThat(opt.targetFileSizeMultiplier()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxBytesForLevelBase() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setMaxBytesForLevelBase(longValue);
      assertThat(opt.maxBytesForLevelBase()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setMaxBytesForLevelBase(longValue);
      assertThat(opt.maxBytesForLevelBase()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void levelCompactionDynamicLevelBytes() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
=======
    try (final Options opt = new Options()) {
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
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setMaxBytesForLevelMultiplier(intValue);
      assertThat(opt.maxBytesForLevelMultiplier()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setMaxBytesForLevelMultiplier(intValue);
      assertThat(opt.maxBytesForLevelMultiplier()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void expandedCompactionFactor() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setExpandedCompactionFactor(intValue);
      assertThat(opt.expandedCompactionFactor()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setExpandedCompactionFactor(intValue);
      assertThat(opt.expandedCompactionFactor()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void sourceCompactionFactor() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setSourceCompactionFactor(intValue);
      assertThat(opt.sourceCompactionFactor()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setSourceCompactionFactor(intValue);
      assertThat(opt.sourceCompactionFactor()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxGrandparentOverlapFactor() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setMaxGrandparentOverlapFactor(intValue);
      assertThat(opt.maxGrandparentOverlapFactor()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setMaxGrandparentOverlapFactor(intValue);
      assertThat(opt.maxGrandparentOverlapFactor()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void softRateLimit() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      double doubleValue = rand.nextDouble();
      opt.setSoftRateLimit(doubleValue);
      assertThat(opt.softRateLimit()).isEqualTo(doubleValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final double doubleValue = rand.nextDouble();
      opt.setSoftRateLimit(doubleValue);
      assertThat(opt.softRateLimit()).isEqualTo(doubleValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void hardRateLimit() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      double doubleValue = rand.nextDouble();
      opt.setHardRateLimit(doubleValue);
      assertThat(opt.hardRateLimit()).isEqualTo(doubleValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final double doubleValue = rand.nextDouble();
      opt.setHardRateLimit(doubleValue);
      assertThat(opt.hardRateLimit()).isEqualTo(doubleValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void rateLimitDelayMaxMilliseconds() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setRateLimitDelayMaxMilliseconds(intValue);
      assertThat(opt.rateLimitDelayMaxMilliseconds()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setRateLimitDelayMaxMilliseconds(intValue);
      assertThat(opt.rateLimitDelayMaxMilliseconds()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void arenaBlockSize() throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setArenaBlockSize(longValue);
      assertThat(opt.arenaBlockSize()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setArenaBlockSize(longValue);
      assertThat(opt.arenaBlockSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void disableAutoCompactions() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setDisableAutoCompactions(boolValue);
      assertThat(opt.disableAutoCompactions()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setDisableAutoCompactions(boolValue);
      assertThat(opt.disableAutoCompactions()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void purgeRedundantKvsWhileFlush() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setPurgeRedundantKvsWhileFlush(boolValue);
      assertThat(opt.purgeRedundantKvsWhileFlush()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setPurgeRedundantKvsWhileFlush(boolValue);
      assertThat(opt.purgeRedundantKvsWhileFlush()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void verifyChecksumsInCompaction() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
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
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setFilterDeletes(boolValue);
      assertThat(opt.filterDeletes()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setVerifyChecksumsInCompaction(boolValue);
      assertThat(opt.verifyChecksumsInCompaction()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxSequentialSkipInIterations() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setMaxSequentialSkipInIterations(longValue);
      assertThat(opt.maxSequentialSkipInIterations()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setMaxSequentialSkipInIterations(longValue);
      assertThat(opt.maxSequentialSkipInIterations()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void inplaceUpdateSupport() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setInplaceUpdateSupport(boolValue);
      assertThat(opt.inplaceUpdateSupport()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setInplaceUpdateSupport(boolValue);
      assertThat(opt.inplaceUpdateSupport()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void inplaceUpdateNumLocks() throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
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
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setMemtablePrefixBloomBits(intValue);
      assertThat(opt.memtablePrefixBloomBits()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setInplaceUpdateNumLocks(longValue);
      assertThat(opt.inplaceUpdateNumLocks()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
  public void memtablePrefixBloomProbes() {
    Options opt = null;
    try {
      int intValue = rand.nextInt();
      opt = new Options();
      opt.setMemtablePrefixBloomProbes(intValue);
      assertThat(opt.memtablePrefixBloomProbes()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
  public void memtablePrefixBloomSizeRatio() {
    try (final Options opt = new Options()) {
      final double doubleValue = rand.nextDouble();
      opt.setMemtablePrefixBloomSizeRatio(doubleValue);
      assertThat(opt.memtablePrefixBloomSizeRatio()).isEqualTo(doubleValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void bloomLocality() {
<<<<<<< HEAD
    Options opt = null;
    try {
      int intValue = rand.nextInt();
      opt = new Options();
      opt.setBloomLocality(intValue);
      assertThat(opt.bloomLocality()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setBloomLocality(intValue);
      assertThat(opt.bloomLocality()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxSuccessiveMerges() throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    try {
      long longValue = rand.nextLong();
      opt = new Options();
      opt.setMaxSuccessiveMerges(longValue);
      assertThat(opt.maxSuccessiveMerges()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setMaxSuccessiveMerges(longValue);
      assertThat(opt.maxSuccessiveMerges()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void minPartialMergeOperands() {
<<<<<<< HEAD
    Options opt = null;
    try {
      int intValue = rand.nextInt();
      opt = new Options();
      opt.setMinPartialMergeOperands(intValue);
      assertThat(opt.minPartialMergeOperands()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setMinPartialMergeOperands(intValue);
      assertThat(opt.minPartialMergeOperands()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void optimizeFiltersForHits() {
<<<<<<< HEAD
    Options opt = null;
    try {
      boolean aBoolean = rand.nextBoolean();
      opt = new Options();
      opt.setOptimizeFiltersForHits(aBoolean);
      assertThat(opt.optimizeFiltersForHits()).isEqualTo(aBoolean);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean aBoolean = rand.nextBoolean();
      opt.setOptimizeFiltersForHits(aBoolean);
      assertThat(opt.optimizeFiltersForHits()).isEqualTo(aBoolean);
>>>>>>> forknote/master
    }
  }

  @Test
  public void createIfMissing() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setCreateIfMissing(boolValue);
      assertThat(opt.createIfMissing()).
          isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setCreateIfMissing(boolValue);
      assertThat(opt.createIfMissing()).
          isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void createMissingColumnFamilies() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setCreateMissingColumnFamilies(boolValue);
      assertThat(opt.createMissingColumnFamilies()).
          isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setCreateMissingColumnFamilies(boolValue);
      assertThat(opt.createMissingColumnFamilies()).
          isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void errorIfExists() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setErrorIfExists(boolValue);
      assertThat(opt.errorIfExists()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setErrorIfExists(boolValue);
      assertThat(opt.errorIfExists()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void paranoidChecks() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setParanoidChecks(boolValue);
      assertThat(opt.paranoidChecks()).
          isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setParanoidChecks(boolValue);
      assertThat(opt.paranoidChecks()).
          isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxTotalWalSize() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setMaxTotalWalSize(longValue);
      assertThat(opt.maxTotalWalSize()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setMaxTotalWalSize(longValue);
      assertThat(opt.maxTotalWalSize()).
          isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxOpenFiles() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setMaxOpenFiles(intValue);
      assertThat(opt.maxOpenFiles()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setMaxOpenFiles(intValue);
      assertThat(opt.maxOpenFiles()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void disableDataSync() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setDisableDataSync(boolValue);
      assertThat(opt.disableDataSync()).
          isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setDisableDataSync(boolValue);
      assertThat(opt.disableDataSync()).
          isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void useFsync() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setUseFsync(boolValue);
      assertThat(opt.useFsync()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setUseFsync(boolValue);
      assertThat(opt.useFsync()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void dbLogDir() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      String str = "path/to/DbLogDir";
      opt.setDbLogDir(str);
      assertThat(opt.dbLogDir()).isEqualTo(str);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final String str = "path/to/DbLogDir";
      opt.setDbLogDir(str);
      assertThat(opt.dbLogDir()).isEqualTo(str);
>>>>>>> forknote/master
    }
  }

  @Test
  public void walDir() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      String str = "path/to/WalDir";
      opt.setWalDir(str);
      assertThat(opt.walDir()).isEqualTo(str);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final String str = "path/to/WalDir";
      opt.setWalDir(str);
      assertThat(opt.walDir()).isEqualTo(str);
>>>>>>> forknote/master
    }
  }

  @Test
  public void deleteObsoleteFilesPeriodMicros() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setDeleteObsoleteFilesPeriodMicros(longValue);
      assertThat(opt.deleteObsoleteFilesPeriodMicros()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setDeleteObsoleteFilesPeriodMicros(longValue);
      assertThat(opt.deleteObsoleteFilesPeriodMicros()).
          isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxBackgroundCompactions() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setMaxBackgroundCompactions(intValue);
      assertThat(opt.maxBackgroundCompactions()).
          isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setMaxBackgroundCompactions(intValue);
      assertThat(opt.maxBackgroundCompactions()).
          isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxBackgroundFlushes() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setMaxBackgroundFlushes(intValue);
      assertThat(opt.maxBackgroundFlushes()).
          isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setMaxBackgroundFlushes(intValue);
      assertThat(opt.maxBackgroundFlushes()).
          isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxLogFileSize() throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setMaxLogFileSize(longValue);
      assertThat(opt.maxLogFileSize()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setMaxLogFileSize(longValue);
      assertThat(opt.maxLogFileSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void logFileTimeToRoll() throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setLogFileTimeToRoll(longValue);
      assertThat(opt.logFileTimeToRoll()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setLogFileTimeToRoll(longValue);
      assertThat(opt.logFileTimeToRoll()).
          isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void keepLogFileNum() throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setKeepLogFileNum(longValue);
      assertThat(opt.keepLogFileNum()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setKeepLogFileNum(longValue);
      assertThat(opt.keepLogFileNum()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxManifestFileSize() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setMaxManifestFileSize(longValue);
      assertThat(opt.maxManifestFileSize()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setMaxManifestFileSize(longValue);
      assertThat(opt.maxManifestFileSize()).
          isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void tableCacheNumshardbits() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setTableCacheNumshardbits(intValue);
      assertThat(opt.tableCacheNumshardbits()).
          isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setTableCacheNumshardbits(intValue);
      assertThat(opt.tableCacheNumshardbits()).
          isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void walSizeLimitMB() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setWalSizeLimitMB(longValue);
      assertThat(opt.walSizeLimitMB()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setWalSizeLimitMB(longValue);
      assertThat(opt.walSizeLimitMB()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void walTtlSeconds() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setWalTtlSeconds(longValue);
      assertThat(opt.walTtlSeconds()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setWalTtlSeconds(longValue);
      assertThat(opt.walTtlSeconds()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void manifestPreallocationSize() throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setManifestPreallocationSize(longValue);
      assertThat(opt.manifestPreallocationSize()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setManifestPreallocationSize(longValue);
      assertThat(opt.manifestPreallocationSize()).
          isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void allowOsBuffer() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setAllowOsBuffer(boolValue);
      assertThat(opt.allowOsBuffer()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setAllowOsBuffer(boolValue);
      assertThat(opt.allowOsBuffer()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void allowMmapReads() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setAllowMmapReads(boolValue);
      assertThat(opt.allowMmapReads()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setAllowMmapReads(boolValue);
      assertThat(opt.allowMmapReads()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void allowMmapWrites() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setAllowMmapWrites(boolValue);
      assertThat(opt.allowMmapWrites()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setAllowMmapWrites(boolValue);
      assertThat(opt.allowMmapWrites()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void isFdCloseOnExec() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setIsFdCloseOnExec(boolValue);
      assertThat(opt.isFdCloseOnExec()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setIsFdCloseOnExec(boolValue);
      assertThat(opt.isFdCloseOnExec()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void statsDumpPeriodSec() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      int intValue = rand.nextInt();
      opt.setStatsDumpPeriodSec(intValue);
      assertThat(opt.statsDumpPeriodSec()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final int intValue = rand.nextInt();
      opt.setStatsDumpPeriodSec(intValue);
      assertThat(opt.statsDumpPeriodSec()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void adviseRandomOnOpen() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setAdviseRandomOnOpen(boolValue);
      assertThat(opt.adviseRandomOnOpen()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setAdviseRandomOnOpen(boolValue);
      assertThat(opt.adviseRandomOnOpen()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void useAdaptiveMutex() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      boolean boolValue = rand.nextBoolean();
      opt.setUseAdaptiveMutex(boolValue);
      assertThat(opt.useAdaptiveMutex()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setUseAdaptiveMutex(boolValue);
      assertThat(opt.useAdaptiveMutex()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void bytesPerSync() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      long longValue = rand.nextLong();
      opt.setBytesPerSync(longValue);
      assertThat(opt.bytesPerSync()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      final long longValue = rand.nextLong();
      opt.setBytesPerSync(longValue);
      assertThat(opt.bytesPerSync()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void env() {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
      Env env = Env.getDefault();
      options.setEnv(env);
      assertThat(options.getEnv()).isSameAs(env);
    } finally {
      if (options != null) {
        options.dispose();
      }
=======
    try (final Options options = new Options();
         final Env env = Env.getDefault()) {
      options.setEnv(env);
      assertThat(options.getEnv()).isSameAs(env);
>>>>>>> forknote/master
    }
  }

  @Test
  public void linkageOfPrepMethods() {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
=======
    try (final Options options = new Options()) {
>>>>>>> forknote/master
      options.optimizeUniversalStyleCompaction();
      options.optimizeUniversalStyleCompaction(4000);
      options.optimizeLevelStyleCompaction();
      options.optimizeLevelStyleCompaction(3000);
      options.optimizeForPointLookup(10);
      options.prepareForBulkLoad();
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
  public void compressionTypes() {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
      for (CompressionType compressionType :
=======
    try (final Options options = new Options()) {
      for (final CompressionType compressionType :
>>>>>>> forknote/master
          CompressionType.values()) {
        options.setCompressionType(compressionType);
        assertThat(options.compressionType()).
            isEqualTo(compressionType);
        assertThat(CompressionType.valueOf("NO_COMPRESSION")).
            isEqualTo(CompressionType.NO_COMPRESSION);
      }
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
  public void compressionPerLevel() {
<<<<<<< HEAD
    ColumnFamilyOptions columnFamilyOptions = null;
    try {
      columnFamilyOptions = new ColumnFamilyOptions();
      assertThat(columnFamilyOptions.compressionPerLevel()).isEmpty();
      List<CompressionType> compressionTypeList =
          new ArrayList<>();
      for (int i=0; i < columnFamilyOptions.numLevels(); i++) {
=======
    try (final ColumnFamilyOptions columnFamilyOptions =
             new ColumnFamilyOptions()) {
      assertThat(columnFamilyOptions.compressionPerLevel()).isEmpty();
      List<CompressionType> compressionTypeList =
          new ArrayList<>();
      for (int i = 0; i < columnFamilyOptions.numLevels(); i++) {
>>>>>>> forknote/master
        compressionTypeList.add(CompressionType.NO_COMPRESSION);
      }
      columnFamilyOptions.setCompressionPerLevel(compressionTypeList);
      compressionTypeList = columnFamilyOptions.compressionPerLevel();
      for (final CompressionType compressionType : compressionTypeList) {
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
    try (final ColumnFamilyOptions columnFamilyOptions =
             new ColumnFamilyOptions()) {
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
    Options options = null;
    try {
      options = new Options();
      for (CompactionStyle compactionStyle :
=======
    try (final Options options = new Options()) {
      for (final CompactionStyle compactionStyle :
>>>>>>> forknote/master
          CompactionStyle.values()) {
        options.setCompactionStyle(compactionStyle);
        assertThat(options.compactionStyle()).
            isEqualTo(compactionStyle);
        assertThat(CompactionStyle.valueOf("FIFO")).
            isEqualTo(CompactionStyle.FIFO);
      }
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
  public void maxTableFilesSizeFIFO() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
=======
    try (final Options opt = new Options()) {
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

  @Test
  public void rateLimiterConfig() {
<<<<<<< HEAD
    Options options = null;
    Options anotherOptions = null;
    RateLimiterConfig rateLimiterConfig;
    try {
      options = new Options();
      rateLimiterConfig = new GenericRateLimiterConfig(1000, 100 * 1000, 1);
      options.setRateLimiterConfig(rateLimiterConfig);
      // Test with parameter initialization
      anotherOptions = new Options();
      anotherOptions.setRateLimiterConfig(
          new GenericRateLimiterConfig(1000));
    } finally {
      if (options != null) {
        options.dispose();
      }
      if (anotherOptions != null) {
        anotherOptions.dispose();
      }
=======
    try (final Options options = new Options();
         final Options anotherOptions = new Options()) {
      final RateLimiterConfig rateLimiterConfig =
          new GenericRateLimiterConfig(1000, 100 * 1000, 1);
      options.setRateLimiterConfig(rateLimiterConfig);
      // Test with parameter initialization

      anotherOptions.setRateLimiterConfig(
          new GenericRateLimiterConfig(1000));
>>>>>>> forknote/master
    }
  }

  @Test
  public void shouldSetTestPrefixExtractor() {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
      options.useFixedLengthPrefixExtractor(100);
      options.useFixedLengthPrefixExtractor(10);
    } finally {
      if (options != null) {
        options.dispose();
      }
=======
    try (final Options options = new Options()) {
      options.useFixedLengthPrefixExtractor(100);
      options.useFixedLengthPrefixExtractor(10);
>>>>>>> forknote/master
    }
  }

  @Test
  public void shouldSetTestCappedPrefixExtractor() {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
      options.useCappedPrefixExtractor(100);
      options.useCappedPrefixExtractor(10);
    } finally {
      if (options != null) {
        options.dispose();
      }
=======
    try (final Options options = new Options()) {
      options.useCappedPrefixExtractor(100);
      options.useCappedPrefixExtractor(10);
>>>>>>> forknote/master
    }
  }


  @Test
  public void shouldTestMemTableFactoryName()
      throws RocksDBException {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
=======
    try (final Options options = new Options()) {
>>>>>>> forknote/master
      options.setMemTableConfig(new VectorMemTableConfig());
      assertThat(options.memTableFactoryName()).
          isEqualTo("VectorRepFactory");
      options.setMemTableConfig(
          new HashLinkedListMemTableConfig());
      assertThat(options.memTableFactoryName()).
          isEqualTo("HashLinkedListRepFactory");
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
  public void statistics() {
<<<<<<< HEAD
    Options options = null;
    Options anotherOptions = null;
    try {
      options = new Options();
      Statistics statistics = options.createStatistics().
          statisticsPtr();
      assertThat(statistics).isNotNull();
      anotherOptions = new Options();
      statistics = anotherOptions.statisticsPtr();
      assertThat(statistics).isNotNull();
    } finally {
      if (options != null) {
        options.dispose();
      }
      if (anotherOptions != null) {
        anotherOptions.dispose();
=======
    try (final Options options = new Options()) {
      Statistics statistics = options.createStatistics().
          statisticsPtr();
      assertThat(statistics).isNotNull();
      try (final Options anotherOptions = new Options()) {
        statistics = anotherOptions.statisticsPtr();
        assertThat(statistics).isNotNull();
>>>>>>> forknote/master
      }
    }
  }
}
