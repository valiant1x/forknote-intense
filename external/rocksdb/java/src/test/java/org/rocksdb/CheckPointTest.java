package org.rocksdb;


import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckPointTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Rule
  public TemporaryFolder dbFolder = new TemporaryFolder();

  @Rule
  public TemporaryFolder checkpointFolder = new TemporaryFolder();

  @Test
  public void checkPoint() throws RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    Options options = null;
    Checkpoint checkpoint = null;
    try {
      options = new Options().
          setCreateIfMissing(true);
      db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath());
      db.put("key".getBytes(), "value".getBytes());
      checkpoint = Checkpoint.create(db);
      checkpoint.createCheckpoint(checkpointFolder.
          getRoot().getAbsolutePath() + "/snapshot1");
      db.put("key2".getBytes(), "value2".getBytes());
      checkpoint.createCheckpoint(checkpointFolder.
          getRoot().getAbsolutePath() + "/snapshot2");
      db.close();
      db = RocksDB.open(options,
          checkpointFolder.getRoot().getAbsolutePath() +
              "/snapshot1");
      assertThat(new String(db.get("key".getBytes()))).
          isEqualTo("value");
      assertThat(db.get("key2".getBytes())).isNull();
      db.close();
      db = RocksDB.open(options,
          checkpointFolder.getRoot().getAbsolutePath() +
              "/snapshot2");
      assertThat(new String(db.get("key".getBytes()))).
          isEqualTo("value");
      assertThat(new String(db.get("key2".getBytes()))).
          isEqualTo("value2");
    } finally {
      if (db != null) {
        db.close();
      }
      if (options != null) {
        options.dispose();
      }
      if (checkpoint != null) {
        checkpoint.dispose();
=======
    try (final Options options = new Options().
        setCreateIfMissing(true)) {

      try (final RocksDB db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath())) {
        db.put("key".getBytes(), "value".getBytes());
        try (final Checkpoint checkpoint = Checkpoint.create(db)) {
          checkpoint.createCheckpoint(checkpointFolder.
              getRoot().getAbsolutePath() + "/snapshot1");
          db.put("key2".getBytes(), "value2".getBytes());
          checkpoint.createCheckpoint(checkpointFolder.
              getRoot().getAbsolutePath() + "/snapshot2");
        }
      }

      try (final RocksDB db = RocksDB.open(options,
          checkpointFolder.getRoot().getAbsolutePath() +
              "/snapshot1")) {
        assertThat(new String(db.get("key".getBytes()))).
            isEqualTo("value");
        assertThat(db.get("key2".getBytes())).isNull();
      }

      try (final RocksDB db = RocksDB.open(options,
          checkpointFolder.getRoot().getAbsolutePath() +
              "/snapshot2")) {
        assertThat(new String(db.get("key".getBytes()))).
            isEqualTo("value");
        assertThat(new String(db.get("key2".getBytes()))).
            isEqualTo("value2");
>>>>>>> forknote/master
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void failIfDbIsNull() {
<<<<<<< HEAD
    Checkpoint.create(null);
=======
    try (final Checkpoint checkpoint = Checkpoint.create(null)) {

    }
>>>>>>> forknote/master
  }

  @Test(expected = IllegalStateException.class)
  public void failIfDbNotInitialized() throws RocksDBException {
<<<<<<< HEAD
    RocksDB db = RocksDB.open(dbFolder.getRoot().getAbsolutePath());
    db.dispose();
    Checkpoint.create(db);
=======
    try (final RocksDB db = RocksDB.open(
        dbFolder.getRoot().getAbsolutePath())) {
      db.close();
      Checkpoint.create(db);
    }
>>>>>>> forknote/master
  }

  @Test(expected = RocksDBException.class)
  public void failWithIllegalPath() throws RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    Checkpoint checkpoint = null;
    try {
      db = RocksDB.open(dbFolder.getRoot().getAbsolutePath());
      checkpoint = Checkpoint.create(db);
      checkpoint.createCheckpoint("/Z:///:\\C:\\TZ/-");
    } finally {
      if (db != null) {
        db.close();
      }
      if (checkpoint != null) {
        checkpoint.dispose();
      }
=======
    try (final RocksDB db = RocksDB.open(dbFolder.getRoot().getAbsolutePath());
         final Checkpoint checkpoint = Checkpoint.create(db)) {
      checkpoint.createCheckpoint("/Z:///:\\C:\\TZ/-");
>>>>>>> forknote/master
    }
  }
}
