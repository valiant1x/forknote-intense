<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

<<<<<<< HEAD
=======
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

>>>>>>> forknote/master
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

<<<<<<< HEAD
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class BackupableDBOptionsTest {

  private final static String ARBITRARY_PATH = "/tmp";
=======
public class BackupableDBOptionsTest {

  private final static String ARBITRARY_PATH =
      System.getProperty("java.io.tmpdir");
>>>>>>> forknote/master

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Rule
  public ExpectedException exception = ExpectedException.none();

  public static final Random rand = PlatformRandomHelper.
      getPlatformSpecificRandomFactory();

  @Test
  public void backupDir() {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions = null;
    try {
      backupableDBOptions = new BackupableDBOptions(ARBITRARY_PATH);
      assertThat(backupableDBOptions.backupDir()).
          isEqualTo(ARBITRARY_PATH);
    } finally {
      if (backupableDBOptions != null) {
        backupableDBOptions.dispose();
      }
=======
    try (final BackupableDBOptions backupableDBOptions =
             new BackupableDBOptions(ARBITRARY_PATH)) {
      assertThat(backupableDBOptions.backupDir()).
          isEqualTo(ARBITRARY_PATH);
>>>>>>> forknote/master
    }
  }

  @Test
  public void shareTableFiles() {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions = null;
    try {
      backupableDBOptions = new BackupableDBOptions(ARBITRARY_PATH);
      boolean value = rand.nextBoolean();
      backupableDBOptions.setShareTableFiles(value);
      assertThat(backupableDBOptions.shareTableFiles()).
          isEqualTo(value);
    } finally {
      if (backupableDBOptions != null) {
        backupableDBOptions.dispose();
      }
=======
    try (final BackupableDBOptions backupableDBOptions =
             new BackupableDBOptions(ARBITRARY_PATH)) {
      final boolean value = rand.nextBoolean();
      backupableDBOptions.setShareTableFiles(value);
      assertThat(backupableDBOptions.shareTableFiles()).
          isEqualTo(value);
>>>>>>> forknote/master
    }
  }

  @Test
  public void sync() {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions = null;
    try {
      backupableDBOptions = new BackupableDBOptions(ARBITRARY_PATH);
      boolean value = rand.nextBoolean();
      backupableDBOptions.setSync(value);
      assertThat(backupableDBOptions.sync()).isEqualTo(value);
    } finally {
      if (backupableDBOptions != null) {
        backupableDBOptions.dispose();
      }
=======
    try (final BackupableDBOptions backupableDBOptions =
             new BackupableDBOptions(ARBITRARY_PATH)) {
      final boolean value = rand.nextBoolean();
      backupableDBOptions.setSync(value);
      assertThat(backupableDBOptions.sync()).isEqualTo(value);
>>>>>>> forknote/master
    }
  }

  @Test
  public void destroyOldData() {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions = null;
    try {
      backupableDBOptions = new BackupableDBOptions(ARBITRARY_PATH);
      boolean value = rand.nextBoolean();
      backupableDBOptions.setDestroyOldData(value);
      assertThat(backupableDBOptions.destroyOldData()).
          isEqualTo(value);
    } finally {
      if (backupableDBOptions != null) {
        backupableDBOptions.dispose();
      }
=======
    try (final BackupableDBOptions backupableDBOptions =
             new BackupableDBOptions(ARBITRARY_PATH);) {
      final boolean value = rand.nextBoolean();
      backupableDBOptions.setDestroyOldData(value);
      assertThat(backupableDBOptions.destroyOldData()).
          isEqualTo(value);
>>>>>>> forknote/master
    }
  }

  @Test
  public void backupLogFiles() {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions = null;
    try {
      backupableDBOptions = new BackupableDBOptions(ARBITRARY_PATH);
      boolean value = rand.nextBoolean();
      backupableDBOptions.setBackupLogFiles(value);
      assertThat(backupableDBOptions.backupLogFiles()).
          isEqualTo(value);
    } finally {
      if (backupableDBOptions != null) {
        backupableDBOptions.dispose();
      }
=======
    try (final BackupableDBOptions backupableDBOptions =
             new BackupableDBOptions(ARBITRARY_PATH)) {
      final boolean value = rand.nextBoolean();
      backupableDBOptions.setBackupLogFiles(value);
      assertThat(backupableDBOptions.backupLogFiles()).
          isEqualTo(value);
>>>>>>> forknote/master
    }
  }

  @Test
  public void backupRateLimit() {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions = null;
    try {
      backupableDBOptions = new BackupableDBOptions(ARBITRARY_PATH);
      long value = Math.abs(rand.nextLong());
=======
    try (final BackupableDBOptions backupableDBOptions =
             new BackupableDBOptions(ARBITRARY_PATH)) {
      final long value = Math.abs(rand.nextLong());
>>>>>>> forknote/master
      backupableDBOptions.setBackupRateLimit(value);
      assertThat(backupableDBOptions.backupRateLimit()).
          isEqualTo(value);
      // negative will be mapped to 0
      backupableDBOptions.setBackupRateLimit(-1);
      assertThat(backupableDBOptions.backupRateLimit()).
          isEqualTo(0);
<<<<<<< HEAD
    } finally {
      if (backupableDBOptions != null) {
        backupableDBOptions.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void restoreRateLimit() {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions = null;
    try {
      backupableDBOptions = new BackupableDBOptions(ARBITRARY_PATH);
      long value = Math.abs(rand.nextLong());
=======
    try (final BackupableDBOptions backupableDBOptions =
             new BackupableDBOptions(ARBITRARY_PATH)) {
      final long value = Math.abs(rand.nextLong());
>>>>>>> forknote/master
      backupableDBOptions.setRestoreRateLimit(value);
      assertThat(backupableDBOptions.restoreRateLimit()).
          isEqualTo(value);
      // negative will be mapped to 0
      backupableDBOptions.setRestoreRateLimit(-1);
      assertThat(backupableDBOptions.restoreRateLimit()).
          isEqualTo(0);
<<<<<<< HEAD
    } finally {
      if (backupableDBOptions != null) {
        backupableDBOptions.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void shareFilesWithChecksum() {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions = null;
    try {
      backupableDBOptions = new BackupableDBOptions(ARBITRARY_PATH);
=======
    try (final BackupableDBOptions backupableDBOptions =
             new BackupableDBOptions(ARBITRARY_PATH)) {
>>>>>>> forknote/master
      boolean value = rand.nextBoolean();
      backupableDBOptions.setShareFilesWithChecksum(value);
      assertThat(backupableDBOptions.shareFilesWithChecksum()).
          isEqualTo(value);
<<<<<<< HEAD
    } finally {
      if (backupableDBOptions != null) {
        backupableDBOptions.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void failBackupDirIsNull() {
    exception.expect(IllegalArgumentException.class);
<<<<<<< HEAD
    new BackupableDBOptions(null);
  }

  @Test
  public void failBackupDirIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.backupDir();
  }

  @Test
  public void failSetShareTableFilesIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.setShareTableFiles(true);
  }

  @Test
  public void failShareTableFilesIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.shareTableFiles();
  }

  @Test
  public void failSetSyncIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.setSync(true);
  }

  @Test
  public void failSyncIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.sync();
  }

  @Test
  public void failSetDestroyOldDataIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.setDestroyOldData(true);
  }

  @Test
  public void failDestroyOldDataIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.destroyOldData();
  }

  @Test
  public void failSetBackupLogFilesIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.setBackupLogFiles(true);
  }

  @Test
  public void failBackupLogFilesIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.backupLogFiles();
  }

  @Test
  public void failSetBackupRateLimitIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.setBackupRateLimit(1);
  }

  @Test
  public void failBackupRateLimitIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.backupRateLimit();
  }

  @Test
  public void failSetRestoreRateLimitIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.setRestoreRateLimit(1);
  }

  @Test
  public void failRestoreRateLimitIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.restoreRateLimit();
  }

  @Test
  public void failSetShareFilesWithChecksumIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.setShareFilesWithChecksum(true);
  }

  @Test
  public void failShareFilesWithChecksumIfDisposed(){
    BackupableDBOptions options = setupUninitializedBackupableDBOptions(
        exception);
    options.shareFilesWithChecksum();
=======
    try (final BackupableDBOptions opts = new BackupableDBOptions(null)) {
      //no-op
    }
  }

  @Test
  public void failBackupDirIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.backupDir();
    }
  }

  @Test
  public void failSetShareTableFilesIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.setShareTableFiles(true);
    }
  }

  @Test
  public void failShareTableFilesIfDisposed() {
    try (BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.shareTableFiles();
    }
  }

  @Test
  public void failSetSyncIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.setSync(true);
    }
  }

  @Test
  public void failSyncIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.sync();
    }
  }

  @Test
  public void failSetDestroyOldDataIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.setDestroyOldData(true);
    }
  }

  @Test
  public void failDestroyOldDataIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.destroyOldData();
    }
  }

  @Test
  public void failSetBackupLogFilesIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.setBackupLogFiles(true);
    }
  }

  @Test
  public void failBackupLogFilesIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.backupLogFiles();
    }
  }

  @Test
  public void failSetBackupRateLimitIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.setBackupRateLimit(1);
    }
  }

  @Test
  public void failBackupRateLimitIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.backupRateLimit();
    }
  }

  @Test
  public void failSetRestoreRateLimitIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.setRestoreRateLimit(1);
    }
  }

  @Test
  public void failRestoreRateLimitIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.restoreRateLimit();
    }
  }

  @Test
  public void failSetShareFilesWithChecksumIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.setShareFilesWithChecksum(true);
    }
  }

  @Test
  public void failShareFilesWithChecksumIfDisposed() {
    try (final BackupableDBOptions options =
             setupUninitializedBackupableDBOptions(exception)) {
      options.shareFilesWithChecksum();
    }
>>>>>>> forknote/master
  }

  private BackupableDBOptions setupUninitializedBackupableDBOptions(
      ExpectedException exception) {
<<<<<<< HEAD
    BackupableDBOptions backupableDBOptions =
        new BackupableDBOptions(ARBITRARY_PATH);
    backupableDBOptions.dispose();
=======
    final BackupableDBOptions backupableDBOptions =
        new BackupableDBOptions(ARBITRARY_PATH);
    backupableDBOptions.close();
>>>>>>> forknote/master
    exception.expect(AssertionError.class);
    return backupableDBOptions;
  }
}
