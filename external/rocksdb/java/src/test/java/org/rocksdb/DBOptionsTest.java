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

import java.util.Properties;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class DBOptionsTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  public static final Random rand = PlatformRandomHelper.
      getPlatformSpecificRandomFactory();

  @Test
  public void getDBOptionsFromProps() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      // setup sample properties
      Properties properties = new Properties();
      properties.put("allow_mmap_reads", "true");
      properties.put("bytes_per_sync", "13");
      opt = DBOptions.getDBOptionsFromProps(properties);
=======
    // setup sample properties
    final Properties properties = new Properties();
    properties.put("allow_mmap_reads", "true");
    properties.put("bytes_per_sync", "13");
    try(final DBOptions opt = DBOptions.getDBOptionsFromProps(properties)) {
>>>>>>> forknote/master
      assertThat(opt).isNotNull();
      assertThat(String.valueOf(opt.allowMmapReads())).
          isEqualTo(properties.get("allow_mmap_reads"));
      assertThat(String.valueOf(opt.bytesPerSync())).
          isEqualTo(properties.get("bytes_per_sync"));
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
  public void failDBOptionsFromPropsWithIllegalValue() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      // setup sample properties
      Properties properties = new Properties();
      properties.put("tomato", "1024");
      properties.put("burger", "2");
      opt = DBOptions.
          getDBOptionsFromProps(properties);
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
    try(final DBOptions opt = DBOptions.getDBOptionsFromProps(properties)) {
      assertThat(opt).isNull();
>>>>>>> forknote/master
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void failDBOptionsFromPropsWithNullValue() {
<<<<<<< HEAD
    DBOptions.getDBOptionsFromProps(null);
=======
    try(final DBOptions opt = DBOptions.getDBOptionsFromProps(null)) {
      //no-op
    }
>>>>>>> forknote/master
  }

  @Test(expected = IllegalArgumentException.class)
  public void failDBOptionsFromPropsWithEmptyProps() {
<<<<<<< HEAD
    DBOptions.getDBOptionsFromProps(
        new Properties());
=======
    try(final DBOptions opt = DBOptions.getDBOptionsFromProps(
        new Properties())) {
      //no-op
    }
>>>>>>> forknote/master
  }

  @Test
  public void setIncreaseParallelism() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      final int threads = Runtime.getRuntime().availableProcessors() * 2;
      opt.setIncreaseParallelism(threads);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final int threads = Runtime.getRuntime().availableProcessors() * 2;
      opt.setIncreaseParallelism(threads);
>>>>>>> forknote/master
    }
  }

  @Test
  public void createIfMissing() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setCreateIfMissing(boolValue);
      assertThat(opt.createIfMissing()).
          isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setCreateIfMissing(boolValue);
      assertThat(opt.createIfMissing()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void createMissingColumnFamilies() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setCreateMissingColumnFamilies(boolValue);
      assertThat(opt.createMissingColumnFamilies()).
          isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setCreateMissingColumnFamilies(boolValue);
      assertThat(opt.createMissingColumnFamilies()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void errorIfExists() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setErrorIfExists(boolValue);
      assertThat(opt.errorIfExists()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setErrorIfExists(boolValue);
      assertThat(opt.errorIfExists()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void paranoidChecks() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setParanoidChecks(boolValue);
      assertThat(opt.paranoidChecks()).
          isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setParanoidChecks(boolValue);
      assertThat(opt.paranoidChecks()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxTotalWalSize() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setMaxTotalWalSize(longValue);
      assertThat(opt.maxTotalWalSize()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setMaxTotalWalSize(longValue);
      assertThat(opt.maxTotalWalSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxOpenFiles() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      int intValue = rand.nextInt();
      opt.setMaxOpenFiles(intValue);
      assertThat(opt.maxOpenFiles()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final int intValue = rand.nextInt();
      opt.setMaxOpenFiles(intValue);
      assertThat(opt.maxOpenFiles()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void disableDataSync() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setDisableDataSync(boolValue);
      assertThat(opt.disableDataSync()).
          isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setDisableDataSync(boolValue);
      assertThat(opt.disableDataSync()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void useFsync() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setUseFsync(boolValue);
      assertThat(opt.useFsync()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setUseFsync(boolValue);
      assertThat(opt.useFsync()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void dbLogDir() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      String str = "path/to/DbLogDir";
      opt.setDbLogDir(str);
      assertThat(opt.dbLogDir()).isEqualTo(str);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final String str = "path/to/DbLogDir";
      opt.setDbLogDir(str);
      assertThat(opt.dbLogDir()).isEqualTo(str);
>>>>>>> forknote/master
    }
  }

  @Test
  public void walDir() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      String str = "path/to/WalDir";
      opt.setWalDir(str);
      assertThat(opt.walDir()).isEqualTo(str);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final String str = "path/to/WalDir";
      opt.setWalDir(str);
      assertThat(opt.walDir()).isEqualTo(str);
>>>>>>> forknote/master
    }
  }

  @Test
  public void deleteObsoleteFilesPeriodMicros() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setDeleteObsoleteFilesPeriodMicros(longValue);
      assertThat(opt.deleteObsoleteFilesPeriodMicros()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setDeleteObsoleteFilesPeriodMicros(longValue);
      assertThat(opt.deleteObsoleteFilesPeriodMicros()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxBackgroundCompactions() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      int intValue = rand.nextInt();
      opt.setMaxBackgroundCompactions(intValue);
      assertThat(opt.maxBackgroundCompactions()).
          isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final int intValue = rand.nextInt();
      opt.setMaxBackgroundCompactions(intValue);
      assertThat(opt.maxBackgroundCompactions()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxBackgroundFlushes() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      int intValue = rand.nextInt();
      opt.setMaxBackgroundFlushes(intValue);
      assertThat(opt.maxBackgroundFlushes()).
          isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final int intValue = rand.nextInt();
      opt.setMaxBackgroundFlushes(intValue);
      assertThat(opt.maxBackgroundFlushes()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxLogFileSize() throws RocksDBException {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setMaxLogFileSize(longValue);
      assertThat(opt.maxLogFileSize()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setMaxLogFileSize(longValue);
      assertThat(opt.maxLogFileSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void logFileTimeToRoll() throws RocksDBException {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setLogFileTimeToRoll(longValue);
      assertThat(opt.logFileTimeToRoll()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setLogFileTimeToRoll(longValue);
      assertThat(opt.logFileTimeToRoll()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void keepLogFileNum() throws RocksDBException {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setKeepLogFileNum(longValue);
      assertThat(opt.keepLogFileNum()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setKeepLogFileNum(longValue);
      assertThat(opt.keepLogFileNum()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void maxManifestFileSize() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setMaxManifestFileSize(longValue);
      assertThat(opt.maxManifestFileSize()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setMaxManifestFileSize(longValue);
      assertThat(opt.maxManifestFileSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void tableCacheNumshardbits() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      int intValue = rand.nextInt();
      opt.setTableCacheNumshardbits(intValue);
      assertThat(opt.tableCacheNumshardbits()).
          isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final int intValue = rand.nextInt();
      opt.setTableCacheNumshardbits(intValue);
      assertThat(opt.tableCacheNumshardbits()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void walSizeLimitMB() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setWalSizeLimitMB(longValue);
      assertThat(opt.walSizeLimitMB()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setWalSizeLimitMB(longValue);
      assertThat(opt.walSizeLimitMB()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void walTtlSeconds() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setWalTtlSeconds(longValue);
      assertThat(opt.walTtlSeconds()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setWalTtlSeconds(longValue);
      assertThat(opt.walTtlSeconds()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void manifestPreallocationSize() throws RocksDBException {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setManifestPreallocationSize(longValue);
      assertThat(opt.manifestPreallocationSize()).
          isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setManifestPreallocationSize(longValue);
      assertThat(opt.manifestPreallocationSize()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void allowOsBuffer() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setAllowOsBuffer(boolValue);
      assertThat(opt.allowOsBuffer()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setAllowOsBuffer(boolValue);
      assertThat(opt.allowOsBuffer()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void allowMmapReads() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setAllowMmapReads(boolValue);
      assertThat(opt.allowMmapReads()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setAllowMmapReads(boolValue);
      assertThat(opt.allowMmapReads()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void allowMmapWrites() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setAllowMmapWrites(boolValue);
      assertThat(opt.allowMmapWrites()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setAllowMmapWrites(boolValue);
      assertThat(opt.allowMmapWrites()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void isFdCloseOnExec() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setIsFdCloseOnExec(boolValue);
      assertThat(opt.isFdCloseOnExec()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setIsFdCloseOnExec(boolValue);
      assertThat(opt.isFdCloseOnExec()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void statsDumpPeriodSec() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      int intValue = rand.nextInt();
      opt.setStatsDumpPeriodSec(intValue);
      assertThat(opt.statsDumpPeriodSec()).isEqualTo(intValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final int intValue = rand.nextInt();
      opt.setStatsDumpPeriodSec(intValue);
      assertThat(opt.statsDumpPeriodSec()).isEqualTo(intValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void adviseRandomOnOpen() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setAdviseRandomOnOpen(boolValue);
      assertThat(opt.adviseRandomOnOpen()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setAdviseRandomOnOpen(boolValue);
      assertThat(opt.adviseRandomOnOpen()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void useAdaptiveMutex() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      boolean boolValue = rand.nextBoolean();
      opt.setUseAdaptiveMutex(boolValue);
      assertThat(opt.useAdaptiveMutex()).isEqualTo(boolValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final boolean boolValue = rand.nextBoolean();
      opt.setUseAdaptiveMutex(boolValue);
      assertThat(opt.useAdaptiveMutex()).isEqualTo(boolValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void bytesPerSync() {
<<<<<<< HEAD
    DBOptions opt = null;
    try {
      opt = new DBOptions();
      long longValue = rand.nextLong();
      opt.setBytesPerSync(longValue);
      assertThat(opt.bytesPerSync()).isEqualTo(longValue);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try(final DBOptions opt = new DBOptions()) {
      final long longValue = rand.nextLong();
      opt.setBytesPerSync(longValue);
      assertThat(opt.bytesPerSync()).isEqualTo(longValue);
>>>>>>> forknote/master
    }
  }

  @Test
  public void rateLimiterConfig() {
<<<<<<< HEAD
    DBOptions options = null;
    DBOptions anotherOptions = null;
    try {
      options = new DBOptions();
      RateLimiterConfig rateLimiterConfig =
          new GenericRateLimiterConfig(1000, 100 * 1000, 1);
      options.setRateLimiterConfig(rateLimiterConfig);
      // Test with parameter initialization
      anotherOptions = new DBOptions();
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
    try(final DBOptions options = new DBOptions();
        final DBOptions anotherOptions = new DBOptions()) {
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
  public void statistics() {
<<<<<<< HEAD
    DBOptions options = new DBOptions();
    Statistics statistics = options.createStatistics().
        statisticsPtr();
    assertThat(statistics).isNotNull();

    DBOptions anotherOptions = new DBOptions();
    statistics = anotherOptions.statisticsPtr();
    assertThat(statistics).isNotNull();
=======
    try(final DBOptions options = new DBOptions()) {
      Statistics statistics = options.createStatistics().
          statisticsPtr();
      assertThat(statistics).isNotNull();

      try(final DBOptions anotherOptions = new DBOptions()) {
        statistics = anotherOptions.statisticsPtr();
        assertThat(statistics).isNotNull();
      }
    }
>>>>>>> forknote/master
  }
}
