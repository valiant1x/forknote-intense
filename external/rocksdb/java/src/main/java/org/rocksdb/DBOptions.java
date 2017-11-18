<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

import java.util.Properties;

/**
 * DBOptions to control the behavior of a database.  It will be used
 * during the creation of a {@link org.rocksdb.RocksDB} (i.e., RocksDB.open()).
 *
<<<<<<< HEAD
 * If {@link #dispose()} function is not called, then it will be GC'd automatically
 * and native resources will be released as part of the process.
=======
 * If {@link #dispose()} function is not called, then it will be GC'd
 * automatically and native resources will be released as part of the process.
>>>>>>> forknote/master
 */
public class DBOptions extends RocksObject implements DBOptionsInterface {
  static {
    RocksDB.loadLibrary();
  }

  /**
   * Construct DBOptions.
   *
   * This constructor will create (by allocating a block of memory)
   * an {@code rocksdb::DBOptions} in the c++ side.
   */
  public DBOptions() {
<<<<<<< HEAD
    super();
    numShardBits_ = DEFAULT_NUM_SHARD_BITS;
    newDBOptions();
=======
    super(newDBOptions());
    numShardBits_ = DEFAULT_NUM_SHARD_BITS;
>>>>>>> forknote/master
  }

  /**
   * <p>Method to get a options instance by using pre-configured
   * property values. If one or many values are undefined in
   * the context of RocksDB the method will return a null
   * value.</p>
   *
   * <p><strong>Note</strong>: Property keys can be derived from
   * getter methods within the options class. Example: the method
   * {@code allowMmapReads()} has a property key:
   * {@code allow_mmap_reads}.</p>
   *
   * @param properties {@link java.util.Properties} instance.
   *
   * @return {@link org.rocksdb.DBOptions instance}
   *     or null.
   *
   * @throws java.lang.IllegalArgumentException if null or empty
   *     {@link java.util.Properties} instance is passed to the method call.
   */
  public static DBOptions getDBOptionsFromProps(
      final Properties properties) {
    if (properties == null || properties.size() == 0) {
      throw new IllegalArgumentException(
          "Properties value must contain at least one value.");
    }
    DBOptions dbOptions = null;
    StringBuilder stringBuilder = new StringBuilder();
    for (final String name : properties.stringPropertyNames()){
      stringBuilder.append(name);
      stringBuilder.append("=");
      stringBuilder.append(properties.getProperty(name));
      stringBuilder.append(";");
    }
    long handle = getDBOptionsFromProps(
        stringBuilder.toString());
    if (handle != 0){
      dbOptions = new DBOptions(handle);
    }
    return dbOptions;
  }

  @Override
  public DBOptions setIncreaseParallelism(
      final int totalThreads) {
<<<<<<< HEAD
    assert (isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setIncreaseParallelism(nativeHandle_, totalThreads);
    return this;
  }

  @Override
  public DBOptions setCreateIfMissing(final boolean flag) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setCreateIfMissing(nativeHandle_, flag);
    return this;
  }

