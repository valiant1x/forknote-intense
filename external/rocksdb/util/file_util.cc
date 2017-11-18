<<<<<<< HEAD
//  Copyright (c) 2013, Facebook, Inc.  All rights reserved.
=======
//  Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
//  This source code is licensed under the BSD-style license found in the
//  LICENSE file in the root directory of this source tree. An additional grant
//  of patent rights can be found in the PATENTS file in the same directory.
//
#include "util/file_util.h"

#include <string>
#include <algorithm>

<<<<<<< HEAD
#include "rocksdb/delete_scheduler.h"
#include "rocksdb/env.h"
#include "rocksdb/options.h"
#include "db/filename.h"
=======
#include "rocksdb/env.h"
#include "rocksdb/options.h"
#include "util/sst_file_manager_impl.h"
>>>>>>> forknote/master
#include "util/file_reader_writer.h"

namespace rocksdb {

// Utility function to copy a file up to a specified length
Status CopyFile(Env* env, const std::string& source,
                const std::string& destination, uint64_t size) {
  const EnvOptions soptions;
  Status s;
  unique_ptr<SequentialFileReader> src_reader;
  unique_ptr<WritableFileWriter> dest_writer;

  {
    unique_ptr<SequentialFile> srcfile;
  s = env->NewSequentialFile(source, &srcfile, soptions);
  unique_ptr<WritableFile> destfile;
  if (s.ok()) {
    s = env->NewWritableFile(destination, &destfile, soptions);
  } else {
    return s;
  }

  if (size == 0) {
    // default argument means copy everything
    if (s.ok()) {
      s = env->GetFileSize(source, &size);
    } else {
      return s;
    }
  }
  src_reader.reset(new SequentialFileReader(std::move(srcfile)));
  dest_writer.reset(new WritableFileWriter(std::move(destfile), soptions));
  }

  char buffer[4096];
  Slice slice;
  while (size > 0) {
<<<<<<< HEAD
    uint64_t bytes_to_read =
        std::min(static_cast<uint64_t>(sizeof(buffer)), size);
=======
    size_t bytes_to_read = std::min(sizeof(buffer), static_cast<size_t>(size));
>>>>>>> forknote/master
    if (s.ok()) {
      s = src_reader->Read(bytes_to_read, &slice, buffer);
    }
    if (s.ok()) {
      if (slice.size() == 0) {
        return Status::Corruption("file too small");
      }
      s = dest_writer->Append(slice);
    }
    if (!s.ok()) {
      return s;
    }
    size -= slice.size();
  }
  return Status::OK();
}

<<<<<<< HEAD
Status DeleteOrMoveToTrash(const DBOptions* db_options,
                           const std::string& fname) {
  if (db_options->delete_scheduler == nullptr) {
    return db_options->env->DeleteFile(fname);
  } else {
    return db_options->delete_scheduler->DeleteFile(fname);
=======
// Utility function to create a file with the provided contents
Status CreateFile(Env* env, const std::string& destination,
                  const std::string& contents) {
  const EnvOptions soptions;
  Status s;
  unique_ptr<WritableFileWriter> dest_writer;

  unique_ptr<WritableFile> destfile;
  s = env->NewWritableFile(destination, &destfile, soptions);
  if (!s.ok()) {
    return s;
  }
  dest_writer.reset(new WritableFileWriter(std::move(destfile), soptions));
  return dest_writer->Append(Slice(contents));
}

Status DeleteSSTFile(const DBOptions* db_options, const std::string& fname,
                     uint32_t path_id) {
  // TODO(tec): support sst_file_manager for multiple path_ids
  auto sfm =
      static_cast<SstFileManagerImpl*>(db_options->sst_file_manager.get());
  if (sfm && path_id == 0) {
    return sfm->ScheduleFileDeletion(fname);
  } else {
    return db_options->env->DeleteFile(fname);
>>>>>>> forknote/master
  }
}

}  // namespace rocksdb
