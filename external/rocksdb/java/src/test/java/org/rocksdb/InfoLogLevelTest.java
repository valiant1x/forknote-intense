package org.rocksdb;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
<<<<<<< HEAD
=======
import org.rocksdb.util.Environment;
>>>>>>> forknote/master

import java.io.IOException;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static org.assertj.core.api.Assertions.assertThat;

public class InfoLogLevelTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Rule
  public TemporaryFolder dbFolder = new TemporaryFolder();

  @Test
  public void testInfoLogLevel() throws RocksDBException,
      IOException {
<<<<<<< HEAD
    RocksDB db = null;
    try {
      db = RocksDB.open(dbFolder.getRoot().getAbsolutePath());
      db.put("key".getBytes(), "value".getBytes());
      assertThat(getLogContentsWithoutHeader()).isNotEmpty();
    } finally {
      if (db != null) {
        db.close();
      }
=======
    try (final RocksDB db =
             RocksDB.open(dbFolder.getRoot().getAbsolutePath())) {
      db.put("key".getBytes(), "value".getBytes());
      assertThat(getLogContentsWithoutHeader()).isNotEmpty();
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
     public void testFatalLogLevel() throws RocksDBException,
      IOException {
    RocksDB db = null;
    Options options = null;
    try {
      options = new Options().
          setCreateIfMissing(true).
          setInfoLogLevel(InfoLogLevel.FATAL_LEVEL);
      assertThat(options.infoLogLevel()).
          isEqualTo(InfoLogLevel.FATAL_LEVEL);
      db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath());
=======
  public void testFatalLogLevel() throws RocksDBException,
      IOException {
    try (final Options options = new Options().
        setCreateIfMissing(true).
        setInfoLogLevel(InfoLogLevel.FATAL_LEVEL);
         final RocksDB db = RocksDB.open(options,
             dbFolder.getRoot().getAbsolutePath())) {
      assertThat(options.infoLogLevel()).
          isEqualTo(InfoLogLevel.FATAL_LEVEL);
>>>>>>> forknote/master
      db.put("key".getBytes(), "value".getBytes());
      // As InfoLogLevel is set to FATAL_LEVEL, here we expect the log
      // content to be empty.
      assertThat(getLogContentsWithoutHeader()).isEmpty();
<<<<<<< HEAD
    } finally {
      if (db != null) {
        db.close();
      }
      if (options != null) {
        options.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void testFatalLogLevelWithDBOptions()
      throws RocksDBException, IOException {
<<<<<<< HEAD
    RocksDB db = null;
    Options options = null;
    DBOptions dbOptions = null;
    try {
      dbOptions = new DBOptions().
          setInfoLogLevel(InfoLogLevel.FATAL_LEVEL);
      options = new Options(dbOptions,
          new ColumnFamilyOptions()).
          setCreateIfMissing(true);
=======
    try (final DBOptions dbOptions = new DBOptions().
        setInfoLogLevel(InfoLogLevel.FATAL_LEVEL);
         final Options options = new Options(dbOptions,
             new ColumnFamilyOptions()).
             setCreateIfMissing(true);
         final RocksDB db =
             RocksDB.open(options, dbFolder.getRoot().getAbsolutePath())) {
>>>>>>> forknote/master
      assertThat(dbOptions.infoLogLevel()).
          isEqualTo(InfoLogLevel.FATAL_LEVEL);
      assertThat(options.infoLogLevel()).
          isEqualTo(InfoLogLevel.FATAL_LEVEL);
<<<<<<< HEAD
      db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath());
      db.put("key".getBytes(), "value".getBytes());
      assertThat(getLogContentsWithoutHeader()).isEmpty();
    } finally {
      if (db != null) {
        db.close();
      }
      if (options != null) {
        options.dispose();
      }
      if (dbOptions != null) {
        dbOptions.dispose();
      }
=======
      db.put("key".getBytes(), "value".getBytes());
      assertThat(getLogContentsWithoutHeader()).isEmpty();
>>>>>>> forknote/master
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void failIfIllegalByteValueProvided() {
<<<<<<< HEAD
    InfoLogLevel.getInfoLogLevel((byte)-1);
=======
    InfoLogLevel.getInfoLogLevel((byte) -1);
>>>>>>> forknote/master
  }

  @Test
  public void valueOf() {
    assertThat(InfoLogLevel.valueOf("DEBUG_LEVEL")).
        isEqualTo(InfoLogLevel.DEBUG_LEVEL);
  }

  /**
   * Read LOG file contents into String.
   *
   * @return LOG file contents as String.
   * @throws IOException if file is not found.
   */
  private String getLogContentsWithoutHeader() throws IOException {
<<<<<<< HEAD
    final String separator = System.getProperty("line.separator");
    final String[] lines = new String(readAllBytes(get(
        dbFolder.getRoot().getAbsolutePath()+ "/LOG"))).split(separator);
=======
    final String separator = Environment.isWindows() ?
        "\n" : System.getProperty("line.separator");
    final String[] lines = new String(readAllBytes(get(
        dbFolder.getRoot().getAbsolutePath() + "/LOG"))).split(separator);
>>>>>>> forknote/master

    int first_non_header = lines.length;
    // Identify the last line of the header
    for (int i = lines.length - 1; i >= 0; --i) {
      if (lines[i].indexOf("Options.") >= 0 && lines[i].indexOf(':') >= 0) {
        first_non_header = i + 1;
        break;
      }
    }
    StringBuilder builder = new StringBuilder();
    for (int i = first_non_header; i < lines.length; ++i) {
      builder.append(lines[i]).append(separator);
    }
    return builder.toString();
  }
}
