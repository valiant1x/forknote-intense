// Copyright (c) 2014 The LevelDB Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file. See the AUTHORS file for names of contributors.

#pragma once

<<<<<<< HEAD
#include <string>
=======
#include <memory>
#include <string>
#include <unordered_map>
>>>>>>> forknote/master
#include <vector>
#include "rocksdb/compaction_job_stats.h"
#include "rocksdb/status.h"
#include "rocksdb/table_properties.h"

namespace rocksdb {

<<<<<<< HEAD
class DB;
class Status;
struct CompactionJobStats;

struct TableFileCreationInfo {
  TableFileCreationInfo() = default;
  explicit TableFileCreationInfo(TableProperties&& prop) :
      table_properties(prop) {}
=======
typedef std::unordered_map<std::string, std::shared_ptr<const TableProperties>>
    TablePropertiesCollection;

class DB;
class Status;
struct CompactionJobStats;
enum CompressionType : unsigned char;

enum class TableFileCreationReason {
  kFlush,
  kCompaction,
  kRecovery,
};

struct TableFileCreationBriefInfo {
>>>>>>> forknote/master
  // the name of the database where the file was created
  std::string db_name;
  // the name of the column family where the file was created.
  std::string cf_name;
  // the path to the created file.
  std::string file_path;
<<<<<<< HEAD
  // the size of the file.
  uint64_t file_size;
  // the id of the job (which could be flush or compaction) that
  // created the file.
  int job_id;
  // Detailed properties of the created file.
  TableProperties table_properties;
};

=======
  // the id of the job (which could be flush or compaction) that
  // created the file.
  int job_id;
  // reason of creating the table.
  TableFileCreationReason reason;
};

struct TableFileCreationInfo : public TableFileCreationBriefInfo {
  TableFileCreationInfo() = default;
  explicit TableFileCreationInfo(TableProperties&& prop)
      : table_properties(prop) {}
  // the size of the file.
  uint64_t file_size;
  // Detailed properties of the created file.
  TableProperties table_properties;
  // The status indicating whether the creation was successful or not.
  Status status;
};

enum class CompactionReason {
  kUnknown,
  // [Level] number of L0 files > level0_file_num_compaction_trigger
  kLevelL0FilesNum,
  // [Level] total size of level > MaxBytesForLevel()
  kLevelMaxLevelSize,
  // [Universal] Compacting for size amplification
  kUniversalSizeAmplification,
  // [Universal] Compacting for size ratio
  kUniversalSizeRatio,
  // [Universal] number of sorted runs > level0_file_num_compaction_trigger
  kUniversalSortedRunNum,
  // [FIFO] total size > max_table_files_size
  kFIFOMaxSize,
  // Manual compaction
  kManualCompaction,
  // DB::SuggestCompactRange() marked files for compaction
  kFilesMarkedForCompaction,
};
>>>>>>> forknote/master

#ifndef ROCKSDB_LITE

struct TableFileDeletionInfo {
  // The name of the database where the file was deleted.
  std::string db_name;
  // The path to the deleted file.
  std::string file_path;
  // The id of the job which deleted the file.
  int job_id;
<<<<<<< HEAD
  // The status indicating whether the deletion was successfull or not.
=======
  // The status indicating whether the deletion was successful or not.
>>>>>>> forknote/master
  Status status;
};

struct FlushJobInfo {
  // the name of the column family
  std::string cf_name;
  // the path to the newly created file
  std::string file_path;
  // the id of the thread that completed this flush job.
  uint64_t thread_id;
  // the job id, which is unique in the same thread.
  int job_id;
  // If true, then rocksdb is currently slowing-down all writes to prevent
  // creating too many Level 0 files as compaction seems not able to
  // catch up the write request speed.  This indicates that there are
  // too many files in Level 0.
  bool triggered_writes_slowdown;
  // If true, then rocksdb is currently blocking any writes to prevent
  // creating more L0 files.  This indicates that there are too many
  // files in level 0.  Compactions should try to compact L0 files down
  // to lower levels as soon as possible.
  bool triggered_writes_stop;
  // The smallest sequence number in the newly created file
  SequenceNumber smallest_seqno;
  // The largest sequence number in the newly created file
  SequenceNumber largest_seqno;
<<<<<<< HEAD
=======
  // Table properties of the table being flushed
  TableProperties table_properties;
>>>>>>> forknote/master
};

struct CompactionJobInfo {
  CompactionJobInfo() = default;
  explicit CompactionJobInfo(const CompactionJobStats& _stats) :
      stats(_stats) {}