  @Override
  public boolean createIfMissing() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return createIfMissing(nativeHandle_);
  }

  @Override
  public DBOptions setCreateMissingColumnFamilies(
      final boolean flag) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setCreateMissingColumnFamilies(nativeHandle_, flag);
    return this;
  }

  @Override
  public boolean createMissingColumnFamilies() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return createMissingColumnFamilies(nativeHandle_);
  }

  @Override
  public DBOptions setErrorIfExists(
      final boolean errorIfExists) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setErrorIfExists(nativeHandle_, errorIfExists);
    return this;
  }

  @Override
  public boolean errorIfExists() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return errorIfExists(nativeHandle_);
  }

  @Override
  public DBOptions setParanoidChecks(
      final boolean paranoidChecks) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setParanoidChecks(nativeHandle_, paranoidChecks);
    return this;
  }

  @Override
  public boolean paranoidChecks() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return paranoidChecks(nativeHandle_);
  }

  @Override
  public DBOptions setRateLimiterConfig(
      final RateLimiterConfig config) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    rateLimiterConfig_ = config;
    setRateLimiter(nativeHandle_, config.newRateLimiterHandle());
    return this;
  }

  @Override
  public DBOptions setLogger(final Logger logger) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setLogger(nativeHandle_, logger.nativeHandle_);
    return this;
  }

  @Override
  public DBOptions setInfoLogLevel(
      final InfoLogLevel infoLogLevel) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setInfoLogLevel(nativeHandle_, infoLogLevel.getValue());
    return this;
  }

  @Override
  public InfoLogLevel infoLogLevel() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return InfoLogLevel.getInfoLogLevel(
        infoLogLevel(nativeHandle_));
  }

  @Override
  public DBOptions setMaxOpenFiles(
      final int maxOpenFiles) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setMaxOpenFiles(nativeHandle_, maxOpenFiles);
    return this;
  }

  @Override
  public int maxOpenFiles() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return maxOpenFiles(nativeHandle_);
  }

  @Override
  public DBOptions setMaxTotalWalSize(
      final long maxTotalWalSize) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setMaxTotalWalSize(nativeHandle_, maxTotalWalSize);
    return this;
  }

  @Override
  public long maxTotalWalSize() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return maxTotalWalSize(nativeHandle_);
  }

  @Override
  public DBOptions createStatistics() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    createStatistics(nativeHandle_);
    return this;
  }

  @Override
  public Statistics statisticsPtr() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master

    long statsPtr = statisticsPtr(nativeHandle_);
    if(statsPtr == 0) {
      createStatistics();
      statsPtr = statisticsPtr(nativeHandle_);
    }

    return new Statistics(statsPtr);
  }

  @Override
  public DBOptions setDisableDataSync(
      final boolean disableDataSync) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setDisableDataSync(nativeHandle_, disableDataSync);
    return this;
  }

  @Override
  public boolean disableDataSync() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return disableDataSync(nativeHandle_);
  }

  @Override
  public DBOptions setUseFsync(
      final boolean useFsync) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setUseFsync(nativeHandle_, useFsync);
    return this;
  }

  @Override
  public boolean useFsync() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return useFsync(nativeHandle_);
  }

  @Override
  public DBOptions setDbLogDir(
      final String dbLogDir) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setDbLogDir(nativeHandle_, dbLogDir);
    return this;
  }

  @Override
  public String dbLogDir() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return dbLogDir(nativeHandle_);
  }

  @Override
  public DBOptions setWalDir(
      final String walDir) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setWalDir(nativeHandle_, walDir);
    return this;
  }

  @Override
  public String walDir() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return walDir(nativeHandle_);
  }

  @Override
  public DBOptions setDeleteObsoleteFilesPeriodMicros(
      final long micros) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setDeleteObsoleteFilesPeriodMicros(nativeHandle_, micros);
    return this;
  }

  @Override
  public long deleteObsoleteFilesPeriodMicros() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return deleteObsoleteFilesPeriodMicros(nativeHandle_);
  }

  @Override
  public DBOptions setMaxBackgroundCompactions(
      final int maxBackgroundCompactions) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setMaxBackgroundCompactions(nativeHandle_, maxBackgroundCompactions);
    return this;
  }

  @Override
  public int maxBackgroundCompactions() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return maxBackgroundCompactions(nativeHandle_);
  }

  @Override
  public DBOptions setMaxBackgroundFlushes(
      final int maxBackgroundFlushes) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setMaxBackgroundFlushes(nativeHandle_, maxBackgroundFlushes);
    return this;
  }

  @Override
  public int maxBackgroundFlushes() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return maxBackgroundFlushes(nativeHandle_);
  }

  @Override
  public DBOptions setMaxLogFileSize(
      final long maxLogFileSize) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setMaxLogFileSize(nativeHandle_, maxLogFileSize);
    return this;
  }

  @Override
  public long maxLogFileSize() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return maxLogFileSize(nativeHandle_);
  }

  @Override
  public DBOptions setLogFileTimeToRoll(
      final long logFileTimeToRoll) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setLogFileTimeToRoll(nativeHandle_, logFileTimeToRoll);
    return this;
  }

  @Override
  public long logFileTimeToRoll() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return logFileTimeToRoll(nativeHandle_);
  }

  @Override
  public DBOptions setKeepLogFileNum(
      final long keepLogFileNum) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setKeepLogFileNum(nativeHandle_, keepLogFileNum);
    return this;
  }

  @Override
  public long keepLogFileNum() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return keepLogFileNum(nativeHandle_);
  }

  @Override
  public DBOptions setMaxManifestFileSize(
      final long maxManifestFileSize) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setMaxManifestFileSize(nativeHandle_, maxManifestFileSize);
    return this;
  }

  @Override
  public long maxManifestFileSize() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return maxManifestFileSize(nativeHandle_);
  }

  @Override
  public DBOptions setTableCacheNumshardbits(
      final int tableCacheNumshardbits) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setTableCacheNumshardbits(nativeHandle_, tableCacheNumshardbits);
    return this;
  }

  @Override
  public int tableCacheNumshardbits() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return tableCacheNumshardbits(nativeHandle_);
  }

  @Override
  public DBOptions setWalTtlSeconds(
      final long walTtlSeconds) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setWalTtlSeconds(nativeHandle_, walTtlSeconds);
    return this;
  }

  @Override
  public long walTtlSeconds() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return walTtlSeconds(nativeHandle_);
  }

  @Override
  public DBOptions setWalSizeLimitMB(
      final long sizeLimitMB) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setWalSizeLimitMB(nativeHandle_, sizeLimitMB);
    return this;
  }

  @Override
  public long walSizeLimitMB() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return walSizeLimitMB(nativeHandle_);
  }

  @Override
  public DBOptions setManifestPreallocationSize(
      final long size) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setManifestPreallocationSize(nativeHandle_, size);
    return this;
  }

  @Override
  public long manifestPreallocationSize() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return manifestPreallocationSize(nativeHandle_);
  }

  @Override
  public DBOptions setAllowOsBuffer(
      final boolean allowOsBuffer) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setAllowOsBuffer(nativeHandle_, allowOsBuffer);
    return this;
  }

  @Override
  public boolean allowOsBuffer() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return allowOsBuffer(nativeHandle_);
  }

  @Override
  public DBOptions setAllowMmapReads(
      final boolean allowMmapReads) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setAllowMmapReads(nativeHandle_, allowMmapReads);
    return this;
  }

  @Override
  public boolean allowMmapReads() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return allowMmapReads(nativeHandle_);
  }

  @Override
  public DBOptions setAllowMmapWrites(
      final boolean allowMmapWrites) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setAllowMmapWrites(nativeHandle_, allowMmapWrites);
    return this;
  }

  @Override
  public boolean allowMmapWrites() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return allowMmapWrites(nativeHandle_);
  }

  @Override
  public DBOptions setIsFdCloseOnExec(
      final boolean isFdCloseOnExec) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setIsFdCloseOnExec(nativeHandle_, isFdCloseOnExec);
    return this;
  }

  @Override
  public boolean isFdCloseOnExec() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return isFdCloseOnExec(nativeHandle_);
  }

  @Override
  public DBOptions setStatsDumpPeriodSec(
      final int statsDumpPeriodSec) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setStatsDumpPeriodSec(nativeHandle_, statsDumpPeriodSec);
    return this;
  }

  @Override
  public int statsDumpPeriodSec() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return statsDumpPeriodSec(nativeHandle_);
  }

  @Override
  public DBOptions setAdviseRandomOnOpen(
      final boolean adviseRandomOnOpen) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setAdviseRandomOnOpen(nativeHandle_, adviseRandomOnOpen);
    return this;
  }

  @Override
  public boolean adviseRandomOnOpen() {
    return adviseRandomOnOpen(nativeHandle_);
  }

  @Override
  public DBOptions setUseAdaptiveMutex(
      final boolean useAdaptiveMutex) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setUseAdaptiveMutex(nativeHandle_, useAdaptiveMutex);
    return this;
  }

  @Override
  public boolean useAdaptiveMutex() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return useAdaptiveMutex(nativeHandle_);
  }

  @Override
  public DBOptions setBytesPerSync(
      final long bytesPerSync) {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    setBytesPerSync(nativeHandle_, bytesPerSync);
    return this;
  }

  @Override
  public long bytesPerSync() {
    return bytesPerSync(nativeHandle_);
  }

