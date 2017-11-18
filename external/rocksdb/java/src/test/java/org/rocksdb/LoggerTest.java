package org.rocksdb;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> forknote/master
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class LoggerTest {
  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Rule
  public TemporaryFolder dbFolder = new TemporaryFolder();

<<<<<<< HEAD
  private AtomicInteger logMessageCounter = new AtomicInteger();

  @Test
  public void customLogger() throws RocksDBException {
    RocksDB db = null;
    logMessageCounter.set(0);
    try {

      // Setup options
      final Options options = new Options().
          setInfoLogLevel(InfoLogLevel.DEBUG_LEVEL).
          setCreateIfMissing(true);

      // Create new logger with max log level passed by options
      Logger logger = new Logger(options) {
        @Override
        protected void log(InfoLogLevel infoLogLevel, String logMsg) {
          assertThat(logMsg).isNotNull();
          assertThat(logMsg.length()).isGreaterThan(0);
          logMessageCounter.incrementAndGet();
        }
      };

      // Set custom logger to options
      options.setLogger(logger);

      db = RocksDB.open(options, dbFolder.getRoot().getAbsolutePath());

      // there should be more than zero received log messages in
      // debug level.
      assertThat(logMessageCounter.get()).isGreaterThan(0);
    } finally {
      if (db != null) {
        db.close();
      }
    }
    logMessageCounter.set(0);
=======
  @Test
  public void customLogger() throws RocksDBException {
    final AtomicInteger logMessageCounter = new AtomicInteger();
    try (final Options options = new Options().
        setInfoLogLevel(InfoLogLevel.DEBUG_LEVEL).
        setCreateIfMissing(true);
         final Logger logger = new Logger(options) {
           // Create new logger with max log level passed by options
           @Override
           protected void log(InfoLogLevel infoLogLevel, String logMsg) {
             assertThat(logMsg).isNotNull();
             assertThat(logMsg.length()).isGreaterThan(0);
             logMessageCounter.incrementAndGet();
           }
         }
    ) {
      // Set custom logger to options
      options.setLogger(logger);

      try (final RocksDB db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath())) {
        // there should be more than zero received log messages in
        // debug level.
        assertThat(logMessageCounter.get()).isGreaterThan(0);
      }
    }
  }

  @Test
  public void warnLogger() throws RocksDBException {
    final AtomicInteger logMessageCounter = new AtomicInteger();
    try (final Options options = new Options().
        setInfoLogLevel(InfoLogLevel.WARN_LEVEL).
        setCreateIfMissing(true);

         final Logger logger = new Logger(options) {
           // Create new logger with max log level passed by options
           @Override
           protected void log(InfoLogLevel infoLogLevel, String logMsg) {
             assertThat(logMsg).isNotNull();
             assertThat(logMsg.length()).isGreaterThan(0);
             logMessageCounter.incrementAndGet();
           }
         }
    ) {

      // Set custom logger to options
      options.setLogger(logger);

      try (final RocksDB db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath())) {
        // there should be zero messages
        // using warn level as log level.
        assertThat(logMessageCounter.get()).isEqualTo(0);
      }
    }
>>>>>>> forknote/master
  }


  @Test
  public void fatalLogger() throws RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    logMessageCounter.set(0);

    try {
      // Setup options
      final Options options = new Options().
          setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
          setCreateIfMissing(true);

      // Create new logger with max log level passed by options
      Logger logger = new Logger(options) {
        @Override
        protected void log(InfoLogLevel infoLogLevel, String logMsg) {
          assertThat(logMsg).isNotNull();
          assertThat(logMsg.length()).isGreaterThan(0);
          logMessageCounter.incrementAndGet();
        }
      };
=======
    final AtomicInteger logMessageCounter = new AtomicInteger();
    try (final Options options = new Options().
        setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
        setCreateIfMissing(true);

         final Logger logger = new Logger(options) {
           // Create new logger with max log level passed by options
           @Override
           protected void log(InfoLogLevel infoLogLevel, String logMsg) {
             assertThat(logMsg).isNotNull();
             assertThat(logMsg.length()).isGreaterThan(0);
             logMessageCounter.incrementAndGet();
           }
         }
    ) {
>>>>>>> forknote/master

      // Set custom logger to options
      options.setLogger(logger);

<<<<<<< HEAD
      db = RocksDB.open(options, dbFolder.getRoot().getAbsolutePath());

      // there should be zero messages
      // using fatal level as log level.
      assertThat(logMessageCounter.get()).isEqualTo(0);
    } finally {
      if (db != null) {
        db.close();
      }
    }
    logMessageCounter.set(0);
=======
      try (final RocksDB db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath())) {
        // there should be zero messages
        // using fatal level as log level.
        assertThat(logMessageCounter.get()).isEqualTo(0);
      }
    }
