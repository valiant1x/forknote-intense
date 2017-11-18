<<<<<<< HEAD
//  Copyright (c) 2013, Facebook, Inc.  All rights reserved.
=======
//  Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
//  This source code is licensed under the BSD-style license found in the
//  LICENSE file in the root directory of this source tree. An additional grant
//  of patent rights can be found in the PATENTS file in the same directory.
//
// Copyright (c) 2011 The LevelDB Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file. See the AUTHORS file for names of contributors.
#pragma once

#include <atomic>
#include <deque>
#include <limits>
#include <set>
#include <utility>
#include <vector>
#include <string>

<<<<<<< HEAD
#include "db/dbformat.h"
#include "db/column_family.h"
=======
#include "db/column_family.h"
#include "db/dbformat.h"
#include "db/flush_scheduler.h"
#include "db/internal_stats.h"
#include "db/job_context.h"
>>>>>>> forknote/master
#include "db/log_writer.h"
#include "db/memtable_list.h"
#include "db/snapshot_impl.h"
#include "db/version_edit.h"
<<<<<<< HEAD
=======
#include "db/write_controller.h"
#include "db/write_thread.h"
>>>>>>> forknote/master
#include "port/port.h"
#include "rocksdb/db.h"
#include "rocksdb/env.h"
#include "rocksdb/memtablerep.h"
#include "rocksdb/transaction_log.h"
<<<<<<< HEAD
=======
#include "table/scoped_arena_iterator.h"
>>>>>>> forknote/master
#include "util/autovector.h"
#include "util/event_logger.h"
#include "util/instrumented_mutex.h"
#include "util/stop_watch.h"
#include "util/thread_local.h"
<<<<<<< HEAD
#include "util/scoped_arena_iterator.h"
#include "db/internal_stats.h"
#include "db/write_controller.h"
#include "db/flush_scheduler.h"
#include "db/write_thread.h"
#include "db/job_context.h"
=======
>>>>>>> forknote/master

namespace rocksdb {

class MemTable;
class TableCache;
class Version;
class VersionEdit;
class VersionSet;
class Arena;

class FlushJob {
 public:
  // TODO(icanadi) make effort to reduce number of parameters here
  // IMPORTANT: mutable_cf_options needs to be alive while FlushJob is alive
  FlushJob(const std::string& dbname, ColumnFamilyData* cfd,
           const DBOptions& db_options,
           const MutableCFOptions& mutable_cf_options,
           const EnvOptions& env_options, VersionSet* versions,
           InstrumentedMutex* db_mutex, std::atomic<bool>* shutting_down,
           std::vector<SequenceNumber> existing_snapshots,
<<<<<<< HEAD
           JobContext* job_context, LogBuffer* log_buffer,
           Directory* db_directory, Directory* output_file_directory,
           CompressionType output_compression, Statistics* stats,
           EventLogger* event_logger);

  ~FlushJob();

  Status Run(FileMetaData* file_meta = nullptr);
=======
           SequenceNumber earliest_write_conflict_snapshot,
           JobContext* job_context, LogBuffer* log_buffer,
           Directory* db_directory, Directory* output_file_directory,
           CompressionType output_compression, Statistics* stats,
           EventLogger* event_logger, bool measure_io_stats);

  ~FlushJob();

  // Require db_mutex held
  void PickMemTable();
  Status Run(FileMetaData* file_meta = nullptr);
  TableProperties GetTableProperties() const { return table_properties_; }
>>>>>>> forknote/master

 private:
  void ReportStartedFlush();
  void ReportFlushInputSize(const autovector<MemTable*>& mems);
  void RecordFlushIOStats();
<<<<<<< HEAD
  Status WriteLevel0Table(const autovector<MemTable*>& mems, VersionEdit* edit,
                          FileMetaData* meta);
=======
  Status WriteLevel0Table();
>>>>>>> forknote/master
  const std::string& dbname_;
  ColumnFamilyData* cfd_;
  const DBOptions& db_options_;
  const MutableCFOptions& mutable_cf_options_;
  const EnvOptions& env_options_;
  VersionSet* versions_;
  InstrumentedMutex* db_mutex_;
  std::atomic<bool>* shutting_down_;
  std::vector<SequenceNumber> existing_snapshots_;
<<<<<<< HEAD
=======
  SequenceNumber earliest_write_conflict_snapshot_;
>>>>>>> forknote/master
  JobContext* job_context_;
  LogBuffer* log_buffer_;
  Directory* db_directory_;
  Directory* output_file_directory_;
  CompressionType output_compression_;
  Statistics* stats_;
  EventLogger* event_logger_;
<<<<<<< HEAD
=======
  TableProperties table_properties_;
  bool measure_io_stats_;

  // Variables below are set by PickMemTable():
  FileMetaData meta_;
  autovector<MemTable*> mems_;
  VersionEdit* edit_;
  Version* base_;
  bool pick_memtable_called;
>>>>>>> forknote/master
};

}  // namespace rocksdb