  // the name of the column family where the compaction happened.
  std::string cf_name;
  // the status indicating whether the compaction was successful or not.
  Status status;
  // the id of the thread that completed this compaction job.
  uint64_t thread_id;
  // the job id, which is unique in the same thread.
  int job_id;
  // the smallest input level of the compaction.
  int base_input_level;
  // the output level of the compaction.
  int output_level;
  // the names of the compaction input files.
  std::vector<std::string> input_files;
<<<<<<< HEAD
  // the names of the compaction output files.
  std::vector<std::string> output_files;
=======

  // the names of the compaction output files.
  std::vector<std::string> output_files;
  // Table properties for input and output tables.
  // The map is keyed by values from input_files and output_files.
  TablePropertiesCollection table_properties;

  // Reason to run the compaction
  CompactionReason compaction_reason;

  // Compression algorithm used for output files
  CompressionType compression;

>>>>>>> forknote/master
  // If non-null, this variable stores detailed information
  // about this compaction.
  CompactionJobStats stats;
};

<<<<<<< HEAD
=======
struct MemTableInfo {
  // the name of the column family to which memtable belongs
  std::string cf_name;
  // Sequence number of the first element that was inserted
  // into the memtable.
  SequenceNumber first_seqno;
  // Sequence number that is guaranteed to be smaller than or equal
  // to the sequence number of any key that could be inserted into this
  // memtable. It can then be assumed that any write with a larger(or equal)
  // sequence number will be present in this memtable or a later memtable.
  SequenceNumber earliest_seqno;
  // Total number of entries in memtable
  uint64_t num_entries;
  // Total number of deletes in memtable
  uint64_t num_deletes;

};

>>>>>>> forknote/master
// EventListener class contains a set of call-back functions that will
// be called when specific RocksDB event happens such as flush.  It can
// be used as a building block for developing custom features such as
// stats-collector or external compaction algorithm.
//
// Note that call-back functions should not run for an extended period of
// time before the function returns, otherwise RocksDB may be blocked.
// For example, it is not suggested to do DB::CompactFiles() (as it may
// run for a long while) or issue many of DB::Put() (as Put may be blocked
// in certain cases) in the same thread in the EventListener callback.
// However, doing DB::CompactFiles() and DB::Put() in another thread is
// considered safe.
//
// [Threading] All EventListener callback will be called using the
// actual thread that involves in that specific event.   For example, it
// is the RocksDB background flush thread that does the actual flush to
// call EventListener::OnFlushCompleted().
//
// [Locking] All EventListener callbacks are designed to be called without
// the current thread holding any DB mutex. This is to prevent potential
// deadlock and performance issue when using EventListener callback
// in a complex way. However, all EventListener call-back functions
// should not run for an extended period of time before the function
// returns, otherwise RocksDB may be blocked. For example, it is not
// suggested to do DB::CompactFiles() (as it may run for a long while)
// or issue many of DB::Put() (as Put may be blocked in certain cases)
// in the same thread in the EventListener callback. However, doing
// DB::CompactFiles() and DB::Put() in a thread other than the
// EventListener callback thread is considered safe.
class EventListener {
 public:
  // A call-back function to RocksDB which will be called whenever a
  // registered RocksDB flushes a file.  The default implementation is
  // no-op.
  //
  // Note that the this function must be implemented in a way such that
  // it should not run for an extended period of time before the function
  // returns.  Otherwise, RocksDB may be blocked.
<<<<<<< HEAD
  virtual void OnFlushCompleted(
      DB* db, const FlushJobInfo& flush_job_info) {}
=======
  virtual void OnFlushCompleted(DB* /*db*/,
                                const FlushJobInfo& /*flush_job_info*/) {}
>>>>>>> forknote/master