<<<<<<< HEAD
  /**
   * Release the memory allocated for the current instance
   * in the c++ side.
   */
  @Override protected void disposeInternal() {
    assert(isInitialized());
    disposeInternal(nativeHandle_);
  }

=======
>>>>>>> forknote/master
  static final int DEFAULT_NUM_SHARD_BITS = -1;

  /**
   * <p>Private constructor to be used by
   * {@link #getDBOptionsFromProps(java.util.Properties)}</p>
   *
<<<<<<< HEAD
   * @param handle native handle to DBOptions instance.
   */
  private DBOptions(final long handle) {
    super();
    nativeHandle_ = handle;
=======
   * @param nativeHandle native handle to DBOptions instance.
   */
  private DBOptions(final long nativeHandle) {
    super(nativeHandle);
>>>>>>> forknote/master
  }

  private static native long getDBOptionsFromProps(
      String optString);

<<<<<<< HEAD
  private native void newDBOptions();
  private native void disposeInternal(long handle);
=======
  private native static long newDBOptions();
  @Override protected final native void disposeInternal(final long handle);
>>>>>>> forknote/master

  private native void setIncreaseParallelism(long handle, int totalThreads);
  private native void setCreateIfMissing(long handle, boolean flag);
  private native boolean createIfMissing(long handle);
  private native void setCreateMissingColumnFamilies(
      long handle, boolean flag);
  private native boolean createMissingColumnFamilies(long handle);
  private native void setErrorIfExists(long handle, boolean errorIfExists);
  private native boolean errorIfExists(long handle);
  private native void setParanoidChecks(
      long handle, boolean paranoidChecks);
  private native boolean paranoidChecks(long handle);
  private native void setRateLimiter(long handle,
      long rateLimiterHandle);
  private native void setLogger(long handle,
      long loggerHandle);
  private native void setInfoLogLevel(long handle, byte logLevel);
  private native byte infoLogLevel(long handle);
  private native void setMaxOpenFiles(long handle, int maxOpenFiles);
  private native int maxOpenFiles(long handle);
  private native void setMaxTotalWalSize(long handle,
      long maxTotalWalSize);
  private native long maxTotalWalSize(long handle);
  private native void createStatistics(long optHandle);
  private native long statisticsPtr(long optHandle);
  private native void setDisableDataSync(long handle, boolean disableDataSync);
  private native boolean disableDataSync(long handle);
  private native boolean useFsync(long handle);
  private native void setUseFsync(long handle, boolean useFsync);
  private native void setDbLogDir(long handle, String dbLogDir);
  private native String dbLogDir(long handle);
  private native void setWalDir(long handle, String walDir);
  private native String walDir(long handle);
  private native void setDeleteObsoleteFilesPeriodMicros(
      long handle, long micros);
  private native long deleteObsoleteFilesPeriodMicros(long handle);
  private native void setMaxBackgroundCompactions(
      long handle, int maxBackgroundCompactions);
  private native int maxBackgroundCompactions(long handle);
  private native void setMaxBackgroundFlushes(
      long handle, int maxBackgroundFlushes);
  private native int maxBackgroundFlushes(long handle);
  private native void setMaxLogFileSize(long handle, long maxLogFileSize)
      throws IllegalArgumentException;
  private native long maxLogFileSize(long handle);
  private native void setLogFileTimeToRoll(
      long handle, long logFileTimeToRoll) throws IllegalArgumentException;
  private native long logFileTimeToRoll(long handle);
  private native void setKeepLogFileNum(long handle, long keepLogFileNum)
      throws IllegalArgumentException;
  private native long keepLogFileNum(long handle);
  private native void setMaxManifestFileSize(
      long handle, long maxManifestFileSize);
  private native long maxManifestFileSize(long handle);
  private native void setTableCacheNumshardbits(
      long handle, int tableCacheNumshardbits);
  private native int tableCacheNumshardbits(long handle);
  private native void setWalTtlSeconds(long handle, long walTtlSeconds);
  private native long walTtlSeconds(long handle);
  private native void setWalSizeLimitMB(long handle, long sizeLimitMB);
  private native long walSizeLimitMB(long handle);
  private native void setManifestPreallocationSize(
      long handle, long size) throws IllegalArgumentException;
  private native long manifestPreallocationSize(long handle);
  private native void setAllowOsBuffer(
      long handle, boolean allowOsBuffer);
  private native boolean allowOsBuffer(long handle);
  private native void setAllowMmapReads(
      long handle, boolean allowMmapReads);
  private native boolean allowMmapReads(long handle);
  private native void setAllowMmapWrites(
      long handle, boolean allowMmapWrites);
  private native boolean allowMmapWrites(long handle);
  private native void setIsFdCloseOnExec(
      long handle, boolean isFdCloseOnExec);
  private native boolean isFdCloseOnExec(long handle);
  private native void setStatsDumpPeriodSec(
      long handle, int statsDumpPeriodSec);
  private native int statsDumpPeriodSec(long handle);
  private native void setAdviseRandomOnOpen(
      long handle, boolean adviseRandomOnOpen);
  private native boolean adviseRandomOnOpen(long handle);
  private native void setUseAdaptiveMutex(
      long handle, boolean useAdaptiveMutex);
  private native boolean useAdaptiveMutex(long handle);
  private native void setBytesPerSync(
      long handle, long bytesPerSync);
  private native long bytesPerSync(long handle);

  int numShardBits_;
  RateLimiterConfig rateLimiterConfig_;
}
