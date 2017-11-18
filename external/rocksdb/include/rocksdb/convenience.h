<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

#pragma once

<<<<<<< HEAD
#include <unordered_map>
#include <string>
=======
#include <string>
#include <unordered_map>
#include <vector>

#include "rocksdb/db.h"
>>>>>>> forknote/master
#include "rocksdb/options.h"
#include "rocksdb/table.h"

namespace rocksdb {

#ifndef ROCKSDB_LITE
// Take a map of option name and option value, apply them into the
// base_options, and return the new options as a result.
//
// If input_strings_escaped is set to true, then each escaped characters
<<<<<<< HEAD
// prefixed by '\' in the the values of the opts_map will be further
=======
// prefixed by '\' in the values of the opts_map will be further
>>>>>>> forknote/master
// converted back to the raw string before assigning to the associated
// options.
Status GetColumnFamilyOptionsFromMap(
    const ColumnFamilyOptions& base_options,
    const std::unordered_map<std::string, std::string>& opts_map,
    ColumnFamilyOptions* new_options, bool input_strings_escaped = false);

// Take a map of option name and option value, apply them into the
// base_options, and return the new options as a result.
//
// If input_strings_escaped is set to true, then each escaped characters
<<<<<<< HEAD
// prefixed by '\' in the the values of the opts_map will be further
=======
// prefixed by '\' in the values of the opts_map will be further
>>>>>>> forknote/master
// converted back to the raw string before assigning to the associated
// options.
Status GetDBOptionsFromMap(
    const DBOptions& base_options,
    const std::unordered_map<std::string, std::string>& opts_map,
    DBOptions* new_options, bool input_strings_escaped = false);

Status GetBlockBasedTableOptionsFromMap(
    const BlockBasedTableOptions& table_options,
    const std::unordered_map<std::string, std::string>& opts_map,
<<<<<<< HEAD
    BlockBasedTableOptions* new_table_options);
=======
    BlockBasedTableOptions* new_table_options,
    bool input_strings_escaped = false);

Status GetPlainTableOptionsFromMap(
    const PlainTableOptions& table_options,
    const std::unordered_map<std::string, std::string>& opts_map,
    PlainTableOptions* new_table_options,
    bool input_strings_escaped = false);
>>>>>>> forknote/master

// Take a string representation of option names and  values, apply them into the
// base_options, and return the new options as a result. The string has the
// following format:
//   "write_buffer_size=1024;max_write_buffer_number=2"
// Nested options config is also possible. For example, you can define
// BlockBasedTableOptions as part of the string for block-based table factory:
//   "write_buffer_size=1024;block_based_table_factory={block_size=4k};"
//   "max_write_buffer_num=2"
Status GetColumnFamilyOptionsFromString(
    const ColumnFamilyOptions& base_options,
    const std::string& opts_str,
    ColumnFamilyOptions* new_options);

Status GetDBOptionsFromString(
    const DBOptions& base_options,
    const std::string& opts_str,
    DBOptions* new_options);

Status GetStringFromDBOptions(std::string* opts_str,
                              const DBOptions& db_options,
                              const std::string& delimiter = ";  ");

Status GetStringFromColumnFamilyOptions(std::string* opts_str,
                                        const ColumnFamilyOptions& db_options,
                                        const std::string& delimiter = ";  ");

<<<<<<< HEAD
=======
Status GetStringFromCompressionType(std::string* compression_str,
                                    CompressionType compression_type);

>>>>>>> forknote/master
Status GetBlockBasedTableOptionsFromString(
    const BlockBasedTableOptions& table_options,
    const std::string& opts_str,
    BlockBasedTableOptions* new_table_options);

<<<<<<< HEAD
Status GetOptionsFromString(const Options& base_options,
                            const std::string& opts_str, Options* new_options);

/// Request stopping background work, if wait is true wait until it's done
void CancelAllBackgroundWork(DB* db, bool wait = false);
=======
Status GetPlainTableOptionsFromString(
    const PlainTableOptions& table_options,
    const std::string& opts_str,
    PlainTableOptions* new_table_options);

Status GetMemTableRepFactoryFromString(
    const std::string& opts_str,
    std::unique_ptr<MemTableRepFactory>* new_mem_factory);

Status GetOptionsFromString(const Options& base_options,
                            const std::string& opts_str, Options* new_options);

// Request stopping background work, if wait is true wait until it's done
void CancelAllBackgroundWork(DB* db, bool wait = false);

// Delete files which are entirely in the given range
// Could leave some keys in the range which are in files which are not
// entirely in the range.
// Snapshots before the delete might not see the data in the given range.
Status DeleteFilesInRange(DB* db, ColumnFamilyHandle* column_family,
                          const Slice* begin, const Slice* end);
>>>>>>> forknote/master
#endif  // ROCKSDB_LITE

}  // namespace rocksdb