  // A call-back function for RocksDB which will be called whenever
  // a SST file is deleted.  Different from OnCompactionCompleted and
  // OnFlushCompleted, this call-back is designed for external logging
  // service and thus only provide string parameters instead
  // of a pointer to DB.  Applications that build logic basic based
  // on file creations and deletions is suggested to implement
  // OnFlushCompleted and OnCompactionCompleted.
  //
  // Note that if applications would like to use the passed reference
  // outside this function call, they should make copies from the
  // returned value.
<<<<<<< HEAD
  virtual void OnTableFileDeleted(
      const TableFileDeletionInfo& info) {}
=======
  virtual void OnTableFileDeleted(const TableFileDeletionInfo& /*info*/) {}
>>>>>>> forknote/master

  // A call-back function for RocksDB which will be called whenever
  // a registered RocksDB compacts a file. The default implementation
  // is a no-op.
  //
  // Note that this function must be implemented in a way such that
  // it should not run for an extended period of time before the function
  // returns. Otherwise, RocksDB may be blocked.
  //
  // @param db a pointer to the rocksdb instance which just compacted
  //   a file.
  // @param ci a reference to a CompactionJobInfo struct. 'ci' is released
  //  after this function is returned, and must be copied if it is needed
  //  outside of this function.
<<<<<<< HEAD
  virtual void OnCompactionCompleted(DB *db, const CompactionJobInfo& ci) {}
=======
  virtual void OnCompactionCompleted(DB* /*db*/,
                                     const CompactionJobInfo& /*ci*/) {}
>>>>>>> forknote/master

  // A call-back function for RocksDB which will be called whenever
  // a SST file is created.  Different from OnCompactionCompleted and
  // OnFlushCompleted, this call-back is designed for external logging
  // service and thus only provide string parameters instead
  // of a pointer to DB.  Applications that build logic basic based
  // on file creations and deletions is suggested to implement
  // OnFlushCompleted and OnCompactionCompleted.
  //
<<<<<<< HEAD
  // Note that if applications would like to use the passed reference
  // outside this function call, they should make copies from these
  // returned value.
  virtual void OnTableFileCreated(
      const TableFileCreationInfo& info) {}
=======
  // Historically it will only be called if the file is successfully created.
  // Now it will also be called on failure case. User can check info.status
  // to see if it succeeded or not.
  //
  // Note that if applications would like to use the passed reference
  // outside this function call, they should make copies from these
  // returned value.
  virtual void OnTableFileCreated(const TableFileCreationInfo& /*info*/) {}

  // A call-back function for RocksDB which will be called before
  // a SST file is being created. It will follow by OnTableFileCreated after
  // the creation finishes.
  //
  // Note that if applications would like to use the passed reference
  // outside this function call, they should make copies from these
  // returned value.
  virtual void OnTableFileCreationStarted(
      const TableFileCreationBriefInfo& /*info*/) {}
 
  // A call-back function for RocksDB which will be called before
  // a memtable is made immutable.
  //
  // Note that the this function must be implemented in a way such that
  // it should not run for an extended period of time before the function
  // returns.  Otherwise, RocksDB may be blocked.
  //
  // Note that if applications would like to use the passed reference
  // outside this function call, they should make copies from these
  // returned value.
  virtual void OnMemTableSealed(
    const MemTableInfo& /*info*/) {}
>>>>>>> forknote/master

  virtual ~EventListener() {}
};

#else

class EventListener {
};

#endif  // ROCKSDB_LITE

}  // namespace rocksdb