>>>>>>> forknote/master
  }

  @Test
  public void dbOptionsLogger() throws RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    Logger logger = null;
    List<ColumnFamilyHandle> cfHandles = new ArrayList<>();
    List<ColumnFamilyDescriptor> cfDescriptors = new ArrayList<>();
    cfDescriptors.add(new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY));

    logMessageCounter.set(0);
    try {
      // Setup options
      final DBOptions options = new DBOptions().
          setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
          setCreateIfMissing(true);

      // Create new logger with max log level passed by options
      logger = new Logger(options) {
        @Override
        protected void log(InfoLogLevel infoLogLevel, String logMsg) {
          assertThat(logMsg).isNotNull();
          assertThat(logMsg.length()).isGreaterThan(0);
          logMessageCounter.incrementAndGet();
        }
      };

      // Set custom logger to options
      options.setLogger(logger);
      db = RocksDB.open(options, dbFolder.getRoot().getAbsolutePath(),
          cfDescriptors, cfHandles);
      // there should be zero messages
      // using fatal level as log level.
      assertThat(logMessageCounter.get()).isEqualTo(0);
      logMessageCounter.set(0);
    } finally {
      for (ColumnFamilyHandle columnFamilyHandle : cfHandles) {
        columnFamilyHandle.dispose();
      }
      if (db != null) {
        db.close();
      }
      if (logger != null) {
        logger.dispose();
=======
    final AtomicInteger logMessageCounter = new AtomicInteger();
    try (final DBOptions options = new DBOptions().
        setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
        setCreateIfMissing(true);
         final Logger logger = new Logger(options) {
           // Create new logger with max log level passed by options
           @Override
           protected void log(InfoLogLevel infoLogLevel, String logMsg) {
             assertThat(logMsg).isNotNull();
             assertThat(logMsg.length()).isGreaterThan(0);
             logMessageCounter.incrementAndGet();
           }
         }
    ) {
      // Set custom logger to options
      options.setLogger(logger);

      final List<ColumnFamilyDescriptor> cfDescriptors =
          Arrays.asList(
              new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY));
      final List<ColumnFamilyHandle> cfHandles = new ArrayList<>();

      try (final RocksDB db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath(),
          cfDescriptors, cfHandles)) {
        try {
          // there should be zero messages
          // using fatal level as log level.
          assertThat(logMessageCounter.get()).isEqualTo(0);
        } finally {
          for (final ColumnFamilyHandle columnFamilyHandle : cfHandles) {
            columnFamilyHandle.close();
          }
        }
>>>>>>> forknote/master
      }
    }
  }

  @Test
