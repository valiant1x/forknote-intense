<<<<<<< HEAD
//  Copyright (c) 2013, Facebook, Inc.  All rights reserved.
=======
//  Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
//  This source code is licensed under the BSD-style license found in the
//  LICENSE file in the root directory of this source tree. An additional grant
//  of patent rights can be found in the PATENTS file in the same directory.

#pragma once

#include "rocksdb/status.h"
#include "rocksdb/iterator.h"

namespace rocksdb {

<<<<<<< HEAD
// Seek to the properties block.
// If it successfully seeks to the properties block, "is_found" will be
// set to true.
Status SeekToPropertiesBlock(Iterator* meta_iter, bool* is_found);
=======
class InternalIterator;

// Seek to the properties block.
// If it successfully seeks to the properties block, "is_found" will be
// set to true.
Status SeekToPropertiesBlock(InternalIterator* meta_iter, bool* is_found);

// Seek to the compression dictionary block.
// If it successfully seeks to the properties block, "is_found" will be
// set to true.
Status SeekToCompressionDictBlock(InternalIterator* meta_iter, bool* is_found);
>>>>>>> forknote/master

}  // namespace rocksdb
