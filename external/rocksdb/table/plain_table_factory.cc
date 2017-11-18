// Copyright (c) 2011 The LevelDB Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file. See the AUTHORS file for names of contributors.

#ifndef ROCKSDB_LITE
#include "table/plain_table_factory.h"

#include <memory>
#include <stdint.h>
#include "db/dbformat.h"
#include "table/plain_table_builder.h"
#include "table/plain_table_reader.h"
#include "port/port.h"

namespace rocksdb {

Status PlainTableFactory::NewTableReader(
    const TableReaderOptions& table_reader_options,
    unique_ptr<RandomAccessFileReader>&& file, uint64_t file_size,
<<<<<<< HEAD
    unique_ptr<TableReader>* table) const {
  return PlainTableReader::Open(
      table_reader_options.ioptions, table_reader_options.env_options,
      table_reader_options.internal_comparator, std::move(file), file_size,
      table, bloom_bits_per_key_, hash_table_ratio_, index_sparseness_,
      huge_page_tlb_size_, full_scan_mode_);
}

TableBuilder* PlainTableFactory::NewTableBuilder(
    const TableBuilderOptions& table_builder_options,
=======
    unique_ptr<TableReader>* table,
    bool prefetch_index_and_filter_in_cache) const {
  return PlainTableReader::Open(
      table_reader_options.ioptions, table_reader_options.env_options,
      table_reader_options.internal_comparator, std::move(file), file_size,
      table, table_options_.bloom_bits_per_key, table_options_.hash_table_ratio,
      table_options_.index_sparseness, table_options_.huge_page_tlb_size,
      table_options_.full_scan_mode);
}

TableBuilder* PlainTableFactory::NewTableBuilder(
    const TableBuilderOptions& table_builder_options, uint32_t column_family_id,
>>>>>>> forknote/master
    WritableFileWriter* file) const {
  // Ignore the skip_filters flag. PlainTable format is optimized for small
  // in-memory dbs. The skip_filters optimization is not useful for plain
  // tables
  //
  return new PlainTableBuilder(
      table_builder_options.ioptions,
<<<<<<< HEAD
      table_builder_options.int_tbl_prop_collector_factories, file,
      user_key_len_, encoding_type_, index_sparseness_, bloom_bits_per_key_, 6,
      huge_page_tlb_size_, hash_table_ratio_, store_index_in_file_);
=======
      table_builder_options.int_tbl_prop_collector_factories, column_family_id,
      file, table_options_.user_key_len, table_options_.encoding_type,
      table_options_.index_sparseness, table_options_.bloom_bits_per_key,
      table_builder_options.column_family_name, 6,
      table_options_.huge_page_tlb_size, table_options_.hash_table_ratio,
      table_options_.store_index_in_file);
>>>>>>> forknote/master
}

std::string PlainTableFactory::GetPrintableTableOptions() const {
  std::string ret;
  ret.reserve(20000);
  const int kBufferSize = 200;
  char buffer[kBufferSize];

  snprintf(buffer, kBufferSize, "  user_key_len: %u\n",
<<<<<<< HEAD
           user_key_len_);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  bloom_bits_per_key: %d\n",
           bloom_bits_per_key_);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  hash_table_ratio: %lf\n",
           hash_table_ratio_);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  index_sparseness: %" ROCKSDB_PRIszt "\n",
           index_sparseness_);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  huge_page_tlb_size: %" ROCKSDB_PRIszt "\n",
           huge_page_tlb_size_);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  encoding_type: %d\n",
           encoding_type_);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  full_scan_mode: %d\n",
           full_scan_mode_);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  store_index_in_file: %d\n",
           store_index_in_file_);
=======
           table_options_.user_key_len);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  bloom_bits_per_key: %d\n",
           table_options_.bloom_bits_per_key);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  hash_table_ratio: %lf\n",
           table_options_.hash_table_ratio);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  index_sparseness: %" ROCKSDB_PRIszt "\n",
           table_options_.index_sparseness);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  huge_page_tlb_size: %" ROCKSDB_PRIszt "\n",
           table_options_.huge_page_tlb_size);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  encoding_type: %d\n",
           table_options_.encoding_type);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  full_scan_mode: %d\n",
           table_options_.full_scan_mode);
  ret.append(buffer);
  snprintf(buffer, kBufferSize, "  store_index_in_file: %d\n",
           table_options_.store_index_in_file);
>>>>>>> forknote/master
  ret.append(buffer);
  return ret;
}

<<<<<<< HEAD
=======
const PlainTableOptions& PlainTableFactory::table_options() const {
  return table_options_;
}

>>>>>>> forknote/master
extern TableFactory* NewPlainTableFactory(const PlainTableOptions& options) {
  return new PlainTableFactory(options);
}

const std::string PlainTablePropertyNames::kPrefixExtractorName =
    "rocksdb.prefix.extractor.name";

const std::string PlainTablePropertyNames::kEncodingType =
    "rocksdb.plain.table.encoding.type";

const std::string PlainTablePropertyNames::kBloomVersion =
    "rocksdb.plain.table.bloom.version";

const std::string PlainTablePropertyNames::kNumBloomBlocks =
    "rocksdb.plain.table.bloom.numblocks";

}  // namespace rocksdb
#endif  // ROCKSDB_LITE