<<<<<<< HEAD
  public void setInfoLogLevel() {
    Logger logger = null;
    try {
      // Setup options
      final Options options = new Options().
          setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
          setCreateIfMissing(true);

      // Create new logger with max log level passed by options
      logger = new Logger(options) {
        @Override
        protected void log(InfoLogLevel infoLogLevel, String logMsg) {
          assertThat(logMsg).isNotNull();
          assertThat(logMsg.length()).isGreaterThan(0);
          logMessageCounter.incrementAndGet();
        }
      };
=======
  public void setWarnLogLevel() {
    final AtomicInteger logMessageCounter = new AtomicInteger();
    try (final Options options = new Options().
        setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
        setCreateIfMissing(true);
         final Logger logger = new Logger(options) {
           // Create new logger with max log level passed by options
           @Override
           protected void log(InfoLogLevel infoLogLevel, String logMsg) {
             assertThat(logMsg).isNotNull();
             assertThat(logMsg.length()).isGreaterThan(0);
             logMessageCounter.incrementAndGet();
           }
         }
    ) {
      assertThat(logger.infoLogLevel()).
          isEqualTo(InfoLogLevel.FATAL_LEVEL);
      logger.setInfoLogLevel(InfoLogLevel.WARN_LEVEL);
      assertThat(logger.infoLogLevel()).
          isEqualTo(InfoLogLevel.WARN_LEVEL);
    }
  }

  @Test
  public void setInfoLogLevel() {
    final AtomicInteger logMessageCounter = new AtomicInteger();
    try (final Options options = new Options().
        setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
        setCreateIfMissing(true);
         final Logger logger = new Logger(options) {
           // Create new logger with max log level passed by options
           @Override
           protected void log(InfoLogLevel infoLogLevel, String logMsg) {
             assertThat(logMsg).isNotNull();
             assertThat(logMsg.length()).isGreaterThan(0);
             logMessageCounter.incrementAndGet();
           }
         }
    ) {
>>>>>>> forknote/master
      assertThat(logger.infoLogLevel()).
          isEqualTo(InfoLogLevel.FATAL_LEVEL);
      logger.setInfoLogLevel(InfoLogLevel.DEBUG_LEVEL);
      assertThat(logger.infoLogLevel()).
          isEqualTo(InfoLogLevel.DEBUG_LEVEL);
<<<<<<< HEAD
    } finally {
      if (logger != null) {
        logger.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void changeLogLevelAtRuntime() throws RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    logMessageCounter.set(0);

    try {
      // Setup options
      final Options options = new Options().
          setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
          setCreateIfMissing(true);

      // Create new logger with max log level passed by options
      Logger logger = new Logger(options) {
        @Override
        protected void log(InfoLogLevel infoLogLevel, String logMsg) {
          assertThat(logMsg).isNotNull();
          assertThat(logMsg.length()).isGreaterThan(0);
          logMessageCounter.incrementAndGet();
        }
      };

      // Set custom logger to options
      options.setLogger(logger);
      db = RocksDB.open(options, dbFolder.getRoot().getAbsolutePath());

      // there should be zero messages
      // using fatal level as log level.
      assertThat(logMessageCounter.get()).isEqualTo(0);

      // change log level to debug level
      logger.setInfoLogLevel(InfoLogLevel.DEBUG_LEVEL);

      db.put("key".getBytes(), "value".getBytes());
      db.flush(new FlushOptions().setWaitForFlush(true));

      // messages shall be received due to previous actions.
      assertThat(logMessageCounter.get()).isNotEqualTo(0);

    } finally {
      if (db != null) {
        db.close();
      }
    }
    logMessageCounter.set(0);
=======
    final AtomicInteger logMessageCounter = new AtomicInteger();
    try (final Options options = new Options().
        setInfoLogLevel(InfoLogLevel.FATAL_LEVEL).
        setCreateIfMissing(true);

         // Create new logger with max log level passed by options
         final Logger logger = new Logger(options) {
           @Override
           protected void log(InfoLogLevel infoLogLevel, String logMsg) {
             assertThat(logMsg).isNotNull();
             assertThat(logMsg.length()).isGreaterThan(0);
             logMessageCounter.incrementAndGet();
           }
         }
    ) {
      // Set custom logger to options
      options.setLogger(logger);

      try (final RocksDB db = RocksDB.open(options,
          dbFolder.getRoot().getAbsolutePath())) {

        // there should be zero messages
        // using fatal level as log level.
        assertThat(logMessageCounter.get()).isEqualTo(0);

        // change log level to debug level
        logger.setInfoLogLevel(InfoLogLevel.DEBUG_LEVEL);

        db.put("key".getBytes(), "value".getBytes());
        db.flush(new FlushOptions().setWaitForFlush(true));

        // messages shall be received due to previous actions.
        assertThat(logMessageCounter.get()).isNotEqualTo(0);
      }
    }
>>>>>>> forknote/master
  }
}
